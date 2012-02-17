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
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.facade.service.search.SearchDynamicCode;
import org.nabucco.framework.common.dynamiccode.util.DynamicCodeTestUtility;

/**
 * SearchDynamicCodeCodeGroupTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchDynamicCodeCodeGroupTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    @Before
    public void testDynamicCodeLookup() throws Exception {
        this.component = super.getComponent(DynamicCodeComponentLocator.getInstance());
    }

    @Test
    public void testCodeGroupSearch() throws Exception {

        DynamicCodeCodeGroup group = DynamicCodeTestUtility.createCodeGroup(this.component,
                DynamicCodeTestUtility.dummyCodeGroup());

        SearchDynamicCode searchService = this.component.getSearchDynamicCode();

        DynamicCodeCodeGroupSearchMsg msg = new DynamicCodeCodeGroupSearchMsg();
        msg.setName(group.getName());
        msg.setOwner(group.getOwner());
        msg.setDescription(group.getDescription());

        ServiceRequest<DynamicCodeCodeGroupSearchMsg> rq = new ServiceRequest<DynamicCodeCodeGroupSearchMsg>(
                super.getServiceContext());
        rq.setRequestMessage(msg);

        ServiceResponse<DynamicCodeCodeGroupListMsg> rs = searchService.searchDynamicCodeCodeGroup(rq);

        Assert.assertNotNull(rs);
        Assert.assertNotNull(rs.getResponseMessage());
        Assert.assertEquals(1, rs.getResponseMessage().getDynamicCodeCodeGroupList().size());

        group = rs.getResponseMessage().getDynamicCodeCodeGroupList().get(0);
        Assert.assertNotNull(group);

        DynamicCodeTestUtility.removeCodeGroup(this.component, group);
    }

}
