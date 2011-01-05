/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeGroupMsg<p/>Default message for CodeGroup datatype<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class DynamicCodeCodeGroupMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "codeGroup" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private DynamicCodeCodeGroup codeGroup;

    /** Constructs a new DynamicCodeCodeGroupMsg instance. */
    public DynamicCodeCodeGroupMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<DynamicCodeCodeGroup>(PROPERTY_NAMES[0],
                DynamicCodeCodeGroup.class, PROPERTY_CONSTRAINTS[0], this.codeGroup));
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
        final DynamicCodeCodeGroupMsg other = ((DynamicCodeCodeGroupMsg) obj);
        if ((this.codeGroup == null)) {
            if ((other.codeGroup != null))
                return false;
        } else if ((!this.codeGroup.equals(other.codeGroup)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.codeGroup == null) ? 0 : this.codeGroup.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<DynamicCodeCodeGroupMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<codeGroup>" + this.codeGroup) + "</codeGroup>\n"));
        appendable.append("</DynamicCodeCodeGroupMsg>\n");
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
}
