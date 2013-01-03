package com.vaia.lumbajxlite.ejbs.dao.impl;

import com.vaia.lumbajxlite.ejbs.dao.DAOUtil;
import com.vaia.lumbajxlite.ejbs.dao.iface.OperatorUserDAO;
import com.vaia.lumbajxlite.ejbs.entity.Masteroperational;
import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import com.vaia.lumbajxlite.ejbs.util.Encrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorUserDAOImpl
        implements OperatorUserDAO {

    private static final long serialVersionUID = 1L;
     private static final Logger LOGGER = LoggerFactory.getLogger(OperatorUserDAOImpl.class);
    private Connection connection;
    private static final String SQL_CHECK_LOGIN = "SELECT * FROM operatoruser WHERE username = ? AND password = ? AND userstatus = true";
    private static final String SQL_RETRIEVE_ALL_ACTIVE = "SELECT * FROM operatoruser WHERE userstatus = true";

    public List<Operatoruser> retrieveAllUser() {
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         List users = new ArrayList();
        try {
             preparedStatement = DAOUtil.prepareStatement(this.connection, "SELECT * FROM operatoruser WHERE userstatus = true");
             resultSet = preparedStatement.executeQuery();
             while (resultSet.next())  {
                users.add(map(resultSet));
            }
        } catch (SQLException e) {
             LOGGER.error(e.getMessage());
        } finally {
             DAOUtil.close(preparedStatement, resultSet);
        }

         return users;
    }

    public Operatoruser checkLogin(Operatoruser loggingInUser) {
         Object[] parameters = {loggingInUser.getUsername(), Encrypt.getMD5(loggingInUser.getPassword())};

         Operatoruser returnedUser = find("SELECT * FROM operatoruser WHERE username = ? AND password = ? AND userstatus = true", parameters);
         returnedUser.setUsername(loggingInUser.getUsername());

         return find("SELECT * FROM operatoruser WHERE username = ? AND password = ? AND userstatus = true", parameters);
    }

    public void setConnection(Connection connection) {
         this.connection = connection;
    }

    private Operatoruser find(String SQL, Object[] values) {
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         Operatoruser operatorUser = null;
        try {
             preparedStatement = DAOUtil.prepareStatement(this.connection, SQL, false, values);
             resultSet = preparedStatement.executeQuery();
             if (resultSet.next())  {
                operatorUser = map(resultSet);
            }
        } catch (SQLException e) {
             LOGGER.error(e.toString());
        } finally {
             DAOUtil.close(preparedStatement, resultSet);
        }

         return operatorUser;
    }

    private static Operatoruser map(ResultSet resultSet) throws SQLException {
         Operatoruser user = new Operatoruser();
         user.setUserid(Integer.valueOf(resultSet.getInt("userid")));
         user.setEmail(resultSet.getString("email"));
         user.setEmployeename(resultSet.getString("employeename"));
         user.setEmployeeid(resultSet.getString("employeeid"));
        user.setUserstatus(Boolean.valueOf(resultSet.getBoolean("userstatus")));

        Masteroperational masteroperational = new Masteroperational();
        masteroperational.setMasteroperationalid(Integer.valueOf(resultSet.getInt("masteroperationalid")));

        user.setMasteroperationalid(masteroperational);
        return user;
    }
}