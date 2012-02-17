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
package org.nabucco.framework.common.dynamiccode.facade.component;

import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.service.export.ExportDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.importing.ImportDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;

/**
 * DynamicCodeComponentLocalProxy<p/>DynamicCode component for configuring codes at runtime<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-06
 */
public class DynamicCodeComponentLocalProxy implements DynamicCodeComponent {

    private static final long serialVersionUID = 1L;

    private final DynamicCodeComponentLocal delegate;

    /**
     * Constructs a new DynamicCodeComponentLocalProxy instance.
     *
     * @param delegate the DynamicCodeComponentLocal.
     */
    public DynamicCodeComponentLocalProxy(DynamicCodeComponentLocal delegate) {
        super();
        if ((delegate == null)) {
            throw new IllegalArgumentException("Cannot create local proxy for component [null].");
        }
        this.delegate = delegate;
    }

    @Override
    public String getId() {
        return this.delegate.getId();
    }

    @Override
    public String getName() {
        return this.delegate.getName();
    }

    @Override
    public String getJndiName() {
        return this.delegate.getJndiName();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.delegate.getComponentRelationServiceLocal();
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return this.delegate.getQueryFilterServiceLocal();
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    public MaintainDynamicCode getMaintainDynamicCode() throws ServiceException {
        return this.delegate.getMaintainDynamicCodeLocal();
    }

    @Override
    public SearchDynamicCode getSearchDynamicCode() throws ServiceException {
        return this.delegate.getSearchDynamicCodeLocal();
    }

    @Override
    public ProduceDynamicCode getProduceDynamicCode() throws ServiceException {
        return this.delegate.getProduceDynamicCodeLocal();
    }

    @Override
    public ResolveDynamicCode getResolveDynamicCode() throws ServiceException {
        return this.delegate.getResolveDynamicCodeLocal();
    }

    @Override
    public ExportDynamicCode getExportDynamicCode() throws ServiceException {
        return this.delegate.getExportDynamicCodeLocal();
    }

    @Override
    public ImportDynamicCode getImportDynamicCode() throws ServiceException {
        return this.delegate.getImportDynamicCodeLocal();
    }

    @Override
    public LinkDynamicCode getLinkDynamicCode() throws ServiceException {
        return this.delegate.getLinkDynamicCodeLocal();
    }
}
