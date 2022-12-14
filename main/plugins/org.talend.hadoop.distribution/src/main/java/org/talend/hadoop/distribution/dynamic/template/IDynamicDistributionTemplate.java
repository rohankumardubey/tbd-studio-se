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
package org.talend.hadoop.distribution.dynamic.template;

import java.util.List;

import org.talend.hadoop.distribution.dynamic.adapter.DynamicPluginAdapter;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public interface IDynamicDistributionTemplate {

    public List<String> getServices();

    public String getTemplateId();

    DynamicPluginAdapter getPluginAdapter();

    boolean registOsgiServices();

    boolean unregistOsgiServices();

    boolean isPluginExtensionsRegisted();

    boolean registPluginExtensions();

    boolean unregistPluginExtensions(boolean reloadLibCache);

}
