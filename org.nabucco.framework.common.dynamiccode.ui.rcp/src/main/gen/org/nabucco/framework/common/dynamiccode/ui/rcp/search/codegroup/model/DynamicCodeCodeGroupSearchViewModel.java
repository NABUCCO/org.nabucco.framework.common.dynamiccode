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
package org.nabucco.framework.common.dynamiccode.ui.rcp.search.codegroup.model;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchViewModel;

/**
 * DynamicCodeCodeGroupSearchViewModel<p/>@TODO<p/>
 *
 * @author Silas Schwarz, PRODYNA AG, 2010-03-05
 */
public class DynamicCodeCodeGroupSearchViewModel extends NabuccoComponentSearchViewModel<DynamicCodeCodeGroup>
        implements NabuccoComponentSearchParameter {

    public static final String ID = "org.nabucco.framework.common.dynamiccode.ui.search.codegroup.DynamicCodeCodeGroupSearchViewModel";

    private DynamicCodeCodeGroup codeGroup;

    public static final String PROPERTY_CODEGROUP_NAME = "codeGroupName";

    public static final String PROPERTY_CODEGROUP_DESCRIPTION = "codeGroupDescription";

    public static final String PROPERTY_CODEGROUP_OWNER = "codeGroupOwner";

    public static String TITLE = (ID + "Title");

    /**
     * Constructs a new DynamicCodeCodeGroupSearchViewModel instance.
     *
     * @param viewId the String.
     */
    public DynamicCodeCodeGroupSearchViewModel(String viewId) {
        super();
        correspondingListView = viewId;
        this.codeGroup = new DynamicCodeCodeGroup();
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
     * Getter for the CodeGroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getCodeGroup() {
        return this.codeGroup;
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
        if (((!oldVal.equals(newName)) && codeGroup.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            codeGroup.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeGroupName.
     *
     * @return the String.
     */
    public String getCodeGroupName() {
        if ((((codeGroup == null) || (codeGroup.getName() == null)) || (codeGroup.getName().getValue() == null))) {
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
        if (((!oldVal.equals(newDescription)) && codeGroup.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            codeGroup.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeGroupDescription.
     *
     * @return the String.
     */
    public String getCodeGroupDescription() {
        if ((((codeGroup == null) || (codeGroup.getDescription() == null)) || (codeGroup.getDescription().getValue() == null))) {
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
        if (((!oldVal.equals(newOwner)) && codeGroup.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            codeGroup.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the CodeGroupOwner.
     *
     * @return the String.
     */
    public String getCodeGroupOwner() {
        if ((((codeGroup == null) || (codeGroup.getOwner() == null)) || (codeGroup.getOwner().getValue() == null))) {
            return "";
        }
        return codeGroup.getOwner().getValue();
    }

    @Override
    public String getId() {
        return DynamicCodeCodeGroupSearchViewModel.ID;
    }
}
