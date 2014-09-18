/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.classes;
import java.util.Date;
/**
 *
 * @author Bruxx
 */
public class PredmetSemestar {
    int id;  
    int upisid;
    int studentid;
    int predmetid;
    String sifrapredmeta;
    String predmet;
    int ocjena;
    Date datumpolozio;
    String profesor;
    String indexbroj;
    
    
  public int getId() {
      return id;
   }
    public String getStringId() {
      return Integer.toString(id);
   }
   public void setId(int id) {
      this.id = id;
   }
    
    public int getUpisid() {
      return upisid;
   }
   public void setUpisid(int upisid) {
      this.upisid = upisid;
   }
   
  public int getStudentid() {
      return studentid;
   }
   public void setStudentid(int studentid) {
      this.studentid = studentid;
   }
       public int getPredmetid() {
      return predmetid;
   }
   public void setPredmetid(int predmetid) {
      this.predmetid = predmetid;
   }
   
   
   
    public String getSifrapredmeta() {
      return sifrapredmeta;
   }
   public void setSifrapredmeta(String sifrapredmeta) {
      this.sifrapredmeta = sifrapredmeta;
   }

    public String getPredmet() {
      return predmet;
   }
   public void setPredmet(String predmet) {
      this.predmet = predmet;
   }

   public int getOcjena() {
      return ocjena;
   }
   
   public void setOcjena(int ocjena) {
      this.ocjena = ocjena;
   }

   
      public Date getDatumpolozio() {
      return datumpolozio;
   }
   
   public void setDatumpolozio(Date datumpolozio) {
      this.datumpolozio = datumpolozio;
   }
  
//       public String getMyFormattedDate() {
//        return new SimpleDateFormat("dd/MM/yyyy").format(datumpolozio);
//    }

    public String getProfesor() {
        
      return profesor;
   }
   public void setProfesor(String profesor) {
      this.profesor = profesor;
   }
   
       public String getIndexbroj() {
      return indexbroj;
   }
   public void setIndexbroj(String indexbroj) {
      this.indexbroj = indexbroj;
   }


}
