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
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.code.model;

import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.search.DynamicCodeCodeSearchMsg;
import org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code.DynamicCodeCodeListViewBrowserElement;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.search.SearchDynamicCodeDelegate;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchModel;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;

/**
 * DynamicCodeCodeSearchModel
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class DynamicCodeCodeSearchBusinessModel implements NabuccoComponentSearchModel {

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.rcp.search.code.model.DynamicCodeCodeSearchBusinessModel";

    /**
     * {@inheritDoc}
     */
    @Override
    public DynamicCodeCodeListViewBrowserElement search(
            NabuccoComponentSearchParameter searchParameter) {

        if (searchParameter instanceof DynamicCodeCodeSearchViewModel) {
            try {
                DynamicCodeCodeSearchViewModel searchViewModel = (DynamicCodeCodeSearchViewModel) searchParameter;

                SearchDynamicCodeDelegate searchDelegate = DynamicCodeComponentServiceDelegateFactory
                        .getInstance().getSearchDynamicCode();

                DynamicCodeCodeSearchMsg request = createDynamicCodeCodeSearchMsg(searchViewModel);

                DynamicCodeCodeListMsg response = searchDelegate.searchDynamicCodeCode(request);

                if (!response.getCodeList().isEmpty()) {
                    return new DynamicCodeCodeListViewBrowserElement(response.getCodeList());
                }

            } catch (ClientException e) {
                Activator.getDefault().logError(e);
            }
        }
        return null;
    }

    private DynamicCodeCodeSearchMsg createDynamicCodeCodeSearchMsg(
            DynamicCodeCodeSearchViewModel searchViewModel) {

        DynamicCodeCodeSearchMsg msg = new DynamicCodeCodeSearchMsg();

        // TODO: Adjust DynamicCode Search parameter

        Name name = this.getNameFromModel(searchViewModel);
        Owner owner = this.getOwnerFromModel(searchViewModel);
        Description description = this.getDescriptionFromModel(searchViewModel);

        msg.setName(name);
        msg.setOwner(owner);
        msg.setDescription(description);

        return msg;
    }

    private Name getNameFromModel(DynamicCodeCodeSearchViewModel searchViewModel) {
        String name = searchViewModel.getCodeName();
        if (name == null || name.isEmpty()) {
            return null;
        }
        return new Name(name);
    }

    private Owner getOwnerFromModel(DynamicCodeCodeSearchViewModel searchViewModel) {
        String owner = searchViewModel.getCodeOwner();
        if (owner == null || owner.isEmpty()) {
            return null;
        }
        return new Owner(owner);
    }

    private Description getDescriptionFromModel(DynamicCodeCodeSearchViewModel searchViewModel) {
        String description = searchViewModel.getCodeDescription();
        if (description == null || description.isEmpty()) {
            return null;
        }
        return new Description(description);
    }

}
