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

import org.nabucco.framework.base.facade.datatype.extension.property.IntegerProperty;
import org.nabucco.framework.base.facade.datatype.extension.schema.property.PropertyExtension;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.impl.service.aspect.caching.CachingSupport;
import org.nabucco.framework.base.impl.service.aspect.resolving.ResolvingAspect;
import org.nabucco.framework.base.impl.service.aspect.resolving.ResolvingException;
import org.nabucco.framework.base.impl.service.aspect.resolving.ResolvingSupport;

/**
 * DynamicCodeResolvingAspect
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeResolvingAspect extends ResolvingSupport implements ResolvingAspect {

    private static final String PROPERTY_TIMEOUT = "TIMEOUT";

    /** The cache timeout */
    private long cacheTimeout = 1800000;

    /** The Logger */
    private static NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(CachingSupport.class);

    @Override
    public void configure(PropertyExtension properties) {
        try {
            IntegerProperty timeout = (IntegerProperty) properties.getPropertyMap().get(PROPERTY_TIMEOUT);
            this.cacheTimeout = timeout.getValue().getValue().longValue();
        } catch (Exception e) {
            logger.warning("Property TIMEOUT not set for code resolving aspect, using default timeout ["
                    + this.cacheTimeout + "].");
        }
    }

    @Override
    public void resolveBefore(ServiceMessage requestMessage) throws ResolvingException {
        // Nothing to do here!
    }

    @Override
    public void resolveAfter(ServiceMessage requestMessage, ServiceMessage responseMessage) throws ResolvingException {

        if (responseMessage == null) {
            return;
        }

        try {
            DynamicCodeResolvingVisitor visitor = new DynamicCodeResolvingVisitor(this.cacheTimeout, super.getContext());
            responseMessage.accept(visitor);
        } catch (Exception e) {
            logger.error(e, "Error resolving codes for '" + requestMessage.getClass().getCanonicalName() + "'.");
        }
    }
}
