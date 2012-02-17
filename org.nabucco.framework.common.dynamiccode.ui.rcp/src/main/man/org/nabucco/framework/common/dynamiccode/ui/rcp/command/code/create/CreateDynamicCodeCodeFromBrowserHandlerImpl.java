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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.create;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup.DynamicCodeCodeGroupEditViewBrowserElement;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;

/**
 * CreateDynamicCodeCodeFromBrowserHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class CreateDynamicCodeCodeFromBrowserHandlerImpl extends CreateDynamicCodeCodeHandlerImpl
        implements CreateDynamicCodeCodeFromBrowserHandler {

    @Override
    public void createDynamicCodeCodeFromBrowser() {
        super.run();
    }

    @Override
    protected void updateModel(DynamicCodeCodeEditViewModel viewModel) {
        super.updateModel(viewModel);

        this.updateParentGroup(viewModel);
    }

    /**
     * Update the parent group.
     * 
     * @param viewModel
     *            the view model
     */
    private void updateParentGroup(DynamicCodeCodeEditViewModel viewModel) {
        BrowserElement element = Activator.getDefault().getModel().getBrowserModel()
                .getFirstElement();

        if (element instanceof DynamicCodeCodeGroupEditViewBrowserElement) {
            DynamicCodeCodeGroup parentGroup = ((DynamicCodeCodeGroupEditViewBrowserElement) element)
                    .getViewModel().getCodeGroup();
            viewModel.setGroup(parentGroup);
        }
    }
}
