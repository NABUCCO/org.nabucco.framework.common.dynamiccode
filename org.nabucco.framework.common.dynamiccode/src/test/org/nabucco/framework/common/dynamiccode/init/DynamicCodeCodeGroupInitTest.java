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
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;


/**
 * DynamicCodeCodeGroupInitTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCodeGroupInitTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void setUp() throws Exception {
        component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void initCodeGroup1() throws Exception {

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext());
        rq.setRequestMessage(msg);

        DynamicCodeCodeGroup group = new DynamicCodeCodeGroup();
        group.setDatatypeState(DatatypeState.INITIALIZED);

        Name name = new Name();
        group.setName(name);
        name.setValue("Admin Group");

        Description description = new Description();
        description.setValue("AdminGroup Description");
        group.setDescription(description);

        Owner owner = new Owner();
        owner.setValue("PRODYNA");
        group.setOwner(owner);

        msg.setCodeGroup(group);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCodeGroup());
    }

    @Test
    public void initCodeGroup2() throws Exception {

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext());
        rq.setRequestMessage(msg);

        DynamicCodeCodeGroup group = new DynamicCodeCodeGroup();
        group.setDatatypeState(DatatypeState.INITIALIZED);

        Name name = new Name();
        group.setName(name);
        name.setValue("User Group");

        Description description = new Description();
        description.setValue("UserGroup Description");
        group.setDescription(description);

        Owner owner = new Owner();
        owner.setValue("PRODYNA");
        group.setOwner(owner);

        msg.setCodeGroup(group);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCodeGroup());
    }

    @Test
    public void initCodeGroup3() throws Exception {

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.createServiceContext());
        rq.setRequestMessage(msg);

        DynamicCodeCodeGroup group = new DynamicCodeCodeGroup();
        group.setDatatypeState(DatatypeState.INITIALIZED);

        Name name = new Name();
        group.setName(name);
        name.setValue("Test Group");

        Description description = new Description();
        description.setValue("TestGroup Description");
        group.setDescription(description);

        Owner owner = new Owner();
        owner.setValue("OTHER");
        group.setOwner(owner);

        msg.setCodeGroup(group);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = component.getMaintainDynamicCode()
                .maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCodeGroup());
    }

}
