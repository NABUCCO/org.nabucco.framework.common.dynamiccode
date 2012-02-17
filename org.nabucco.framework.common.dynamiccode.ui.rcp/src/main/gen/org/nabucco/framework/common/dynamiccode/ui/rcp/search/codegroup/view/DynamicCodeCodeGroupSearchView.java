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
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.view;

import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.model.DynamicCodeCodeGroupSearchViewModel;
import org.nabucco.framework.plugin.base.view.AbstractNabuccoSearchView;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.framework.plugin.base.view.NabuccoSearchView;

/**
 * DynamicCodeCodeGroupSearchView<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-05
 */
public class DynamicCodeCodeGroupSearchView extends AbstractNabuccoSearchView<DynamicCodeCodeGroupSearchViewModel>
        implements NabuccoSearchView {

    private DynamicCodeCodeGroupSearchViewModel model;

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.search.codegroup.DynamicCodeCodeGroupSearchView";

    /** Constructs a new DynamicCodeCodeGroupSearchView instance. */
    public DynamicCodeCodeGroupSearchView() {
        super();
        model = new DynamicCodeCodeGroupSearchViewModel(this.getCorrespondingListView());
    }

    @Override
    public void createPartControl(final Composite parent, final NabuccoMessageManager aMessageManager) {
        this.getLayouter().layout(parent, aMessageManager, model);
    }

    @Override
    public DynamicCodeCodeGroupSearchViewModel getModel() {
        return model;
    }

    @Override
    public String getId() {
        return DynamicCodeCodeGroupSearchView.ID;
    }
}
