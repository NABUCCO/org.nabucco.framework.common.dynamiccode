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

import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.command.CommandHandler;

/**
 * DynamicCodeCodeEditViewBrowserElementHandler<p/>Leading datatype of the DynamicCodeCodeEditView<p/>
 *
 * @author Undefined
 */
public interface DynamicCodeCodeEditViewBrowserElementHandler extends CommandHandler {

    /**
     * LoadFull.
     *
     * @param dynamicCodeCode the DynamicCodeCodeEditViewModel.
     * @return the DynamicCodeCodeEditViewModel.
     */
    DynamicCodeCodeEditViewModel loadFull(final DynamicCodeCodeEditViewModel dynamicCodeCode);

    /**
     * CreateChildren.
     *
     * @param element the DynamicCodeCodeEditViewBrowserElement.
     * @param viewModel the DynamicCodeCodeEditViewModel.
     */
    void createChildren(final DynamicCodeCodeEditViewModel viewModel,
            final DynamicCodeCodeEditViewBrowserElement element);
}
