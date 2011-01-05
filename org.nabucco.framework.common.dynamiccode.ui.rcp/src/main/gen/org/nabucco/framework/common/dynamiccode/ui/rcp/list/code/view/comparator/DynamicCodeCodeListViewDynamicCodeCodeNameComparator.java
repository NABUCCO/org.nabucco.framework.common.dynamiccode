/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.comparator;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;

/**
 * DynamicCodeCodeListViewDynamicCodeCodeNameComparator
 *
 * @author Undefined
 */
public class DynamicCodeCodeListViewDynamicCodeCodeNameComparator extends
        NabuccoColumComparator<DynamicCodeCode> {

    /** Constructs a new DynamicCodeCodeListViewDynamicCodeCodeNameComparator instance. */
    public DynamicCodeCodeListViewDynamicCodeCodeNameComparator() {
        super();
    }

    @Override
    public int compareConcrete(DynamicCodeCode object1, DynamicCodeCode object2) {
        return this.compareBasetype(object1.getName(), object2.getName());
    }
}
