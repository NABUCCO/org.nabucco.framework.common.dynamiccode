/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.web.communication.maintain;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;

/**
 * MaintainDynamicCodeDelegate<p/>Maintain Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-01-15
 */
public class MaintainDynamicCodeDelegate extends ServiceDelegateSupport {

    private MaintainDynamicCode service;

    /**
     * Constructs a new MaintainDynamicCodeDelegate instance.
     *
     * @param service the MaintainDynamicCode.
     */
    public MaintainDynamicCodeDelegate(MaintainDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * MaintainDynamicCodeCodeGroup.
     *
     * @param rq the DynamicCodeCodeGroupMaintainMsg.
     * @return the DynamicCodeCodeGroupMaintainMsg.
     * @throws MaintainException
     */
    public DynamicCodeCodeGroupMaintainMsg maintainDynamicCodeCodeGroup(
            DynamicCodeCodeGroupMaintainMsg rq) throws MaintainException {
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> request = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs;
        if ((service != null)) {
            rs = service.maintainDynamicCodeCodeGroup(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }

    /**
     * MaintainDynamicCodeCodeGroup.
     *
     * @param subject the Subject.
     * @param rq the DynamicCodeCodeGroupMaintainMsg.
     * @return the DynamicCodeCodeGroupMaintainMsg.
     * @throws MaintainException
     */
    public DynamicCodeCodeGroupMaintainMsg maintainDynamicCodeCodeGroup(
            DynamicCodeCodeGroupMaintainMsg rq, Subject subject) throws MaintainException {
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> request = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs;
        if ((service != null)) {
            rs = service.maintainDynamicCodeCodeGroup(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }

    /**
     * MaintainDynamicCodeCode.
     *
     * @param rq the DynamicCodeCodeMaintainMsg.
     * @return the DynamicCodeCodeMaintainMsg.
     * @throws MaintainException
     */
    public DynamicCodeCodeMaintainMsg maintainDynamicCodeCode(DynamicCodeCodeMaintainMsg rq)
            throws MaintainException {
        ServiceRequest<DynamicCodeCodeMaintainMsg> request = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeMaintainMsg> rs;
        if ((service != null)) {
            rs = service.maintainDynamicCodeCode(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }

    /**
     * MaintainDynamicCodeCode.
     *
     * @param subject the Subject.
     * @param rq the DynamicCodeCodeMaintainMsg.
     * @return the DynamicCodeCodeMaintainMsg.
     * @throws MaintainException
     */
    public DynamicCodeCodeMaintainMsg maintainDynamicCodeCode(DynamicCodeCodeMaintainMsg rq,
            Subject subject) throws MaintainException {
        ServiceRequest<DynamicCodeCodeMaintainMsg> request = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeMaintainMsg> rs;
        if ((service != null)) {
            rs = service.maintainDynamicCodeCode(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }
}
