package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.FactoryDAO;
import com.vaia.lumbajxlite.ejbs.dao.iface.OperatorUserDAO;
import com.vaia.lumbajxlite.ejbs.ejb.AbstractFacade;
import com.vaia.lumbajxlite.ejbs.ejb.local.OperatorUserFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class OperatorUserFacade extends AbstractFacade<Operatoruser>
        implements OperatorUserFacadeLocal {

    @PersistenceContext(unitName = "LumbaJXLite-ejb.v1.PU")
    private EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(Operatoruser.class);
    private OperatorUserDAO operatorUserDAO;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public OperatorUserFacade() {
        super(Operatoruser.class);
    }

    @PostConstruct
    private void initialize() {
        this.operatorUserDAO = ((OperatorUserDAO) FactoryDAO.getDAOImpl(OperatorUserDAO.class));
    }

    public Operatoruser checkUser(Operatoruser loggingInUser) {
        return this.operatorUserDAO.checkLogin(loggingInUser);
    }

    public List<Operatoruser> findAll() {
        return this.operatorUserDAO.retrieveAllUser();
    }
}