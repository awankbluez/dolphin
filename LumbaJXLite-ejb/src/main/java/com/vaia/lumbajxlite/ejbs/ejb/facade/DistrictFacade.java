/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.ejb.local.DistrictFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.District;
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
public class DistrictFacade extends AbstractFacade<District> implements DistrictFacadeLocal {

    @PersistenceContext(unitName = "LumbaJXLite-ejb.v1.PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DistrictFacade() {
        super(District.class);
    }

    @Override
    public List<District> retrieveAllByProvince(Province province) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("provinceid", province);

        Query query = em.createNamedQuery(District.SQL_FIND_BY_PROVINCE);
        populateParameter(query, parameters);
        return query.getResultList();
    }
}
