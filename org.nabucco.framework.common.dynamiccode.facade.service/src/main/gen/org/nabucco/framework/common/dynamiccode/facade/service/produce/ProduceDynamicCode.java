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
package org.nabucco.framework.common.dynamiccode.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;

/**
 * ProduceDynamicCode<p/>Produce Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-29
 */
public interface ProduceDynamicCode extends Service {

    /**
     * Creates a new DynamicCodeCodeGroup.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMsg>.
     * @throws ProduceException
     */
    ServiceResponse<DynamicCodeCodeGroupMsg> produceDynamicCodeCodeGroup(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Creates a new DynamicCodeCode.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeMsg>.
     * @throws ProduceException
     */
    ServiceResponse<DynamicCodeCodeMsg> produceDynamicCodeCode(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;
}
