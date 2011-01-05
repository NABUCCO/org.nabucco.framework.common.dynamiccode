/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.component;

import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;

/**
 * DynamicCodeComponent<p/>DynamicCode component for configuring codes at runtime<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-06
 */
public interface DynamicCodeComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.framework.common.dynamiccode";

    /**
     * Getter for the MaintainDynamicCode.
     *
     * @return the MaintainDynamicCode.
     * @throws ServiceException
     */
    MaintainDynamicCode getMaintainDynamicCode() throws ServiceException;

    /**
     * Getter for the SearchDynamicCode.
     *
     * @return the SearchDynamicCode.
     * @throws ServiceException
     */
    SearchDynamicCode getSearchDynamicCode() throws ServiceException;

    /**
     * Getter for the ProduceDynamicCode.
     *
     * @return the ProduceDynamicCode.
     * @throws ServiceException
     */
    ProduceDynamicCode getProduceDynamicCode() throws ServiceException;

    /**
     * Getter for the ResolveDynamicCode.
     *
     * @return the ResolveDynamicCode.
     * @throws ServiceException
     */
    ResolveDynamicCode getResolveDynamicCode() throws ServiceException;

    /**
     * Getter for the LinkDynamicCode.
     *
     * @return the LinkDynamicCode.
     * @throws ServiceException
     */
    LinkDynamicCode getLinkDynamicCode() throws ServiceException;
}
