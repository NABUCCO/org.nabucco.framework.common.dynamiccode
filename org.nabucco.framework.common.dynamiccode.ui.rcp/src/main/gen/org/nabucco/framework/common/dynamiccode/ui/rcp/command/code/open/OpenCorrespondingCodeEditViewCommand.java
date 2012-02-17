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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.code.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeEditViewCommand<p/>Command for opening the corresponding CodeGroup EditView<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class OpenCorrespondingCodeEditViewCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeEditViewHandler openDynamicCodeCodeEditViewHandler = NabuccoInjector.getInstance(
            OpenCorrespondingCodeEditViewCommand.class).inject(OpenDynamicCodeCodeEditViewHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.OpenCorrespondingCodeGroupEditViewCommand";

    /** Constructs a new OpenCorrespondingCodeEditViewCommand instance. */
    public OpenCorrespondingCodeEditViewCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeEditViewHandler.openDynamicCodeCodeEditView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeEditViewCommand.ID;
    }
}
