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
package org.talend.hadoop.distribution.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.talend.core.model.general.ModuleNeeded;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.BooleanOperator;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.condition.MultiComponentCondition;
import org.talend.hadoop.distribution.condition.RawExpression;
import org.talend.hadoop.distribution.condition.SimpleComponentCondition;
import org.talend.hadoop.distribution.condition.common.SparkBatchLinkedNodeCondition;
import org.talend.hadoop.distribution.condition.common.SparkStreamingLinkedNodeCondition;
import org.talend.hadoop.distribution.constants.ModuleGroupName;
import org.talend.hadoop.distribution.constants.SparkBatchConstant;
import org.talend.librariesmanager.model.ExtensionModuleManager;

/**
 * Utilities for distributions module groups (plugin.xml)
 */
public class ModuleGroupsUtils {

    /**
     * Get all module's libraries IDs
     *
     * @param moduleGroupName The name of the module group
     * @return A list of libraries IDs contained in the module group
     */
    public static List<String> getModuleLibrariesIDs(String moduleGroupName) {

        List<String> moduleLibrariesIDs = new ArrayList<>();

        List<ModuleNeeded> moduleNeededList =
                ExtensionModuleManager.getInstance().getModuleNeeded(moduleGroupName, true);

        if (moduleNeededList != null && !moduleNeededList.isEmpty()) {
            for (ModuleNeeded moduleNeeded : moduleNeededList) {
                String id = moduleNeeded.getId();
                moduleLibrariesIDs.add(id);
            }
        }

        return moduleLibrariesIDs;
    }

    /**
     * Get all module's libraries names
     *
     * @param moduleGroupName The name of the module group
     * @return A list of libraries IDs contained in the module group
     */
    public static List<String> getModuleLibrariesNames(String moduleGroupName) {

        List<String> moduleLibrariesNames = new ArrayList<>();

        List<ModuleNeeded> moduleNeededList =
                ExtensionModuleManager.getInstance().getModuleNeeded(moduleGroupName, true);

        if (moduleNeededList != null && !moduleNeededList.isEmpty()) {
            for (ModuleNeeded moduleNeeded : moduleNeededList) {
                String name = moduleNeeded.getModuleName();
                moduleLibrariesNames.add(name);
            }
        }

        return moduleLibrariesNames;
    }

    /**
     * Utility method to create the collection of {@link DistributionModuleGroup} with a condition made of a
     * {@link SparkBatchLinkedNodeCondition} and an additional raw condition
     *
     * @param distribution the distribution key
     * @param version the version key
     * @param condition a nullable additional condition
     * @param moduleName the module name
     * @param mrRequired if the module group is mrRequired
     * @return a set of {@link DistributionModuleGroup}
     */
    public static Set<DistributionModuleGroup> getModuleGroups(String distribution, String version, String condition,
            String moduleName, boolean mrRequired) {
        return getModuleGroups(distribution, version, condition == null ? null : new SimpleComponentCondition(
                new RawExpression(condition)), moduleName, mrRequired);
    }

    /**
     * Utility method to create the collection of {@link DistributionModuleGroup} with a condition made of a
     * {@link SparkBatchLinkedNodeCondition} and an additional raw condition
     *
     * @param distribution the distribution key
     * @param version the version key
     * @param condition a nullable additional condition
     * @param moduleName the module name
     * @param mrRequired if the module group is mrRequired
     * @return a set of {@link DistributionModuleGroup}
     */
    public static Set<DistributionModuleGroup> getModuleGroups(String distribution, String version,
            ComponentCondition condition, String moduleName, boolean mrRequired) {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        ComponentCondition distribCondition =
                new SparkBatchLinkedNodeCondition(distribution, version,
                        SparkBatchConstant.SPARK_BATCH_SPARKCONFIGURATION_LINKEDPARAMETER).getCondition();
        ComponentCondition cc = null;
        if (condition != null) {
            cc = new MultiComponentCondition(condition, BooleanOperator.AND, distribCondition);
        } else {
            cc = distribCondition;
        }
        DistributionModuleGroup dmg = new DistributionModuleGroup(moduleName, mrRequired, cc);
        hs.add(dmg);
        return hs;
    }
    
    /**
     * Utility method to create the collection of {@link DistributionModuleGroup} with a condition made of a
     * {@link SparkStreamingLinkedNodeCondition} and an additional raw condition
     *
     * @param distribution the distribution key
     * @param version the version key
     * @param condition a nullable additional condition
     * @param moduleName the module name
     * @param mrRequired if the module group is mrRequired
     * @return a set of {@link DistributionModuleGroup}
     */
    public static Set<DistributionModuleGroup> getStreamingModuleGroups(String distribution, String version,
            ComponentCondition condition, String moduleName, boolean mrRequired) {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        ComponentCondition distribCondition =
                new SparkStreamingLinkedNodeCondition(distribution, version).getCondition();
        ComponentCondition cc = null;
        if (condition != null) {
            cc = new MultiComponentCondition(condition, BooleanOperator.AND, distribCondition);
        } else {
            cc = distribCondition;
        }
        DistributionModuleGroup dmg = new DistributionModuleGroup(moduleName, mrRequired, cc);
        hs.add(dmg);
        return hs;
    }
    
    
    public static Set<DistributionModuleGroup> getModuleGroups(ComponentCondition condition, String moduleName, boolean mrRequired) {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        hs.add(new DistributionModuleGroup(moduleName, mrRequired, condition));
        return hs;
    }

}