/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;

/**
 * ResolveDynamicCodeImpl<p/>Resolution Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public class ResolveDynamicCodeImpl extends ServiceSupport implements ResolveDynamicCode {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolveDynamicCode";

    private EntityManager entityManager;

    private ResolveDynamicCodeCodeServiceHandler resolveDynamicCodeCodeServiceHandler;

    private ResolveDynamicCodeCodeGroupServiceHandler resolveDynamicCodeCodeGroupServiceHandler;

    /** Constructs a new ResolveDynamicCodeImpl instance. */
    public ResolveDynamicCodeImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.resolveDynamicCodeCodeServiceHandler = injector
                .inject(ResolveDynamicCodeCodeServiceHandler.getId());
        if ((this.resolveDynamicCodeCodeServiceHandler != null)) {
            this.resolveDynamicCodeCodeServiceHandler.setEntityManager(this.entityManager);
            this.resolveDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDynamicCodeCodeGroupServiceHandler = injector
                .inject(ResolveDynamicCodeCodeGroupServiceHandler.getId());
        if ((this.resolveDynamicCodeCodeGroupServiceHandler != null)) {
            this.resolveDynamicCodeCodeGroupServiceHandler.setEntityManager(this.entityManager);
            this.resolveDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<DynamicCodeCodeResolveRs> resolveDynamicCodeCode(
            ServiceRequest<DynamicCodeCodeResolveRq> rq) throws ResolveException {
        if ((this.resolveDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for resolveDynamicCodeCode().");
            throw new InjectionException(
                    "No service implementation configured for resolveDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeResolveRs> rs;
        this.resolveDynamicCodeCodeServiceHandler.init();
        rs = this.resolveDynamicCodeCodeServiceHandler.invoke(rq);
        this.resolveDynamicCodeCodeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupResolveRs> resolveDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupResolveRq> rq) throws ResolveException {
        if ((this.resolveDynamicCodeCodeGroupServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for resolveDynamicCodeCodeGroup().");
            throw new InjectionException(
                    "No service implementation configured for resolveDynamicCodeCodeGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupResolveRs> rs;
        this.resolveDynamicCodeCodeGroupServiceHandler.init();
        rs = this.resolveDynamicCodeCodeGroupServiceHandler.invoke(rq);
        this.resolveDynamicCodeCodeGroupServiceHandler.finish();
        return rs;
    }
}
