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
package org.talend.repository.hdfs.ui;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.metadata.managment.ui.wizard.AbstractForm;

/**
 * DOC ycbai class global comment. Detailled comment
 */
public class HDFSWizardPage extends WizardPage {

    private ConnectionItem connectionItem;

    private HDFSForm hdfsForm;

    private final String[] existingNames;

    private final boolean isRepositoryObjectEditable;

    public HDFSWizardPage(ConnectionItem connectionItem, boolean isRepositoryObjectEditable, String[] existingNames) {
        super("HDFSWizardPage"); //$NON-NLS-1$
        this.connectionItem = connectionItem;
        this.existingNames = existingNames;
        this.isRepositoryObjectEditable = isRepositoryObjectEditable;
    }

    public void createControl(final Composite parent) {
        hdfsForm = new HDFSForm(parent, connectionItem, existingNames);
        hdfsForm.setReadOnly(!isRepositoryObjectEditable);

        AbstractForm.ICheckListener listener = new AbstractForm.ICheckListener() {

            public void checkPerformed(final AbstractForm source) {
                if (source.isStatusOnError()) {
                    HDFSWizardPage.this.setPageComplete(false);
                    setErrorMessage(source.getStatus());
                } else {
                    HDFSWizardPage.this.setPageComplete(isRepositoryObjectEditable);
                    setErrorMessage(null);
                    setMessage(source.getStatus(), source.getStatusLevel());
                }
            }
        };
        hdfsForm.setListener(listener);
        setControl(hdfsForm);
        if (StringUtils.isNotEmpty(connectionItem.getProperty().getLabel())) {
            hdfsForm.checkFieldsValue();
        }
    }

}
