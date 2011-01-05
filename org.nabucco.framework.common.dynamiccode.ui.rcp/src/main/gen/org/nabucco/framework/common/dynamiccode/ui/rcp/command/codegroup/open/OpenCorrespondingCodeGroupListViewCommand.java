/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeGroupListViewCommand<p/>Opens the corresponding DynamicCodeCodeGroupListView<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class OpenCorrespondingCodeGroupListViewCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeGroupListViewHandler openDynamicCodeCodeGroupListViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingCodeGroupListViewCommand.class).inject(
                    OpenDynamicCodeCodeGroupListViewHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.open.OpenCorrespondingCodeGroupListViewCommand";

    /** Constructs a new OpenCorrespondingCodeGroupListViewCommand instance. */
    public OpenCorrespondingCodeGroupListViewCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeGroupListViewHandler.openDynamicCodeCodeGroupListView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeGroupListViewCommand.ID;
    }
}
