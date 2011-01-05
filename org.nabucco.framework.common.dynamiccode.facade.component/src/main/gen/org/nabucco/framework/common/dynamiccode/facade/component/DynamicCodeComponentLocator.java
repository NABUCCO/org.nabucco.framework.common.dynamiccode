/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.component;

import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for DynamicCodeComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class DynamicCodeComponentLocator extends ComponentLocatorSupport<DynamicCodeComponent>
        implements ComponentLocator<DynamicCodeComponent> {

    private static final String JNDI_NAME = ((((ComponentLocator.COMPONENTS + "/") + DynamicCodeComponent.COMPONENT_NAME) + "/") + "org.nabucco.framework.common.dynamiccode.facade.component.DynamicCodeComponent");

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

    /**
     * Getter for the Instance.
     *
     * @return the DynamicCodeComponentLocator.
     */
    public static DynamicCodeComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new DynamicCodeComponentLocator(JNDI_NAME, DynamicCodeComponent.class);
        }
        return instance;
    }
}
