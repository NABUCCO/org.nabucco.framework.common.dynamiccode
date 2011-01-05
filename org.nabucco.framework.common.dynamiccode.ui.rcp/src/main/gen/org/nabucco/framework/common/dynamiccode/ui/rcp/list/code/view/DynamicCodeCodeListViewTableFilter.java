/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view;

import org.eclipse.jface.viewers.Viewer;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableFilter;

/**
 * DynamicCodeCodeListViewTableFilter<p/>ListView for DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-16
 */
public class DynamicCodeCodeListViewTableFilter extends NabuccoTableFilter {

    /** Constructs a new DynamicCodeCodeListViewTableFilter instance. */
    public DynamicCodeCodeListViewTableFilter() {
        super();
    }

    @Override
    public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
        boolean result = false;
        if (((null == searchFilter.getFilter()) || (0 == searchFilter.getFilter().length()))) {
            result = true;
        } else if ((element instanceof DynamicCodeCode)) {
            DynamicCodeCode datatype = ((DynamicCodeCode) element);
            result = (result || this.contains(datatype.getOwner(), searchFilter.getFilter()));
            result = (result || this.contains(datatype.getName(), searchFilter.getFilter()));
            result = (result || this.contains(datatype.getDescription(), searchFilter.getFilter()));
        }
        return result;
    }
}
