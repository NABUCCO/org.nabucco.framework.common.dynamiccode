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
package org.nabucco.framework.common.dynamiccode.ui.rcp.command.codegroup.open;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingCodeGroupListViewCommand<p/>Opens the corresponding DynamicCodeCodeGroupListView<p/>
 *
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class OpenCorrespondingCodeGroupListViewCommand implements NabuccoCommand {

    private OpenDynamicCodeCodeGroupListViewHandler openDynamicCodeCodeGroupListViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingCodeGroupListViewCommand.class).inject(
                    OpenDynamicCodeCodeGroupListViewHandler.class);

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.command.codegroup.open.OpenCorrespondingCodeGroupListViewCommand";

    /** Constructs a new OpenCorrespondingCodeGroupListViewCommand instance. */
    public OpenCorrespondingCodeGroupListViewCommand() {
        super();
    }

    @Override
    public void run() {
        openDynamicCodeCodeGroupListViewHandler.openDynamicCodeCodeGroupListView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingCodeGroupListViewCommand.ID;
    }
}
