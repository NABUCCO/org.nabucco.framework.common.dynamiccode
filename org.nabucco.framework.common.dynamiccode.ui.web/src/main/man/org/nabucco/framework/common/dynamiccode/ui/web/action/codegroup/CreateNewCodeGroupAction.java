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

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.client.action.ActionException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.ui.web.action.handler.OpenEditorActionHandler;
import org.nabucco.framework.base.ui.web.action.parameter.WebActionParameter;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.produce.ProduceDynamicCodeDelegate;

/**
 * CreateNewCodeGroupAction
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class CreateNewCodeGroupAction extends OpenEditorActionHandler<DynamicCodeCodeGroup> {

    private static final String EDITOR_ID = "DynamicCodeGroupEditor";

    @Override
    protected String getEditorId(WebActionParameter parameter, DynamicCodeCodeGroup group) throws ClientException {
        return EDITOR_ID;
    }

    @Override
    protected DynamicCodeCodeGroup loadDatatype(Long datatypeId, WebActionParameter parameter) throws ClientException {
        ProduceDynamicCodeDelegate produceService = DynamicCodeComponentServiceDelegateFactory.getInstance()
                .getProduceDynamicCode();

        try {
            EmptyServiceMessage rq = new EmptyServiceMessage();
            DynamicCodeCodeGroupMsg rs = produceService.produceDynamicCodeCodeGroup(rq, parameter.getSession());
            return rs.getCodeGroup();
        } catch (ProduceException e) {
            throw new ActionException("Error producing DynamicCodeGroup.", e);
        }
    }

}
