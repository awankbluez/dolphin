/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MBS Development Team
 */
@Local
public interface OperatorUserFacadeLocal {

    void create(OperatorUser operatorUser);

    void edit(OperatorUser operatorUser);

    void remove(OperatorUser operatorUser);

    OperatorUser find(Object id);

    List<OperatorUser> findAll();

    List<OperatorUser> findRange(int[] range);

    int count();

    OperatorUser checkUser(OperatorUser operatorUser);
}
