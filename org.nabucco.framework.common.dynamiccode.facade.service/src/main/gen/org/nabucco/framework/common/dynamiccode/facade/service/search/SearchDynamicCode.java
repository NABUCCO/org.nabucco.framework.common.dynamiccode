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
package org.nabucco.framework.common.dynamiccode.facade.service.search;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;

/**
 * SearchDynamicCode<p/>Search Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public interface SearchDynamicCode extends Service {

    /**
     * Missing description at method searchDynamicCodeCode.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeSearchMsg>.
     * @return the ServiceResponse<DynamicCodeCodeListMsg>.
     * @throws SearchException
     */
    ServiceResponse<DynamicCodeCodeListMsg> searchDynamicCodeCode(ServiceRequest<DynamicCodeCodeSearchMsg> rq)
            throws SearchException;

    /**
     * Missing description at method searchDynamicCodeCodeGroup.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupSearchMsg>.
     * @return the ServiceResponse<DynamicCodeCodeGroupListMsg>.
     * @throws SearchException
     */
    ServiceResponse<DynamicCodeCodeGroupListMsg> searchDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupSearchMsg> rq) throws SearchException;

    /**
     * Missing description at method searchByCodePath.
     *
     * @param rq the ServiceRequest<CodePathSearchMsg>.
     * @return the ServiceResponse<DynamicCodeCodeListMsg>.
     * @throws SearchException
     */
    ServiceResponse<DynamicCodeCodeListMsg> searchByCodePath(ServiceRequest<CodePathSearchMsg> rq)
            throws SearchException;

    /**
     * Missing description at method searchByCodeGroupPath.
     *
     * @param rq the ServiceRequest<CodePathSearchMsg>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMsg>.
     * @throws SearchException
     */
    ServiceResponse<DynamicCodeCodeGroupMsg> searchByCodeGroupPath(ServiceRequest<CodePathSearchMsg> rq)
            throws SearchException;
}
