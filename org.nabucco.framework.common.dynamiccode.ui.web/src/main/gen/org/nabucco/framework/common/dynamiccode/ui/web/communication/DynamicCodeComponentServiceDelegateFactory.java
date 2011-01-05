/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.web.communication;

import org.nabucco.framework.base.facade.component.connection.Connection;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.connection.ConnectionFactory;
import org.nabucco.framework.base.facade.component.connection.ConnectionSpecification;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.link.LinkDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.maintain.MaintainDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.produce.ProduceDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.resolve.ResolveDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.search.SearchDynamicCodeDelegate;

/**
 * ServiceDelegateFactoryTemplate<p/>DynamicCode component for configuring codes at runtime<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-06
 */
public class DynamicCodeComponentServiceDelegateFactory {

    private static DynamicCodeComponentServiceDelegateFactory instance = new DynamicCodeComponentServiceDelegateFactory();

    private DynamicCodeComponent component;

    private MaintainDynamicCodeDelegate maintainDynamicCodeDelegate;

    private SearchDynamicCodeDelegate searchDynamicCodeDelegate;

    private ProduceDynamicCodeDelegate produceDynamicCodeDelegate;

    private ResolveDynamicCodeDelegate resolveDynamicCodeDelegate;

    private LinkDynamicCodeDelegate linkDynamicCodeDelegate;

    /** Constructs a new DynamicCodeComponentServiceDelegateFactory instance. */
    private DynamicCodeComponentServiceDelegateFactory() {
        super();
    }

    /**
     * Getter for the Component.
     *
     * @return the DynamicCodeComponent.
     * @throws ConnectionException
     */
    private DynamicCodeComponent getComponent() throws ConnectionException {
        if ((this.component == null)) {
            this.initComponent();
        }
        return this.component;
    }

    /**
     * InitComponent.
     *
     * @throws ConnectionException
     */
    private void initComponent() throws ConnectionException {
        ConnectionSpecification specification = ConnectionSpecification.getCurrentSpecification();
        Connection connection = ConnectionFactory.getInstance().createConnection(specification);
        this.component = DynamicCodeComponentLocator.getInstance().getComponent(connection);
    }

    /**
     * Getter for the MaintainDynamicCode.
     *
     * @return the MaintainDynamicCodeDelegate.
     * @throws ClientException
     */
    public MaintainDynamicCodeDelegate getMaintainDynamicCode() throws ClientException {
        try {
            if ((this.maintainDynamicCodeDelegate == null)) {
                this.maintainDynamicCodeDelegate = new MaintainDynamicCodeDelegate(this
                        .getComponent().getMaintainDynamicCode());
            }
            return this.maintainDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: MaintainDynamicCode", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the SearchDynamicCode.
     *
     * @return the SearchDynamicCodeDelegate.
     * @throws ClientException
     */
    public SearchDynamicCodeDelegate getSearchDynamicCode() throws ClientException {
        try {
            if ((this.searchDynamicCodeDelegate == null)) {
                this.searchDynamicCodeDelegate = new SearchDynamicCodeDelegate(this.getComponent()
                        .getSearchDynamicCode());
            }
            return this.searchDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: SearchDynamicCode", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ProduceDynamicCode.
     *
     * @return the ProduceDynamicCodeDelegate.
     * @throws ClientException
     */
    public ProduceDynamicCodeDelegate getProduceDynamicCode() throws ClientException {
        try {
            if ((this.produceDynamicCodeDelegate == null)) {
                this.produceDynamicCodeDelegate = new ProduceDynamicCodeDelegate(this
                        .getComponent().getProduceDynamicCode());
            }
            return this.produceDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ProduceDynamicCode", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ResolveDynamicCode.
     *
     * @return the ResolveDynamicCodeDelegate.
     * @throws ClientException
     */
    public ResolveDynamicCodeDelegate getResolveDynamicCode() throws ClientException {
        try {
            if ((this.resolveDynamicCodeDelegate == null)) {
                this.resolveDynamicCodeDelegate = new ResolveDynamicCodeDelegate(this
                        .getComponent().getResolveDynamicCode());
            }
            return this.resolveDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ResolveDynamicCode", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the LinkDynamicCode.
     *
     * @return the LinkDynamicCodeDelegate.
     * @throws ClientException
     */
    public LinkDynamicCodeDelegate getLinkDynamicCode() throws ClientException {
        try {
            if ((this.linkDynamicCodeDelegate == null)) {
                this.linkDynamicCodeDelegate = new LinkDynamicCodeDelegate(this.getComponent()
                        .getLinkDynamicCode());
            }
            return this.linkDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: LinkDynamicCode", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the DynamicCodeComponentServiceDelegateFactory.
     */
    public static DynamicCodeComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
