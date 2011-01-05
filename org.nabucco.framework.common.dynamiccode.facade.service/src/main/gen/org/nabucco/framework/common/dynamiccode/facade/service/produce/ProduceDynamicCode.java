/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;

/**
 * ProduceDynamicCode<p/>Produce Service for DynamicCode<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-29
 */
public interface ProduceDynamicCode extends Service {

    /**
     * Creates a new DynamicCodeCodeGroup.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeGroupMsg>.
     * @throws ProduceException
     */
    ServiceResponse<DynamicCodeCodeGroupMsg> produceDynamicCodeCodeGroup(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Creates a new DynamicCodeCode.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<DynamicCodeCodeMsg>.
     * @throws ProduceException
     */
    ServiceResponse<DynamicCodeCodeMsg> produceDynamicCodeCode(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;
}
