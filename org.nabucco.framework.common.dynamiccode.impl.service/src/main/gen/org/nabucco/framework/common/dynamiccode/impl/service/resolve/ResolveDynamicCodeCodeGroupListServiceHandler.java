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
*
* Generated with NABUCCO Generator 
*/
package org.nabucco.framework.common.dynamiccode.impl.service.resolve;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupListMsg;
import org.nabucco.framework.common.dynamiccode.facade.message.maintain.DynamicCodeCodeGroupMaintainMsg;


/**
 * ResolveDynamicCodeCodeGroupListServiceHandler
 * <p/>
 * Resolution Service for DynamicCode
 * <p/>
 * 
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-06
 */
public abstract class ResolveDynamicCodeCodeGroupListServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {
    private static final String ID = "org.nabucco.framework.common.dynamiccode.impl.service.resolve.ResolveDynamicCodeCodeGroupListServiceHandler";

    private static final long serialVersionUID = 1L;

    /** Constructs a new ResolveDynamicCodeCodeGroupListServiceHandler instance. */
    public ResolveDynamicCodeCodeGroupListServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     * 
     * @param msg
     *            the DynamicCodeCodeGroupListMsg.
     * @return the DynamicCodeCodeGroupMaintainMsg.
     * @throws ResolveException
     */
    protected DynamicCodeCodeGroupMaintainMsg invoke(DynamicCodeCodeGroupListMsg msg)
            throws ResolveException {
        try {
            DynamicCodeCodeGroupMaintainMsg rs = this.resolveDynamicCodeCodeGroupList(msg);
            if ((rs == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(rs);
            }
            return rs;
        } catch (ResolveException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ResolveException wrappedException = new ResolveException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ResolveException(e.getMessage());
        }
    }

    /**
     * Missing description at method resolveDynamicCodeCodeGroupList.
     * 
     * @param msg
     *            the DynamicCodeCodeGroupListMsg.
     * @return the DynamicCodeCodeGroupMaintainMsg.
     * @throws ResolveException
     */
    protected abstract DynamicCodeCodeGroupMaintainMsg resolveDynamicCodeCodeGroupList(
            DynamicCodeCodeGroupListMsg msg) throws ResolveException;

    /**
     * Getter for the Id.
     * 
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
