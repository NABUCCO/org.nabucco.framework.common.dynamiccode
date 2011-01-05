/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;

/**
 * ProduceDynamicCodeDelegate<p/>Produce Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-29
 */
public class ProduceDynamicCodeDelegate extends ServiceDelegateSupport {

    private ProduceDynamicCode service;

    /**
     * Constructs a new ProduceDynamicCodeDelegate instance.
     *
     * @param service the ProduceDynamicCode.
     */
    public ProduceDynamicCodeDelegate(ProduceDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * ProduceDynamicCodeCodeGroup.
     *
     * @param rq the EmptyServiceMessage.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ProduceException
     */
    public DynamicCodeCodeGroupMsg produceDynamicCodeCodeGroup(EmptyServiceMessage rq)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        if ((service != null)) {
            rs = service.produceDynamicCodeCodeGroup(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceDynamicCodeCodeGroup.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the DynamicCodeCodeGroupMsg.
     * @throws ProduceException
     */
    public DynamicCodeCodeGroupMsg produceDynamicCodeCodeGroup(EmptyServiceMessage rq,
            Subject subject) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        if ((service != null)) {
            rs = service.produceDynamicCodeCodeGroup(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceDynamicCodeCode.
     *
     * @param rq the EmptyServiceMessage.
     * @return the DynamicCodeCodeMsg.
     * @throws ProduceException
     */
    public DynamicCodeCodeMsg produceDynamicCodeCode(EmptyServiceMessage rq)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeMsg> rs;
        if ((service != null)) {
            rs = service.produceDynamicCodeCode(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceDynamicCodeCode.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the DynamicCodeCodeMsg.
     * @throws ProduceException
     */
    public DynamicCodeCodeMsg produceDynamicCodeCode(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeMsg> rs;
        if ((service != null)) {
            rs = service.produceDynamicCodeCode(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }
}
