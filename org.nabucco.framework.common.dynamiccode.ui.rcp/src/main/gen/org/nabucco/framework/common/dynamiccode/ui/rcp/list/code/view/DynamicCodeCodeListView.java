/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view;

import java.io.Serializable;
import java.util.Map;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.model.DynamicCodeCodeListViewModel;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoComponentListView;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoCompositeTextFilter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableViewer;

/**
 * DynamicCodeCodeListView<p/>ListView for DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-16
 */
public class DynamicCodeCodeListView extends NabuccoComponentListView<DynamicCodeCodeListViewModel> {

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.list.code.DynamicCodeCodeListView";

    public static final String TAB_TITLE = (ID + ".tabTitle");

    public static final String TITLE = (ID + ".title");

    /** Constructs a new DynamicCodeCodeListView instance. */
    public DynamicCodeCodeListView() {
        super();
        model = new DynamicCodeCodeListViewModel();
    }

    @Override
    protected void createFormControl(Form form) {
        Composite o = this.getLayouter().layout(form.getBody(), this.getMessageManager(), model,
                this);
        if ((o instanceof NabuccoTableViewer)) {
            tableViewer = ((NabuccoTableViewer) o);
        }
    }

    @Override
    protected NabuccoCompositeTextFilter createFilter(final Composite parent) {
        return new NabuccoCompositeTextFilter(parent);
    }

    @Override
    public void setFocus() {
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
    public String getManagedFormTitle() {
        return I18N.i18n(TITLE);
    }

    @Override
    public String getId() {
        return DynamicCodeCodeListView.ID;
    }
}
