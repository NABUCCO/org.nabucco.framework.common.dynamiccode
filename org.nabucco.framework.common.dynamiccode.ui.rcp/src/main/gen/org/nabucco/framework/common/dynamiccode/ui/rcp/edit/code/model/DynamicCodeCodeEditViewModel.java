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
package org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model;

import java.io.Serializable;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.Tenant;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.plugin.base.component.edit.model.EditViewModel;
import org.nabucco.framework.plugin.base.logging.Loggable;

/**
 * DynamicCodeCodeEditViewModel<p/>@Edit view for datatype DynamicCodeCode<p/>
 *
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class DynamicCodeCodeEditViewModel extends EditViewModel implements Loggable {

    private DynamicCodeCode code;

    private DynamicCodeCodeGroup group;

    public static final String PROPERTY_CODE_NAME = "codeName";

    public static final String PROPERTY_CODE_DESCRIPTION = "codeDescription";

    public static final String PROPERTY_CODE_TENANT = "codeTenant";

    public static final String PROPERTY_CODE_OWNER = "codeOwner";

    public static final String PROPERTY_CODE_FUNCTIONALID = "codeFunctionalId";

    public static final String PROPERTY_GROUP_NAME = "groupName";

    /** Constructs a new DynamicCodeCodeEditViewModel instance. */
    public DynamicCodeCodeEditViewModel() {
        super();
    }

    /**
     * Getter for the ID.
     *
     * @return the String.
     */
    public String getID() {
        return "org.nabucco.framework.common.dynamiccode.ui.rcp.edit.code.model.DynamicCodeCodeEditViewModel";
    }

    /**
     * Getter for the Values.
     *
     * @return the Map<String, Serializable>.
     */
    public Map<String, Serializable> getValues() {
        Map<String, Serializable> result = super.getValues();
        result.put(PROPERTY_CODE_DESCRIPTION, this.getCodeDescription());
        result.put(PROPERTY_GROUP_NAME, this.getGroupName());
        result.put(PROPERTY_CODE_FUNCTIONALID, this.getCodeFunctionalId());
        result.put(PROPERTY_CODE_OWNER, this.getCodeOwner());
        result.put(PROPERTY_CODE_TENANT, this.getCodeTenant());
        result.put(PROPERTY_CODE_NAME, this.getCodeName());
        return result;
    }

    /**
     * Setter for the Code.
     *
     * @param newValue the DynamicCodeCode.
     */
    public void setCode(DynamicCodeCode newValue) {
        DynamicCodeCode oldValue = this.code;
        this.code = newValue;
        this.updateProperty(PROPERTY_CODE_TENANT, ((oldValue != null) ? oldValue.getTenant() : ""),
                ((newValue != null) ? newValue.getTenant() : ""));
        this.updateProperty(PROPERTY_CODE_DESCRIPTION, ((oldValue != null) ? oldValue.getDescription() : ""),
                ((newValue != null) ? newValue.getDescription() : ""));
        this.updateProperty(PROPERTY_CODE_NAME, ((oldValue != null) ? oldValue.getName() : ""),
                ((newValue != null) ? newValue.getName() : ""));
        this.updateProperty(PROPERTY_CODE_OWNER, ((oldValue != null) ? oldValue.getOwner() : ""),
                ((newValue != null) ? newValue.getOwner() : ""));
        this.updateProperty(PROPERTY_CODE_FUNCTIONALID, ((oldValue != null) ? oldValue.getFunctionalId() : ""),
                ((newValue != null) ? newValue.getFunctionalId() : ""));
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
     * Setter for the Group.
     *
     * @param newValue the DynamicCodeCodeGroup.
     */
    public void setGroup(DynamicCodeCodeGroup newValue) {
        DynamicCodeCodeGroup oldValue = this.group;
        this.group = newValue;
        this.updateProperty(PROPERTY_GROUP_NAME, ((oldValue != null) ? oldValue.getName() : ""),
                ((newValue != null) ? newValue.getName() : ""));
    }

    /**
     * Getter for the Group.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getGroup() {
        return this.group;
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
        if (((!oldVal.equals(newDescription)) && code.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            code.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeDescription.
     *
     * @return the String.
     */
    public String getCodeDescription() {
        if ((((code == null) || (code.getDescription() == null)) || (code.getDescription().getValue() == null))) {
            return "";
        }
        return code.getDescription().getValue();
    }

    /**
     * Setter for the CodeTenant.
     *
     * @param newTenant the String.
     */
    public void setCodeTenant(String newTenant) {
        if (((code != null) && (code.getTenant() == null))) {
            Tenant tenant = new Tenant();
            code.setTenant(tenant);
        }
        String oldVal = code.getTenant().getValue();
        code.getTenant().setValue(newTenant);
        this.updateProperty(PROPERTY_CODE_TENANT, oldVal, newTenant);
        if (((!oldVal.equals(newTenant)) && code.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            code.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeTenant.
     *
     * @return the String.
     */
    public String getCodeTenant() {
        if ((((code == null) || (code.getTenant() == null)) || (code.getTenant().getValue() == null))) {
            return "";
        }
        return code.getTenant().getValue();
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

    /**
     * Setter for the CodeFunctionalId.
     *
     * @param newFunctionalId the String.
     */
    public void setCodeFunctionalId(String newFunctionalId) {
        if (((code != null) && (code.getFunctionalId() == null))) {
            FunctionalIdentifier functionalId = new FunctionalIdentifier();
            code.setFunctionalId(functionalId);
        }
        String oldVal = code.getFunctionalId().getValue();
        code.getFunctionalId().setValue(newFunctionalId);
        this.updateProperty(PROPERTY_CODE_FUNCTIONALID, oldVal, newFunctionalId);
        if (((!oldVal.equals(newFunctionalId)) && code.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            code.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeFunctionalId.
     *
     * @return the String.
     */
    public String getCodeFunctionalId() {
        if ((((code == null) || (code.getFunctionalId() == null)) || (code.getFunctionalId().getValue() == null))) {
            return "";
        }
        return code.getFunctionalId().getValue();
    }

    /**
     * Setter for the GroupName.
     *
     * @param newName the String.
     */
    public void setGroupName(String newName) {
        if (((group != null) && (group.getName() == null))) {
            Name name = new Name();
            group.setName(name);
        }
        String oldVal = group.getName().getValue();
        group.getName().setValue(newName);
        this.updateProperty(PROPERTY_GROUP_NAME, oldVal, newName);
        if (((!oldVal.equals(newName)) && group.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            group.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the GroupName.
     *
     * @return the String.
     */
    public String getGroupName() {
        if ((((group == null) || (group.getName() == null)) || (group.getName().getValue() == null))) {
            return "";
        }
        return group.getName().getValue();
    }
}
