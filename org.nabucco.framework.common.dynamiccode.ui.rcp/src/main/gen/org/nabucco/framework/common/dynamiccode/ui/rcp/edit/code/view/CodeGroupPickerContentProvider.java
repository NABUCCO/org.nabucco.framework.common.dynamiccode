/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view;

import java.util.Map;
import org.eclipse.jface.viewers.Viewer;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerContentProvider;

/**
 * CodeGroupPickerContentProvider<p/>@Edit view for datatype DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class CodeGroupPickerContentProvider implements ElementPickerContentProvider,
        NabuccoInjectionReciever {

    private CodeGroupPickerContentProviderHandler handler = NabuccoInjector.getInstance(
            CodeGroupPickerContentProvider.class).inject(
            CodeGroupPickerContentProviderHandler.class);

    private Map<String, DynamicCodeCodeGroup[]> values;

    private DynamicCodeCodeEditViewModel viewModel;

    /**
     * Constructs a new CodeGroupPickerContentProvider instance.
     *
     * @param viewModel the DynamicCodeCodeEditViewModel.
     */
    public CodeGroupPickerContentProvider(DynamicCodeCodeEditViewModel viewModel) {
        super();
        this.viewModel = viewModel;
    }

    /** InitValues. */
    private void initValues() {
        values = handler.loadAllDynamicCodeCodeGroup(viewModel);
    }

    @Override
    public String[] getPaths() {
        this.initValues();
        return values.keySet().toArray(new String[values.size()]);
    }

    @Override
    public Object[] getElements(Object arg0) {
        this.initValues();
        if ((arg0 instanceof String)) {
            return values.get(arg0);
        }
        return new Object[0];
    }

    @Override
    public void dispose() {
        values = null;
    }

    @Override
    public void inputChanged(Viewer arg0, Object anOldValue, Object anNewValue) {
    }
}
