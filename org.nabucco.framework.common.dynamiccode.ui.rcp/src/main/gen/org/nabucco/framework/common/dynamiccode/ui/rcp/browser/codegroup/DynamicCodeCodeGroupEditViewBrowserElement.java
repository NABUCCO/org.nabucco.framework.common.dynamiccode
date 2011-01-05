/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup;

import java.io.Serializable;
import java.util.Map;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.plugin.base.model.browser.DatatypeBrowserElement;

/**
 * DynamicCodeCodeGroupEditViewBrowserElement<p/>Leading datatype of the DynamicCodeCodeEditView<p/>
 *
 * @author Undefined
 */
public class DynamicCodeCodeGroupEditViewBrowserElement extends DatatypeBrowserElement implements
        NabuccoInjectionReciever {

    private DynamicCodeCodeGroupEditViewModel viewModel;

    private DynamicCodeCodeGroupEditViewBrowserElementHandler browserHandler;

    /**
     * Constructs a new DynamicCodeCodeGroupEditViewBrowserElement instance.
     *
     * @param datatype the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroupEditViewBrowserElement(final DynamicCodeCodeGroup datatype) {
        super();
        NabuccoInjector instance = NabuccoInjector
                .getInstance(DynamicCodeCodeGroupEditViewBrowserElement.class);
        browserHandler = instance.inject(DynamicCodeCodeGroupEditViewBrowserElementHandler.class);
        viewModel = new DynamicCodeCodeGroupEditViewModel();
        viewModel.setCodeGroup(datatype);
    }

    @Override
    protected void fillDatatype() {
        viewModel = browserHandler.loadFull(viewModel);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        browserHandler.createChildren(viewModel, this);
    }

    @Override
    public Map<String, Serializable> getValues() {
        return this.viewModel.getValues();
    }

    /**
     * Getter for the ViewModel.
     *
     * @return the DynamicCodeCodeGroupEditViewModel.
     */
    public DynamicCodeCodeGroupEditViewModel getViewModel() {
        return this.viewModel;
    }

    /**
     * Setter for the ViewModel.
     *
     * @param viewModel the DynamicCodeCodeGroupEditViewModel.
     */
    public void setViewModel(DynamicCodeCodeGroupEditViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
