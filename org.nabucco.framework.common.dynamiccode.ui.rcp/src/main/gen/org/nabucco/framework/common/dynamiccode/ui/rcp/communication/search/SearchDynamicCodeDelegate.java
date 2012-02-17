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
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * SearchDynamicCodeDelegate<p/>Search Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class SearchDynamicCodeDelegate extends ServiceDelegateSupport {

    private SearchDynamicCode service;

    /**
     * Constructs a new SearchDynamicCodeDelegate instance.
     *
     * @param service the SearchDynamicCode.
     */
    public SearchDynamicCodeDelegate(SearchDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * SearchDynamicCodeCode.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DynamicCodeCodeSearchMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeListMsg searchDynamicCodeCode(DynamicCodeCodeSearchMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<DynamicCodeCodeSearchMsg> request = new ServiceRequest<DynamicCodeCodeSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchDynamicCodeCode(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchDynamicCode.class, "searchDynamicCodeCode", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCode");
    }

    /**
     * SearchDynamicCodeCodeGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DynamicCodeCodeGroupSearchMsg.
     * @return the DynamicCodeCodeGroupListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupListMsg searchDynamicCodeCodeGroup(DynamicCodeCodeGroupSearchMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<DynamicCodeCodeGroupSearchMsg> request = new ServiceRequest<DynamicCodeCodeGroupSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchDynamicCodeCodeGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchDynamicCode.class, "searchDynamicCodeCodeGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCodeGroup");
    }

    /**
     * SearchByCodePath.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CodePathSearchMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeListMsg searchByCodePath(CodePathSearchMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CodePathSearchMsg> request = new ServiceRequest<CodePathSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchByCodePath(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchDynamicCode.class, "searchByCodePath", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchDynamicCode.searchByCodePath");
    }

    /**
     * SearchByCodeGroupPath.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the CodePathSearchMsg.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupMsg searchByCodeGroupPath(CodePathSearchMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<CodePathSearchMsg> request = new ServiceRequest<CodePathSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchByCodeGroupPath(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchDynamicCode.class, "searchByCodeGroupPath", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchDynamicCode.searchByCodeGroupPath");
    }
}
