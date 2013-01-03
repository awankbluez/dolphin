/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.ejb.impl;

import com.vaia.lumbajxlite.ejbs.ejb.local.MenuFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import com.vaia.lumbajxlite.web.ejb.local.MenuServiceLocal;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
@Stateless
public class MenuService implements MenuServiceLocal {

    @EJB
    private MenuFacadeLocal menuFacadeLocal;
    @ManagedProperty("#{msgs}")
    private ResourceBundle i18n;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuService.class);

    public MenuService() {
    }

    @Override
    public MenuModel getUserAccessedMenu(Operatoruser Operatoruser) throws SQLException {
        List<Menu> userRootMenus = menuFacadeLocal.findRootUserMenu(Operatoruser);
        MenuModel userRootMenuModel = generateMenuModel(userRootMenus, Operatoruser);
        return userRootMenuModel;
    }

    @Override
    public MenuModel getUserAccessedReportMenu(Operatoruser Operatoruser) throws SQLException {
        List<Menu> userRootReportMenus = menuFacadeLocal.findRootUserReportMenu(Operatoruser);
        MenuModel userRootMenuModel = generateMenuModel(userRootReportMenus, Operatoruser);
        return userRootMenuModel;
    }

    private MenuModel generateMenuModel(List<Menu> menus, Operatoruser Operatoruser) throws SQLException {
        MenuModel menuModel = new DefaultMenuModel();

        if (!menus.isEmpty() || menus != null) {
            for (Menu menu : menus) {
                Submenu submenu = new Submenu();
                if (("#").equalsIgnoreCase(menu.getLink())) {
                    submenu.setLabel(menu.getMenuname());
                    submenu.setId("sub" + menu.getMenuid());
                    menuModel.addSubmenu(submenu);
                } else {
                    MenuItem item = new MenuItem();
                    item.setValue(menu.getMenuname());
                    item.setUrl(menu.getLink());
                    item.setId("mn" + menu.getMenuid());
                    menuModel.addMenuItem(item);
                }

                List<Menu> subMenus1 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(Operatoruser, menu);

                for (Menu sub1 : subMenus1) {
                    Submenu submenu1 = new Submenu();
                    if (("#").equalsIgnoreCase(sub1.getLink())) {
                        submenu1.setLabel(sub1.getMenuname());
                        submenu1.setId("sub" + sub1.getMenuid());
                        submenu.getChildren().add(submenu1);
                    } else {
                        MenuItem item = new MenuItem();
                        item.setValue(sub1.getMenuname());
                        item.setUrl(sub1.getLink());
                        item.setId("mn" + sub1.getMenuid());
                        submenu.getChildren().add(item);
                    }

                    List<Menu> subMenus2 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(Operatoruser, sub1);

                    for (Menu sub2 : subMenus2) {
                        Submenu submenu2 = new Submenu();
                        if (("#").equalsIgnoreCase(sub2.getLink())) {
                            submenu2.setLabel(sub2.getMenuname());
                            submenu2.setId("sub" + sub2.getMenuid());
                            submenu1.getChildren().add(submenu2);
                        } else {
                            MenuItem item = new MenuItem();
                            item.setValue(sub2.getMenuname());
                            item.setUrl(sub2.getLink());
                            item.setId("mn" + sub2.getMenuid());
                            submenu1.getChildren().add(item);
                        }

                        List<Menu> subMenus3 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(Operatoruser, sub2);

                        for (Menu sub3 : subMenus3) {
                            Submenu submenu3 = new Submenu();
                            if (("#").equalsIgnoreCase(sub3.getLink())) {
                                submenu3.setLabel(sub3.getMenuname());
                                submenu3.setId("sub" + sub3.getMenuid());
                                submenu2.getChildren().add(submenu3);
                            } else {
                                MenuItem item = new MenuItem();
                                item.setValue(sub3.getMenuname());
                                item.setUrl(sub3.getLink());
                                item.setId("mn" + sub3.getMenuid());
                                submenu2.getChildren().add(item);
                            }

                            List<Menu> subMenus4 = menuFacadeLocal.retrieveUserSubMenuByParentMenuId(Operatoruser, sub3);

                            for (Menu sub4 : subMenus4) {
                                Submenu submenu4 = new Submenu();
                                if (("#").equalsIgnoreCase(sub4.getLink())) {
                                    submenu4.setLabel(sub4.getMenuname());
                                    submenu4.setId("sub" + sub4.getMenuid());
                                    submenu3.getChildren().add(submenu4);
                                } else {
                                    MenuItem item = new MenuItem();
                                    item.setValue(sub4.getMenuname());
                                    item.setUrl(sub4.getLink());
                                    item.setId("mn" + sub4.getMenuid());
                                    submenu3.getChildren().add(item);
                                }
                            }
                        }
                    }
                }
            }
        }

        return menuModel;
    }
}
