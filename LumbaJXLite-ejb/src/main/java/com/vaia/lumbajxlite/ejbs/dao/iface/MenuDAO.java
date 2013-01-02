/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao.iface;

import com.vaia.lumbajxlite.ejbs.dao.BaseDAO;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MBS Development Team
 */
public interface MenuDAO extends BaseDAO {

    Menu findParentMenuBySubMenuId(Integer subMenuId) throws SQLException;

    List<Menu> findRootUserMenu(OperatorUser operatorUser) throws SQLException;

    List<Menu> findRootUserReportMenu(OperatorUser operatorUser) throws SQLException;

    List<Menu> retrieveUserSubMenuByParentMenuId(OperatorUser operatorUser, Menu parentMenu) throws SQLException;

    List<Menu> retrieveUserReportSubMenuByParentMenuId(OperatorUser operatorUser, Menu parentMenu) throws SQLException;
}
