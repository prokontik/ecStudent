package com.ec.estudent.classes;

/**
 *
 * @author Bruxx
 */
public class Index {
   int studentid;
   int indexid;
   String brojindeksa;
   String faklutetnaziv;
   String studijskiprogramsifra;
   String studijskiprogramnaziv;

   
   
//   select ID as IndexID, Broj, StudentID, StudijskiProgramSifra, StudijskiProgramNaziv, Datum, FakultetNaziv, BrojIndeksa from dbo.vIndeks;
   
  public int getIndexid() {
      return indexid;
   }
   public void setIndexid(int indexid) {
      this.indexid = indexid;
   }
   public int getStudentId() {
      return studentid;
   }
   public void setStudentId(int studentid) {
      this.studentid = studentid;
   }
   
   
     public String getBrojindeksa() {
      return brojindeksa;
   }
   public void setBrojindeksa(String brojindeksa) {
      this.brojindeksa = brojindeksa;
   }
     public String getFaklutetnaziv() {
      return faklutetnaziv;
   }
   public void setFaklutetnaziv(String faklutetnaziv) {
      this.faklutetnaziv = faklutetnaziv;
   }
     public String getStudijskiprogramsifra() {
      return studijskiprogramsifra;
   }
   public void setSudijskiprogramsifra(String studijskiprogramsifra) {
      this.studijskiprogramsifra = studijskiprogramsifra;
   }
     public String getStudijskiprogramnaziv() {
      return studijskiprogramnaziv;
   }
   public void setStudijskiprogramnaziv(String studijskiprogramnaziv) {
      this.studijskiprogramnaziv = studijskiprogramnaziv;
   }

   
}
