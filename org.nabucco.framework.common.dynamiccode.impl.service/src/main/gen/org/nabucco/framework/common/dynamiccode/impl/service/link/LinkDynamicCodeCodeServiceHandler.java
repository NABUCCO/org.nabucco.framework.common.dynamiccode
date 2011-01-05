/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.link;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.LinkException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;

/**
 * LinkDynamicCodeCodeServiceHandler<p/>Linkage Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public abstract class LinkDynamicCodeCodeServiceHandler extends ServiceHandlerSupport implements
        ServiceHandler {

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
    protected ServiceResponse<DynamicCodeCodeListMsg> invoke(
            ServiceRequest<DynamicCodeCodeListMsg> rq) throws LinkException {
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
            throw new LinkException(e.getMessage());
        }
    }

    /**
     * Missing description at method linkDynamicCodeCode.
     *
     * @param msg the DynamicCodeCodeListMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws LinkException
     */
    protected abstract DynamicCodeCodeListMsg linkDynamicCodeCode(DynamicCodeCodeListMsg msg)
            throws LinkException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
