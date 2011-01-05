/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view;

import org.eclipse.swt.events.TypedEvent;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerListener;

/**
 * CodeGroupPickerHandler<p/>@Edit view for datatype DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class CodeGroupPickerHandler implements ElementPickerListener {

    private DynamicCodeCodeEditViewModel model;

    /**
     * Constructs a new CodeGroupPickerHandler instance.
     *
     * @param model the DynamicCodeCodeEditViewModel.
     */
    public CodeGroupPickerHandler(final DynamicCodeCodeEditViewModel model) {
        super();
        this.model = model;
    }

    @Override
    public void elementSelected(TypedEvent event) {
        if ((event.data instanceof DynamicCodeCodeGroup)) {
            model.setGroup(((DynamicCodeCodeGroup) event.data));
        } else if ((event.data == null)) {
            model.setGroup(null);
        }
    }
}
