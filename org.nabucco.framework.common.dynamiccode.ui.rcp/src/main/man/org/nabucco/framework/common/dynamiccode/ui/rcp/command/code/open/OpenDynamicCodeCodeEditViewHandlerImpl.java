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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.open;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view.DynamicCodeCodeEditView;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.DynamicCodeCodeListView;
import org.nabucco.framework.plugin.base.command.AbstractOpenCorrespondingEditViewHandlerImpl;

/**
 * OpenDynamicCodeCodeEditViewHandlerImpl
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class OpenDynamicCodeCodeEditViewHandlerImpl extends
        AbstractOpenCorrespondingEditViewHandlerImpl<DynamicCodeCodeEditViewModel, DynamicCodeCode>
        implements OpenDynamicCodeCodeEditViewHandler {

    @Override
    public void openDynamicCodeCodeEditView() {
        run();
    }

    @Override
    protected void openCorrespondingEditView(DynamicCodeCodeEditViewModel model,
            DynamicCodeCode selected) {
        model.setCode(selected);
    }

    @Override
    protected String getEditorViewId() {
        return DynamicCodeCodeEditView.ID;
    }

    @Override
    public String getListViewId() {
        return DynamicCodeCodeListView.ID;
    }

}
