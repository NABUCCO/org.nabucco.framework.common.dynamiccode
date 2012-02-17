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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.save;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditBusinessModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.plugin.base.command.AbstractSaveCommandHandlerImpl;

/**
 * SaveDynamicCodeCodeGroupHandlerImpl
 * 
 * @author Michael Krau�e, PRODYNA AG
 */
public class SaveDynamicCodeCodeGroupHandlerImpl extends
        AbstractSaveCommandHandlerImpl<DynamicCodeCodeGroupEditBusinessModel, DynamicCodeCodeGroupEditViewModel>
        implements SaveDynamicCodeCodeGroupHandler {

    @Override
    public void saveDynamicCodeCodeGroup() {
        run();
    }

    @Override
    public String getBusinessModelId() {
        return DynamicCodeCodeGroupEditBusinessModel.ID;
    }

    @Override
    protected void saveModel(DynamicCodeCodeGroupEditViewModel viewModel,
            DynamicCodeCodeGroupEditBusinessModel businessModel) throws ClientException {
        DynamicCodeCodeGroup code = viewModel.getCodeGroup();
        DynamicCodeCodeGroup parentGroup = viewModel.getParentGroup();
        DynamicCodeCodeGroupMaintainMsg result = businessModel.save(code, parentGroup);
        viewModel.setCodeGroup(result.getCodeGroup());
        viewModel.setDirty(false);
    }
}
