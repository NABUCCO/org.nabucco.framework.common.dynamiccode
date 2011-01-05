/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code;

import java.io.Serializable;
import java.util.Map;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.model.browser.DatatypeBrowserElement;

/**
 * DynamicCodeCodeEditViewBrowserElement<p/>Leading datatype of the DynamicCodeCodeEditView<p/>
 *
 * @author Undefined
 */
public class DynamicCodeCodeEditViewBrowserElement extends DatatypeBrowserElement implements
        NabuccoInjectionReciever {

    private DynamicCodeCodeEditViewModel viewModel;

    private DynamicCodeCodeEditViewBrowserElementHandler browserHandler;

    /**
     * Constructs a new DynamicCodeCodeEditViewBrowserElement instance.
     *
     * @param datatype the DynamicCodeCode.
     */
    public DynamicCodeCodeEditViewBrowserElement(final DynamicCodeCode datatype) {
        super();
        NabuccoInjector instance = NabuccoInjector
                .getInstance(DynamicCodeCodeEditViewBrowserElement.class);
        browserHandler = instance.inject(DynamicCodeCodeEditViewBrowserElementHandler.class);
        viewModel = new DynamicCodeCodeEditViewModel();
        viewModel.setCode(datatype);
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
     * @return the DynamicCodeCodeEditViewModel.
     */
    public DynamicCodeCodeEditViewModel getViewModel() {
        return this.viewModel;
    }

    /**
     * Setter for the ViewModel.
     *
     * @param viewModel the DynamicCodeCodeEditViewModel.
     */
    public void setViewModel(DynamicCodeCodeEditViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
