/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Country;
import com.vaia.lumbajxlite.ejbs.entity.District;
import com.vaia.lumbajxlite.ejbs.entity.Province;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MBS Development Team
 */
@Local
public interface CountryFacadeLocal {

    List<Country> retrievAllCountry();

    List<Country> findAll();
}
