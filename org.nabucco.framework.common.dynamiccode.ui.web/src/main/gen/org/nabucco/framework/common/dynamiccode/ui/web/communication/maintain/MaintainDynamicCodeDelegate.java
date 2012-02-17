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
package org.nabucco.framework.common.dynamiccode.ui.web.communication.maintain;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;

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
     * @param session the NabuccoSession.
     * @param message the DynamicCodeCodeGroupMaintainMsg.
     * @return the DynamicCodeCodeGroupMaintainMsg.
     * @throws MaintainException
     */
    public DynamicCodeCodeGroupMaintainMsg maintainDynamicCodeCodeGroup(DynamicCodeCodeGroupMaintainMsg message,
            NabuccoSession session, ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> request = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException(
                "Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCodeGroup");
    }

    /**
     * MaintainDynamicCodeCode.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the DynamicCodeCodeMaintainMsg.
     * @return the DynamicCodeCodeMaintainMsg.
     * @throws MaintainException
     */
    public DynamicCodeCodeMaintainMsg maintainDynamicCodeCode(DynamicCodeCodeMaintainMsg message,
            NabuccoSession session, ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<DynamicCodeCodeMaintainMsg> request = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeMaintainMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCode");
    }
}
