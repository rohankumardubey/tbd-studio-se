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
package org.talend.hadoop.distribution.condition.common;

import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.condition.BooleanOperator;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.condition.EqualityOperator;
import org.talend.hadoop.distribution.condition.LinkedNodeExpression;
import org.talend.hadoop.distribution.condition.MultiComponentCondition;
import org.talend.hadoop.distribution.condition.NestedComponentCondition;
import org.talend.hadoop.distribution.condition.SimpleComponentCondition;
import org.talend.hadoop.distribution.constants.SparkBatchConstant;
import org.talend.hadoop.distribution.constants.SparkStreamingConstant;

/**
 * created by rdubois on 16 nov. 2015 Detailled comment
 *
 */
public class SparkStreamingLinkedNodeCondition {

    private ComponentCondition mCondition = null;

    public SparkStreamingLinkedNodeCondition(String distribution, String version) {
        this(distribution, version, SparkStreamingConstant.SPARK_STREAMING_SPARKCONFIGURATION_LINKEDPARAMETER);
    }

    public SparkStreamingLinkedNodeCondition(String distribution, String version, String linkedParameter) {
        final ComponentCondition isCurrentDistribution = new NestedComponentCondition(new MultiComponentCondition(
                new SimpleComponentCondition(new LinkedNodeExpression(linkedParameter, //
                        ComponentType.SPARKSTREAMING.getDistributionParameter(), EqualityOperator.EQ, distribution)),
                BooleanOperator.AND,//
                new SimpleComponentCondition(new LinkedNodeExpression(linkedParameter, //
                        ComponentType.SPARKSTREAMING.getVersionParameter(), EqualityOperator.EQ, version))));

        this.mCondition = isCurrentDistribution;
    }

    public ComponentCondition getCondition() {
        return this.mCondition;
    }
}
