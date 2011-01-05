/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.web.communication.resolve;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;

/**
 * ResolveDynamicCodeDelegate<p/>Resolution Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public class ResolveDynamicCodeDelegate extends ServiceDelegateSupport {

    private ResolveDynamicCode service;

    /**
     * Constructs a new ResolveDynamicCodeDelegate instance.
     *
     * @param service the ResolveDynamicCode.
     */
    public ResolveDynamicCodeDelegate(ResolveDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * ResolveDynamicCodeCode.
     *
     * @param rq the DynamicCodeCodeResolveRq.
     * @return the DynamicCodeCodeResolveRs.
     * @throws ResolveException
     */
    public DynamicCodeCodeResolveRs resolveDynamicCodeCode(DynamicCodeCodeResolveRq rq)
            throws ResolveException {
        ServiceRequest<DynamicCodeCodeResolveRq> request = new ServiceRequest<DynamicCodeCodeResolveRq>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeResolveRs> rs;
        if ((service != null)) {
            rs = service.resolveDynamicCodeCode(request);
        } else {
            throw new ResolveException(
                    "Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }

    /**
     * ResolveDynamicCodeCode.
     *
     * @param subject the Subject.
     * @param rq the DynamicCodeCodeResolveRq.
     * @return the DynamicCodeCodeResolveRs.
     * @throws ResolveException
     */
    public DynamicCodeCodeResolveRs resolveDynamicCodeCode(DynamicCodeCodeResolveRq rq,
            Subject subject) throws ResolveException {
        ServiceRequest<DynamicCodeCodeResolveRq> request = new ServiceRequest<DynamicCodeCodeResolveRq>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeResolveRs> rs;
        if ((service != null)) {
            rs = service.resolveDynamicCodeCode(request);
        } else {
            throw new ResolveException(
                    "Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }

    /**
     * ResolveDynamicCodeCodeGroup.
     *
     * @param rq the DynamicCodeCodeGroupResolveRq.
     * @return the DynamicCodeCodeGroupResolveRs.
     * @throws ResolveException
     */
    public DynamicCodeCodeGroupResolveRs resolveDynamicCodeCodeGroup(
            DynamicCodeCodeGroupResolveRq rq) throws ResolveException {
        ServiceRequest<DynamicCodeCodeGroupResolveRq> request = new ServiceRequest<DynamicCodeCodeGroupResolveRq>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupResolveRs> rs;
        if ((service != null)) {
            rs = service.resolveDynamicCodeCodeGroup(request);
        } else {
            throw new ResolveException(
                    "Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }

    /**
     * ResolveDynamicCodeCodeGroup.
     *
     * @param subject the Subject.
     * @param rq the DynamicCodeCodeGroupResolveRq.
     * @return the DynamicCodeCodeGroupResolveRs.
     * @throws ResolveException
     */
    public DynamicCodeCodeGroupResolveRs resolveDynamicCodeCodeGroup(
            DynamicCodeCodeGroupResolveRq rq, Subject subject) throws ResolveException {
        ServiceRequest<DynamicCodeCodeGroupResolveRq> request = new ServiceRequest<DynamicCodeCodeGroupResolveRq>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupResolveRs> rs;
        if ((service != null)) {
            rs = service.resolveDynamicCodeCodeGroup(request);
        } else {
            throw new ResolveException(
                    "Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }
}
