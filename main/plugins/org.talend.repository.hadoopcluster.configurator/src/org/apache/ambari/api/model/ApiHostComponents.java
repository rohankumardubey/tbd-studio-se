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
package org.apache.ambari.api.model;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * created by bchen on Jun 10, 2015 Detailled comment
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiHostComponents {

    /**
     * DOC bchen ApiHostComponents constructor comment.
     */
    public ApiHostComponents() {
        // TODO Auto-generated constructor stub
    }

    @XmlElement(name = "HostRoles")
    private ApiHostRoles hostRoles;

    @XmlElement(name = "HostRoles")
    public ApiHostRoles getHostRoles() {
        return hostRoles;
    }
}
