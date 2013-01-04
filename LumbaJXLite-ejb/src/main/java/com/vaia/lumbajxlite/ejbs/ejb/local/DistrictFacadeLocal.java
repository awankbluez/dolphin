/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.District;
import com.vaia.lumbajxlite.ejbs.entity.Province;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MBS Development Team
 */
@Local
public interface DistrictFacadeLocal {

    void create(District district);

    void edit(District district);

    void remove(District district);

    District find(Object id);

    List<District> findAll();

    List<District> findRange(int[] range);

    int count();

    List<District> retrieveAllByProvince(Province province);
}
