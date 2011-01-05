/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;

/**
 * DynamicCodeCodeMsg<p/>Default message for Code datatype<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class DynamicCodeCodeMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "code" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private DynamicCodeCode code;

    /** Constructs a new DynamicCodeCodeMsg instance. */
    public DynamicCodeCodeMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<DynamicCodeCode>(PROPERTY_NAMES[0],
                DynamicCodeCode.class, PROPERTY_CONSTRAINTS[0], this.code));
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
        final DynamicCodeCodeMsg other = ((DynamicCodeCodeMsg) obj);
        if ((this.code == null)) {
            if ((other.code != null))
                return false;
        } else if ((!this.code.equals(other.code)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.code == null) ? 0 : this.code.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<DynamicCodeCodeMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<code>" + this.code) + "</code>\n"));
        appendable.append("</DynamicCodeCodeMsg>\n");
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
}
