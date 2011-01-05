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
import org.nabucco.framework.common.dynamiccode.facade.datatype.DynamicCodeCodeGroup;

/**
 * DynamicCodeCodeGroupListMsg<p/>Default message for list of CodeGroup datatype<p/>
 *
 * @version 1.0
 * @author Stefanie Feld, PRODYNA AG, 2010-03-22
 */
public class DynamicCodeCodeGroupListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "dynamicCodeCodeGroupList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<DynamicCodeCodeGroup> dynamicCodeCodeGroupList;

    /** Constructs a new DynamicCodeCodeGroupListMsg instance. */
    public DynamicCodeCodeGroupListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties
                .add(new ListProperty<DynamicCodeCodeGroup>(PROPERTY_NAMES[0],
                        DynamicCodeCodeGroup.class, PROPERTY_CONSTRAINTS[0],
                        this.dynamicCodeCodeGroupList));
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
        final DynamicCodeCodeGroupListMsg other = ((DynamicCodeCodeGroupListMsg) obj);
        if ((this.dynamicCodeCodeGroupList == null)) {
            if ((other.dynamicCodeCodeGroupList != null))
                return false;
        } else if ((!this.dynamicCodeCodeGroupList.equals(other.dynamicCodeCodeGroupList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.dynamicCodeCodeGroupList == null) ? 0
                : this.dynamicCodeCodeGroupList.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<DynamicCodeCodeGroupListMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<dynamicCodeCodeGroupList>" + this.dynamicCodeCodeGroupList) + "</dynamicCodeCodeGroupList>\n"));
        appendable.append("</DynamicCodeCodeGroupListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getDynamicCodeCodeGroupList.
     *
     * @return the List<DynamicCodeCodeGroup>.
     */
    public List<DynamicCodeCodeGroup> getDynamicCodeCodeGroupList() {
        if ((this.dynamicCodeCodeGroupList == null)) {
            this.dynamicCodeCodeGroupList = new ArrayList<DynamicCodeCodeGroup>();
        }
        return this.dynamicCodeCodeGroupList;
    }
}
