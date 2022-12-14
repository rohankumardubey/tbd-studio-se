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
 * Cloudera navigator entity to represent any Talend input component
 * The new Cloudera navigator API (2.0) impose to connect the entity
 * to its source and its target.
 * The source needs to be connected to the inputEntity itself.
 * The target needs to be connected to another entity.
 *
 */
@MClass(model = "talend")
public class TalendInputEntity extends TalendEntity {

    private List<String>        nextEntitiesId;

    private List<String>        previousEntitiesId;

    @MRelation(role = RelationRole.SOURCE)
    private List<EndPointProxy> sourceProxies;

    @MRelation(role = RelationRole.TARGET)
    private List<EndPointProxy> targetProxies;

    public TalendInputEntity(String jobId, String componentName) {
        super(jobId, componentName);
        targetProxies = new ArrayList<EndPointProxy>();
        sourceProxies = new ArrayList<EndPointProxy>();
        nextEntitiesId = new ArrayList<String>();
        previousEntitiesId = new ArrayList<String>();
    }

    public void addNextEntity(String entityId) {
        this.nextEntitiesId.add(entityId);
        EndPointProxy endpointProxy = new EndPointProxy(entityId, SourceType.SDK, EntityType.OPERATION_EXECUTION);
        this.targetProxies.add(endpointProxy);
    }

    public void addPreviousEntity(String entityId) {
        this.previousEntitiesId.add(entityId);
        EndPointProxy endpointProxy = new EndPointProxy(entityId, SourceType.SDK, EntityType.OPERATION_EXECUTION);
        this.sourceProxies.add(endpointProxy);
    }

    public List<String> getPreviousEntitiesId() {
        return previousEntitiesId;
    }

    public List<String> getNextEntitiesId() {
        return nextEntitiesId;
    }

    public List<EndPointProxy> getTargetProxies() {
        return targetProxies;
    }

    public List<EndPointProxy> getSourceProxies() {
        return sourceProxies;
    }

    @Override
    public String toString() {
        return getName() + " (" + getEntityId() + ")" + " --->" + this.nextEntitiesId;
    }

    /**
     * Connects a parent entity to its output using SOURCE -> TARGET relations
     * Connects the source (previous) entity to itself to follow the new Cloudera Navigator API (2.0)
     */
    @Override
    public void connectToEntity(List<String> inputs, List<String> outputs) {
    	// set the input
    	this.addPreviousEntity(this.getEntityId());

    	for (String output : outputs) {
    		// generate the id of the component to connect to
    		String id = GeneratorID.generateNodeID(this.getJobId(), output);
    		this.addNextEntity(id);
	     }
    }

}
