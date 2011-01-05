/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message.resolve;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeResolveRs<p/>Response message of the resolve service of datatype DynamicCodeCode<p/>
 *
 * @version 1.0
 * @author Lasse Asbach, PRODYNA AG, 2010-07-21
 */
public class DynamicCodeCodeResolveRs extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "code", "parentGroup" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;" };

    /** The resolved code. */
    private DynamicCodeCode code;

    /** The resolved parent codegroup. */
    private DynamicCodeCodeGroup parentGroup;

    /** Constructs a new DynamicCodeCodeResolveRs instance. */
    public DynamicCodeCodeResolveRs() {
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
        final DynamicCodeCodeResolveRs other = ((DynamicCodeCodeResolveRs) obj);
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
        appendable.append("<DynamicCodeCodeResolveRs>\n");
        appendable.append(super.toString());
        appendable.append((("<code>" + this.code) + "</code>\n"));
        appendable.append((("<parentGroup>" + this.parentGroup) + "</parentGroup>\n"));
        appendable.append("</DynamicCodeCodeResolveRs>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The resolved code.
     *
     * @return the DynamicCodeCode.
     */
    public DynamicCodeCode getCode() {
        return this.code;
    }

    /**
     * The resolved code.
     *
     * @param code the DynamicCodeCode.
     */
    public void setCode(DynamicCodeCode code) {
        this.code = code;
    }

    /**
     * The resolved parent codegroup.
     *
     * @return the DynamicCodeCodeGroup.
     */
    public DynamicCodeCodeGroup getParentGroup() {
        return this.parentGroup;
    }

    /**
     * The resolved parent codegroup.
     *
     * @param parentGroup the DynamicCodeCodeGroup.
     */
    public void setParentGroup(DynamicCodeCodeGroup parentGroup) {
        this.parentGroup = parentGroup;
    }
}
