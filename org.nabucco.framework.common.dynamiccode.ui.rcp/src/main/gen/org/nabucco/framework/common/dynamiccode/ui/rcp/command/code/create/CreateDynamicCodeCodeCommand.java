/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.create;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CreateDynamicCodeCodeCommand<p/>This command is for creating a new DynamicCode<p/>
 *
 * @author Michael Krausse, PRODYNA AG, 2010-03-16
 */
public class CreateDynamicCodeCodeCommand implements NabuccoCommand {

    private CreateDynamicCodeCodeHandler createDynamicCodeCodeHandler = NabuccoInjector
            .getInstance(CreateDynamicCodeCodeCommand.class).inject(
                    CreateDynamicCodeCodeHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.code.CreateDynamicCodeCodeCommand";

    /** Constructs a new CreateDynamicCodeCodeCommand instance. */
    public CreateDynamicCodeCodeCommand() {
        super();
    }

    @Override
    public void run() {
        createDynamicCodeCodeHandler.createDynamicCodeCode();
    }

    @Override
    public String getId() {
        return CreateDynamicCodeCodeCommand.ID;
    }
}
