/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.util;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.plugin.base.view.NabuccoMessage;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;

/**
 * TextModifyListener
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class TextModifyListener implements ModifyListener {

    private Text text;

    private NabuccoMessageManager messageManager;

    /**
     * Creates a new {@link TextModifyListener} instance.
     * 
     * @param text
     *            the text input field
     * @param messageManager
     *            the message manager
     */
    public TextModifyListener(Text text, NabuccoMessageManager messageManager) {
        if (text == null) {
            throw new IllegalArgumentException("Text field must not be null.");
        }
        if (messageManager == null) {
            throw new IllegalArgumentException("MessageManager must not be null.");
        }
        this.text = text;
        this.messageManager = messageManager;
    }

    @Override
    public void modifyText(ModifyEvent arg0) {
        if (this.text.getText() == null || this.text.getText().isEmpty()) {
            this.messageManager.addMessage(this.text, new NabuccoMessage("text",
                    "Text needs more than zero character", IMessageProvider.ERROR, text));
        } else {
            messageManager.removeMessage(null, new NabuccoMessage("text", text));
        }
    }

}
