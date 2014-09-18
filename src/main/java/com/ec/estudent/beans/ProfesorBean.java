/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.beans;


import com.ec.estudent.classes.Profesor;
import com.ec.estudent.classes.CV;
import com.ec.estudent.classes.StudentPredmet;
import com.ec.estudent.classes.Treedoc;
import com.ec.estudent.dao.Database;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
//import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Bruxx
 */
@ManagedBean(name = "profesorBean")
@SessionScoped
public class ProfesorBean implements Serializable {

    String naziv;
    private int profesorID;
    public int cvid;
    private CV profcv;
    private String selectedpredmet = "";
    
    
        private TreeNode root;
     
    private TreeNode selectedNode;
    
    

   public CV getProfcv() {
      return profcv;
   }
   
   
   public void setProfcv(CV profcv) {
      this.profcv = profcv;
   }
   
   
   
           public String getNaziv() {
      return naziv;
   }
   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }
    
     public List<Profesor> getProfesors(String userGUID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "Select ID as ProfesorID, Ime, Prezime, Titula, Naziv, eMail, ecBit from Profesor ";
      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + userGUID + "')");     
      List<Profesor> records;
       records = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            Profesor profesor = new Profesor();
           naziv=rs.getString("Naziv");
           profesorID = rs.getInt("ProfesorID");
            profesor.setProfesorId(rs.getInt("ProfesorID"));
            profesor.setIme(rs.getString("Ime"));
            profesor.setPrezime(rs.getString("Prezime"));
            profesor.setTitula(rs.getString("Titula"));
            profesor.setNaziv(rs.getString("Naziv"));
            profesor.setEmail(rs.getString("Email"));
            profesor.setEcbit(rs.getInt("ecBit"));

//            student.   .setStudentid(rs.getInt(1));
//            student.setName(rs.getString(2));
            records.add(profesor);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return records;
   }
    
    
     
     
      public List<StudentPredmet> getStuidentPredmet(String userGUID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "SELECT TOP 1000 [ID]\n" +
"      ,[IndeksBroj]\n" +
"      ,[JMBG]\n" +
"      ,Cast([StudentID] as varchar(10)) as StudentID\n" +
"      ,[Student]\n" +
"      ,[StudijskaGrupaNaziv]\n" +
"      ,[StudijNaziv]\n" +
"      ,[StudijskiProgramNaziv]\n" +
"      ,[GodinaNaziv]\n" +
"      ,[SemestarNaziv]\n" +
"      ,[PredmetID]\n" +
"      ,[SifraPredmeta]\n" +
"      ,[Predmet]\n" +
"      ,[ecBit]\n" +
"      ,[Ocjena]\n" +
"      ,[Opis]\n" +
"      ,[DatumPolozio]\n" +
"      ,[DatumPolozioStr]\n" +
"      ,[ProfesorID]\n" +
"      ,[Profesor]\n" +
"      ,[IspitniRokID]\n" +
"      ,[IspitniRokNaziv]\n" +
"  FROM [dbo].[vUpisDetalj]";
      stm = stm.concat(" where Len(Student) > 2 and Predmet = '" + selectedpredmet +"' and ProfesorID = dbo.fvratiStudentID('" + userGUID + "')");     
      List<StudentPredmet> records;
       records = new ArrayList<>();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            StudentPredmet sp = new StudentPredmet();
//           naziv=rs.getString("Naziv");
//           profesorID = rs.getInt("ProfesorID");
            sp.setProfesorId(rs.getInt("ProfesorID"));
            sp.setNaziv(rs.getString("Student"));
           sp.setEmail("");
            sp.setBrindexa(rs.getString("IndeksBroj"));
            sp.setOcjena(rs.getString("Ocjena"));
            sp.setDatumpolozio(rs.getString("DatumPolozioStr"));
//   int profesorid;
//   String studentid;
//   String naziv;
//   String brindexa;
//   String email;
//   String ocjena;
//   Date datumpolozio;
//            student.   .setStudentid(rs.getInt(1));
//            student.setName(rs.getString(2));
            records.add(sp);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return records;
   }
     
     
     
     
      public Profesor getProfesor(String userGUID){
      ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "Select TOP 1 ID as ProfesorID, Ime, Prezime, Titula, Naziv, eMail, ecBit from Profesor ";
      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + userGUID + "')");     
      Profesor profesor;
       profesor = new Profesor();
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
           naziv=rs.getString("Naziv");
           profesorID = rs.getInt("ProfesorID");
            profesor.setProfesorId(rs.getInt("ProfesorID"));
            profesor.setIme(rs.getString("Ime"));
            profesor.setPrezime(rs.getString("Prezime"));
            profesor.setTitula(rs.getString("Titula"));
            profesor.setNaziv(rs.getString("Naziv"));
            profesor.setEmail(rs.getString("Email"));
            profesor.setEcbit(rs.getInt("ecBit"));
            getCv ();

