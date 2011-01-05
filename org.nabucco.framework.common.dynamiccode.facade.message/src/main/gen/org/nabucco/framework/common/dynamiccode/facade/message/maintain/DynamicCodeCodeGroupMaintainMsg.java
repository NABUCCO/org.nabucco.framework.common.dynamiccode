/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message.maintain;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeGroupMaintainMsg<p/>Maintain Message for DynamicCodeCode<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-06-16
 */
public class DynamicCodeCodeGroupMaintainMsg extends ServiceMessageSupport implements
        ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "codeGroup", "parentGroup" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;" };

    private DynamicCodeCodeGroup codeGroup;

    private DynamicCodeCodeGroup parentGroup;

    /** Constructs a new DynamicCodeCodeGroupMaintainMsg instance. */
    public DynamicCodeCodeGroupMaintainMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<DynamicCodeCodeGroup>(PROPERTY_NAMES[0],
                DynamicCodeCodeGroup.class, PROPERTY_CONSTRAINTS[0], this.codeGroup));
        properties.add(new DatatypeProperty<DynamicCodeCodeGroup>(PROPERTY_NAMES[1],
                DynamicCodeCodeGroup.class, PROPERTY_CONSTRAINTS[1], this.parentGroup));
        return properties;
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
        final DynamicCodeCodeGroupMaintainMsg other = ((DynamicCodeCodeGroupMaintainMsg) obj);
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<DynamicCodeCodeGroupMaintainMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<codeGroup>" + this.codeGroup) + "</codeGroup>\n"));
        appendable.append((("<parentGroup>" + this.parentGroup) + "</parentGroup>\n"));
        appendable.append("</DynamicCodeCodeGroupMaintainMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getCodeGroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getCodeGroup() {
        return this.codeGroup;
    }

    /**
     * Missing description at method setCodeGroup.
     *
     * @param codeGroup the DynamicCodeCodeGroup.
     */
    public void setCodeGroup(DynamicCodeCodeGroup codeGroup) {
        this.codeGroup = codeGroup;
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
}
