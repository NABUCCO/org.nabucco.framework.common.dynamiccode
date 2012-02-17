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
package org.nabucco.framework.common.dynamiccode.service.resolve;

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
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeResolveRs;
import org.nabucco.framework.common.dynamiccode.util.DynamicCodeTestUtility;

/**
 * ResolveDynamicCodeCodeTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ResolveDynamicCodeCodeTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void testDynamicCodeLookup() throws Exception {
        component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testCodeResolve() throws Exception {

        DynamicCodeCodeGroup group = DynamicCodeTestUtility.dummyCodeGroup("Group");
        DynamicCodeCode code = DynamicCodeTestUtility.dummyCode("Code");
        group.getCodeList().add(code);

        group = DynamicCodeTestUtility.createCodeGroup(this.component, group);
        code = group.getCodeList().get(0);

        ServiceRequest<DynamicCodeCodeResolveRq> rq = new ServiceRequest<DynamicCodeCodeResolveRq>(
                super.createServiceContext());

        DynamicCodeCodeResolveRq rqMsg = new DynamicCodeCodeResolveRq();
        rq.setRequestMessage(rqMsg);
        rqMsg.setCode(code);

        ServiceResponse<DynamicCodeCodeResolveRs> rs = this.component.getResolveDynamicCode()
                .resolveDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        DynamicCodeCodeResolveRs rsMsg = rs.getResponseMessage();

        code = rsMsg.getCode();
        group = rsMsg.getParentGroup();

        Assert.assertNotNull(group);
        Assert.assertNotNull(group.getId());
        Assert.assertNotNull(group.getVersion());
        Assert.assertEquals(DatatypeState.PERSISTENT, group.getDatatypeState());
        Assert.assertEquals("Group", (group.getName()).getValue());

        Assert.assertNotNull(code);
        Assert.assertNotNull(code.getId());
        Assert.assertNotNull(code.getVersion());
        Assert.assertEquals(DatatypeState.PERSISTENT, code.getDatatypeState());
        Assert.assertEquals("Code", (code.getName()).getValue());

        DynamicCodeTestUtility.removeCodeGroup(component, group);

    }
}
