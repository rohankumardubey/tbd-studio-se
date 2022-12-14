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

/**
 * Interface that exposes specific MapRStreams methods.
 */
public interface MapRStreamsComponent {

    /**
     * Spark Streaming jobs need to know where mapr-streams-X.X.X-mapr.jar is located on the cluster.
     *
     * @return The default mapr-streams-X.X.X-mapr.jar path on the cluster.
     */
    String getMapRStreamsJarPath();

    /**
     * Whether the distribution supports MapR Streams Admin API or not.
     *
     * @return true if the distribution supports MapR Streams Admin API.
     */
    boolean canCreateMapRStream();
}
