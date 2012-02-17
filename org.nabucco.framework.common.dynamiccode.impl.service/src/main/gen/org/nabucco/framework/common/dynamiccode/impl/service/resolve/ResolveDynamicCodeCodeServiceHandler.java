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
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;

/**
 * ResolveDynamicCodeCodeServiceHandler<p/>Resolution Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public abstract class ResolveDynamicCodeCodeServiceHandler extends PersistenceServiceHandlerSupport implements
        ServiceHandler, PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.resolve.ResolveDynamicCodeCodeServiceHandler";

    /** Constructs a new ResolveDynamicCodeCodeServiceHandler instance. */
    public ResolveDynamicCodeCodeServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeResolveRq>.
     * @return the ServiceResponse<DynamicCodeCodeResolveRs>.
     * @throws ResolveException
     */
    protected ServiceResponse<DynamicCodeCodeResolveRs> invoke(ServiceRequest<DynamicCodeCodeResolveRq> rq)
            throws ResolveException {
        ServiceResponse<DynamicCodeCodeResolveRs> rs;
        DynamicCodeCodeResolveRs msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.resolveDynamicCodeCode(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeResolveRs>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ResolveException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ResolveException wrappedException = new ResolveException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ResolveException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method resolveDynamicCodeCode.
     *
     * @param msg the DynamicCodeCodeResolveRq.
     * @return the DynamicCodeCodeResolveRs.
     * @throws ResolveException
     */
    protected abstract DynamicCodeCodeResolveRs resolveDynamicCodeCode(DynamicCodeCodeResolveRq msg)
            throws ResolveException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
