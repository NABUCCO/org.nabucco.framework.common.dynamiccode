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
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.model.DynamicCodeCodeGroupListViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.comparator.DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionComparator;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.comparator.DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.label.DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionLabelProvider;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.label.DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameLabelProvider;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoAbstractListLayouter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoComponentListView;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultListContentProvider;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultTableSorter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableParameter;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * DynamicCodeCodeGroupListViewLayouter
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class DynamicCodeCodeGroupListViewLayouter extends
        NabuccoAbstractListLayouter<DynamicCodeCodeGroupListViewModel> {

    private static final String COLUMN_NAME_TITLE = DynamicCodeCodeGroupListView.ID
            + ".column.name.title";

    private static final String COLUMN_NAME_TOOLTIP = DynamicCodeCodeGroupListView.ID
            + ".column.name.tooltip";

    private static final String COLUMN_DESCRIPTION_TITLE = DynamicCodeCodeGroupListView.ID
            + ".column.description.title";

    private static final String COLUMN_DESCRIPTION_TOOLTIP = DynamicCodeCodeGroupListView.ID
            + ".column.description.tooltip";

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager,
            DynamicCodeCodeGroupListViewModel model,
            Layoutable<DynamicCodeCodeGroupListViewModel> view) {

        NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);

        DynamicCodeCodeGroupListViewWidgetFactory widgetFactory = new DynamicCodeCodeGroupListViewWidgetFactory(
                ntk);

        NabuccoCommand doubleClickCommand = null;

        if (view instanceof NabuccoComponentListView) {
            doubleClickCommand = ((NabuccoComponentListView<DynamicCodeCodeGroupListViewModel>) view)
                    .getDoubleClickCommand();
        }

        NabuccoTableParameter parameter = new NabuccoTableParameter(
                new NabuccoDefaultTableSorter<DynamicCodeCodeGroup>(createTableComparator()),
                new DynamicCodeCodeGroupListViewTableFilter(),
                new NabuccoDefaultListContentProvider(model), createTableColumnInfo(),
                doubleClickCommand);

        return widgetFactory.createTable(parent, parameter, model);

    }

    private List<Comparator<DynamicCodeCodeGroup>> createTableComparator() {
        List<Comparator<DynamicCodeCodeGroup>> result = new LinkedList<Comparator<DynamicCodeCodeGroup>>();
        result.add(new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator());
        result.add(new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionComparator());
        return result;
    }

    private NabuccoTableColumnInfo[] createTableColumnInfo() {
        NabuccoTableColumnInfo[] result = {
                new NabuccoTableColumnInfo(COLUMN_NAME_TITLE, COLUMN_NAME_TOOLTIP, 200, SWT.CENTER,
                        SWT.CENTER,
                        new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameLabelProvider()),
                new NabuccoTableColumnInfo(
                        COLUMN_DESCRIPTION_TITLE,
                        COLUMN_DESCRIPTION_TOOLTIP,
                        300,
                        SWT.RIGHT,
                        SWT.RIGHT,
                        new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupDescriptionLabelProvider()) };

        return result;
    }
}
