/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.managedBeans.applicationBean;

import com.vaia.lumbajxlite.ejbs.ejb.local.MenuFacadeLocal;
import com.vaia.lumbajxlite.ejbs.ejb.local.OperatorUserFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.OperatorUser;
import com.vaia.lumbajxlite.web.managedBeans.AbstractManagedBean;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
    private MenuFacadeLocal menuFacade;
    @EJB
    private OperatorUserFacadeLocal operatorUserService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSessionMB.class);
    private OperatorUser user;
    private OperatorUser authenticatedUser;
    private List<Menu> userAccessedMenu;

    public UserSessionMB() {
    }

    @PostConstruct
    private void intiialize() {
    }

    public void userLogin() {
        if (!user.getUsername().isEmpty() && !user.getPassword().isEmpty()) {
            authenticatedUser = operatorUserService.checkUser(user.getUsername(), user.getPassword());
        } else {
            displayErrorMessageToUser("User Name and Password cannot be empty.");
        }

        if (authenticatedUser != null) {
            if (authenticatedUser.getUserstatus()) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

                session.setAttribute("userId", authenticatedUser.getUserid().toString());
                session.setAttribute("userName", authenticatedUser.getUsername());

                LOGGER.info("User {} successfully logged in.", authenticatedUser.getEmployeename());

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
        session.removeAttribute("userName");
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

    private void retrieveUserAccess() {
        if (authenticatedUser != null) {
            userAccessedMenu = new ArrayList<>();


        }
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
}
