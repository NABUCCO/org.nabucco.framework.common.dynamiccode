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
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;

/**
 * SearchDynamicCodeCodeServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchDynamicCodeCodeServiceHandlerImpl extends SearchDynamicCodeCodeServiceHandler {

    private static final long serialVersionUID = 1L;

    private DynamicCodeCodeSearchMsg request;

    private Set<DynamicCodeCode> resultSet;

    @Override
    public DynamicCodeCodeListMsg searchDynamicCodeCode(DynamicCodeCodeSearchMsg msg) throws SearchException {

        this.request = msg;
        this.resultSet = new HashSet<DynamicCodeCode>();

        this.search();

        DynamicCodeCodeListMsg response = new DynamicCodeCodeListMsg();
        for (DynamicCodeCode code : this.resultSet) {
            code.setDatatypeState(DatatypeState.PERSISTENT);
            response.getCodeList().add(code);
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
        queryString.append("select c from DynamicCodeCode c where");
        queryString.append(" (c.name = :name or :name is null)");
        queryString.append(" and (c.owner = :owner or :owner is null)");
        queryString.append(" and (c.description like :description or :description is null)");

        try {

            NabuccoQuery<DynamicCodeCode> query = super.getPersistenceManager().createQuery(queryString.toString());
            query.setParameter("name", this.request.getName());
            query.setParameter("owner", this.request.getOwner());
            query.setParameter("description", QuerySupport.searchParameter(this.request.getDescription()));

            List<DynamicCodeCode> resultList = query.getResultList();
            this.resultSet.addAll(resultList);
        } catch (PersistenceException pe) {
            throw new SearchException("Error searching for DynamicCodeCode.", pe);
        }
    }
}
