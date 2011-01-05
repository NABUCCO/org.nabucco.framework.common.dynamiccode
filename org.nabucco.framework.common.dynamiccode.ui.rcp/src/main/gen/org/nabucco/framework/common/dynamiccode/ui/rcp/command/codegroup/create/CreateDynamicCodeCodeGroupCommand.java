/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.create;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CreateDynamicCodeCodeGroupCommand<p/>@TODO<p/>
 *
 * @author Michael Krausse, PRODYNA AG, 2010-03-16
 */
public class CreateDynamicCodeCodeGroupCommand implements NabuccoCommand {

    private CreateDynamicCodeCodeGroupHandler createDynamicCodeCodeGroupHandler = NabuccoInjector
            .getInstance(CreateDynamicCodeCodeGroupCommand.class).inject(
                    CreateDynamicCodeCodeGroupHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.CreateDynamicCodeCodeGroupCommand";

    /** Constructs a new CreateDynamicCodeCodeGroupCommand instance. */
    public CreateDynamicCodeCodeGroupCommand() {
        super();
    }

    @Override
    public void run() {
        createDynamicCodeCodeGroupHandler.createDynamicCodeCodeGroup();
    }

    @Override
    public String getId() {
        return CreateDynamicCodeCodeGroupCommand.ID;
    }
}
