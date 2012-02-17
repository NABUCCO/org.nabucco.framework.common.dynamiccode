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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.CodePathSearchMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.search.SearchDynamicCodeDelegate;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerContentProvider;

/**
 * CodeContentProvider
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class CodeContentProvider implements ElementPickerContentProvider {

    private CodePath codePath;

    private List<DynamicCodeCode> codes;

    public CodeContentProvider(final CodePath codePath) {

        this.codePath = codePath;

        // get the codes from the searchByCodePath service operation
        try {
            SearchDynamicCodeDelegate searchDynamicCodeDelegate = DynamicCodeComponentServiceDelegateFactory
                    .getInstance().getSearchDynamicCode();

            CodePathSearchMsg rqMsg = new CodePathSearchMsg();
            rqMsg.setCodePath(this.codePath);
            DynamicCodeCodeListMsg rsMsg = searchDynamicCodeDelegate.searchByCodePath(rqMsg);
            codes = rsMsg.getCodeList();
        } catch (ClientException e) {

            // in such an error case (most likely, the code path does not exist in the database), we
            // want the rest of this Master Detail widget to behave normally as if nothing happened
            // -> initialize codes with an empty list
            codes = new ArrayList<DynamicCodeCode>();
            Activator.getDefault().logError("Problem when accessing SearchDynamicCodeDelegate:");
            Activator.getDefault().logError(e);
        }

    }

    @Override
    public String[] getPaths() {
        return null;
    }

    @Override
    public Object[] getElements(Object inputElement) {

        return codes.toArray(new Code[codes.size()]);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

}
