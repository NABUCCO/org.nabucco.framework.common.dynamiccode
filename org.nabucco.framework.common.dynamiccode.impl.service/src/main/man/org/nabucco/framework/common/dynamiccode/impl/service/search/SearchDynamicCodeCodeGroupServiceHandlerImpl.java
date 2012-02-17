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
package org.nabucco.framework.common.dynamiccode.impl.service.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.base.impl.service.search.QuerySupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;

/**
 * SearchDynamicCodeCodeGroupServiceHandlerImpl
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class SearchDynamicCodeCodeGroupServiceHandlerImpl extends SearchDynamicCodeCodeGroupServiceHandler {

    private static final long serialVersionUID = 1L;

    private DynamicCodeCodeGroupSearchMsg request;

    private Set<DynamicCodeCodeGroup> resultSet;

    @Override
    public DynamicCodeCodeGroupListMsg searchDynamicCodeCodeGroup(DynamicCodeCodeGroupSearchMsg msg)
            throws SearchException {

        this.request = msg;
        this.resultSet = new HashSet<DynamicCodeCodeGroup>();

        this.search();

        DynamicCodeCodeGroupListMsg response = new DynamicCodeCodeGroupListMsg();
        for (DynamicCodeCodeGroup codeGroup : this.resultSet) {
            codeGroup.setDatatypeState(DatatypeState.PERSISTENT);
            response.getDynamicCodeCodeGroupList().add(codeGroup);
        }

        return response;
    }

    /**
     * Execute the search.
     * 
     * @throws SearchException
     *             when the search did not finish normally
     */
    private void search() throws SearchException {
        StringBuilder queryString = new StringBuilder();
        queryString.append("select c from DynamicCodeCodeGroup c where");
        queryString.append(" (c.name = :name or :name is null)");
        queryString.append(" and (c.owner = :owner or :owner is null)");
        queryString.append(" and (c.description like :description or :description is null)");

        try {
            NabuccoQuery<DynamicCodeCodeGroup> query = super.getPersistenceManager()
                    .createQuery(queryString.toString());
            query.setParameter("name", this.request.getName());
            query.setParameter("owner", this.request.getOwner());
            query.setParameter("description", QuerySupport.searchParameter(this.request.getDescription()));

            List<DynamicCodeCodeGroup> resultList = query.getResultList();
            this.resultSet.addAll(resultList);
        } catch (PersistenceException pe) {
            throw new SearchException("Error searching for DynamicCodeCodeGroup.", pe);
        }
    }
}
