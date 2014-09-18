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
public class StudentPredmet {
   int profesorid;
   String studentid;
   String naziv;
   String brindexa;
   String email;
   String ocjena;
   String datumpolozio;
   
   public int getProfesorId() {
      return profesorid;
   }
   public void setProfesorId(int profesorid) {
      this.profesorid = profesorid;
   }
   
   
     public String getStudentid() {
      return studentid;
   }
   public void setStudentid(String studentid) {
      this.studentid = studentid;
   }
       public String getNaziv() {
      return naziv;
   }
   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }
   
   
   public String getOcjena() {
      return ocjena;
   }
   public void setOcjena(String ocjena) {
      this.ocjena = ocjena;
   }
   
   
     public String getBrindexa() {
      return brindexa;
   }
   public void setBrindexa(String brindexa) {
      this.brindexa = brindexa;
   }
     public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
  
      public String getDatumpolozio() {
      return datumpolozio;
   }
   public void setDatumpolozio(String datumpolozio) {
      this.datumpolozio = datumpolozio;
   } 
   
}
