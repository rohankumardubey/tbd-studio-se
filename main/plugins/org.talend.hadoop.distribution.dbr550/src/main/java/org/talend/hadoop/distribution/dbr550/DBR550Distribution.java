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
package org.talend.hadoop.distribution.dbr550;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.talend.hadoop.distribution.AbstractDatabricksDistribution;
import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.EHadoopVersion;
import org.talend.hadoop.distribution.ESparkVersion;
import org.talend.hadoop.distribution.NodeComponentTypeBean;
import org.talend.hadoop.distribution.component.HiveOnSparkComponent;
import org.talend.hadoop.distribution.component.SparkBatchComponent;
import org.talend.hadoop.distribution.component.SparkStreamingComponent;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.constants.SparkBatchConstant;
import org.talend.hadoop.distribution.constants.SparkStreamingConstant;
import org.talend.hadoop.distribution.dbr550.modulegroup.DBR550HiveOnSparkModuleGroup;
import org.talend.hadoop.distribution.dbr550.modulegroup.DBR550SparkBatchModuleGroup;
import org.talend.hadoop.distribution.dbr550.modulegroup.DBR550SparkStreamingModuleGroup;
import org.talend.hadoop.distribution.dbr550.modulegroup.node.sparkbatch.DBR550SparkBatchAzureNodeModuleGroup;
import org.talend.hadoop.distribution.dbr550.modulegroup.node.sparkstreaming.DBR550SparkStreamingKinesisNodeModuleGroup;

public class DBR550Distribution extends AbstractDatabricksDistribution implements SparkBatchComponent,
        SparkStreamingComponent, HiveOnSparkComponent {

    public final static String VERSION = "Databricks_5_5";

    public static final String VERSION_DISPLAY = "5.5 LTS (includes Apache Spark 2.4.3, Scala 2.11)";

    private final static String YARN_APPLICATION_CLASSPATH = "$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*"; //$NON-NLS-1$

    protected Map<ComponentType, Set<DistributionModuleGroup>> moduleGroups;

    protected Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> nodeModuleGroups;

    protected Map<ComponentType, ComponentCondition> displayConditions;

    protected Map<ComponentType, String> customVersionDisplayNames;

    public DBR550Distribution() {
        displayConditions = buildDisplayConditions();
        customVersionDisplayNames = buildCustomVersionDisplayNames();
        moduleGroups = buildModuleGroups();
        nodeModuleGroups = buildNodeModuleGroups(getDistribution(), getVersion());
    }

    protected Map<ComponentType, ComponentCondition> buildDisplayConditions() {
        return new HashMap<>();
    }

    protected Map<ComponentType, String> buildCustomVersionDisplayNames() {
        Map<ComponentType, String> result = new HashMap<>();
        return result;
    }

    protected Map<ComponentType, Set<DistributionModuleGroup>> buildModuleGroups() {
        Map<ComponentType, Set<DistributionModuleGroup>> result = new HashMap<>();
        result.put(ComponentType.SPARKBATCH, DBR550SparkBatchModuleGroup.getModuleGroups());
        result.put(ComponentType.SPARKSTREAMING, DBR550SparkStreamingModuleGroup.getModuleGroups());
        result.put(ComponentType.HIVEONSPARK, DBR550HiveOnSparkModuleGroup.getModuleGroups());
        return result;
    }

    protected Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> buildNodeModuleGroups(String distribution, String version) {
        Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> result = super.buildNodeModuleGroups(distribution, version);
        // Azure
        result.put(new NodeComponentTypeBean(ComponentType.SPARKBATCH,
                SparkBatchConstant.AZURE_CONFIGURATION_COMPONENT), DBR550SparkBatchAzureNodeModuleGroup
                .getModuleGroups(distribution, version));
        result.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.AZURE_CONFIGURATION_COMPONENT), DBR550SparkBatchAzureNodeModuleGroup
                .getModuleGroups(distribution, version));

        // Kinesis
        result.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING, SparkStreamingConstant.KINESIS_OUTPUT_COMPONENT), DBR550SparkStreamingKinesisNodeModuleGroup.getKinesisModuleGroups(distribution, version, null));
        result.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING, SparkStreamingConstant.KINESIS_INPUT_COMPONENT), DBR550SparkStreamingKinesisNodeModuleGroup.getKinesisModuleGroups(distribution, version, null));
        result.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING, SparkStreamingConstant.KINESIS_INPUT_AVRO_COMPONENT), DBR550SparkStreamingKinesisNodeModuleGroup.getKinesisModuleGroups(distribution, version, null));
        return result;

    }

	@Override
	public String getDistribution() {
		// TODO Auto-generated method stub
        return DISTRIBUTION_NAME;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
        return VERSION;
	}

	@Override
	public EHadoopVersion getHadoopVersion() {
		// TODO Auto-generated method stub
        return EHadoopVersion.HADOOP_2;
	}

	@Override
	public boolean doSupportKerberos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDistributionName() {
		// TODO Auto-generated method stub
        return DISTRIBUTION_DISPLAY_NAME;
	}

	@Override
	public String getVersionName(ComponentType componentType) {
		// TODO Auto-generated method stub
        return VERSION_DISPLAY;
	}

	@Override
	public boolean doSupportUseDatanodeHostname() {
		// TODO Auto-generated method stub
        return true;
	}

    @Override
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType) {
        return moduleGroups.get(componentType);
    }

    @Override
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType, String componentName) {
        return nodeModuleGroups.get(new NodeComponentTypeBean(componentType, componentName));
    }

	@Override
	public Set<ESparkVersion> getSparkVersions() {
		Set<ESparkVersion> version = new HashSet<>();
		version.add(ESparkVersion.SPARK_2_4_X);
        return version;
    }

	@Override
	public boolean doSupportDynamicMemoryAllocation() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doSupportCrossPlatformSubmission() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doSupportImpersonation() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDatabricksDistribution() {
	    return true;
	}

	@Override
	public boolean isCloudDistribution() {
	    return true;
    }

	@Override
	public boolean useCloudLauncher() {
	    return true;
    }

	@Override
	public boolean doSupportSparkStandaloneMode() {
	    return true;
    }

	@Override
	public boolean doSupportSparkYarnClientMode() {
	    return false;
    }

	@Override
	public boolean doSupportSparkYarnClusterMode() {
	    return false;
    }

    @Override
    public boolean doSupportAzureBlobStorage() {
        return true;
    }

    @Override
    public boolean doSupportAzureDataLakeStorage() {
        return true;
    }

    @Override
    public boolean doSupportCheckpointing() {
        return true;
    }

    @Override
    public boolean doSupportBackpressure() {
        return true;
    }

    @Override
    public boolean doSupportS3() {
        return true;
    }

    @Override
    public boolean doSupportS3V4() {
        return true;
    }

    @Override
    public boolean useOldAWSAPI() {
        return true;
    }

    @Override
    public String getTransientClusterSparkVersion() {
        return "\"5.5.x-scala2.11\"";
    }
    
    @Override
    public boolean doSupportAzureDataLakeStorageGen2() {
    	return true;
    }
}
