/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.beans;
/**
 *
 * @author Bruxx
 */

import com.ec.estudent.classes.Student;
import com.ec.estudent.classes.UpisSemestar;
import com.ec.estudent.classes.Index;
import com.ec.estudent.classes.PredmetSemestar;
import com.ec.estudent.classes.RasporedIspita;
import com.ec.estudent.dao.Database;


import java.io.Serializable;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.TabChangeEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
//import javax.servlet.http.HttpSession;
//import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "studentBean")
@SessionScoped
public class StudentBean implements Serializable {

    List<Index> indexrecords;
    private String currentindexbroj ;
    private int currentindexid =0;
  public int izabranpredmet =0;
    public int studentid =0;

//    private PredmetSemestar selectedPredmet;
//    private List<PredmetSemestar> selectedPredmets;
    
    
   public List<Student> getStudents(String userGUID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + userGUID + "')");     
      List<Student> records;
       records = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            Student student = new Student();
            studentid=rs.getInt("StudentID");
            student.setStudentId(rs.getInt("StudentID"));
            student.setIme(rs.getString("Ime"));
            student.setPrezime(rs.getString("Prezime"));
            student.setImeoca(rs.getString("ImeOca"));
            student.setJmbg(rs.getString("JMBG"));
            student.setAdresa(rs.getString("AdresaStanovanja"));
            student.setGrad(rs.getString("MjestoStanovanjaNaziv"));
            student.setZip(rs.getString("MjestoStanovanjaPostBr"));
//            student.   .setStudentid(rs.getInt(1));
//            student.setName(rs.getString(2));
            records.add(student);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return records;
   }

   
   public List<Index> getIndexs(String userGUID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "select ID as IndexID, Broj, StudentID, StudijskiProgramSifra, StudijskiProgramNaziv, Datum, FakultetNaziv, BrojIndeksa from dbo.vIndeks ";
      stm = stm.concat(" where StudentID = dbo.fvratiStudentID('" + userGUID + "') ORDER BY IndexID");     

       indexrecords = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            if (currentindexid == 0)
            {
              currentindexid = rs.getInt("IndexID");
            }
            Index index = new Index();
            index.setStudentId(rs.getInt("StudentID"));
            index.setIndexid(rs.getInt("IndexID"));
            index.setBrojindeksa(rs.getString("BrojIndeksa"));
            index.setFaklutetnaziv(rs.getString("FakultetNaziv"));
            index.setStudijskiprogramnaziv(rs.getString("StudijskiProgramNaziv"));
            index.setSudijskiprogramsifra(rs.getString("StudijskiProgramSifra"));
            indexrecords.add(index);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return indexrecords;
   }
   
   
    public void onTabChange(TabChangeEvent event) {

    
//       currentindexbroj=indexrecords.get(Integer.valueOf(event.getTab().getId())).getBrojindeksa();
//        currentindexbroj= event.getComponent().
                FacesMessage msg = new FacesMessage("Tab Changed", "Active index: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("Tabchanged -->" +event.getTab().getTitle());
    }
   
    
    
     public void onIndexChange(String indexid) {

    
//       currentindexbroj=indexrecords.get(Integer.valueOf(event.getTab().getId())).getBrojindeksa();
//        currentindexbroj= event.getComponent().
//         currentindexid = indexid.;
                HttpSession session = Util.getSession();
                session.setAttribute("IndexID", indexid);
                FacesMessage msg = new FacesMessage("Index Changed", indexid);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("inmdchanged -->" + indexid);
     }
     
          public void onChange() {

    
//       currentindexbroj=indexrecords.get(Integer.valueOf(event.getTab().getId())).getBrojindeksa();
//        currentindexbroj= event.getComponent().
                FacesMessage msg = new FacesMessage("Tab Changed","dssds");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("Tabchanged -->");
     }
    
    
     
                 public void getFinKarticeFora ()
                  {
                 System.out.println("Tabchanged -->");      
                  }
                    
                  public String getFinKartice ()
                  {
                      String str;
                      str = Database.getJasperurl();
                      str = str.concat("flow.html?_flowId=viewReportFlow&standAlone=true&_flowId=viewReportFlow&ParentFolderUri=%2FUnisyss&reportUnit=%2FUnisyss%2Ffinansijskakartica&output=pdf&j_username=fisko&j_password=fisko&ParID=");
                      str= str.concat(Integer.toString(studentid));        
                      return str;
                  }
                     
          
          
          
      public String getCurrentindexbroj() {
        return currentindexbroj;
    }
    public void setCurrentindexbroj(String currentindexbroj) {
        this.currentindexbroj = currentindexbroj;
    }
     
        public int getCurrentindexid() {
        return currentindexid;
    }
    public void setCurrentindexbroj(int currentindexid) {
        this.currentindexid = currentindexid;
    }
    
    
    
    
     public List<UpisSemestar> getUpisSemestar(String indexID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      HttpSession session = Util.getSession();
           session.setAttribute("izabranpredmet", 0);

//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "select ID as UpisID,  'Semestar '+ SemestarNaziv as Semestar, SemestarID, IndeksBroj, IndexID , StudentID, StudijskiProgramNaziv from dbo.vUpis ";
      stm = stm.concat(" where indexID = " + indexID + " ORDER BY SemestarID");
      
      List<UpisSemestar> records;
       records = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();
         while(rs.next()){
            UpisSemestar upissemestar = new UpisSemestar();
            upissemestar.setIndexbroj(rs.getString("IndeksBroj"));
            upissemestar.setIndexid(rs.getInt("IndexID"));
            upissemestar.setSemestar(rs.getString("Semestar"));
            upissemestar.setSemestarid(rs.getInt("SemestarID"));
            upissemestar.setStudentid(rs.getInt("StudentID"));
            upissemestar.setUpisid(rs.getInt("UpisID"));
            records.add(upissemestar);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return records;
   }
    
   
     
     public String knjige()
     {
         return "books?faces-redirect=true";
     }
     
      public List<PredmetSemestar> getPredmetSemestar(String upisID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      System.out.println("upis " + upisID);
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
      String stm = "SELECT  ID ,UpisID ,StudentID ,PredmetID ,SifraPredmeta ,Predmet ,Ocjena ,DatumPolozio ,Profesor ,IndeksBroj FROM dbo.vUpisDetalj ";
      stm = stm.concat(" where UpisID = " + upisID + " ORDER BY StudentID");
      
      List<PredmetSemestar> records;
       records = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            PredmetSemestar predmetsemestar = new PredmetSemestar();
            predmetsemestar.setId(rs.getInt("ID"));
            predmetsemestar.setUpisid(rs.getInt("UpisID"));
            predmetsemestar.setStudentid(rs.getInt("StudentID"));
            predmetsemestar.setPredmetid(rs.getInt("PredmetID"));
            predmetsemestar.setSifrapredmeta(rs.getString("SifraPredmeta"));
            predmetsemestar.setPredmet(rs.getString("Predmet"));
            predmetsemestar.setOcjena(rs.getInt("Ocjena"));
            predmetsemestar.setDatumpolozio(rs.getDate("DatumPolozio"));
            if (rs.getString("Profesor") == null)
            {
             predmetsemestar.setProfesor("Javite se studentskoj službi da Vam odrede profesora za predmet da bi mogli prijaviti ispit!");
            }
            else
            {
                predmetsemestar.setProfesor(rs.getString("Profesor"));
            }
            predmetsemestar.setIndexbroj(rs.getString("IndeksBroj"));
            records.add(predmetsemestar);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return records;
   }
     
      
//      public PredmetSemestar getSelectedPredmet() {
//        return selectedPredmet;
//    }
// 
//    public void setSelectedPredmet(PredmetSemestar selectedPredmet) {
//        this.selectedPredmet = selectedPredmet;
//    }
// 
//    public List<PredmetSemestar> getSelectedPredmets() {
//        return selectedPredmets;
//    }
// 
//    public void setSelectedPredmets(List<PredmetSemestar> selectedPredmets) {
//        this.selectedPredmets = selectedPredmets;
//    }
      
      
     public void onRowSelect(SelectEvent event) {
      
         String mesg;
         int broj=0;
         broj =        ((PredmetSemestar) event.getObject()).getId(); 
         mesg = Integer.toString(broj);
         
//        FacesMessage msg = new FacesMessage("Predmet Selected", mesg);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("PredmetSelected " + mesg);
    }
     
     
     public void onRedSelect (int broj)
     {
             String mesg;
        
//         broj =        ((PredmetSemestar) event.getObject()).getId(); 
         mesg = Integer.toString(broj);
         
//        FacesMessage msg = new FacesMessage("Predmet Selected", mesg);
//        FacesContext.getCurrentInstance().addMessage(null, msg);     
         System.out.println("PredmetSelected " + mesg);
         
     }
 
    public void onRowUnselect(UnselectEvent event) {
        
                 String mesg;
         int broj;
         broj =        ((PredmetSemestar) event.getObject()).getId(); 
         mesg = Integer.toString(broj);
         
//        FacesMessage msg = new FacesMessage("Predmet Unselected", mesg);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
           System.out.println("Predmet UN Selected " + mesg);
    } 
    
    
    
    
 
    
      public double getFinsaldo(String userGUID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "Select SUM(Duguje-Potrazuje) as Saldo from vNalogAll ";
      stm = stm.concat(" where ParID = dbo.fvratiStudentID('" + userGUID + "')");     
      
      double saldo;
      saldo = 0.00;
      
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            saldo = rs.getDouble("Saldo");			
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      
//      String result;
//      result = Double.toString(saldo);
//      result = String.format(Locale.GERMANY, "%,10.2f", saldo);
      return saldo;
   }
    

      
      
      
    
      
      
      
    
//   public Connection getConnection(){
//      Connection con = null;
//
//      String url = "jdbc:postgresql://localhost/testdb";
//      String user = "user1";
//      String password = "user1";
//      try {
//         con = DriverManager.getConnection(url, user, password);
//         System.out.println("Connection completed.");
//      } catch (SQLException ex) {
//         System.out.println(ex.getMessage());
//      }
//      finally{
//      }
//      return con;
//   }
}