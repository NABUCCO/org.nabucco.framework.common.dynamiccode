/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message.maintain;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "code", "parentGroup" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;" };

    private DynamicCodeCode code;

    private DynamicCodeCodeGroup parentGroup;

    /** Constructs a new DynamicCodeCodeMaintainMsg instance. */
    public DynamicCodeCodeMaintainMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<DynamicCodeCode>(PROPERTY_NAMES[0],
                DynamicCodeCode.class, PROPERTY_CONSTRAINTS[0], this.code));
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<DynamicCodeCodeMaintainMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<code>" + this.code) + "</code>\n"));
        appendable.append((("<parentGroup>" + this.parentGroup) + "</parentGroup>\n"));
        appendable.append("</DynamicCodeCodeMaintainMsg>\n");
        return appendable.toString();
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
}
