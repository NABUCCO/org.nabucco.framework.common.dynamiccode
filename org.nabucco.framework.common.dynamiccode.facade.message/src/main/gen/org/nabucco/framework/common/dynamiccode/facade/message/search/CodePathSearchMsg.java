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
package org.nabucco.framework.common.dynamiccode.facade.message.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.code.CodeFilter;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * CodePathSearchMsg<p/>Search message for searching (Dynamic) codes via code paths and code filters.<p/>
 *
 * @version 1.0
 * @author Lasse Asbach, PRODYNA AG, 2010-09-23
 */
public class CodePathSearchMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l1,1024;u0,n;m1,1;", "l1,32;u0,n;m0,1;" };

    public static final String CODEPATH = "codePath";

    public static final String CODEFILTER = "codeFilter";

    /** A full qualified path of the CodeGroup tree. */
    private CodePath codePath;

    /** An optional filter for selecting only matching code values. */
    private CodeFilter codeFilter;

    /** Constructs a new CodePathSearchMsg instance. */
    public CodePathSearchMsg() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(CODEPATH,
                PropertyDescriptorSupport.createBasetype(CODEPATH, CodePath.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(CODEFILTER, PropertyDescriptorSupport.createBasetype(CODEFILTER, CodeFilter.class, 1,
                PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(CodePathSearchMsg.getPropertyDescriptor(CODEPATH), this.codePath));
        properties.add(super.createProperty(CodePathSearchMsg.getPropertyDescriptor(CODEFILTER), this.codeFilter));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CODEPATH) && (property.getType() == CodePath.class))) {
            this.setCodePath(((CodePath) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CODEFILTER) && (property.getType() == CodeFilter.class))) {
            this.setCodeFilter(((CodeFilter) property.getInstance()));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final CodePathSearchMsg other = ((CodePathSearchMsg) obj);
        if ((this.codePath == null)) {
            if ((other.codePath != null))
                return false;
        } else if ((!this.codePath.equals(other.codePath)))
            return false;
        if ((this.codeFilter == null)) {
            if ((other.codeFilter != null))
                return false;
        } else if ((!this.codeFilter.equals(other.codeFilter)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.codePath == null) ? 0 : this.codePath.hashCode()));
        result = ((PRIME * result) + ((this.codeFilter == null) ? 0 : this.codeFilter.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * A full qualified path of the CodeGroup tree.
     *
     * @return the CodePath.
     */
    public CodePath getCodePath() {
        return this.codePath;
    }

    /**
     * A full qualified path of the CodeGroup tree.
     *
     * @param codePath the CodePath.
     */
    public void setCodePath(CodePath codePath) {
        this.codePath = codePath;
    }

    /**
     * An optional filter for selecting only matching code values.
     *
     * @return the CodeFilter.
     */
    public CodeFilter getCodeFilter() {
        return this.codeFilter;
    }

    /**
     * An optional filter for selecting only matching code values.
     *
     * @param codeFilter the CodeFilter.
     */
    public void setCodeFilter(CodeFilter codeFilter) {
        this.codeFilter = codeFilter;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(CodePathSearchMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(CodePathSearchMsg.class).getAllProperties();
    }
}
