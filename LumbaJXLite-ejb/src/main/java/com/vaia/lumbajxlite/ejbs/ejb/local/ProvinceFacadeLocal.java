/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Country;
import com.vaia.lumbajxlite.ejbs.entity.Province;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MBS Development Team
 */
@Local
public interface ProvinceFacadeLocal {

    void create(Province province);

    void edit(Province province);

    void remove(Province province);

    Province find(Object id);

    List<Province> findAll();

    List<Province> findRange(int[] range);

    int count();

    List<Province> retrieveAllByCountry(Country country);
}
