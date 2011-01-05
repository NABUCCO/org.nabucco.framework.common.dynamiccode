/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.service.maintain;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;

/**
 * MaintainDynamicCode<p/>Maintain Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-01-15
 */
public interface MaintainDynamicCode extends Service {

    /**
     * Missing description at method maintainDynamicCodeCodeGroup.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeGroupMaintainMsg>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMaintainMsg>.
     * @throws MaintainException
     */
    ServiceResponse<DynamicCodeCodeGroupMaintainMsg> maintainDynamicCodeCodeGroup(
            ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainDynamicCodeCode.
     *
     * @param rq the ServiceRequest<DynamicCodeCodeMaintainMsg>.
     * @return the ServiceResponse<DynamicCodeCodeMaintainMsg>.
     * @throws MaintainException
     */
    ServiceResponse<DynamicCodeCodeMaintainMsg> maintainDynamicCodeCode(
            ServiceRequest<DynamicCodeCodeMaintainMsg> rq) throws MaintainException;
}
