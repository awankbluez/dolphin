/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MBS Development Team
 */
@Local
public interface MenuFacadeLocal {

    void create(Menu menu);

    void edit(Menu menu);

    void remove(Menu menu);

    Menu find(Object id);

    List<Menu> findAll();

    List<Menu> findRange(int[] range);

    int count();

    List<Menu> retrieveUserAccessedMenu(OperatorUser user);

    List<Menu> retrieveAllMainMenu();
}
