/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.iface.OperatorUserDAO;
import com.vaia.lumbajxlite.ejbs.ejb.AbstractFacade;
import com.vaia.lumbajxlite.ejbs.ejb.local.OperatorUserFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.sql.SQLException;
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
public class OperatorUserFacade extends AbstractFacade<OperatorUser> implements OperatorUserFacadeLocal {

    @PersistenceContext(unitName = "com.vaia_LumbaJXLite-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorUser.class);
    private OperatorUserDAO operatorUserDAO = dAOFactory.getDAOImpl(OperatorUserDAO.class);

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperatorUserFacade() {
        super(OperatorUser.class);
    }

    @Override
    public OperatorUser checkUser(String userName, String password) {
        OperatorUser returnedUser;

        if (!userName.isEmpty() && !password.isEmpty()) {
            returnedUser = operatorUserDAO.findOperatorUser(userName, password);
        } else {
            returnedUser = new OperatorUser();
        }
        return returnedUser;
    }
}
