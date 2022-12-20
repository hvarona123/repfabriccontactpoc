/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repfabric.poc.contact;

import com.repfabric.poc.multitenancy.core.ThreadLocalStorage;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Henry
 */
public class TenantAwareDatasource extends HikariDataSource {

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = super.getConnection();

        try ( Statement sql = connection.createStatement()) {

            String tenantName = ThreadLocalStorage.getTenantName();
            sql.execute("SET app.current_tenant = '" + tenantName + "'");
        }

        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Connection connection = super.getConnection(username, password);

        try ( Statement sql = connection.createStatement()) {
            sql.execute("SET app.current_tenant = '" + ThreadLocalStorage.getTenantName() + "'");
        }

        return connection;
    }

}
