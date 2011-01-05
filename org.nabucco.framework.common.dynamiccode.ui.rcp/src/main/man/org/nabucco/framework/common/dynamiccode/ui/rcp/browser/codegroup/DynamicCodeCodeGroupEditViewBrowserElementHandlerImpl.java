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
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code.DynamicCodeCodeListViewBrowserElement;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.resolve.ResolveDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.plugin.base.Activator;

/**
 * DynamicCodeCodeGroupEditViewBrowserElementHandlerImpl
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class DynamicCodeCodeGroupEditViewBrowserElementHandlerImpl implements
        DynamicCodeCodeGroupEditViewBrowserElementHandler {

    @Override
    public DynamicCodeCodeGroupEditViewModel loadFull(DynamicCodeCodeGroupEditViewModel viewModel) {

        try {
            ResolveDynamicCodeDelegate resolveDynamicCodeService = DynamicCodeComponentServiceDelegateFactory
                    .getInstance().getResolveDynamicCode();

            // create request message
            DynamicCodeCodeGroupResolveRq rqMsg = new DynamicCodeCodeGroupResolveRq();
            rqMsg.setCodeGroup(viewModel.getCodeGroup());

            // send request to service
            DynamicCodeCodeGroupResolveRs rsMsg = resolveDynamicCodeService
                    .resolveDynamicCodeCodeGroup(rqMsg);

            // process request
            DynamicCodeCodeGroup codeGroup = rsMsg.getCodeGroup();
            DynamicCodeCodeGroup parentCodeGroup = rsMsg.getParentGroup();

            viewModel.setCodeGroup(codeGroup);
            viewModel.setParentGroup(parentCodeGroup);

        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }

        return viewModel;
    }

    @Override
    public void createChildren(DynamicCodeCodeGroupEditViewModel viewModel,
            DynamicCodeCodeGroupEditViewBrowserElement element) {
        DynamicCodeCodeGroup codeGroup = viewModel.getCodeGroup();
        if (!codeGroup.getCodeList().isEmpty()) {
            element.addBrowserElement(new DynamicCodeCodeListViewBrowserElement(codeGroup
                    .getCodeList()));
        }
        if (!codeGroup.getCodeGroupList().isEmpty()) {
            element.addBrowserElement(new DynamicCodeCodeGroupListViewBrowserElement(codeGroup
                    .getCodeGroupList()));
        }
    }
}
