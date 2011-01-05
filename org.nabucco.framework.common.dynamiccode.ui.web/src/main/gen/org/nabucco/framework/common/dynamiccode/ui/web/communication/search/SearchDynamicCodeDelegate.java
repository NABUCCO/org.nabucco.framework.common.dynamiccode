/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.web.communication.search;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;

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
     * @throws SearchException
     */
    public DynamicCodeCodeListMsg searchDynamicCodeCode(DynamicCodeCodeSearchMsg rq)
            throws SearchException {
        ServiceRequest<DynamicCodeCodeSearchMsg> request = new ServiceRequest<DynamicCodeCodeSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            rs = service.searchDynamicCodeCode(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchDynamicCodeCode.
     *
     * @param subject the Subject.
     * @param rq the DynamicCodeCodeSearchMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws SearchException
     */
    public DynamicCodeCodeListMsg searchDynamicCodeCode(DynamicCodeCodeSearchMsg rq, Subject subject)
            throws SearchException {
        ServiceRequest<DynamicCodeCodeSearchMsg> request = new ServiceRequest<DynamicCodeCodeSearchMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            rs = service.searchDynamicCodeCode(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCode");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchDynamicCodeCodeGroup.
     *
     * @param rq the DynamicCodeCodeGroupSearchMsg.
     * @return the DynamicCodeCodeGroupListMsg.
     * @throws SearchException
     */
    public DynamicCodeCodeGroupListMsg searchDynamicCodeCodeGroup(DynamicCodeCodeGroupSearchMsg rq)
            throws SearchException {
        ServiceRequest<DynamicCodeCodeGroupSearchMsg> request = new ServiceRequest<DynamicCodeCodeGroupSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupListMsg> rs;
        if ((service != null)) {
            rs = service.searchDynamicCodeCodeGroup(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchDynamicCodeCodeGroup.
     *
     * @param subject the Subject.
     * @param rq the DynamicCodeCodeGroupSearchMsg.
     * @return the DynamicCodeCodeGroupListMsg.
     * @throws SearchException
     */
    public DynamicCodeCodeGroupListMsg searchDynamicCodeCodeGroup(DynamicCodeCodeGroupSearchMsg rq,
            Subject subject) throws SearchException {
        ServiceRequest<DynamicCodeCodeGroupSearchMsg> request = new ServiceRequest<DynamicCodeCodeGroupSearchMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeGroupListMsg> rs;
        if ((service != null)) {
            rs = service.searchDynamicCodeCodeGroup(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchDynamicCode.searchDynamicCodeCodeGroup");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchByCodePath.
     *
     * @param rq the CodePathSearchMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws SearchException
     */
    public DynamicCodeCodeListMsg searchByCodePath(CodePathSearchMsg rq) throws SearchException {
        ServiceRequest<CodePathSearchMsg> request = new ServiceRequest<CodePathSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            rs = service.searchByCodePath(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchDynamicCode.searchByCodePath");
        }
        return rs.getResponseMessage();
    }

    /**
     * SearchByCodePath.
     *
     * @param subject the Subject.
     * @param rq the CodePathSearchMsg.
     * @return the DynamicCodeCodeListMsg.
     * @throws SearchException
     */
    public DynamicCodeCodeListMsg searchByCodePath(CodePathSearchMsg rq, Subject subject)
            throws SearchException {
        ServiceRequest<CodePathSearchMsg> request = new ServiceRequest<CodePathSearchMsg>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        if ((service != null)) {
            rs = service.searchByCodePath(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchDynamicCode.searchByCodePath");
        }
        return rs.getResponseMessage();
    }
}
