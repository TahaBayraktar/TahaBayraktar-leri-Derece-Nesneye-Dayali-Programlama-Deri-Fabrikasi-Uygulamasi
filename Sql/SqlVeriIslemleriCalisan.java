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
import nesneproje.Calisan;
import nesneproje.Personel;
import nesneproje.Yonetici;

public class SqlVeriIslemleriCalisan extends SqlBaglantı implements SqlVeriIslem  {
    private Connection db;
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
    public void Guncelleme(String hangiOzellik, String ozellik1_deger, int tc, int ozellik_deger, int kactane) {
        try{
             Statement st = this.getDb().createStatement();
             if(ozellik1_deger.equals("")){
             String updateQuery = "UPDATE calisan SET "+hangiOzellik+"= ? WHERE tc = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setInt(1,ozellik_deger);
             pstmt.setInt(2,tc);
             pstmt.executeUpdate();
             System.out.println("güncellendi.");   
             }
             else{
             String updateQuery = "UPDATE calisan SET " + hangiOzellik + " = ? WHERE tc = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setString(1,ozellik1_deger);
             pstmt.setInt(2,tc);
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
    public void Silme(int tc) {
    
    }

    @Override
    public List Verileri_Listeleme() {
        List<Calisan> veriListe = new ArrayList<>();
        try {

            Statement st = this.getDb().createStatement();
            String query = "select *from calisan";//tüm tabloyu alma
            ResultSet rs = st.executeQuery(query); //tablodan veri çekme
            while (rs.next()) { //burası null olana kadar dönmesi için tablonunu
                String mevki = rs.getString("mevki");
                if (mevki.equals("Yönetici")) {
                    veriListe.add(new Yonetici(rs.getLong("tc"), rs.getString("sifre"),rs.getString("ulke"),rs.getString("isim"), rs.getString("soyad"),
                            rs.getString("numara"),  rs.getInt("mas"), rs.getInt("ortcalısmasaati")));
                } else {
                    veriListe.add(new Personel(rs.getLong("tc"), rs.getString("sifre"),rs.getString("ulke"),rs.getString("isim"), rs.getString("soyad"),
                            rs.getString("numara"), rs.getInt("mas"), rs.getInt("ortcalısmasaati")));
                }

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

            if (c instanceof Yonetici) {
                Yonetici ca = (Yonetici) c;
                query2 = "insert into calisan(tc,ulke,isim,sifre,soyad,numara,mevki,mas,ortcalısmasaati) values('" + ca.getTc() + "','" +ca.getUlke() + "','"+ ca.getIsim() + "','" + ca.getSifre() + "','"+ ca.getSoyad() + "','" + ca.getTelefonNo() + "','" + ca.getMevki() + "','" + ca.getMaas() + "','" + ca.getOrtalamaCalısmaSaati() + "')";
            } else if (c instanceof Personel) {
                Personel ca = (Personel) c;
                query2 = "insert into calisan(tc,ulke,isim,sifre,soyad,numara,mevki,mas,ortcalısmasaati) values('" + ca.getTc() + "','" +ca.getUlke() + "','"+ ca.getIsim() + "','" + ca.getSifre() + "','"+ ca.getSoyad() + "','" + ca.getTelefonNo() + "','" + ca.getMevki() + "','" + ca.getMaas() + "','" + ca.getOrtalamaCalısmaSaati() + "')";
            }

            int r = st.executeUpdate(query2); // Veri Ekleme ,Başarılıyken 1 dönüyor.

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void SilmeCalisan(Long tc) {
        try{
            Statement st = this.getDb().createStatement();
            String deleteQuery = "Delete from calisan WHERE tc ='"+tc+"'";
            PreparedStatement pstmt = db.prepareStatement(deleteQuery);
            pstmt.executeUpdate();
            
        } 
        catch(Exception ex){
           
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public void GuncellemeCalisan(String hangiOzellik, String ozellik1_deger, long tc, int ozellik_deger, int kactane) {
    try{
             Statement st = this.getDb().createStatement();
             if(ozellik1_deger.equals("")){
             String updateQuery = "UPDATE calisan SET "+hangiOzellik+"= ? WHERE tc = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setInt(1,ozellik_deger);
             pstmt.setLong(2,tc);
             pstmt.executeUpdate();
             System.out.println("güncellendi.");   
             }
             else{
             String updateQuery = "UPDATE calisan SET " + hangiOzellik + " = ? WHERE tc = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setString(1,ozellik1_deger);
             pstmt.setLong(2,tc);
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
    
}
