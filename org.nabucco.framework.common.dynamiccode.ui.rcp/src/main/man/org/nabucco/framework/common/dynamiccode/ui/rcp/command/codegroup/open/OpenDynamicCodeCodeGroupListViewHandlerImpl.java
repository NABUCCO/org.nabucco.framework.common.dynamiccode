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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.open;

import org.nabucco.framework.common.dynamiccode.ui.rcp.browser.code.DynamicCodeCodeListViewBrowserElement;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.model.DynamicCodeCodeListViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.DynamicCodeCodeGroupListView;
import org.nabucco.framework.plugin.base.command.AbstractNabuccoOpenCorrespondingListViewHandlerImpl;

/**
 * OpenDynamicCodeCodeGroupListViewHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class OpenDynamicCodeCodeGroupListViewHandlerImpl
        extends
        AbstractNabuccoOpenCorrespondingListViewHandlerImpl<DynamicCodeCodeListViewBrowserElement, DynamicCodeCodeListViewModel>
        implements OpenDynamicCodeCodeGroupListViewHandler {

    @Override
    public void openDynamicCodeCodeGroupListView() {
        super.run();
    }

    @Override
    protected String getListViewId() {
        return DynamicCodeCodeGroupListView.ID;
    }

}