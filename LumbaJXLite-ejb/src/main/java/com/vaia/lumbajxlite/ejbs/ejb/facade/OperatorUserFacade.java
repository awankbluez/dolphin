/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.iface.OperatorUserDAO;
import com.vaia.lumbajxlite.ejbs.ejb.AbstractFacade;
import com.vaia.lumbajxlite.ejbs.ejb.local.OperatorUserFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import javax.annotation.PostConstruct;
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
    private OperatorUserDAO operatorUserDAO;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperatorUserFacade() {
        super(OperatorUser.class);
    }

    @PostConstruct
    private void initialize() {
        operatorUserDAO = dAOFactory.getDAOImpl(OperatorUserDAO.class);
    }

    @Override
    public OperatorUser checkUser(String userName, String password) {
        return operatorUserDAO.findOperatorUser(userName, password);
    }
}
