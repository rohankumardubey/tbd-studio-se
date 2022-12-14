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
package org.talend.lineage.cloudera.entity;

import java.util.ArrayList;
import java.util.List;

import org.talend.lineage.cloudera.util.GeneratorID;

import com.cloudera.nav.sdk.model.SourceType;
import com.cloudera.nav.sdk.model.annotations.MClass;
import com.cloudera.nav.sdk.model.annotations.MRelation;
import com.cloudera.nav.sdk.model.entities.EndPointProxy;
import com.cloudera.nav.sdk.model.entities.EntityType;
import com.cloudera.nav.sdk.model.relations.RelationRole;

/**
 * Cloudera navigator entity to represent any Talend output component
 * The new Cloudera navigator API (2.0) impose to connect the entity
 * to its source and its target.
 * The source needs to be connected to another entity.
 * The target needs to be connected to the outputEntity itself.
 */
@MClass(model = "talend")
public class TalendOutputEntity extends TalendEntity {

    private List<String>        previousEntitiesId;

    private List<String>        nextEntitiesId;


    @MRelation(role = RelationRole.SOURCE)
    private List<EndPointProxy> sourceProxies;

    @MRelation(role = RelationRole.TARGET)
    private List<EndPointProxy> targetProxies;

    public TalendOutputEntity(String jobId, String componentName) {
        super(jobId, componentName);
        sourceProxies = new ArrayList<EndPointProxy>();
        targetProxies = new ArrayList<EndPointProxy>();

        previousEntitiesId = new ArrayList<String>();
        nextEntitiesId = new ArrayList<String>();
    }

    public void addPreviousEntity(String entityId) {
        this.previousEntitiesId.add(entityId);
        EndPointProxy endpointProxy = new EndPointProxy(entityId, SourceType.SDK, EntityType.OPERATION_EXECUTION);
        this.sourceProxies.add(endpointProxy);
    }

    public void addNextEntity(String entityId) {
        this.nextEntitiesId.add(entityId);
        EndPointProxy endpointProxy = new EndPointProxy(entityId, SourceType.SDK, EntityType.OPERATION_EXECUTION);
        this.targetProxies.add(endpointProxy);
    }

    public List<String> getPreviousEntitiesId() {
        return previousEntitiesId;
    }

    public List<String> getNextEntitiesId() {
        return nextEntitiesId;
    }

    public List<EndPointProxy> getSourceProxies() {
        return sourceProxies;
    }

    public List<EndPointProxy> getTargetProxies() {
        return targetProxies;
    }

    @Override
    public String toString() {
        return this.previousEntitiesId + "---> " + getName() + " (" + getEntityId() + ")";
    }

    /**
     * Connects a parent entity to its input using TARGET -> SOURCE relations
     * Connects the target (next) entity to itself to follow the new Cloudera Navigator API (2.0)
     */
    @Override
    public void connectToEntity(List<String> inputs, List<String> outputs) {
        for (String input : inputs) {
            // generate the id of the component to connect to
            String id = GeneratorID.generateNodeID(this.getJobId(), input);
            this.addPreviousEntity(id);
        }

        // set the output
        this.addNextEntity(this.getEntityId());
    }
}
