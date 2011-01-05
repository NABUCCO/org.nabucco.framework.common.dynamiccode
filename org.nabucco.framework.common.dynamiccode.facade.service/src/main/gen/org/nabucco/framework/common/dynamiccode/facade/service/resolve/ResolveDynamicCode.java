/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.service.resolve;

import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;

/**
 * ResolveDynamicCode<p/>Resolution Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public interface ResolveDynamicCode extends Service {

    /**
     * Missing description at method resolveDynamicCodeCode.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeResolveRq>.
     * @return the ServiceResponse<DynamicCodeCodeResolveRs>.
     * @throws ResolveException
     */
    ServiceResponse<DynamicCodeCodeResolveRs> resolveDynamicCodeCode(
            ServiceRequest<DynamicCodeCodeResolveRq> rq) throws ResolveException;

    /**
     * Missing description at method resolveDynamicCodeCodeGroup.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupResolveRq>.
     * @return the ServiceResponse<DynamicCodeCodeGroupResolveRs>.
     * @throws ResolveException
     */
    ServiceResponse<DynamicCodeCodeGroupResolveRs> resolveDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupResolveRq> rq) throws ResolveException;
}
