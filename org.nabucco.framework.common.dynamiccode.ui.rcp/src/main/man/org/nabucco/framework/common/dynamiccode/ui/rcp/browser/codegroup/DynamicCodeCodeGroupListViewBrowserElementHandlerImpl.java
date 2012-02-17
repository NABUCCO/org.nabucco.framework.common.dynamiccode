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
package org.nabucco.framework.common.dynamiccode.ui.rcp.browser.codegroup;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRq;
import org.nabucco.framework.common.dynamiccode.facade.message.resolve.DynamicCodeCodeGroupResolveRs;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.rcp.communication.resolve.ResolveDynamicCodeDelegate;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.model.DynamicCodeCodeGroupListViewModel;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.model.browser.AbstractBrowserListViewHandlerImpl;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;

/**
 * DynamicCodeCodeGroupListViewBrowserElementHandlerImpl
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class DynamicCodeCodeGroupListViewBrowserElementHandlerImpl
        extends
        AbstractBrowserListViewHandlerImpl<DynamicCodeCodeGroup, DynamicCodeCodeGroupListViewModel, DynamicCodeCodeGroupListViewBrowserElement, DynamicCodeCodeGroupEditViewBrowserElement>
        implements DynamicCodeCodeGroupListViewBrowserElementHandler {

    @Override
    public void createChildren(DynamicCodeCodeGroupListViewModel viewModel,
            DynamicCodeCodeGroupListViewBrowserElement element) {

        this.fullLoadChildren(viewModel);

        for (DynamicCodeCodeGroup codegroup : viewModel.getElements()) {
            element.addBrowserElement(new DynamicCodeCodeGroupEditViewBrowserElement(codegroup));
        }
    }

    /**
     * Load the children.
     * 
     * @param viewModel
     *            the view model
     */
    private void fullLoadChildren(DynamicCodeCodeGroupListViewModel viewModel) {

        try {
            ResolveDynamicCodeDelegate resolveDynamicCodeService = DynamicCodeComponentServiceDelegateFactory
                    .getInstance().getResolveDynamicCode();

            List<DynamicCodeCodeGroup> groupList = new ArrayList<DynamicCodeCodeGroup>();

            for (DynamicCodeCodeGroup group : viewModel.getElements()) {
                DynamicCodeCodeGroupResolveRq rqMsg = new DynamicCodeCodeGroupResolveRq();
                rqMsg.setCodeGroup(group);

                DynamicCodeCodeGroupResolveRs rsMsg = resolveDynamicCodeService
                        .resolveDynamicCodeCodeGroup(rqMsg);

                groupList.add(rsMsg.getCodeGroup());
            }

            viewModel.setElements(groupList.toArray(new DynamicCodeCodeGroup[viewModel
                    .getElements().length]));

        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }
    }

    @Override
    public void removeChild(BrowserElement toBeRemoved,
            DynamicCodeCodeGroupListViewBrowserElement element) {
        super.removeChildren((DynamicCodeCodeGroupEditViewBrowserElement) toBeRemoved, element);
    }

    @Override
    public boolean haveSameId(DynamicCodeCodeGroup codeGroup,
            DynamicCodeCodeGroupEditViewBrowserElement dynamicCodeCodeGroupEditViewBrowserElement) {

        boolean result = false;
        result = codeGroup.getId().equals(
                dynamicCodeCodeGroupEditViewBrowserElement.getViewModel().getCodeGroup().getId());
        return result;
    }

    @Override
    public void updateViewModel(List<DynamicCodeCodeGroup> elements,
            DynamicCodeCodeGroupListViewModel viewModel) {

        viewModel.setElements(elements.toArray(new DynamicCodeCodeGroup[0]));

    }

}
