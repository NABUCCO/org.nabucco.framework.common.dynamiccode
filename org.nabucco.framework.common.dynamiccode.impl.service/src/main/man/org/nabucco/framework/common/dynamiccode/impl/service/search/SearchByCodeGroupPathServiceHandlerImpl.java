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

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.impl.service.util.CodePathGroupResolver;

/**
 * SearchByCodeGroupPathServiceHandlerImpl
 * 
 * @author Silas Schwarz, PRODYNA AG
 */
public class SearchByCodeGroupPathServiceHandlerImpl extends SearchByCodeGroupPathServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected DynamicCodeCodeGroupMsg searchByCodeGroupPath(CodePathSearchMsg msg) throws SearchException {

        DynamicCodeCodeGroupMsg response = new DynamicCodeCodeGroupMsg();

        CodePathGroupResolver resolver = new CodePathGroupResolver(super.getPersistenceManager());
        DynamicCodeCodeGroup group = resolver.resolve(msg.getCodePath());

        response.setCodeGroup(group);

        return response;
    }
}
