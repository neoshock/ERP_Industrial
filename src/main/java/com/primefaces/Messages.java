
package com.primefaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages {
    public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public static void showInfo(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, "Éxito", message);
    }

    public static void showWarn(String message) {
        addMessage(FacesMessage.SEVERITY_WARN, "Advertencia", message);
    }

    public static void showError(String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error", message);
    }
}
