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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.create;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.produce.ProduceDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view.DynamicCodeCodeEditView;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.AbstractAddDatatypeHandlerImpl;

/**
 * CreateDynamicCodeCodeHandlerImpl
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class CreateDynamicCodeCodeHandlerImpl extends AbstractAddDatatypeHandlerImpl<DynamicCodeCodeEditViewModel>
        implements CreateDynamicCodeCodeHandler {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEditViewId() {
        return DynamicCodeCodeEditView.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createDynamicCodeCode() {
        run();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updateModel(DynamicCodeCodeEditViewModel viewModel) {
        DynamicCodeCode freshDynamicCodeCode = createNewDynamicCodeCode();
        viewModel.setCode(freshDynamicCodeCode);
        viewModel.setGroup(null);
    }

    /**
     * Produce new {@link DynamicCodeCode} instance.
     * 
     * @return the new created dynamic code
     */
    private DynamicCodeCode createNewDynamicCodeCode() {
        DynamicCodeCode result = null;

        try {
            ProduceDynamicCodeDelegate produceAuthorization = DynamicCodeComponentServiceDelegateFactory.getInstance()
                    .getProduceDynamicCode();
            DynamicCodeCodeMsg response = produceAuthorization.produceDynamicCodeCode(new EmptyServiceMessage());
            result = response.getCode();
        } catch (ClientException e) {
            Activator.getDefault().logError(e);
        }
        return result;
    }

}
