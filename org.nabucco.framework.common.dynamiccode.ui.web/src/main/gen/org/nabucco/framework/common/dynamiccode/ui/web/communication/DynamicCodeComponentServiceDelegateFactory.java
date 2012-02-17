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
package org.nabucco.framework.common.dynamiccode.ui.web.communication;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateFactorySupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.export.ExportDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.importing.ImportDynamicCodeDelegate;
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
public class DynamicCodeComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<DynamicCodeComponent> {

    private static DynamicCodeComponentServiceDelegateFactory instance = new DynamicCodeComponentServiceDelegateFactory();

    private MaintainDynamicCodeDelegate maintainDynamicCodeDelegate;

    private SearchDynamicCodeDelegate searchDynamicCodeDelegate;

    private ProduceDynamicCodeDelegate produceDynamicCodeDelegate;

    private ResolveDynamicCodeDelegate resolveDynamicCodeDelegate;

    private ExportDynamicCodeDelegate exportDynamicCodeDelegate;

    private ImportDynamicCodeDelegate importDynamicCodeDelegate;

    private LinkDynamicCodeDelegate linkDynamicCodeDelegate;

    /** Constructs a new DynamicCodeComponentServiceDelegateFactory instance. */
    private DynamicCodeComponentServiceDelegateFactory() {
        super(DynamicCodeComponentLocator.getInstance());
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
                this.maintainDynamicCodeDelegate = new MaintainDynamicCodeDelegate(this.getComponent()
                        .getMaintainDynamicCode());
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
                this.produceDynamicCodeDelegate = new ProduceDynamicCodeDelegate(this.getComponent()
                        .getProduceDynamicCode());
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
                this.resolveDynamicCodeDelegate = new ResolveDynamicCodeDelegate(this.getComponent()
                        .getResolveDynamicCode());
            }
            return this.resolveDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ResolveDynamicCode", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ExportDynamicCode.
     *
     * @return the ExportDynamicCodeDelegate.
     * @throws ClientException
     */
    public ExportDynamicCodeDelegate getExportDynamicCode() throws ClientException {
        try {
            if ((this.exportDynamicCodeDelegate == null)) {
                this.exportDynamicCodeDelegate = new ExportDynamicCodeDelegate(this.getComponent()
                        .getExportDynamicCode());
            }
            return this.exportDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ExportDynamicCode", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ImportDynamicCode.
     *
     * @return the ImportDynamicCodeDelegate.
     * @throws ClientException
     */
    public ImportDynamicCodeDelegate getImportDynamicCode() throws ClientException {
        try {
            if ((this.importDynamicCodeDelegate == null)) {
                this.importDynamicCodeDelegate = new ImportDynamicCodeDelegate(this.getComponent()
                        .getImportDynamicCode());
            }
            return this.importDynamicCodeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ImportDynamicCode", e);
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
                this.linkDynamicCodeDelegate = new LinkDynamicCodeDelegate(this.getComponent().getLinkDynamicCode());
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
