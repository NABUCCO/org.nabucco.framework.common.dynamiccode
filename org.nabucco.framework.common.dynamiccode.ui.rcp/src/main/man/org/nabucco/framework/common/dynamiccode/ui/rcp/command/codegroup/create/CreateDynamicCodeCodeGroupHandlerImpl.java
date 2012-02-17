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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.create;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.produce.ProduceDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.view.DynamicCodeCodeGroupEditView;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.AbstractAddDatatypeHandlerImpl;

/**
 * Manual implementation for creating a new codeGroup.
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class CreateDynamicCodeCodeGroupHandlerImpl extends
        AbstractAddDatatypeHandlerImpl<DynamicCodeCodeGroupEditViewModel> implements CreateDynamicCodeCodeGroupHandler {

    /**
     * {@inheritDoc}
     */
    @Override
    public void createDynamicCodeCodeGroup() {
        run();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getEditViewId() {
        return DynamicCodeCodeGroupEditView.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updateModel(final DynamicCodeCodeGroupEditViewModel viewModel) {
        DynamicCodeCodeGroup codeGroup = createNewDynamicCodeCode();
        viewModel.setCodeGroup(codeGroup);
        viewModel.setParentGroup(null);
    }

    /**
     * Retrieves a new produced DynamicCodeCodeGroup from server.
     * 
     * @return the code group
     */
    private DynamicCodeCodeGroup createNewDynamicCodeCode() {
        try {
            ProduceDynamicCodeDelegate produceAuthorization = DynamicCodeComponentServiceDelegateFactory.getInstance()
                    .getProduceDynamicCode();
            DynamicCodeCodeGroupMsg response = produceAuthorization
                    .produceDynamicCodeCodeGroup(new EmptyServiceMessage());
            return response.getCodeGroup();
        } catch (ClientException e) {
            Activator.getDefault().logError(e);
        }
        return null;
    }
}
