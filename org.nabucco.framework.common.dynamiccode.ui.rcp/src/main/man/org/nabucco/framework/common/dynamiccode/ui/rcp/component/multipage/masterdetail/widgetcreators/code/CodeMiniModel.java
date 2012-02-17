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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.model.MiniViewModel;
import org.nabucco.framework.plugin.base.model.ViewModel;

/**
 * This class represents the analog to EnumerationMiniModel.
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class CodeMiniModel extends MiniViewModel {

    /**
     * This field is needed for the RCP framework -> it calls the getter to retrieve an object with
     * a valid toString representation for the combo box.
     */
    public static final String PROPERTY_VALUE = "value";

    private Code value;

    private CodeContentProvider contentProvider;

    private Method method;

    private Object object;

    /**
     * Constructor.
     * 
     * @param contentProvider
     *            provides Contents for comboBox
     * @param method
     *            will be called to set the value
     * @param code
     *            initial value
     * @param object
     *            object where enumerations is part of
     */
    public CodeMiniModel(CodeContentProvider contentProvider, Method method, Datatype datatype,
            ViewModel externalViewModel, Code code) {
        super(externalViewModel, datatype);
        this.contentProvider = contentProvider;
        this.method = method;
        this.object = datatype;
        this.value = code;
        setInitialized();
    }

    /**
     * Setter.
     * 
     * @param value
     *            value
     */
    public void setValue(final Code value) {

        final Code oldValue = this.value;
        final Code newValue = value;

        this.value = value;
        final Object[] args = { value };

        try {
            method.invoke(object, args);
        } catch (final IllegalArgumentException e) {
            Activator.getDefault().logError(e);
        } catch (final IllegalAccessException e) {
            Activator.getDefault().logError(e);
        } catch (final InvocationTargetException e) {
            Activator.getDefault().logError(e);
        }

        updateProperty(PROPERTY_VALUE, oldValue, newValue);
    }

    public void setValue(final String codeName) {
        final Object[] codesFromCodePath = contentProvider.getElements(null);
        Code newCodeValue = null;
        for (final Object codeFromCodePathAsObject : codesFromCodePath) {
            final Code codeFromCodepath = (Code) codeFromCodePathAsObject;
            if (codeFromCodepath.getName().getValue().equals(codeName)) {
                newCodeValue = codeFromCodepath;
            }
        }
        setValue(newCodeValue);
    }

    /**
     * Getter.
     * 
     * @return value
     */
    public String getValue() {
        if (this.value == null || this.value.getName() == null) {
            return "";
        }
        return this.value.getName().getValue();
    }

}
