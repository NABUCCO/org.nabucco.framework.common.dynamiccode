/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeEditViewFromBrowserCommand<p/>Command for opening the DynamicCodeCodeEditView from the BrowserElement<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-03-16
 */
public class OpenCorrespondingCodeEditViewFromBrowserCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeEditViewFromBrowserHandler openDynamicCodeCodeEditViewFromBrowserHandler = NabuccoInjector
            .getInstance(OpenCorrespondingCodeEditViewFromBrowserCommand.class).inject(
                    OpenDynamicCodeCodeEditViewFromBrowserHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.code.open.OpenCorrespondingCodeEditViewFromBrowserCommand";

    /** Constructs a new OpenCorrespondingCodeEditViewFromBrowserCommand instance. */
    public OpenCorrespondingCodeEditViewFromBrowserCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeEditViewFromBrowserHandler.openDynamicCodeCodeEditViewFromBrowser();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeEditViewFromBrowserCommand.ID;
    }
}
