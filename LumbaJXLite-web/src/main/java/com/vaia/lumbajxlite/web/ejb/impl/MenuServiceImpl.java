/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.ejb.impl;

import com.vaia.lumbajxlite.ejbs.ejb.local.MenuFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import com.vaia.lumbajxlite.web.ejb.service.MenuServiceImplLocal;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.MenuModel;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
@Stateless
public class MenuServiceImpl implements MenuServiceImplLocal {

    @ManagedProperty(value = "#{msgs}")
    private ResourceBundle i18n;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
    @EJB
    private MenuFacadeLocal menuFacadeLocal;

    @Override
    public MenuModel getUserAccessedMenu(OperatorUser operatorUser) throws SQLException {
        return generateMenuModel(menuFacadeLocal.findRootUserMenu(operatorUser), operatorUser);
    }

    @Override
    public MenuModel getUserAccessedReportMenu(OperatorUser operatorUser) throws SQLException {
        return generateMenuModel(menuFacadeLocal.findRootUserReportMenu(operatorUser), operatorUser);
    }

    private MenuModel generateMenuModel(List<Menu> menus, OperatorUser operatorUser) throws SQLException {
        MenuModel menuModel = new DefaultMenuModel();

        for (Menu menu : menus) {
            Submenu submenu = new Submenu();
            if (("#").equalsIgnoreCase(menu.getLink())) {
                submenu.setLabel(i18n.getString(i18n.getString(menu.getMenuname())));
                submenu.setId("sub" + menu.getMenuid());
                menuModel.addSubmenu(submenu);
            } else {
                MenuItem item = new MenuItem();
                item.setValue(i18n.getString(menu.getMenuname()));
                item.setUrl(menu.getLink());
                item.setId("mn" + menu.getMenuid());
                menuModel.addMenuItem(item);
            }

            List<Menu> subMenus1 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(operatorUser, menu);

            for (Menu sub1 : subMenus1) {
                Submenu submenu1 = new Submenu();
                if (("#").equalsIgnoreCase(sub1.getLink())) {
                    submenu1.setLabel(i18n.getString(menu.getMenuname()));
                    submenu1.setId("sub" + sub1.getMenuid());
                    submenu.getChildren().add(submenu1);
                } else {
                    MenuItem item = new MenuItem();
                    item.setValue(i18n.getString(menu.getMenuname()));
                    item.setUrl(sub1.getLink());
                    item.setId("mn" + sub1.getMenuid());
                    submenu.getChildren().add(item);
                }

                List<Menu> subMenus2 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(operatorUser, menu);

                for (Menu sub2 : subMenus2) {
                    Submenu submenu2 = new Submenu();
                    if (("#").equalsIgnoreCase(sub2.getLink())) {
                        submenu2.setLabel(i18n.getString(menu.getMenuname()));
                        submenu2.setId("sub" + sub2.getMenuid());
                        submenu1.getChildren().add(submenu2);
                    } else {
                        MenuItem item = new MenuItem();
                        item.setValue(i18n.getString(menu.getMenuname()));
                        item.setUrl(sub2.getLink());
                        item.setId("mn" + sub2.getMenuid());
                        submenu1.getChildren().add(item);
                    }

                    List<Menu> subMenus3 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(operatorUser, menu);

                    for (Menu sub3 : subMenus3) {
                        Submenu submenu3 = new Submenu();
                        if (("#").equalsIgnoreCase(sub3.getLink())) {
                            submenu3.setLabel(i18n.getString(menu.getMenuname()));
                            submenu3.setId("sub" + sub3.getMenuid());
                            submenu2.getChildren().add(submenu3);
                        } else {
                            MenuItem item = new MenuItem();
                            item.setValue(i18n.getString(menu.getMenuname()));
                            item.setUrl(sub3.getLink());
                            item.setId("mn" + sub3.getMenuid());
                            submenu2.getChildren().add(item);
                        }

                        List<Menu> subMenus4 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(operatorUser, menu);

                        for (Menu sub4 : subMenus4) {
                            Submenu submenu4 = new Submenu();
                            if (("#").equalsIgnoreCase(sub4.getLink())) {
                                submenu4.setLabel(i18n.getString(menu.getMenuname()));
                                submenu4.setId("sub" + sub4.getMenuid());
                                submenu3.getChildren().add(submenu4);
                            } else {
                                MenuItem item = new MenuItem();
                                item.setValue(i18n.getString(menu.getMenuname()));
                                item.setUrl(sub4.getLink());
                                item.setId("mn" + sub4.getMenuid());
                                submenu3.getChildren().add(item);
                            }
                        }
                    }
                }
            }
        }

        return menuModel;
    }
}
