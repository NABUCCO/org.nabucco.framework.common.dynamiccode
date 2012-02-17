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
package org.nabucco.framework.common.dynamiccode.facade.message.maintain;

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
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeMaintainMsg<p/>Maintain Message for DynamicCodeCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class DynamicCodeCodeMaintainMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;" };

    public static final String CODE = "code";

    public static final String PARENTGROUP = "parentGroup";

    private DynamicCodeCode code;

    private DynamicCodeCodeGroup parentGroup;

    /** Constructs a new DynamicCodeCodeMaintainMsg instance. */
    public DynamicCodeCodeMaintainMsg() {
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
        propertyMap.put(CODE, PropertyDescriptorSupport.createDatatype(CODE, DynamicCodeCode.class, 0,
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
        properties.add(super.createProperty(DynamicCodeCodeMaintainMsg.getPropertyDescriptor(CODE), this.getCode()));
        properties.add(super.createProperty(DynamicCodeCodeMaintainMsg.getPropertyDescriptor(PARENTGROUP),
                this.getParentGroup()));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CODE) && (property.getType() == DynamicCodeCode.class))) {
            this.setCode(((DynamicCodeCode) property.getInstance()));
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
        final DynamicCodeCodeMaintainMsg other = ((DynamicCodeCodeMaintainMsg) obj);
        if ((this.code == null)) {
            if ((other.code != null))
                return false;
        } else if ((!this.code.equals(other.code)))
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
        result = ((PRIME * result) + ((this.code == null) ? 0 : this.code.hashCode()));
        result = ((PRIME * result) + ((this.parentGroup == null) ? 0 : this.parentGroup.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getCode.
     *
     * @return the DynamicCodeCode.
     */
    public DynamicCodeCode getCode() {
        return this.code;
    }

    /**
     * Missing description at method setCode.
     *
     * @param code the DynamicCodeCode.
     */
    public void setCode(DynamicCodeCode code) {
        this.code = code;
    }

    /**
     * Missing description at method getParentGroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getParentGroup() {
        return this.parentGroup;
    }

    /**
     * Missing description at method setParentGroup.
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
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeMaintainMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeMaintainMsg.class).getAllProperties();
    }
}
