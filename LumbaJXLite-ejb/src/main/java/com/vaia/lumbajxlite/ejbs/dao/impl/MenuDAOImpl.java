/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao.impl;

import com.vaia.lumbajxlite.ejbs.dao.iface.MenuDAO;
import static com.vaia.lumbajxlite.ejbs.dao.DAOUtil.*;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
public class MenuDAOImpl implements MenuDAO {

    private static final long serialVersionUID = 1L;
    private Connection connection;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuDAOImpl.class);
    private final String SQL_RETRIEVE_SUBMENU_FROM_PARENT_MENU = "SELECT * FROM menu WHERE menutype = 'MM' and parentid = ? ORDER BY ordering;";
    private final String SQL_FIND_ROOT_MAIN_MENU = "SELECT * FROM menu WHERE menuid = 1 AND menutype = 'MM'";
    private final String SQL_FIND_PARENT_MENU_FROM_SUBMENU = "SELECT * FROM menu WHERE menutype = 'MM' and menuid = ?";
    private final String SQL_FIND_USER_ROOT_MAIN_MENU = "SELECT * FROM privilageuser"
            + " INNER JOIN menu ON menu.menuid = privilageuser.menuid "
            + " WHERE menu.level = 0 "
            + " AND privilageuser.userid = ? "
            + " AND menu.menutype = 'MM' "
            + " AND menu.menustatus IS true "
            + " AND menu.menuid != 8 "
            + " ORDER BY ordering";
    private final String SQL_FIND_USER_ROOT_REPORT_MENU = "SELECT * FROM privilageuser"
            + " INNER JOIN menu ON menu.menuid = privilageuser.menuid "
            + " WHERE menu.level = 1 "
            + " AND privilageuser.userid = ? "
            + " AND menu.menutype = 'MM' "
            + " AND menu.menustatus IS true "
            + " AND menu.parentid = 8 "
            + " ORDER BY ordering";
    private final String SQL_FIND_USER_SUB_MAIN_MENU = "SELECT * FROM privilageuser "
            + " INNER JOIN menu on menu.menuid = privilageuser.menuid "
            + " WHERE privilageuser.userid = ? "
            //            + "AND privilageuser.menuid != 8"
            + " AND privilageuser.menuid IN ("
            + " SELECT menu.menuid FROM menu "
            + " WHERE menu.parentid = ?) "
            + " ORDER BY ordering";
    private final String SQL_FIND_USER_SUB_REPORT_MENU = "SELECT * FROM privilageuser "
            + " INNER JOIN menu on menu.menuid = privilageuser.menuid "
            + " WHERE privilageuser.userid = ? "
            + " AND privilageuser.menuid IN ("
            + " SELECT menu.menuid FROM menu "
            + " WHERE menu.parentid = ?) "
            + " ORDER BY ordering";

    @Override
    public Menu findParentMenuBySubMenuId(Integer subMenuId) throws SQLException {
        CallableStatement callStatement = null;
        ResultSet rs = null;
        Menu menu = new Menu();
        try {
            callStatement = connection.prepareCall(SQL_FIND_PARENT_MENU_FROM_SUBMENU);
            callStatement.setInt(1, subMenuId);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(callStatement.toString());
            }

            rs = callStatement.executeQuery();
            while (rs.next()) {

                menu.setMenuid(rs.getInt("menuid"));
                menu.setMenuname(rs.getString("menuname"));
                menu.setParentid(rs.getInt("parentid"));
                menu.setAlias(rs.getString("alias"));
                menu.setLevel(rs.getInt("level"));
                menu.setLink(rs.getString("link"));
                menu.setMenustatus(rs.getBoolean("menustatus"));
                menu.setOrdering(rs.getInt("ordering"));
            }

        } catch (SQLException ex) {
            LOGGER.error(ex.toString());
        } finally {
            close(callStatement, rs);
        }
        return menu;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Menu> findRootUserMenu(OperatorUser operatorUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Menu> menus = new ArrayList<>();
        Object[] parameters = {
            operatorUser.getUserid()
        };

        try {
            preparedStatement = prepareStatement(connection, SQL_FIND_USER_ROOT_MAIN_MENU, false, parameters);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Menu rootUserMenu = new Menu();
                rootUserMenu = map(resultSet);
                menus.add(rootUserMenu);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }

        return menus;
    }

    @Override
    public List<Menu> findRootUserReportMenu(OperatorUser operatorUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Menu> menus = new ArrayList<>();
        Object[] parameters = {
            operatorUser.getUserid()
        };

        try {
            preparedStatement = prepareStatement(connection, SQL_FIND_USER_ROOT_REPORT_MENU, false, parameters);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Menu rootUserMenu = new Menu();
                rootUserMenu = map(resultSet);
                menus.add(rootUserMenu);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }

        return menus;
    }

    @Override
    public List<Menu> retrieveUserSubMenuByParentMenuId(OperatorUser operatorUser, Menu parentMenu) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Menu> userSubMenuList = new ArrayList<>();
        Object[] parameters = {
            operatorUser.getUserid(),
            parentMenu.getMenuid()
        };

        try {
            preparedStatement = prepareStatement(connection, SQL_FIND_USER_SUB_MAIN_MENU, false, parameters);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Menu menu = map(resultSet);
                userSubMenuList.add(menu);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }

        return userSubMenuList;
    }

    @Override
    public List<Menu> retrieveUserReportSubMenuByParentMenuId(OperatorUser operatorUser, Menu parentMenu) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Menu> userSubMenuList = new ArrayList<>();
        Object[] parameters = {
            operatorUser.getUserid(),
            parentMenu.getMenuid()
        };

        try {
            preparedStatement = prepareStatement(connection, SQL_FIND_USER_SUB_REPORT_MENU, false, parameters);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Menu menu = map(resultSet);
                userSubMenuList.add(menu);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            close(preparedStatement, resultSet);
        }

        return userSubMenuList;
    }

    private static Menu map(ResultSet resultSet) throws SQLException {
        Menu menu = new Menu();
        menu.setMenuid(resultSet.getInt("menuid"));
        menu.setMenuname(resultSet.getString("menuname"));
        menu.setAlias(resultSet.getString("alias"));
        menu.setLink(resultSet.getString("link"));
        menu.setAction(resultSet.getString("action"));
        menu.setLevel(resultSet.getInt("level"));
        menu.setMenustatus(resultSet.getBoolean("menustatus"));
        menu.setOrdering(resultSet.getInt("ordering"));
        menu.setParentid(resultSet.getInt("parentid"));
        return menu;
    }
}
