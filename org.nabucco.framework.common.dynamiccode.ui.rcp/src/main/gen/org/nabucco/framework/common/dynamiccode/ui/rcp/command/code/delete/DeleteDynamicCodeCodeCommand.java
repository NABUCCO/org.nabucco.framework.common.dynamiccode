/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

    private DeleteDynamicCodeCodeHandler deleteDynamicCodeCodeHandler = NabuccoInjector.getInstance(
            DeleteDynamicCodeCodeCommand.class).inject(DeleteDynamicCodeCodeHandler.class);

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
