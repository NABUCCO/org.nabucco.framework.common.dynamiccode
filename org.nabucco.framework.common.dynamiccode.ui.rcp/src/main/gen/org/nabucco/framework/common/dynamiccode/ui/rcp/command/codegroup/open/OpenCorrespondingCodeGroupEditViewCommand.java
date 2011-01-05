/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeGroupEditViewCommand<p/>@TODO<p/>
 *
 * @author Michael Krausse, PRODYNA AG, 2010-03-16
 */
public class OpenCorrespondingCodeGroupEditViewCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeGroupEditViewHandler openDynamicCodeCodeGroupEditViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingCodeGroupEditViewCommand.class).inject(
                    OpenDynamicCodeCodeGroupEditViewHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.OpenCorrespondingCodeGroupEditViewCommand";

    /** Constructs a new OpenCorrespondingCodeGroupEditViewCommand instance. */
    public OpenCorrespondingCodeGroupEditViewCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeGroupEditViewHandler.openDynamicCodeCodeGroupEditView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeGroupEditViewCommand.ID;
    }
}
