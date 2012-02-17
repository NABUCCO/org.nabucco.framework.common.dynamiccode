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
package org.nabucco.framework.common.dynamiccode.ui.web.communication.importing;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.service.importing.ImportDynamicCode;

/**
 * ImportDynamicCodeDelegate<p/>Service to import dynamic code<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2011-02-26
 */
public class ImportDynamicCodeDelegate extends ServiceDelegateSupport {

    private ImportDynamicCode service;

    /**
     * Constructs a new ImportDynamicCodeDelegate instance.
     *
     * @param service the ImportDynamicCode.
     */
    public ImportDynamicCodeDelegate(ImportDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * ImportDynamicCode.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ImportRq.
     * @return the ImportRs.
     * @throws ImportException
     */
    public ImportRs importDynamicCode(ImportRq message, NabuccoSession session, ServiceSubContext... subContexts)
            throws ImportException {
        ServiceRequest<ImportRq> request = new ServiceRequest<ImportRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ImportRs> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.importDynamicCode(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ImportDynamicCode.class, "importDynamicCode", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ImportException("Cannot execute service operation: ImportDynamicCode.importDynamicCode");
    }
}
