/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.code.model;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchViewModel;

/**
 * DynamicCodeCodeSearchViewModel<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-05
 */
public class DynamicCodeCodeSearchViewModel extends
        NabuccoComponentSearchViewModel<DynamicCodeCode> implements NabuccoComponentSearchParameter {

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.search.code.DynamicCodeCodeSearchViewModel";

    private DynamicCodeCode code;

    public static final String PROPERTY_CODE_NAME = "codeName";

    public static final String PROPERTY_CODE_DESCRIPTION = "codeDescription";

    public static final String PROPERTY_CODE_OWNER = "codeOwner";

    public static String TITLE = (ID + "Title");

    /**
     * Constructs a new DynamicCodeCodeSearchViewModel instance.
     *
     * @param viewId the String.
     */
    public DynamicCodeCodeSearchViewModel(String viewId) {
        super();
        correspondingListView = viewId;
        this.code = new DynamicCodeCode();
    }

    @Override
    public String getSearchModelId() {
        return searchModelId;
    }

    @Override
    public NabuccoComponentSearchParameter getSearchParameter() {
        return this;
    }

    /**
     * Getter for the Code.
     *
     * @return the DynamicCodeCode.
     */
    public DynamicCodeCode getCode() {
        return this.code;
    }

    /**
     * Setter for the CodeName.
     *
     * @param newName the String.
     */
    public void setCodeName(String newName) {
        if (((code != null) && (code.getName() == null))) {
            Name name = new Name();
            code.setName(name);
        }
        String oldVal = code.getName().getValue();
        code.getName().setValue(newName);
        this.updateProperty(PROPERTY_CODE_NAME, oldVal, newName);
        if (((!oldVal.equals(newName)) && code.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            code.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeName.
     *
     * @return the String.
     */
    public String getCodeName() {
        if ((((code == null) || (code.getName() == null)) || (code.getName().getValue() == null))) {
            return "";
        }
        return code.getName().getValue();
    }

    /**
     * Setter for the CodeDescription.
     *
     * @param newDescription the String.
     */
    public void setCodeDescription(String newDescription) {
        if (((code != null) && (code.getDescription() == null))) {
            Description description = new Description();
            code.setDescription(description);
        }
        String oldVal = code.getDescription().getValue();
        code.getDescription().setValue(newDescription);
        this.updateProperty(PROPERTY_CODE_DESCRIPTION, oldVal, newDescription);
        if (((!oldVal.equals(newDescription)) && code.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            code.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeDescription.
     *
     * @return the String.
     */
    public String getCodeDescription() {
        if ((((code == null) || (code.getDescription() == null)) || (code.getDescription()
                .getValue() == null))) {
            return "";
        }
        return code.getDescription().getValue();
    }

    /**
     * Setter for the CodeOwner.
     *
     * @param newOwner the String.
     */
    public void setCodeOwner(String newOwner) {
        if (((code != null) && (code.getOwner() == null))) {
            Owner owner = new Owner();
            code.setOwner(owner);
        }
        String oldVal = code.getOwner().getValue();
        code.getOwner().setValue(newOwner);
        this.updateProperty(PROPERTY_CODE_OWNER, oldVal, newOwner);
        if (((!oldVal.equals(newOwner)) && code.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            code.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeOwner.
     *
     * @return the String.
     */
    public String getCodeOwner() {
        if ((((code == null) || (code.getOwner() == null)) || (code.getOwner().getValue() == null))) {
            return "";
        }
        return code.getOwner().getValue();
    }

    @Override
    public String getId() {
        return DynamicCodeCodeSearchViewModel.ID;
    }
}
