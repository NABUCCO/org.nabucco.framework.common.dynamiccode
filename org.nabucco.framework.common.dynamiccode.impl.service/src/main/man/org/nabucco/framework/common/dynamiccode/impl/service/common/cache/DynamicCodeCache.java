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
package org.nabucco.framework.common.dynamiccode.impl.service.common.cache;

import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCache
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class DynamicCodeCache {

    /** Map of Dynamic Codes by their code path. */
    private static final Map<String, SoftReference<Collection<DynamicCodeCode>>> CODE_BY_CODEPATH = new HashMap<String, SoftReference<Collection<DynamicCodeCode>>>();

    /** Map of Dynamic Codes by their ID. */
    private static final Map<Long, SoftReference<DynamicCodeCode>> CODE_BY_ID = new HashMap<Long, SoftReference<DynamicCodeCode>>();

    /** Map of Dynamic CodeGroups by their ID. */
    private static final Map<Long, SoftReference<DynamicCodeCodeGroup>> GROUP_BY_ID = new HashMap<Long, SoftReference<DynamicCodeCodeGroup>>();

    /**
     * Private constructor must not be invoked.
     */
    private DynamicCodeCache() {
    }

    /**
     * Retrieves the DynamicCodeCode by its ID.
     * 
     * @param id
     *            ID of the code
     * 
     * @return the specified code
     */
    public static DynamicCodeCode retrieveFromCache(Long id) {
        if (id == null) {
            return null;
        }

        synchronized (CODE_BY_ID) {
            SoftReference<DynamicCodeCode> reference = CODE_BY_ID.get(id);
            if (reference != null && reference.get() != null) {
                return reference.get();
            }
        }

        return null;
    }

    /**
     * Retrieves the DynamicCodeCodeGroup by its child ID.
     * 
     * @param code
     *            child code
     * 
     * @return the specified code
     */
    public static DynamicCodeCodeGroup retrieveFromCache(DynamicCodeCode code) {
        if (code == null || code.getId() == null) {
            return null;
        }

        synchronized (GROUP_BY_ID) {
            SoftReference<DynamicCodeCodeGroup> reference = GROUP_BY_ID.get(code.getId());
            if (reference != null && reference.get() != null) {
                return reference.get();
            }
        }

        return null;
    }

    /**
     * Retrieves the list of cached codes.
     * 
     * @param path
     *            the code path
     * 
     * @return the list of codes
     */
    public static Collection<DynamicCodeCode> retrieveFromCache(CodePath path) {
        if (path == null || path.getValue() == null) {
            return null;
        }

        synchronized (CODE_BY_CODEPATH) {
            SoftReference<Collection<DynamicCodeCode>> reference = CODE_BY_CODEPATH.get(path.getValue());
            if (reference != null && reference.get() != null) {
                return reference.get();
            }
        }

        return null;
    }

    /**
     * Cache a dynamic code by its ID.
     * 
     * @param code
     *            the code to cache
     */
    public static void sendToCache(DynamicCodeCode code) {
        if (code == null || code.getId() == null) {
            return;
        }

        synchronized (CODE_BY_ID) {
            CODE_BY_ID.put(code.getId(), new SoftReference<DynamicCodeCode>(code));
        }
    }

    /**
     * Cache a dynamic codegroup by its ID.
     * 
     * @param child
     *            the child code
     * @param group
     *            the codegroup to cache
     */
    public static void sendToCache(DynamicCodeCode child, DynamicCodeCodeGroup group) {
        if (child == null || child.getId() == null) {
            return;
        }

        synchronized (GROUP_BY_ID) {
            GROUP_BY_ID.put(child.getId(), new SoftReference<DynamicCodeCodeGroup>(group));
        }
    }

    /**
     * Cache a list of dynamic codes by their code path.
     * 
     * @param path
     *            the path as key
     * @param codes
     *            the list of codes
     */
    public static void sendToCache(CodePath path, Collection<DynamicCodeCode> codes) {
        if (path == null || path.getValue() == null) {
            return;
        }

        synchronized (CODE_BY_CODEPATH) {
            CODE_BY_CODEPATH.put(path.getValue(), new SoftReference<Collection<DynamicCodeCode>>(codes));
        }
    }

    /**
     * Clears all cached DynamicCode entries.
     */
    public static void clear() {
        CODE_BY_CODEPATH.clear();
        CODE_BY_ID.clear();
        GROUP_BY_ID.clear();
    }

}
