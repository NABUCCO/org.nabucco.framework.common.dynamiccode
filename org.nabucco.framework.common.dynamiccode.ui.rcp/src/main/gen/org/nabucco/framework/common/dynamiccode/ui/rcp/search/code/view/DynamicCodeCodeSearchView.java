/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.code.view;

import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.common.dynamiccode.ui.rcp.search.code.model.DynamicCodeCodeSearchViewModel;
import org.nabucco.framework.plugin.base.view.AbstractNabuccoSearchView;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.framework.plugin.base.view.NabuccoSearchView;

/**
 * DynamicCodeCodeSearchView<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-05
 */
public class DynamicCodeCodeSearchView extends
        AbstractNabuccoSearchView<DynamicCodeCodeSearchViewModel> implements NabuccoSearchView {

    private DynamicCodeCodeSearchViewModel model;

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.search.code.DynamicCodeCodeSearchView";

    /** Constructs a new DynamicCodeCodeSearchView instance. */
    public DynamicCodeCodeSearchView() {
        super();
        model = new DynamicCodeCodeSearchViewModel(this.getCorrespondingListView());
    }

    @Override
    public void createPartControl(final Composite parent,
            final NabuccoMessageManager aMessageManager) {
        this.getLayouter().layout(parent, aMessageManager, model);
    }

    @Override
    public DynamicCodeCodeSearchViewModel getModel() {
        return model;
    }

    @Override
    public String getId() {
        return DynamicCodeCodeSearchView.ID;
    }
}
