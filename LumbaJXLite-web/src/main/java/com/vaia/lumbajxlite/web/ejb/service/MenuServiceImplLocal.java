/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.ejb.service;

import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import java.sql.SQLException;
import javax.ejb.Local;
import org.primefaces.model.MenuModel;
import org.primefaces.model.TreeNode;

/**
 *
 * @author MBS Development Team
 */
@Local
public interface MenuServiceImplLocal {

//    TreeNode getUserAccessedMenu(OperatorUser operatorUser);
//    TreeNode getUserAccessedReportMenu(OperatorUser operatorUser);
    MenuModel getUserAccessedMenu(OperatorUser operatorUser) throws SQLException;

    MenuModel getUserAccessedReportMenu(OperatorUser operatorUser) throws SQLException;
}
