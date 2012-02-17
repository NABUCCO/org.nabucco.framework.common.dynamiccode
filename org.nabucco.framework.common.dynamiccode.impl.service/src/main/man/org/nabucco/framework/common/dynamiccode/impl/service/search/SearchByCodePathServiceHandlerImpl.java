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

import java.util.Set;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.impl.service.util.CodePathResolver;

/**
 * SearchByCodePathServiceHandlerImpl
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class SearchByCodePathServiceHandlerImpl extends SearchByCodePathServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected DynamicCodeCodeListMsg searchByCodePath(CodePathSearchMsg msg) throws SearchException {

        DynamicCodeCodeListMsg response = new DynamicCodeCodeListMsg();

        CodePathResolver resolver = new CodePathResolver(super.getPersistenceManager());
        Set<DynamicCodeCode> codes = resolver.resolve(msg.getCodePath());

        response.getCodeList().addAll(codes);

        return response;
    }

}
