/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;

/**
 * SearchDynamicCodeDelegate<p/>Search Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class SearchDynamicCodeDelegate extends ServiceDelegateSupport {

    private SearchDynamicCode service;

    /**
     * Constructs a new SearchDynamicCodeDelegate instance.
     *
     * @param service the SearchDynamicCode.
     */
    public SearchDynamicCodeDelegate(SearchDynamicCode service) {
        super();
        this.service = service;
    }

    /**
     * SearchDynamicCodeCode.
     *
     * @param rq the DynamicCodeCodeSearchMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeListMsg searchDynamicCodeCode(DynamicCodeCodeSearchMsg rq)
            throws ClientException {
        ServiceRequest<DynamicCodeCodeSearchMsg> request = new ServiceRequest<DynamicCodeCodeSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchDynamicCodeCode(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchDynamicCodeDelegate.class, "Service: ",
                                "SearchDynamicCode.searchDynamicCodeCode", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCode");
    }

    /**
     * SearchDynamicCodeCodeGroup.
     *
     * @param rq the DynamicCodeCodeGroupSearchMsg.
     * @return the DynamicCodeCodeGroupListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeGroupListMsg searchDynamicCodeCodeGroup(DynamicCodeCodeGroupSearchMsg rq)
            throws ClientException {
        ServiceRequest<DynamicCodeCodeGroupSearchMsg> request = new ServiceRequest<DynamicCodeCodeGroupSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchDynamicCodeCodeGroup(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchDynamicCodeDelegate.class, "Service: ",
                                "SearchDynamicCode.searchDynamicCodeCodeGroup", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCodeGroup");
    }

    /**
     * SearchByCodePath.
     *
     * @param rq the CodePathSearchMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws ClientException
     */
    public DynamicCodeCodeListMsg searchByCodePath(CodePathSearchMsg rq) throws ClientException {
        ServiceRequest<CodePathSearchMsg> request = new ServiceRequest<CodePathSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchByCodePath(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchDynamicCodeDelegate.class, "Service: ",
                                "SearchDynamicCode.searchByCodePath", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchDynamicCode.searchByCodePath");
    }
}
