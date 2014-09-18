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
public class Student {
   int Studentid;
   String ime;
   String prezime;
   String imeoca;
   String jmbg;
   String grad;
   String adresa;
   String zip;
   String drzava;
   
  public String getIme() {
      return ime;
   }
   public void setIme(String ime) {
      this.ime = ime;
   }
   public int getStudentId() {
      return Studentid;
   }
   public void setStudentId(int studentid) {
      this.Studentid = studentid;
   }
   
   
     public String getPrezime() {
      return prezime;
   }
   public void setPrezime(String prezime) {
      this.prezime = prezime;
   }
     public String getImeoca() {
      return imeoca;
   }
   public void setImeoca(String imeoca) {
      this.imeoca = imeoca;
   }
     public String getJmbg() {
      return jmbg;
   }
   public void setJmbg(String jmbg) {
      this.jmbg = jmbg;
   }
     public String getAdresa() {
      return adresa;
   }
   public void setAdresa(String adresa) {
      this.adresa = adresa;
   }
     public String getGrad() {
      return grad;
   }
   public void setGrad(String grad) {
      this.grad = grad;
   }
     public String getZip() {
      return zip;
   }
   public void setZip(String zip) {
      this.zip = zip;
   }
   
}
