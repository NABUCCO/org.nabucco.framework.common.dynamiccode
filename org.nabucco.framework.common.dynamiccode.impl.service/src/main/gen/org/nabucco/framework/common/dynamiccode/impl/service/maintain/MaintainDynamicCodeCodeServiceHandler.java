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
package org.nabucco.framework.common.dynamiccode.impl.service.maintain;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;

/**
 * MaintainDynamicCodeCodeServiceHandler<p/>Maintain Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-01-15
 */
public abstract class MaintainDynamicCodeCodeServiceHandler extends PersistenceServiceHandlerSupport implements
        ServiceHandler, PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.maintain.MaintainDynamicCodeCodeServiceHandler";

    /** Constructs a new MaintainDynamicCodeCodeServiceHandler instance. */
    public MaintainDynamicCodeCodeServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeMaintainMsg>.
     * @return the ServiceResponse<DynamicCodeCodeMaintainMsg>.
     * @throws MaintainException
     */
    protected ServiceResponse<DynamicCodeCodeMaintainMsg> invoke(ServiceRequest<DynamicCodeCodeMaintainMsg> rq)
            throws MaintainException {
        ServiceResponse<DynamicCodeCodeMaintainMsg> rs;
        DynamicCodeCodeMaintainMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.maintainDynamicCodeCode(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeMaintainMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (MaintainException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            MaintainException wrappedException = new MaintainException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new MaintainException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method maintainDynamicCodeCode.
     *
     * @param msg the DynamicCodeCodeMaintainMsg.
     * @return the DynamicCodeCodeMaintainMsg.
     * @throws MaintainException
     */
    protected abstract DynamicCodeCodeMaintainMsg maintainDynamicCodeCode(DynamicCodeCodeMaintainMsg msg)
            throws MaintainException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
