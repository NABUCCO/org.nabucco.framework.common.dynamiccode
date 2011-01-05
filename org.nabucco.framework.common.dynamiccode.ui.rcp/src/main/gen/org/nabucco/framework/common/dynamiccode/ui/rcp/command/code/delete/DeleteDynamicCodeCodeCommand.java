/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.delete;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * DeleteDynamicCodeCodeCommand<p/>Command for deletion of a DynamicCodeCode<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-12-16
 */
public class DeleteDynamicCodeCodeCommand implements NabuccoCommand {

    private DeleteDynamicCodeCodeHandler deleteDynamicCodeCodeHandler = NabuccoInjector
            .getInstance(DeleteDynamicCodeCodeCommand.class).inject(
                    DeleteDynamicCodeCodeHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.DeleteDynamicCodeCodeCommand";

    /** Constructs a new DeleteDynamicCodeCodeCommand instance. */
    public DeleteDynamicCodeCodeCommand() {
        super();
    }

    @Override
    public void run() {
        deleteDynamicCodeCodeHandler.deleteDynamicCodeCode();
    }

    @Override
    public String getId() {
        return DeleteDynamicCodeCodeCommand.ID;
    }
}
