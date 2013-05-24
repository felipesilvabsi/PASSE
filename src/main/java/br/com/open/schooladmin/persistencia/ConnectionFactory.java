/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Felipe Silva
 */
public class ConnectionFactory {

    private static final String CONF_ARQUIVO = "/br/com/open/schooladmin/persistencia/SchoolAdmin";
    private static final String CONF_JDBC_DRIVER = "jdbc_driver";
    private static final String CONF_JDBC_USER = "jdbc_user";
    private static final String CONF_JDBC_PASSWORD = "jdbc_password";
    private static final String CONF_JDBC_URL = "jdbc_url";

    public static Connection getConnection() throws DaoException {

        try {
            
            //String driver = java.util.ResourceBundle.getBundle(CONF_ARQUIVO).getString(CONF_JDBC_DRIVER);
            //String url = java.util.ResourceBundle.getBundle(CONF_ARQUIVO).getString(CONF_JDBC_URL);
            //String user = java.util.ResourceBundle.getBundle(CONF_ARQUIVO).getString(CONF_JDBC_USER);
            //String password = java.util.ResourceBundle.getBundle(CONF_ARQUIVO).getString(CONF_JDBC_PASSWORD);

            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/schooladmin", "postgres", "admin");

        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }

    }

    public static void closeConnection(Connection conn) throws DaoException {
        close(conn, null, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement st) throws DaoException {
        close(conn, st, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement st, ResultSet rs) throws DaoException {
        close(conn, st, rs);
    }

    private static void close(Connection conn, PreparedStatement st, ResultSet rs) throws DaoException {
        try {

            if (rs != null) {
                rs.close();
            }

            if (st != null) {
                st.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

}
