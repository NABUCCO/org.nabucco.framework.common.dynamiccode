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
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.resolve.ResolveDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.Activator;

/**
 * DynamicCodeCodeEditViewBrowserElementHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCodeEditViewBrowserElementHandlerImpl implements
        DynamicCodeCodeEditViewBrowserElementHandler {

    @Override
    public DynamicCodeCodeEditViewModel loadFull(DynamicCodeCodeEditViewModel viewModel) {

        try {
            ResolveDynamicCodeDelegate resolveDynamicCodeService = DynamicCodeComponentServiceDelegateFactory
                    .getInstance().getResolveDynamicCode();

            DynamicCodeCodeResolveRq rqMsg = new DynamicCodeCodeResolveRq();
            rqMsg.setCode(viewModel.getCode());

            DynamicCodeCodeResolveRs rsMsg = resolveDynamicCodeService
                    .resolveDynamicCodeCode(rqMsg);
            DynamicCodeCode code = rsMsg.getCode();

            DynamicCodeCodeGroup codeGroup = rsMsg.getParentGroup();

            viewModel.setCode(code);
            viewModel.setGroup(codeGroup);

        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }

        return viewModel;
    }

    @Override
    public void createChildren(DynamicCodeCodeEditViewModel viewModel,
            DynamicCodeCodeEditViewBrowserElement element) {
        // DynamicCodeCodes do not have any children.
    }
}
