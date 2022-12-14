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
package org.talend.hadoop.distribution.hdinsight400;

public enum HDInsight40Constant {

    BIGDATALAUNCHER_MODULE_GROUP("BIGDATA-LAUNCHER-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    HDINSIGHT400COMMON_MODULE_GROUP("HD_INSIGHT_4_0_0_COMMON_LIBRARIES"), //$NON-NLS-1$
    SPARK23_MODULE_GROUP("SPARK23-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK24_MODULE_GROUP("SPARK24-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK23_STREAMING_MODULE_GROUP("SPARK23-STREAMING-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK24_STREAMING_MODULE_GROUP("SPARK24-STREAMING-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$

    SPARK_PARQUET_MRREQUIRED_MODULE_GROUP("SPARK-PARQUET-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK23_HIVE_MRREQUIRED_MODULE_GROUP("SPARK23-HIVE-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK24_HIVE_MRREQUIRED_MODULE_GROUP("SPARK24-HIVE-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK23_STREAMING_PARQUET_MRREQUIRED_MODULE_GROUP("SPARK23-STREAMING-PARQUET-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK24_STREAMING_PARQUET_MRREQUIRED_MODULE_GROUP("SPARK24-STREAMING-PARQUET-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK23_SQL_MRREQUIRED_MODULE_GROUP("SPARK23-SQL-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK24_SQL_MRREQUIRED_MODULE_GROUP("SPARK24-SQL-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$

    HIVE_PARQUET_MODULE_GROUP("HIVE-PARQUET-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK23_MAPREDUCE_MODULE_GROUP("SPARK23-MAPREDUCE-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK24_MAPREDUCE_MODULE_GROUP("SPARK24-MAPREDUCE-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK23_MAPREDUCE_PARQUET_MODULE_GROUP("SPARK23-MAPREDUCE-PARQUET-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    SPARK24_MAPREDUCE_PARQUET_MODULE_GROUP("SPARK24-MAPREDUCE-PARQUET-LIB-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
    
    SPARK23_GRAPHFRAMES_MRREQUIRED_MODULE_GROUP("SPARK23-GRAPHFRAMES-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"), //$NON-NLS-1$
	SPARK24_GRAPHFRAMES_MRREQUIRED_MODULE_GROUP("SPARK24-GRAPHFRAMES-LIB-MRREQUIRED-HD_INSIGHT_4_0_0"); //$NON-NLS-1$

    private String mModuleName;

    HDInsight40Constant(String moduleName) {
        this.mModuleName = moduleName;
    }

    public String getModuleName() {
        return this.mModuleName;
    }
}
