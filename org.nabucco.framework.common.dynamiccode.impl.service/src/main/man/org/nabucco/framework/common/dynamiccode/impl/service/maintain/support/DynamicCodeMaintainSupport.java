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
package org.nabucco.framework.common.dynamiccode.impl.service.maintain.support;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.impl.service.common.cache.DynamicCodeCache;

/**
 * DynamicCodeMaintainSupport
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeMaintainSupport {

    private PersistenceManager manager;

    /**
     * Creates a new {@link DynamicCodeMaintainSupport} instance.
     * 
     * @param manager
     *            the persistence manager
     */
    public DynamicCodeMaintainSupport(PersistenceManager manager) {
        if (manager == null) {
            throw new IllegalArgumentException("Persistence Manager must be defined.");
        }
        this.manager = manager;
    }

    /**
     * Maintain a single {@link DynamicCodeGroup} instance.
     * 
     * @param group
     *            the group to maintain
     * 
     * @return the persistet group
     * 
     * @throws PersistenceException
     */
    public DynamicCodeCodeGroup maintainDynamicCodeCodeGroup(DynamicCodeCodeGroup group) throws PersistenceException {
        if (group == null) {
            throw new PersistenceException("Cannot maintain DynamicCode CodeGroup [null].");
        }

        if (group.getDatatypeState() == DatatypeState.DELETED) {

            DynamicCodeCodeGroup currentGroup = this.manager.find(group);

            for (DynamicCodeCodeGroup codeGroup : currentGroup.getCodeGroupList()) {
                codeGroup.setDatatypeState(DatatypeState.DELETED);
                this.maintainDynamicCodeCodeGroup(codeGroup);
            }

            for (DynamicCodeCode code : currentGroup.getCodeList()) {
                code.setDatatypeState(DatatypeState.DELETED);
                this.maintainDynamicCodeCode(code);
            }

        } else {

            if (this.isTraversable(group.getCodeGroupList())) {
                List<DynamicCodeCodeGroup> unassignedCodeGroups = NabuccoCollectionAccessor.getInstance()
                        .getUnassignedList(group.getCodeGroupList());

                for (DynamicCodeCodeGroup codeGroup : group.getCodeGroupList()) {
                    this.maintainDynamicCodeCodeGroup(codeGroup);
                }

                for (DynamicCodeCodeGroup codeGroup : unassignedCodeGroups) {
                    codeGroup.setDatatypeState(DatatypeState.DELETED);
                    this.maintainDynamicCodeCodeGroup(codeGroup);
                }
            }

            if (this.isTraversable(group.getCodeList())) {
                List<DynamicCodeCode> unassignedCodes = NabuccoCollectionAccessor.getInstance().getUnassignedList(
                        group.getCodeList());

                for (DynamicCodeCode code : group.getCodeList()) {
                    this.maintainDynamicCodeCode(code);
                }

                for (DynamicCodeCode code : unassignedCodes) {
                    code.setDatatypeState(DatatypeState.DELETED);
                    this.maintainDynamicCodeCode(code);
                }
            }
        }

        DynamicCodeCache.clear();
        group = this.manager.persist(group);

        if (group.getCodeGroupList().isTraversable()) {
            group.getCodeGroupList().size();
        }
        if (group.getCodeList().isTraversable()) {
            group.getCodeList().size();
        }

        return group;
    }

    /**
     * Maintain a list of {@link DynamicCodeCode} instances.
     * 
     * @param codeList
     *            the list of codes
     * 
     * @return the persistet codes
     * 
     * @throws PersistenceException
     *             when persisting fails
     */
    public List<DynamicCodeCode> maintainDynamicCodeCode(List<DynamicCodeCode> codeList) throws PersistenceException {
        for (DynamicCodeCode code : codeList) {
            this.maintainDynamicCodeCode(code);
        }
        return codeList;
    }

    /**
     * Maintain a single {@link DynamicCodeCode} instance.
     * 
     * @param code
     *            the code to maintain
     * 
     * @return the persistet code
     * 
     * @throws PersistenceException
     *             when persisting fails
     */
    public DynamicCodeCode maintainDynamicCodeCode(DynamicCodeCode code) throws PersistenceException {
        if (code == null) {
            throw new PersistenceException("Cannot maintain DynamicCode Code [null].");
        }

        DynamicCodeCache.clear();
        code = this.manager.persist(code);
        return code;
    }

    /**
     * Checks whether a list is traversable or not. Only {@link NabuccoList} that are not in state
     * LAZY are considered.
     * 
     * @param list
     *            the list to check
     * 
     * @return <b>true</b> if the list is traversable, <b>false</b> otherwise
     */
    private <T extends NabuccoDatatype> boolean isTraversable(List<T> list) {
        if (list == null) {
            return false;
        }
        if (!(list instanceof NabuccoList<?>)) {
            return true;
        }

        NabuccoList<T> nabuccoList = (NabuccoList<T>) list;
        if (nabuccoList.getState() != NabuccoCollectionState.LAZY) {
            return true;
        }
        return false;
    }

}
