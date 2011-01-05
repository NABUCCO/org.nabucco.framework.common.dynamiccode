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

import java.util.Set;

import org.eclipse.ui.forms.IManagedForm;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.GeneralDetailPageView;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.GeneralDetailPageViewLayouter;
import org.nabucco.framework.plugin.base.component.multipage.model.MultiPageEditViewModel;
import org.nabucco.framework.plugin.base.view.ManagedFormViewPart;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * DynamicCodeEnabledGeneralDetailPageView
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class DynamicCodeEnabledGeneralDetailPageView<M extends MultiPageEditViewModel> extends
        GeneralDetailPageView<M> {

    /**
     * Creates a new {@link DynamicCodeEnabledGeneralDetailPageView} instance.
     * 
     * @param block
     *            the master-detail block
     * @param managedForm
     *            the managed form
     * @param parentView
     *            the parent view
     * @param nabuccoMessageManager
     *            the message manager
     * @param masterBlockId
     *            the master-block id
     * @param detailTitle
     *            i18n representation of title for details
     * @param readOnlyProperties
     *            properties that are not editable
     * @param invisibleProperties
     *            properties that are not painted
     */
    public DynamicCodeEnabledGeneralDetailPageView(MasterDetailBlock<M> block,
            IManagedForm managedForm, ManagedFormViewPart<M> parentView,
            NabuccoMessageManager nabuccoMessageManager, String idOfMasterBlock,
            String detailTitle, Set<String> invisibleProperties, Set<String> readOnlyProperties) {

        super(block, managedForm, parentView, nabuccoMessageManager, idOfMasterBlock, detailTitle,
                invisibleProperties, readOnlyProperties);

    }

    @Override
    protected GeneralDetailPageViewLayouter getLayouter(String detailTitle) {
        return new DynamicCodeEnabledGeneralDetailPageViewLayouter(detailTitle);
    }

}
