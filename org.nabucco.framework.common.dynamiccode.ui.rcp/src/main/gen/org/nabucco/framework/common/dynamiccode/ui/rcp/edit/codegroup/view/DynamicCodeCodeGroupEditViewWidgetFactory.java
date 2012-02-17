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
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerComposite;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;

/**
 * DynamicCodeCodeGroupEditViewWidgetFactory<p/>@Edit view for datatype DynamicCodeCodeGroup<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class DynamicCodeCodeGroupEditViewWidgetFactory extends WidgetFactory {

    private DynamicCodeCodeGroupEditViewModel model;

    public static final String SECTION = "SectionName";

    public static final String LABEL_NAME = "codeGroup.name";

    public static final String OBSERVE_VALUE_NAME = DynamicCodeCodeGroupEditViewModel.PROPERTY_CODEGROUP_NAME;

    public static final String LABEL_DESCRIPTION = "codeGroup.description";

    public static final String OBSERVE_VALUE_DESCRIPTION = DynamicCodeCodeGroupEditViewModel.PROPERTY_CODEGROUP_DESCRIPTION;

    public static final String LABEL_OWNER = "codeGroup.owner";

    public static final String OBSERVE_VALUE_OWNER = DynamicCodeCodeGroupEditViewModel.PROPERTY_CODEGROUP_OWNER;

    public static final String LABEL_TENANT = "codeGroup.tenant";

    public static final String OBSERVE_VALUE_TENANT = DynamicCodeCodeGroupEditViewModel.PROPERTY_CODEGROUP_TENANT;

    public static final String LABEL_CODEGROUPPICKER = "dynamicCode.group";

    public static final String TITLE_CODEGROUPPICKER = "newTITLE";

    public static final String MESSAGE_CODEGROUPPICKER = "newMESSAGE";

    public static final String SHELL_TITLE_CODEGROUPPICKER = "newSHELL_TITLE";

    public static final String MESSAGE_TABLE_CODEGROUPPICKER = "newMESSAGE_TABLE";

    public static final String MESSAGE_COMBO_CODEGROUPPICKER = "newMESSAGE_COMBO";

    public static final String PATH_LABEL_CODEGROUPPICKER = "newPATH_LABEL";

    public static final String OBSERVE_VALUE_CODEGROUPPICKER = DynamicCodeCodeGroupEditViewModel.PROPERTY_PARENTGROUP_NAME;

    /**
     * Constructs a new DynamicCodeCodeGroupEditViewWidgetFactory instance.
     *
     * @param model the DynamicCodeCodeGroupEditViewModel.
     * @param nabuccoFormToolKit the NabuccoFormToolkit.
     */
    public DynamicCodeCodeGroupEditViewWidgetFactory(NabuccoFormToolkit nabuccoFormToolKit,
            DynamicCodeCodeGroupEditViewModel model) {
        super(nabuccoFormToolKit);
        this.model = model;
    }

    /**
     * CreateSectionHeading.
     *
     * @param parent the Composite.
     * @return the Section.
     */
    public Section createSectionHeading(Composite parent) {
        return nabuccoFormToolKit.createSection(parent, SECTION, new GridLayout());
    }

    /**
     * CreateLabelName.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelName(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_NAME);
    }

    /**
     * CreateInputFieldName.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldName(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_NAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelDescription.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelDescription(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_DESCRIPTION);
    }

    /**
     * CreateInputFieldDescription.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldDescription(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_DESCRIPTION);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelOwner.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelOwner(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_OWNER);
    }

    /**
     * CreateInputFieldOwner.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldOwner(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_OWNER);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelTenant.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelTenant(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_TENANT);
    }

    /**
     * CreateInputFieldTenant.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldTenant(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_TENANT);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelCodeGroupPicker.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelCodeGroupPicker(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_CODEGROUPPICKER);
    }

    /**
     * CreateElementPickerCodeGroupPicker.
     *
     * @param params the ElementPickerParameter.
     * @param parent the Composite.
     */
    public void createElementPickerCodeGroupPicker(Composite parent, ElementPickerParameter params) {
        ElementPickerComposite picker = new ElementPickerComposite(parent, SWT.NONE, params,
                params.getInputFieldLabelProvider(), new LabelForDialog(TITLE_CODEGROUPPICKER, MESSAGE_CODEGROUPPICKER,
                        SHELL_TITLE_CODEGROUPPICKER, MESSAGE_TABLE_CODEGROUPPICKER, MESSAGE_COMBO_CODEGROUPPICKER,
                        PATH_LABEL_CODEGROUPPICKER));
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement;
        IObservableValue modelElement;
        uiElement = SWTObservables.observeText(picker.getInputText(), SWT.Modify);
        modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_CODEGROUPPICKER);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        picker.addElementSelected(new CodeGroupPickerHandler(model));
    }
}
