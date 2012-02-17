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
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup;

import java.util.List;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.model.DynamicCodeCodeGroupListViewModel;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.framework.plugin.base.model.browser.BrowserListElement;

/**
 * DynamicCodeCodeGroupListViewBrowserElement
 *
 * @author Undefined
 */
public class DynamicCodeCodeGroupListViewBrowserElement extends BrowserListElement<DynamicCodeCodeGroupListViewModel>
        implements NabuccoInjectionReciever {

    private DynamicCodeCodeGroupListViewBrowserElementHandler listViewBrowserElementHandler;

    /**
     * Constructs a new DynamicCodeCodeGroupListViewBrowserElement instance.
     *
     * @param datatypeList the List<DynamicCodeCodeGroup>.
     */
    public DynamicCodeCodeGroupListViewBrowserElement(final List<DynamicCodeCodeGroup> datatypeList) {
        this(datatypeList.toArray(new DynamicCodeCodeGroup[datatypeList.size()]));
    }

    /**
     * Constructs a new DynamicCodeCodeGroupListViewBrowserElement instance.
     *
     * @param datatypeArray the DynamicCodeCodeGroup[].
     */
    public DynamicCodeCodeGroupListViewBrowserElement(final DynamicCodeCodeGroup[] datatypeArray) {
        super();
        NabuccoInjector instance = NabuccoInjector.getInstance(DynamicCodeCodeGroupListViewBrowserElement.class);
        listViewBrowserElementHandler = instance.inject(DynamicCodeCodeGroupListViewBrowserElementHandler.class);
        viewModel = new DynamicCodeCodeGroupListViewModel();
        viewModel.setElements(datatypeArray);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        listViewBrowserElementHandler.createChildren(viewModel, this);
    }

    @Override
    public void removeBrowserElement(final BrowserElement element) {
        super.removeBrowserElement(element);
        listViewBrowserElementHandler.removeChild(element, this);
    }
}
