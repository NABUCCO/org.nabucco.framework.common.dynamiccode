/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.comparator;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;

/**
 * DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionComparator
 *
 * @author Undefined
 */
public class DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionComparator extends
        NabuccoColumComparator<DynamicCodeCodeGroup> {

    /** Constructs a new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionComparator instance. */
    public DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionComparator() {
        super();
    }

    @Override
    public int compareConcrete(DynamicCodeCodeGroup object1, DynamicCodeCodeGroup object2) {
        return this.compareBasetype(object1.getDescription(), object2.getDescription());
    }
}
