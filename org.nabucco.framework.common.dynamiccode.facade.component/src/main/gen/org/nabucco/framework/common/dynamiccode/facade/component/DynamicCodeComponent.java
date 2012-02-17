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

import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.common.dynamiccode.facade.service.export.ExportDynamicCode;
import org.nabucco.framework.common.dynamiccode.facade.service.importing.ImportDynamicCode;
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

    final String COMPONENT_PREFIX = "dync";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent");

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
     * Getter for the ExportDynamicCode.
     *
     * @return the ExportDynamicCode.
     * @throws ServiceException
     */
    ExportDynamicCode getExportDynamicCode() throws ServiceException;

    /**
     * Getter for the ImportDynamicCode.
     *
     * @return the ImportDynamicCode.
     * @throws ServiceException
     */
    ImportDynamicCode getImportDynamicCode() throws ServiceException;

    /**
     * Getter for the LinkDynamicCode.
     *
     * @return the LinkDynamicCode.
     * @throws ServiceException
     */
    LinkDynamicCode getLinkDynamicCode() throws ServiceException;
}
