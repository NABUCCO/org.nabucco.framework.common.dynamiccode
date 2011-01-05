/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;

/**
 * ResolveDynamicCodeCodeGroupServiceHandler<p/>Resolution Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public abstract class ResolveDynamicCodeCodeGroupServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.resolve.ResolveDynamicCodeCodeGroupServiceHandler";

    /** Constructs a new ResolveDynamicCodeCodeGroupServiceHandler instance. */
    public ResolveDynamicCodeCodeGroupServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupResolveRq>.
     * @return the ServiceResponse<DynamicCodeCodeGroupResolveRs>.
     * @throws ResolveException
     */
    protected ServiceResponse<DynamicCodeCodeGroupResolveRs> invoke(
            ServiceRequest<DynamicCodeCodeGroupResolveRq> rq) throws ResolveException {
        ServiceResponse<DynamicCodeCodeGroupResolveRs> rs;
        DynamicCodeCodeGroupResolveRs msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.resolveDynamicCodeCodeGroup(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeGroupResolveRs>(rq.getContext());
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
            throw new ResolveException(e.getMessage());
        }
    }

    /**
     * Missing description at method resolveDynamicCodeCodeGroup.
     *
     * @param msg the DynamicCodeCodeGroupResolveRq.
     * @return the DynamicCodeCodeGroupResolveRs.
     * @throws ResolveException
     */
    protected abstract DynamicCodeCodeGroupResolveRs resolveDynamicCodeCodeGroup(
            DynamicCodeCodeGroupResolveRq msg) throws ResolveException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
