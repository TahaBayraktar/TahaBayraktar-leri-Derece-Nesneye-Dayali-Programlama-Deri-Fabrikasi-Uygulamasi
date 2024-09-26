/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sql;

import TemplateMethod.DenizYoluUlasım;
import TemplateMethod.HavaYoluUlasım;
import TemplateMethod.KaraYoluUlasım;
import TemplateMethod.UlasımYap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nesneproje.Calisan;
import nesneproje.Personel;
import nesneproje.Yonetici;

/**
 *
 * @author taha
 */
public class SqlVeriIslemleriUlasım extends SqlBaglantı implements SqlVeriIslem {
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
    public void Guncelleme(String hangiOzellik, String ozellik1_deger, int tc, int ozellik_deger, int kactane) {
     try{
             Statement st = this.getDb().createStatement();
             if(ozellik1_deger.equals("")){
             String updateQuery = "UPDATE ulasım SET "+hangiOzellik+"= ? WHERE ulasım_id = ?";
             PreparedStatement pstmt = db.prepareStatement(updateQuery);
             pstmt.setInt(1,ozellik_deger);
             pstmt.setInt(2,tc);
             pstmt.executeUpdate();
             System.out.println("güncellendi.");   
             }
             else{
             String updateQuery = "UPDATE ulasım SET " + hangiOzellik + " = ? WHERE ulasım_id = ?";
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
    public void Silme(int ulasim_id) {
       try{
            Statement st = this.getDb().createStatement();
            String deleteQuery = "Delete from ulasım WHERE ulasım_id ='"+ulasim_id+"'";
            PreparedStatement pstmt = db.prepareStatement(deleteQuery);
            pstmt.executeUpdate();
            
        } 
        catch(Exception ex){
           
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List Verileri_Listeleme() {
       List<UlasımYap> veriListe = new ArrayList<>();
        try {

            Statement st = this.getDb().createStatement();
            String query = "select *from ulasım";//tüm tabloyu alma
            ResultSet rs = st.executeQuery(query); //tablodan veri çekme
            while (rs.next()) { //burası null olana kadar dönmesi için tablonunu
                String ulasım_yolu = rs.getString("ulasım_yolu");
                
                if (ulasım_yolu.toLowerCase().equals("deniz")) {
                    veriListe.add(new DenizYoluUlasım(rs.getInt("ulasım_id"), rs.getInt("satis_id"),rs.getString("sattigimiz_ulke"),rs.getString("satilan_urun"), rs.getString("satilan_renk"),
                            rs.getString("firma_iletisim"),  rs.getString("ulasım_yolu"), rs.getString("teslim_edildimi"),rs.getInt("ulasım_yolu_uzaklık"),rs.getInt("satilan_desi"),rs.getInt("ulasım_maliyet"),rs.getInt("tahmini_teslimat_gunu")));
                    
                } else if(ulasım_yolu.toLowerCase().equals("kara")) {
                   veriListe.add(new KaraYoluUlasım(rs.getInt("ulasım_id"), rs.getInt("satis_id"),rs.getString("sattigimiz_ulke"),rs.getString("satilan_urun"), rs.getString("satilan_renk"),
                            rs.getString("firma_iletisim"),  rs.getString("ulasım_yolu"), rs.getString("teslim_edildimi"),rs.getInt("ulasım_yolu_uzaklık"),rs.getInt("satilan_desi"),rs.getInt("ulasım_maliyet"),rs.getInt("tahmini_teslimat_gunu")));
                }
                else if(ulasım_yolu.toLowerCase().equals("hava")){
                    veriListe.add(new HavaYoluUlasım(rs.getInt("ulasım_id"), rs.getInt("satis_id"),rs.getString("sattigimiz_ulke"),rs.getString("satilan_urun"), rs.getString("satilan_renk"),
                            rs.getString("firma_iletisim"),  rs.getString("ulasım_yolu"), rs.getString("teslim_edildimi"),rs.getInt("ulasım_yolu_uzaklık"),rs.getInt("satilan_desi"),rs.getInt("ulasım_maliyet"),rs.getInt("tahmini_teslimat_gunu")));
                    
                }
                

            }
            return veriListe;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return veriListe;
    }

    @Override
    public void VeriEkleme(Object c, int id) {
    try {
            Statement st = this.getDb().createStatement();
            String query2 = "";

            if (c instanceof DenizYoluUlasım) {
                DenizYoluUlasım ca = (DenizYoluUlasım) c;
                query2 = "insert into ulasım(satis_id,sattigimiz_ulke,satilan_urun,satilan_renk,firma_iletisim,ulasım_yolu,teslim_edildimi,ulasım_yolu_uzaklık,satilan_desi,ulasım_maliyet,tahmini_teslimat_gunu) values('" + ca.getSatis_id() + "','" +ca.getSattigimiz_ulke() + "','"+ ca.getSatilan_urun() + "','" + ca.getSatilan_renk() + "','"+ ca.getFirma_iletisim()+ "','" + ca.getUlasım_yolu() + "','" + ca.getTeslim_edildimi() + "','" + ca.getUlasım_yolu_uzaklık() + "','" +ca.getSatilan_desi() + "','" +ca.getUlasım_maliyet() + "','"+ ca.getTahmini_teslimat_gunu() + "')";
            } else if (c instanceof HavaYoluUlasım) {
                HavaYoluUlasım ca = (HavaYoluUlasım) c;
               query2 = "insert into ulasım(satis_id,sattigimiz_ulke,satilan_urun,satilan_renk,firma_iletisim,ulasım_yolu,teslim_edildimi,ulasım_yolu_uzaklık,satilan_desi,ulasım_maliyet,tahmini_teslimat_gunu) values('" + ca.getSatis_id() + "','" +ca.getSattigimiz_ulke() + "','"+ ca.getSatilan_urun() + "','" + ca.getSatilan_renk() + "','"+ ca.getFirma_iletisim()+ "','" + ca.getUlasım_yolu() + "','" + ca.getTeslim_edildimi() + "','" +ca.getUlasım_yolu_uzaklık() + "','" + ca.getSatilan_desi() + "','" +ca.getUlasım_maliyet() + "','"+ ca.getTahmini_teslimat_gunu() + "')";
            }
            else if (c instanceof KaraYoluUlasım) {
                KaraYoluUlasım ca = (KaraYoluUlasım) c;
               query2 = "insert into ulasım(satis_id,sattigimiz_ulke,satilan_urun,satilan_renk,firma_iletisim,ulasım_yolu,teslim_edildimi,ulasım_yolu_uzaklık,satilan_desi,ulasım_maliyet,tahmini_teslimat_gunu) values('" + ca.getSatis_id() + "','" +ca.getSattigimiz_ulke() + "','"+ ca.getSatilan_urun() + "','" + ca.getSatilan_renk() + "','"+ ca.getFirma_iletisim()+ "','" + ca.getUlasım_yolu() + "','" + ca.getTeslim_edildimi() + "','" +ca.getUlasım_yolu_uzaklık() + "','" + ca.getSatilan_desi() + "','" +ca.getUlasım_maliyet() + "','"+ ca.getTahmini_teslimat_gunu() + "')";
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
