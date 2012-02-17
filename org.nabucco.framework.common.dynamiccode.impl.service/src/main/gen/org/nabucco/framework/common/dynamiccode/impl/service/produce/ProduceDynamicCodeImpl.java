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
package org.nabucco.framework.common.dynamiccode.impl.service.produce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
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

    private static Map<String, String[]> ASPECTS;

    private ProduceDynamicCodeCodeGroupServiceHandler produceDynamicCodeCodeGroupServiceHandler;

    private ProduceDynamicCodeCodeServiceHandler produceDynamicCodeCodeServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProduceDynamicCodeImpl instance. */
    public ProduceDynamicCodeImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceDynamicCodeCodeGroupServiceHandler = injector.inject(ProduceDynamicCodeCodeGroupServiceHandler
                .getId());
        if ((this.produceDynamicCodeCodeGroupServiceHandler != null)) {
            this.produceDynamicCodeCodeGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.produceDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
        this.produceDynamicCodeCodeServiceHandler = injector.inject(ProduceDynamicCodeCodeServiceHandler.getId());
        if ((this.produceDynamicCodeCodeServiceHandler != null)) {
            this.produceDynamicCodeCodeServiceHandler.setPersistenceManager(persistenceManager);
            this.produceDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("produceDynamicCodeCodeGroup", NO_ASPECTS);
            ASPECTS.put("produceDynamicCodeCode", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupMsg> produceDynamicCodeCodeGroup(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceDynamicCodeCodeGroupServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceDynamicCodeCodeGroup().");
            throw new InjectionException("No service implementation configured for produceDynamicCodeCodeGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        this.produceDynamicCodeCodeGroupServiceHandler.init();
        rs = this.produceDynamicCodeCodeGroupServiceHandler.invoke(rq);
        this.produceDynamicCodeCodeGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeMsg> produceDynamicCodeCode(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceDynamicCodeCode().");
            throw new InjectionException("No service implementation configured for produceDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeMsg> rs;
        this.produceDynamicCodeCodeServiceHandler.init();
        rs = this.produceDynamicCodeCodeServiceHandler.invoke(rq);
        this.produceDynamicCodeCodeServiceHandler.finish();
        return rs;
    }
}
