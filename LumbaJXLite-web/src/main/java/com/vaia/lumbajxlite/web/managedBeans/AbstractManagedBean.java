/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.managedBeans;

import com.vaia.lumbajxlite.web.util.JSFMessagesUtil;
import java.io.Serializable;
import org.primefaces.context.RequestContext;

/**
 *
 * @author awank
 */
public class AbstractManagedBean implements Serializable {

    public AbstractManagedBean() {
        super();
    }

    protected void displayErrorMessageToUser(String message) {
        JSFMessagesUtil messageUtil = new JSFMessagesUtil();
        messageUtil.sendErrorMessageToUser(message);
    }

    protected void displayInfoMessageToUser(String message) {
        JSFMessagesUtil messageUtil = new JSFMessagesUtil();
        messageUtil.sendInfoMessageToUser(message);
    }

    protected void displayWarnMessageToUser(String message) {
        JSFMessagesUtil messageUtil = new JSFMessagesUtil();
        messageUtil.sendWarnMessageToUser(message);
    }

    protected RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }
}
