/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.view;

import org.eclipse.swt.events.TypedEvent;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerListener;

/**
 * CodeGroupPickerHandler<p/>@Edit view for datatype DynamicCodeCodeGroup<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class CodeGroupPickerHandler implements ElementPickerListener {

    private DynamicCodeCodeGroupEditViewModel model;

    /**
     * Constructs a new CodeGroupPickerHandler instance.
     *
     * @param model the DynamicCodeCodeGroupEditViewModel.
     */
    public CodeGroupPickerHandler(final DynamicCodeCodeGroupEditViewModel model) {
        super();
        this.model = model;
    }

    @Override
    public void elementSelected(TypedEvent event) {
        if ((event.data instanceof DynamicCodeCodeGroup)) {
            model.setParentGroup(((DynamicCodeCodeGroup) event.data));
        } else if ((event.data == null)) {
            model.setParentGroup(null);
        }
    }
}
