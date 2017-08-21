// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.dynamic;

import java.util.List;

import org.talend.core.runtime.dynamic.IDynamicConfiguration;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public class DynamicClassloaderAdapter extends AbstractDynamicAdapter {

    public static final String TAG_NAME = "classloader"; //$NON-NLS-1$

    public static final String ATTR_INDEX = "index"; //$NON-NLS-1$

    public static final String ATTR_LIBRARIES = "libraries"; //$NON-NLS-1$

    public DynamicClassloaderAdapter(IDynamicConfiguration dynamicConfiguration, String id) {
        super(dynamicConfiguration, id);
        if (!TAG_NAME.equals(dynamicConfiguration.getTagName())) {
            throw new RuntimeException("The input configuration is not an instance of " + TAG_NAME); //$NON-NLS-1$
        }
    }

    public IDynamicConfiguration getDynamicClassLoader() {
        return (IDynamicConfiguration) getDynamicAttribute();
    }

    @Override
    public void adapt() {
        IDynamicConfiguration dynamicClassLoader = getDynamicClassLoader();

        dynamicClassLoader.setAttribute(ATTR_INDEX, getNewValueByTemplate(ATTR_INDEX));

        dynamicClassLoader.setAttribute(ATTR_LIBRARIES, getAttributeDefault(ATTR_LIBRARIES));

        List<IDynamicConfiguration> childConfigurations = dynamicClassLoader.getChildConfigurations();
        if (childConfigurations != null && !childConfigurations.isEmpty()) {
            for (IDynamicConfiguration config : childConfigurations) {
                AbstractDynamicAdapter adapter = DynamicAdapterFactory.getInstance().create(config.getTagName(), config, getDynamicId());
                adapter.adapt();
            }
        }

        super.adapt();
    }

}
