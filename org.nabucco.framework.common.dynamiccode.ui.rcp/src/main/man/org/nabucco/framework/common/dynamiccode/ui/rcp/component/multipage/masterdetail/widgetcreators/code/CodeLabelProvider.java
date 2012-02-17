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
package org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.widgetcreators.code;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.framework.base.facade.datatype.code.Code;

/**
 * CodeLabelProvider
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class CodeLabelProvider implements ILabelProvider {

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImage(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(Object element) {

        Code code = (Code) element;
        return code.getName().getValue().toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

}
