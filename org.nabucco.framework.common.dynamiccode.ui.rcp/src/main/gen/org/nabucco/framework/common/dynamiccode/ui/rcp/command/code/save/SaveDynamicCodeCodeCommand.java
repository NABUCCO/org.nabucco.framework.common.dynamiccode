/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.save;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * SaveDynamicCodeCodeCommand<p/>This command should save a DyanmicCode<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-16
 */
public class SaveDynamicCodeCodeCommand implements NabuccoCommand {

    private SaveDynamicCodeCodeHandler saveDynamicCodeCodeHandler = NabuccoInjector.getInstance(
            SaveDynamicCodeCodeCommand.class).inject(SaveDynamicCodeCodeHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.code.SaveDynamicCodeCodeCommand";

    /** Constructs a new SaveDynamicCodeCodeCommand instance. */
    public SaveDynamicCodeCodeCommand() {
        super();
    }

    @Override
    public void run() {
        saveDynamicCodeCodeHandler.saveDynamicCodeCode();
    }

    @Override
    public String getId() {
        return SaveDynamicCodeCodeCommand.ID;
    }
}
