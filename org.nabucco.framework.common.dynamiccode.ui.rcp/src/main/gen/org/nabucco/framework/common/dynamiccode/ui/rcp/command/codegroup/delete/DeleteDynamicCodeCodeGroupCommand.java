/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.delete;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * DeleteDynamicCodeCodeGroupCommand<p/>Command for deletion of a DynamicCodeCodeGroup<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-12-16
 */
public class DeleteDynamicCodeCodeGroupCommand implements NabuccoCommand {

    private DeleteDynamicCodeCodeGroupHandler deleteDynamicCodeCodeGroupHandler = NabuccoInjector
            .getInstance(DeleteDynamicCodeCodeGroupCommand.class).inject(
                    DeleteDynamicCodeCodeGroupHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.DeleteDynamicCodeCodeGroupCommand";

    /** Constructs a new DeleteDynamicCodeCodeGroupCommand instance. */
    public DeleteDynamicCodeCodeGroupCommand() {
        super();
    }

    @Override
    public void run() {
        deleteDynamicCodeCodeGroupHandler.deleteDynamicCodeCodeGroup();
    }

    @Override
    public String getId() {
        return DeleteDynamicCodeCodeGroupCommand.ID;
    }
}
