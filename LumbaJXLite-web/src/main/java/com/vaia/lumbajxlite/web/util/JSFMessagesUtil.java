/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author awank
 */
public class JSFMessagesUtil {

    public void sendInfoMessageToUser(String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
        addMessageToJsfContext(facesMessage);
    }

    public void sendWarnMessageToUser(String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, message);
        addMessageToJsfContext(facesMessage);
    }

    public void sendErrorMessageToUser(String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, message);
        addMessageToJsfContext(facesMessage);
    }

    private FacesMessage createMessage(Severity severity, String mensagemErro) {
        return new FacesMessage(severity, mensagemErro, mensagemErro);
    }

    private void addMessageToJsfContext(FacesMessage facesMessage) {
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
