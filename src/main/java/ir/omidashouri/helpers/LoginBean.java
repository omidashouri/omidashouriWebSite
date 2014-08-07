/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.omidashouri.helpers;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author omid
 */
@Named
@RequestScoped
public class LoginBean {
  private String username;
  private String password;
  private static Logger log = Logger.getLogger(LogoutBean.class.getName());
  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



  public String login () {
      FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest  request = (HttpServletRequest)  context.getExternalContext().getRequest();
//    String remoteUser = request.getRemoteUser();
//    String remoteUser2 = context.getExternalContext().getRemoteUser();
    try {
      request.login(this.username, this.password);
    } catch (ServletException e) {
      context.addMessage(null, new FacesMessage("Login failed."));
      return "loginerror";
    }
      System.out.println("LogIn Success");
//    return "admins/index";
//      return "/foo.xhtml?faces-redirect=true&param=bar";  <<<<<<<<<example
//      return "success";
      return "mainTemplate?faces-redirect=true";
  }

  public String logout() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    try {
      request.logout();
    } catch (ServletException e) {
      log.log(Level.SEVERE, "Failed to logout user!", e);
      context.addMessage(null, new FacesMessage("Logout failed."));
    }
    return "mainTemplate?faces-redirect=true";
  }
  
//    public void someEventListener(SomeEvent event) { // AjaxBehaviorEvent or ComponentSystemEvent or even just argumentless.
//
//      FacesContext context = FacesContext.getCurrentInstance();
//        NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
//      navigationHandler.handleNavigation(context, null, "success");
//  }
  
  }
