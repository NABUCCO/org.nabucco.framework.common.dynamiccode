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
package org.nabucco.framework.common.dynamiccode.impl.component;

import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocal;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentRemote;
import org.nabucco.framework.common.dynamiccode.facade.service.export.ExportDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.importing.ImportDynamicCode;
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
public class DynamicCodeComponentImpl extends ComponentSupport implements DynamicCodeComponentLocal,
        DynamicCodeComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "DynamicCodeComponent";

    /** Constructs a new DynamicCodeComponentImpl instance. */
    public DynamicCodeComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE,
                ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL,
                ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainDynamicCode getMaintainDynamicCodeLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.MAINTAIN_DYNAMIC_CODE_LOCAL, MaintainDynamicCode.class);
    }

    @Override
    public MaintainDynamicCode getMaintainDynamicCode() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.MAINTAIN_DYNAMIC_CODE_REMOTE, MaintainDynamicCode.class);
    }

    @Override
    public SearchDynamicCode getSearchDynamicCodeLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.SEARCH_DYNAMIC_CODE_LOCAL, SearchDynamicCode.class);
    }

    @Override
    public SearchDynamicCode getSearchDynamicCode() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.SEARCH_DYNAMIC_CODE_REMOTE, SearchDynamicCode.class);
    }

    @Override
    public ProduceDynamicCode getProduceDynamicCodeLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.PRODUCE_DYNAMIC_CODE_LOCAL, ProduceDynamicCode.class);
    }

    @Override
    public ProduceDynamicCode getProduceDynamicCode() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.PRODUCE_DYNAMIC_CODE_REMOTE, ProduceDynamicCode.class);
    }

    @Override
    public ResolveDynamicCode getResolveDynamicCodeLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.RESOLVE_DYNAMIC_CODE_LOCAL, ResolveDynamicCode.class);
    }

    @Override
    public ResolveDynamicCode getResolveDynamicCode() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.RESOLVE_DYNAMIC_CODE_REMOTE, ResolveDynamicCode.class);
    }

    @Override
    public ExportDynamicCode getExportDynamicCodeLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.EXPORT_DYNAMIC_CODE_LOCAL, ExportDynamicCode.class);
    }

    @Override
    public ExportDynamicCode getExportDynamicCode() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.EXPORT_DYNAMIC_CODE_REMOTE, ExportDynamicCode.class);
    }

    @Override
    public ImportDynamicCode getImportDynamicCodeLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.IMPORT_DYNAMIC_CODE_LOCAL, ImportDynamicCode.class);
    }

    @Override
    public ImportDynamicCode getImportDynamicCode() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.IMPORT_DYNAMIC_CODE_REMOTE, ImportDynamicCode.class);
    }

    @Override
    public LinkDynamicCode getLinkDynamicCodeLocal() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.LINK_DYNAMIC_CODE_LOCAL, LinkDynamicCode.class);
    }

    @Override
    public LinkDynamicCode getLinkDynamicCode() throws ServiceException {
        return super.lookup(DynamicCodeComponentJndiNames.LINK_DYNAMIC_CODE_REMOTE, LinkDynamicCode.class);
    }
}
