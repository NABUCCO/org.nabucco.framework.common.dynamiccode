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
package org.nabucco.framework.common.dynamiccode.impl.service.link;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.LinkException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
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

    private static Map<String, String[]> ASPECTS;

    private LinkDynamicCodeCodeServiceHandler linkDynamicCodeCodeServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new LinkDynamicCodeImpl instance. */
    public LinkDynamicCodeImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.linkDynamicCodeCodeServiceHandler = injector.inject(LinkDynamicCodeCodeServiceHandler.getId());
        if ((this.linkDynamicCodeCodeServiceHandler != null)) {
            this.linkDynamicCodeCodeServiceHandler.setPersistenceManager(persistenceManager);
            this.linkDynamicCodeCodeServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("linkDynamicCodeCode", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<DynamicCodeCodeListMsg> linkDynamicCodeCode(ServiceRequest<DynamicCodeCodeListMsg> rq)
            throws LinkException {
        if ((this.linkDynamicCodeCodeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for linkDynamicCodeCode().");
            throw new InjectionException("No service implementation configured for linkDynamicCodeCode().");
        }
        ServiceResponse<DynamicCodeCodeListMsg> rs;
        this.linkDynamicCodeCodeServiceHandler.init();
        rs = this.linkDynamicCodeCodeServiceHandler.invoke(rq);
        this.linkDynamicCodeCodeServiceHandler.finish();
        return rs;
    }
}
