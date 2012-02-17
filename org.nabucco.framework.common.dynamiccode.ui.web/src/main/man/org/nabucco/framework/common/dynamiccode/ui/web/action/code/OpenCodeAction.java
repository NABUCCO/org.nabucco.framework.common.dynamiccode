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

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.client.action.ActionException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.ui.web.action.handler.OpenEditorActionHandler;
import org.nabucco.framework.base.ui.web.action.parameter.WebActionParameter;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.resolve.ResolveDynamicCodeDelegate;

/**
 * OpenCodeAction
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class OpenCodeAction extends OpenEditorActionHandler<DynamicCodeCode> {

    private static final String EDITOR_ID = "DynamicCodeEditor";

    @Override
    protected String getEditorId(WebActionParameter parameter) throws ClientException {
        return EDITOR_ID;
    }

    @Override
    protected DynamicCodeCode loadDatatype(Long id, WebActionParameter parameter) throws ClientException {
        if (id == null) {
            return null;
        }

        ResolveDynamicCodeDelegate resolveService = DynamicCodeComponentServiceDelegateFactory.getInstance()
                .getResolveDynamicCode();

        DynamicCodeCodeResolveRq rq = new DynamicCodeCodeResolveRq();
        DynamicCodeCode code = new DynamicCodeCode();
        rq.setCode(code);
        code.setId(id);

        try {
            DynamicCodeCodeResolveRs rs = resolveService.resolveDynamicCodeCode(rq, parameter.getSession());
            return rs.getCode();
        } catch (ResolveException e) {
            throw new ActionException("Error resolving DynamicCode.", e);
        }
    }

}
