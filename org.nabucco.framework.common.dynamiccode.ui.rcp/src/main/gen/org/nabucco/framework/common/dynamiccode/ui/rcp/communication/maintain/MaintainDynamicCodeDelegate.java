/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.maintain;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;

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
     * @throws ClientException
     */
    public DynamicCodeCodeGroupMaintainMsg maintainDynamicCodeCodeGroup(
            DynamicCodeCodeGroupMaintainMsg rq) throws ClientException {
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> request = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.maintainDynamicCodeCodeGroup(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(MaintainDynamicCodeDelegate.class, "Service: ",
                                "MaintainDynamicCode.maintainDynamicCodeCodeGroup", " Time: ",
                                String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCodeGroup");
    }

    /**
     * MaintainDynamicCodeCode.
     *
     * @param rq the DynamicCodeCodeMaintainMsg.
     * @return the DynamicCodeCodeMaintainMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeMaintainMsg maintainDynamicCodeCode(DynamicCodeCodeMaintainMsg rq)
            throws ClientException {
        ServiceRequest<DynamicCodeCodeMaintainMsg> request = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeMaintainMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.maintainDynamicCodeCode(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(MaintainDynamicCodeDelegate.class, "Service: ",
                                "MaintainDynamicCode.maintainDynamicCodeCode", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: MaintainDynamicCode.maintainDynamicCodeCode");
    }
}
