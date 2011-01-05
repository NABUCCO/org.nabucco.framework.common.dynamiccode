/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.resolve;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;

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
     * @throws ClientException
     */
    public DynamicCodeCodeResolveRs resolveDynamicCodeCode(DynamicCodeCodeResolveRq rq)
            throws ClientException {
        ServiceRequest<DynamicCodeCodeResolveRq> request = new ServiceRequest<DynamicCodeCodeResolveRq>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeResolveRs> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.resolveDynamicCodeCode(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ResolveDynamicCodeDelegate.class, "Service: ",
                                "ResolveDynamicCode.resolveDynamicCodeCode", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCode");
    }

    /**
     * ResolveDynamicCodeCodeGroup.
     *
     * @param rq the DynamicCodeCodeGroupResolveRq.
     * @return the DynamicCodeCodeGroupResolveRs.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupResolveRs resolveDynamicCodeCodeGroup(
            DynamicCodeCodeGroupResolveRq rq) throws ClientException {
        ServiceRequest<DynamicCodeCodeGroupResolveRq> request = new ServiceRequest<DynamicCodeCodeGroupResolveRq>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupResolveRs> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.resolveDynamicCodeCodeGroup(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ResolveDynamicCodeDelegate.class, "Service: ",
                                "ResolveDynamicCode.resolveDynamicCodeCodeGroup", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ResolveDynamicCode.resolveDynamicCodeCodeGroup");
    }
}
