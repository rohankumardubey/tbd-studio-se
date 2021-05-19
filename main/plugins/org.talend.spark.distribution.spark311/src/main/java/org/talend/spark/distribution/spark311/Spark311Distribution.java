// ============================================================================
//
// Copyright (C) 2006-2020 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.spark.distribution.spark311;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.talend.hadoop.distribution.AbstractDistribution;
import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.EHadoopVersion;
import org.talend.hadoop.distribution.EParquetPackagePrefix;
import org.talend.hadoop.distribution.ESparkVersion;
import org.talend.hadoop.distribution.NodeComponentTypeBean;
import org.talend.hadoop.distribution.component.HiveOnSparkComponent;
import org.talend.hadoop.distribution.component.SparkBatchComponent;
import org.talend.hadoop.distribution.component.SparkStreamingComponent;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.constants.apache.ISparkDistribution;
import org.talend.spark.distribution.spark311.modulegroup.Spark311SparkCompileModuleGroup;

public class Spark311Distribution extends AbstractDistribution
        implements ISparkDistribution, SparkBatchComponent, SparkStreamingComponent, HiveOnSparkComponent {

    public final static ESparkVersion SPARK_VERSION = ESparkVersion.SPARK_3_1;

    public final static String VERSION = Spark311Distribution.SPARK_VERSION.getSparkVersion();

    public static final String VERSION_DISPLAY = Spark311Distribution.SPARK_VERSION.getVersionLabel();

    protected Map<ComponentType, Set<DistributionModuleGroup>> moduleGroups;

    protected Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> nodeModuleGroups;

    protected Map<ComponentType, ComponentCondition> displayConditions;

    protected Map<ComponentType, String> customVersionDisplayNames;

    public Spark311Distribution() {
        this.displayConditions = buildDisplayConditions();
        this.customVersionDisplayNames = buildCustomVersionDisplayNames();
        this.moduleGroups = buildModuleGroups();
        this.nodeModuleGroups = buildNodeModuleGroups(getDistribution(), getVersion());
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
        result.put(ComponentType.SPARKBATCH, Spark311SparkCompileModuleGroup.getModuleGroups());
        result.put(ComponentType.SPARKSTREAMING, Spark311SparkCompileModuleGroup.getModuleGroups());
        return result;
    }

    protected Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> buildNodeModuleGroups(String distribution,
            String version) {
        Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> result = new HashMap<>();

        return result;

    }

    @Override
    public String getDistribution() {
        return DISTRIBUTION_NAME;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public EHadoopVersion getHadoopVersion() {
        return EHadoopVersion.HADOOP_3;
    }

    @Override
    public boolean doSupportKerberos() {
        return false;
    }

    @Override
    public String getDistributionName() {
        return DISTRIBUTION_DISPLAY_NAME;
    }

    @Override
    public String getVersionName(ComponentType componentType) {
        return VERSION_DISPLAY;
    }

    @Override
    public boolean doSupportUseDatanodeHostname() {
        return true;
    }

    @Override
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType) {
        return this.moduleGroups.get(componentType);
    }

    @Override
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType, String componentName) {
        return this.nodeModuleGroups.get(new NodeComponentTypeBean(componentType, componentName));
    }

    @Override
    public Set<ESparkVersion> getSparkVersions() {
        Set<ESparkVersion> version = new HashSet<>();
        version.add(ESparkVersion.SPARK_3_1);
        return version;
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
        return false;
    }

    @Override
    public boolean doSupportSparkStandaloneMode() {
        return false;
    }

    @Override
    public boolean doSupportSparkYarnClientMode() {
        return false;
    }
    
    @Override
    public boolean doSupportSparkYarnClusterMode() {
        return false; //at some point we should enable this
    }
    
    @Override
    public boolean doSupportSparkYarnK8SMode() {
    	return true;
    }

    @Override
    public boolean doSupportImpersonation() {
        return false;
    }

    @Override
    public boolean doSupportCheckpointing() {
        return false;
    }

    @Override
    public boolean doSupportBackpressure() {
        return false;
    }

    @Override
    public boolean doSupportAzureDataLakeStorage() {
        return true;
    }

    @Override
    public String getParquetPrefixPackageName() {
        return EParquetPackagePrefix.APACHE.toString();
    }

	@Override
	public boolean doSupportDynamicMemoryAllocation() {
		return false;
	}

	@Override
	public boolean doSupportCrossPlatformSubmission() {
		return false;
	}

}