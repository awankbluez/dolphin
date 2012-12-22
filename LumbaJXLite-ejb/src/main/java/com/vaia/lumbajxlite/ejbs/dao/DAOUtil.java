/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for DAO's. This class contains commonly used DAO logic which is
 * been refactored in single static methods. As far it contains a
 * PreparedStatement values setter and several quiet close methods.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */
public final class DAOUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DAOUtil.class);

    // Constructors -------------------------------------------------------------------------------
    private DAOUtil() {
        // Utility class, hide constructor.
    }

    // Actions ------------------------------------------------------------------------------------
    /**
     * Returns a PreparedStatement of the given connection, set with the given
     * SQL query and the given parameter values.
     *
     * @param connection The Connection to create the PreparedStatement from.
     * @param sql The SQL query to construct the PreparedStatement with.
     * @param returnGeneratedKeys Set whether to return generated keys or not.
     * @param values The parameter values to be set in the created
     * PreparedStatement.
     * @throws SQLException If something fails during creating the
     * PreparedStatement.
     */
    public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys, Object... values) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        setValues(preparedStatement, values);
        return preparedStatement;
    }

    public static PreparedStatement prepareStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

    /**
     * Set the given parameter values in the given PreparedStatement.
     *
     * @param connection The PreparedStatement to set the given parameter values
     * in.
     * @param values The parameter values to be set in the created
     * PreparedStatement.
     * @throws SQLException If something fails during setting the
     * PreparedStatement values.
     */
    public static void setValues(PreparedStatement preparedStatement, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
    }

    /**
     * Converts the given java.util.Date to java.sql.Date.
     *
     * @param date The java.util.Date to be converted to java.sql.Date.
     * @return The converted java.sql.Date.
     */
    public static Date toSqlDate(java.util.Date date) {
        return (date != null) ? new Date(date.getTime()) : null;
    }

    /**
     * Quietly close the Connection. Any errors will be printed to the stderr.
     *
     * @param connection The Connection to be closed quietly.
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Closing Connection failed: " + e.getMessage());
                LOGGER.error(e.toString());
            }
        }
    }

    /**
     * Quietly close the Statement. Any errors will be printed to the stderr.
     *
     * @param statement The Statement to be closed quietly.
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("Closing Statement failed: " + e.getMessage());
                LOGGER.error(e.toString());
            }
        }
    }

    /**
     * Quietly close the ResultSet. Any errors will be printed to the stderr.
     *
     * @param resultSet The ResultSet to be closed quietly.
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("Closing ResultSet failed: " + e.getMessage());
                LOGGER.error(e.toString());
            }
        }
    }

    /**
     * Quietly close the Connection and Statement. Any errors will be printed to
     * the stderr.
     *
     * @param connection The Connection to be closed quietly.
     * @param statement The Statement to be closed quietly.
     */
    public static void close(Connection connection, Statement statement) {
        close(statement);
        close(connection);
    }

    /**
     * Quietly close the Connection, Statement and ResultSet. Any errors will be
     * printed to the stderr.
     *
     * @param connection The Connection to be closed quietly.
     * @param statement The Statement to be closed quietly.
     * @param resultSet The ResultSet to be closed quietly.
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(resultSet);
        close(statement);
        close(connection);
    }
}
