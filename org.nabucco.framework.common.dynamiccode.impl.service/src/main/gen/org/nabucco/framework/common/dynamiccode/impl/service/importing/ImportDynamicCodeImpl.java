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
package org.nabucco.framework.common.dynamiccode.impl.service.importing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.framework.common.dynamiccode.facade.service.importing.ImportDynamicCode;

/**
 * ImportDynamicCodeImpl<p/>Service to import dynamic code<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2011-02-26
 */
public class ImportDynamicCodeImpl extends ServiceSupport implements ImportDynamicCode {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ImportDynamicCode";

    private static Map<String, String[]> ASPECTS;

    private ImportDynamicCodeServiceHandler importDynamicCodeServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ImportDynamicCodeImpl instance. */
    public ImportDynamicCodeImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.importDynamicCodeServiceHandler = injector.inject(ImportDynamicCodeServiceHandler.getId());
        if ((this.importDynamicCodeServiceHandler != null)) {
            this.importDynamicCodeServiceHandler.setPersistenceManager(persistenceManager);
            this.importDynamicCodeServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("importDynamicCode", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ImportRs> importDynamicCode(ServiceRequest<ImportRq> rq) throws ImportException {
        if ((this.importDynamicCodeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for importDynamicCode().");
            throw new InjectionException("No service implementation configured for importDynamicCode().");
        }
        ServiceResponse<ImportRs> rs;
        this.importDynamicCodeServiceHandler.init();
        rs = this.importDynamicCodeServiceHandler.invoke(rq);
        this.importDynamicCodeServiceHandler.finish();
        return rs;
    }
}
