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
package org.nabucco.framework.common.dynamiccode.impl.service.produce;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;

/**
 * ProduceDynamicCodeCodeServiceHandlerImpl
 * 
 * @author Stefanie Feld, PRODYNA AG
 */
public class ProduceDynamicCodeCodeServiceHandlerImpl extends ProduceDynamicCodeCodeServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    public DynamicCodeCodeMsg produceDynamicCodeCode(EmptyServiceMessage msg) throws ProduceException {
        DynamicCodeCodeMsg codeMsg = new DynamicCodeCodeMsg();

        DynamicCodeCode code = new DynamicCodeCode();
        code.setName(new Name());
        code.setOwner(NabuccoInstance.getInstance().getOwner());
        code.setTenant(super.getContext().getSubject().getTenant());
        code.setDescription(new Description());
        code.setDatatypeState(DatatypeState.INITIALIZED);

        codeMsg.setCode(code);

        return codeMsg;
    }

}
