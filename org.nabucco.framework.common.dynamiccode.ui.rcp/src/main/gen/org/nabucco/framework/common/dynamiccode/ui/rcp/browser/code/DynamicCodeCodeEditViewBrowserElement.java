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

import java.io.Serializable;
import java.util.Map;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.model.browser.DatatypeBrowserElement;

/**
 * DynamicCodeCodeEditViewBrowserElement<p/>Leading datatype of the DynamicCodeCodeEditView<p/>
 *
 * @author Undefined
 */
public class DynamicCodeCodeEditViewBrowserElement extends DatatypeBrowserElement implements NabuccoInjectionReciever {

    private DynamicCodeCodeEditViewModel viewModel;

    private DynamicCodeCodeEditViewBrowserElementHandler browserHandler;

    /**
     * Constructs a new DynamicCodeCodeEditViewBrowserElement instance.
     *
     * @param datatype the DynamicCodeCode.
     */
    public DynamicCodeCodeEditViewBrowserElement(final DynamicCodeCode datatype) {
        super();
        NabuccoInjector instance = NabuccoInjector.getInstance(DynamicCodeCodeEditViewBrowserElement.class);
        browserHandler = instance.inject(DynamicCodeCodeEditViewBrowserElementHandler.class);
        viewModel = new DynamicCodeCodeEditViewModel();
        viewModel.setCode(datatype);
    }

    @Override
    protected void fillDatatype() {
        viewModel = browserHandler.loadFull(viewModel);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        browserHandler.createChildren(viewModel, this);
    }

    @Override
    public Map<String, Serializable> getValues() {
        return this.viewModel.getValues();
    }

    /**
     * Getter for the ViewModel.
     *
     * @return the DynamicCodeCodeEditViewModel.
     */
    public DynamicCodeCodeEditViewModel getViewModel() {
        return this.viewModel;
    }

    /**
     * Setter for the ViewModel.
     *
     * @param viewModel the DynamicCodeCodeEditViewModel.
     */
    public void setViewModel(DynamicCodeCodeEditViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
