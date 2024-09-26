/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import AbstractFactory.AmerikaSuet;
import AbstractFactory.AmerikaSuni;
import AbstractFactory.TurkiyeSuet;
import AbstractFactory.TurkiyeSuni;
import AbstractFactory.Uretim;

/**
 *
 * @author taha
 */
public class SqlVeriIslemleriUretim extends SqlBaglantı implements SqlVeriIslem {
private Connection db;
    @Override
    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    @Override
    public void setDb(Connection db) {
       this.db=db;
    }

    @Override
    public void Guncelleme(String hangiOzellik, String ozellik1_deger, int id, int ozellik_deger, int kactane) {
        try{
             Statement st = this.getDb().createStatement();
             if(ozellik1_deger.equals("")){
             String updateQuery = "UPDATE uretim SET "+hangiOzellik+"= ? WHERE uretim_id = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setInt(1,ozellik_deger);
             pstmt.setInt(2,id);
             pstmt.executeUpdate();
             System.out.println("güncellendi.");   
             }
             else{
             String updateQuery = "UPDATE uretim SET " + hangiOzellik + " = ? WHERE uretim_id = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setString(1,ozellik1_deger);
             pstmt.setInt(2,id);
             pstmt.executeUpdate();
             System.out.println("güncellendi."); 
             }
             //Arayüzde girilen kutucuk kadar kactane değişkenine atanır ve atanan kadar for döngüsünde
             //metot çalıştırılarak dinamik hale gelmiş olur.
              
        }
                catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Silme(int uretim_id) {
       try{
            Statement st = this.getDb().createStatement();
            String deleteQuery = "Delete from uretim WHERE uretim_id ='"+uretim_id+"'";
            PreparedStatement pstmt = db.prepareStatement(deleteQuery);
            pstmt.executeUpdate();
        } 
        catch(Exception ex){

            System.out.println(ex.getMessage());
        } 
    }
    @Override
    public List Verileri_Listeleme() {
        List<Uretim> veriListe = new ArrayList<>();
        try {

            Statement st = this.getDb().createStatement();
            String query = "select *from uretim";//tüm tabloyu alma
            ResultSet rs = st.executeQuery(query); //tablodan veri çekme
            while (rs.next()) { //burası null olana kadar dönmesi için tablonunu
                    veriListe.add(new Uretim(rs.getInt("uretim_id"),rs.getInt("urun_id"),
                    rs.getString("urun_adı"), rs.getString("urun_renk"),rs.getString("uretilen_ulke"),
                    rs.getInt("uretilen_miktar"), rs.getInt("maliyet")
                    ));
         }
            return veriListe;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return veriListe;
    }
    
    
    

    @Override
    public void VeriEkleme(Object c,int id) {
       try {
            Statement st = this.getDb().createStatement();
            String query2 = "";
            if(c instanceof TurkiyeSuni){
                TurkiyeSuni ca=(TurkiyeSuni) c;
            query2 = "insert into uretim(urun_id,uretilen_ulke,urun_adı,urun_renk,uretilen_miktar,maliyet) values('" 
                    + ca.getid()+ "','" + "turkiye"+"','" + "suni"+ "','" + ca.getRenk()+ "','" + ca.getistenen_miktar()+ "','" + id
                    + "')";
            }
            else if(c instanceof TurkiyeSuet){
                  TurkiyeSuet ca=(TurkiyeSuet) c;
            query2 = "insert into uretim(urun_id,uretilen_ulke,urun_adı,urun_renk,uretilen_miktar,maliyet) values('" 
                    + ca.getid()+ "','" + "turkiye"+"','" + "suet"+ "','" + ca.getRenk()+ "','" + ca.getistenen_miktar()+ "','" + id
                    + "')";
            }
            else if(c instanceof AmerikaSuet){
                  AmerikaSuet ca=(AmerikaSuet) c;
            query2 = "insert into uretim(urun_id,uretilen_ulke,urun_adı,urun_renk,uretilen_miktar,maliyet) values('" 
                    + ca.getid()+"','" + "amerika"+"','" + "suet"+ "','" + ca.getRenk()+ "','" + ca.getistenen_miktar()+ "','" + id
                    + "')";
            }
             else if(c instanceof AmerikaSuni){
                  AmerikaSuni ca=(AmerikaSuni) c;
            query2 ="insert into uretim(urun_id,uretilen_ulke,urun_adı,urun_renk,uretilen_miktar,maliyet) values('" 
                    + ca.getid()+ "','" + "amerika"+"','" + "suni"+  "','" + ca.getRenk()+ "','" + ca.getistenen_miktar()+ "','" + id
                    + "')";
            }
            
            int r = st.executeUpdate(query2); // Veri Ekleme ,Başarılıyken 1 dönüyor.
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void SilmeCalisan(Long tc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void GuncellemeCalisan(String hangiOzellik, String ozellik1_deger, long tc, int ozellik_deger, int kactane) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
