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
package org.nabucco.framework.common.dynamiccode.facade.message.resolve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeGroupResolveRs<p/>Response message of the resolve service of datatype DynamicCodeCodeGroup<p/>
 *
 * @version 1.0
 * @author Lasse Asbach, PRODYNA AG, 2010-07-21
 */
public class DynamicCodeCodeGroupResolveRs extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;" };

    public static final String CODEGROUP = "codeGroup";

    public static final String PARENTGROUP = "parentGroup";

    /** The resolved codegroup. */
    private DynamicCodeCodeGroup codeGroup;

    /** The resolved parent codegroup. */
    private DynamicCodeCodeGroup parentGroup;

    /** Constructs a new DynamicCodeCodeGroupResolveRs instance. */
    public DynamicCodeCodeGroupResolveRs() {
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
        propertyMap.put(CODEGROUP, PropertyDescriptorSupport.createDatatype(CODEGROUP, DynamicCodeCodeGroup.class, 0,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PARENTGROUP, PropertyDescriptorSupport.createDatatype(PARENTGROUP, DynamicCodeCodeGroup.class,
                1, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(DynamicCodeCodeGroupResolveRs.getPropertyDescriptor(CODEGROUP),
                this.getCodeGroup()));
        properties.add(super.createProperty(DynamicCodeCodeGroupResolveRs.getPropertyDescriptor(PARENTGROUP),
                this.getParentGroup()));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CODEGROUP) && (property.getType() == DynamicCodeCodeGroup.class))) {
            this.setCodeGroup(((DynamicCodeCodeGroup) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PARENTGROUP) && (property.getType() == DynamicCodeCodeGroup.class))) {
            this.setParentGroup(((DynamicCodeCodeGroup) property.getInstance()));
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
        final DynamicCodeCodeGroupResolveRs other = ((DynamicCodeCodeGroupResolveRs) obj);
        if ((this.codeGroup == null)) {
            if ((other.codeGroup != null))
                return false;
        } else if ((!this.codeGroup.equals(other.codeGroup)))
            return false;
        if ((this.parentGroup == null)) {
            if ((other.parentGroup != null))
                return false;
        } else if ((!this.parentGroup.equals(other.parentGroup)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.codeGroup == null) ? 0 : this.codeGroup.hashCode()));
        result = ((PRIME * result) + ((this.parentGroup == null) ? 0 : this.parentGroup.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The resolved codegroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getCodeGroup() {
        return this.codeGroup;
    }

    /**
     * The resolved codegroup.
     *
     * @param codeGroup the DynamicCodeCodeGroup.
     */
    public void setCodeGroup(DynamicCodeCodeGroup codeGroup) {
        this.codeGroup = codeGroup;
    }

    /**
     * The resolved parent codegroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getParentGroup() {
        return this.parentGroup;
    }

    /**
     * The resolved parent codegroup.
     *
     * @param parentGroup the DynamicCodeCodeGroup.
     */
    public void setParentGroup(DynamicCodeCodeGroup parentGroup) {
        this.parentGroup = parentGroup;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeGroupResolveRs.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeGroupResolveRs.class).getAllProperties();
    }
}
