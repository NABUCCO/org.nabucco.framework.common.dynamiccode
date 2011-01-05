/*

 * Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved. Created 20.05.2010

 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code;

import java.util.List;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.model.DynamicCodeCodeListViewModel;
import org.nabucco.framework.plugin.base.model.browser.AbstractBrowserListViewHandlerImpl;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;

/**
 * DynamicCodeCodeListViewBrowserElementHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCodeListViewBrowserElementHandlerImpl
        extends
        AbstractBrowserListViewHandlerImpl<DynamicCodeCode, DynamicCodeCodeListViewModel, DynamicCodeCodeListViewBrowserElement, DynamicCodeCodeEditViewBrowserElement>
        implements DynamicCodeCodeListViewBrowserElementHandler {

    @Override
    public void createChildren(DynamicCodeCodeListViewModel viewModel,
            DynamicCodeCodeListViewBrowserElement element) {

        for (DynamicCodeCode code : viewModel.getElements()) {
            element.addBrowserElement(new DynamicCodeCodeEditViewBrowserElement(code));
        }
    }

    @Override
    public void removeChild(BrowserElement toBeRemoved,
            DynamicCodeCodeListViewBrowserElement element) {
        super.removeChildren((DynamicCodeCodeEditViewBrowserElement) toBeRemoved, element);
    }

    @Override
    public boolean haveSameId(DynamicCodeCode codeGroup,
            DynamicCodeCodeEditViewBrowserElement dynamicCodeCodeEditViewBrowserElement) {

        boolean result = false;
        result = codeGroup.getId().equals(
                dynamicCodeCodeEditViewBrowserElement.getViewModel().getCode().getId());
        return result;
    }

    @Override
    public void updateViewModel(List<DynamicCodeCode> elements,
            DynamicCodeCodeListViewModel viewModel) {

        viewModel.setElements(elements.toArray(new DynamicCodeCode[0]));

    }

}
