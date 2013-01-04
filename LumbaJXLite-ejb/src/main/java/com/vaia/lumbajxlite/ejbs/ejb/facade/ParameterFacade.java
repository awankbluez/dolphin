package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.ejb.local.ParameterFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Parameter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ParameterFacade extends AbstractFacade<Parameter>
        implements ParameterFacadeLocal {

    @PersistenceContext(unitName = "LumbaJXLite-ejb.v1.PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public ParameterFacade() {
        super(Parameter.class);
    }

    public List<Parameter> findByCode(String code) {
        Query query = this.em.createNamedQuery(Parameter.SQL_FIND_BY_CODE);
        query.setParameter("parametercode", code);

        return query.getResultList();
    }
}