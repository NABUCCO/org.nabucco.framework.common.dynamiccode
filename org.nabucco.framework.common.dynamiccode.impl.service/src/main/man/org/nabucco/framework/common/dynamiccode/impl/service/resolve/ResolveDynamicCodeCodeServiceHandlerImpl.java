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
 * See the License for the specific language governing codes and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;

/**
 * ResolveDynamicCodeCodeServiceHandlerImpl
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class ResolveDynamicCodeCodeServiceHandlerImpl extends ResolveDynamicCodeCodeServiceHandler {

    private static final long serialVersionUID = 1L;

    private PersistenceHelper helper;

    private DynamicCodeCodeResolveRs response;

    private DynamicCodeCode code;

    @Override
    protected DynamicCodeCodeResolveRs resolveDynamicCodeCode(DynamicCodeCodeResolveRq msg)
            throws ResolveException {

        this.code = msg.getCode();
        this.response = new DynamicCodeCodeResolveRs();
        this.helper = new PersistenceHelper(super.getEntityManager());

        try {

            this.resolve();
            this.loadParentGroup();

        } catch (PersistenceException e) {
            throw new ResolveException("Cannot resolve DynamicCodeCode with id "
                    + this.code.getId());
        }

        this.response.setCode(this.code);

        return this.response;
    }

    /**
     * Resolve the code.
     * 
     * @throws PersistenceException
     *             when the code is not persistent
     */
    private void resolve() throws PersistenceException {
        this.code = this.helper.find(DynamicCodeCode.class, this.code);
    }

    /**
     * Load all codeGroups holding the code.
     * 
     * @throws ResolveException
     *             when the code is not persistent
     */
    private void loadParentGroup() throws ResolveException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("select cg from DynamicCodeCodeGroup cg");
        queryString.append(" inner join cg.codeListJPA c");
        queryString.append(" where (c.id = :codeId)");

        Query query = super.getEntityManager().createQuery(queryString.toString());
        query.setParameter("codeId", this.code.getId());

        @SuppressWarnings("unchecked")
        List<DynamicCodeCodeGroup> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            this.response.setParentGroup(resultList.get(0));
        }
    }

}
