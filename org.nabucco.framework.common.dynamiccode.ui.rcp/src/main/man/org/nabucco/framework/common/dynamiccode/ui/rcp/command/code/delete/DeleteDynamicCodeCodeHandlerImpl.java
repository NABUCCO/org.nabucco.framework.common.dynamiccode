/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.delete;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditBusinessModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view.DynamicCodeCodeEditView;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.close.AbstractDeleteDatatypeHandler;
import org.nabucco.framework.plugin.base.model.BusinessModel;

/**
 * DeleteDynamicCodeCodeHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DeleteDynamicCodeCodeHandlerImpl extends
        AbstractDeleteDatatypeHandler<DynamicCodeCodeEditView> implements
        DeleteDynamicCodeCodeHandler {

    @Override
    public String getId() {
        return DynamicCodeCodeEditView.ID;
    }

    @Override
    public void deleteDynamicCodeCode() {
        super.run();
    }

    @Override
    protected boolean preClose(DynamicCodeCodeEditView view) {
        DynamicCodeCode code = view.getModel().getCode();
        code.setDatatypeState(DatatypeState.DELETED);

        BusinessModel businessModel = Activator.getDefault().getModel()
                .getBusinessModel(DynamicCodeCodeEditBusinessModel.ID);

        try {
            if (businessModel instanceof DynamicCodeCodeEditBusinessModel) {
                ((DynamicCodeCodeEditBusinessModel) businessModel).save(code, null);
            }
        } catch (ClientException e) {
            Activator.getDefault().logError(e);
            return true;
        }

        return super.preClose(view);
    }

}
