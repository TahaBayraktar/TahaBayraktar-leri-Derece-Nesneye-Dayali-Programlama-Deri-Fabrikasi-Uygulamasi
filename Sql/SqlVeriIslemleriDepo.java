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
import AbstractFactory.Depo;

/**
 *
 * @author w10
 */
public class SqlVeriIslemleriDepo extends SqlBaglantı implements SqlVeriIslem {
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
        this.db = db;
    }

    @Override
    public void Guncelleme(String hangiOzellik, String ozellik1_deger, int id, int ozellik_deger, int kactane) {
        try{
             Statement st = this.getDb().createStatement();
             if(ozellik1_deger.equals("")){
             String updateQuery = "UPDATE depo SET "+hangiOzellik+"= ? WHERE urun_id = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setInt(1,ozellik_deger);
             pstmt.setInt(2,id);
             pstmt.executeUpdate();
             System.out.println("güncellendi.");   
             }
             else{
             String updateQuery = "UPDATE depo SET " + hangiOzellik + " = ? WHERE urun_id = ?";
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
    public void Silme(int id) {
        try{
            Statement st = this.getDb().createStatement();
            String deleteQuery = "Delete from depo WHERE urun_id ='"+id+"'";
            PreparedStatement pstmt = db.prepareStatement(deleteQuery);
            pstmt.executeUpdate();
        } 
        catch(Exception ex){

            System.out.println(ex.getMessage());
        } 
    }
    @Override
    public List Verileri_Listeleme() {
       List<Depo> veriListe = new ArrayList<>();
        try {

            Statement st = this.getDb().createStatement();
            String query = "select *from depo";//tüm tabloyu alma
            ResultSet rs = st.executeQuery(query); //tablodan veri çekme
            while (rs.next()) { //burası null olana kadar dönmesi için tablonunu
                    veriListe.add(new Depo(rs.getInt("urun_id"),rs.getString("urun_adi"), rs.getString("renk"), rs.getInt("birim_maliyet"),
                            rs.getInt("satis_fiyat"),  rs.getInt("birim_kar"), rs.getInt("stok_miktari")));
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
            Depo ca=(Depo) c;
            query2 = "insert into depo(urun_adi,renk,birim_maliyet,satis_fiyat,birim_kar,stok_miktari) values('" 
                    + ca.getUrun_adı() + "','" + ca.getRenk() + "','" + ca.getBirim_maliyet() + "','" + ca.getSatis_fiyat() 
                    + "','" + ca.getBirim_kar() + "','"+ ca.getStok_miktarı() + "')";
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
