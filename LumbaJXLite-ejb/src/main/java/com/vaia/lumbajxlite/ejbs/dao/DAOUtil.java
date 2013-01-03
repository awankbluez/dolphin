package com.vaia.lumbajxlite.ejbs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DAOUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DAOUtil.class);

    public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys, Object[] values)
            throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql, returnGeneratedKeys ? 1 : 2);
        setValues(preparedStatement, values);
        LOGGER.debug(preparedStatement.toString());
        return preparedStatement;
    }

    public static PreparedStatement prepareStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

    public static CallableStatement callableStatement(Connection connection, String storeProc, Object[] parameterIn) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(storeProc);
        setValues(callableStatement, parameterIn);
        LOGGER.debug(callableStatement.toString());
        return callableStatement;
    }

    public static CallableStatement callableStatement(Connection connection, String storeProc) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(storeProc);
        return callableStatement;
    }

    public static void setValues(CallableStatement callableStatement, Object[] parametersIn) throws SQLException {
        for (int i = 0; i < parametersIn.length; i++) {
            if (parametersIn[i] == null) {
                callableStatement.setNull(i + 1, 12);
            } else {
                callableStatement.setObject(i + 1, parametersIn[i]);
            }
        }
    }

    public static void setValues(PreparedStatement preparedStatement, Object[] values)
            throws SQLException {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                preparedStatement.setNull(i + 1, 12);
            } else {
                preparedStatement.setObject(i + 1, values[i]);
            }
        }
    }

    public static Date toSqlDate(Date date) {
        return date != null ? new Date(date.getTime()) : null;
    }

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

    public static void close(Connection connection, Statement statement) {
        close(statement);
        close(connection);
    }

    public static void close(Statement statement, ResultSet resultSet) {
        close(statement);
        close(resultSet);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(resultSet);
        close(statement);
        close(connection);
    }
}