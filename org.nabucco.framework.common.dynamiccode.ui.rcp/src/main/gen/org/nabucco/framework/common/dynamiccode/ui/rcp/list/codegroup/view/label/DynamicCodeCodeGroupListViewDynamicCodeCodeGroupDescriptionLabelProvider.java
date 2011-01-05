/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionLabelProvider
 *
 * @author Undefined
 */
public class DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionLabelProvider implements
        ILabelProvider {

    /** Constructs a new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionLabelProvider instance. */
    public DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionLabelProvider() {
        super();
    }

    @Override
    public Image getImage(Object arg0) {
        return null;
    }

    @Override
    public String getText(Object arg0) {
        String result = "";
        if ((arg0 instanceof DynamicCodeCodeGroup)) {
            DynamicCodeCodeGroup codegroup = ((DynamicCodeCodeGroup) arg0);
            result = ((codegroup.getDescription() != null) ? codegroup.getDescription().toString()
                    : "");
        }
        return result;
    }

    @Override
    public void addListener(ILabelProviderListener arg0) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isLabelProperty(Object arg0, String arg1) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener arg0) {
    }
}
