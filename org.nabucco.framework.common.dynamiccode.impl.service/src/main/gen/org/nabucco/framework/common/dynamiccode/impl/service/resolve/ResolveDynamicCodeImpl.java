/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
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

    private static Map<String, String[]> ASPECTS;

    private ResolveDynamicCodeCodeServiceHandler resolveDynamicCodeCodeServiceHandler;

    private ResolveDynamicCodeCodeGroupServiceHandler resolveDynamicCodeCodeGroupServiceHandler;

    private ResolveAllServiceHandler resolveAllServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolveDynamicCodeImpl instance. */
    public ResolveDynamicCodeImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveDynamicCodeCodeServiceHandler = injector.inject(ResolveDynamicCodeCodeServiceHandler.getId());
        if ((this.resolveDynamicCodeCodeServiceHandler != null)) {
            this.resolveDynamicCodeCodeServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDynamicCodeCodeGroupServiceHandler = injector.inject(ResolveDynamicCodeCodeGroupServiceHandler
                .getId());
        if ((this.resolveDynamicCodeCodeGroupServiceHandler != null)) {
            this.resolveDynamicCodeCodeGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
        this.resolveAllServiceHandler = injector.inject(ResolveAllServiceHandler.getId());
        if ((this.resolveAllServiceHandler != null)) {
            this.resolveAllServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveAllServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("resolveDynamicCodeCode", NO_ASPECTS);
            ASPECTS.put("resolveDynamicCodeCodeGroup", NO_ASPECTS);
            ASPECTS.put("resolveAll", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<DynamicCodeCodeResolveRs> resolveDynamicCodeCode(ServiceRequest<DynamicCodeCodeResolveRq> rq)
            throws ResolveException {
        if ((this.resolveDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveDynamicCodeCode().");
            throw new InjectionException("No service implementation configured for resolveDynamicCodeCode().");
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
            super.getLogger().error("No service implementation configured for resolveDynamicCodeCodeGroup().");
            throw new InjectionException("No service implementation configured for resolveDynamicCodeCodeGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupResolveRs> rs;
        this.resolveDynamicCodeCodeGroupServiceHandler.init();
        rs = this.resolveDynamicCodeCodeGroupServiceHandler.invoke(rq);
        this.resolveDynamicCodeCodeGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupMsg> resolveAll(ServiceRequest<EmptyServiceMessage> rq)
            throws ResolveException {
        if ((this.resolveAllServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveAll().");
            throw new InjectionException("No service implementation configured for resolveAll().");
        }
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        this.resolveAllServiceHandler.init();
        rs = this.resolveAllServiceHandler.invoke(rq);
        this.resolveAllServiceHandler.finish();
        return rs;
    }
}
