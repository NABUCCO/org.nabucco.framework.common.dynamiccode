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
package org.nabucco.framework.common.dynamiccode.impl.service.export;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.export.ExportDynamicCode;

/**
 * ExportDynamicCodeImpl<p/>Service to export Dynamic Code<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2011-01-26
 */
public class ExportDynamicCodeImpl extends ServiceSupport implements ExportDynamicCode {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ExportDynamicCode";

    private static Map<String, String[]> ASPECTS;

    private ExportServiceHandler exportServiceHandler;

    private ExportRootGroupServiceHandler exportRootGroupServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ExportDynamicCodeImpl instance. */
    public ExportDynamicCodeImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.exportServiceHandler = injector.inject(ExportServiceHandler.getId());
        if ((this.exportServiceHandler != null)) {
            this.exportServiceHandler.setPersistenceManager(persistenceManager);
            this.exportServiceHandler.setLogger(super.getLogger());
        }
        this.exportRootGroupServiceHandler = injector.inject(ExportRootGroupServiceHandler.getId());
        if ((this.exportRootGroupServiceHandler != null)) {
            this.exportRootGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.exportRootGroupServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("export", NO_ASPECTS);
            ASPECTS.put("exportRootGroup", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ExportRs> export(ServiceRequest<EmptyServiceMessage> rq) throws ExportException {
        if ((this.exportServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for export().");
            throw new InjectionException("No service implementation configured for export().");
        }
        ServiceResponse<ExportRs> rs;
        this.exportServiceHandler.init();
        rs = this.exportServiceHandler.invoke(rq);
        this.exportServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<DynamicCodeCodeGroupMsg> exportRootGroup(ServiceRequest<EmptyServiceMessage> rq)
            throws ExportException {
        if ((this.exportRootGroupServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for exportRootGroup().");
            throw new InjectionException("No service implementation configured for exportRootGroup().");
        }
        ServiceResponse<DynamicCodeCodeGroupMsg> rs;
        this.exportRootGroupServiceHandler.init();
        rs = this.exportRootGroupServiceHandler.invoke(rq);
        this.exportRootGroupServiceHandler.finish();
        return rs;
    }
}
