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
package org.nabucco.framework.common.dynamiccode.service.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;

/**
 * SearchDynamicCodePathTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchDynamicCodePathTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void setUp() throws Exception {
        this.component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testCodePathSearch() throws Exception {

        CodePathSearchMsg msg = new CodePathSearchMsg();
        msg.setCodePath(new CodePath("nabucco.authorization.user"));

        ServiceRequest<CodePathSearchMsg> rq = new ServiceRequest<CodePathSearchMsg>(
                super.getServiceContext());

        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeListMsg> rs = this.component.getSearchDynamicCode()
                .searchByCodePath(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertEquals(3, rs.getResponseMessage().getCodeList().size());
    }

    @Test
    public void testCodeGroupPathSearch() throws Exception {

        CodePathSearchMsg msg = new CodePathSearchMsg();
        msg.setCodePath(new CodePath("nabucco.authorization.user"));

        ServiceRequest<CodePathSearchMsg> rq = new ServiceRequest<CodePathSearchMsg>(
                super.getServiceContext());

        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeGroupMsg> rs = this.component.getSearchDynamicCode()
                .searchByCodeGroupPath(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertNotNull(rs.getResponseMessage().getCodeGroup());
        Assert.assertEquals(rs.getResponseMessage().getCodeGroup().getName().getValue(), "user");
    }

}
