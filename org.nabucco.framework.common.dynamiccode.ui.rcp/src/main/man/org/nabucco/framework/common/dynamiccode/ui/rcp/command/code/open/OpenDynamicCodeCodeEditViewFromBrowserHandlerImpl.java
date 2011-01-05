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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.open;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code.DynamicCodeCodeEditViewBrowserElement;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.resolve.ResolveDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view.DynamicCodeCodeEditView;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.AbstractNabuccoOpenEditViewHandlerImpl;

/**
 * Implements handler of openening edit view.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class OpenDynamicCodeCodeEditViewFromBrowserHandlerImpl
        extends
        AbstractNabuccoOpenEditViewHandlerImpl<DynamicCodeCodeEditViewBrowserElement, DynamicCodeCodeEditViewModel>
        implements OpenDynamicCodeCodeEditViewFromBrowserHandler {

    @Override
    public void openDynamicCodeCodeEditViewFromBrowser() {
        run();
    }

    @Override
    protected String getEditViewId() {
        return DynamicCodeCodeEditView.ID;
    }

    @Override
    protected void updateModel(DynamicCodeCodeEditViewBrowserElement browserElement,
            DynamicCodeCodeEditViewModel model) {

        loadFull(browserElement.getViewModel());

        model.setCode(browserElement.getViewModel().getCode());
        model.setGroup(browserElement.getViewModel().getGroup());
    }

    private void loadFull(DynamicCodeCodeEditViewModel viewModel) {
        try {

            ResolveDynamicCodeDelegate resolveDynamicCodeService = DynamicCodeComponentServiceDelegateFactory
                    .getInstance().getResolveDynamicCode();

            DynamicCodeCodeResolveRq rq = new DynamicCodeCodeResolveRq();
            DynamicCodeCode codeToResolve = viewModel.getCode();
            rq.setCode(codeToResolve);

            DynamicCodeCodeResolveRs rs = resolveDynamicCodeService.resolveDynamicCodeCode(rq);

            DynamicCodeCode resolvedCode = rs.getCode();
            DynamicCodeCodeGroup parentCodeGroup = rs.getParentGroup();
            viewModel.setCode(resolvedCode);
            viewModel.setGroup(parentCodeGroup);

        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }
    }

}
