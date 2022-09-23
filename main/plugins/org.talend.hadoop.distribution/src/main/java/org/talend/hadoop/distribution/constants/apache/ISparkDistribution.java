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
package org.talend.hadoop.distribution.constants.apache;

import java.util.List;

import org.talend.hadoop.distribution.constants.databricks.EDatabricksCloudProvider;
import org.talend.hadoop.distribution.constants.databricks.EDatabricksClusterType ;
import org.talend.hadoop.distribution.constants.databricks.EDatabricksSubmitMode;
import org.talend.hadoop.distribution.constants.databricks.EKubernetesAzureCredentials;
import org.talend.hadoop.distribution.constants.databricks.EKubernetesBucketCloudProvider;
import org.talend.hadoop.distribution.constants.databricks.EKubernetesS3Credentials;
import org.talend.hadoop.distribution.constants.databricks.EKubernetesSubmitMode;

public interface ISparkDistribution {

    static final String DISTRIBUTION_NAME = "SPARK";

    static final String DISTRIBUTION_DISPLAY_NAME = "Universal";
    
    public List<ESparkMode> getSparkModes();
    
    List<EDatabricksCloudProvider> getSupportCloudProviders();
    
    List<EDatabricksClusterType > getClusterTypes();
    
    List<EDatabricksSubmitMode> getRunSubmitMode();
    
    List<EKubernetesSubmitMode> getK8sRunSubmitMode();
    
    List<EKubernetesBucketCloudProvider> getK8sCloudProvider();
    
    List<EKubernetesAzureCredentials> getK8sAzureCredentials();
    
    List<EKubernetesS3Credentials> getK8sS3Credentials();

    public boolean doSupportUniversalDBRMode();
    
    public boolean doSupportUniversalDataprocMode();
    
    public boolean doSupportUniversalLocalMode();
    
    public boolean doSupportSparkYarnK8SMode();
    
    public boolean doSupportSparkYarnClusterMode();
    
    public boolean doSupportUniversalStandaloneMode();
    
}
