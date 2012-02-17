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
package org.nabucco.framework.common.dynamiccode.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
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

    private static Map<String, String[]> ASPECTS;

    private SearchDynamicCodeCodeServiceHandler searchDynamicCodeCodeServiceHandler;

    private SearchDynamicCodeCodeGroupServiceHandler searchDynamicCodeCodeGroupServiceHandler;

    private SearchByCodePathServiceHandler searchByCodePathServiceHandler;

    private SearchByCodeGroupPathServiceHandler searchByCodeGroupPathServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchDynamicCodeImpl instance. */
    public SearchDynamicCodeImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchDynamicCodeCodeServiceHandler = injector.inject(SearchDynamicCodeCodeServiceHandler.getId());
        if ((this.searchDynamicCodeCodeServiceHandler != null)) {
            this.searchDynamicCodeCodeServiceHandler.setPersistenceManager(persistenceManager);
            this.searchDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
        }
        this.searchDynamicCodeCodeGroupServiceHandler = injector.inject(SearchDynamicCodeCodeGroupServiceHandler
                .getId());
        if ((this.searchDynamicCodeCodeGroupServiceHandler != null)) {
            this.searchDynamicCodeCodeGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.searchDynamicCodeCodeGroupServiceHandler.setLogger(super.getLogger());
        }
        this.searchByCodePathServiceHandler = injector.inject(SearchByCodePathServiceHandler.getId());
        if ((this.searchByCodePathServiceHandler != null)) {
            this.searchByCodePathServiceHandler.setPersistenceManager(persistenceManager);
            this.searchByCodePathServiceHandler.setLogger(super.getLogger());
        }
        this.searchByCodeGroupPathServiceHandler = injector.inject(SearchByCodeGroupPathServiceHandler.getId());
        if ((this.searchByCodeGroupPathServiceHandler != null)) {
            this.searchByCodeGroupPathServiceHandler.setPersistenceManager(persistenceManager);
            this.searchByCodeGroupPathServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("searchDynamicCodeCode", NO_ASPECTS);
            ASPECTS.put("searchDynamicCodeCodeGroup", NO_ASPECTS);
            ASPECTS.put("searchByCodePath", NO_ASPECTS);
            ASPECTS.put("searchByCodeGroupPath", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<DynamicCodeCodeListMsg> searchDynamicCodeCode(ServiceRequest<DynamicCodeCodeSearchMsg> rq)
            throws SearchException {
        if ((this.searchDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchDynamicCodeCode().");
            throw new InjectionException("No service implementation configured for searchDynamicCodeCode().");
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
            super.getLogger().error("No service implementation configured for searchDynamicCodeCodeGroup().");
            throw new InjectionException("No service implementation configured for searchDynamicCodeCodeGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupListMsg> rs;
        this.searchDynamicCodeCodeGroupServiceHandler.init();
        rs = this.searchDynamicCodeCodeGroupServiceHandler.invoke(rq);
        this.searchDynamicCodeCodeGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeListMsg> searchByCodePath(ServiceRequest<CodePathSearchMsg> rq)
            throws SearchException {
        if ((this.searchByCodePathServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchByCodePath().");
            throw new InjectionException("No service implementation configured for searchByCodePath().");
        }
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        this.searchByCodePathServiceHandler.init();
        rs = this.searchByCodePathServiceHandler.invoke(rq);
        this.searchByCodePathServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupMsg> searchByCodeGroupPath(ServiceRequest<CodePathSearchMsg> rq)
            throws SearchException {
        if ((this.searchByCodeGroupPathServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchByCodeGroupPath().");
            throw new InjectionException("No service implementation configured for searchByCodeGroupPath().");
        }
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        this.searchByCodeGroupPathServiceHandler.init();
        rs = this.searchByCodeGroupPathServiceHandler.invoke(rq);
        this.searchByCodeGroupPathServiceHandler.finish();
        return rs;
    }
}
