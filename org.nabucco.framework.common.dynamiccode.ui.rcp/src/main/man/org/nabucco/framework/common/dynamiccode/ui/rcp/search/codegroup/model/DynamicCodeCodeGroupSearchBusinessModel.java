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
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.model;

import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeGroupSearchMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup.DynamicCodeCodeGroupListViewBrowserElement;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.search.SearchDynamicCodeDelegate;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchModel;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;

/**
 * DynamicCodeCodeGroupSearchBusinessModel
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCodeGroupSearchBusinessModel implements NabuccoComponentSearchModel {

    public final static String ID = "org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.model.DynamicCodeCodeGroupSearchBusinessModel";

    /**
     * {@inheritDoc}
     */
    @Override
    public DynamicCodeCodeGroupListViewBrowserElement search(
            NabuccoComponentSearchParameter nabuccoComponentSearchParameter) {

        DynamicCodeCodeGroupListViewBrowserElement result = null;
        if (nabuccoComponentSearchParameter instanceof DynamicCodeCodeGroupSearchViewModel) {
            try {
                DynamicCodeCodeGroupSearchViewModel searchViewModel = (DynamicCodeCodeGroupSearchViewModel) nabuccoComponentSearchParameter;

                SearchDynamicCodeDelegate searchDelegate = DynamicCodeComponentServiceDelegateFactory
                        .getInstance().getSearchDynamicCode();

                DynamicCodeCodeGroupSearchMsg request = createDynamicCodeCodeSearchMsg(searchViewModel);

                DynamicCodeCodeGroupListMsg response = searchDelegate
                        .searchDynamicCodeCodeGroup(request);

                if (response.getDynamicCodeCodeGroupList().size() > 0) {
                    result = new DynamicCodeCodeGroupListViewBrowserElement(
                            response.getDynamicCodeCodeGroupList());
                }

            } catch (ClientException se) {
                Activator.getDefault().logError(se);

            }
        }
        return result;
    }

    private DynamicCodeCodeGroupSearchMsg createDynamicCodeCodeSearchMsg(
            DynamicCodeCodeGroupSearchViewModel searchViewModel) {

        DynamicCodeCodeGroupSearchMsg msg = new DynamicCodeCodeGroupSearchMsg();

        Name name = this.getNameFromModel(searchViewModel);
        Owner owner = this.getOwnerFromModel(searchViewModel);
        Description description = this.getDescriptionFromModel(searchViewModel);

        msg.setName(name);
        msg.setOwner(owner);
        msg.setDescription(description);

        return msg;
    }

    private Name getNameFromModel(DynamicCodeCodeGroupSearchViewModel searchViewModel) {
        String name = searchViewModel.getCodeGroupName();
        if (name == null || name.isEmpty()) {
            return null;
        }
        return new Name(name);
    }

    private Owner getOwnerFromModel(DynamicCodeCodeGroupSearchViewModel searchViewModel) {
        String owner = searchViewModel.getCodeGroupOwner();
        if (owner == null || owner.isEmpty()) {
            return null;
        }
        return new Owner(owner);
    }

    private Description getDescriptionFromModel(DynamicCodeCodeGroupSearchViewModel searchViewModel) {
        String description = searchViewModel.getCodeGroupDescription();
        if (description == null || description.isEmpty()) {
            return null;
        }
        return new Description(description);
    }

}
