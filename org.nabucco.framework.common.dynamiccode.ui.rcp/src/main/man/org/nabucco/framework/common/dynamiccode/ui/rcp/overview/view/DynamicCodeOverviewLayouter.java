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
package org.nabucco.framework.common.dynamiccode.ui.rcp.overview.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.plugin.base.component.overview.model.NabuccoOverviewAction;
import org.nabucco.framework.plugin.base.component.overview.model.NabuccoOverviewModel;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.layout.NabuccoLayouter;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * DynamicCodeOverviewLayouter
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeOverviewLayouter implements NabuccoLayouter<NabuccoOverviewModel> {

    private DynamicCodeOverviewWidgetFactory widgetFactory;

    private NabuccoOverviewModel model;

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager,
            NabuccoOverviewModel model) {
        return layout(parent, model);
    }

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager,
            NabuccoOverviewModel model, Layoutable<NabuccoOverviewModel> view) {
        return layout(parent, messageManager, model);
    }

    private Composite layout(Composite parent, NabuccoOverviewModel nabuccoOverviewModel) {
        model = nabuccoOverviewModel;

        NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);
        Composite frame = ntk.createComposite(parent, new RowLayout(SWT.VERTICAL | SWT.NO_SCROLL));

        widgetFactory = new DynamicCodeOverviewWidgetFactory(ntk);

        createSectionSummary(frame);
        createSectionBottom(frame);

        return null;
    }

    private void createSectionSummary(final Composite parent) {
        Section section = widgetFactory.createSectionHeadingSummary(parent);
        Composite child = widgetFactory.getNabuccoFormToolKit().createComposite(section,
                new FormLayout());
        section.setClient(child);

        createDescription(parent, child);
    }

    private void createDescription(final Composite parent, final Composite child) {
        final Composite com = widgetFactory.getNabuccoFormToolKit().createComposite(child,
                new FillLayout());

        FormData areaForViewer = new FormData();
        areaForViewer.left = new FormAttachment(0, 0);
        areaForViewer.top = new FormAttachment(0, 0);
        areaForViewer.right = new FormAttachment(0, 0);
        areaForViewer.bottom = new FormAttachment(0, 0);

        com.setLayoutData(areaForViewer);
        widgetFactory.createTextDescription(com);
        parent.getParent().addControlListener(new ControlListener() {

            @Override
            public void controlResized(ControlEvent arg0) {
                FormData a = (FormData) com.getLayoutData();
                if (0 != parent.getClientArea().width) {
                    a.right.offset = parent.getClientArea().width;
                    a.bottom.offset = com.computeSize(a.right.offset, SWT.DEFAULT, false).y;
                } else {
                    a.right.offset = 635;
                    a.bottom.offset = a.bottom.offset = com.computeSize(a.right.offset,
                            SWT.DEFAULT, false).y;
                }
                com.setLayoutData(a);
                parent.layout();
            }

            @Override
            public void controlMoved(ControlEvent arg0) {
            }
        });
    }

    private void createSectionBottom(Composite parent) {
        Section section = widgetFactory.createSectionHeadingAction(parent);

        Composite child = widgetFactory.getNabuccoFormToolKit().createComposite(section,
                new GridLayout(2, true));
        section.setClient(child);

        for (NabuccoOverviewAction overviewActionItem : model.getComponentActions()) {
            widgetFactory.linkAction(child, overviewActionItem);
            widgetFactory.createActionDescription(child, overviewActionItem);
        }
    }
}
