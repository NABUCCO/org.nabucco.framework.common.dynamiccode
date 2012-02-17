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
package org.nabucco.framework.common.dynamiccode.impl.service.maintain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
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

    private static Map<String, String[]> ASPECTS;

    private MaintainDynamicCodeCodeGroupServiceHandler maintainDynamicCodeCodeGroupServiceHandler;

    private MaintainDynamicCodeCodeServiceHandler maintainDynamicCodeCodeServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MaintainDynamicCodeImpl instance. */
    public MaintainDynamicCodeImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.maintainDynamicCodeCodeGroupServiceHandler = injector.inject(MaintainDynamicCodeCodeGroupServiceHandler
                .getId());
        if ((this.maintainDynamicCodeCodeGroupServiceHandler != null)) {
            this.maintainDynamicCodeCodeGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
        this.maintainDynamicCodeCodeServiceHandler = injector.inject(MaintainDynamicCodeCodeServiceHandler.getId());
        if ((this.maintainDynamicCodeCodeServiceHandler != null)) {
            this.maintainDynamicCodeCodeServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("maintainDynamicCodeCodeGroup", NO_ASPECTS);
            ASPECTS.put("maintainDynamicCodeCode", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupMaintainMsg> maintainDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq) throws MaintainException {
        if ((this.maintainDynamicCodeCodeGroupServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainDynamicCodeCodeGroup().");
            throw new InjectionException("No service implementation configured for maintainDynamicCodeCodeGroup().");
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
            super.getLogger().error("No service implementation configured for maintainDynamicCodeCode().");
            throw new InjectionException("No service implementation configured for maintainDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeMaintainMsg> rs;
        this.maintainDynamicCodeCodeServiceHandler.init();
        rs = this.maintainDynamicCodeCodeServiceHandler.invoke(rq);
        this.maintainDynamicCodeCodeServiceHandler.finish();
        return rs;
    }
}
