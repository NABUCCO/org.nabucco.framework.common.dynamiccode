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
package org.nabucco.framework.common.dynamiccode.facade.service.export;

import org.nabucco.framework.base.facade.exception.service.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;

/**
 * ExportDynamicCode<p/>Service to export Dynamic Code<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2011-01-26
 */
public interface ExportDynamicCode extends Service {

    /**
     * Missing description at method export.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ExportRs>.
     * @throws ExportException
     */
    ServiceResponse<ExportRs> export(ServiceRequest<EmptyServiceMessage> rq) throws ExportException;

    /**
     * Missing description at method exportRootGroup.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMsg>.
     * @throws ExportException
     */
    ServiceResponse<DynamicCodeCodeGroupMsg> exportRootGroup(ServiceRequest<EmptyServiceMessage> rq)
            throws ExportException;
}
