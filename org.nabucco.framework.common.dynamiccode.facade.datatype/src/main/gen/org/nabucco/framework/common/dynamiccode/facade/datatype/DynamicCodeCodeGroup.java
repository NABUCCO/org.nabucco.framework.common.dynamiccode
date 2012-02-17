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
package org.nabucco.framework.common.dynamiccode.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.CodeGroup;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeGroup<p/>DynamicCode CodeGroup Datatype<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class DynamicCodeCodeGroup extends CodeGroup implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;", "m0,n;" };

    public static final String CODEGROUPLIST = "codeGroupList";

    public static final String CODELIST = "codeList";

    private NabuccoList<DynamicCodeCodeGroup> codeGroupList;

    private NabuccoList<DynamicCodeCode> codeList;

    /** Constructs a new DynamicCodeCodeGroup instance. */
    public DynamicCodeCodeGroup() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the DynamicCodeCodeGroup.
     */
    protected void cloneObject(DynamicCodeCodeGroup clone) {
        super.cloneObject(clone);
        if ((this.codeGroupList != null)) {
            clone.codeGroupList = this.codeGroupList.cloneCollection();
        }
        if ((this.codeList != null)) {
            clone.codeList = this.codeList.cloneCollection();
        }
    }

    /**
     * Getter for the CodeGroupListJPA.
     *
     * @return the List<DynamicCodeCodeGroup>.
     */
    List<DynamicCodeCodeGroup> getCodeGroupListJPA() {
        if ((this.codeGroupList == null)) {
            this.codeGroupList = new NabuccoListImpl<DynamicCodeCodeGroup>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<DynamicCodeCodeGroup>) this.codeGroupList).getDelegate();
    }

    /**
     * Setter for the CodeGroupListJPA.
     *
     * @param codeGroupList the List<DynamicCodeCodeGroup>.
     */
    void setCodeGroupListJPA(List<DynamicCodeCodeGroup> codeGroupList) {
        if ((this.codeGroupList == null)) {
            this.codeGroupList = new NabuccoListImpl<DynamicCodeCodeGroup>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<DynamicCodeCodeGroup>) this.codeGroupList).setDelegate(codeGroupList);
    }

    /**
     * Getter for the CodeListJPA.
     *
     * @return the List<DynamicCodeCode>.
     */
    List<DynamicCodeCode> getCodeListJPA() {
        if ((this.codeList == null)) {
            this.codeList = new NabuccoListImpl<DynamicCodeCode>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<DynamicCodeCode>) this.codeList).getDelegate();
    }

    /**
     * Setter for the CodeListJPA.
     *
     * @param codeList the List<DynamicCodeCode>.
     */
    void setCodeListJPA(List<DynamicCodeCode> codeList) {
        if ((this.codeList == null)) {
            this.codeList = new NabuccoListImpl<DynamicCodeCode>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<DynamicCodeCode>) this.codeList).setDelegate(codeList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(CodeGroup.class).getPropertyMap());
        propertyMap.put(CODEGROUPLIST, PropertyDescriptorSupport.createCollection(CODEGROUPLIST,
                DynamicCodeCodeGroup.class, 7, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(CODELIST, PropertyDescriptorSupport.createCollection(CODELIST, DynamicCodeCode.class, 8,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(DynamicCodeCodeGroup.getPropertyDescriptor(CODEGROUPLIST),
                this.codeGroupList, null));
        properties.add(super.createProperty(DynamicCodeCodeGroup.getPropertyDescriptor(CODELIST), this.codeList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CODEGROUPLIST) && (property.getType() == DynamicCodeCodeGroup.class))) {
            this.codeGroupList = ((NabuccoList<DynamicCodeCodeGroup>) property.getInstance());
            return true;
        } else if ((property.getName().equals(CODELIST) && (property.getType() == DynamicCodeCode.class))) {
            this.codeList = ((NabuccoList<DynamicCodeCode>) property.getInstance());
            return true;
        }
        return false;
    }

    @Override
    public DynamicCodeCodeGroup cloneObject() {
        DynamicCodeCodeGroup clone = new DynamicCodeCodeGroup();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getCodeGroupList.
     *
     * @return the NabuccoList<DynamicCodeCodeGroup>.
     */
    public NabuccoList<DynamicCodeCodeGroup> getCodeGroupList() {
        if ((this.codeGroupList == null)) {
            this.codeGroupList = new NabuccoListImpl<DynamicCodeCodeGroup>(NabuccoCollectionState.INITIALIZED);
        }
        return this.codeGroupList;
    }

    /**
     * Missing description at method getCodeList.
     *
     * @return the NabuccoList<DynamicCodeCode>.
     */
    public NabuccoList<DynamicCodeCode> getCodeList() {
        if ((this.codeList == null)) {
            this.codeList = new NabuccoListImpl<DynamicCodeCode>(NabuccoCollectionState.INITIALIZED);
        }
        return this.codeList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeGroup.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(DynamicCodeCodeGroup.class).getAllProperties();
    }
}
