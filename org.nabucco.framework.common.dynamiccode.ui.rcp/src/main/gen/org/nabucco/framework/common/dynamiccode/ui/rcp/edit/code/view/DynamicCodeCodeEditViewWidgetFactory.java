/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view;

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
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerComposite;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;

/**
 * DynamicCodeCodeEditViewWidgetFactory<p/>@Edit view for datatype DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class DynamicCodeCodeEditViewWidgetFactory extends WidgetFactory {

    private DynamicCodeCodeEditViewModel model;

    public static final String SECTION = "SectionName";

    public static final String LABEL_NAME = "code.name";

    public static final String OBSERVE_VALUE_NAME = DynamicCodeCodeEditViewModel.PROPERTY_CODE_NAME;

    public static final String LABEL_DESCRIPTION = "code.description";

    public static final String OBSERVE_VALUE_DESCRIPTION = DynamicCodeCodeEditViewModel.PROPERTY_CODE_DESCRIPTION;

    public static final String LABEL_OWNER = "code.owner";

    public static final String OBSERVE_VALUE_OWNER = DynamicCodeCodeEditViewModel.PROPERTY_CODE_OWNER;

    public static final String LABEL_CODEGROUPPICKER = "dynamicCode.group";

    public static final String TITLE_CODEGROUPPICKER = "newTITLE";

    public static final String MESSAGE_CODEGROUPPICKER = "newMESSAGE";

    public static final String SHELL_TITLE_CODEGROUPPICKER = "newSHELL_TITLE";

    public static final String MESSAGE_TABLE_CODEGROUPPICKER = "newMESSAGE_TABLE";

    public static final String MESSAGE_COMBO_CODEGROUPPICKER = "newMESSAGE_COMBO";

    public static final String PATH_LABEL_CODEGROUPPICKER = "newPATH_LABEL";

    public static final String OBSERVE_VALUE_CODEGROUPPICKER = DynamicCodeCodeEditViewModel.PROPERTY_GROUP_NAME;

    /**
     * Constructs a new DynamicCodeCodeEditViewWidgetFactory instance.
     *
     * @param model the DynamicCodeCodeEditViewModel.
     * @param nabuccoFormToolKit the NabuccoFormToolkit.
     */
    public DynamicCodeCodeEditViewWidgetFactory(NabuccoFormToolkit nabuccoFormToolKit,
            DynamicCodeCodeEditViewModel model) {
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
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_DESCRIPTION);
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
                params.getInputFieldLabelProvider(), new LabelForDialog(TITLE_CODEGROUPPICKER,
                        MESSAGE_CODEGROUPPICKER, SHELL_TITLE_CODEGROUPPICKER,
                        MESSAGE_TABLE_CODEGROUPPICKER, MESSAGE_COMBO_CODEGROUPPICKER,
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
