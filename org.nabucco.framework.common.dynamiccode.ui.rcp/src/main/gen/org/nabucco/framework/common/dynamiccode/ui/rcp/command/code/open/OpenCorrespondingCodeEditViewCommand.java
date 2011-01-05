/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeEditViewCommand<p/>Command for opening the corresponding CodeGroup EditView<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class OpenCorrespondingCodeEditViewCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeEditViewHandler openDynamicCodeCodeEditViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingCodeEditViewCommand.class).inject(
                    OpenDynamicCodeCodeEditViewHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.OpenCorrespondingCodeGroupEditViewCommand";

    /** Constructs a new OpenCorrespondingCodeEditViewCommand instance. */
    public OpenCorrespondingCodeEditViewCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeEditViewHandler.openDynamicCodeCodeEditView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeEditViewCommand.ID;
    }
}
