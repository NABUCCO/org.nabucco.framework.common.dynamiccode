/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.web.communication.link;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.LinkException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;

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
     * @throws LinkException
     */
    public DynamicCodeCodeListMsg linkDynamicCodeCode(DynamicCodeCodeListMsg rq)
            throws LinkException {
        ServiceRequest<DynamicCodeCodeListMsg> request = new ServiceRequest<DynamicCodeCodeListMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            rs = service.linkDynamicCodeCode(request);
        } else {
            throw new LinkException(
                    "Cannot execute service operation: LinkDynamicCode.linkDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }

    /**
     * LinkDynamicCodeCode.
     *
     * @param subject the Subject.
     * @param rq the DynamicCodeCodeListMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws LinkException
     */
    public DynamicCodeCodeListMsg linkDynamicCodeCode(DynamicCodeCodeListMsg rq, Subject subject)
            throws LinkException {
        ServiceRequest<DynamicCodeCodeListMsg> request = new ServiceRequest<DynamicCodeCodeListMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            rs = service.linkDynamicCodeCode(request);
        } else {
            throw new LinkException(
                    "Cannot execute service operation: LinkDynamicCode.linkDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }
}
