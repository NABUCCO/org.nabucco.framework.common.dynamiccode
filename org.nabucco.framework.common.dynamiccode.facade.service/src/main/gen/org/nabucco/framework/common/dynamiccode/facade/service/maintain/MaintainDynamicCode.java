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
package org.nabucco.framework.common.dynamiccode.facade.service.maintain;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;

/**
 * MaintainDynamicCode<p/>Maintain Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-01-15
 */
public interface MaintainDynamicCode extends Service {

    /**
     * Missing description at method maintainDynamicCodeCodeGroup.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupMaintainMsg>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMaintainMsg>.
     * @throws MaintainException
     */
    ServiceResponse<DynamicCodeCodeGroupMaintainMsg> maintainDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainDynamicCodeCode.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeMaintainMsg>.
     * @return the ServiceResponse<DynamicCodeCodeMaintainMsg>.
     * @throws MaintainException
     */
    ServiceResponse<DynamicCodeCodeMaintainMsg> maintainDynamicCodeCode(ServiceRequest<DynamicCodeCodeMaintainMsg> rq)
            throws MaintainException;
}
