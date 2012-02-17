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
package org.nabucco.framework.common.dynamiccode.impl.service;

import java.util.Set;

import javax.persistence.EntityManager;

import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.context.ServiceMessageContext;
import org.nabucco.framework.base.facade.message.dynamiccode.DynamicCodeIdRq;
import org.nabucco.framework.base.facade.message.dynamiccode.DynamicCodePathRq;
import org.nabucco.framework.base.facade.message.dynamiccode.DynamicCodeRs;
import org.nabucco.framework.base.facade.service.dynamiccode.DynamicCodeService;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.impl.service.util.CodePathResolver;

/**
 * DynamicCodeServiceImpl
 * <p/>
 * <p/>
 * Manual implementation of the base dynamic code service. Allows the searching and resolving of
 * existing dynamic codes.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeServiceImpl extends ServiceSupport implements DynamicCodeService {

    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    @Override
    public void postConstruct() {
        super.postConstruct();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public ServiceResponse<DynamicCodeRs> resolveDynamicCode(ServiceRequest<DynamicCodeIdRq> rq)
            throws ResolveException {

        if (rq == null || rq.getRequestMessage() == null) {
            throw new ResolveException("Cannot resolve dynamic code for request [null].");
        }

        ServiceMessageContext context = rq.getContext();

        Identifier id = rq.getRequestMessage().getReferenceId();

        if (id == null || id.getValue() == null) {
            throw new ResolveException("Cannot resolve dynamic code for id [null].");
        }

        try {
            PersistenceManager manager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                    this.entityManager, super.getLogger());

            DynamicCodeCode code = manager.find(DynamicCodeCode.class, id.getValue());

            DynamicCodeRs msg = new DynamicCodeRs();
            msg.getCodeList().add(code);

            ServiceResponse<DynamicCodeRs> rs = new ServiceResponse<DynamicCodeRs>(context);
            rs.setResponseMessage(msg);

            return rs;
        } catch (PersistenceException pe) {
            throw new ResolveException("Cannot resolve dynamic code with id [" + id + "].", pe);
        }
    }

    @Override
    public ServiceResponse<DynamicCodeRs> searchDynamicCode(ServiceRequest<DynamicCodePathRq> rq)
            throws SearchException {

        if (rq == null || rq.getRequestMessage() == null) {
            throw new SearchException("Cannot resolve dynamic code for request [null].");
        }

        ServiceMessageContext context = rq.getContext();

        CodePath codePath = rq.getRequestMessage().getPath();

        if (codePath == null || codePath.getValue() == null) {
            throw new SearchException("Cannot resolve dynamic code for id [null].");
        }

        PersistenceManager manager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());

        CodePathResolver resolver = new CodePathResolver(manager);

        Set<DynamicCodeCode> codes = resolver.resolve(codePath);

        DynamicCodeRs msg = new DynamicCodeRs();
        msg.getCodeList().addAll(codes);

        ServiceResponse<DynamicCodeRs> rs = new ServiceResponse<DynamicCodeRs>(context);
        rs.setResponseMessage(msg);

        return rs;
    }

}
