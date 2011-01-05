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
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;

/**
 * ResolveDynamicCodeCodeGroupServiceHandlerImpl
 * 
 * @author Stefanie Feld, PRODYNA AG
 */
public class ResolveDynamicCodeCodeGroupServiceHandlerImpl extends
        ResolveDynamicCodeCodeGroupServiceHandler {

    private static final long serialVersionUID = 1L;

    private PersistenceHelper helper;

    private DynamicCodeCodeGroup codeGroup;

    private DynamicCodeCodeGroupResolveRs response;

    @Override
    protected DynamicCodeCodeGroupResolveRs resolveDynamicCodeCodeGroup(
            DynamicCodeCodeGroupResolveRq msg) throws ResolveException {

        this.response = new DynamicCodeCodeGroupResolveRs();
        this.helper = new PersistenceHelper(super.getEntityManager());
        this.codeGroup = msg.getCodeGroup();

        try {
            this.resolve();

            this.loadParentGroup();

        } catch (PersistenceException e) {
            throw new ResolveException("Cannot resolve DynamicCodeCodeGroup with id "
                    + this.codeGroup.getId());
        }

        this.response.setCodeGroup(this.codeGroup);
        return response;
    }

    /**
     * Resolve the codeGroup with its roles and permissions.
     * 
     * @throws PersistenceException
     *             when the codeGroup is not persistent
     */
    private void resolve() throws PersistenceException {
        this.codeGroup = this.helper.find(DynamicCodeCodeGroup.class, this.codeGroup);

        this.codeGroup.getCodeGroupList().size();
        this.codeGroup.getCodeList().size();
    }

    /**
     * Load all parent codeGroups containing the codeGroup.
     * 
     * @throws ResolveException
     *             when the codeGroup is not persistent
     */
    private void loadParentGroup() throws ResolveException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("select pg from DynamicCodeCodeGroup pg");
        queryString.append(" inner join pg.codeGroupListJPA cg");
        queryString.append(" where (cg.id = :codeGroupId)");

        Query query = super.getEntityManager().createQuery(queryString.toString());
        query.setParameter("codeGroupId", this.codeGroup.getId());

        @SuppressWarnings("unchecked")
        List<DynamicCodeCodeGroup> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            this.response.setParentGroup(resultList.get(0));
        }
    }
}
