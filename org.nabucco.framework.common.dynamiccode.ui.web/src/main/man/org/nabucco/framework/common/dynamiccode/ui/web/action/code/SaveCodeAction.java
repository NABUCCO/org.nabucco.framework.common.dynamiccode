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
package org.nabucco.framework.common.dynamiccode.ui.web.action.code;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.client.action.ActionException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.ui.web.action.handler.SaveActionHandler;
import org.nabucco.framework.base.ui.web.action.parameter.WebActionParameter;
import org.nabucco.framework.base.ui.web.component.work.WorkItemType;
import org.nabucco.framework.base.ui.web.component.work.editor.EditorItem;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.maintain.MaintainDynamicCodeDelegate;

/**
 * SaveCodeAction
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SaveCodeAction extends SaveActionHandler<DynamicCodeCode> {

    @Override
    protected DynamicCodeCode saveDatatype(DynamicCodeCode code, EditorItem editor, WebActionParameter parameter)
            throws ClientException {

        code = this.maintain(code, parameter);

        this.addToParent(code, editor);

        return code;
    }

    /**
     * Maintain the code to the database.
     * 
     * @param code
     *            the code to maintain
     * @param parameter
     *            the web action parameter
     * 
     * @return the maintained code
     * 
     * @throws ClientException
     *             when the code cannot be maintained
     */
    public DynamicCodeCode maintain(DynamicCodeCode code, WebActionParameter parameter) throws ClientException {

        MaintainDynamicCodeDelegate maintainService = DynamicCodeComponentServiceDelegateFactory.getInstance()
                .getMaintainDynamicCode();

        DynamicCodeCodeMaintainMsg rq = new DynamicCodeCodeMaintainMsg();
        rq.setCode(code);

        try {
            DynamicCodeCodeMaintainMsg rs = maintainService.maintainDynamicCodeCode(rq, parameter.getSession());
            return rs.getCode();
        } catch (MaintainException e) {
            throw new ActionException("Error maintaining DynamicCode.", e);
        }
    }

    /**
     * Add the code to the parent datatype if exists.
     * 
     * @param code
     *            the code to add to the parent
     * @param editor
     *            the editor holding the source reference
     */
    private void addToParent(DynamicCodeCode code, EditorItem editor) {
        if (editor.getSource() == null) {
            return;
        }
        if (editor.getSource().getItemType() != WorkItemType.EDITOR) {
            return;
        }

        EditorItem sourceEditor = (EditorItem) editor.getSource();
        Datatype sourceDatatype = sourceEditor.getModel().getDatatype();

        if (sourceDatatype instanceof DynamicCodeCodeGroup) {
            DynamicCodeCodeGroup codeGroup = (DynamicCodeCodeGroup) sourceDatatype;

            for (int i = 0; i < codeGroup.getCodeList().size(); i++) {
                DynamicCodeCode existingCode = codeGroup.getCodeList().get(i);
                if (existingCode.getId().equals(code.getId())) {
                    codeGroup.getCodeList().set(i, code);
                    return;
                }
            }

            codeGroup.getCodeList().add(code);
        }
    }

}
