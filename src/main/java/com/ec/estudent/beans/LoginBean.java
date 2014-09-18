/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.beans;

import com.ec.estudent.dao.UserDAO;
import com.ec.estudent.dao.Database;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 import java.util.UUID;
@ManagedBean(name = "loginBean")
@SessionScoped
/**
 *
 * @author User
 */
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String password;
    private String message, uname;
 
    public String getMessage() {
        return message;
    }
    
     public String getRandomId() {
        return "r" + UUID.randomUUID().toString().substring(0, 6);
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
    
    public String getUserGUID() {
        HttpSession session = Util.getSession();
        return session.getAttribute("userGUID").toString();
    }

        public String getImePrezime() {
        HttpSession session = Util.getSession();
        String r;
       // r="<b>";
        r=session.getAttribute("ImePrezime").toString();
        //r=r+"</b>";
        return r;
    }
        
        
                public String getNaziv() {
        HttpSession session = Util.getSession();
        String r;
       // r="<b>";
        r=session.getAttribute("Naziv").toString();
        //r=r+"</b>";
        return r;
    }
    
    
    
    public String getIndexID() {
        HttpSession session = Util.getSession();
        return session.getAttribute("IndexID").toString();
    }
 
    public String getUserTHEME() {
 
      HttpSession session = Util.getSession();
//       
       String txh;
////       
      txh = (String) session.getAttribute("userTHEME");
//
               System.out.println(Database.getDatabaseurl());       
      if (txh != null)
      {
          return txh;
      } else {
         return "redmond";
        }
                   
    }             

//       
//      if (th == null)
               //{

//               }
//       
////       FacesContext.getCurrentInstance().addMessage(
////                    null,
////                    new FacesMessage(FacesMessage.SEVERITY_WARN,
////                    th,
////                    "Molimo Vas pokušajte ponovo!"));
//       System.out.println(th);
//       if ( th != "aristo" )
//       {
////         return "redmond";
//        return session.getAttribute("userTHEME").toString();
//         }
//        else
//        {
//            return "aristo";
//        }
                
//    }
//    public void setUserGUID(String userGUID) {
//        this.userGUID = userGUID;
//    }
    
     public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "login?faces-redirect=true";
   }
     
    public String loginProject() {
        int result = UserDAO.login(uname, password);
        if (result > 0) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
            session.setAttribute("izabranpredmet", "0");
         //   session.setAttribute("userGUID", result);
 if (result==1)  // student
 {
      return "dashboard?faces-redirect=true";
 }
 
 if (result==2)
 {
      return "profesor?faces-redirect=true";
 }
 
  if (result>2)
 {
      return "login";
 }
            
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Pogrešna prijava!",
                    "Molimo Vas pokušajte ponovo!"));
                        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Pogrešna prijava!",
                    "Molimo Vas pokušajte ponovo!"));
                                    FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Pogrešna prijava!",
                    "Molimo Vas pokušajte ponovo!"));
                                    FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Pogrešna prijava!",
                    "Molimo Vas pokušajte ponovo!"));
                                                                       
                                    
                                    
                                    
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "login";
        }
         return "login";
    }
 

}