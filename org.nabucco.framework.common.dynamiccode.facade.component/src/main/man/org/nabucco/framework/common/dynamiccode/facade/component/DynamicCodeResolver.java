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
package org.nabucco.framework.common.dynamiccode.facade.component;

import java.util.Collections;
import java.util.List;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.context.ServiceMessageContext;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;

/**
 * DynamicCodeResolver
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public final class DynamicCodeResolver {

    private ServiceMessageContext context;

    private DynamicCodeComponent component;

    /** The Logger */
    private static NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(
            DynamicCodeResolver.class);

    /**
     * Creates a new {@link DynamicCodeResolver} instance.
     * 
     * @param context
     *            the service message context
     * 
     * @throws ConnectionException
     *             when the connection to the DynamicCode component cannot be established
     */
    public DynamicCodeResolver(ServiceMessageContext context) throws ConnectionException {
        if (context == null) {
            throw new IllegalArgumentException(
                    "Cannot create DynamicCodeResolver for service context [null].");
        }
        this.context = context;

        this.initComponent();
    }

    /**
     * Creates a new {@link DynamicCodeResolver} instance.
     * 
     * @param context
     *            the service message context
     * @param component
     *            the dynamic code component
     * 
     * @throws ConnectionException
     *             when the connection to the DynamicCode component cannot be established
     */
    public DynamicCodeResolver(ServiceMessageContext context, DynamicCodeComponent component) {
        if (context == null) {
            throw new IllegalArgumentException(
                    "Cannot create DynamicCodeResolver for service context [null].");
        }
        if (component == null) {
            throw new IllegalArgumentException(
                    "Cannot create DynamicCodeResolver for component [null].");
        }
        this.context = context;
        this.component = component;
    }

    /**
     * Initializes the DynamicCode component connection.
     * 
     * @throws ConnectionException
     *             when the connection to DynamicCode cannot be established
     */
    private void initComponent() throws ConnectionException {
        try {
            if (this.component == null) {
                this.component = DynamicCodeComponentLocator.getInstance().getComponent();
            }
        } catch (ConnectionException ce) {
            logger.error(ce, "Error connecting to DynamicCode component.");
            throw ce;
        }
    }

    /**
     * Resolve the {@link Code} by its reference ID.
     * 
     * @param id
     *            the reference ID of the code
     * @return the resolved code
     * 
     * @throws ResolveException
     *             when the code cannot be resolved
     */
    public Code resolveById(Long id) throws ResolveException {
        if (id == null) {
            throw new ResolveException("Cannot resolve DynamicCode with ID [null].");
        }

        try {
            DynamicCodeCode code = new DynamicCodeCode();
            code.setId(id);

            DynamicCodeCodeResolveRq msg = new DynamicCodeCodeResolveRq();
            msg.setCode(code);

            ServiceRequest<DynamicCodeCodeResolveRq> rq = new ServiceRequest<DynamicCodeCodeResolveRq>(
                    this.context);

            rq.setRequestMessage(msg);

            ResolveDynamicCode resolveService = this.component.getResolveDynamicCode();
            ServiceResponse<DynamicCodeCodeResolveRs> rs = resolveService
                    .resolveDynamicCodeCode(rq);

            return rs.getResponseMessage().getCode();

        } catch (ResolveException re) {
            logger.error(re, "Error resolving DynamicCode with ID [", String.valueOf(id), "].");
            throw re;
        } catch (ServiceException se) {
            logger.error(se, "Error resolving DynamicCode with ID [", String.valueOf(id), "].");
            throw new ResolveException("Error resolving DynamicCode with ID [" + id + "].", se);
        } catch (Exception e) {
            logger.error(e, "Error resolving DynamicCode with ID [", String.valueOf(id), "].");
            throw new ResolveException("Unexpected error resolving DynamicCode with ID ["
                    + id + "].", e);
        }
    }

    /**
     * Resolves the Codes defined at the given path.
     * 
     * @param path
     *            the code path to resolve
     * 
     * @return the list of codes represented by the given code path
     * 
     * @throws ResolveException
     *             when the code cannot be resolved
     */
    public List<? extends Code> resolveByPath(String path) throws ResolveException {
        if (path == null) {
            return Collections.emptyList();
        }

        try {
            CodePathSearchMsg msg = new CodePathSearchMsg();
            msg.setCodePath(new CodePath(path));

            ServiceRequest<CodePathSearchMsg> rq = new ServiceRequest<CodePathSearchMsg>(
                    this.context);

            rq.setRequestMessage(msg);

            SearchDynamicCode searchService = this.component.getSearchDynamicCode();
            ServiceResponse<DynamicCodeCodeListMsg> rs = searchService.searchByCodePath(rq);

            return rs.getResponseMessage().getCodeList();

        } catch (ServiceException se) {
            logger.error(se, "Error resolving DynamicCodes for path [", path, "].");
            throw new ResolveException("Error resolving DynamicCodes for path [" + path + "].", se);
        } catch (Exception e) {
            logger.error(e, "Error resolving DynamicCodes for path [", path, "].");
            throw new ResolveException("Unexpected error resolving DynamicCodes for path ["
                    + path + "].", e);
        }
    }

}
