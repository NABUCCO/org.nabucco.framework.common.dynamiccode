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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.open;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup.DynamicCodeCodeGroupEditViewBrowserElement;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.resolve.ResolveDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.view.DynamicCodeCodeGroupEditView;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.AbstractNabuccoOpenEditViewHandlerImpl;

/**
 * OpenDynamicCodeCodeGroupEditViewFromBrowserHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class OpenDynamicCodeCodeGroupEditViewFromBrowserHandlerImpl
        extends
        AbstractNabuccoOpenEditViewHandlerImpl<DynamicCodeCodeGroupEditViewBrowserElement, DynamicCodeCodeGroupEditViewModel>
        implements OpenDynamicCodeCodeGroupEditViewFromBrowserHandler {

    @Override
    public void openDynamicCodeCodeGroupEditViewFromBrowser() {
        run();
    }

    @Override
    protected String getEditViewId() {
        return DynamicCodeCodeGroupEditView.ID;
    }

    @Override
    protected void updateModel(DynamicCodeCodeGroupEditViewBrowserElement browserElement,
            DynamicCodeCodeGroupEditViewModel model) {

        loadFull(browserElement.getViewModel());

        model.setCodeGroup(browserElement.getViewModel().getCodeGroup());
        model.setParentGroup(browserElement.getViewModel().getParentGroup());
    }

    private void loadFull(DynamicCodeCodeGroupEditViewModel viewModel) {

        try {
            ResolveDynamicCodeDelegate resolveService = DynamicCodeComponentServiceDelegateFactory
                    .getInstance().getResolveDynamicCode();

            DynamicCodeCodeGroupResolveRq rq = new DynamicCodeCodeGroupResolveRq();
            DynamicCodeCodeGroup codeGroupToResolve = viewModel.getCodeGroup();
            rq.setCodeGroup(codeGroupToResolve);

            // send request to service
            DynamicCodeCodeGroupResolveRs rs = resolveService.resolveDynamicCodeCodeGroup(rq);

            DynamicCodeCodeGroup codeGroup = rs.getCodeGroup();
            DynamicCodeCodeGroup parentCodeGroup = rs.getParentGroup();
            viewModel.setCodeGroup(codeGroup);
            viewModel.setParentGroup(parentCodeGroup);

        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }
    }

}
