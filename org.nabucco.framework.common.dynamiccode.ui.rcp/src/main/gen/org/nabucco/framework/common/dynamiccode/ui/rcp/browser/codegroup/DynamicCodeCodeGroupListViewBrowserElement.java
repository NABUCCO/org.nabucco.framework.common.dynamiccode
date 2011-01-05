/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
public class DynamicCodeCodeGroupListViewBrowserElement extends
        BrowserListElement<DynamicCodeCodeGroupListViewModel> implements NabuccoInjectionReciever {

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
        NabuccoInjector instance = NabuccoInjector
                .getInstance(DynamicCodeCodeGroupListViewBrowserElement.class);
        listViewBrowserElementHandler = instance
                .inject(DynamicCodeCodeGroupListViewBrowserElementHandler.class);
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
