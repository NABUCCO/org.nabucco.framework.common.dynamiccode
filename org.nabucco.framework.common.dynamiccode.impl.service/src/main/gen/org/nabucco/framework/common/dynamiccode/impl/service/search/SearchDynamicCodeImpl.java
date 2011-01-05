/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.search;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;

/**
 * SearchDynamicCodeImpl<p/>Search Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class SearchDynamicCodeImpl extends ServiceSupport implements SearchDynamicCode {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchDynamicCode";

    private EntityManager entityManager;

    private SearchDynamicCodeCodeServiceHandler searchDynamicCodeCodeServiceHandler;

    private SearchDynamicCodeCodeGroupServiceHandler searchDynamicCodeCodeGroupServiceHandler;

    private SearchByCodePathServiceHandler searchByCodePathServiceHandler;

    /** Constructs a new SearchDynamicCodeImpl instance. */
    public SearchDynamicCodeImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.searchDynamicCodeCodeServiceHandler = injector
                .inject(SearchDynamicCodeCodeServiceHandler.getId());
        if ((this.searchDynamicCodeCodeServiceHandler != null)) {
            this.searchDynamicCodeCodeServiceHandler.setEntityManager(this.entityManager);
            this.searchDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
        }
        this.searchDynamicCodeCodeGroupServiceHandler = injector
                .inject(SearchDynamicCodeCodeGroupServiceHandler.getId());
        if ((this.searchDynamicCodeCodeGroupServiceHandler != null)) {
            this.searchDynamicCodeCodeGroupServiceHandler.setEntityManager(this.entityManager);
            this.searchDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
        this.searchByCodePathServiceHandler = injector.inject(SearchByCodePathServiceHandler
                .getId());
        if ((this.searchByCodePathServiceHandler != null)) {
            this.searchByCodePathServiceHandler.setEntityManager(this.entityManager);
            this.searchByCodePathServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<DynamicCodeCodeListMsg> searchDynamicCodeCode(
            ServiceRequest<DynamicCodeCodeSearchMsg> rq) throws SearchException {
        if ((this.searchDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchDynamicCodeCode().");
            throw new InjectionException(
                    "No service implementation configured for searchDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        this.searchDynamicCodeCodeServiceHandler.init();
        rs = this.searchDynamicCodeCodeServiceHandler.invoke(rq);
        this.searchDynamicCodeCodeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupListMsg> searchDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupSearchMsg> rq) throws SearchException {
        if ((this.searchDynamicCodeCodeGroupServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchDynamicCodeCodeGroup().");
            throw new InjectionException(
                    "No service implementation configured for searchDynamicCodeCodeGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupListMsg> rs;
        this.searchDynamicCodeCodeGroupServiceHandler.init();
        rs = this.searchDynamicCodeCodeGroupServiceHandler.invoke(rq);
        this.searchDynamicCodeCodeGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeListMsg> searchByCodePath(
            ServiceRequest<CodePathSearchMsg> rq) throws SearchException {
        if ((this.searchByCodePathServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchByCodePath().");
            throw new InjectionException(
                    "No service implementation configured for searchByCodePath().");
        }
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        this.searchByCodePathServiceHandler.init();
        rs = this.searchByCodePathServiceHandler.invoke(rq);
        this.searchByCodePathServiceHandler.finish();
        return rs;
    }
}
