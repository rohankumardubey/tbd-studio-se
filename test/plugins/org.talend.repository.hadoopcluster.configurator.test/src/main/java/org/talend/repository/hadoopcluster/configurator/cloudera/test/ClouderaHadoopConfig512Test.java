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
package org.talend.repository.hadoopcluster.configurator.cloudera.test;

import org.junit.Ignore;
import org.junit.Test;
import org.talend.repository.hadoopcluster.configurator.HadoopCluster;
import org.talend.repository.hadoopcluster.configurator.HadoopClusterService;
import org.talend.repository.hadoopcluster.configurator.HadoopConfigurationManager;
import org.talend.repository.hadoopcluster.configurator.HadoopConfigurator;
import org.talend.repository.hadoopcluster.configurator.HadoopConfiguratorBuilder;
import org.talend.repository.hadoopcluster.configurator.HadoopHostedService;
import org.talend.repository.hadoopcluster.configurator.test.TestUtil;

import java.net.URL;
import java.util.Map;

/**
 * created by bchen on Nov 26, 2015 Detailled comment
 *
 */
public class ClouderaHadoopConfig512Test {

    //FIXME: use Mock of Cloudera API or TestContainers framework (https://www.testcontainers.org/) to be able to test it.
    @Ignore("ignored in buildme system, comment out this line when run locally")
    @Test
    public void testConfigurator_cdh512() throws Exception {
        String folder = "/tmp/cm";

        // 512
        String url = "http://163.172.6.25:7180";

        HadoopConfigurator configurator = new HadoopConfiguratorBuilder().withVendor(HadoopConfigurationManager.CLOUDERA_MANAGER)
                .withBaseURL(new URL(url)).withUsernamePassword("talendwiz", "83RpC5MWcnZPbQyVaNxF").build();
        TestUtil.checkCluster(configurator, "Cluster 1");

        HadoopCluster cluster = configurator.getCluster(configurator.getAllClusters().get(0));
        Map<HadoopHostedService, HadoopClusterService> services = cluster.getHostedServices();

        TestUtil.checkService(services, HadoopHostedService.HDFS, HadoopHostedService.YARN, HadoopHostedService.HIVE,
                HadoopHostedService.HBASE);

        TestUtil.checkServiceConf(services.get(HadoopHostedService.HDFS), "hdfs-site.xml", "core-site.xml");
        TestUtil.checkServiceConf(services.get(HadoopHostedService.YARN), "yarn-site.xml", "hdfs-site.xml", "core-site.xml",
                "mapred-site.xml");
        TestUtil.checkServiceConf(services.get(HadoopHostedService.HIVE), "hive-site.xml", "yarn-site.xml", "hdfs-site.xml",
                "core-site.xml", "mapred-site.xml");
        TestUtil.checkServiceConf(services.get(HadoopHostedService.HBASE), "hbase-site.xml", "hdfs-site.xml", "core-site.xml");
    }
}
