/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.comparator;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;

/**
 * DynamicCodeCodeListViewDynamicCodeCodeDescriptionComparator
 *
 * @author Undefined
 */
public class DynamicCodeCodeListViewDynamicCodeCodeDescriptionComparator extends
        NabuccoColumComparator<DynamicCodeCode> {

    /** Constructs a new DynamicCodeCodeListViewDynamicCodeCodeDescriptionComparator instance. */
    public DynamicCodeCodeListViewDynamicCodeCodeDescriptionComparator() {
        super();
    }

    @Override
    public int compareConcrete(DynamicCodeCode object1, DynamicCodeCode object2) {
        return this.compareBasetype(object1.getDescription(), object2.getDescription());
    }
}
