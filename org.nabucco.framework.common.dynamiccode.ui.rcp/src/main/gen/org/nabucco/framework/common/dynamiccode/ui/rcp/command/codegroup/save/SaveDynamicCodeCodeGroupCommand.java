/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.save;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * SaveDynamicCodeCodeGroupCommand<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-16
 */
public class SaveDynamicCodeCodeGroupCommand implements NabuccoCommand {

    private SaveDynamicCodeCodeGroupHandler saveDynamicCodeCodeGroupHandler = NabuccoInjector
            .getInstance(SaveDynamicCodeCodeGroupCommand.class).inject(
                    SaveDynamicCodeCodeGroupHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.SaveDynamicCodeCodeGroupCommand";

    /** Constructs a new SaveDynamicCodeCodeGroupCommand instance. */
    public SaveDynamicCodeCodeGroupCommand() {
        super();
    }

    @Override
    public void run() {
        saveDynamicCodeCodeGroupHandler.saveDynamicCodeCodeGroup();
    }

    @Override
    public String getId() {
        return SaveDynamicCodeCodeGroupCommand.ID;
    }
}
