// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.cdh580.modulegroup;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.cdh580.CDH580Constant;

public class CDH580ImpalaModuleGroup {

    public static Set<DistributionModuleGroup> getModuleGroups() {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        hs.add(new DistributionModuleGroup(CDH580Constant.HIVE_MODULE_GROUP.getModuleName()));
        hs.add(new DistributionModuleGroup(CDH580Constant.HDFS_MODULE_GROUP.getModuleName()));
        hs.add(new DistributionModuleGroup(CDH580Constant.MAPREDUCE_MODULE_GROUP.getModuleName()));
        return hs;
    }
}