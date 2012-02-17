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
package org.nabucco.framework.common.dynamiccode.facade.component;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for DynamicCodeComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class DynamicCodeComponentLocator extends ComponentLocatorSupport<DynamicCodeComponent> implements
        ComponentLocator<DynamicCodeComponent> {

    private static DynamicCodeComponentLocator instance;

    /**
     * Constructs a new DynamicCodeComponentLocator instance.
     *
     * @param component the Class<DynamicCodeComponent>.
     * @param jndiName the String.
     */
    private DynamicCodeComponentLocator(String jndiName, Class<DynamicCodeComponent> component) {
        super(jndiName, component);
    }

    @Override
    public DynamicCodeComponent getComponent() throws ConnectionException {
        DynamicCodeComponent component = super.getComponent();
        if ((component instanceof DynamicCodeComponentLocal)) {
            return new DynamicCodeComponentLocalProxy(((DynamicCodeComponentLocal) component));
        }
        return component;
    }

    /**
     * Getter for the Instance.
     *
     * @return the DynamicCodeComponentLocator.
     */
    public static DynamicCodeComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new DynamicCodeComponentLocator(DynamicCodeComponent.JNDI_NAME, DynamicCodeComponent.class);
        }
        return instance;
    }
}
