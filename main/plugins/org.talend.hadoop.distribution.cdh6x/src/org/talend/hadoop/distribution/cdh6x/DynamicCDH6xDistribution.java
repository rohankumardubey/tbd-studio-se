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
package org.talend.hadoop.distribution.cdh6x;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.talend.core.runtime.dynamic.IDynamicPluginConfiguration;
import org.talend.designer.maven.aether.IDynamicMonitor;
import org.talend.hadoop.distribution.cdh6x.CDH6xDistributionTemplate;
import org.talend.hadoop.distribution.dynamic.adapter.DynamicPluginAdapter;
import org.talend.hadoop.distribution.dynamic.cdh.AbstractDynamicCDHDistribution;
import org.talend.hadoop.distribution.dynamic.template.IDynamicDistributionTemplate;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public class DynamicCDH6xDistribution extends AbstractDynamicCDHDistribution {

    public static final String TEMPLATE_FOLDER_PATH = "resources/template/cdhx/"; //$NON-NLS-1$

    public static final String BUILD_IN_FOLDER_PATH = "resources/builtin/cdhx/"; //$NON-NLS-1$

    @Override
    protected IDynamicDistributionTemplate initTemplate(DynamicPluginAdapter pluginAdapter, IDynamicMonitor monitor)
            throws Exception {
        IDynamicDistributionTemplate dynamicDistributionTemplate = null;
        IDynamicPluginConfiguration pluginConfiguration = pluginAdapter.getPluginConfiguration();
        String templateId = pluginConfiguration.getTemplateId();
        switch (templateId) {
        case CDH6xDistributionTemplate.TEMPLATE_ID:
            dynamicDistributionTemplate = new CDH6xDistributionTemplate(pluginAdapter);
            break;
        default:
            throw new Exception("Unknown templateId: " + templateId);
        }
        return dynamicDistributionTemplate;
    }

    @Override
    public List<String> getSupportedTemplateIds(IDynamicMonitor monitor) throws Exception {
        List<String> templateIds = new ArrayList<>();

        templateIds.add(CDH6xDistributionTemplate.TEMPLATE_ID);

        return templateIds;
    }

    @Override
    protected String getTemplateFolderPath() {
        return TEMPLATE_FOLDER_PATH;
    }

    @Override
    protected Bundle getBundle() {
        CDH6xPlugin cdh6xPlugin = CDH6xPlugin.getInstance();
        return cdh6xPlugin.getBundle();
    }

    @Override
    protected String getBuiltinFolderPath() {
        return BUILD_IN_FOLDER_PATH;
    }

}
