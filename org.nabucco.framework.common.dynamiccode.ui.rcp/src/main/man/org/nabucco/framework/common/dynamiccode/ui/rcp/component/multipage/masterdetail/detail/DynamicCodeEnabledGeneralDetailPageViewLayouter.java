/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.detail;

import java.lang.reflect.Method;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.widgetcreators.code.WidgetCreatorForCode;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.GeneralDetailPageViewLayouter;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.BaseTypeWidgetFactory;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * DynamicCodeEnabledGeneralDetailPageViewLayouter
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class DynamicCodeEnabledGeneralDetailPageViewLayouter extends GeneralDetailPageViewLayouter {

    /**
     * Creates a new {@link DynamicCodeEnabledGeneralDetailPageViewLayouter} instance.
     * 
     * @param detailTitle
     *            the section title
     */
    public DynamicCodeEnabledGeneralDetailPageViewLayouter(String detailTitle) {
        super(detailTitle);

//        super.addInitializer(Code.class, new InitializerForCode());
    }

    @Override
    protected Control layoutElement(Composite parent, BaseTypeWidgetFactory widgetFactory,
            Datatype datatype, String masterBlockId, Object property, String propertyName,
            GridData data, boolean readOnly, ViewModel externalViewModel,
            NabuccoMessageManager messageManager) {

        Class<?> propertyClass = getJavaFieldClassViaGetterMethod(datatype.getClass(), propertyName);

        if (propertyClass != Code.class) {
            // delegate to superclass
            return super.layoutElement(parent, widgetFactory, datatype, masterBlockId, property,
                    propertyName, data, readOnly, externalViewModel, messageManager);
        }

        String firstChar = propertyName.substring(0, 1);
        String lastPart = propertyName.substring(1);

        Label label = widgetFactory.createLabel(parent, masterBlockId + "." + propertyName);
        label.setToolTipText(label.getText());
        label.setLayoutData(data);

        try {
            Method method = datatype.getClass().getMethod(
                    "set" + firstChar.toUpperCase() + lastPart, new Class[] { propertyClass });

            NabuccoFormToolkit nft = widgetFactory.getNabuccoFormToolKit();
            WidgetCreatorForCode widgetCreatorForCode = new WidgetCreatorForCode(nft);
            Control newWidget = widgetCreatorForCode.createViewInputElement(parent, property,
                    method, datatype, readOnly, externalViewModel, messageManager, propertyName);

            if (newWidget == null) {
                Activator.getDefault().logError("Cannot create Code Widget [null].");
            } else {
                super.setDataForWidget(data, newWidget);
            }

            return newWidget;

        } catch (SecurityException e) {
            Activator.getDefault().logError(e);
        } catch (NoSuchMethodException e) {
            Activator.getDefault().logError(e);
        }
        return null;

    }

    /**
     * Internal helper method.
     * 
     * @param fieldName
     * @return
     */
    private static String deriveGetterMethodNameAccordingToJavaBeansNamingConventions(
            String fieldName) {

        StringBuilder rv = new StringBuilder();

        rv.append("get");
        rv.append(fieldName.substring(0, 1).toUpperCase());
        rv.append(fieldName.substring(1));

        return rv.toString();
    }

    /**
     * Internal helper method.
     * 
     * @param clazz
     * @param javaFieldName
     * @return
     */
    private static Class<?> getJavaFieldClassViaGetterMethod(Class<?> clazz, String javaFieldName) {

        try {
            String getterName = deriveGetterMethodNameAccordingToJavaBeansNamingConventions(javaFieldName);
            Class<?>[] methodArgs = new Class<?>[0];
            Method method = clazz.getMethod(getterName, methodArgs);
            Class<?> fieldClass = method.getReturnType();

            return fieldClass;
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            return null;
        }

    }

}
