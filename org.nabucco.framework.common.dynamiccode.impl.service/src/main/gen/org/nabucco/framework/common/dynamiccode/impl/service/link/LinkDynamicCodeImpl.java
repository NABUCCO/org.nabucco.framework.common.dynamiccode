/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.link;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.LinkException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;

/**
 * LinkDynamicCodeImpl<p/>Linkage Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class LinkDynamicCodeImpl extends ServiceSupport implements LinkDynamicCode {

    private static final long serialVersionUID = 1L;

    private static final String ID = "LinkDynamicCode";

    private EntityManager entityManager;

    private LinkDynamicCodeCodeServiceHandler linkDynamicCodeCodeServiceHandler;

    /** Constructs a new LinkDynamicCodeImpl instance. */
    public LinkDynamicCodeImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.linkDynamicCodeCodeServiceHandler = injector.inject(LinkDynamicCodeCodeServiceHandler
                .getId());
        if ((this.linkDynamicCodeCodeServiceHandler != null)) {
            this.linkDynamicCodeCodeServiceHandler.setEntityManager(this.entityManager);
            this.linkDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<DynamicCodeCodeListMsg> linkDynamicCodeCode(
            ServiceRequest<DynamicCodeCodeListMsg> rq) throws LinkException {
        if ((this.linkDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for linkDynamicCodeCode().");
            throw new InjectionException(
                    "No service implementation configured for linkDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        this.linkDynamicCodeCodeServiceHandler.init();
        rs = this.linkDynamicCodeCodeServiceHandler.invoke(rq);
        this.linkDynamicCodeCodeServiceHandler.finish();
        return rs;
    }
}
