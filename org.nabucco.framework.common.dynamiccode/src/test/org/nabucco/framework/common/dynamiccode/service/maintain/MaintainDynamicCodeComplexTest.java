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
package org.nabucco.framework.common.dynamiccode.service.maintain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;
import org.nabucco.framework.common.dynamiccode.util.DynamicCodeTestUtility;

/**
 * MaintainDynamicCodeComplexTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainDynamicCodeComplexTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void testDynamicCodeLookup() throws Exception {
        this.component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testCodeInGroupInGroup() throws Exception {

        DynamicCodeCodeGroup parent = DynamicCodeTestUtility.dummyCodeGroup("Parent");

        DynamicCodeCodeGroup child = DynamicCodeTestUtility.dummyCodeGroup("Child");
        parent.getCodeGroupList().add(child);

        DynamicCodeCode codeA = DynamicCodeTestUtility.dummyCode("Code A");
        child.getCodeList().add(codeA);

        DynamicCodeCode codeB = DynamicCodeTestUtility.dummyCode("Code B");
        child.getCodeList().add(codeB);

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        msg.setCodeGroup(parent);

        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.getServiceContext());

        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = this.component.getMaintainDynamicCode()
                .maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        parent = rs.getResponseMessage().getCodeGroup();
        Assert.assertNotNull(parent);

        Assert.assertEquals(1, parent.getCodeGroupList().size());

        child = parent.getCodeGroupList().get(0);

        Assert.assertNotNull(child);
        Assert.assertNotNull(child.getId());
        Assert.assertEquals(DatatypeState.PERSISTENT, child.getDatatypeState());

        Assert.assertEquals(2, child.getCodeList().size());

        codeA = child.getCodeList().get(0);
        codeB = child.getCodeList().get(1);

        Assert.assertNotNull(codeA);
        Assert.assertNotNull(codeA.getId());
        Assert.assertEquals(DatatypeState.PERSISTENT, codeA.getDatatypeState());

        Assert.assertNotNull(codeB);
        Assert.assertNotNull(codeB.getId());
        Assert.assertEquals(DatatypeState.PERSISTENT, codeB.getDatatypeState());

        DynamicCodeTestUtility.removeCodeGroup(this.component, parent);
    }

    @Test
    public void testCodeInGroup() throws Exception {

        DynamicCodeCodeGroup group = DynamicCodeTestUtility.dummyCodeGroup("Group");
        group = DynamicCodeTestUtility.createCodeGroup(this.component, group);
        Assert.assertEquals(0, group.getVersion().longValue());

        DynamicCodeCode code = DynamicCodeTestUtility.dummyCode("Code");

        DynamicCodeCodeMaintainMsg msg = new DynamicCodeCodeMaintainMsg();
        msg.setCode(code);
        msg.setParentGroup(group);

        ServiceRequest<DynamicCodeCodeMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                super.getServiceContext());

        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeMaintainMsg> rs = this.component.getMaintainDynamicCode()
                .maintainDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        group = rs.getResponseMessage().getParentGroup();
        Assert.assertNotNull(group);
        Assert.assertEquals(1, group.getVersion().longValue());
        Assert.assertEquals(DatatypeState.PERSISTENT, group.getDatatypeState());

        Assert.assertEquals(1, group.getCodeList().size());

        code = group.getCodeList().get(0);

        Assert.assertNotNull(code);
        Assert.assertNotNull(code.getId());
        Assert.assertEquals(0, code.getVersion().longValue());
        Assert.assertEquals(DatatypeState.PERSISTENT, code.getDatatypeState());

        code = rs.getResponseMessage().getCode();

        Assert.assertNotNull(code);
        Assert.assertNotNull(code.getId());
        Assert.assertEquals(0, code.getVersion().longValue());
        Assert.assertEquals(DatatypeState.PERSISTENT, code.getDatatypeState());

        DynamicCodeTestUtility.removeCodeGroup(this.component, group);
    }

    @Test
    public void testGroupInGroup() throws Exception {

        DynamicCodeCodeGroup parent = DynamicCodeTestUtility.dummyCodeGroup("Parent");
        parent = DynamicCodeTestUtility.createCodeGroup(this.component, parent);

        Assert.assertEquals(0, parent.getVersion().longValue());

        DynamicCodeCodeGroup child = DynamicCodeTestUtility.dummyCodeGroup("Child");

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        msg.setCodeGroup(child);
        msg.setParentGroup(parent);

        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.getServiceContext());

        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = this.component.getMaintainDynamicCode()
                .maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        parent = rs.getResponseMessage().getParentGroup();
        Assert.assertNotNull(parent);
        Assert.assertEquals(1, parent.getVersion().longValue());
        Assert.assertEquals(DatatypeState.PERSISTENT, parent.getDatatypeState());

        Assert.assertEquals(1, parent.getCodeGroupList().size());

        child = parent.getCodeGroupList().get(0);

        Assert.assertNotNull(child);
        Assert.assertNotNull(child.getId());
        Assert.assertEquals(0, child.getVersion().longValue());
        Assert.assertEquals(DatatypeState.PERSISTENT, child.getDatatypeState());

        child = rs.getResponseMessage().getCodeGroup();

        Assert.assertNotNull(child);
        Assert.assertNotNull(child.getId());
        Assert.assertEquals(0, child.getVersion().longValue());
        Assert.assertEquals(DatatypeState.PERSISTENT, child.getDatatypeState());

        DynamicCodeTestUtility.removeCodeGroup(this.component, parent);
    }
}
