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
package org.nabucco.framework.common.dynamiccode.facade.component;

import org.junit.Assert;
import org.junit.Test;

import org.nabucco.framework.base.facade.component.connection.Connection;
import org.nabucco.framework.base.facade.component.connection.ConnectionFactory;
import org.nabucco.framework.base.facade.component.connection.ConnectionSpecification;
import org.nabucco.framework.base.facade.component.connection.ConnectionType;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent;
import org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponentLocator;


/**
 * DynamicCodeComponentLocatorTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeComponentLocatorTest {

    @Test
    public void testDynamicCodeLookup() throws Exception {

        Connection connection = ConnectionFactory.getInstance().createConnection(
                new ConnectionSpecification(ConnectionType.JBOSS));

        DynamicCodeComponent dynamicCodeComponent = DynamicCodeComponentLocator.getInstance()
                .getComponent(connection);
        
        Assert.assertNotNull(dynamicCodeComponent);
        
    }
    
}