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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.save;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditBusinessModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.command.AbstractSaveCommandHandlerImpl;

/**
 * SaveDynamicCodeCodeHandlerImpl
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class SaveDynamicCodeCodeHandlerImpl extends
        AbstractSaveCommandHandlerImpl<DynamicCodeCodeEditBusinessModel, DynamicCodeCodeEditViewModel> implements
        SaveDynamicCodeCodeHandler {

    @Override
    public void saveDynamicCodeCode() {
        run();
    }

    @Override
    public String getBusinessModelId() {
        return DynamicCodeCodeEditBusinessModel.ID;
    }

    @Override
    protected void saveModel(DynamicCodeCodeEditViewModel viewModel, DynamicCodeCodeEditBusinessModel businessModel)
            throws ClientException {
        DynamicCodeCode code = viewModel.getCode();
        DynamicCodeCodeGroup parentGroup = viewModel.getGroup();
        DynamicCodeCodeMaintainMsg result = businessModel.save(code, parentGroup);
        viewModel.setCode(result.getCode());
    }
}
