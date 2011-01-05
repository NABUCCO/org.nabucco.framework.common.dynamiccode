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
package org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.comparator.DynamicCodeCodeListViewDynamicCodeCodeDescriptionComparator;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.comparator.DynamicCodeCodeListViewDynamicCodeCodeNameComparator;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.label.DynamicCodeCodeListViewDynamicCodeCodeDescriptionLabelProvider;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.code.view.label.DynamicCodeCodeListViewDynamicCodeCodeNameLabelProvider;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoAbstractListLayouter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoComponentListView;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultListContentProvider;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultTableSorter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableParameter;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchViewModel;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * DynamicCodeCodeListViewLayouter
 * 
 * @author Lasse Asbach, PRODYNA AG
 */
public class DynamicCodeCodeListViewLayouter extends
        NabuccoAbstractListLayouter<NabuccoComponentSearchViewModel<DynamicCodeCode>> {

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager,
            NabuccoComponentSearchViewModel<DynamicCodeCode> model,
            Layoutable<NabuccoComponentSearchViewModel<DynamicCodeCode>> view) {

        NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);

        DynamicCodeCodeListViewWidgetFactory widgetFactory = new DynamicCodeCodeListViewWidgetFactory(
                ntk);

        NabuccoCommand doubleClickCommand = null;

        if (view instanceof NabuccoComponentListView) {
            doubleClickCommand = ((NabuccoComponentListView<NabuccoComponentSearchViewModel<DynamicCodeCode>>) view)
                    .getDoubleClickCommand();
        }

        NabuccoTableParameter parameter = new NabuccoTableParameter(
                new NabuccoDefaultTableSorter<DynamicCodeCode>(createTableSorter()),
                new DynamicCodeCodeListViewTableFilter(), new NabuccoDefaultListContentProvider(
                        model), createTableColumnInfo(), doubleClickCommand);

        return widgetFactory.createTable(parent, parameter, model);
    }

    private List<Comparator<DynamicCodeCode>> createTableSorter() {
        List<Comparator<DynamicCodeCode>> result = new LinkedList<Comparator<DynamicCodeCode>>();
        result.add(new DynamicCodeCodeListViewDynamicCodeCodeNameComparator());
        result.add(new DynamicCodeCodeListViewDynamicCodeCodeDescriptionComparator());

        return result;
    }

    private NabuccoTableColumnInfo[] createTableColumnInfo() {
        NabuccoTableColumnInfo[] result = {
                new NabuccoTableColumnInfo("Name", "Name of the DynamicCode Code", 200, SWT.CENTER,
                        SWT.CENTER, new DynamicCodeCodeListViewDynamicCodeCodeNameLabelProvider()),
                new NabuccoTableColumnInfo("Description", "Description of the DynamicCode Code",
                        300, SWT.RIGHT, SWT.RIGHT,
                        new DynamicCodeCodeListViewDynamicCodeCodeDescriptionLabelProvider()) };

        return result;
    }

}
