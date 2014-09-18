/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.classes;

/**
 *
 * @author Bruxx
 * select ID as UpisID,  'Semestar '+ SemestarNaziv as Semestar, SemestarID, IndeksBroj, IndexID , StudentID from dbo.vUpis;
 */
public class UpisSemestar {
    int upisid;
    String semestar;
    int semestarid;
    String indexbroj;
    int indexid;
    int studentid;
        String studijskiprogramnaziv;
    
    public int getUpisid() {
      return upisid;
   }
   public void setUpisid(int upisid) {
      this.upisid = upisid;
   }
   
    public String getSemestar() {
      return semestar;
   }
   public void setSemestar(String semestar) {
      this.semestar = semestar;
   }
   
    public String getStudijskiprogramnaziv() {
      return studijskiprogramnaziv;
   }
   public void setStudijskiprogramnaziv(String studijskiprogramnaziv) {
      this.studijskiprogramnaziv = studijskiprogramnaziv;
   }
   
   public int getSemestarid() {
      return semestarid;
   }
       
   public void setSemestarid(int semestarid) {
      this.semestarid = semestarid;
   }
   
   public String getIndexbroj() {
      return indexbroj;
   }
   public void setIndexbroj(String indexbroj) {
      this.indexbroj = indexbroj;
   }
  
   
  public int getIndexid() {
      return indexid;
   }
   public void setIndexid(int indexid) {
      this.indexid = indexid;
   }
 
     public int getStudentid() {
      return studentid;
   }
   public void setStudentid(int studentid) {
      this.studentid = studentid;
   }
   
}
