/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message.search;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * DynamicCodeCodeSearchMsg<p/>Search message for selecting codes of a given tree path<p/>
 *
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-15
 */
public class DynamicCodeCodeSearchMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "owner", "name", "description" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;" };

    /** The owner of the code. For system codes 'NABUCCO' has to be used. */
    private Owner owner;

    /** The name of the code. */
    private Name name;

    /** The description of the code. */
    private Description description;

    /** Constructs a new DynamicCodeCodeSearchMsg instance. */
    public DynamicCodeCodeSearchMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Owner>(PROPERTY_NAMES[0], Owner.class,
                PROPERTY_CONSTRAINTS[0], this.owner));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[1], Name.class,
                PROPERTY_CONSTRAINTS[1], this.name));
        properties.add(new BasetypeProperty<Description>(PROPERTY_NAMES[2], Description.class,
                PROPERTY_CONSTRAINTS[2], this.description));
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
        final DynamicCodeCodeSearchMsg other = ((DynamicCodeCodeSearchMsg) obj);
        if ((this.owner == null)) {
            if ((other.owner != null))
                return false;
        } else if ((!this.owner.equals(other.owner)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.owner == null) ? 0 : this.owner.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<DynamicCodeCodeSearchMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<owner>" + this.owner) + "</owner>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<description>" + this.description) + "</description>\n"));
        appendable.append("</DynamicCodeCodeSearchMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The owner of the code. For system codes 'NABUCCO' has to be used.
     *
     * @return the Owner.
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * The owner of the code. For system codes 'NABUCCO' has to be used.
     *
     * @param owner the Owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * The name of the code.
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * The name of the code.
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * The description of the code.
     *
     * @return the Description.
     */
    public Description getDescription() {
        return this.description;
    }

    /**
     * The description of the code.
     *
     * @param description the Description.
     */
    public void setDescription(Description description) {
        this.description = description;
    }
}
