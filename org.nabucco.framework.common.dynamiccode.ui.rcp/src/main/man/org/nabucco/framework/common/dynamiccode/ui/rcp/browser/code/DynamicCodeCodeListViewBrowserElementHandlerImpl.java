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

import java.util.List;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.model.DynamicCodeCodeListViewModel;
import org.nabucco.framework.plugin.base.model.browser.AbstractBrowserListViewHandlerImpl;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;

/**
 * DynamicCodeCodeListViewBrowserElementHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCodeListViewBrowserElementHandlerImpl
        extends
        AbstractBrowserListViewHandlerImpl<DynamicCodeCode, DynamicCodeCodeListViewModel, DynamicCodeCodeListViewBrowserElement, DynamicCodeCodeEditViewBrowserElement>
        implements DynamicCodeCodeListViewBrowserElementHandler {

    @Override
    public void createChildren(DynamicCodeCodeListViewModel viewModel,
            DynamicCodeCodeListViewBrowserElement element) {

        for (DynamicCodeCode code : viewModel.getElements()) {
            element.addBrowserElement(new DynamicCodeCodeEditViewBrowserElement(code));
        }
    }

    @Override
    public void removeChild(BrowserElement toBeRemoved,
            DynamicCodeCodeListViewBrowserElement element) {
        super.removeChildren((DynamicCodeCodeEditViewBrowserElement) toBeRemoved, element);
    }

    @Override
    public boolean haveSameId(DynamicCodeCode codeGroup,
            DynamicCodeCodeEditViewBrowserElement dynamicCodeCodeEditViewBrowserElement) {

        boolean result = false;
        result = codeGroup.getId().equals(
                dynamicCodeCodeEditViewBrowserElement.getViewModel().getCode().getId());
        return result;
    }

    @Override
    public void updateViewModel(List<DynamicCodeCode> elements,
            DynamicCodeCodeListViewModel viewModel) {

        viewModel.setElements(elements.toArray(new DynamicCodeCode[0]));

    }

}
