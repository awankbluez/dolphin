/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.dao.iface;

import com.vaia.lumbajxlite.ejbs.dao.BaseDAO;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.util.List;

/**
 *
 * @author MBS Development Team
 */
public interface OperatorUserDAO extends BaseDAO {

    OperatorUser checkLogin(OperatorUser loggingInUser);

    List<OperatorUser> retrieveAllUser();
}
