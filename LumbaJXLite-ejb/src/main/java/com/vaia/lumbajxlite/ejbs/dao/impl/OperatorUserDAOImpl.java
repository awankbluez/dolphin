/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao.impl;

import static com.vaia.lumbajxlite.ejbs.dao.DAOUtil.*;
import static com.vaia.lumbajxlite.ejbs.util.Encrypt.*;
import com.vaia.lumbajxlite.ejbs.dao.iface.OperatorUserDAO;
import com.vaia.lumbajxlite.ejbs.entity.Masteroperational;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
public class OperatorUserDAOImpl implements OperatorUserDAO {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorUserDAOImpl.class);
    private Connection connection;
    private static final String SQL_CHECK_LOGIN = "SELECT * FROM operatoruser WHERE username = ? AND password = ? AND userstatus = true";
    private static final String SQL_RETRIEVE_ALL_ACTIVE = "SELECT * FROM operatoruser WHERE userstatus = true";

    public OperatorUserDAOImpl() {
    }

    @Override
    public List<OperatorUser> retrieveAllUser() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<OperatorUser> users = new ArrayList<>();

        try {
            preparedStatement = prepareStatement(connection, SQL_RETRIEVE_ALL_ACTIVE);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }

        return users;
    }

    @Override
    public OperatorUser checkLogin(OperatorUser loggingInUser) {
        Object[] parameters = {
            loggingInUser.getUsername(),
            getMD5(loggingInUser.getPassword())
        };

        return find(SQL_CHECK_LOGIN, parameters);
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private OperatorUser find(String SQL, Object... values) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OperatorUser operatorUser = null;

        try {
            preparedStatement = prepareStatement(connection, SQL, false, values);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                operatorUser = map(resultSet);
            }

        } catch (SQLException e) {
            LOGGER.error(e.toString());
        } finally {
            close(preparedStatement, resultSet);
        }

        return operatorUser;

    }

    private static OperatorUser map(ResultSet resultSet) throws SQLException {
        OperatorUser user = new OperatorUser();
        user.setUserid(resultSet.getInt("userid"));
        user.setEmail(resultSet.getString("email"));
        user.setEmployeename(resultSet.getString("employeename"));
        user.setEmployeeid(resultSet.getString("employeeid"));
        user.setUserstatus(resultSet.getBoolean("userstatus"));

        Masteroperational masteroperational = new Masteroperational();
        masteroperational.setMasteroperationalid(resultSet.getInt("masteroperationalid"));

        user.setMasteroperationalid(masteroperational);
        return user;
    }
}
