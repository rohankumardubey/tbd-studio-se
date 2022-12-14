// ============================================================================
//
// Copyright (C) 2006-2021 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.hdfsbrowse.exceptions;

import java.lang.reflect.InvocationTargetException;

/**
 * DOC ycbai class global comment. Detailled comment
 */
public class HadoopServerException extends Exception {

    private static final long serialVersionUID = 6647425021640000921L;

    public HadoopServerException(String message) {
        super(message);
    }

    public HadoopServerException(Throwable cause) {
        super(cause instanceof InvocationTargetException ? cause.getCause() : cause);
    }

    public HadoopServerException(String msg, Throwable cause) {
        super(msg, cause instanceof InvocationTargetException ? cause.getCause() : cause);
    }

}
