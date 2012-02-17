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
package org.nabucco.framework.common.dynamiccode.impl.service.importing;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.importing.ImportContainer;
import org.nabucco.framework.base.facade.datatype.importing.ImportContext;
import org.nabucco.framework.base.facade.datatype.importing.ImportContextEntry;
import org.nabucco.framework.base.facade.datatype.serialization.DeserializationData;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationException;
import org.nabucco.framework.base.facade.datatype.serialization.xml.XmlSerializer;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ImportException;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.impl.service.common.cache.DynamicCodeCache;

/**
 * ImportDynamicCodeServiceHandlerImpl
 * 
 * @author Silas Schwarz, PRODYNA AG
 */
public class ImportDynamicCodeServiceHandlerImpl extends ImportDynamicCodeServiceHandler implements ServiceHandler {

    private static final MessageFormat LOOKUP_QUERY = new MessageFormat("select t from {0} t where t.name = :name");

    private static final String[] QUERY_PARAMETER = { "name" };

    private static final int PARAM_NAME = 0;

    private static final long serialVersionUID = 1L;

    @Override
    protected ImportRs importDynamicCode(ImportRq msg) throws ImportException {

        ImportRs result = new ImportRs();
        ImportContext importContext = msg.getImportContext();
        ImportContainer container = msg.getContainer();
        result.setImportContext(importContext);

        try {
            XmlSerializer xmlSerializer = new XmlSerializer();

            DeserializationData data = new DeserializationData(container.getContent().getValue());
            data.setResourceData(container.getResourceData().getValue());
            List<Datatype> deserialized = xmlSerializer.deserialize(data);

            List<ImportContextEntry> entries = handleImport(deserialized);
            result.getImportContext().getEntries().addAll(entries);

        } catch (SerializationException e) {
            throw new ImportException("Import of DynamicCode failed.", e);
        }

        DynamicCodeCache.clear();

        return result;
    }

    private List<ImportContextEntry> handleImport(List<Datatype> deserialized) throws ImportException {
        List<ImportContextEntry> importedElements = new ArrayList<ImportContextEntry>();
        for (Datatype current : deserialized) {
            if (current instanceof DynamicCodeCodeGroup || current instanceof DynamicCodeCode) {
                importedElements.add(maintain((NabuccoDatatype) current));
            }
        }
        return importedElements;
    }

    private ImportContextEntry maintain(NabuccoDatatype type) throws ImportException {

        try {
            NabuccoDatatype lookUp = findExisting(type);

            ImportContextEntry result = new ImportContextEntry();
            result.setOldId(type.getId());
            result.setTypeName(type.getClass().getName());

            if (lookUp == null) {
                type.setDatatypeState(DatatypeState.INITIALIZED);
                type.setId((Long) null);
                type = super.getPersistenceManager().persist(type);
            } else {
                type = lookUp;
            }

            result.setNewId(type.getId());
            return result;

        } catch (PersistenceException e) {
            throw new ImportException("Unable to import DynamicCodeCodeGroup", e);
        }
    }

    private NabuccoDatatype findExisting(NabuccoDatatype type) throws PersistenceException {

        NabuccoQuery<NabuccoDatatype> lookUp = super.getPersistenceManager().createQuery(
                LOOKUP_QUERY.format(new Object[] { type.getClass().getSimpleName() }));

        if (type instanceof DynamicCodeCodeGroup) {
            lookUp.setParameter(QUERY_PARAMETER[PARAM_NAME], ((DynamicCodeCodeGroup) type).getName());
        } else if (type instanceof DynamicCodeCode) {
            lookUp.setParameter(QUERY_PARAMETER[PARAM_NAME], ((DynamicCodeCode) type).getName());
        }

        List<NabuccoDatatype> resultList = lookUp.getResultList();

        if (resultList.isEmpty() || resultList.size() != 1) {
            return null;
        }
        return resultList.get(0);
    }
}