//            student.   .setStudentid(rs.getInt(1));
//            student.setName(rs.getString(2));
//            records.add(profesor);				
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      return profesor;
   }
     
     
      public void editCv() {
          
          
       Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
//        options.put("draggable", false);
//        options.put("resizable", false);
        options.put("contentHeight", 790);
        options.put("contentWidth", 1000);
         
        RequestContext.getCurrentInstance().openDialog("cv", options, null);
          
//        RequestContext.getCurrentInstance().openDialog("cv");
    }
     
    
      
      
     public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    
          public void onNodeSelect(NodeSelectEvent event) {
        selectedpredmet = event.getTreeNode().toString();
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedpredmet);
//        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
      
    public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
          
          
          
          
          
          
    public TreeNode getPredmetTree(String userGUID)
    {
         ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
      
//       HttpSession session = Util.getSession();
      
//      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
//      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
       String stm = "SELECT  [ID]\n" +
"      ,[ProfesorID]\n" +
"      ,[ProfesorNaziv]\n" +
"      ,CAST([PredmetID] as varchar(50)) as PredmetID\n" +
"      ,[SifraPredmeta]\n" +
"      ,[PredmetNaziv]\n" +
"      ,[Opis]\n" +
"      ,[ecBit]\n" +
"  FROM .[dbo].[vProfesorPredmet] ";
      stm = stm.concat(" where ProfesorID = dbo.fvratiStudentID('" + userGUID + "')");     
      
      root = new DefaultTreeNode(new Treedoc("Files", "-", "Folder"), null);
      // root.setRowKey("1");
//      TreeNode predmet = new DefaultTreeNode( new Treedoc("..", "-", "Folder"), root);
//      root.setRowKey("0");
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();
int brojac =0;


         while(rs.next()){
//           TreeNode node = new DefaultTreeNode(rs.getString("PredmetNaziv"), root);
		 TreeNode  predmet = new DefaultTreeNode( new Treedoc(rs.getString("PredmetNaziv"), "-", "Folder"), root);	
                
//                predmet.setRowKey(rs.getString("PredmetID"));
                
         }
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }
      
      
      
      
      return root;
      
    }
      
     
    public CV getCv ()
    {
         ResultSet rs = null;
      PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
      
         String stm = "SELECT [ID]\n" +
"      ,[ProfesorID]\n" +
"      ,[Obrazovanje]\n" +
"      ,ISNULL([RadnIskustvo],'') as RadnIskustvo\n" +
"      ,[ClanStrucNaucAso]\n" +
"      ,ISNULL([NastRad],'') as NastRad\n" +
"      ,[NastRadMonograf]\n" +
"      ,[NastRadClanciCaso]\n" +
"      ,[NastRadClanciZborn]\n" +
"      ,[NastRadClanciZbornNacioSkup]\n" +
"      ,[Udzbenici]\n" +
"      ,[NaucProjekStudi]\n" +
"      ,[Jezici]\n" +
"      ,[OrgSposobn]\n" +
"      ,[TehSposobn]\n" +
"      ,[NagradePriznanja]\n" +
"      ,[DodatInfor]\n" +
"      ,[ecBit]\n" +
"  FROM [dbo].[CV]";
         
      stm = stm.concat(" where ProfesorID = " + profesorID );     
      profcv = new CV();
      try {  
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();
            while(rs.next()){
                profcv.setCvid(rs.getInt("ID"));
                profcv.setObrazovanje(rs.getString("Obrazovanje"));
                  profcv.setRadnoIskustvo(rs.getString("RadnIskustvo"));
                  profcv.setNastRad(rs.getString("NastRad"));
                  profcv.setClanStrucNaucAso(rs.getString("ClanStrucNaucAso"));
                 profcv.setNastRadMonograf(rs.getString("NastRadMonograf"));
                 profcv.setNastRadClanciCaso(rs.getString("NastRadClanciCaso"));
                 profcv.setNastRadClanciZborn(rs.getString("NastRadClanciZborn"));
                 profcv.setNastRadClanciZbornNacioSkup(rs.getString("NastRadClanciZbornNacioSkup"));
                 profcv.setUdzbenici(rs.getString("Udzbenici"));
                 profcv.setNaucProjekStudi(rs.getString("NaucProjekStudi"));
                 profcv.setJezici(rs.getString("Jezici"));
                 profcv.setOrgSposobn(rs.getString("OrgSposobn"));
                 profcv.setTehSposobn(rs.getString("TehSposobn"));
                 profcv.setNagradePriznanja(rs.getString("NagradePriznanja"));
                  profcv.setDodatInfor(rs.getString("DodatInfor"));
                 
                      
                 
//                 profcv.setRadnoIskustvo(rs.getString("ClanStrucNaucAso"));
//               profcv.setNastRadMonograf(rs.getString("NastRadMonograf"));
               
            }
         
      } catch (SQLException e) {
         System.out.println("Error in login() -->" + e.getMessage());
      }   
       return profcv;   
    }
     
     
    public void saveCv()
    {
              PreparedStatement pst = null;
      Connection con = null;
      con = Database.getConnection();
     String stm ="Update CV Set Obrazovanje = '" + profcv.getObrazovanje() 
     + "', RadnIskustvo = '" + profcv.getRadnoIskustvo()
     + "', NastRad = '" + profcv.getNastRad()
     + "', ClanStrucNaucAso = '" + profcv.getClanStrucNaucAso()     
      + "', NastRadMonograf = '" + profcv.getNastRadMonograf() 
      + "', NastRadClanciCaso = '" + profcv.getNastRadClanciCaso() 
      + "', NastRadClanciZborn = '" + profcv.getNastRadClanciZborn() 
     + "', NastRadClanciZbornNacioSkup = '" + profcv.getNastRadClanciZbornNacioSkup() 
     + "', Udzbenici = '" + profcv.getUdzbenici() 
      + "', NaucProjekStudi = '" + profcv.getNaucProjekStudi() 
      + "', Jezici = '" + profcv.getJezici() 
      + "', OrgSposobn = '" + profcv.getOrgSposobn() 
     + "', TehSposobn = '" + profcv.getTehSposobn() 
      + "', NagradePriznanja = '" + profcv.getNagradePriznanja() 
      + "', DodatInfor = '" + profcv.getDodatInfor()        
     +  "' WHERE id = " +  Integer.toString(profcv.getCvId());
     
     
     try { 
     pst = con.prepareStatement(stm);
       int i;
         i =  pst.executeUpdate();
     }
     catch (SQLException e) {
         System.out.println("Error in update() -->" + e.getMessage());
      }   
     
     }
    
    
    
    
    
    
     
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

