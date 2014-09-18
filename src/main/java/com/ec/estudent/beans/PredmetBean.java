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
import com.ec.estudent.classes.Predmet;
import com.ec.estudent.classes.RasporedIspita;
import com.ec.estudent.dao.Database;
import com.ec.estudent.dao.UserDAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;




@ManagedBean(name = "predmetBean")
@SessionScoped

public class PredmetBean implements Serializable{
    private List<Predmet> predmets;
    private Predmet selectedPredmet;
    
      public int izabranpredmet=0;
    
     public List<Predmet> getPredmetSemestar(String upisID){
      
         predmets =  UserDAO.getPredmetSemestar(upisID);
         return predmets;
         
//         ResultSet rs = null;
//      PreparedStatement pst = null;
//      Connection con = null;
//      con = Database.getConnection();
//      
//      System.out.println("upis " + upisID);
////       HttpSession session = Util.getSession();
//      
////      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
////      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
//      String stm = "SELECT  ID ,UpisID ,StudentID ,PredmetID ,SifraPredmeta ,Predmet ,Ocjena ,DatumPolozio ,Profesor ,IndeksBroj FROM dbo.vUpisDetalj ";
//      stm = stm.concat(" where UpisID = " + upisID + " ORDER BY StudentID");
//      
////      System.out.println("upis -->" + upisID);
//       predmets = new ArrayList<>();
//      try {   
//         pst = con.prepareStatement(stm);
//         pst.execute();
//         rs = pst.getResultSet();
//
//         while(rs.next()){
//            Predmet predmet = new Predmet(
//            
//            rs.getInt("ID"),
//               rs.getInt("UpisID"),
//              rs.getInt("StudentID"),
//               rs.getInt("PredmetID"),     
//            rs.getString("SifraPredmeta"),
//                    rs.getString("Predmet"),
//                            rs.getInt("Ocjena"),
//                                    rs.getDate("DatumPolozio"),
//               rs.getString("Profesor")   ,
//                       rs.getString("IndeksBroj")
//            );
////            predmet.setId();
////            predmetsemestar.setUpisid(rs.getInt("UpisID"));
////            predmetsemestar.setStudentid(rs.getInt("StudentID"));
////            predmetsemestar.setPredmetid(rs.getInt("PredmetID"));
////            predmetsemestar.setSifrapredmeta(rs.getString("SifraPredmeta"));
////            predmetsemestar.setPredmet(rs.getString("Predmet"));
////            predmetsemestar.setOcjena(rs.getInt("Ocjena"));
////            predmetsemestar.setDatumpolozio(rs.getDate("DatumPolozio"));
////            if (rs.getString("Profesor") == null)
////            {
////             predmetsemestar.setProfesor("Javite se studentskoj službi da Vam odrede profesora za predmet da bi mogli prijaviti ispit!");
////            }
////            else
////            {
////                predmetsemestar.setProfesor(rs.getString("Profesor"));
////            }
////            predmetsemestar.setIndexbroj(rs.getString("IndeksBroj"));
//            predmets.add(predmet);				
//         }
//      } catch (SQLException e) {
//         System.out.println("Error in login() -->" + e.getMessage());
//      }
//      return predmets;
   }
    
    
    public List<Predmet> getPredmets() {
        return predmets;
    }

    public void setPredmets(List<Predmet> predmets) {
        this.predmets = predmets;
    }

    public Predmet getSelectedPredmet() {
        return selectedPredmet;
    }

    public void setSelectedPredmet(Predmet selectedPredmet) {
        this.selectedPredmet = selectedPredmet;
    }
    
    
    
    
     public void onRowSelect(SelectEvent event) {
      
         String mesg;
         int broj=0;
         broj =        ((Predmet) event.getObject()).getId(); 
         mesg = Integer.toString(broj);
         
//        FacesMessage msg = new FacesMessage("Predmet Selected", mesg);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
          izabranpredmet = broj;
          
           HttpSession session = Util.getSession();
           session.setAttribute("izabranpredmet", broj);
        System.out.println("PredmetSelected " + mesg);
    }
     
     
     
     public List<RasporedIspita> getRasporedIspita(){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
      HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
//       String stm = "select ID as UpisID,  'Semestar '+ SemestarNaziv as Semestar, SemestarID, IndeksBroj, IndexID , StudentID, StudijskiProgramNaziv from dbo.vUpis ";

      
          
   String stm = " SELECT UpisDetaljID ,RasporedIspitaID as ID, PredmetSifra, PredmetNaziv, ProfesorNaziv, ispitnirok, DatumOd, DatumDo FROM dbo.vMoguceOnlinePrijave";
       stm = stm.concat(" where UpisDetaljID  = " + session.getAttribute("izabranpredmet").toString() + " ORDER BY RasporedIspitaID");
    
   
      
      
      List<RasporedIspita> records;
       records = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            RasporedIspita rasporedispita = new RasporedIspita();
            rasporedispita.setId(rs.getInt("ID"));
            rasporedispita.setUpisDetaljID(rs.getInt("UpisDetaljID"));
            rasporedispita.setSifrapredmeta(rs.getString("PredmetSifra"));
            rasporedispita.setPredmet(rs.getString("PredmetNaziv"));
            rasporedispita.setProfesor(rs.getString("ProfesorNaziv"));
            rasporedispita.setDatumod(rs.getDate("DatumOd"));
            rasporedispita.setDatumdo(rs.getDate("DatumDo"));
            rasporedispita.setIspitniroknaziv(rs.getString("ispitnirok"));
            records.add(rasporedispita);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return records;
   }
     
     
     
//     public void onRedSelect (int broj)
//     {
//             String mesg;
//        
////         broj =        ((PredmetSemestar) event.getObject()).getId(); 
//         mesg = Integer.toString(broj);
//         
////        FacesMessage msg = new FacesMessage("Predmet Selected", mesg);
////        FacesContext.getCurrentInstance().addMessage(null, msg);     
//         System.out.println("PredmetSelected " + mesg);
//         
//         izabranpredmet = broj;
//     }
 
    public void onRowUnselect(UnselectEvent event) {
        
                 String mesg;
         int broj;
         broj =        ((Predmet) event.getObject()).getId(); 
         mesg = Integer.toString(broj);
         
//        FacesMessage msg = new FacesMessage("Predmet Unselected", mesg);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
           System.out.println("Predmet UN Selected " + mesg);
    } 
    
    
}