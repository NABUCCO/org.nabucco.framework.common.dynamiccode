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
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.maintain.MaintainDynamicCodeDelegate;
import org.nabucco.framework.plugin.base.model.BusinessModel;

/**
 * DynamicCodeCodeEditBusinessModel
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class DynamicCodeCodeEditBusinessModel implements BusinessModel {

    public static String ID = "org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditBusinessModel";

    /**
     * Save a code.
     * 
     * @param code
     *            should be saved
     * @param parentGroup
     *            the containing codegroup
     * 
     * @throws ClientException
     *             when the save did not finish successful
     */
    public DynamicCodeCodeMaintainMsg save(DynamicCodeCode code, DynamicCodeCodeGroup parentGroup)
            throws ClientException {

        MaintainDynamicCodeDelegate maintainDelegate = DynamicCodeComponentServiceDelegateFactory
                .getInstance().getMaintainDynamicCode();

        DynamicCodeCodeMaintainMsg message = createDynamicCodeCodeMsg(code, parentGroup);
        return maintainDelegate.maintainDynamicCodeCode(message);
    }

    /**
     * Create the maintain message.
     * 
     * @param code
     *            the current code
     * @param parentGroup
     *            the parent codegroup
     * 
     * @return the message
     */
    private DynamicCodeCodeMaintainMsg createDynamicCodeCodeMsg(final DynamicCodeCode code,
            DynamicCodeCodeGroup parentGroup) {
        DynamicCodeCodeMaintainMsg message = new DynamicCodeCodeMaintainMsg();
        message.setCode(code);
        message.setParentGroup(parentGroup);
        return message;
    }
}
