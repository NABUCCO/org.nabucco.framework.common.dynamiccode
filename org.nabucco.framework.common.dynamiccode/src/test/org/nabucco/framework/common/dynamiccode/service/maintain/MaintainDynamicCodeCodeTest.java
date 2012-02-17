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
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeMaintainMsg;

/**
 * MaintainDynamicCodeCodeTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainDynamicCodeCodeTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void testDynamicCodeLookup() throws Exception {
        this.component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testMaintainCode() throws Exception {

        DynamicCodeCode code = new DynamicCodeCode();
        code.setName("Test Code");
        code.setDescription("This is a test code");
        code.setOwner("PRODYNA");
        code.setDatatypeState(DatatypeState.INITIALIZED);

        DynamicCodeCodeMaintainMsg msg = new DynamicCodeCodeMaintainMsg();
        msg.setCode(code);

        ServiceRequest<DynamicCodeCodeMaintainMsg> rq = new ServiceRequest<DynamicCodeCodeMaintainMsg>(
                super.createServiceContext());
        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeMaintainMsg> rs = this.component.getMaintainDynamicCode()
                .maintainDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        code = rs.getResponseMessage().getCode();
        Assert.assertNotNull(code);

        Assert.assertEquals("Test Code", code.getName().getValue());
        Assert.assertEquals("This is a test code", code.getDescription().getValue());
        Assert.assertEquals("PRODYNA", code.getOwner().getValue());

        code.setDatatypeState(DatatypeState.MODIFIED);
        code.getName().setValue("Other code");
        code.getDescription().setValue("Other Description");
        code.getOwner().setValue("NABUCCO");

        msg.setCode(code);

        rs = component.getMaintainDynamicCode().maintainDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        code = rs.getResponseMessage().getCode();
        Assert.assertNotNull(code);

        Assert.assertEquals("Other code", code.getName().getValue());
        Assert.assertEquals("Other Description", code.getDescription().getValue());
        Assert.assertEquals("NABUCCO", code.getOwner().getValue());

        code.setDatatypeState(DatatypeState.DELETED);

        msg.setCode(code);

        rs = component.getMaintainDynamicCode().maintainDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

    }

}
