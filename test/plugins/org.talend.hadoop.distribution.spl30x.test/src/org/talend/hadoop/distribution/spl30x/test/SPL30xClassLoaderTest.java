// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.spl30x.test;

import org.talend.hadoop.distribution.component.HadoopComponent;
import org.talend.hadoop.distribution.spl30x.SPL30xDistribution;
import org.talend.hadoop.distribution.test.classloader.AbstractTest4ClassLoaderProvider;

public class SPL30xClassLoaderTest extends AbstractTest4ClassLoaderProvider {

    @Override
    protected Class<? extends HadoopComponent> getHadoopComponentClass() {
        return SPL30xDistribution.class;
    }


}