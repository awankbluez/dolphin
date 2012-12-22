/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao.impl;

import static com.vaia.lumbajxlite.ejbs.dao.DAOUtil.*;
import com.vaia.lumbajxlite.ejbs.dao.iface.MenuDAO;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
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

    private DAOFactory dAOFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuDAOImpl.class);
    private static final String SQL_RETRIEVE_ALL_MAIN_MENU = "SELECT * FROM menu WHERE menutype = 'MM' and menustatus = true";

    public MenuDAOImpl(DAOFactory dAOFactory) {
        this.dAOFactory = dAOFactory;
    }

    @Override
    public List<Menu> retrieveAllMainMenu() {
        List<Menu> menus = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OperatorUser user = null;

        try {
            connection = dAOFactory.getConnection();
            preparedStatement = prepareStatement(connection, SQL_RETRIEVE_ALL_MAIN_MENU);

            LOGGER.debug(preparedStatement.toString());

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Menu menu;
                menu = map(resultSet);

                menus.add(menu);
            }
        } catch (SQLException e) {
            LOGGER.error(e.toString());
        } finally {
            close(connection, preparedStatement, resultSet);
        }

        return menus;
    }

    private Menu map(ResultSet rs) throws SQLException {
        Menu menu = new Menu();

        menu.setMenuid(rs.getInt("menuid"));
        menu.setMenuname(rs.getString("menuname"));
        menu.setAlias(rs.getString("alias"));
        menu.setLink(rs.getString("link"));
        menu.setLevel(rs.getInt("level"));
        menu.setOrdering(rs.getInt("ordering"));
        menu.setParentid(rs.getInt("parentid"));

        return menu;
    }

    @Override
    public void setDAOFactory(DAOFactory dAOFactory) {
        this.dAOFactory = dAOFactory;
    }
}