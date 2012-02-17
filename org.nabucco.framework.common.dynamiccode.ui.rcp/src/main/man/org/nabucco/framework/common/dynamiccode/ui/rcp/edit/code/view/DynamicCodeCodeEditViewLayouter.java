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
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.DynamicCodeCodeGroupListViewTableFilter;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.comparator.DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator;
import org.nabucco.framework.common.dynamiccode.ui.rcp.list.codegroup.view.label.DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameLabelProvider;
import org.nabucco.framework.common.dynamiccode.ui.rcp.util.DynamicCodeLayouterUtility;
import org.nabucco.framework.common.dynamiccode.ui.rcp.util.TextModifyListener;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultTableSorter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.layout.NabuccoLayouter;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * DynamicCodeCodeEditViewLayouter
 * 
 * @author Michael Krau�e, PRODYNA AG
 */
public class DynamicCodeCodeEditViewLayouter implements NabuccoLayouter<DynamicCodeCodeEditViewModel> {

    private DynamicCodeCodeEditViewWidgetFactory widgetFactory;

    private NabuccoMessageManager messageManager;

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager, DynamicCodeCodeEditViewModel model) {

        this.messageManager = messageManager;

        this.widgetFactory = new DynamicCodeCodeEditViewWidgetFactory(new NabuccoFormToolkit(parent), model);

        return this.layoutSection(parent, model);
    }

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager, DynamicCodeCodeEditViewModel model,
            Layoutable<DynamicCodeCodeEditViewModel> view) {

        this.messageManager = messageManager;

        this.widgetFactory = new DynamicCodeCodeEditViewWidgetFactory(new NabuccoFormToolkit(parent), model);

        return this.layoutSection(parent, model);
    }

    /**
     * Layouts the section.
     * 
     * @param parent
     *            the parent of the section
     * 
     * @return the layouted composite
     */
    private Composite layoutSection(Composite parent, DynamicCodeCodeEditViewModel model) {
        Section section = widgetFactory.createSectionHeading(parent);

        GridLayout layout = new GridLayout(2, false);
        layout.verticalSpacing = 10;
        layout.horizontalSpacing = 20;

        Composite sectionBody = widgetFactory.getNabuccoFormToolKit().createComposite(section, layout);
        section.setClient(sectionBody);

        this.layoutLabelAndInputFieldName(sectionBody);
        this.layoutLabelAndInputFieldDescription(sectionBody);
        this.layoutLabelAndInputFieldOwner(sectionBody);
        this.layoutLabelAndInputFieldTenant(sectionBody);
        this.layoutLabelAndInputFieldFuntionalId(sectionBody);
        this.layoutCodeGroupPicker(sectionBody, model);

        return section;
    }

    /**
     * Layout the code name.
     * 
     * @param parent
     *            the parent section
     */
    private void layoutLabelAndInputFieldName(Composite parent) {
        Label label = widgetFactory.createLabelName(parent);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldName(parent);
        DynamicCodeLayouterUtility.layoutDefault(text);

        TextModifyListener listener = new TextModifyListener(text, messageManager);
        text.addModifyListener(listener);
    }

    /**
     * Layout the code description.
     * 
     * @param parent
     *            the parent section
     */
    private void layoutLabelAndInputFieldDescription(Composite parent) {
        Label label = widgetFactory.createLabelDescription(parent);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldDescription(parent);
        DynamicCodeLayouterUtility.layoutDefault(text);

        TextModifyListener listener = new TextModifyListener(text, messageManager);
        text.addModifyListener(listener);
    }

    /**
     * Layout the code owner.
     * 
     * @param parent
     *            the parent section
     */
    private void layoutLabelAndInputFieldOwner(Composite parent) {
        Label label = widgetFactory.createLabelOwner(parent);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldOwner(parent);
        DynamicCodeLayouterUtility.layoutDefault(text);
        
        text.setEnabled(false);
        text.setEditable(false);
    }

    /**
     * Layout the code tenant.
     * 
     * @param parent
     *            the parent section
     */
    private void layoutLabelAndInputFieldTenant(Composite parent) {
        Label label = widgetFactory.createLabelTenant(parent);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldTenant(parent);
        DynamicCodeLayouterUtility.layoutDefault(text);
        
        text.setEnabled(false);
        text.setEditable(false);
    }

    /**
     * Layout the code functional id.
     * 
     * @param parent
     *            the parent section
     */
    private void layoutLabelAndInputFieldFuntionalId(Composite sectionBody) {
        Label label = widgetFactory.createLabelFunctionalId(sectionBody);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldFunctionalId(sectionBody);
        DynamicCodeLayouterUtility.layoutDefault(text);
    }

    /**
     * Create CodeGroupPicker.
     * 
     * @param parent
     *            the parent composite
     */
    private void layoutCodeGroupPicker(Composite parent, DynamicCodeCodeEditViewModel model) {
        ElementPickerParameter params = new ElementPickerParameter(new NabuccoDefaultTableSorter<DynamicCodeCodeGroup>(
                createTableColumnComparators()), new DynamicCodeCodeGroupListViewTableFilter(),
                new DynamicCodeCodeGroupLabelProvider(), new CodeGroupPickerContentProvider(model),
                createTableColumnInfo());

        widgetFactory.createLabelCodeGroupPicker(parent);
        widgetFactory.createElementPickerCodeGroupPicker(parent, params);
    }

    /**
     * Creates a comparator for the codegroup picker table.
     * 
     * @return the comparator
     */
    private List<Comparator<DynamicCodeCodeGroup>> createTableColumnComparators() {
        List<Comparator<DynamicCodeCodeGroup>> result = new LinkedList<Comparator<DynamicCodeCodeGroup>>();
        result.add(new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameComparator());
        return result;
    }

    /**
     * Create column information for the codegroup picker table.
     * 
     * @return the column information
     */
    private NabuccoTableColumnInfo[] createTableColumnInfo() {

        NabuccoTableColumnInfo info;
        List<NabuccoTableColumnInfo> columnInfoList = new ArrayList<NabuccoTableColumnInfo>(2);

        info = new NabuccoTableColumnInfo("Name", "Name of the Code", 100, SWT.LEFT, SWT.CENTER,
                new DynamicCodeCodeGroupListViewDynamicCodeCodeGroupNameLabelProvider());
        info.setResizable(false);
        info.setMoveable(false);
        columnInfoList.add(info);

        return columnInfoList.toArray(new NabuccoTableColumnInfo[columnInfoList.size()]);
    }

}
