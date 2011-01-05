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
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;

/**
 * MaintainDynamicCodeCodeGroupTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainDynamicCodeCodeGroupTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void testDynamicCodeLookup() throws Exception {
        this.component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testMaintainCodeGroup() throws Exception {

        DynamicCodeCodeGroup codeGroup = new DynamicCodeCodeGroup();
        codeGroup.setName("Test CodeGroup");
        codeGroup.setDescription("This is a test codeGroup");
        codeGroup.setOwner("PRODYNA");
        codeGroup.setDatatypeState(DatatypeState.INITIALIZED);

        DynamicCodeCodeGroupMaintainMsg msg = new DynamicCodeCodeGroupMaintainMsg();
        msg.setCodeGroup(codeGroup);

        ServiceRequest<DynamicCodeCodeGroupMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeGroupMaintainMsg>(
                super.getServiceContext());

        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeGroupMaintainMsg> rs = this.component
                .getMaintainDynamicCode().maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        codeGroup = rs.getResponseMessage().getCodeGroup();
        Assert.assertNotNull(codeGroup);

        Assert.assertEquals("Test CodeGroup", codeGroup.getName().getValue());
        Assert.assertEquals("This is a test codeGroup", codeGroup.getDescription().getValue());
        Assert.assertEquals("PRODYNA", codeGroup.getOwner().getValue());

        codeGroup.setDatatypeState(DatatypeState.MODIFIED);
        codeGroup.setName("Other codeGroup");
        codeGroup.setDescription("Other Description");
        codeGroup.setOwner("NABUCCO");

        msg.setCodeGroup(codeGroup);

        rs = component.getMaintainDynamicCode().maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        codeGroup = rs.getResponseMessage().getCodeGroup();
        Assert.assertNotNull(codeGroup);

        Assert.assertEquals("Other codeGroup", codeGroup.getName().getValue());
        Assert.assertEquals("Other Description", codeGroup.getDescription().getValue());
        Assert.assertEquals("NABUCCO", codeGroup.getOwner().getValue());

        // persist DynamicCodeCodeGroup (DELETE)
        codeGroup.setDatatypeState(DatatypeState.DELETED);

        msg.setCodeGroup(codeGroup);

        rs = component.getMaintainDynamicCode().maintainDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
    }

}
