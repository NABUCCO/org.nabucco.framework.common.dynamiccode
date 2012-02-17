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
package org.nabucco.framework.common.dynamiccode.ui.web.communication.export;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.export.ExportDynamicCode;

/**
 * ExportDynamicCodeDelegate<p/>Service to export Dynamic Code<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2011-01-26
 */
public class ExportDynamicCodeDelegate extends ServiceDelegateSupport {

    private ExportDynamicCode service;

    /**
     * Constructs a new ExportDynamicCodeDelegate instance.
     *
     * @param service the ExportDynamicCode.
     */
    public ExportDynamicCodeDelegate(ExportDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * Export.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmptyServiceMessage.
     * @return the ExportRs.
     * @throws ExportException
     */
    public ExportRs export(EmptyServiceMessage message, NabuccoSession session, ServiceSubContext... subContexts)
            throws ExportException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ExportRs> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.export(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ExportDynamicCode.class, "export", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ExportException("Cannot execute service operation: ExportDynamicCode.export");
    }

    /**
     * ExportRootGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmptyServiceMessage.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ExportException
     */
    public DynamicCodeCodeGroupMsg exportRootGroup(EmptyServiceMessage message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ExportException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<DynamicCodeCodeGroupMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.exportRootGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ExportDynamicCode.class, "exportRootGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ExportException("Cannot execute service operation: ExportDynamicCode.exportRootGroup");
    }
}
