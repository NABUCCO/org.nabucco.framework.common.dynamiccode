/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.maintain;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;

/**
 * MaintainDynamicCodeImpl<p/>Maintain Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-01-15
 */
public class MaintainDynamicCodeImpl extends ServiceSupport implements MaintainDynamicCode {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainDynamicCode";

    private EntityManager entityManager;

    private MaintainDynamicCodeCodeGroupServiceHandler maintainDynamicCodeCodeGroupServiceHandler;

    private MaintainDynamicCodeCodeServiceHandler maintainDynamicCodeCodeServiceHandler;

    /** Constructs a new MaintainDynamicCodeImpl instance. */
    public MaintainDynamicCodeImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.maintainDynamicCodeCodeGroupServiceHandler = injector
                .inject(MaintainDynamicCodeCodeGroupServiceHandler.getId());
        if ((this.maintainDynamicCodeCodeGroupServiceHandler != null)) {
            this.maintainDynamicCodeCodeGroupServiceHandler.setEntityManager(this.entityManager);
            this.maintainDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
        this.maintainDynamicCodeCodeServiceHandler = injector
                .inject(MaintainDynamicCodeCodeServiceHandler.getId());
        if ((this.maintainDynamicCodeCodeServiceHandler != null)) {
            this.maintainDynamicCodeCodeServiceHandler.setEntityManager(this.entityManager);
            this.maintainDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupMaintainMsg> maintainDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq) throws MaintainException {
        if ((this.maintainDynamicCodeCodeGroupServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for maintainDynamicCodeCodeGroup().");
            throw new InjectionException(
                    "No service implementation configured for maintainDynamicCodeCodeGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs;
        this.maintainDynamicCodeCodeGroupServiceHandler.init();
        rs = this.maintainDynamicCodeCodeGroupServiceHandler.invoke(rq);
        this.maintainDynamicCodeCodeGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeMaintainMsg> maintainDynamicCodeCode(
            ServiceRequest<DynamicCodeCodeMaintainMsg> rq) throws MaintainException {
        if ((this.maintainDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for maintainDynamicCodeCode().");
            throw new InjectionException(
                    "No service implementation configured for maintainDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeMaintainMsg> rs;
        this.maintainDynamicCodeCodeServiceHandler.init();
        rs = this.maintainDynamicCodeCodeServiceHandler.invoke(rq);
        this.maintainDynamicCodeCodeServiceHandler.finish();
        return rs;
    }
}
