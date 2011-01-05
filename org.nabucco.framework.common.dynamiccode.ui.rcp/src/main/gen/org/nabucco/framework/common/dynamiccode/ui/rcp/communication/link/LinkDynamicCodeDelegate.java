/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.link;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;

/**
 * LinkDynamicCodeDelegate<p/>Linkage Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class LinkDynamicCodeDelegate extends ServiceDelegateSupport {

    private LinkDynamicCode service;

    /**
     * Constructs a new LinkDynamicCodeDelegate instance.
     *
     * @param service the LinkDynamicCode.
     */
    public LinkDynamicCodeDelegate(LinkDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * LinkDynamicCodeCode.
     *
     * @param rq the DynamicCodeCodeListMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeListMsg linkDynamicCodeCode(DynamicCodeCodeListMsg rq)
            throws ClientException {
        ServiceRequest<DynamicCodeCodeListMsg> request = new ServiceRequest<DynamicCodeCodeListMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.linkDynamicCodeCode(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(LinkDynamicCodeDelegate.class, "Service: ",
                                "LinkDynamicCode.linkDynamicCodeCode", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: LinkDynamicCode.linkDynamicCodeCode");
    }
}
