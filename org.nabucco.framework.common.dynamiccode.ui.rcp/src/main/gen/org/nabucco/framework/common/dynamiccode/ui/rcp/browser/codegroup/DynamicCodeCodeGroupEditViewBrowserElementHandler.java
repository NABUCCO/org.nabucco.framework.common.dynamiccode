/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup;

import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.plugin.base.command.CommandHandler;

/**
 * DynamicCodeCodeGroupEditViewBrowserElementHandler<p/>Leading datatype of the DynamicCodeCodeEditView<p/>
 *
 * @author Undefined
 */
public interface DynamicCodeCodeGroupEditViewBrowserElementHandler extends CommandHandler {

    /**
     * LoadFull.
     *
     * @param dynamicCodeCodeGroup the DynamicCodeCodeGroupEditViewModel.
     * @return the DynamicCodeCodeGroupEditViewModel.
     */
    DynamicCodeCodeGroupEditViewModel loadFull(
            final DynamicCodeCodeGroupEditViewModel dynamicCodeCodeGroup);

    /**
     * CreateChildren.
     *
     * @param element the DynamicCodeCodeGroupEditViewBrowserElement.
     * @param viewModel the DynamicCodeCodeGroupEditViewModel.
     */
    void createChildren(final DynamicCodeCodeGroupEditViewModel viewModel,
            final DynamicCodeCodeGroupEditViewBrowserElement element);
}
