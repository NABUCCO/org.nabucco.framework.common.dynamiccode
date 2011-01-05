/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;

/**
 * ProduceDynamicCodeImpl<p/>Produce Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-29
 */
public class ProduceDynamicCodeImpl extends ServiceSupport implements ProduceDynamicCode {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceDynamicCode";

    private ProduceDynamicCodeCodeGroupServiceHandler produceDynamicCodeCodeGroupServiceHandler;

    private ProduceDynamicCodeCodeServiceHandler produceDynamicCodeCodeServiceHandler;

    /** Constructs a new ProduceDynamicCodeImpl instance. */
    public ProduceDynamicCodeImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.produceDynamicCodeCodeGroupServiceHandler = injector
                .inject(ProduceDynamicCodeCodeGroupServiceHandler.getId());
        if ((this.produceDynamicCodeCodeGroupServiceHandler != null)) {
            this.produceDynamicCodeCodeGroupServiceHandler.setEntityManager(null);
            this.produceDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
        this.produceDynamicCodeCodeServiceHandler = injector
                .inject(ProduceDynamicCodeCodeServiceHandler.getId());
        if ((this.produceDynamicCodeCodeServiceHandler != null)) {
            this.produceDynamicCodeCodeServiceHandler.setEntityManager(null);
            this.produceDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupMsg> produceDynamicCodeCodeGroup(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceDynamicCodeCodeGroupServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceDynamicCodeCodeGroup().");
            throw new InjectionException(
                    "No service implementation configured for produceDynamicCodeCodeGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        this.produceDynamicCodeCodeGroupServiceHandler.init();
        rs = this.produceDynamicCodeCodeGroupServiceHandler.invoke(rq);
        this.produceDynamicCodeCodeGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeMsg> produceDynamicCodeCode(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceDynamicCodeCode().");
            throw new InjectionException(
                    "No service implementation configured for produceDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeMsg> rs;
        this.produceDynamicCodeCodeServiceHandler.init();
        rs = this.produceDynamicCodeCodeServiceHandler.invoke(rq);
        this.produceDynamicCodeCodeServiceHandler.finish();
        return rs;
    }
}
