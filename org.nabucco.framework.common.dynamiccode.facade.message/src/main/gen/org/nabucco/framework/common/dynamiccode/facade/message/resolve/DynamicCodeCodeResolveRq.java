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

/**
 * DynamicCodeCodeResolveRq<p/>Request message for the resolve service of datatype DynamicCodeCode<p/>
 *
 * @version 1.0
 * @author Lasse Asbach, PRODYNA AG, 2010-07-21
 */
public class DynamicCodeCodeResolveRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "code" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    /** The DynamicCode code to resolve. */
    private DynamicCodeCode code;

    /** Constructs a new DynamicCodeCodeResolveRq instance. */
    public DynamicCodeCodeResolveRq() {
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
        final DynamicCodeCodeResolveRq other = ((DynamicCodeCodeResolveRq) obj);
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
        appendable.append("<DynamicCodeCodeResolveRq>\n");
        appendable.append(super.toString());
        appendable.append((("<code>" + this.code) + "</code>\n"));
        appendable.append("</DynamicCodeCodeResolveRq>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The DynamicCode code to resolve.
     *
     * @return the DynamicCodeCode.
     */
    public DynamicCodeCode getCode() {
        return this.code;
    }

    /**
     * The DynamicCode code to resolve.
     *
     * @param code the DynamicCodeCode.
     */
    public void setCode(DynamicCodeCode code) {
        this.code = code;
    }
}
