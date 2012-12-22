/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao.iface;

import com.vaia.lumbajxlite.ejbs.dao.BaseDAO;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import java.util.List;

/**
 *
 * @author MBS Development Team
 */
public interface MenuDAO extends BaseDAO{

    List<Menu> retrieveAllMainMenu();

}
