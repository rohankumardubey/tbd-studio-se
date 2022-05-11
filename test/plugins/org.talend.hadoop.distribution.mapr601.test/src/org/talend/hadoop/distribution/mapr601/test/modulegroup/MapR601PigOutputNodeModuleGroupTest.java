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
package org.talend.hadoop.distribution.mapr601.test.modulegroup;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.mapr601.MapR601Constant;
import org.talend.hadoop.distribution.mapr601.modulegroup.MapR601PigOutputNodeModuleGroup;

public class MapR601PigOutputNodeModuleGroupTest {

    @Test
    public void testModuleGroups() throws Exception {
        Map<String, String> results = new HashMap<String, String>();
        results.put(MapR601Constant.PIG_PARQUET_MODULE_GROUP.getModuleName(),
                "(#LINK@NODE.ASSOCIATED_PIG_LOAD.DISTRIBUTION=='MAPR') AND (#LINK@NODE.ASSOCIATED_PIG_LOAD.PIG_VERSION=='MAPR601')");
        results.put(MapR601Constant.SPARK_S3_MRREQUIRED_MODULE_GROUP.getModuleName(),
                "(#LINK@NODE.ASSOCIATED_PIG_LOAD.DISTRIBUTION=='MAPR') AND (#LINK@NODE.ASSOCIATED_PIG_LOAD.PIG_VERSION=='MAPR601') "
                        + "AND (S3_LOCATION=='true') AND (STORE!='HCATSTORER') AND (STORE!='HBASESTORAGE')");

        Set<DistributionModuleGroup> moduleGroups = MapR601PigOutputNodeModuleGroup.getModuleGroups();
        assertEquals(results.size(), moduleGroups.size());
        moduleGroups.iterator();
        for (DistributionModuleGroup module : moduleGroups) {
            assertTrue("Should contain module " + module.getModuleName(), results.containsKey(module.getModuleName()));
            if (results.get(module.getModuleName()) == null) {
                assertTrue("The condition of the module " + module.getModuleName() + " is not null.",
                        results.get(module.getModuleName()) == null);
            } else {
                assertTrue(
                        "The condition of the module " + module.getModuleName() + " is null, but it should be "
                                + results.get(module.getModuleName()) + ".", results.get(module.getModuleName()) != null);
                assertEquals(results.get(module.getModuleName()), module.getRequiredIf().getConditionString());
            }
        }
    }
}