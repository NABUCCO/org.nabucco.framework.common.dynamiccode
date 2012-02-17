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
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.maintain.MaintainDynamicCodeDelegate;
import org.nabucco.framework.plugin.base.model.BusinessModel;

/**
 * DynamicCodeCodeGroupEditBusinessModel
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class DynamicCodeCodeGroupEditBusinessModel implements BusinessModel {

    public static String ID = "org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditBusinessModel";

    /**
     * Save a codeGroup.
     * 
     * @param codeGroup
     *            should be saved
     * @param the
     *            parent code group
     * 
     * @throws ClientException
     *             when the save operation did not finish successful
     */
    public DynamicCodeCodeGroupMaintainMsg save(final DynamicCodeCodeGroup codeGroup,
            final DynamicCodeCodeGroup parentCodeGroup) throws ClientException {

        MaintainDynamicCodeDelegate maintainDelegate = DynamicCodeComponentServiceDelegateFactory
                .getInstance().getMaintainDynamicCode();

        DynamicCodeCodeGroupMaintainMsg message = createDynamicCodeCodeGroupMaintainMsg(codeGroup,
                parentCodeGroup);

        return maintainDelegate.maintainDynamicCodeCodeGroup(message);
    }

    /**
     * Create the maintain message
     * 
     * @param codeGroup
     *            the codeGroup
     * @param parentGroup
     *            the parent codeGroup
     * 
     * @return the maintain message
     */
    private DynamicCodeCodeGroupMaintainMsg createDynamicCodeCodeGroupMaintainMsg(
            final DynamicCodeCodeGroup codeGroup, final DynamicCodeCodeGroup parentGroup) {
        DynamicCodeCodeGroupMaintainMsg message = new DynamicCodeCodeGroupMaintainMsg();
        message.setCodeGroup(codeGroup);
        message.setParentGroup(parentGroup);
        return message;
    }
}
