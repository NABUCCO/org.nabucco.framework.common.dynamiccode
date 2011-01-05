/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.produce;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;

/**
 * ProduceDynamicCodeCodeGroupServiceHandler<p/>Produce Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-29
 */
public abstract class ProduceDynamicCodeCodeGroupServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.produce.ProduceDynamicCodeCodeGroupServiceHandler";

    /** Constructs a new ProduceDynamicCodeCodeGroupServiceHandler instance. */
    public ProduceDynamicCodeCodeGroupServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<DynamicCodeCodeGroupMsg> invoke(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        DynamicCodeCodeGroupMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceDynamicCodeCodeGroup(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeGroupMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ProduceException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ProduceException wrappedException = new ProduceException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ProduceException(e.getMessage());
        }
    }

    /**
     * Creates a new DynamicCodeCodeGroup.
     *
     * @param msg the EmptyServiceMessage.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ProduceException
     */
    protected abstract DynamicCodeCodeGroupMsg produceDynamicCodeCodeGroup(EmptyServiceMessage msg)
            throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
