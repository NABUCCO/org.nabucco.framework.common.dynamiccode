/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.create;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CreateDynamicCodeCodeFromBrowserCommand<p/>This command is for reading a DynamicCode<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class CreateDynamicCodeCodeFromBrowserCommand implements NabuccoCommand {

    private CreateDynamicCodeCodeFromBrowserHandler createDynamicCodeCodeFromBrowserHandler = NabuccoInjector
            .getInstance(CreateDynamicCodeCodeFromBrowserCommand.class).inject(
                    CreateDynamicCodeCodeFromBrowserHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.code.CreateDynamicCodeCodeFromBrowserCommand";

    /** Constructs a new CreateDynamicCodeCodeFromBrowserCommand instance. */
    public CreateDynamicCodeCodeFromBrowserCommand() {
        super();
    }

    @Override
    public void run() {
        createDynamicCodeCodeFromBrowserHandler.createDynamicCodeCodeFromBrowser();
    }

    @Override
    public String getId() {
        return CreateDynamicCodeCodeFromBrowserCommand.ID;
    }
}
