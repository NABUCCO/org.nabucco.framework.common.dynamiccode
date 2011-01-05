/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.impl.component;

import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.impl.component.ComponentSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;

/**
 * DynamicCodeComponentImpl<p/>DynamicCode component for configuring codes at runtime<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-06
 */
public class DynamicCodeComponentImpl extends ComponentSupport implements DynamicCodeComponent {

    private static final long serialVersionUID = 1L;

    private ComponentRelationService componentRelationService;

    private MaintainDynamicCode maintainDynamicCode;

    private SearchDynamicCode searchDynamicCode;

    private ProduceDynamicCode produceDynamicCode;

    private ResolveDynamicCode resolveDynamicCode;

    private LinkDynamicCode linkDynamicCode;

    /** Constructs a new DynamicCodeComponentImpl instance. */
    public DynamicCodeComponentImpl() {
        super();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.componentRelationService;
    }

    /**
     * Getter for the MaintainDynamicCode.
     *
     * @return the MaintainDynamicCode.
     */
    public MaintainDynamicCode getMaintainDynamicCode() {
        return this.maintainDynamicCode;
    }

    /**
     * Getter for the SearchDynamicCode.
     *
     * @return the SearchDynamicCode.
     */
    public SearchDynamicCode getSearchDynamicCode() {
        return this.searchDynamicCode;
    }

    /**
     * Getter for the ProduceDynamicCode.
     *
     * @return the ProduceDynamicCode.
     */
    public ProduceDynamicCode getProduceDynamicCode() {
        return this.produceDynamicCode;
    }

    /**
     * Getter for the ResolveDynamicCode.
     *
     * @return the ResolveDynamicCode.
     */
    public ResolveDynamicCode getResolveDynamicCode() {
        return this.resolveDynamicCode;
    }

    /**
     * Getter for the LinkDynamicCode.
     *
     * @return the LinkDynamicCode.
     */
    public LinkDynamicCode getLinkDynamicCode() {
        return this.linkDynamicCode;
    }
}
