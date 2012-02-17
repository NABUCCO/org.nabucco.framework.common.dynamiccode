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
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.maintain;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * MaintainDynamicCodeDelegate<p/>Maintain Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-01-15
 */
public class MaintainDynamicCodeDelegate extends ServiceDelegateSupport {

    private MaintainDynamicCode service;

    /**
     * Constructs a new MaintainDynamicCodeDelegate instance.
     *
     * @param service the MaintainDynamicCode.
     */
    public MaintainDynamicCodeDelegate(MaintainDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * MaintainDynamicCodeCodeGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DynamicCodeCodeGroupMaintainMsg.
     * @return the DynamicCodeCodeGroupMaintainMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupMaintainMsg maintainDynamicCodeCodeGroup(DynamicCodeCodeGroupMaintainMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> request = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainDynamicCodeCodeGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainDynamicCode.class, "maintainDynamicCodeCodeGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCodeGroup");
    }

    /**
     * MaintainDynamicCodeCode.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the DynamicCodeCodeMaintainMsg.
     * @return the DynamicCodeCodeMaintainMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeMaintainMsg maintainDynamicCodeCode(DynamicCodeCodeMaintainMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<DynamicCodeCodeMaintainMsg> request = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeMaintainMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainDynamicCodeCode(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainDynamicCode.class, "maintainDynamicCodeCode", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCode");
    }
}
