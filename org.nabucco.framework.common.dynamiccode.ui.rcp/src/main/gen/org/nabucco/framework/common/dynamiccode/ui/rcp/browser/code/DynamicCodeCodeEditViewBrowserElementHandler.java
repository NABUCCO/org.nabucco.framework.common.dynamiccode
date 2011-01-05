/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
