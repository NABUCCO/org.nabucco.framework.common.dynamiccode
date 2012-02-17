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
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.produce;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ProduceDynamicCodeDelegate<p/>Produce Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-29
 */
public class ProduceDynamicCodeDelegate extends ServiceDelegateSupport {

    private ProduceDynamicCode service;

    /**
     * Constructs a new ProduceDynamicCodeDelegate instance.
     *
     * @param service the ProduceDynamicCode.
     */
    public ProduceDynamicCodeDelegate(ProduceDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * ProduceDynamicCodeCodeGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupMsg produceDynamicCodeCodeGroup(EmptyServiceMessage message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceDynamicCodeCodeGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceDynamicCode.class, "produceDynamicCodeCodeGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCodeGroup");
    }

    /**
     * ProduceDynamicCodeCode.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the DynamicCodeCodeMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeMsg produceDynamicCodeCode(EmptyServiceMessage message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceDynamicCodeCode(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceDynamicCode.class, "produceDynamicCodeCode", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCode");
    }
}
