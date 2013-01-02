/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.managedBeans.applicationBean;

import com.vaia.lumbajxlite.ejb.impl.MenuService;
import com.vaia.lumbajxlite.ejb.local.MenuServiceLocal;
import com.vaia.lumbajxlite.ejbs.ejb.local.OperatorUserFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import com.vaia.lumbajxlite.web.managedBeans.AbstractManagedBean;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.MenuModel;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author MBS Development Team
 */
@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSessionMB extends AbstractManagedBean implements Serializable {

    @EJB
    private OperatorUserFacadeLocal operatorUserService;
    @EJB
    private MenuServiceLocal menuService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSessionMB.class);
    private OperatorUser user;
    private OperatorUser authenticatedUser;
    private MenuModel userMainMenuModel;
    private MenuModel userReportMenuModel;
    private TreeNode userMainMenu;
    private TreeNode userReportMenu;
    private List<Menu> userAccessedMenu;

    public UserSessionMB() {
    }

    @PostConstruct
    private void initialize() {
        user = new OperatorUser();
        menuService = new MenuService();
    }

    public void userLogin() throws SQLException {
        if (!user.getUsername().isEmpty() && !user.getPassword().isEmpty()) {
            authenticatedUser = operatorUserService.checkUser(user);
        } else {
            displayErrorMessageToUser("User Name and Password cannot be empty.");
        }

        if (authenticatedUser != null) {
            if (authenticatedUser.getUserstatus()) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

                session.setAttribute("userId", authenticatedUser.getUserid().toString());

                LOGGER.info("User {} successfully logged in.", authenticatedUser.getEmployeename());

                // retrieve user access
                retrieveUserAccess();

                doRedirect("/index.xhtml");
            } else {

                LOGGER.info("User {} not activated", authenticatedUser.getUsername());
                displayWarnMessageToUser("User is inactive.");
            }
        } else {

            LOGGER.info("User {} is not registered.", user.getUsername());
            displayErrorMessageToUser("User not registered.");
        }
    }

    public String userLogout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        session.removeAttribute("userId");
        session.invalidate();

        LOGGER.info("User {} logged out.", authenticatedUser.getEmployeename());

        authenticatedUser = null;

        return "/login.xhtml";
    }

    private boolean isUserLoggedIn() {
        return (authenticatedUser != null);
    }

    public void varifyUserLoggedIn() {
    }

    private void doRedirect(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + url);
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }

    private void retrieveUserAccess() throws SQLException {
        userMainMenuModel = menuService.getUserAccessedMenu(authenticatedUser);
        userReportMenuModel = menuService.getUserAccessedReportMenu(authenticatedUser);
    }

    /**
     * getter setter
     */
    public OperatorUser getUser() {
        return user;
    }

    public void setUser(OperatorUser user) {
        this.user = user;
    }

    public OperatorUser getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(OperatorUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public OperatorUserFacadeLocal getOperatorUserService() {
        return operatorUserService;
    }

    public void setOperatorUserService(OperatorUserFacadeLocal operatorUserService) {
        this.operatorUserService = operatorUserService;
    }

    public TreeNode getUserMainMenu() {
        return userMainMenu;
    }

    public TreeNode getUserReportMenu() {
        return userReportMenu;
    }
}
