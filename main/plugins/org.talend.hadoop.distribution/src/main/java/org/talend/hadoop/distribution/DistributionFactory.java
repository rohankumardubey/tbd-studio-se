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

package org.talend.hadoop.distribution;

import org.talend.hadoop.distribution.component.HadoopComponent;
import org.talend.hadoop.distribution.constants.emr.IAmazonEMRDistribution;
import org.talend.hadoop.distribution.constants.spl.ISparkLocalDistribution;
import org.talend.hadoop.distribution.helper.DistributionHelper;
import org.talend.hadoop.distribution.helper.HadoopDistributionsHelper;

/**
 * This is a factory class that provides a way to create a {@link HadoopComponent} using the underlying GUI classes
 *
 * {@link EHadoopVersion4Drivers} and {@link EHadoopDistributions}
 *
 */
public class DistributionFactory {

    /**
     *
     * Builds a {@link HadoopComponent} distribution.
     *
     * @param pDistribution The name of the distribution
     * @param pVersion The name of the version
     * @return an implementation of {@link HadoopComponent}.
     * @throws Exception
     */
    public static HadoopComponent buildDistribution(String pDistribution, String pVersion) throws Exception {
        return HadoopDistributionsHelper.buildDistribution(pDistribution, pVersion);
    }

    /**
    *
    * Builds a {@link HadoopComponent} distribution.
    *
    * @param sparkLocalVersion
    * @return an implementation of {@link HadoopComponent}.
    */
   public static HadoopComponent buildSparkLocalDistribution(String sparkLocalVersion) {
       try {
		return buildDistribution(ISparkLocalDistribution.DISTRIBUTION_NAME, sparkLocalVersion);
	} catch (Exception e) {
		// This means targeted Spark local version does not exist as a distribution
		return null;
	}
   }
    
        
    
    
    /**
     * Executes a method for a given distribution and version. This function must return a boolean
     *
     * @param methodName the name of the method
     * @param distribution the name of the distribution
     * @param version the name of the version
     *
     * @return
     * @throws Exception
     */
    public static boolean executeBooleanMethod(String methodName, String distribution, String version) throws Exception {
        HadoopComponent hadoopComponent = DistributionFactory.buildDistribution(distribution, version);
        return DistributionHelper.doSupportMethod(hadoopComponent, methodName);
    }

    /**
    *
    * Builds a {@link IAmazonEMRDistribution} distribution.
    *
    * @param distribution The name of the distribution
    * @param version The version of the distribution
    * @return an implementation of {@link IAmazonEMRDistribution}.
    * @throws Exception
    */
    
    public static IAmazonEMRDistribution buildEMRDistribution(String version) throws Exception{
        return HadoopDistributionsHelper.buildEMRDistribution(version);
    }
}
