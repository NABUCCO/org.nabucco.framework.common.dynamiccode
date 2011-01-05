/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code;

import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.model.DynamicCodeCodeListViewModel;
import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;

/**
 * DynamicCodeCodeListViewBrowserElementHandler
 *
 * @author Undefined
 */
public interface DynamicCodeCodeListViewBrowserElementHandler extends CommandHandler {

    /**
     * CreateChildren.
     *
     * @param element the DynamicCodeCodeListViewBrowserElement.
     * @param viewModel the DynamicCodeCodeListViewModel.
     */
    void createChildren(final DynamicCodeCodeListViewModel viewModel,
            final DynamicCodeCodeListViewBrowserElement element);

    /**
     * RemoveChild.
     *
     * @param element the DynamicCodeCodeListViewBrowserElement.
     * @param toBeRemoved the BrowserElement.
     */
    void removeChild(final BrowserElement toBeRemoved,
            final DynamicCodeCodeListViewBrowserElement element);
}
