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
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;

/**
 * MaintainDynamicCodeCodeGroupServiceHandler<p/>Maintain Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-01-15
 */
public abstract class MaintainDynamicCodeCodeGroupServiceHandler extends PersistenceServiceHandlerSupport implements
        ServiceHandler, PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.maintain.MaintainDynamicCodeCodeGroupServiceHandler";

    /** Constructs a new MaintainDynamicCodeCodeGroupServiceHandler instance. */
    public MaintainDynamicCodeCodeGroupServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupMaintainMsg>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMaintainMsg>.
     * @throws MaintainException
     */
    protected ServiceResponse<DynamicCodeCodeGroupMaintainMsg> invoke(ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq)
            throws MaintainException {
        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs;
        DynamicCodeCodeGroupMaintainMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.maintainDynamicCodeCodeGroup(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeGroupMaintainMsg>(rq.getContext());
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
     * Missing description at method maintainDynamicCodeCodeGroup.
     *
     * @param msg the DynamicCodeCodeGroupMaintainMsg.
     * @return the DynamicCodeCodeGroupMaintainMsg.
     * @throws MaintainException
     */
    protected abstract DynamicCodeCodeGroupMaintainMsg maintainDynamicCodeCodeGroup(DynamicCodeCodeGroupMaintainMsg msg)
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
