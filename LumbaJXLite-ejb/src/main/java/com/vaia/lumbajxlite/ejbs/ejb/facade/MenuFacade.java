package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.FactoryDAO;
import com.vaia.lumbajxlite.ejbs.dao.iface.MenuDAO;
import com.vaia.lumbajxlite.ejbs.ejb.AbstractFacade;
import com.vaia.lumbajxlite.ejbs.ejb.local.MenuFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class MenuFacade extends AbstractFacade<Menu>
        implements MenuFacadeLocal {

    @PersistenceContext(unitName = "LumbaJXLite-ejb.v1.PU")
    private EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(Operatoruser.class);
    private MenuDAO menuDAO;

    public MenuFacade() {
        super(Menu.class);
    }

    @PostConstruct
    private void initialize() {
        this.menuDAO = ((MenuDAO) FactoryDAO.getDAOImpl(MenuDAO.class));
    }

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public List<Menu> findRootUserMenu(Operatoruser operatorUser) throws SQLException {
        List userRootMenu = this.menuDAO.findRootUserMenu(operatorUser);
        return userRootMenu;
    }

    public List<Menu> findRootUserReportMenu(Operatoruser operatorUser) throws SQLException {
        List userRootReportMenu = this.menuDAO.findRootUserReportMenu(operatorUser);
        return userRootReportMenu;
    }

    public List<Menu> retrieveUserSubMenuByParentMenuId(Operatoruser operatorUser, Menu parentMenu) throws SQLException {
        return this.menuDAO.retrieveUserSubMenuByParentMenuId(operatorUser, parentMenu);
    }

    public List<Menu> retrieveUserReportSubMenuByParentMenuId(Operatoruser operatorUser, Menu parentMenu) throws SQLException {
        return this.menuDAO.retrieveUserReportSubMenuByParentMenuId(operatorUser, parentMenu);
    }

    public String retrieveString() {
        return "Test";
    }
}