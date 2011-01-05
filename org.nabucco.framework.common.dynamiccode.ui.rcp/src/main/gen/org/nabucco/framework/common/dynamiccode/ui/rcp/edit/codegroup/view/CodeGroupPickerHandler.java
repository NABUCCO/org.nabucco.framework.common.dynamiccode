/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.view;

import org.eclipse.swt.events.TypedEvent;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerListener;

/**
 * CodeGroupPickerHandler<p/>@Edit view for datatype DynamicCodeCodeGroup<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class CodeGroupPickerHandler implements ElementPickerListener {

    private DynamicCodeCodeGroupEditViewModel model;

    /**
     * Constructs a new CodeGroupPickerHandler instance.
     *
     * @param model the DynamicCodeCodeGroupEditViewModel.
     */
    public CodeGroupPickerHandler(final DynamicCodeCodeGroupEditViewModel model) {
        super();
        this.model = model;
    }

    @Override
    public void elementSelected(TypedEvent event) {
        if ((event.data instanceof DynamicCodeCodeGroup)) {
            model.setParentGroup(((DynamicCodeCodeGroup) event.data));
        } else if ((event.data == null)) {
            model.setParentGroup(null);
        }
    }
}
