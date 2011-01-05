/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeGroupEditViewFromBrowserCommand<p/>Command for opening the DynamicCodeCodeGroupEditView from the BrowserElement<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-03-16
 */
public class OpenCorrespondingCodeGroupEditViewFromBrowserCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeGroupEditViewFromBrowserHandler openDynamicCodeCodeGroupEditViewFromBrowserHandler = NabuccoInjector
            .getInstance(OpenCorrespondingCodeGroupEditViewFromBrowserCommand.class).inject(
                    OpenDynamicCodeCodeGroupEditViewFromBrowserHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.open.OpenCorrespondingCodeGroupEditViewFromBrowserCommand";

    /** Constructs a new OpenCorrespondingCodeGroupEditViewFromBrowserCommand instance. */
    public OpenCorrespondingCodeGroupEditViewFromBrowserCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeGroupEditViewFromBrowserHandler
                .openDynamicCodeCodeGroupEditViewFromBrowser();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeGroupEditViewFromBrowserCommand.ID;
    }
}
