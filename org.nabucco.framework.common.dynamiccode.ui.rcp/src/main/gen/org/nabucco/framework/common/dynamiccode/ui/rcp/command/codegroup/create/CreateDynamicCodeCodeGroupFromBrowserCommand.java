/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.create;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CreateDynamicCodeCodeGroupFromBrowserCommand<p/>This command creates a new DynamicCode CodeGroup from BrowserView<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class CreateDynamicCodeCodeGroupFromBrowserCommand implements NabuccoCommand {

    private CreateDynamicCodeCodeGroupFromBrowserHandler createDynamicCodeCodeGroupFromBrowserHandler = NabuccoInjector
            .getInstance(CreateDynamicCodeCodeGroupFromBrowserCommand.class).inject(
                    CreateDynamicCodeCodeGroupFromBrowserHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.CreateDynamicCodeCodeGroupFromBrowserCommand";

    /** Constructs a new CreateDynamicCodeCodeGroupFromBrowserCommand instance. */
    public CreateDynamicCodeCodeGroupFromBrowserCommand() {
        super();
    }

    @Override
    public void run() {
        createDynamicCodeCodeGroupFromBrowserHandler.createDynamicCodeCodeGroupFromBrowser();
    }

    @Override
    public String getId() {
        return CreateDynamicCodeCodeGroupFromBrowserCommand.ID;
    }
}
