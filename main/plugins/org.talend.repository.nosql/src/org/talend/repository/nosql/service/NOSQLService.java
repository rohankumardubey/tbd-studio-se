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
package org.talend.repository.nosql.service;

import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.service.INOSQLService;
import org.talend.repository.model.nosql.NoSQLConnection;
import org.talend.repository.nosql.db.common.mongodb.IMongoDBAttributes;
import org.talend.repository.nosql.ui.node.NoSQLRepositoryNodeType;
import org.talend.utils.security.PasswordMigrationUtil;

/**
 * created by hwang on Apr 15, 2015 Detailled comment
 *
 */
public class NOSQLService implements INOSQLService {

    /*
     * (non-Javadoc)
     *
     * @see org.talend.core.service.INOSQLService#getNOSQLRepositoryType()
     */
    @Override
    public ERepositoryObjectType getNOSQLRepositoryType() {
        return NoSQLRepositoryNodeType.METADATA_NOSQL_CONNECTIONS;
    }

    @Override
    public boolean isNoSQLConnection(Connection connection) {
        if (connection != null) {
            return connection instanceof NoSQLConnection;
        }
        return false;
    }

    @Override
    public boolean isUseReplicaSet(Connection connection) {
        if (isNoSQLConnection(connection)) {
            String isUseReplicaSet = ((NoSQLConnection) connection).getAttributes().get(IMongoDBAttributes.USE_REPLICA_SET);
            return Boolean.valueOf(isUseReplicaSet);
        }
        return false;
    }

    @Override
    public String getMongoDBReplicaSets(Connection connection) {
        if (isNoSQLConnection(connection)) {
            return ((NoSQLConnection) connection).getAttributes().get(IMongoDBAttributes.REPLICA_SET);
        }
        return null;
    }

    @Override
    public boolean updateNoSqlConnection(Connection connection) throws Exception{
        if (isNoSQLConnection(connection)) {
            NoSQLConnection noSqlConn = (NoSQLConnection)connection;
            String pass = noSqlConn.getAttributes().get(IMongoDBAttributes.PASSWORD);
            if(pass != null) {
                pass = PasswordMigrationUtil.encryptPasswordIfNeeded(pass);
                noSqlConn.getAttributes().put(IMongoDBAttributes.PASSWORD, noSqlConn.getValue(pass, true));
                return true; 
            }
        }
        return false;
    }

    @Override
    public boolean isUseSSL(Connection connection) {
        if (isNoSQLConnection(connection)) {
            String isUseSSL = ((NoSQLConnection) connection).getAttributes().get(IMongoDBAttributes.REQUIRED_ENCRYPTION);
            return Boolean.valueOf(isUseSSL);
        }
        return false;
    }

}
