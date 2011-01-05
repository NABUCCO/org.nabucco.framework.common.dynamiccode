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
package org.nabucco.framework.common.dynamiccode.service.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;
import org.nabucco.framework.common.dynamiccode.util.DynamicCodeTestUtility;

/**
 * SearchDynamicCodeCodeTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchDynamicCodeCodeTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void testDynamicCodeLookup() throws Exception {
        component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testCodeSearch() throws Exception {

        DynamicCodeCode code = DynamicCodeTestUtility.createCode(this.component,
                DynamicCodeTestUtility.dummyCode());

        DynamicCodeCodeSearchMsg msg = new DynamicCodeCodeSearchMsg();
        msg.setName(code.getName());
        msg.setOwner(code.getOwner());
        msg.setDescription(code.getDescription());

        ServiceRequest<DynamicCodeCodeSearchMsg> rq = new ServiceRequest<DynamicCodeCodeSearchMsg>(
                super.createServiceContext());
        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeListMsg> rs = this.component.getSearchDynamicCode()
                .searchDynamicCodeCode(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertEquals(1, rs.getResponseMessage().getCodeList().size());

        code = rs.getResponseMessage().getCodeList().get(0);
        Assert.assertNotNull(code);

        DynamicCodeTestUtility.removeCode(this.component, code);
    }

}
