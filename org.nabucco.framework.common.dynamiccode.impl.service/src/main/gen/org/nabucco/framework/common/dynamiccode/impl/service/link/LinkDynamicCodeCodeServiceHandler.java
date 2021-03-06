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
package org.nabucco.framework.common.dynamiccode.impl.service.link;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.LinkException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;

/**
 * LinkDynamicCodeCodeServiceHandler<p/>Linkage Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public abstract class LinkDynamicCodeCodeServiceHandler extends PersistenceServiceHandlerSupport implements
        ServiceHandler, PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.link.LinkDynamicCodeCodeServiceHandler";

    /** Constructs a new LinkDynamicCodeCodeServiceHandler instance. */
    public LinkDynamicCodeCodeServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeListMsg>.
     * @return the ServiceResponse<DynamicCodeCodeListMsg>.
     * @throws LinkException
     */
    protected ServiceResponse<DynamicCodeCodeListMsg> invoke(ServiceRequest<DynamicCodeCodeListMsg> rq)
            throws LinkException {
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        DynamicCodeCodeListMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.linkDynamicCodeCode(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeListMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (LinkException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            LinkException wrappedException = new LinkException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new LinkException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method linkDynamicCodeCode.
     *
     * @param msg the DynamicCodeCodeListMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws LinkException
     */
    protected abstract DynamicCodeCodeListMsg linkDynamicCodeCode(DynamicCodeCodeListMsg msg) throws LinkException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
