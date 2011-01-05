/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCode;

/**
 * DynamicCodeCodeListMsg<p/>Default message for list of Code datatype<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class DynamicCodeCodeListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "codeList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<DynamicCodeCode> codeList;

    /** Constructs a new DynamicCodeCodeListMsg instance. */
    public DynamicCodeCodeListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<DynamicCodeCode>(PROPERTY_NAMES[0], DynamicCodeCode.class,
                PROPERTY_CONSTRAINTS[0], this.codeList));
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
        final DynamicCodeCodeListMsg other = ((DynamicCodeCodeListMsg) obj);
        if ((this.codeList == null)) {
            if ((other.codeList != null))
                return false;
        } else if ((!this.codeList.equals(other.codeList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.codeList == null) ? 0 : this.codeList.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<DynamicCodeCodeListMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<codeList>" + this.codeList) + "</codeList>\n"));
        appendable.append("</DynamicCodeCodeListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getCodeList.
     *
     * @return the List<DynamicCodeCode>.
     */
    public List<DynamicCodeCode> getCodeList() {
        if ((this.codeList == null)) {
            this.codeList = new ArrayList<DynamicCodeCode>();
        }
        return this.codeList;
    }
}
