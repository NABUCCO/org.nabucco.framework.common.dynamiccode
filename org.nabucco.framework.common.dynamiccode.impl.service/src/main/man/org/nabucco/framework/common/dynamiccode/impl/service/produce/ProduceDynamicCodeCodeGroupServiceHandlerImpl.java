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
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;

/**
 * ProduceDynamicCodeCodeGroupServiceHandlerImpl
 * 
 * @author Stefanie Feld, PRODYNA AG
 */
public class ProduceDynamicCodeCodeGroupServiceHandlerImpl extends ProduceDynamicCodeCodeGroupServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    public DynamicCodeCodeGroupMsg produceDynamicCodeCodeGroup(EmptyServiceMessage msg) throws ProduceException {
        DynamicCodeCodeGroupMsg rs = new DynamicCodeCodeGroupMsg();

        DynamicCodeCodeGroup codeGroup = new DynamicCodeCodeGroup();
        codeGroup.setName(new Name());
        codeGroup.setOwner(NabuccoInstance.getInstance().getOwner());
        codeGroup.setTenant(super.getContext().getSubject().getTenant());
        codeGroup.setDescription(new Description());
        codeGroup.setDatatypeState(DatatypeState.INITIALIZED);

        rs.setCodeGroup(codeGroup);

        return rs;
    }

}
