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
package org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view.DynamicCodeCodeEditView;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.view.DynamicCodeCodeGroupEditView;
import org.nabucco.framework.plugin.base.component.overview.model.NabuccoOverviewAction;
import org.nabucco.framework.plugin.base.component.overview.model.NabuccoOverviewModel;
import org.nabucco.framework.plugin.base.component.overview.view.NabuccoOverviewView;

/**
 * DynamicCodeOverviewView
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeOverviewView extends NabuccoOverviewView {

    public final static String ID = "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.DynamicCodeOverviewView";

    /**
     * Creates a new {@link DynamicCodeOverviewView} instance.
     */
    public DynamicCodeOverviewView() {
        this.createModel();
    }

    @Override
    protected void createFormControl(Form form) {
        getLayouter().layout(form.getBody(), getMessageManager(), getModel());
    }

    /**
     * Create the view model
     */
    private void createModel() {

        NabuccoOverviewModel localModel = new NabuccoOverviewModel();

        NabuccoOverviewAction action = new NabuccoOverviewAction(
                "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.edit.code.description",
                "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.edit.code.name",
                DynamicCodeCodeEditView.ID);
        localModel.getComponentActions().add(action);

        action = new NabuccoOverviewAction(
                "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.edit.codegroup.description",
                "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.edit.codegroup.name",
                DynamicCodeCodeGroupEditView.ID);
        localModel.getComponentActions().add(action);

        model = localModel;

        // TODO old, remove later
        /*
         * NabuccoOverviewModel localModel = new NabuccoOverviewModel();
         * 
         * String description = "Create a new DynamicCode Code"; String label = "New Code";
         * 
         * NabuccoOverviewAction action = new NabuccoOverviewAction(label, description,
         * DynamicCodeCodeEditView.ID); localModel.getComponentActions().add(action);
         * 
         * model = localModel;
         */
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void createHeadControl(Composite head) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void createToolbarActions(IToolBarManager toolbarManager) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getManagedFormTitle() {
        // return "DynamicCode Overview";
        return I18N.i18n("org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view");
    }

    public DynamicCodeOverviewLayouter getLayouter() {
        return new DynamicCodeOverviewLayouter();
    }

}
