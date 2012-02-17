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
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.code.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.common.dynamiccode.ui.rcp.search.code.model.DynamicCodeCodeSearchViewModel;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;

/**
 * DynamicCodeCodeSearchViewWidgetFactory<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-05
 */
public class DynamicCodeCodeSearchViewWidgetFactory extends WidgetFactory {

    private DynamicCodeCodeSearchViewModel model;

    public static final String LABEL_CODENAME = "code.name";

    public static final String OBSERVE_VALUE_CODENAME = DynamicCodeCodeSearchViewModel.PROPERTY_CODE_NAME;

    public static final String LABEL_CODEDESCRIPTION = "code.description";

    public static final String OBSERVE_VALUE_CODEDESCRIPTION = DynamicCodeCodeSearchViewModel.PROPERTY_CODE_DESCRIPTION;

    public static final String LABEL_CODEOWNER = "code.owner";

    public static final String OBSERVE_VALUE_CODEOWNER = DynamicCodeCodeSearchViewModel.PROPERTY_CODE_OWNER;

    /**
     * Constructs a new DynamicCodeCodeSearchViewWidgetFactory instance.
     *
     * @param aModel the DynamicCodeCodeSearchViewModel.
     * @param nabuccoFormToolKit the NabuccoFormToolkit.
     */
    public DynamicCodeCodeSearchViewWidgetFactory(final NabuccoFormToolkit nabuccoFormToolKit,
            final DynamicCodeCodeSearchViewModel aModel) {
        super(nabuccoFormToolKit);
        model = aModel;
    }

    /**
     * CreateLabelCodeName.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelCodeName(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CODENAME);
    }

    /**
     * CreateInputFieldCodeName.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldCodeName(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_CODENAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelCodeDescription.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelCodeDescription(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CODEDESCRIPTION);
    }

    /**
     * CreateInputFieldCodeDescription.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldCodeDescription(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_CODEDESCRIPTION);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelCodeOwner.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelCodeOwner(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CODEOWNER);
    }

    /**
     * CreateInputFieldCodeOwner.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldCodeOwner(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_CODEOWNER);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }
}
