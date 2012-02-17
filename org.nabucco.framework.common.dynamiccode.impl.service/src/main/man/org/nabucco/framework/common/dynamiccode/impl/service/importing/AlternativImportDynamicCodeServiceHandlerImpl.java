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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Name;
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
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.impl.service.common.cache.DynamicCodeCache;

/**
 * AlternativImportDynamicCodeServiceHandlerImpl
 * 
 * @author Silas Schwarz, PRODYNA AG
 */
public class AlternativImportDynamicCodeServiceHandlerImpl extends ImportDynamicCodeServiceHandler {

    private static final String NABUCCO = "nabucco";

    private static final String QUERY = "from DynamicCodeCodeGroup rg where not exists ("
            + "select pg from DynamicCodeCodeGroup pg " + "inner join pg.codeGroupListJPA c " + "where (c.id = rg.id))";

    private static final long serialVersionUID = 1L;

    private XmlSerializer xmlSerializer;

    @Override
    protected ImportRs importDynamicCode(ImportRq msg) throws ImportException {
        ImportRs response = new ImportRs();

        xmlSerializer = new XmlSerializer();

        DynamicCodeCodeGroup currentRootGroup = findRoot();
        DynamicCodeCodeGroup importRootGroup = findRoot(msg);

        ImportContext importContext = msg.getImportContext();

        merge(importContext.getEntries(), currentRootGroup, importRootGroup);

        response.setImportContext(importContext);

        DynamicCodeCache.clear();

        return response;
    }

    private DynamicCodeCodeGroup findRoot(ImportRq msg) throws ImportException {
        ImportContainer container = msg.getContainer();
        DeserializationData deserializationData = new DeserializationData(container.getContent().getValue());
        deserializationData.setResourceData(container.getResourceData().getValue());

        try {
            List<Datatype> deserialized = xmlSerializer.deserialize(deserializationData);
            for (Datatype d : deserialized) {
                if (d instanceof DynamicCodeCodeGroup) {
                    DynamicCodeCodeGroup nabuccoRootCandidate = (DynamicCodeCodeGroup) d;
                    if (nabuccoRootCandidate.getName() != null
                            && nabuccoRootCandidate.getName().getValue().compareTo(NABUCCO) == 0) {
                        return nabuccoRootCandidate;
                    }
                }
            }
        } catch (SerializationException e) {
            throw new ImportException("unable to deserialize from container", e);
        }
        throw new ImportException("unable to find root nabucco element in import data");
    }

    private DynamicCodeCodeGroup findRoot() throws ImportException {
        try {
            NabuccoQuery<Datatype> query = super.getPersistenceManager().createQuery(QUERY);

            List<Datatype> resultList = query.getResultList();
            for (Datatype d : resultList) {
                if (d instanceof DynamicCodeCodeGroup) {
                    DynamicCodeCodeGroup rootCandidate = (DynamicCodeCodeGroup) d;
                    if (rootCandidate.getName().getValue().compareTo(NABUCCO) == 0) {
                        return rootCandidate;
                    }
                }
            }
        } catch (PersistenceException pe) {
            throw new ImportException("Unable to locate root code 'nabucco' in database.", pe);
        }

        throw new ImportException("Unable to locate root code 'nabucco' in database.");

    }

    private void merge(List<ImportContextEntry> entries, DynamicCodeCodeGroup leftRoot, DynamicCodeCodeGroup rightRoot)
            throws ImportException {

        for (DynamicCodeCode currentRight : rightRoot.getCodeList()) {
            if (!isContained(leftRoot.getCodeList(), currentRight)) {
                leftRoot.getCodeList().add(add(entries, leftRoot, currentRight));
            } else {
                update(entries, leftRoot, currentRight);
            }
        }

        for (DynamicCodeCodeGroup currentRight : rightRoot.getCodeGroupList()) {
            if (!isContained(leftRoot.getCodeGroupList(), currentRight)) {
                leftRoot.getCodeGroupList().add(add(entries, leftRoot, currentRight));
            } else {
                update(entries, leftRoot, currentRight);
            }
        }

        try {
            super.getPersistenceManager().persist(leftRoot);
        } catch (PersistenceException e) {
            throw new ImportException("unable to update root element", e);
        }

    }

