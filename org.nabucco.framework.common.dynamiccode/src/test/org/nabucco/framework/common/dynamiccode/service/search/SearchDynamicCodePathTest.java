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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.util.DynamicCodeTestUtility;

/**
 * SearchDynamicCodePathTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchDynamicCodePathTest extends RuntimeTestSupport {

    private DynamicCodeComponent component;

    private DynamicCodeCodeGroup nabucco;

    @Before
    public void setUp() throws Exception {
        this.component = super.getComponent(DynamicCodeComponentLocator.getInstance());
        this.nabucco = this.createCodeGroup();
    }

    @After
    public void tearDown() throws Exception {
        DynamicCodeTestUtility.removeCodeGroup(this.component, nabucco);
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

    /**
     * Create a dummy code group tree (nabucco.authorization.user).
     * 
     * @return the code group
     * 
     * @throws ServiceException
     */
    private DynamicCodeCodeGroup createCodeGroup() throws ServiceException {

        DynamicCodeCodeGroup nabucco = new DynamicCodeCodeGroup();
        nabucco.setDatatypeState(DatatypeState.INITIALIZED);
        nabucco.setName("nabucco");

        DynamicCodeCodeGroup authorization = new DynamicCodeCodeGroup();
        authorization.setDatatypeState(DatatypeState.INITIALIZED);
        authorization.setName("authorization");
        nabucco.getCodeGroupList().add(authorization);

        DynamicCodeCodeGroup user = new DynamicCodeCodeGroup();
        user.setDatatypeState(DatatypeState.INITIALIZED);
        user.setName("user");
        authorization.getCodeGroupList().add(user);

        DynamicCodeCode admin = new DynamicCodeCode();
        admin.setDatatypeState(DatatypeState.INITIALIZED);
        admin.setName("ADMIN");
        user.getCodeList().add(admin);

        DynamicCodeCode developer = new DynamicCodeCode();
        developer.setDatatypeState(DatatypeState.INITIALIZED);
        developer.setName("USER");
        user.getCodeList().add(developer);

        DynamicCodeCode tester = new DynamicCodeCode();
        tester.setDatatypeState(DatatypeState.INITIALIZED);
        tester.setName("TESTER");
        user.getCodeList().add(tester);

        nabucco = DynamicCodeTestUtility.createCodeGroup(this.component, nabucco);

        Assert.assertNotNull("CodeGroup 'nabucco.authorization.user' cannot be created.", nabucco);

        return nabucco;
    }

}
