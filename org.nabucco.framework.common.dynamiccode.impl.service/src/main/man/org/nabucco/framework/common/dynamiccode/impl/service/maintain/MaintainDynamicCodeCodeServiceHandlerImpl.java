/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
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
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.impl.service.maintain.support.DynamicCodeMaintainSupport;

/**
 * MaintainDynamicCodeCodeServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainDynamicCodeCodeServiceHandlerImpl extends
        MaintainDynamicCodeCodeServiceHandler {

    private static final long serialVersionUID = 1L;

    private DynamicCodeCode code;

    private DynamicCodeCodeGroup group;

    private PersistenceHelper helper;

    @Override
    public DynamicCodeCodeMaintainMsg maintainDynamicCodeCode(DynamicCodeCodeMaintainMsg msg)
            throws MaintainException {

        this.code = msg.getCode();
        this.group = msg.getParentGroup();

        this.helper = new PersistenceHelper(super.getEntityManager());

        this.maintain();

        DynamicCodeCodeMaintainMsg rsMsg = new DynamicCodeCodeMaintainMsg();
        rsMsg.setCode(this.code);
        rsMsg.setParentGroup(this.group);

        return rsMsg;
    }

    /**
     * Maintain the {@link DynamicCodeCode} instance.
     * 
     * @throws MaintainException
     *             when the persistence operation failed
     */
    private void maintain() throws MaintainException {
        try {
            this.maintainCode();

            if (this.group != null && this.code.getDatatypeState() != DatatypeState.DELETED) {
                this.maintainParentGroup();
            }

        } catch (PersistenceException pe) {
            throw new MaintainException("Error maintaining DynamicCodeCode.", pe);
        }
    }

    /**
     * Maintains the code.
     * 
     * @throws PersistenceException
     */
    private void maintainCode() throws PersistenceException {
        DynamicCodeMaintainSupport support = new DynamicCodeMaintainSupport(this.helper);
        this.code = support.maintainDynamicCodeCode(this.code);
    }

    /**
     * Maintains the parent group.
     * 
     * @throws PersistenceException
     *             when the parent group is not persistent
     */
    private void maintainParentGroup() throws PersistenceException {
        if (this.group.getId() == null) {
            throw new PersistenceException(
                    "Cannot modify non-persistent parent DynamicCodeCodeGroup.");
        }

        this.group = this.helper.find(DynamicCodeCodeGroup.class, this.group);
        this.group.getCodeList().add(this.code);
    }
}
