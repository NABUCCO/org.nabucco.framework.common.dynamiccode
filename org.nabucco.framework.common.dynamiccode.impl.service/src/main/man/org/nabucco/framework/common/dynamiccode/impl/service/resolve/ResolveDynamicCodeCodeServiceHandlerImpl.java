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
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import java.util.List;

import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;

/**
 * ResolveDynamicCodeCodeServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ResolveDynamicCodeCodeServiceHandlerImpl extends ResolveDynamicCodeCodeServiceHandler {

    private static final long serialVersionUID = 1L;

    private DynamicCodeCodeResolveRs response;

    private DynamicCodeCode code;

    @Override
    protected DynamicCodeCodeResolveRs resolveDynamicCodeCode(DynamicCodeCodeResolveRq msg) throws ResolveException {

        this.code = msg.getCode();
        this.response = new DynamicCodeCodeResolveRs();

        try {

            this.resolve();
            this.loadParentGroup();

        } catch (PersistenceException e) {
            throw new ResolveException("Cannot resolve DynamicCodeCode with id " + this.code.getId());
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
        this.code = super.getPersistenceManager().find(this.code);
    }

    /**
     * Load all codeGroups holding the code.
     * 
     * @throws PersistenceException
     *             when the parent group is not persistent
     */
    private void loadParentGroup() throws PersistenceException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("select cg from DynamicCodeCodeGroup cg");
        queryString.append(" inner join cg.codeListJPA c");
        queryString.append(" where (c.id = :codeId)");

        NabuccoQuery<DynamicCodeCodeGroup> query = super.getPersistenceManager().createQuery(queryString.toString());
        query.setParameter("codeId", this.code.getId());

        List<DynamicCodeCodeGroup> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            this.response.setParentGroup(resultList.get(0));
        }
    }

}
