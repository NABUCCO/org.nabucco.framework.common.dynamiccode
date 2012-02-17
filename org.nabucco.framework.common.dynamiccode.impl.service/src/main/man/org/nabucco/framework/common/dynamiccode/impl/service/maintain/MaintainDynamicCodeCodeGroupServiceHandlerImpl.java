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
package org.nabucco.framework.common.dynamiccode.impl.service.maintain;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.impl.service.maintain.support.DynamicCodeMaintainSupport;

/**
 * MaintainDynamicCodeCodeGroupServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainDynamicCodeCodeGroupServiceHandlerImpl extends MaintainDynamicCodeCodeGroupServiceHandler {

    private static final long serialVersionUID = 1L;

    private DynamicCodeCodeGroup group;

    private DynamicCodeCodeGroup parentGroup;

    @Override
    public DynamicCodeCodeGroupMaintainMsg maintainDynamicCodeCodeGroup(DynamicCodeCodeGroupMaintainMsg msg)
            throws MaintainException {

        this.group = msg.getCodeGroup();
        this.parentGroup = msg.getParentGroup();

        this.maintain();

        DynamicCodeCodeGroupMaintainMsg rsMsg = new DynamicCodeCodeGroupMaintainMsg();
        rsMsg.setCodeGroup(this.group);
        rsMsg.setParentGroup(this.parentGroup);

        return rsMsg;
    }

    /**
     * Maintain the {@link DynamicCodeCodeGroup} instance.
     * 
     * @throws MaintainException
     *             when the persistence operation failed
     */
    private void maintain() throws MaintainException {
        if (this.group.equals(this.parentGroup)) {
            throw new MaintainException(
                    "Error maintaining DynamicCodeCodeGroup. Parent DynamicCodeCodeGroup must not reference on itsself.");
        }

        try {
            this.maintainGroup();

            if (this.parentGroup != null && this.group.getDatatypeState() != DatatypeState.DELETED) {
                this.maintainParentGroup();
            }

        } catch (PersistenceException pe) {
            throw new MaintainException("Error maintaining DynamicCodeCodeGroup.", pe);
        }
    }

    /**
     * Maintains the group.
     * 
     * @throws PersistenceException
     */
    private void maintainGroup() throws PersistenceException {
        DynamicCodeMaintainSupport support = new DynamicCodeMaintainSupport(super.getPersistenceManager());
        this.group = support.maintainDynamicCodeCodeGroup(this.group);
    }

    /**
     * Maintains the parent group.
     * 
     * @throws PersistenceException
     *             when the parent group is not persistent
     */
    private void maintainParentGroup() throws PersistenceException {
        if (this.parentGroup.getId() == null) {
            throw new PersistenceException("Cannot modify non-persistent parent DynamicCodeCodeGroup.");
        }

        this.parentGroup = super.getPersistenceManager().find(this.parentGroup);
        this.parentGroup.getCodeGroupList().add(this.group);
    }

}
