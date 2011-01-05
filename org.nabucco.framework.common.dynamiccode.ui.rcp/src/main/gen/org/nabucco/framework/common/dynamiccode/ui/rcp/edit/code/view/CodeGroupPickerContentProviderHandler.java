/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view;

import java.util.Map;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectable;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;

/**
 * CodeGroupPickerContentProviderHandler<p/>@Edit view for datatype DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public interface CodeGroupPickerContentProviderHandler extends NabuccoInjectable {

    /**
     * LoadAllDynamicCodeCodeGroup.
     *
     * @param viewModel the DynamicCodeCodeEditViewModel.
     * @return the Map<String, DynamicCodeCodeGroup[]>.
     */
    Map<String, DynamicCodeCodeGroup[]> loadAllDynamicCodeCodeGroup(
            DynamicCodeCodeEditViewModel viewModel);
}
