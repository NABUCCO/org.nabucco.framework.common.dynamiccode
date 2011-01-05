/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model;

import java.io.Serializable;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.plugin.base.component.edit.model.EditViewModel;
import org.nabucco.framework.plugin.base.logging.Loggable;

/**
 * DynamicCodeCodeGroupEditViewModel<p/>@Edit view for datatype DynamicCodeCodeGroup<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class DynamicCodeCodeGroupEditViewModel extends EditViewModel implements Loggable {

    private DynamicCodeCodeGroup codeGroup;

    private DynamicCodeCodeGroup parentGroup;

    public static final String PROPERTY_CODEGROUP_NAME = "codeGroupName";

    public static final String PROPERTY_CODEGROUP_DESCRIPTION = "codeGroupDescription";

    public static final String PROPERTY_CODEGROUP_OWNER = "codeGroupOwner";

    public static final String PROPERTY_PARENTGROUP_NAME = "parentGroupName";

    /** Constructs a new DynamicCodeCodeGroupEditViewModel instance. */
    public DynamicCodeCodeGroupEditViewModel() {
        super();
    }

    /**
     * Getter for the ID.
     *
     * @return the String.
     */
    public String getID() {
        return "org.nabucco.framework.common.dynamiccode.ui.rcp.edit.codegroup.model.DynamicCodeCodeGroupEditViewModel";
    }

    /**
     * Getter for the Values.
     *
     * @return the Map<String, Serializable>.
     */
    public Map<String, Serializable> getValues() {
        Map<String, Serializable> result = super.getValues();
        result.put(PROPERTY_CODEGROUP_NAME, this.getCodeGroupName());
        result.put(PROPERTY_CODEGROUP_OWNER, this.getCodeGroupOwner());
        result.put(PROPERTY_CODEGROUP_DESCRIPTION, this.getCodeGroupDescription());
        result.put(PROPERTY_PARENTGROUP_NAME, this.getParentGroupName());
        return result;
    }

    /**
     * Setter for the CodeGroup.
     *
     * @param newValue the DynamicCodeCodeGroup.
     */
    public void setCodeGroup(DynamicCodeCodeGroup newValue) {
        DynamicCodeCodeGroup oldValue = this.codeGroup;
        this.codeGroup = newValue;
        this.updateProperty(PROPERTY_CODEGROUP_DESCRIPTION,
                ((oldValue != null) ? oldValue.getDescription() : ""),
                ((newValue != null) ? newValue.getDescription() : ""));
        this.updateProperty(PROPERTY_CODEGROUP_NAME,
                ((oldValue != null) ? oldValue.getName() : ""),
                ((newValue != null) ? newValue.getName() : ""));
        this.updateProperty(PROPERTY_CODEGROUP_OWNER, ((oldValue != null) ? oldValue.getOwner()
                : ""), ((newValue != null) ? newValue.getOwner() : ""));
    }

    /**
     * Getter for the CodeGroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getCodeGroup() {
        return this.codeGroup;
    }

    /**
     * Setter for the ParentGroup.
     *
     * @param newValue the DynamicCodeCodeGroup.
     */
    public void setParentGroup(DynamicCodeCodeGroup newValue) {
        DynamicCodeCodeGroup oldValue = this.parentGroup;
        this.parentGroup = newValue;
        this.updateProperty(PROPERTY_PARENTGROUP_NAME, ((oldValue != null) ? oldValue.getName()
                : ""), ((newValue != null) ? newValue.getName() : ""));
    }

    /**
     * Getter for the ParentGroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getParentGroup() {
        return this.parentGroup;
    }

    /**
     * Setter for the CodeGroupName.
     *
     * @param newName the String.
     */
    public void setCodeGroupName(String newName) {
        if (((codeGroup != null) && (codeGroup.getName() == null))) {
            Name name = new Name();
            codeGroup.setName(name);
        }
        String oldVal = codeGroup.getName().getValue();
        codeGroup.getName().setValue(newName);
        this.updateProperty(PROPERTY_CODEGROUP_NAME, oldVal, newName);
        if (((!oldVal.equals(newName)) && codeGroup.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            codeGroup.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeGroupName.
     *
     * @return the String.
     */
    public String getCodeGroupName() {
        if ((((codeGroup == null) || (codeGroup.getName() == null)) || (codeGroup.getName()
                .getValue() == null))) {
            return "";
        }
        return codeGroup.getName().getValue();
    }

    /**
     * Setter for the CodeGroupDescription.
     *
     * @param newDescription the String.
     */
    public void setCodeGroupDescription(String newDescription) {
        if (((codeGroup != null) && (codeGroup.getDescription() == null))) {
            Description description = new Description();
            codeGroup.setDescription(description);
        }
        String oldVal = codeGroup.getDescription().getValue();
        codeGroup.getDescription().setValue(newDescription);
        this.updateProperty(PROPERTY_CODEGROUP_DESCRIPTION, oldVal, newDescription);
        if (((!oldVal.equals(newDescription)) && codeGroup.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            codeGroup.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeGroupDescription.
     *
     * @return the String.
     */
    public String getCodeGroupDescription() {
        if ((((codeGroup == null) || (codeGroup.getDescription() == null)) || (codeGroup
                .getDescription().getValue() == null))) {
            return "";
        }
        return codeGroup.getDescription().getValue();
    }

    /**
     * Setter for the CodeGroupOwner.
     *
     * @param newOwner the String.
     */
    public void setCodeGroupOwner(String newOwner) {
        if (((codeGroup != null) && (codeGroup.getOwner() == null))) {
            Owner owner = new Owner();
            codeGroup.setOwner(owner);
        }
        String oldVal = codeGroup.getOwner().getValue();
        codeGroup.getOwner().setValue(newOwner);
        this.updateProperty(PROPERTY_CODEGROUP_OWNER, oldVal, newOwner);
        if (((!oldVal.equals(newOwner)) && codeGroup.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            codeGroup.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeGroupOwner.
     *
     * @return the String.
     */
    public String getCodeGroupOwner() {
        if ((((codeGroup == null) || (codeGroup.getOwner() == null)) || (codeGroup.getOwner()
                .getValue() == null))) {
            return "";
        }
        return codeGroup.getOwner().getValue();
    }

    /**
     * Setter for the ParentGroupName.
     *
     * @param newName the String.
     */
    public void setParentGroupName(String newName) {
        if (((parentGroup != null) && (parentGroup.getName() == null))) {
            Name name = new Name();
            parentGroup.setName(name);
        }
        String oldVal = parentGroup.getName().getValue();
        parentGroup.getName().setValue(newName);
        this.updateProperty(PROPERTY_PARENTGROUP_NAME, oldVal, newName);
        if (((!oldVal.equals(newName)) && parentGroup.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            parentGroup.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the ParentGroupName.
     *
     * @return the String.
     */
    public String getParentGroupName() {
        if ((((parentGroup == null) || (parentGroup.getName() == null)) || (parentGroup.getName()
                .getValue() == null))) {
            return "";
        }
        return parentGroup.getName().getValue();
    }
}
