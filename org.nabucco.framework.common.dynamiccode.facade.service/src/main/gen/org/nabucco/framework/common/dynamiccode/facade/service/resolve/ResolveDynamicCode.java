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
package org.nabucco.framework.common.dynamiccode.facade.service.resolve;

import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;

/**
 * ResolveDynamicCode<p/>Resolution Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public interface ResolveDynamicCode extends Service {

    /**
     * Missing description at method resolveDynamicCodeCode.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeResolveRq>.
     * @return the ServiceResponse<DynamicCodeCodeResolveRs>.
     * @throws ResolveException
     */
    ServiceResponse<DynamicCodeCodeResolveRs> resolveDynamicCodeCode(ServiceRequest<DynamicCodeCodeResolveRq> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveDynamicCodeCodeGroup.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupResolveRq>.
     * @return the ServiceResponse<DynamicCodeCodeGroupResolveRs>.
     * @throws ResolveException
     */
    ServiceResponse<DynamicCodeCodeGroupResolveRs> resolveDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupResolveRq> rq) throws ResolveException;

    /**
     * Missing description at method resolveAll.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMsg>.
     * @throws ResolveException
     */
    ServiceResponse<DynamicCodeCodeGroupMsg> resolveAll(ServiceRequest<EmptyServiceMessage> rq) throws ResolveException;
}
