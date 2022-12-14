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
package org.talend.repository.model.nosql.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.talend.core.model.metadata.builder.connection.AbstractMetadataObject;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.Item;
import org.talend.repository.model.nosql.*;
import org.talend.repository.model.nosql.NoSQLConnection;
import org.talend.repository.model.nosql.NoSQLConnectionItem;
import org.talend.repository.model.nosql.NosqlPackage;
import orgomg.cwm.foundation.softwaredeployment.DataManager;
import orgomg.cwm.foundation.softwaredeployment.DataProvider;
import orgomg.cwm.foundation.softwaredeployment.DeployedComponent;
import orgomg.cwm.objectmodel.core.Element;
import orgomg.cwm.objectmodel.core.ModelElement;
import orgomg.cwm.objectmodel.core.Namespace;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.talend.repository.model.nosql.NosqlPackage
 * @generated
 */
public class NosqlAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static NosqlPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NosqlAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = NosqlPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This
     * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
     * the model. <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected NosqlSwitch<Adapter> modelSwitch = new NosqlSwitch<Adapter>() {
            @Override
            public Adapter caseNoSQLConnection(NoSQLConnection object) {
                return createNoSQLConnectionAdapter();
            }
            @Override
            public Adapter caseNoSQLConnectionItem(NoSQLConnectionItem object) {
                return createNoSQLConnectionItemAdapter();
            }
            @Override
            public Adapter caseNoSQLAttributes(Map.Entry<String, String> object) {
                return createNoSQLAttributesAdapter();
            }
            @Override
            public Adapter caseElement(Element object) {
                return createElementAdapter();
            }
            @Override
            public Adapter caseModelElement(ModelElement object) {
                return createModelElementAdapter();
            }
            @Override
            public Adapter caseAbstractMetadataObject(AbstractMetadataObject object) {
                return createAbstractMetadataObjectAdapter();
            }
            @Override
            public Adapter caseNamespace(Namespace object) {
                return createNamespaceAdapter();
            }
            @Override
            public Adapter casePackage(orgomg.cwm.objectmodel.core.Package object) {
                return createPackageAdapter();
            }
            @Override
            public Adapter caseDeployedComponent(DeployedComponent object) {
                return createDeployedComponentAdapter();
            }
            @Override
            public Adapter caseDataManager(DataManager object) {
                return createDataManagerAdapter();
            }
            @Override
            public Adapter caseDataProvider(DataProvider object) {
                return createDataProviderAdapter();
            }
            @Override
            public Adapter caseConnection(Connection object) {
                return createConnectionAdapter();
            }
            @Override
            public Adapter caseItem(Item object) {
                return createItemAdapter();
            }
            @Override
            public Adapter caseConnectionItem(ConnectionItem object) {
                return createConnectionItemAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.repository.model.nosql.NoSQLConnection <em>No SQL Connection</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can
     * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * @return the new adapter.
     * @see org.talend.repository.model.nosql.NoSQLConnection
     * @generated
     */
    public Adapter createNoSQLConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.repository.model.nosql.NoSQLConnectionItem <em>No SQL Connection Item</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * @return the new adapter.
     * @see org.talend.repository.model.nosql.NoSQLConnectionItem
     * @generated
     */
    public Adapter createNoSQLConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>No SQL Attributes</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
    public Adapter createNoSQLAttributesAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link orgomg.cwm.objectmodel.core.Element <em>Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see orgomg.cwm.objectmodel.core.Element
     * @generated
     */
    public Adapter createElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link orgomg.cwm.objectmodel.core.ModelElement
     * <em>Model Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see orgomg.cwm.objectmodel.core.ModelElement
     * @generated
     */
    public Adapter createModelElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.metadata.builder.connection.AbstractMetadataObject <em>Abstract Metadata Object</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.metadata.builder.connection.AbstractMetadataObject
     * @generated
     */
    public Adapter createAbstractMetadataObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link orgomg.cwm.objectmodel.core.Namespace <em>Namespace</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see orgomg.cwm.objectmodel.core.Namespace
     * @generated
     */
    public Adapter createNamespaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link orgomg.cwm.objectmodel.core.Package <em>Package</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see orgomg.cwm.objectmodel.core.Package
     * @generated
     */
    public Adapter createPackageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link orgomg.cwm.foundation.softwaredeployment.DeployedComponent <em>Deployed Component</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can
     * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * @return the new adapter.
     * @see orgomg.cwm.foundation.softwaredeployment.DeployedComponent
     * @generated
     */
    public Adapter createDeployedComponentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link orgomg.cwm.foundation.softwaredeployment.DataManager
     * <em>Data Manager</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see orgomg.cwm.foundation.softwaredeployment.DataManager
     * @generated
     */
    public Adapter createDataManagerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link orgomg.cwm.foundation.softwaredeployment.DataProvider
     * <em>Data Provider</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see orgomg.cwm.foundation.softwaredeployment.DataProvider
     * @generated
     */
    public Adapter createDataProviderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.metadata.builder.connection.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.metadata.builder.connection.Connection
     * @generated
     */
    public Adapter createConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Item <em>Item</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.talend.core.model.properties.Item
     * @generated
     */
    public Adapter createItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ConnectionItem <em>Connection Item</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can
     * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ConnectionItem
     * @generated
     */
    public Adapter createConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc --> This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // NosqlAdapterFactory
