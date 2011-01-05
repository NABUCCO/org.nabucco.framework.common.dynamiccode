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
package org.nabucco.framework.common.dynamiccode.init;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;


/**
 * DynamicCodeCodeInitTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCodeInitTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void setUp() throws Exception {
        component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void initCode1() throws Exception {

        DynamicCodeCodeMaintainMsg msg = new DynamicCodeCodeMaintainMsg();
        ServiceRequest<DynamicCodeCodeMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeMaintainMsg>(super
                .createServiceContext());
        rq.setRequestMessage(msg);
        DynamicCodeCode code = new DynamicCodeCode();
        code.setDatatypeState(DatatypeState.INITIALIZED);

        Name name = new Name();
        code.setName(name);
        name.setValue("Code1");

        Description description = new Description();
        description.setValue("Code Description");
        code.setDescription(description);

        Owner owner = new Owner();
        owner.setValue("PRODYNA");
        code.setOwner(owner);

        msg.setCode(code);

        ServiceResponse<DynamicCodeCodeMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCode());
    }

    @Test
    public void initCode2() throws Exception {

        DynamicCodeCodeMaintainMsg msg = new DynamicCodeCodeMaintainMsg();
        ServiceRequest<DynamicCodeCodeMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeMaintainMsg>(super
                .createServiceContext());
        rq.setRequestMessage(msg);

        DynamicCodeCode code = new DynamicCodeCode();
        code.setDatatypeState(DatatypeState.INITIALIZED);

        Name name = new Name();
        code.setName(name);
        name.setValue("DynamicCode");

        Description description = new Description();
        description.setValue("This is a sample code");
        code.setDescription(description);

        Owner owner = new Owner();
        owner.setValue("NABUCCO");
        code.setOwner(owner);

        msg.setCode(code);

        ServiceResponse<DynamicCodeCodeMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCode());
    }

    @Test
    public void initCode3() throws Exception {

        DynamicCodeCodeMaintainMsg msg = new DynamicCodeCodeMaintainMsg();
        ServiceRequest<DynamicCodeCodeMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeMaintainMsg>(super
                .createServiceContext());
        rq.setRequestMessage(msg);

        DynamicCodeCode code = new DynamicCodeCode();
        code.setDatatypeState(DatatypeState.INITIALIZED);

        Name name = new Name();
        code.setName(name);
        name.setValue("SuperCode");

        Description description = new Description();
        description.setValue("Super Code");
        code.setDescription(description);

        Owner owner = new Owner();
        owner.setValue("PRODYNA");
        code.setOwner(owner);

        msg.setCode(code);

        ServiceResponse<DynamicCodeCodeMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCode());
    }

}
