/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.view;

import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.model.DynamicCodeCodeGroupSearchViewModel;
import org.nabucco.framework.plugin.base.view.AbstractNabuccoSearchView;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.framework.plugin.base.view.NabuccoSearchView;

/**
 * DynamicCodeCodeGroupSearchView<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-05
 */
public class DynamicCodeCodeGroupSearchView extends
        AbstractNabuccoSearchView<DynamicCodeCodeGroupSearchViewModel> implements NabuccoSearchView {

    private DynamicCodeCodeGroupSearchViewModel model;

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.search.codegroup.DynamicCodeCodeGroupSearchView";

    /** Constructs a new DynamicCodeCodeGroupSearchView instance. */
    public DynamicCodeCodeGroupSearchView() {
        super();
        model = new DynamicCodeCodeGroupSearchViewModel(this.getCorrespondingListView());
    }

    @Override
    public void createPartControl(final Composite parent,
            final NabuccoMessageManager aMessageManager) {
        this.getLayouter().layout(parent, aMessageManager, model);
    }

    @Override
    public DynamicCodeCodeGroupSearchViewModel getModel() {
        return model;
    }

    @Override
    public String getId() {
        return DynamicCodeCodeGroupSearchView.ID;
    }
}
