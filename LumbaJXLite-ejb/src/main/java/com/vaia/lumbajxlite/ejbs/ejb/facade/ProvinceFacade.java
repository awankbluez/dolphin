/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.ejb.local.ProvinceFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Country;
import com.vaia.lumbajxlite.ejbs.entity.Province;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MBS Development Team
 */
@Stateless
public class ProvinceFacade extends AbstractFacade<Province> implements ProvinceFacadeLocal {

    @PersistenceContext(unitName = "LumbaJXLite-ejb.v1.PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinceFacade() {
        super(Province.class);
    }

    @Override
    public List<Province> retrieveAllByCountry(Country country) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("countryid", country);

        Query query = em.createNamedQuery(Province.SQL_FIND_BY_COUNTRY);
        populateParameter(query, parameters);
        return query.getResultList();
    }
}
