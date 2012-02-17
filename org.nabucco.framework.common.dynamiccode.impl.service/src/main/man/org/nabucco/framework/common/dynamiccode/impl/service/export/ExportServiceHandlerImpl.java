/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.export;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.Data;
import org.nabucco.framework.base.facade.datatype.exporting.ExportContainer;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationException;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationResult;
import org.nabucco.framework.base.facade.datatype.serialization.xml.XmlSerializer;
import org.nabucco.framework.base.facade.datatype.text.TextContent;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * ExportServiceHandlerImpl
 * 
 * @author Silas Schwarz, PRODYNA AG
 */
public class ExportServiceHandlerImpl extends ExportServiceHandler implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String QUERY = "from DynamicCodeCodeGroup rg where not exists ("
            + "select pg from DynamicCodeCodeGroup pg " + "inner join pg.codeGroupListJPA c " + "where (c.id = rg.id))";

    @Override
    protected ExportRs export(EmptyServiceMessage msg) throws ExportException {

        ExportRs result = new ExportRs();

        XmlSerializer xmlSerializer = new XmlSerializer();
        ExportContainer container = new ExportContainer();

        try {
            List<DynamicCodeCodeGroup> rootGroups = this.getRootGroups();

            SerializationResult serializationResult = xmlSerializer.serialize(rootGroups, XmlSerializer.DEFAULT_INDENT,
                    true);

            container.setResult(new TextContent(serializationResult.getContent()));

            Data data = new Data(serializationResult.getResourceContainer().toByteArray());

            container.setResourceData(data);

        } catch (PersistenceException pe) {
            throw new ExportException("Unable to load DynamicCodeGroup for export.", pe);
        } catch (SerializationException se) {
            throw new ExportException("Unable to serialize DynamicCodeGroup for export.", se);
        }

        result.setContainer(container);
        return result;
    }

    private List<DynamicCodeCodeGroup> getRootGroups() throws PersistenceException {
        NabuccoQuery<DynamicCodeCodeGroup> query = this.getPersistenceManager().createQuery(QUERY);
        List<DynamicCodeCodeGroup> resultList = query.getResultList();
        return this.resolve(resultList);
    }

    private List<DynamicCodeCodeGroup> resolve(List<DynamicCodeCodeGroup> groupList) {
        for (DynamicCodeCodeGroup current : groupList) {
            this.resolve(current.getCodeGroupList());
        }
        return groupList;
    }

}
