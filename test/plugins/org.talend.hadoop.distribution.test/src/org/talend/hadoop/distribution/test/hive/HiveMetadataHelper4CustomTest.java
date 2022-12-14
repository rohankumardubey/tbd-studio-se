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
package org.talend.hadoop.distribution.test.hive;

import org.junit.Test;
import org.talend.hadoop.distribution.constants.custom.ICustomDistribution;
import org.talend.hadoop.distribution.test.hive.AbstractDistributionTest4HiveMetadataHelper;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class HiveMetadataHelper4CustomTest extends AbstractDistributionTest4HiveMetadataHelper {

    @Override
    protected String getDistribution() {
        return ICustomDistribution.DISTRIBUTION_NAME;
    }

    @Override
    protected String getDistributionDisplay() {
        return ICustomDistribution.DISTRIBUTION_DISPLAY_NAME;
    }

    @Override
    protected String[] getDistributionVersionsDisplay() {
        return null;
    }

    //this empty test is here to make tycho runner not failed on initialization
    //because it does not found any test in the final class
    @Override
    @Test
    public void testGetDistributionVersionsDisplay() {
        //
    }

}
