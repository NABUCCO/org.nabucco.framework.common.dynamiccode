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
package org.nabucco.framework.common.dynamiccode.ui.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.common.dynamiccode.facade.message.DynamicCodeCodeGroupMsg;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.DynamicCodeComponentServiceDelegateFactory;
import org.nabucco.framework.common.dynamiccode.ui.web.communication.resolve.ResolveDynamicCodeDelegate;

/**
 * DynamicCodeCache
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCache {

    private final Map<String, List<Code>> codeMap;

    /**
     * Singleton instance.
     */
    private static DynamicCodeCache instance;

    /**
     * Private constructor.
     */
    private DynamicCodeCache() {
        this.codeMap = Collections.synchronizedMap(new HashMap<String, List<Code>>());
    }

    /**
     * Singleton access.
     * 
     * @return the DynamicCodeCache instance.
     */
    public static synchronized DynamicCodeCache getInstance() {
        if (instance == null) {
            instance = new DynamicCodeCache();
        }
        return instance;
    }

    /**
     * Initialize the cache by resolving all codes recursively from the root code group.
     * 
     * @param root
     *            the root code group to add to the cache
     */
    public synchronized void init(DynamicCodeCodeGroup root) {
        if (root == null) {
            throw new IllegalArgumentException(
                    "Cannot initialize DynamicCode cache for root code group [null].");
        }

        this.codeMap.clear();
        this.sendToCache(null, root);
    }

    /**
     * Initialize the cache by retrieving the root element from the DynamicCode component and
     * calling {@link DynamicCodeCache#init(DynamicCodeCodeGroup)} implicitly.
     * <p/>
     * The default root code group should have the name <b>'nabucco'</b>.
     * 
     * @param session
     *            the nabucco session to connect to the server
     * 
     * @throws ClientException
     *             when the connection cannot be established
     * @throws ResolveException
     *             when the root code group cannot be resolved
     */
    public synchronized void init(NabuccoSession session) throws ClientException, ResolveException {
        ResolveDynamicCodeDelegate resolveService = DynamicCodeComponentServiceDelegateFactory
                .getInstance().getResolveDynamicCode();

        EmptyServiceMessage rq = new EmptyServiceMessage();
        DynamicCodeCodeGroupMsg rs = resolveService.resolveAll(rq, session);

        this.init(rs.getCodeGroup());
    }

    /**
     * Sends all codes of a code group into the cache.
     * 
     * @param prefix
     *            the prefixing code path
     * @param group
     *            the group to put into the cache
     */
    private void sendToCache(String prefix, DynamicCodeCodeGroup group) {

        String path = this.createPath(prefix, group);

        List<Code> codeList = this.codeMap.get(path);

        if (codeList == null) {
            codeList = new ArrayList<Code>();
            this.codeMap.put(path, codeList);
        }

        for (DynamicCodeCode code : group.getCodeList()) {
            codeList.add(code);
        }

        for (DynamicCodeCodeGroup child : group.getCodeGroupList()) {
            this.sendToCache(path, child);
        }
    }

    /**
     * Creates a code path for a given code group.
     * 
     * @param prefix
     *            the prefixing code path
     * @param group
     *            the group to add to the path
     * 
     * @return the new path
     */
    private String createPath(String prefix, DynamicCodeCodeGroup group) {
        StringBuilder path = new StringBuilder();

        if (prefix != null) {
            path.append(prefix);
            path.append('.');
        }

        path.append(group.getName().getValue());

        return path.toString();
    }

    /**
     * Retrieve the list of codes for the given code path from the cache.
     * 
     * @param path
     *            the path to resolve the codes for
     * 
     * @return the list of codes for the given path
     */
    public synchronized List<Code> getCodes(String path) {
        List<Code> codes = new ArrayList<Code>();
        codes.addAll(this.codeMap.get(path));
        return codes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        List<String> paths = new ArrayList<String>(this.codeMap.keySet());
        Collections.sort(paths);

        for (Iterator<String> iterator = paths.iterator(); iterator.hasNext();) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append('\n');
            }
        }

        return result.toString();
    }

}
