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
package org.nabucco.framework.common.dynamiccode.util;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;

/**
 * DynamicCodeTestUtility
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public final class DynamicCodeTestUtility {

    private DynamicCodeTestUtility() {
    }

    public static DynamicCodeCode dummyCode() {
        return dummyCode("Dummy Code");
    }

    public static DynamicCodeCode dummyCode(String name) {
        DynamicCodeCode code = new DynamicCodeCode();
        code.setName(name);
        code.setDescription("This is a test code");
        code.setOwner("PRODYNA");
        code.setDatatypeState(DatatypeState.INITIALIZED);

        return code;
    }

    public static DynamicCodeCodeGroup dummyCodeGroup() {
        return dummyCodeGroup("Dummy CodeGroup");
    }

    public static DynamicCodeCodeGroup dummyCodeGroup(String name) {
        DynamicCodeCodeGroup codeGroup = new DynamicCodeCodeGroup();
        codeGroup.setName(name);
        codeGroup.setDescription("CodeGroup Description");
        codeGroup.setOwner("NABUCCO");
        codeGroup.setDatatypeState(DatatypeState.INITIALIZED);
        return codeGroup;
    }

    public static DynamicCodeCodeGroup createCodeGroup(DynamicCodeComponent component, DynamicCodeCodeGroup codeGroup)
            throws ServiceException {

        codeGroup.setDatatypeState(DatatypeState.INITIALIZED);

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        msg.setCodeGroup(codeGroup);

        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                RuntimeTestSupport.createServiceContext());
        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCodeGroup(rq);

        return rs.getResponseMessage().getCodeGroup();
    }

    public static DynamicCodeCodeGroup removeCodeGroup(DynamicCodeComponent component, DynamicCodeCodeGroup codeGroup)
            throws ServiceException {

        codeGroup.setDatatypeState(DatatypeState.DELETED);

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        msg.setCodeGroup(codeGroup);

        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                RuntimeTestSupport.createServiceContext());
        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCodeGroup(rq);

        DynamicCodeCodeGroup responseCodeGroup = rs.getResponseMessage().getCodeGroup();
        return responseCodeGroup;
    }

    public static DynamicCodeCode createCode(DynamicCodeComponent component, DynamicCodeCode code)
            throws ServiceException {

        code.setDatatypeState(DatatypeState.INITIALIZED);

        DynamicCodeCodeMaintainMsg msg = new DynamicCodeCodeMaintainMsg();
        msg.setCode(code);

        ServiceRequest<DynamicCodeCodeMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                RuntimeTestSupport.createServiceContext());
        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeMaintainMsg> rs = component.getMaintainDynamicCode().maintainDynamicCodeCode(rq);

        return rs.getResponseMessage().getCode();
    }

    public static void removeCode(DynamicCodeComponent component, DynamicCodeCode code) throws ServiceException {

        code.setDatatypeState(DatatypeState.DELETED);

        DynamicCodeCodeMaintainMsg msg = new DynamicCodeCodeMaintainMsg();
        msg.setCode(code);

        ServiceRequest<DynamicCodeCodeMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                RuntimeTestSupport.createServiceContext());
        rq.setRequestMessage(msg);
        component.getMaintainDynamicCode().maintainDynamicCodeCode(rq);
    }

}
