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
package org.talend.repository.nosql.db.ui.mongodb;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.repository.nosql.db.util.mongodb.MongoDBConnectionUtil;
import org.talend.repository.nosql.exceptions.NoSQLGeneralException;
import org.talend.repository.nosql.exceptions.NoSQLServerException;
import org.talend.repository.nosql.ui.common.AbstractNoSQLRetrieveSchemaForm;

public class MongoDBRetrieveSchemaForm extends AbstractNoSQLRetrieveSchemaForm {

    public MongoDBRetrieveSchemaForm(Composite parent, ConnectionItem connectionItem, String[] existingNames, boolean creation,
            WizardPage parentWizardPage) {
        super(parent, connectionItem, existingNames, creation, parentWizardPage);
        setupForm();
    }

    @Override
    protected void addFields() {
        addSchemaFields(this);
    }

    @Override
    public void releaseResources() throws NoSQLGeneralException {
        super.releaseResources();
        try {
            MongoDBConnectionUtil.closeConnections();
        } catch (NoSQLServerException e) {
            throw new NoSQLGeneralException(e);
        }
    }

}
