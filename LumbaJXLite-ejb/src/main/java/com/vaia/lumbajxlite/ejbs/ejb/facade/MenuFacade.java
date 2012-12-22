/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.iface.MenuDAO;
import com.vaia.lumbajxlite.ejbs.ejb.AbstractFacade;
import com.vaia.lumbajxlite.ejbs.ejb.local.MenuFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> implements MenuFacadeLocal {

    @PersistenceContext(unitName = "com.vaia_LumbaJXLite-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuFacade.class);
    private MenuDAO menuDAO = dAOFactory.getDAOImpl(MenuDAO.class);

    ;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }

    @Override
    public List<Menu> retrieveUserAccessedMenu(OperatorUser user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Menu> retrieveAllMainMenu() {
        return menuDAO.retrieveAllMainMenu();
    }
}
