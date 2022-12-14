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
package org.talend.hadoop.distribution.constants;

import java.util.Arrays;
import java.util.List;

public final class SqoopConstant {

    public static final String SERVICE = "org.talend.hadoop.distribution.component.SqoopComponent";//$NON-NLS-1$

    public static final String DISTRIBUTION_PARAMETER = "DISTRIBUTION";//$NON-NLS-1$

    public static final String DISTRIBUTION_REPOSITORYVALUE = "DISTRIBUTION";//$NON-NLS-1$

    public static final String VERSION_PARAMETER = "DB_VERSION";//$NON-NLS-1$

    public static final String VERSION_REPOSITORYVALUE = "DB_VERSION";//$NON-NLS-1$

    public static final String FILE_FORMAT = "FILE_FORMAT";//$NON-NLS-1$

    public static final String PAQUET_OUTPUT_FORMAT = "parquetfile";//$NON-NLS-1$

    public static final String AVRO_OUTPUT_FORMAT = "avrofile";//$NON-NLS-1$

    public static final String TEXT_OUTPUT_FORMAT = "textfile";//$NON-NLS-1$

    public static final String SEQUENCE_OUTPUT_FORMAT = "sequencefile";//$NON-NLS-1$
    
    public static final List<String> SQOOP_COMPONENTS = Arrays.asList("tSqoopImport","tSqoopMerge","tSqoopExport","tSqoopImportAllTables");

}
