/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.managedBeans.applicationBean;

import com.vaia.lumbajxlite.web.managedBeans.AbstractManagedBean;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MBS Development Team
 */
@ManagedBean(name="userInfoBean")
@SessionScoped
public class UserInfoMB extends AbstractManagedBean {

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        switch (language) {
            case "en_US":
                locale = new Locale("en", "US");
                break;
            case "in_ID":
                locale = new Locale("in", "ID");
                break;
        }
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
