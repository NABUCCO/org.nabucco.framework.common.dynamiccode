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
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.model.DynamicCodeCodeGroupSearchViewModel;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;

/**
 * DynamicCodeCodeGroupSearchViewWidgetFactory<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-05
 */
public class DynamicCodeCodeGroupSearchViewWidgetFactory extends WidgetFactory {

    private DynamicCodeCodeGroupSearchViewModel model;

    public static final String LABEL_CODEGROUPNAME = "codeGroup.name";

    public static final String OBSERVE_VALUE_CODEGROUPNAME = DynamicCodeCodeGroupSearchViewModel.PROPERTY_CODEGROUP_NAME;

    public static final String LABEL_CODEGROUPDESCRIPTION = "codeGroup.description";

    public static final String OBSERVE_VALUE_CODEGROUPDESCRIPTION = DynamicCodeCodeGroupSearchViewModel.PROPERTY_CODEGROUP_DESCRIPTION;

    public static final String LABEL_CODEGROUPOWNER = "codeGroup.owner";

    public static final String OBSERVE_VALUE_CODEGROUPOWNER = DynamicCodeCodeGroupSearchViewModel.PROPERTY_CODEGROUP_OWNER;

    /**
     * Constructs a new DynamicCodeCodeGroupSearchViewWidgetFactory instance.
     *
     * @param aModel the DynamicCodeCodeGroupSearchViewModel.
     * @param nabuccoFormToolKit the NabuccoFormToolkit.
     */
    public DynamicCodeCodeGroupSearchViewWidgetFactory(final NabuccoFormToolkit nabuccoFormToolKit,
            final DynamicCodeCodeGroupSearchViewModel aModel) {
        super(nabuccoFormToolKit);
        model = aModel;
    }

    /**
     * CreateLabelCodeGroupName.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelCodeGroupName(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CODEGROUPNAME);
    }

    /**
     * CreateInputFieldCodeGroupName.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldCodeGroupName(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_CODEGROUPNAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelCodeGroupDescription.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelCodeGroupDescription(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CODEGROUPDESCRIPTION);
    }

    /**
     * CreateInputFieldCodeGroupDescription.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldCodeGroupDescription(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_CODEGROUPDESCRIPTION);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelCodeGroupOwner.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelCodeGroupOwner(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CODEGROUPOWNER);
    }

    /**
     * CreateInputFieldCodeGroupOwner.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldCodeGroupOwner(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_CODEGROUPOWNER);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }
}
