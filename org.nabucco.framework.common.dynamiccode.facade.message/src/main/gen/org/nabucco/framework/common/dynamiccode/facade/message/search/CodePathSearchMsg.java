/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.framework.common.dynamiccode.facade.message.search;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.code.CodeFilter;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * CodePathSearchMsg<p/>Search message for searching (Dynamic) codes via code paths and code filters.<p/>
 *
 * @version 1.0
 * @author Lasse Asbach, PRODYNA AG, 2010-09-23
 */
public class CodePathSearchMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "codePath", "codeFilter" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m0,1;" };

    /** A full qualified path of the CodeGroup tree. */
    private CodePath codePath;

    /** An optional filter for selecting only matching code values. */
    private CodeFilter codeFilter;

    /** Constructs a new CodePathSearchMsg instance. */
    public CodePathSearchMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<CodePath>(PROPERTY_NAMES[0], CodePath.class,
                PROPERTY_CONSTRAINTS[0], this.codePath));
        properties.add(new BasetypeProperty<CodeFilter>(PROPERTY_NAMES[1], CodeFilter.class,
                PROPERTY_CONSTRAINTS[1], this.codeFilter));
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
        final CodePathSearchMsg other = ((CodePathSearchMsg) obj);
        if ((this.codePath == null)) {
            if ((other.codePath != null))
                return false;
        } else if ((!this.codePath.equals(other.codePath)))
            return false;
        if ((this.codeFilter == null)) {
            if ((other.codeFilter != null))
                return false;
        } else if ((!this.codeFilter.equals(other.codeFilter)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.codePath == null) ? 0 : this.codePath.hashCode()));
        result = ((PRIME * result) + ((this.codeFilter == null) ? 0 : this.codeFilter.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<CodePathSearchMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<codePath>" + this.codePath) + "</codePath>\n"));
        appendable.append((("<codeFilter>" + this.codeFilter) + "</codeFilter>\n"));
        appendable.append("</CodePathSearchMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * A full qualified path of the CodeGroup tree.
     *
     * @return the CodePath.
     */
    public CodePath getCodePath() {
        return this.codePath;
    }

    /**
     * A full qualified path of the CodeGroup tree.
     *
     * @param codePath the CodePath.
     */
    public void setCodePath(CodePath codePath) {
        this.codePath = codePath;
    }

    /**
     * An optional filter for selecting only matching code values.
     *
     * @return the CodeFilter.
     */
    public CodeFilter getCodeFilter() {
        return this.codeFilter;
    }

    /**
     * An optional filter for selecting only matching code values.
     *
     * @param codeFilter the CodeFilter.
     */
    public void setCodeFilter(CodeFilter codeFilter) {
        this.codeFilter = codeFilter;
    }
}
