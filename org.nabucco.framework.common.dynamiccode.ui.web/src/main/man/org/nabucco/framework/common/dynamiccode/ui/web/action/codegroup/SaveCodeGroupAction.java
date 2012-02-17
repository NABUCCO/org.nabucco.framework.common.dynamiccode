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
package org.nabucco.framework.common.dynamiccode.ui.web.action.codegroup;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.client.action.ActionException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.ui.web.action.handler.SaveActionHandler;
import org.nabucco.framework.base.ui.web.action.parameter.WebActionParameter;
import org.nabucco.framework.base.ui.web.component.work.WorkItemType;
import org.nabucco.framework.base.ui.web.component.work.editor.EditorItem;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.maintain.MaintainDynamicCodeDelegate;

/**
 * SaveCodeGroupAction
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SaveCodeGroupAction extends SaveActionHandler<DynamicCodeCodeGroup> {

    @Override
    protected DynamicCodeCodeGroup saveDatatype(DynamicCodeCodeGroup codeGroup, EditorItem editor,
            WebActionParameter parameter) throws ClientException {

        codeGroup = maintain(codeGroup, parameter);
        this.addToParent(codeGroup, editor);

        return codeGroup;
    }

    /**
     * Maintain the codeGroup to the database.
     * 
     * @param codeGroup
     *            the codeGroup to maintain
     * @param parameter
     *            the web action parameter
     * 
     * @return the maintained codeGroup
     * 
     * @throws ClientException
     *             when the codeGroup cannot be maintained
     */
    private DynamicCodeCodeGroup maintain(DynamicCodeCodeGroup codeGroup, WebActionParameter parameter)
            throws ClientException {

        MaintainDynamicCodeDelegate maintainService = DynamicCodeComponentServiceDelegateFactory.getInstance()
                .getMaintainDynamicCode();

        DynamicCodeCodeGroupMaintainMsg rq = new DynamicCodeCodeGroupMaintainMsg();
        rq.setCodeGroup(codeGroup);

        try {
            DynamicCodeCodeGroupMaintainMsg rs = maintainService.maintainDynamicCodeCodeGroup(rq,
                    parameter.getSession());
            return rs.getCodeGroup();
        } catch (MaintainException e) {
            throw new ActionException("Error maintaining DynamicCodeGroup.", e);
        }
    }

    /**
     * Add the code group to the parent datatype if exists.
     * 
     * @param group
     *            the code group to add to the parent
     * @param editor
     *            the editor holding the source reference
     */
    private void addToParent(DynamicCodeCodeGroup group, EditorItem editor) {
        if (editor.getSource() == null) {
            return;
        }
        if (editor.getSource().getItemType() != WorkItemType.EDITOR) {
            return;
        }

        EditorItem sourceEditor = (EditorItem) editor.getSource();
        Datatype sourceDatatype = sourceEditor.getModel().getDatatype();

        if (sourceDatatype instanceof DynamicCodeCodeGroup) {
            DynamicCodeCodeGroup parentGroup = (DynamicCodeCodeGroup) sourceDatatype;

            for (int i = 0; i < parentGroup.getCodeGroupList().size(); i++) {
                DynamicCodeCodeGroup existingGroup = parentGroup.getCodeGroupList().get(i);
                if (existingGroup.getId().equals(group.getId())) {
                    parentGroup.getCodeGroupList().set(i, group);
                    return;
                }
            }

            parentGroup.getCodeGroupList().add(group);
        }
    }

}
