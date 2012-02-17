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
package org.nabucco.framework.common.dynamiccode.ui.web.provider;

import org.nabucco.framework.base.facade.datatype.code.CodeGroup;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.code.CodeProvider;
import org.nabucco.framework.base.facade.datatype.code.CodeProviderException;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.ui.web.session.NabuccoWebSessionFactory;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.resolve.ResolveDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.search.SearchDynamicCodeDelegate;

/**
 * A {@link CodeProvider} implementation that access the Dynamic Code Component for delivering codes
 * within the web client.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeWebCodeProvider implements CodeProvider {

    /** The name of the root code group */
    private String root;

    /** The Logger */
    private static NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(
            DynamicCodeWebCodeProvider.class);

    /**
     * Creates a new {@link DynamicCodeWebCodeProvider} instance.
     * 
     * @param root
     *            name of the root code group
     */
    public DynamicCodeWebCodeProvider(String root) {
        if (root == null) {
            throw new IllegalArgumentException("Cannot create DynamicCodeCodeProvider for root group [null].");
        }
        this.root = root;
    }

    @Override
    public CodeGroup getCodeRoot() throws CodeProviderException {
        return this.loadRoot();
    }

    @Override
    public CodeGroup reloadPath(String codePath) throws CodeProviderException {
        return this.load(codePath);
    }

    /**
     * Search the code group for the given code path.
     * 
     * @param codePath
     *            the code path pointing to the code group
     * 
     * @return the found code group
     * 
     * @throws CodeProviderException
     *             when the search fails
     */
    private DynamicCodeCodeGroup loadRoot() throws CodeProviderException {

        try {
            ResolveDynamicCodeDelegate resolveService = DynamicCodeComponentServiceDelegateFactory.getInstance()
                    .getResolveDynamicCode();

            EmptyServiceMessage rq = new EmptyServiceMessage();

            DynamicCodeCodeGroupMsg rs = resolveService.resolveAll(rq, NabuccoWebSessionFactory.getCurrentSession());

            if (rs == null || rs.getCodeGroup() == null) {
                logger.warning("No Code Group found for path '", this.root, "'!");
                return null;
            }

            return rs.getCodeGroup();

        } catch (ClientException ce) {
            logger.error(ce, "Error resolving code root '", this.root, "'.");
            throw new CodeProviderException("Error resolving code root '" + this.root + "'.", ce);
        } catch (ResolveException re) {
            logger.error(re, "Error resolving code root '", this.root, "'.");
            throw new CodeProviderException("Error resolving code root '" + this.root + "'.", re);
        } catch (Exception e) {
            logger.error(e, "Unexpected error resolving code root '", this.root, "'.");
            throw new CodeProviderException("Unexpected error resolving code root '" + this.root + "'.", e);
        }
    }

    /**
     * Search the code group for the given code path.
     * 
     * @param codePath
     *            the code path pointing to the code group
     * 
     * @return the found code group
     * 
     * @throws CodeProviderException
     *             when the search fails
     */
    private DynamicCodeCodeGroup load(String codePath) throws CodeProviderException {

        logger.debug("Searching Dynamic Codes for path '", codePath, "'.");

        try {
            SearchDynamicCodeDelegate searchService = DynamicCodeComponentServiceDelegateFactory.getInstance()
                    .getSearchDynamicCode();

            CodePathSearchMsg rq = new CodePathSearchMsg();
            rq.setCodePath(new CodePath(codePath));

            DynamicCodeCodeGroupMsg rs = searchService.searchByCodeGroupPath(rq,
                    NabuccoWebSessionFactory.getCurrentSession());

            if (rs == null || rs.getCodeGroup() == null) {
                logger.warning("No Code Group found for path '", codePath, "'!");
                return null;
            }

            DynamicCodeCodeGroup group = rs.getCodeGroup();

            if (group.getCodeList().isEmpty()) {
                logger.warning("No Codes found for path '", codePath, "'!");
                return null;
            }

            return rs.getCodeGroup();

        } catch (ClientException ce) {
            logger.error(ce, "Error resolving codes for path '", codePath, "'.");
            throw new CodeProviderException("Error resolving codes for path '" + codePath + "'.", ce);
        } catch (SearchException se) {
            logger.error(se, "Error searching codes for path '", codePath, "'.");
            throw new CodeProviderException("Error searching codes for path '" + codePath + "'.", se);
        } catch (Exception e) {
            logger.error(e, "Unexpected error resolving codes for path '", codePath, "'.");
            throw new CodeProviderException("Unexpected error resolving codes for path '" + codePath + "'.", e);
        }
    }
}
