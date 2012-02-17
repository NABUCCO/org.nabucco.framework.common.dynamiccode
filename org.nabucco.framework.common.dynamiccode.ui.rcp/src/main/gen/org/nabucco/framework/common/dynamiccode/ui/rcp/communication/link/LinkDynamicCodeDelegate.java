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
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.link;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * LinkDynamicCodeDelegate<p/>Linkage Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class LinkDynamicCodeDelegate extends ServiceDelegateSupport {

    private LinkDynamicCode service;

    /**
     * Constructs a new LinkDynamicCodeDelegate instance.
     *
     * @param service the LinkDynamicCode.
     */
    public LinkDynamicCodeDelegate(LinkDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * LinkDynamicCodeCode.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DynamicCodeCodeListMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeListMsg linkDynamicCodeCode(DynamicCodeCodeListMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<DynamicCodeCodeListMsg> request = new ServiceRequest<DynamicCodeCodeListMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.linkDynamicCodeCode(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(LinkDynamicCode.class, "linkDynamicCodeCode", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: LinkDynamicCode.linkDynamicCodeCode");
    }
}
