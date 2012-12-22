/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao.impl;

import static com.vaia.lumbajxlite.ejbs.dao.DAOUtil.*;
import com.vaia.lumbajxlite.ejbs.dao.iface.OperatorUserDAO;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import com.vaia.lumbajxlite.ejbs.util.Encrypt;
import com.vaia.lumbajxlite.ejbs.util.dao.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
public class OperatorUserDAOImpl implements OperatorUserDAO {

    private DAOFactory daoFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorUserDAOImpl.class);
    private static final String SQL_FIND_USER_BY_USERNAME_PASSWORD = "SELECT * FROM operatoruser where username = ?, password = ?";

    public OperatorUserDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public OperatorUser findOperatorUser(String userName, String password) {
        Encrypt encrypt = new Encrypt();
        String hasPassword = encrypt.getMD5(password);
        return find(SQL_FIND_USER_BY_USERNAME_PASSWORD, userName, hasPassword);
    }

    /**
     * Returns the user from the database matching the given SQL query with the
     * given values.
     *
     * @param sql The SQL query to be executed in the database.
     * @param values The PreparedStatement values to be set.
     * @return The user from the database matching the given SQL query with the
     * given values.
     * @throws DAOException If something fails at database level.
     */
    private OperatorUser find(String sql, Object... values) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OperatorUser user = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = prepareStatement(connection, sql, false, values);

            LOGGER.debug(preparedStatement.toString());

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        } finally {
            close(connection, preparedStatement, resultSet);
        }

        return user;
    }

    // method helper -----------------------------------------------------------
    /**
     * Map the current row of the given ResultSet to an OperatorUser.
     *
     * @param resultSet The ResultSet of which the current row is to be mapped
     * to an OperatorUser.
     * @return The mapped OperatorUser from the current row of the given
     * ResultSet.
     * @throws SQLException If something fails at database level.
     */
    private static OperatorUser map(ResultSet resultSet) throws SQLException {
        OperatorUser operatorUser = new OperatorUser();
        operatorUser.setUserid(resultSet.getInt("id"));
        operatorUser.setEmployeename(resultSet.getString("employeename"));
        operatorUser.setUsername(resultSet.getString("username"));
        operatorUser.setEmail(resultSet.getString("email"));
        return operatorUser;
    }

    @Override
    public void setDAOFactory(DAOFactory dAOFactory) {
        this.daoFactory = dAOFactory;
    }
}
