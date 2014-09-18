package com.ec.estudent.classes;
import java.util.Date;
/**
 *
 * @author Bruxx
 */
public class RasporedIspita {
    int id;  
    int UpisDetaljID;
    String sifrapredmeta;
    String predmet;
    String profesor;
    String ispitniroknaziv;
    Date datumod;
    Date datumdo;


    
 
    
  public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
    
    public int getUpisDetaljID() {
      return UpisDetaljID;
   }
   public void setUpisDetaljID(int UpisDetaljID) {
      this.UpisDetaljID = UpisDetaljID;
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

   
       public String getProfesor() {
        
      return profesor;
   }
   public void setProfesor(String profesor) {
      this.profesor = profesor;
   }
   
   public String getIspitniroknaziv() {
        
      return ispitniroknaziv;
   }
   public void setIspitniroknaziv(String ispitniroknaziv) {
      this.ispitniroknaziv = ispitniroknaziv;
   }
      public Date getDatumod() {
      return datumod;
   }
   
   public void setDatumod(Date datumod) {
      this.datumod = datumod;
   }
  
   
         public Date getDatumdo() {
      return datumdo;
   }
   
   public void setDatumdo(Date datumdo) {
      this.datumdo = datumdo;
   }
   
   
//       public String getMyFormattedDate() {
//        return new SimpleDateFormat("dd/MM/yyyy").format(datumpolozio);
//    }


 


}