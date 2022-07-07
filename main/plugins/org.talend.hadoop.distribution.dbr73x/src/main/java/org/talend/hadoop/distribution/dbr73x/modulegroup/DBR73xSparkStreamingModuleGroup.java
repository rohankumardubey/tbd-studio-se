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
package org.talend.hadoop.distribution.dbr73x.modulegroup;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.BasicExpression;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.condition.EqualityOperator;
import org.talend.hadoop.distribution.condition.SimpleComponentCondition;
import org.talend.hadoop.distribution.constants.SparkBatchConstant;
import org.talend.hadoop.distribution.dbr73x.DBR73xConstant;

public class DBR73xSparkStreamingModuleGroup {

    public static Set<DistributionModuleGroup> getModuleGroups() {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.SPARK_STREAMING_LIB_MRREQUIRED_DBR73X.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.HIVEONSPARK_LIB_MRREQUIRED_DBR73X.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.SPARK_LIB_MRREQUIRED_DBR73X.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.BIGDATA_LAUNCHER_LIB_DBR73X.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.DYNAMODB_GROUP_DBR73x.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.KAFKA_LIB_REQUIRED_DBR73X.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.SPARK_STREAMING_LIB_KINESIS_DBR73X.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.REDSHIFT_GROUP_DBR73X.getModuleName(),
                true
        ));
        hs.add(new DistributionModuleGroup(
                DBR73xConstant.REST_GROUP_DBR73X.getModuleName(),
                true
        ));
      
        return hs;
    }
}
