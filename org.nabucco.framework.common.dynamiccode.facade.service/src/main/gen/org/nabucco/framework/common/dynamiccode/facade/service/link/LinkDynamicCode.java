/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.service.link;

import org.nabucco.framework.base.facade.exception.service.LinkException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;

/**
 * LinkDynamicCode<p/>Linkage Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public interface LinkDynamicCode extends Service {

    /**
     * Missing description at method linkDynamicCodeCode.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeListMsg>.
     * @return the ServiceResponse<DynamicCodeCodeListMsg>.
     * @throws LinkException
     */
    ServiceResponse<DynamicCodeCodeListMsg> linkDynamicCodeCode(
            ServiceRequest<DynamicCodeCodeListMsg> rq) throws LinkException;
}
