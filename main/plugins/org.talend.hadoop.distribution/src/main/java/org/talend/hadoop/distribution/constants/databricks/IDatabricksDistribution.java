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
package org.talend.hadoop.distribution.constants.databricks;

import java.util.List;

@SuppressWarnings("nls")
public interface IDatabricksDistribution {

    static final String DISTRIBUTION_NAME = "DATABRICKS";

    static final String DISTRIBUTION_DISPLAY_NAME = "Databricks";

    List<EDatabricksCloudProvider> getSupportCloudProviders();
    
    List<EDatabricksSubmitMode> getRunSubmitMode();

}
