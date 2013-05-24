/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Felipe Silva
 */
public abstract class AbstractDao<T> implements IDao<T> {

    private boolean ownerTransaction;
    private static Connection connection;

    public AbstractDao(boolean owner) {
        this.ownerTransaction = owner;
    }

    protected void beginTransaction() throws SQLException {
        this.connection.setAutoCommit(false);
    }

    protected void commitTransaction() throws SQLException {
        if (this.ownerTransaction) {
            this.connection.commit();
            this.connection.setAutoCommit(true);
        }

    }

    protected void rollbackTransaction() throws SQLException {
        if (this.ownerTransaction) {
            this.connection.rollback();
        }
    }

    protected Connection getConnection() throws DaoException {

        if (this.connection == null) {
            this.connection = ConnectionFactory.getConnection();
        }

        return this.connection;
    }

    protected PreparedStatement getPreparedStatementByHashMap(Connection con,
           String sql, HashMap<String, Object> map) throws DaoException {

        try {

            String where = " WHERE";

            int count = 0;

            for (String value : map.keySet()) {
                where += String.format(" %s = ?", value);

                if (count < map.size() - 1) {
                    where += " AND ";
                    count++;
                }
            }

            PreparedStatement st = con.prepareStatement(sql + where);

            int index = 1;

            for (Object value : map.values()) {
                st.setObject(index, value);
                index++;
            }

            return st;

        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }


    }

    protected void free(Connection con, PreparedStatement stmt, Statement stm, ResultSet rs) {

        try {
            if (con != null && ownerTransaction) {
                con.close();
                this.connection = null;
            }

            if (stmt != null) {
                stmt.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (rs != null) {
                rs.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
