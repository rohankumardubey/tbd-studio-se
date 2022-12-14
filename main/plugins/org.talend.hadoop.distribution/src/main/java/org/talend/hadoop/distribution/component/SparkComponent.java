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
package org.talend.hadoop.distribution.component;

import java.util.List;
import java.util.Set;

import org.talend.core.model.process.INode;
import org.talend.hadoop.distribution.ESparkVersion;

/**
 * Interface that exposes specific Spark methods.
 *
 */
public interface SparkComponent extends MRComponent {

    /**
     * Spark uses Hive 1.2.1 internally
     * (https://spark.apache.org/docs/latest/sql-programming-guide.html#interacting-with
     * -different-versions-of-hive-metastore), If we're using another Hive version for table creation, we need to
     * override default hive version with the one which spark uses.
     *
     * @return true if distribution creates hive tables with hive other than Spark uses internally
     */
    public boolean doRequireMetastoreVersionOverride();

    /**
     * Returns Spark's internal Hive version (currently 1.2.1, as described here:
     * https://spark.apache.org/docs/latest/sql
     * -programming-guide.html#interacting-with-different-versions-of-hive-metastore)
     *
     * @return Spark internal hive version
     */
    public String getHiveMetastoreVersionForSpark();

    /**
     * @return The value to be set in spark.sql.hive.metastore.jars if doRequireMetastoreVersionOverride() returns true 
     */
    public String getHiveMetastoreJars();

    /**
     * A distribution can be using Spark 1.3 or Spark 1.4. This method returns the supported Spark versions.
     *
     * @return the collection of supported @link{ESparkVersion} in the distribution.
     */
    public Set<ESparkVersion> getSparkVersions();

    /**
     * @return true if the distribution supports the Spark Standalone mode.
     */
    public boolean doSupportSparkStandaloneMode();

    /**
     * @return true if the distribution supports the Spark Yarn Client mode.
     */
    public boolean doSupportSparkYarnClientMode();

    /**
     * @return true if the distribution supports the Spark Yarn Cluster mode.
     */
    public boolean doSupportSparkYarnClusterMode();

    /**
     * @return true if the distribution supports the Dynamic Allocation feature.
     * @see http://spark.apache.org/docs/latest/configuration.html#dynamic-allocation
     */
    public boolean doSupportDynamicMemoryAllocation();

    /**
     * @return true if the distribution executes its Spark job through Spark JobServer.
     */
    public boolean isExecutedThroughSparkJobServer();

    /**
     * @return true if the distribution executes its Spark job through Livy.
     */
    public boolean isExecutedThroughLivy();
    
    /**
     * @return true if the distribution executes its Spark job through Knox.
     */
    public boolean isExecutedThroughKnox();

    /**
     * @return A string with all of the Spark jars (from the module group SPARK) mapped to local Studio paths.
     */
    public String generateSparkJarsPaths(List<String> commandLineJarsPaths);
    
    public String generateSparkJarsPaths(List<String> commandLineJarsPaths, boolean isLightWeight);

    /**
     * @return true if the distribution implementation is responsible for importing the Dynamo DB dependencies. If
     * false, the components themselves are going to import a default version of the dependencies
     */
    public boolean doImportDynamoDBDependencies();

    /**
     * @return true if the distribution implementation is responsible for importing the spark hive context dependencies.
     * If false, the components themselves are going to import the default version of dependencies on tSqlRow with module name SPARK-HIVECONTEXT-LIB-ALL_LATEST
     */
    public boolean doImportSparkHiveContextDependencies();

    /**
     * The distribution uses "fs.s3a.secret.key" and "fs.s3a.awsSecretAcessKey" properties for the S3 Authentication with the S3A fileSystem.
     */
    public boolean useS3AProperties();

    /**
     * The distribution supports STS Assume Role.
     */
    public boolean doSupportAssumeRole();
    
    /**
     * returns the class path used by lightweight on cluster side
     */
    public String getLightWeightClasspath();
    
    /**
     * @return the packages used during K8s' spark submit to upload to S3
     */
    public String getS3Packages();
    
    /**
     * @return the packages used during spark submit to upload to blob
     */
    public String getBlobPackages();
    
    /**
     * @return the packages used during spark submit to upload to adls gen 2
     */
    public String getADLS2Packages();
    
    /**
     * @return if the distribution uses spark submit for yarn
     */
    public boolean doSendBySparkSubmit();
    
    /**
     * @param nodes of the job
     * @return the classpath to be set
     */
    public String getSparkClasspath(List<? extends INode> nodes);
    
    /**
     * 
     * @return if the universal plugin can be used in local
     */
    public boolean doSupportUniversalLocalMode();
}
