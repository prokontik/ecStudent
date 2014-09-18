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
import java.io.Serializable;
import java.util.Date;

public class Predmet implements Serializable {

    /**
     * 
     */
//    private static final long serialVersionUID = 240545116337689611L;
//    private String model;
//    private int year;
//    private String manufacturer;
//    private String color;
//    private int price;

    
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
    
    
    
    public Predmet( int id,   int upisid,  int studentid, 
    int predmetid, String sifrapredmeta, String predmet, 
    int ocjena, Date datumpolozio,
    String profesor,
    String indexbroj)
    {
      this.id=id;
      this.upisid=upisid;
      this.studentid=studentid;
      this.predmetid=predmetid;
      this.sifrapredmeta=sifrapredmeta;
      this.predmet=predmet;
      this.ocjena=ocjena;
      this.datumpolozio=datumpolozio;
      this.profesor=profesor;
      this.indexbroj=indexbroj;
    }
            
            
            
            
            


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getupisid() {
        return upisid;
    }

    public void setupisid(int upisid) {
        this.upisid = upisid;
    }

    public int getstudentid() {
        return studentid;
    }

    public void setstudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getpredmetid() {
        return predmetid;
    }

    public void setpredmetid(int predmetid) {
        this.predmetid = predmetid;
    }

    public String getsifrapredmeta() {
        return sifrapredmeta;
    }

    public void setsifrapredmeta(String sifrapredmeta) {
        this.sifrapredmeta = sifrapredmeta;
    }
    
    
       public String getpredmet() {
        return predmet;
    }

    public void setpredmet(String predmet) {
        this.predmet = predmet;
    }
 
    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }
    
    
    public Date getdatumpolozio() {
        return datumpolozio;
    }

    public void setdatumpolozio(Date datumpolozio) {
        this.datumpolozio = datumpolozio;
    }
    
       public String getprofesor() {
        return profesor;
    }

    public void setprofesor(String profesor) {
        this.profesor = profesor;
    } 
    
       public String getindexbroj() {
        return indexbroj;
    }

    public void seindexbroj(String indexbroj) {
        this.indexbroj = indexbroj;
    } 
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Predmet))
            return false;

        Predmet compare = (Predmet) obj;

        return compare.id == this.id;
    }

//    @Override
//    public int hashCode() {
//        int hash = 1;
//
//        return hash * 31 + id.hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" + "model=" + model + ", year=" + year + ", manufacturer=" + manufacturer + ", color=" + color + ", price=" + price + '}';
//    }
}
