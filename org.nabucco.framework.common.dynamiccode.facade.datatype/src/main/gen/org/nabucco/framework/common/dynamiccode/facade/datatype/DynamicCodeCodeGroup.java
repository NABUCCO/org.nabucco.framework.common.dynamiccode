/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.CodeGroup;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "codeGroupList", "codeList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;", "m0,n;" };

    private List<DynamicCodeCodeGroup> codeGroupList;

    private List<DynamicCodeCode> codeList;

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
        if ((this.codeGroupList instanceof NabuccoList<?>)) {
            clone.codeGroupList = ((NabuccoList<DynamicCodeCodeGroup>) this.codeGroupList)
                    .cloneCollection();
        }
        if ((this.codeList instanceof NabuccoList<?>)) {
            clone.codeList = ((NabuccoList<DynamicCodeCode>) this.codeList).cloneCollection();
        }
    }

    /**
     * Getter for the CodeGroupListJPA.
     *
     * @return the List<DynamicCodeCodeGroup>.
     */
    List<DynamicCodeCodeGroup> getCodeGroupListJPA() {
        if ((this.codeGroupList == null)) {
            this.codeGroupList = new NabuccoList<DynamicCodeCodeGroup>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<DynamicCodeCodeGroup>) this.codeGroupList).getDelegate();
    }

    /**
     * Setter for the CodeGroupListJPA.
     *
     * @param codeGroupList the List<DynamicCodeCodeGroup>.
     */
    void setCodeGroupListJPA(List<DynamicCodeCodeGroup> codeGroupList) {
        if ((this.codeGroupList == null)) {
            this.codeGroupList = new NabuccoList<DynamicCodeCodeGroup>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<DynamicCodeCodeGroup>) this.codeGroupList).setDelegate(codeGroupList);
    }

    /**
     * Getter for the CodeListJPA.
     *
     * @return the List<DynamicCodeCode>.
     */
    List<DynamicCodeCode> getCodeListJPA() {
        if ((this.codeList == null)) {
            this.codeList = new NabuccoList<DynamicCodeCode>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<DynamicCodeCode>) this.codeList).getDelegate();
    }

    /**
     * Setter for the CodeListJPA.
     *
     * @param codeList the List<DynamicCodeCode>.
     */
    void setCodeListJPA(List<DynamicCodeCode> codeList) {
        if ((this.codeList == null)) {
            this.codeList = new NabuccoList<DynamicCodeCode>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<DynamicCodeCode>) this.codeList).setDelegate(codeList);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<DynamicCodeCodeGroup>(PROPERTY_NAMES[0],
                DynamicCodeCodeGroup.class, PROPERTY_CONSTRAINTS[0], this.codeGroupList));
        properties.add(new ListProperty<DynamicCodeCode>(PROPERTY_NAMES[1], DynamicCodeCode.class,
                PROPERTY_CONSTRAINTS[1], this.codeList));
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append(super.toString());
        return appendable.toString();
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
     * @return the List<DynamicCodeCodeGroup>.
     */
    public List<DynamicCodeCodeGroup> getCodeGroupList() {
        if ((this.codeGroupList == null)) {
            this.codeGroupList = new NabuccoList<DynamicCodeCodeGroup>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.codeGroupList;
    }

    /**
     * Missing description at method getCodeList.
     *
     * @return the List<DynamicCodeCode>.
     */
    public List<DynamicCodeCode> getCodeList() {
        if ((this.codeList == null)) {
            this.codeList = new NabuccoList<DynamicCodeCode>(NabuccoCollectionState.INITIALIZED);
        }
        return this.codeList;
    }
}
