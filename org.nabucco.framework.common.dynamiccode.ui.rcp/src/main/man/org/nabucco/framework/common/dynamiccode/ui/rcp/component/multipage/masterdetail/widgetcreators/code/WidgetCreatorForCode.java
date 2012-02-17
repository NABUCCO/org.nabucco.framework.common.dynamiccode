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

import java.lang.reflect.Method;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.AbstractBaseTypeWidgetCreator;
import org.nabucco.framework.plugin.base.component.picker.combo.ElementPickerCombo;
import org.nabucco.framework.plugin.base.component.picker.combo.ElementPickerComboParameter;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * WidgetCreatorForCode
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class WidgetCreatorForCode extends AbstractBaseTypeWidgetCreator<Code> {

    /**
     * Constructor.
     * 
     * @param nft
     *            value
     */
    public WidgetCreatorForCode(NabuccoFormToolkit nft) {
        super(nft);
    }

    @Override
    protected Control createWidget(Composite parent, Code code, Method method, Object object,
            boolean readOnly, ViewModel externalViewModel, NabuccoMessageManager messageManager,
            String propertyName) {

        final String codePathGetterName = deriveCodePathGetterNameFromSetterName(method.getName());
        final CodePath codePath = getCodePathViaReflection(object, codePathGetterName);

        final CodeContentProvider codeContentProvider = new CodeContentProvider(codePath);

        final ElementPickerComboParameter params = new ElementPickerComboParameter(
                codeContentProvider, new CodeLabelProvider());

        // ElementPickerCombo elementCombo = new ElementPickerCombo(parent, params);
        ElementPickerCombo elementCombo = super.getFormToolkit().createElementPickerCombo(parent,
                params, readOnly, true);

        // combo.setLayoutData(gridData);

        final DataBindingContext bindingContext = new DataBindingContext();
        final IObservableValue uiElement = SWTObservables.observeSelection(elementCombo.getCombo());

        if (object instanceof Datatype) {

            final CodeMiniModel model = new CodeMiniModel(codeContentProvider, method,
                    (Datatype) object, externalViewModel, code);
            final IObservableValue modelElement = BeansObservables.observeValue(model,
                    CodeMiniModel.PROPERTY_VALUE);
            bindingContext.bindValue(uiElement, modelElement, null, null);
            elementCombo.addSelectionListener(new CodeComboBoxHandler(model));
        }

        return elementCombo;
    }

    private String deriveCodePathGetterNameFromSetterName(String getterName) {

        final StringBuilder codePathGetterName = new StringBuilder();

        codePathGetterName.append("get");
        codePathGetterName.append(getterName.substring(3));
        codePathGetterName.append("CodePath");

        return codePathGetterName.toString();
    }

    private CodePath getCodePathViaReflection(Object object, String codePathGetterName) {

        try {

            // get Method object
            final Class<?> objectClass = object.getClass();
            final Class<?>[] methodArgs = new Class<?>[0];
            final Method codePathGetterMethod = objectClass.getMethod(codePathGetterName,
                    methodArgs);

            final Object codePathAsObject = codePathGetterMethod.invoke(object);
            final CodePath codePath = (CodePath) codePathAsObject;
            return codePath;

        } catch (final Exception e) {

            Activator.getDefault().logError(e);
            return null;
        }

    }

}
