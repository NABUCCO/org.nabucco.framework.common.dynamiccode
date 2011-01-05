/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.search;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;

/**
 * SearchDynamicCodeCodeGroupServiceHandler<p/>Search Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public abstract class SearchDynamicCodeCodeGroupServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.search.SearchDynamicCodeCodeGroupServiceHandler";

    /** Constructs a new SearchDynamicCodeCodeGroupServiceHandler instance. */
    public SearchDynamicCodeCodeGroupServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupSearchMsg>.
     * @return the ServiceResponse<DynamicCodeCodeGroupListMsg>.
     * @throws SearchException
     */
    protected ServiceResponse<DynamicCodeCodeGroupListMsg> invoke(
            ServiceRequest<DynamicCodeCodeGroupSearchMsg> rq) throws SearchException {
        ServiceResponse<DynamicCodeCodeGroupListMsg> rs;
        DynamicCodeCodeGroupListMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.searchDynamicCodeCodeGroup(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<DynamicCodeCodeGroupListMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (SearchException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            SearchException wrappedException = new SearchException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new SearchException(e.getMessage());
        }
    }

    /**
     * Missing description at method searchDynamicCodeCodeGroup.
     *
     * @param msg the DynamicCodeCodeGroupSearchMsg.
     * @return the DynamicCodeCodeGroupListMsg.
     * @throws SearchException
     */
    protected abstract DynamicCodeCodeGroupListMsg searchDynamicCodeCodeGroup(
            DynamicCodeCodeGroupSearchMsg msg) throws SearchException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
