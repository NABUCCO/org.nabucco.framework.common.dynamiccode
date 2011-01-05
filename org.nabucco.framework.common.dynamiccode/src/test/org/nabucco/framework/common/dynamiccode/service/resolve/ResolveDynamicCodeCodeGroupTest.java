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
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.util.DynamicCodeTestUtility;

/**
 * ResolveDynamicCodeCodeGroupTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ResolveDynamicCodeCodeGroupTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void testDynamicCodeLookup() throws Exception {
        component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testCodeGroupResolve() throws Exception {

        DynamicCodeCodeGroup parent = DynamicCodeTestUtility.dummyCodeGroup("Parent");
        DynamicCodeCodeGroup child = DynamicCodeTestUtility.dummyCodeGroup("Child");
        parent.getCodeGroupList().add(child);

        parent = DynamicCodeTestUtility.createCodeGroup(this.component, parent);
        child = parent.getCodeGroupList().get(0);

        ServiceRequest<DynamicCodeCodeGroupResolveRq> rq = new ServiceRequest<DynamicCodeCodeGroupResolveRq>(
                super.createServiceContext());

        DynamicCodeCodeGroupResolveRq rqMsg = new DynamicCodeCodeGroupResolveRq();
        rq.setRequestMessage(rqMsg);
        rqMsg.setCodeGroup(child);

        ServiceResponse<DynamicCodeCodeGroupResolveRs> rs = this.component.getResolveDynamicCode()
                .resolveDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());

        DynamicCodeCodeGroupResolveRs rsMsg = rs.getResponseMessage();
        
        child = rsMsg.getCodeGroup();
        parent = rsMsg.getParentGroup();

        Assert.assertNotNull(parent);
        Assert.assertNotNull(parent.getId());
        Assert.assertNotNull(parent.getVersion());
        Assert.assertEquals(DatatypeState.PERSISTENT, parent.getDatatypeState());
        Assert.assertEquals("Parent", (parent.getName()).getValue());

        Assert.assertNotNull(child);
        Assert.assertNotNull(child.getId());
        Assert.assertNotNull(child.getVersion());
        Assert.assertEquals(DatatypeState.PERSISTENT, child.getDatatypeState());
        Assert.assertEquals("Child", (child.getName()).getValue());

        DynamicCodeTestUtility.removeCodeGroup(component, parent);
    }
}
