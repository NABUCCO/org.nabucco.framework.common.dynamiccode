package org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.view;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.model.DynamicCodeCodeGroupSearchViewModel;
import org.nabucco.framework.common.dynamiccode.ui.rcp.util.DynamicCodeLayouterUtility;
import org.nabucco.framework.plugin.base.layout.BaseSearchViewLayouter;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.layout.NabuccoLayouter;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * Layouts the elements for the code group search view.
 * 
 * @author Michael Krausse, PRODYNA AG
 * 
 */
public class DynamicCodeCodeGroupSearchViewLayouter extends
        BaseSearchViewLayouter<DynamicCodeCodeGroupSearchViewModel> implements
        NabuccoLayouter<DynamicCodeCodeGroupSearchViewModel> {

    private final String MESSAGE_OWNER_ID = "org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.CodeGroupSearchViewLayouter";

    private static final String SECTION_TITLE = DynamicCodeCodeGroupSearchView.ID + ".section";

    private DynamicCodeCodeGroupSearchViewWidgetFactory widgetFactory;

    @Override
    protected String getMessageOwnerId() {
        return MESSAGE_OWNER_ID;
    }

    @Override
    public Composite layoutComposite(Composite parent, NabuccoMessageManager msgManager,
            DynamicCodeCodeGroupSearchViewModel model,
            Layoutable<DynamicCodeCodeGroupSearchViewModel> view) {

        this.widgetFactory = new DynamicCodeCodeGroupSearchViewWidgetFactory(nabuccoFormToolKit,
                model);

        Section section = layoutSection(parent);

        GridLayout layout = new GridLayout(2, false);
        layout.verticalSpacing = 10;
        layout.horizontalSpacing = 20;

        Composite sectionBody = nabuccoFormToolKit.createComposite(section, layout);
        section.setClient(sectionBody);

        layoutLabelAndInputFieldName(sectionBody);
        layoutLabelAndInputFieldOwner(sectionBody);
        layoutLabelAndInputFieldDescription(sectionBody);
        section.setClient(sectionBody);

        return section;
    }

    /**
     * Layout the section.
     * 
     * @param parent
     *            the parent frame
     * 
     * @return the layouted section
     */
    private Section layoutSection(Composite parent) {
        Section result = nabuccoFormToolKit.createSection(parent, SECTION_TITLE, new GridLayout(1,
                true));
        return result;
    }

    /**
     * Layout the search parameter name.
     * 
     * @param parent
     *            the parent composite
     */
    private void layoutLabelAndInputFieldName(Composite parent) {
        Label label = widgetFactory.createLabelCodeGroupName(parent);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldCodeGroupName(parent);
        DynamicCodeLayouterUtility.layoutDefault(text);
    }

    /**
     * Layout the search parameter description.
     * 
     * @param parent
     *            the parent composite
     */
    private void layoutLabelAndInputFieldDescription(Composite parent) {
        Label label = widgetFactory.createLabelCodeGroupDescription(parent);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldCodeGroupDescription(parent);
        DynamicCodeLayouterUtility.layoutDefault(text);
    }

    /**
     * Layout the search parameter owner.
     * 
     * @param parent
     *            the parent composite
     */
    private void layoutLabelAndInputFieldOwner(Composite parent) {
        Label label = widgetFactory.createLabelCodeGroupOwner(parent);
        DynamicCodeLayouterUtility.layoutDefault(label);

        Text text = widgetFactory.createInputFieldCodeGroupOwner(parent);
        DynamicCodeLayouterUtility.layoutDefault(text);
    }
}
