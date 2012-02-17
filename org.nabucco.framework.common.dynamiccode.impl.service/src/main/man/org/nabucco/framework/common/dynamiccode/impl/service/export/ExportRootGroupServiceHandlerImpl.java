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

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;

/**
 * ExportRootGroupServiceHandlerImpl
 * 
 * @author Silas Schwarz, PRODYNA AG
 */
public class ExportRootGroupServiceHandlerImpl extends ExportRootGroupServiceHandler {

    private static final NabuccoLogger LOGGER = NabuccoLoggingFactory.getInstance().getLogger(
            ExportRootGroupServiceHandlerImpl.class);

    private static final long serialVersionUID = 1L;

    private static final String QUERY = "from DynamicCodeCodeGroup rg where not exists ("
            + "select pg from DynamicCodeCodeGroup pg " + "inner join pg.codeGroupListJPA c " + "where (c.id = rg.id))";

    @Override
    protected DynamicCodeCodeGroupMsg exportRootGroup(EmptyServiceMessage msg) throws ExportException {
        DynamicCodeCodeGroupMsg result = new DynamicCodeCodeGroupMsg();

        try {
            List<DynamicCodeCodeGroup> rootGroups = getRootGroups();
            DynamicCodeCodeGroup codeGroup = rootGroups.get(0);
            codeGroup.accept(new DatatypeVisitor() {

                @Override
                public void visit(Datatype datatype) throws VisitorException {
                    if (datatype instanceof DynamicCodeCodeGroup) {
                        DynamicCodeCodeGroup dynamicCodeCodeGroup = (DynamicCodeCodeGroup) datatype;
                        dynamicCodeCodeGroup.getCodeGroupList().size();
                        dynamicCodeCodeGroup.getCodeList().size();
                    }
                    super.visit(datatype);
                }
            });
            if (rootGroups.isEmpty()) {
                throw new ExportException("unable to find dynamic code root group");
            } else if (rootGroups.size() > 1) {
                LOGGER.warning("more than one dynamic code root group was found, picking first (name is: "
                        + codeGroup.getName().getValue() + "), please check database content");
            }
            result.setCodeGroup(codeGroup);
        } catch (PersistenceException e) {
            throw new ExportException("unable to find root dynamic code group", e);
        } catch (VisitorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
