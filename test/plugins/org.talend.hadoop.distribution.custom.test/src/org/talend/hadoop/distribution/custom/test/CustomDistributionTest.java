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
package org.talend.hadoop.distribution.custom.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talend.hadoop.distribution.ESparkVersion;
import org.talend.hadoop.distribution.component.HBaseComponent;
import org.talend.hadoop.distribution.component.HCatalogComponent;
import org.talend.hadoop.distribution.component.HDFSComponent;
import org.talend.hadoop.distribution.component.HadoopComponent;
import org.talend.hadoop.distribution.component.HiveComponent;
import org.talend.hadoop.distribution.component.ImpalaComponent;
import org.talend.hadoop.distribution.component.MRComponent;
import org.talend.hadoop.distribution.component.SparkBatchComponent;
import org.talend.hadoop.distribution.component.SparkStreamingComponent;
import org.talend.hadoop.distribution.component.SqoopComponent;
import org.talend.hadoop.distribution.custom.CustomDistribution;
import org.talend.hadoop.distribution.test.AbstractDistributionTest;

/**
 * Test class for the {@link CustomDistribution} distribution.
 *
 */
public class CustomDistributionTest extends AbstractDistributionTest {

    public CustomDistributionTest() {
        super(new CustomDistribution());
    }

    private final static String DEFAULT_YARN_APPLICATION_CLASSPATH = "$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*"; //$NON-NLS-1$

    @Test
    public void testCustomDistribution() throws Exception {
        HadoopComponent distribution = new CustomDistribution();
        assertNotNull(distribution.getDistributionName());
        assertNull(distribution.getVersionName(null));
        assertTrue(distribution.doSupportS3());
        assertEquals(CustomDistribution.DISTRIBUTION_NAME, distribution.getDistribution());
        assertNull(distribution.getVersion());
        assertNull(distribution.getHadoopVersion());
        assertTrue(distribution.doSupportKerberos());
        assertTrue(distribution.doSupportUseDatanodeHostname());
        assertFalse(distribution.doSupportGroup());
        assertTrue(distribution.doSupportOldImportMode());
        assertTrue(((HDFSComponent) distribution).doSupportSequenceFileShortType());
        assertFalse(((MRComponent) distribution).isExecutedThroughWebHCat());
        assertFalse(((MRComponent) distribution).doSupportCrossPlatformSubmission());
        assertTrue(((MRComponent) distribution).doSupportImpersonation());
        assertEquals(DEFAULT_YARN_APPLICATION_CLASSPATH, ((MRComponent) distribution).getYarnApplicationClasspath());
        assertFalse(((HBaseComponent) distribution).doSupportNewHBaseAPI());
        assertTrue(((SqoopComponent) distribution).doJavaAPISupportStorePasswordInFile());
        assertFalse(((SqoopComponent) distribution).doJavaAPISqoopImportSupportDeleteTargetDir());
        assertTrue(((SqoopComponent) distribution).doJavaAPISqoopImportAllTablesSupportExcludeTable());
        assertTrue(((HiveComponent) distribution).doSupportEmbeddedMode());
        assertTrue(((HiveComponent) distribution).doSupportStandaloneMode());
        assertTrue(((HiveComponent) distribution).doSupportHive1());
        assertTrue(((HiveComponent) distribution).doSupportHive2());
        assertTrue(((HiveComponent) distribution).doSupportTezForHive());
        assertTrue(((HiveComponent) distribution).doSupportHBaseForHive());
        assertTrue(((HiveComponent) distribution).doSupportSSL());
        assertTrue(((HiveComponent) distribution).doSupportORCFormat());
        assertTrue(((HiveComponent) distribution).doSupportAvroFormat());
        assertTrue(((HiveComponent) distribution).doSupportParquetFormat());
        assertFalse(((SparkBatchComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_2_0));
        assertFalse(((SparkBatchComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_6));
        assertFalse(((SparkBatchComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_5));
        assertFalse(((SparkBatchComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_4));
        assertTrue(((SparkBatchComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_3));
        assertTrue(((SparkBatchComponent) distribution).doSupportDynamicMemoryAllocation());
        assertFalse(((SparkBatchComponent) distribution).isExecutedThroughSparkJobServer());
        assertTrue(((SparkBatchComponent) distribution).doSupportSparkStandaloneMode());
        assertTrue(((SparkBatchComponent) distribution).doSupportSparkYarnClientMode());
        assertFalse(((SparkStreamingComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_2_0));
        assertFalse(((SparkStreamingComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_6));
        assertFalse(((SparkStreamingComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_5));
        assertFalse(((SparkStreamingComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_4));
        assertTrue(((SparkStreamingComponent) distribution).getSparkVersions().contains(ESparkVersion.SPARK_1_3));
        assertTrue(((SparkStreamingComponent) distribution).doSupportDynamicMemoryAllocation());
        assertFalse(((SparkStreamingComponent) distribution).isExecutedThroughSparkJobServer());
        assertTrue(((SparkStreamingComponent) distribution).doSupportCheckpointing());
        assertTrue(((SparkStreamingComponent) distribution).doSupportSparkStandaloneMode());
        assertTrue(((SparkStreamingComponent) distribution).doSupportSparkYarnClientMode());
        assertTrue(((SparkStreamingComponent) distribution).doSupportBackpressure());
        assertFalse(((HiveComponent) distribution).doSupportStoreAsParquet());
        assertFalse(((HiveComponent) distribution).doSupportClouderaNavigator());
        assertTrue(distribution instanceof HCatalogComponent);
        assertTrue(distribution instanceof ImpalaComponent);
        assertTrue(distribution.doSupportCreateServiceConnection());
        assertTrue((distribution.getNecessaryServiceName() == null ? 0 : distribution.getNecessaryServiceName().size()) == 0);
        assertFalse(distribution.doSupportAzureDataLakeStorage());
        assertFalse(distribution.doSupportWebHDFS());
    }

}
