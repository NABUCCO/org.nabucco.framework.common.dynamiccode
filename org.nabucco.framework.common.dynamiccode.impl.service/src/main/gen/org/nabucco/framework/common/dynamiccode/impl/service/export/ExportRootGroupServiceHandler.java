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
package org.nabucco.framework.common.dynamiccode.impl.service.export;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;

/**
 * ExportRootGroupServiceHandler<p/>Service to export Dynamic Code<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2011-01-26
 */
public abstract class ExportRootGroupServiceHandler extends PersistenceServiceHandlerSupport implements ServiceHandler,
        PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.export.ExportRootGroupServiceHandler";

    /** Constructs a new ExportRootGroupServiceHandler instance. */
    public ExportRootGroupServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMsg>.
     * @throws ExportException
     */
    protected ServiceResponse<DynamicCodeCodeGroupMsg> invoke(ServiceRequest<EmptyServiceMessage> rq)
            throws ExportException {
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        DynamicCodeCodeGroupMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.exportRootGroup(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeGroupMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ExportException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ExportException wrappedException = new ExportException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ExportException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method exportRootGroup.
     *
     * @param msg the EmptyServiceMessage.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ExportException
     */
    protected abstract DynamicCodeCodeGroupMsg exportRootGroup(EmptyServiceMessage msg) throws ExportException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
