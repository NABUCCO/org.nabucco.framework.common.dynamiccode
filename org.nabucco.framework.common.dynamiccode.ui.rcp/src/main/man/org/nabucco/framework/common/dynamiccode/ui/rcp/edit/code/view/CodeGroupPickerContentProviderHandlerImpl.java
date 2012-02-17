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
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.search.SearchDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.plugin.base.Activator;

/**
 * CodeGroupPickerContentProviderHandlerImpl
 * 
 * @author Michael Krau�e, PRODYNA AG
 */
public class CodeGroupPickerContentProviderHandlerImpl implements
        CodeGroupPickerContentProviderHandler {

    private DynamicCodeCodeGroup currentCodeGroup = null;

    private Map<String, DynamicCodeCodeGroup[]> codeGroups = new HashMap<String, DynamicCodeCodeGroup[]>();

    @Override
    public Map<String, DynamicCodeCodeGroup[]> loadAllDynamicCodeCodeGroup(
            DynamicCodeCodeEditViewModel viewModel) {

        if (this.needsRefresh(viewModel)) {
            this.codeGroups.clear();
            this.loadCodeGroups(viewModel);
        }

        return this.codeGroups;
    }

    /**
     * Checks whether the cache of {@link DynamicCodeCodeGroup} instances must be cleared.
     * 
     * @param viewModel
     *            the view model
     * 
     * @return <b>true</b> if the cache must be refreshed, <b>false</b> if not
     */
    private boolean needsRefresh(DynamicCodeCodeEditViewModel viewModel) {
        if (viewModel == null) {
            return false;
        }
        if (currentCodeGroup == null) {
            return true;
        }

        boolean result = currentCodeGroup != viewModel.getGroup();
        currentCodeGroup = viewModel.getGroup();

        return result;
    }

    private void loadCodeGroups(DynamicCodeCodeEditViewModel viewModel) {

        try {
            SearchDynamicCodeDelegate service = DynamicCodeComponentServiceDelegateFactory
                    .getInstance().getSearchDynamicCode();

            DynamicCodeCodeGroupListMsg codeGroups = service
                    .searchDynamicCodeCodeGroup(new DynamicCodeCodeGroupSearchMsg());

            List<DynamicCodeCodeGroup> searchResult = new ArrayList<DynamicCodeCodeGroup>();
            for (DynamicCodeCodeGroup codeGroup : codeGroups.getDynamicCodeCodeGroupList()) {
                if (!codeGroup.equals(viewModel.getGroup())) {
                    searchResult.add(codeGroup);
                }
            }

            this.codeGroups.put(" ", searchResult.toArray(new DynamicCodeCodeGroup[0]));

        } catch (ClientException e) {
            Activator.getDefault().logError(e);
        }
    }

}
