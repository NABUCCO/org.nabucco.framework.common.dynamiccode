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
package org.nabucco.framework.common.dynamiccode.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
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
 * DynamicCodeCodeGroupListMsg<p/>Default message for list of CodeGroup datatype<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class DynamicCodeCodeGroupListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    public static final String DYNAMICCODECODEGROUPLIST = "dynamicCodeCodeGroupList";

    private NabuccoList<DynamicCodeCodeGroup> dynamicCodeCodeGroupList;

    /** Constructs a new DynamicCodeCodeGroupListMsg instance. */
    public DynamicCodeCodeGroupListMsg() {
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
        propertyMap.put(DYNAMICCODECODEGROUPLIST, PropertyDescriptorSupport.createCollection(DYNAMICCODECODEGROUPLIST,
                DynamicCodeCodeGroup.class, 0, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                DynamicCodeCodeGroupListMsg.getPropertyDescriptor(DYNAMICCODECODEGROUPLIST),
                this.dynamicCodeCodeGroupList));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(DYNAMICCODECODEGROUPLIST) && (property.getType() == DynamicCodeCodeGroup.class))) {
            this.dynamicCodeCodeGroupList = ((NabuccoList<DynamicCodeCodeGroup>) property.getInstance());
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
        final DynamicCodeCodeGroupListMsg other = ((DynamicCodeCodeGroupListMsg) obj);
        if ((this.dynamicCodeCodeGroupList == null)) {
            if ((other.dynamicCodeCodeGroupList != null))
                return false;
        } else if ((!this.dynamicCodeCodeGroupList.equals(other.dynamicCodeCodeGroupList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.dynamicCodeCodeGroupList == null) ? 0 : this.dynamicCodeCodeGroupList
                .hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getDynamicCodeCodeGroupList.
     *
     * @return the NabuccoList<DynamicCodeCodeGroup>.
     */
    public NabuccoList<DynamicCodeCodeGroup> getDynamicCodeCodeGroupList() {
        if ((this.dynamicCodeCodeGroupList == null)) {
            this.dynamicCodeCodeGroupList = new NabuccoListImpl<DynamicCodeCodeGroup>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.dynamicCodeCodeGroupList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeGroupListMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeGroupListMsg.class).getAllProperties();
    }
}
