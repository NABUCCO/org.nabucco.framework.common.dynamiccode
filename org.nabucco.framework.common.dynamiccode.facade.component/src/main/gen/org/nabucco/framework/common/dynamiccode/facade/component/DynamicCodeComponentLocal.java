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
import org.nabucco.framework.common.dynamiccode.facade.service.export.ExportDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.importing.ImportDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.link.LinkDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.maintain.MaintainDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.produce.ProduceDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.resolve.ResolveDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;

/**
 * DynamicCodeComponentLocal<p/>DynamicCode component for configuring codes at runtime<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-06
 */
public interface DynamicCodeComponentLocal extends DynamicCodeComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainDynamicCodeLocal.
     *
     * @return the MaintainDynamicCode.
     * @throws ServiceException
     */
    MaintainDynamicCode getMaintainDynamicCodeLocal() throws ServiceException;

    /**
     * Getter for the SearchDynamicCodeLocal.
     *
     * @return the SearchDynamicCode.
     * @throws ServiceException
     */
    SearchDynamicCode getSearchDynamicCodeLocal() throws ServiceException;

    /**
     * Getter for the ProduceDynamicCodeLocal.
     *
     * @return the ProduceDynamicCode.
     * @throws ServiceException
     */
    ProduceDynamicCode getProduceDynamicCodeLocal() throws ServiceException;

    /**
     * Getter for the ResolveDynamicCodeLocal.
     *
     * @return the ResolveDynamicCode.
     * @throws ServiceException
     */
    ResolveDynamicCode getResolveDynamicCodeLocal() throws ServiceException;

    /**
     * Getter for the ExportDynamicCodeLocal.
     *
     * @return the ExportDynamicCode.
     * @throws ServiceException
     */
    ExportDynamicCode getExportDynamicCodeLocal() throws ServiceException;

    /**
     * Getter for the ImportDynamicCodeLocal.
     *
     * @return the ImportDynamicCode.
     * @throws ServiceException
     */
    ImportDynamicCode getImportDynamicCodeLocal() throws ServiceException;

    /**
     * Getter for the LinkDynamicCodeLocal.
     *
     * @return the LinkDynamicCode.
     * @throws ServiceException
     */
    LinkDynamicCode getLinkDynamicCodeLocal() throws ServiceException;
}
