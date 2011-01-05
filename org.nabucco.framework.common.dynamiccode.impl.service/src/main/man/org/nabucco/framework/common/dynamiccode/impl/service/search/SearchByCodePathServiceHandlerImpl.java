/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.search;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.impl.service.common.cache.DynamicCodeCache;

/**
 * SearchByCodePathServiceHandlerImpl
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class SearchByCodePathServiceHandlerImpl extends SearchByCodePathServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final Pattern PATTERN = Pattern.compile("\\.");

    private CodePathSearchMsg request;

    private Set<DynamicCodeCode> resultSet;

    @Override
    protected DynamicCodeCodeListMsg searchByCodePath(CodePathSearchMsg msg) throws SearchException {

        this.request = msg;
        this.resultSet = new HashSet<DynamicCodeCode>();

        DynamicCodeCodeListMsg response = new DynamicCodeCodeListMsg();

        CodePath path = msg.getCodePath();

        Collection<DynamicCodeCode> codes = DynamicCodeCache.retrieveFromCache(path);
        if (codes != null) {
            response.getCodeList().addAll(codes);
            return response;
        }

        this.search();

        DynamicCodeCache.sendToCache(path, this.resultSet);

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
        CodePath path = this.request.getCodePath();
        if (path == null || path.getValue() == null) {
            throw new IllegalArgumentException("Cannot search for code path [null].");
        }

        String[] groups = PATTERN.split(path.getValue());
        if (groups.length == 0) {
            throw new IllegalArgumentException("Cannot search for code path [].");
        }

        String queryString = this.createQuery(groups.length);

        Query query = super.getEntityManager().createQuery(queryString);

        for (int i = 0; i < groups.length; i++) {
            String group = groups[i];
            
            if (group == null || group.isEmpty()) {
                throw new IllegalArgumentException("Cannot search for code group [].");
            }
            
            query.setParameter("name" + i, group);
        }

        @SuppressWarnings("unchecked")
        List<DynamicCodeCode> resultList = query.getResultList();
        this.resultSet.addAll(resultList);
    }

    /**
     * Create the dynamic query for code path resolving.
     * 
     * @param groupCount
     *            the amount of code group tokens
     * 
     * @return the query string
     */
    private String createQuery(int groupCount) {

        StringBuilder queryString = new StringBuilder();
        queryString.append("select c from DynamicCodeCodeGroup g");

        for (int i = 0; i < groupCount; i++) {
            if (i == 0) {
                queryString.append(i);
            } else {
                queryString.append(" inner join g" + (i - 1) + ".codeGroupListJPA g" + i);
            }
        }

        queryString.append(" inner join g" + (groupCount - 1) + ".codeListJPA c");
        queryString.append(" where ");

        for (int i = 0; i < groupCount; i++) {
            if (i != 0) {
                queryString.append(" and ");
            }
            queryString.append("g" + i + ".name.value = :name" + i);
        }

        return queryString.toString();
    }

}
