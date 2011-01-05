/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code;

import java.util.List;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.model.DynamicCodeCodeListViewModel;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.framework.plugin.base.model.browser.BrowserListElement;

/**
 * DynamicCodeCodeListViewBrowserElement
 *
 * @author Undefined
 */
public class DynamicCodeCodeListViewBrowserElement extends
        BrowserListElement<DynamicCodeCodeListViewModel> implements NabuccoInjectionReciever {

    private DynamicCodeCodeListViewBrowserElementHandler listViewBrowserElementHandler;

    /**
     * Constructs a new DynamicCodeCodeListViewBrowserElement instance.
     *
     * @param datatypeList the List<DynamicCodeCode>.
     */
    public DynamicCodeCodeListViewBrowserElement(final List<DynamicCodeCode> datatypeList) {
        this(datatypeList.toArray(new DynamicCodeCode[datatypeList.size()]));
    }

    /**
     * Constructs a new DynamicCodeCodeListViewBrowserElement instance.
     *
     * @param datatypeArray the DynamicCodeCode[].
     */
    public DynamicCodeCodeListViewBrowserElement(final DynamicCodeCode[] datatypeArray) {
        super();
        NabuccoInjector instance = NabuccoInjector
                .getInstance(DynamicCodeCodeListViewBrowserElement.class);
        listViewBrowserElementHandler = instance
                .inject(DynamicCodeCodeListViewBrowserElementHandler.class);
        viewModel = new DynamicCodeCodeListViewModel();
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
