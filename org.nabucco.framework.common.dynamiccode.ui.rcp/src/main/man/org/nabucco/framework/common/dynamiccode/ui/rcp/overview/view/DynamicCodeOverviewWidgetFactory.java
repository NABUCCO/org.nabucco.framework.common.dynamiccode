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
package org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.plugin.base.NabuccoRcpToolkit;
import org.nabucco.framework.plugin.base.component.overview.model.NabuccoOverviewAction;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;

/**
 * DynamicCodeOverviewWidgetFactory
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeOverviewWidgetFactory extends WidgetFactory {

    // private static final String OVERVIEW =
    // "PRODYNA NABUCCO Component DynamicCode is responsible for maintaining dynamic enumerations that are exchangeable during runtime.";

    private static final String TITLE = "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.Title";

    private static final String SUMMARY = "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.Summary";

    private static final String ACTIONS = "org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view.Actions";

    public DynamicCodeOverviewWidgetFactory(NabuccoFormToolkit aNabuccoFormToolKit) {
        super(aNabuccoFormToolKit);
    }

    /**
     * Create Heading for summary.
     * 
     * @param parent
     *            the parent composite
     * 
     * @return the layouted section
     */
    public Section createSectionHeadingSummary(Composite parent) {
        Section result = super.nabuccoFormToolKit.createSection(parent, TITLE, new RowLayout());

        return result;
    }

    /**
     * Create Description text.
     * 
     * @param parent
     *            parent of element
     * 
     * @return created element
     */
    public StyledText createTextDescription(Composite parent) {
        StyledText result = super.nabuccoFormToolKit.createMultipleLineLabel(parent, SUMMARY);
        return result;
    }

    /**
     * Create a section for the given label.
     * 
     * @param parent
     *            the parent composite
     * @param label
     *            the label string
     * 
     * @return the layouted section
     */
    public Section createSectionHeadingAction(Composite parent) {
        Section result = super.nabuccoFormToolKit.createSection(parent, ACTIONS, new RowLayout());
        return result;
    }

    /**
     * Links an action to another composite.
     * 
     * @param composite
     *            the parent to add the action
     * @param action
     *            the action
     */
    public void linkAction(Composite composite, final NabuccoOverviewAction action) {
        Link link = nabuccoFormToolKit.createLink(composite, action.getActionDescription());
        link.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                NabuccoRcpToolkit.showView(action.getViewId());
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
        });
    }

    /**
     * Create an action description
     * 
     * @param parent
     *            the parent composite
     * @param action
     *            the action holding the description
     * 
     * @return the action description
     */
    public Label createActionDescription(Composite parent, NabuccoOverviewAction action) {
        return nabuccoFormToolKit.createRealLabel(parent, action.getDescription());
    }
}
