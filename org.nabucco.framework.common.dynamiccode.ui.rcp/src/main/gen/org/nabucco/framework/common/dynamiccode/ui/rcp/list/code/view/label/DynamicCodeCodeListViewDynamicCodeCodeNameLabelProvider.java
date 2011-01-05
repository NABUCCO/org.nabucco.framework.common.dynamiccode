/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;

/**
 * DynamicCodeCodeListViewDynamicCodeCodeNameLabelProvider
 *
 * @author Undefined
 */
public class DynamicCodeCodeListViewDynamicCodeCodeNameLabelProvider implements ILabelProvider {

    /** Constructs a new DynamicCodeCodeListViewDynamicCodeCodeNameLabelProvider instance. */
    public DynamicCodeCodeListViewDynamicCodeCodeNameLabelProvider() {
        super();
    }

    @Override
    public Image getImage(Object arg0) {
        return null;
    }

    @Override
    public String getText(Object arg0) {
        String result = "";
        if ((arg0 instanceof DynamicCodeCode)) {
            DynamicCodeCode code = ((DynamicCodeCode) arg0);
            result = ((code.getName() != null) ? code.getName().toString() : "");
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
