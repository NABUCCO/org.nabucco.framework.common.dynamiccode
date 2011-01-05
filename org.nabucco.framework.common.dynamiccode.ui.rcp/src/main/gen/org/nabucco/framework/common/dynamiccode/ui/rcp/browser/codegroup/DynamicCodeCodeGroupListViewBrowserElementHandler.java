/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup;

import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.model.DynamicCodeCodeGroupListViewModel;
import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;

/**
 * DynamicCodeCodeGroupListViewBrowserElementHandler
 *
 * @author Undefined
 */
public interface DynamicCodeCodeGroupListViewBrowserElementHandler extends CommandHandler {

    /**
     * CreateChildren.
     *
     * @param element the DynamicCodeCodeGroupListViewBrowserElement.
     * @param viewModel the DynamicCodeCodeGroupListViewModel.
     */
    void createChildren(final DynamicCodeCodeGroupListViewModel viewModel,
            final DynamicCodeCodeGroupListViewBrowserElement element);

    /**
     * RemoveChild.
     *
     * @param element the DynamicCodeCodeGroupListViewBrowserElement.
     * @param toBeRemoved the BrowserElement.
     */
    void removeChild(final BrowserElement toBeRemoved,
            final DynamicCodeCodeGroupListViewBrowserElement element);
}
