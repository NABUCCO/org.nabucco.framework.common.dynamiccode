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
package org.nabucco.framework.common.dynamiccode.service.produce;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeMsg;

/**
 * ProduceDynamicCodeCodeTest
 * 
 * @author Stefanie Feld, PRODYNA AG
 */
public class ProduceDynamicCodeCodeTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void setUp() throws Exception {
        component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testProduceCode() throws Exception {
        ServiceRequest<EmptyServiceMessage> rq = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        rq.setRequestMessage(new EmptyServiceMessage());

        ServiceResponse<DynamicCodeCodeMsg> rs = component.getProduceDynamicCode()
                .produceDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCode());

        DynamicCodeCode code = rs.getResponseMessage().getCode();

        Assert.assertNotNull(code);
        Assert.assertEquals(DatatypeState.INITIALIZED, code.getDatatypeState());

        Assert.assertNotNull(code.getOwner());
        Assert.assertNotNull(code.getName());
        Assert.assertNotNull(code.getDescription());
    }
}
