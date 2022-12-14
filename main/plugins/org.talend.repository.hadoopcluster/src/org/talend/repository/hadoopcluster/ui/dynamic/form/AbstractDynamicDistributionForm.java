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
package org.talend.repository.hadoopcluster.ui.dynamic.form;

import java.util.EventListener;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.talend.repository.hadoopcluster.ui.dynamic.DynamicDistributionSetupData;

/**
 * DOC cmeng class global comment. Detailled comment
 */
public abstract class AbstractDynamicDistributionForm extends Composite {

    private ICheckListener checkListener;

    private DynamicDistributionSetupData configData;

    public AbstractDynamicDistributionForm(Composite parent, int style, DynamicDistributionSetupData configData) {
        super(parent, style);
        this.setLayout(new FillLayout());
        this.configData = configData;
    }

    abstract public boolean isComplete();

    abstract public boolean canFinish();

    abstract public boolean canFlipToNextPage();

    public static Point getNewButtonSize(Button btn) {
        return getNewButtonSize(btn, 6);
    }

    public static Point getNewButtonSize(Button btn, int hPadding) {
        Point btnSize = btn.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        btnSize.x += hPadding * 2;
        return btnSize;
    }

    protected Composite createFormContainer(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        FormLayout formLayout = new FormLayout();
        formLayout.marginTop = 10;
        formLayout.marginBottom = 10;
        formLayout.marginLeft = 10;
        formLayout.marginRight = 10;
        container.setLayout(formLayout);
        return container;
    }

    protected int getAlignVertical() {
        return 12;
    }

    protected int getAlignVerticalInner() {
        return 7;
    }

    protected int getAlignHorizon() {
        return 3;
    }

    protected int getHorizonWidth() {
        return 100;
    }

    public boolean performApply() {
        return true;
    }

    public boolean performDefaults() {
        return true;
    }

    public boolean performOk() {
        return true;
    }

    public ICheckListener getCheckListener() {
        return this.checkListener;
    }

    public void setCheckListener(ICheckListener checkListener) {
        this.checkListener = checkListener;
    }

    protected void showMessage(String message, int level) {
        if (StringUtils.isEmpty(message)) {
            // means clean message
            this.checkListener.showMessage(message, level);
        } else {
            String existingMessage = getMessage();
            if (StringUtils.isNotEmpty(existingMessage)) {
                if (!existingMessage.contains(message)) {
                    existingMessage = existingMessage + "\n" + message; //$NON-NLS-1$
                }
            } else {
                existingMessage = message;
            }
            this.checkListener.showMessage(existingMessage, level);
        }
    }

    protected String getMessage() {
        return this.checkListener.getMessage();
    }

    protected void updateButtons() {
        this.checkListener.updateButtons();
    }

    protected void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable) throws Exception {
        this.checkListener.run(fork, cancelable, runnable);
    }

    protected DynamicDistributionSetupData getDynamicDistributionSetupData() {
        return this.configData;
    }

    public static interface ICheckListener extends EventListener {

        public void showMessage(String message, int level);

        public String getMessage();

        public void updateButtons();

        public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable) throws Exception;

    }
}
