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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.delete;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditBusinessModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.view.DynamicCodeCodeGroupEditView;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.close.AbstractDeleteDatatypeHandler;
import org.nabucco.framework.plugin.base.model.BusinessModel;

/**
 * DeleteDynamicCodeCodeGroupHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DeleteDynamicCodeCodeGroupHandlerImpl extends AbstractDeleteDatatypeHandler<DynamicCodeCodeGroupEditView>
        implements DeleteDynamicCodeCodeGroupHandler {

    @Override
    public String getId() {
        return DynamicCodeCodeGroupEditView.ID;
    }

    @Override
    public void deleteDynamicCodeCodeGroup() {
        super.run();
    }

    @Override
    protected boolean preClose(DynamicCodeCodeGroupEditView view) throws ClientException {
        DynamicCodeCodeGroup codeGroup = view.getModel().getCodeGroup();
        codeGroup.setDatatypeState(DatatypeState.DELETED);

        BusinessModel businessModel = Activator.getDefault().getModel()
                .getBusinessModel(DynamicCodeCodeGroupEditBusinessModel.ID);

        if (businessModel instanceof DynamicCodeCodeGroupEditBusinessModel) {
            ((DynamicCodeCodeGroupEditBusinessModel) businessModel).save(codeGroup, null);
        }

        return super.preClose(view);
    }

}
