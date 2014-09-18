/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.dao;
import com.ec.estudent.beans.Util;
import com.ec.estudent.classes.Predmet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;


  
public class UserDAO {    
   
    
     public static int login(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select TOP 1 JU.username, JU.password as pass, JU.Id as UserGUID,  JU.StudentID,  JU.userTHEME, ISNULL(I.IndexID,0)  as IndexID, S.Ime, S.Prezime , P.Naziv,  JU.IsProfesor from dbo.JavaUsers  as JU  left OUTER join sTUDENT s ON S.iD = JU.sTUDENTid left OUTER join Profesor P ON P.iD = JU.sTUDENTid LEFT OUTER JOIN (SELECT top 100 PERCENT id as IndexID, StudentID From dbo.vIndeks ORDER BY ID) I on i.StudentId = JU.StudentID  where JU.username= ? and JU.password= ?  ORDER BY ISNULL(I.IndexID,0)");
 
            
            
            ps.setString(1, user);
            ps.setString(2, password);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
              System.out.println(rs.getString("username"));
              System.out.println(rs.getString("UserGUID"));
                HttpSession session = Util.getSession();
                session.setAttribute("userGUID", rs.getString("UserGUID"));
                
                 System.out.println(session.getAttribute("userGUID"));
session.setAttribute("userTHEME", rs.getString("userTHEME"));
session.setAttribute("IndexID", rs.getString("IndexID"));
session.setAttribute("IsProfesor", Integer.toString(rs.getInt("IsProfesor")));




if (rs.getInt("IsProfesor")==0)
        {
            session.setAttribute("ImePrezime", rs.getString("Ime").concat(" ").concat(rs.getString("Prezime")));
                return 1;    // student           
        }
else
{
    session.setAttribute("Naziv", rs.getString("Naziv"));
                   return 2;   // profesor
}

 
            }
            else {
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return 0;
        } finally {
            Database.close(con);
        }
        
        
     }  
        
    
    
    
     public static List<Predmet> getPredmetSemestar(String upisID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      List<Predmet> predmets;
      
      System.out.println("upis " + upisID);
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
      String stm = "SELECT  ID ,UpisID ,StudentID ,PredmetID ,SifraPredmeta ,Predmet ,Ocjena ,DatumPolozio ,Profesor ,IndeksBroj FROM dbo.vUpisDetalj ";
      stm = stm.concat(" where UpisID = " + upisID + " ORDER BY StudentID");
      
//      System.out.println("upis -->" + upisID);
       predmets = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            Predmet predmet = new Predmet(
            
            rs.getInt("ID"),
               rs.getInt("UpisID"),
              rs.getInt("StudentID"),
               rs.getInt("PredmetID"),     
            rs.getString("SifraPredmeta"),
                    rs.getString("Predmet"),
                            rs.getInt("Ocjena"),
                                    rs.getDate("DatumPolozio"),
               rs.getString("Profesor")   ,
                       rs.getString("IndeksBroj")
            );
//            predmet.setId();
//            predmetsemestar.setUpisid(rs.getInt("UpisID"));
//            predmetsemestar.setStudentid(rs.getInt("StudentID"));
//            predmetsemestar.setPredmetid(rs.getInt("PredmetID"));
//            predmetsemestar.setSifrapredmeta(rs.getString("SifraPredmeta"));
//            predmetsemestar.setPredmet(rs.getString("Predmet"));
//            predmetsemestar.setOcjena(rs.getInt("Ocjena"));
//            predmetsemestar.setDatumpolozio(rs.getDate("DatumPolozio"));
//            if (rs.getString("Profesor") == null)
//            {
//             predmetsemestar.setProfesor("Javite se studentskoj službi da Vam odrede profesora za predmet da bi mogli prijaviti ispit!");
//            }
//            else
//            {
//                predmetsemestar.setProfesor(rs.getString("Profesor"));
//            }
//            predmetsemestar.setIndexbroj(rs.getString("IndeksBroj"));
            predmets.add(predmet);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return predmets;
   }
        
        
        
        
    
}