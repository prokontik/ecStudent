/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.classes;

/**
 *
 * @author Bruxx
 */
public class Profesor {
   int profesorid;
   String ime;
   String prezime;
   String titula;
   String naziv;
   int ecbit;
   String email;
   
   
   
  public String getIme() {
      return ime;
   }
   public void setIme(String ime) {
      this.ime = ime;
   }
   
   
   public int getProfesorId() {
      return profesorid;
   }
   public void setProfesorId(int profesorid) {
      this.profesorid = profesorid;
   }
   
   
     public String getPrezime() {
      return prezime;
   }
   public void setPrezime(String prezime) {
      this.prezime = prezime;
   }
       public String getNaziv() {
      return naziv;
   }
   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }
   
     public String getTitula() {
      return titula;
   }
   public void setTitula(String titula) {
      this.titula = titula;
   }
     public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
  
   
      public int getEcbit() {
      return ecbit;
   }
   public void setEcbit(int ecbit) {
      this.ecbit = ecbit;
   }
   
}
