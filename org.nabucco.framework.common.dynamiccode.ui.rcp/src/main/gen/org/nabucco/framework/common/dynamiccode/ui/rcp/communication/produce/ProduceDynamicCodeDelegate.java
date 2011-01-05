/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.produce;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;

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
     * @throws ClientException
     */
    public DynamicCodeCodeGroupMsg produceDynamicCodeCodeGroup(EmptyServiceMessage rq)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceDynamicCodeCodeGroup(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceDynamicCodeDelegate.class, "Service: ",
                                "ProduceDynamicCode.produceDynamicCodeCodeGroup", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCodeGroup");
    }

    /**
     * ProduceDynamicCodeCode.
     *
     * @param rq the EmptyServiceMessage.
     * @return the DynamicCodeCodeMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeMsg produceDynamicCodeCode(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceDynamicCodeCode(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceDynamicCodeDelegate.class, "Service: ",
                                "ProduceDynamicCode.produceDynamicCodeCode", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceDynamicCode.produceDynamicCodeCode");
    }
}
