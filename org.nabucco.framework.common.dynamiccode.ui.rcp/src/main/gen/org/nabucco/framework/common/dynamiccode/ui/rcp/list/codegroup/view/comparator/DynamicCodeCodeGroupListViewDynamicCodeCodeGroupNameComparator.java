/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.comparator;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;

/**
 * DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator
 *
 * @author Undefined
 */
public class DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator extends
        NabuccoColumComparator<DynamicCodeCodeGroup> {

    /** Constructs a new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator instance. */
    public DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator() {
        super();
    }

    @Override
    public int compareConcrete(DynamicCodeCodeGroup object1, DynamicCodeCodeGroup object2) {
        return this.compareBasetype(object1.getName(), object2.getName());
    }
}
