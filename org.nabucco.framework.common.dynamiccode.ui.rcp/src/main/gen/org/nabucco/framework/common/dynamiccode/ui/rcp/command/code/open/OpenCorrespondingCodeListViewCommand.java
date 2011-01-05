/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeListViewCommand<p/>Opens the corresponding DynamicCodeCodeListView<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class OpenCorrespondingCodeListViewCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeListViewHandler openDynamicCodeCodeListViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingCodeListViewCommand.class).inject(
                    OpenDynamicCodeCodeListViewHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.code.open.OpenCorrespondingCodeListViewCommand";

    /** Constructs a new OpenCorrespondingCodeListViewCommand instance. */
    public OpenCorrespondingCodeListViewCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeListViewHandler.openDynamicCodeCodeListView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeListViewCommand.ID;
    }
}
