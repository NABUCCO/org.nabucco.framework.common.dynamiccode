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
package org.nabucco.framework.common.dynamiccode.impl.service.common.aspect.resolving;

import org.nabucco.common.cache.CacheFactory;
import org.nabucco.common.cache.CacheManager;
import org.nabucco.common.cache.CacheType;
import org.nabucco.common.cache.TenantCache;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Tenant;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyType;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.security.SecurityException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.context.ServiceMessageContext;
import org.nabucco.framework.base.facade.message.visitor.ServiceMessageVisitor;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;

/**
 * DynamicCodeResolvingVisitor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeResolvingVisitor extends ServiceMessageVisitor {

    private static final String CACHE_NAME = "CodeResolvingAspectCache";

    /** Logger */
    private static NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(
            DynamicCodeResolvingVisitor.class);

    /** The Tenant Enabled Cache */
    private static TenantCache<Code> cache;

    /** The cache timeout */
    private long cacheTimeout = 1800000;

    /** The service context */
    private ServiceMessageContext context;

    /**
     * Creates a new {@link DynamicCodeResolvingVisitor} instance.
     * 
     * @param timeout
     *            the cache timeout
     * @param context
     *            the service context
     */
    public DynamicCodeResolvingVisitor(long timeout, ServiceMessageContext context) {
        this.cacheTimeout = timeout;
        this.context = context;
    }

    @Override
    public void visit(Datatype datatype) throws VisitorException {

        if (datatype != null) {
            this.resolveDatatype(datatype);
        }

        super.visit(datatype);
    }

    /**
     * Resolve all codes of the given datatype.
     * 
     * @param datatype
     *            the datatype to resolve
     * 
     * @throws VisitorException
     *             when the datatype cannot be resolved
     */
    private void resolveDatatype(Datatype datatype) throws VisitorException {

        for (NabuccoProperty property : datatype.getProperties()) {

            if (property.getPropertyType() != NabuccoPropertyType.DATATYPE) {
                continue;
            }

            if (!Code.class.isAssignableFrom(property.getType())) {
                continue;
            }

            DatatypeProperty codeProperty = (DatatypeProperty) property;
            Long refId = codeProperty.getReferenceId();

            if (refId == null) {
                continue;
            }

            try {
                Code code = this.resolveCode(refId);
                NabuccoProperty newProperty = codeProperty.createProperty(code);
                datatype.setProperty(newProperty);
            } catch (ServiceException se) {
                logger.error(se, "Error resolving code for id '", refId, "'.");
            } catch (ConnectionException ce) {
                logger.error(ce, "Error connecting to Dynamic Code Component.");
                throw new VisitorException("Error connecting to Dynamic Code Component.", ce);
            } catch (Exception e) {
                logger.error(e, "Error resolving code for id '", refId, "'.");
                throw new VisitorException("Error resolving code for id '" + refId + "'.", e);
            }
        }
    }

    /**
     * Resolve the code with the given id.
     * 
     * @param id
     *            id of the code
     * 
     * @return the resolved code
     * 
     * @throws SecurityException
     *             when the current user is not authorized to access the code
     * @throws ServiceException
     *             when an error during the resolve service occurs
     * @throws ConnectionException
     *             when the dynamic code compoennt is not accessible
     */
    private Code resolveCode(Long id) throws SecurityException, ServiceException, ConnectionException {
        if (id == null) {
            return null;
        }

        String key = id.toString();
        String tenant = this.getTenant();

        if (getCache().contains(tenant, key)) {
            return getCache().retrieve(tenant, key);
        }

        DynamicCodeComponent component = DynamicCodeComponentLocator.getInstance().getComponent();
        ResolveDynamicCode resolveService = component.getResolveDynamicCode();

        ServiceRequest<DynamicCodeCodeResolveRq> rq = new ServiceRequest<DynamicCodeCodeResolveRq>(context);
        DynamicCodeCodeResolveRq msg = new DynamicCodeCodeResolveRq();

        DynamicCodeCode code = new DynamicCodeCode();
        code.setId(id);

        msg.setCode(code);
        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeResolveRs> rs = resolveService.resolveDynamicCodeCode(rq);

        if (rs == null || rs.getResponseMessage() == null) {
            throw new IllegalStateException("Cannot resolve code with id '" + id + "'.");
        }

        code = rs.getResponseMessage().getCode();

        if (code != null && code.getId() != null) {
            getCache().store(tenant, code.getId().toString(), code, this.cacheTimeout);
        }

        return code;
    }

    /**
     * Retrieve the tenant from the current service context.
     * 
     * @return the current tenant
     * 
     * @throws SecurityException
     *             when the current user is not authorized to access the cache
     */
    private String getTenant() throws SecurityException {
        if (this.context == null) {
            throw new IllegalStateException("Service Request Context [null] is not valid.");
        }
        if (this.context.getSubject() == null || this.context.getSubject().getUser() == null) {
            throw new SecurityException("User 'null' is not authorized to access the cache.");
        }

        UserId user = this.context.getSubject().getUserId();
        Tenant tenant = this.context.getSubject().getTenant();

        if (tenant == null || tenant.getValue() == null) {
            logger.error("User '" + user + "' is not authorized to access the code resolver cache.");
            throw new SecurityException("User '" + user + "' is not authorized to access the code resolver cache.");
        }

        return tenant.getValue();
    }

    /**
     * Retrieve the cache.
     * 
     * @return the cache
     */
    private static synchronized final TenantCache<Code> getCache() {
        if (cache == null) {
            CacheFactory<Code> factory = new CacheFactory<Code>();
            CacheManager manager = new CacheManager(CACHE_NAME);
            cache = factory.newTenantCache(CacheType.SIMPLE, manager);
        }

        return cache;
    }
}
