/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view;

import java.io.Serializable;
import java.util.Map;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.component.edit.view.EditView;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;

/**
 * DynamicCodeCodeEditView<p/>@Edit view for datatype DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class DynamicCodeCodeEditView extends EditView<DynamicCodeCodeEditViewModel> {

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.edit.code.DynamicCodeCodeEditView";

    public static final String TAB_TITLE = (ID + ".tabTitle");

    private NabuccoFormToolkit ntk;

    public static final String TITLE = (ID + ".title");

    /** Constructs a new DynamicCodeCodeEditView instance. */
    public DynamicCodeCodeEditView() {
        super();
    }

    @Override
    protected String getManagedFormTitle() {
        return I18N.i18n(TITLE);
    }

    @Override
    protected void createFormControl(Form form) {
        ntk = new NabuccoFormToolkit(form.getBody());
        Composite frame = ntk.createComposite(form.getBody(), new RowLayout(SWT.VERTICAL));
        model = new DynamicCodeCodeEditViewModel();
        this.getLayouter().layout(frame, this.getMessageManager(), model);
    }

    @Override
    protected void createHeadControl(Composite head) {
    }

    @Override
    protected void createToolbarActions(IToolBarManager toolbarManager) {
    }

    /**
     * Getter for the Values.
     *
     * @return the Map<String, Serializable>.
     */
    public Map<String, Serializable> getValues() {
        return model.getValues();
    }

    @Override
    public String getNewPartName() {
        return I18N.i18n(TAB_TITLE, this.getValues());
    }

    @Override
    public String getId() {
        return DynamicCodeCodeEditView.ID;
    }
}
