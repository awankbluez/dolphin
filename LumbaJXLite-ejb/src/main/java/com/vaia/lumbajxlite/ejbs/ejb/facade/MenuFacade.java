/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.FactoryDAO;
import com.vaia.lumbajxlite.ejbs.dao.iface.MenuDAO;
import com.vaia.lumbajxlite.ejbs.ejb.AbstractFacade;
import com.vaia.lumbajxlite.ejbs.ejb.local.MenuFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
public class MenuFacade extends AbstractFacade<Menu> implements MenuFacadeLocal {

    @PersistenceContext(unitName = "LumbaJXLite-ejb.v1.PU")
    private EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorUser.class);
    private MenuDAO menuDAO;

    public MenuFacade() {
        super(Menu.class);
    }

    @PostConstruct
    private void initialize() {
        menuDAO = FactoryDAO.getDAOImpl(MenuDAO.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Menu> findRootUserMenu(OperatorUser operatorUser) throws SQLException {
        return menuDAO.findRootUserMenu(operatorUser);
    }

    @Override
    public List<Menu> findRootUserReportMenu(OperatorUser operatorUser) throws SQLException {
        return menuDAO.findRootUserReportMenu(operatorUser);
    }

    @Override
    public List<Menu> retrieveUserSubMenuByParentMenuId(OperatorUser operatorUser, Menu parentMenu) throws SQLException {
        return menuDAO.retrieveUserSubMenuByParentMenuId(operatorUser, parentMenu);
    }

    @Override
    public List<Menu> retrieveUserReportSubMenuByParentMenuId(OperatorUser operatorUser, Menu parentMenu) throws SQLException {
        return menuDAO.retrieveUserReportSubMenuByParentMenuId(operatorUser, parentMenu);
    }
}
