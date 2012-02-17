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
package org.nabucco.framework.common.dynamiccode.impl.service.util;

import java.util.List;
import java.util.regex.Pattern;

import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.impl.service.common.cache.DynamicCodeCache;

/**
 * CodePathResolver
 * <p/>
 * Utility class for resolving codes by code path.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class CodePathGroupResolver {

    private static final Pattern PATTERN = Pattern.compile("\\.");

    private PersistenceManager manager;

    /**
     * Creates a new {@link CodePathGroupResolver} instance.
     * 
     * @param manager
     *            the persistence manager
     */
    public CodePathGroupResolver(PersistenceManager manager) {
        this.manager = manager;
    }

    /**
     * Resolves the codes for a given code path.
     * 
     * @param path
     *            the code path to resolve
     * 
     * @throws SearchException
     *             when the search did not finish normally
     */
    public DynamicCodeCodeGroup resolve(CodePath path) throws SearchException {
        DynamicCodeCodeGroup resultingGroup = null;

        if (path == null || path.getValue() == null || path.getValue().isEmpty()) {
            throw new IllegalArgumentException("Cannot search for code path [null] nor empty path.");
        }

        resultingGroup = DynamicCodeCache.retrieveGroupFromCache(path);
        if (resultingGroup != null) {
            return resultingGroup;
        }

        String[] groups = PATTERN.split(path.getValue());
        if (groups.length == 0) {
            throw new IllegalArgumentException("Cannot search for code path [].");
        }

        String queryString = this.createQuery(groups.length);

        try {

            NabuccoQuery<DynamicCodeCodeGroup> query = this.manager.createQuery(queryString);

            for (int i = 0; i < groups.length; i++) {
                String group = groups[i];

                if (group == null || group.isEmpty()) {
                    throw new IllegalArgumentException("Cannot search for code group [].");
                }

                query.setParameter("name" + i, group);
            }

            List<DynamicCodeCodeGroup> resultList = query.getResultList();
            if (!resultList.isEmpty()) {
                resultingGroup = resultList.get(0);

                try {
                    DatatypeVisitor visitor = new DatatypeVisitor();
                    resultingGroup.accept(visitor);
                } catch (VisitorException ve) {
                    throw new SearchException("Error resolving DynamicCodeCodeGroup with id '"
                            + resultingGroup.getId() + "'.", ve);
                }
            }

        } catch (PersistenceException pe) {
            throw new SearchException("Error searching for DynamicCodeCodeGroup.", pe);
        }

        DynamicCodeCache.sendToCache(path, resultingGroup);

        return resultingGroup;
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
        queryString.append("select g" + (groupCount - 1) + " from DynamicCodeCodeGroup g");

        for (int i = 0; i < groupCount; i++) {
            if (i == 0) {
                queryString.append(i);
            } else {
                queryString.append(" inner join g" + (i - 1) + ".codeGroupListJPA g" + i);
            }
        }
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