// public List<Index> getIndexs(String userGUID){
//      ResultSet rs = null;
//      PreparedStatement pst = null;
//      Connection con = null;
//      con = Database.getConnection();
//      
//      
////       HttpSession session = Util.getSession();
//      
////      String stm = "Select ID as StudentID, Ime, Prezime, JMBG, ImeOca, AdresaStanovanja, MjestoStanovanjaNaziv, MjestoStanovanjaPostBr from vStudent ";
////      stm = stm.concat(" where ID = dbo.fvratiStudentID('" + session.getAttribute("userGUID").toString() + "')");
//       String stm = "select ID as IndexID, Broj, StudentID, StudijskiProgramSifra, StudijskiProgramNaziv, Datum, FakultetNaziv, BrojIndeksa from dbo.vIndeks ";
//      stm = stm.concat(" where StudentID = dbo.fvratiStudentID('" + userGUID + "') ORDER BY IndexID");     
//
//       indexrecords = new ArrayList<>();
//      try {   
//         pst = con.prepareStatement(stm);
//         pst.execute();
//         rs = pst.getResultSet();
//
//         while(rs.next()){
//            if (currentindexid == 0)
//            {
//              currentindexid = rs.getInt("IndexID");
//            }
//            Index index = new Index();
//            index.setStudentId(rs.getInt("StudentID"));
//            index.setIndexid(rs.getInt("IndexID"));
//            index.setBrojindeksa(rs.getString("BrojIndeksa"));
//            index.setFaklutetnaziv(rs.getString("FakultetNaziv"));
//            index.setStudijskiprogramnaziv(rs.getString("StudijskiProgramNaziv"));
//            index.setSudijskiprogramsifra(rs.getString("StudijskiProgramSifra"));
//            indexrecords.add(index);				
//         }
//      } catch (SQLException e) {
//         System.out.println("Error in login() -->" + e.getMessage());
//      }
//      return indexrecords;
//   }


}