    private DynamicCodeCodeGroup add(List<ImportContextEntry> entries, DynamicCodeCodeGroup reciever,
            DynamicCodeCodeGroup groupToAdd) throws ImportException {

        List<DynamicCodeCodeGroup> peristentChildGroups = new ArrayList<DynamicCodeCodeGroup>();
        for (DynamicCodeCodeGroup currentChild : groupToAdd.getCodeGroupList()) {
            peristentChildGroups.add(add(entries, groupToAdd, currentChild));
        }

        List<DynamicCodeCode> peristentChildCodes = new ArrayList<DynamicCodeCode>();
        for (DynamicCodeCode currentChild : groupToAdd.getCodeList()) {
            peristentChildCodes.add(add(entries, groupToAdd, currentChild));
        }

        groupToAdd.getCodeList().clear();
        groupToAdd.getCodeList().addAll(peristentChildCodes);

        groupToAdd.getCodeGroupList().clear();
        groupToAdd.getCodeGroupList().addAll(peristentChildGroups);

        ImportContextEntry result = new ImportContextEntry();

        result.setOldId(groupToAdd.getId());
        result.setTypeName(groupToAdd.getClass().getName());

        groupToAdd.setDatatypeState(DatatypeState.INITIALIZED);
        groupToAdd.setId((Long) null);

        try {
            groupToAdd = super.getPersistenceManager().persist(groupToAdd);
        } catch (PersistenceException e) {
            throw new ImportException("unable to add new DynamicCodeCodeGroup", e);
        }

        result.setNewId(groupToAdd.getId());

        entries.add(result);

        return groupToAdd;
    }

    private DynamicCodeCode add(List<ImportContextEntry> entries, DynamicCodeCodeGroup reciever,
            DynamicCodeCode codeToAdd) throws ImportException {
        ImportContextEntry result = new ImportContextEntry();

        result.setOldId(codeToAdd.getId());
        result.setTypeName(codeToAdd.getClass().getName());

        codeToAdd.setDatatypeState(DatatypeState.INITIALIZED);
        codeToAdd.setId((Long) null);

        try {
            codeToAdd = super.getPersistenceManager().persist(codeToAdd);
        } catch (PersistenceException e) {
            throw new ImportException("unable to add new DynamicCodeCode", e);
        }

        result.setNewId(codeToAdd.getId());

        entries.add(result);
        return codeToAdd;
    }

    private void update(List<ImportContextEntry> entries, DynamicCodeCodeGroup reciever,
            DynamicCodeCodeGroup groupToUpdate) throws ImportException {
        ImportContextEntry result = new ImportContextEntry();

        DynamicCodeCodeGroup found = find(reciever.getCodeGroupList(), groupToUpdate);
        merge(entries, found, groupToUpdate);

        result.setOldId(groupToUpdate.getId());
        result.setNewId(found.getId());
        result.setTypeName(found.getClass().getName());

        entries.add(result);
    }

    private void update(List<ImportContextEntry> entries, DynamicCodeCodeGroup reciever, DynamicCodeCode codeToUpdate)
            throws ImportException {
        ImportContextEntry result = new ImportContextEntry();

        DynamicCodeCode found = find(reciever.getCodeList(), codeToUpdate);

        result.setOldId(codeToUpdate.getId());
        result.setNewId(found.getId());
        result.setTypeName(found.getClass().getName());

        entries.add(result);
    }

    private static boolean isContained(Collection<DynamicCodeCodeGroup> set, DynamicCodeCodeGroup element) {
        return (find(set, element) != null);
    }

    private static boolean isContained(Collection<DynamicCodeCode> set, DynamicCodeCode element) {
        return (find(set, element) != null);
    }

    private static DynamicCodeCodeGroup find(Collection<DynamicCodeCodeGroup> collection, DynamicCodeCodeGroup prototype) {
        Name elementName = prototype.getName();
        for (DynamicCodeCodeGroup current : collection) {
            Name collectionName = current.getName();
            if (collectionName.getValue().compareTo(elementName.getValue()) == 0) {
                return current;
            }
        }
        return null;
    }

    private static DynamicCodeCode find(Collection<DynamicCodeCode> collection, DynamicCodeCode prototype) {
        Name elementName = prototype.getName();
        for (DynamicCodeCode current : collection) {
            Name collectionName = current.getName();
            if (collectionName.getValue().compareTo(elementName.getValue()) == 0) {
                return current;
            }
        }
        return null;
    }
}
