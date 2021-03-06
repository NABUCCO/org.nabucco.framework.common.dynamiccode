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
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.resolve;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ResolveDynamicCodeDelegate<p/>Resolution Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public class ResolveDynamicCodeDelegate extends ServiceDelegateSupport {

    private ResolveDynamicCode service;

    /**
     * Constructs a new ResolveDynamicCodeDelegate instance.
     *
     * @param service the ResolveDynamicCode.
     */
    public ResolveDynamicCodeDelegate(ResolveDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * ResolveDynamicCodeCode.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DynamicCodeCodeResolveRq.
     * @return the DynamicCodeCodeResolveRs.
     * @throws ClientException
     */
    public DynamicCodeCodeResolveRs resolveDynamicCodeCode(DynamicCodeCodeResolveRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<DynamicCodeCodeResolveRq> request = new ServiceRequest<DynamicCodeCodeResolveRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeResolveRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDynamicCodeCode(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveDynamicCode.class, "resolveDynamicCodeCode", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCode");
    }

    /**
     * ResolveDynamicCodeCodeGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DynamicCodeCodeGroupResolveRq.
     * @return the DynamicCodeCodeGroupResolveRs.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupResolveRs resolveDynamicCodeCodeGroup(DynamicCodeCodeGroupResolveRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<DynamicCodeCodeGroupResolveRq> request = new ServiceRequest<DynamicCodeCodeGroupResolveRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupResolveRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDynamicCodeCodeGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveDynamicCode.class, "resolveDynamicCodeCodeGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCodeGroup");
    }

    /**
     * ResolveAll.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupMsg resolveAll(EmptyServiceMessage message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveAll(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveDynamicCode.class, "resolveAll", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveDynamicCode.resolveAll");
    }
}
