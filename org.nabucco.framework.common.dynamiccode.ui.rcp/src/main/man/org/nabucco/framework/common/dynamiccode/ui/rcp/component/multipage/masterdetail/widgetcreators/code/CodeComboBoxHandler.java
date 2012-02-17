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

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;

/**
 * This class is analogous to EnumComboBoxHandler.
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class CodeComboBoxHandler implements SelectionListener {

    CodeMiniModel model;

    /**
     * Constructor.
     * 
     * @param model
     *            contains enumeration which will be updated.
     */
    public CodeComboBoxHandler(final CodeMiniModel model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     * 
     * Empty implementation. Does nothing
     */
    @Override
    public void widgetDefaultSelected(SelectionEvent selectionEvent) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void widgetSelected(final SelectionEvent selectionEvent) {
        if ((selectionEvent.widget instanceof Combo)) {
            Combo combo = ((Combo) selectionEvent.widget);
            model.setValue(combo.getText());
        }

    }

}
