/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sql;

import AbstractFactory.Satis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author w10
 */
public class SqlVeriIslemleriSatis extends SqlBaglantı implements SqlVeriIslem {
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
    public void Guncelleme(String hangiOzellik, String ozellik1_deger, int satis_id, int ozellik_deger, int kactane) {
        try{
             Statement st = this.getDb().createStatement();
             if(ozellik1_deger.equals("")){
             String updateQuery = "UPDATE satis SET "+hangiOzellik+"= ? WHERE satis_id = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setInt(1,ozellik_deger);
             pstmt.setInt(2,satis_id);
             pstmt.executeUpdate();
             System.out.println("güncellendi.");   
             }
             else{
             String updateQuery = "UPDATE satis SET " + hangiOzellik + " = ? WHERE satis_id = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setString(1,ozellik1_deger);
             pstmt.setInt(2,satis_id);
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
    public void Silme(int satis_id) {
       try{
            Statement st = this.getDb().createStatement();
            String deleteQuery = "Delete from satis WHERE satis_id ='"+satis_id+"'";
            PreparedStatement pstmt = db.prepareStatement(deleteQuery);
            pstmt.executeUpdate();
        } 
        catch(Exception ex){

            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public List Verileri_Listeleme() {
        List<Satis> veriListe = new ArrayList<>();
        try {

            Statement st = this.getDb().createStatement();
            String query = "select *from satis";//tüm tabloyu alma
            ResultSet rs = st.executeQuery(query); //tablodan veri çekme
            while (rs.next()) { //burası null olana kadar dönmesi için tablonunu
                    veriListe.add(new Satis(rs.getInt("satis_id"),rs.getInt("uretim_id"),rs.getString("satilan_ulke"),rs.getString("sattigimiz_ulke"),rs.getString("firma_adi"),
                    rs.getString("firma_vergi_no"), rs.getString("firma_iletisim"),
                    rs.getString("satilan_urun"), rs.getString("satilan_urun_renk"),rs.getString("odeme_turu"),rs.getString("ulasım_yolu"),rs.getInt("ulasım_yolu_uzaklık"),rs.getInt("satis_fiyati"), 
                    rs.getInt("satilan_desi")
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
            Satis ca=(Satis) c;
            query2 = "insert into satis(uretim_id,satilan_ulke,sattigimiz_ulke,firma_adi,firma_vergi_no,firma_iletisim,satilan_urun,satilan_urun_renk,odeme_turu,ulasım_yolu,ulasım_yolu_uzaklık,satilan_desi,satis_fiyati) values('" 
                    +ca.getUretim_id()+"','"+ca.getSatilan_ulke()+"','"+ca.getSattigimiz_ulke()+"','"+ ca.getFirma_adi()+ "','" + ca.getFirma_vergi_no()+ "','" + ca.getFirma_iletisim()+ "','" + ca.getSatilan_urun()
                    + "','" + ca.getSatilan_urun_renk()+ "','"+ ca.getOdeme_turu()+"','" +ca.getUlasım_yolu()+"','"+ca.getUlasım_yolu_uzaklık()+"','"+ ca.getSatılan_desi()+ "','" + ca.getSatis_fiyati()
                    +"')";
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
