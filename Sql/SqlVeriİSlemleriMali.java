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
import nesneproje.Calisan;
import AbstractFactory.Depo;
import nesneproje.Personel;
import nesneproje.Yonetici;

public class SqlVeriİSlemleriMali extends SqlBaglantı {

    private Connection db;

    public void VeriEkleme(Object c,int id) {
        try {
            Statement st = this.getDb().createStatement();
            String query2 = "";

            if (c instanceof Yonetici) {
                Yonetici ca = (Yonetici) c;
                query2 = "insert into mali(gun,departman,gelir,gider,kar_zarar) values('" + ca.getGun() + "','Calisan','" + ca.gelir(id) + "','" + ca.gider(id) + "','" + ca.kar_zarar(id) + "')";
            } else if (c instanceof Personel) {
                Personel ca = (Personel) c;
                query2 = "insert into mali(gun,departman,gelir,gider,kar_zarar) values('" + ca.getGun() + "','Personel','" + ca.gelir(id) + "','" + ca.gider(id) + "','" + ca.kar_zarar(id) + "')";
            } else if (c instanceof Satis) {
                Satis ca = (Satis) c;
                query2 = "insert into mali(gun,departman,gelir,gider,kar_zarar) values('" + ca.getGun() + "','Satis','" + ca.gelir(id) + "','" + ca.gider(id) + "','" + ca.kar_zarar(id) + "')";
            } else if (c instanceof Depo) {
                Depo ca = (Depo) c;
                query2 = "insert into mali(gun,departman,gelir,gider,kar_zarar) values('" + ca.getGun() + "','Depo','" + ca.gelir(id) + "','" + ca.gider(id) + "','" + ca.kar_zarar(id) + "')";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List Verileri_Listeleme() {
        List<Calisan> veriListe = new ArrayList<>();
        try {

            Statement st = this.getDb().createStatement();
            String query = "select *from mali";//tüm tabloyu alma
            ResultSet rs = st.executeQuery(query); //tablodan veri çekme
            while (rs.next()) { //burası null olana kadar dönmesi için tablonunu
                String departman = rs.getString("departman");
                if (departman.equals("Yönetici")) {
                    veriListe.add(new Yonetici(rs.getInt("islem_id"), rs.getInt("gun"), rs.getString("departman"),
                            rs.getInt("gelir"), rs.getInt("gider"), rs.getInt("kar_zarar")));
                } else {
                    veriListe.add(new Personel(rs.getInt("islem_id"), rs.getInt("gun"), rs.getString("departman"),
                            rs.getInt("gelir"), rs.getInt("gider"), rs.getInt("kar_zarar")));
                }

            }
            return veriListe;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return veriListe;
    }

    public void Silme(int islem_id) {
        try {
            Statement st = this.getDb().createStatement();
            String deleteQuery = "Delete from mali WHERE islem_id ='" + islem_id + "'";
            PreparedStatement pstmt = db.prepareStatement(deleteQuery);
            pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Guncelleme(String hangiOzellik, String ozellik1_deger, int islem_id, int ozellik_deger, int kactane) {
        try {
            Statement st = this.getDb().createStatement();
            if (ozellik1_deger.equals("")) {
                String updateQuery = "UPDATE mali SET " + hangiOzellik + "= ? WHERE islem_id = ?";
                PreparedStatement pstmt = db.prepareStatement(updateQuery);
                pstmt.setInt(1, ozellik_deger);
                pstmt.setInt(2, islem_id);
                pstmt.executeUpdate();
                System.out.println("güncellendi.");
            } else {
                String updateQuery = "UPDATE mali SET " + hangiOzellik + " = ? WHERE islem_id = ?";
                PreparedStatement pstmt = db.prepareStatement(updateQuery);
                pstmt.setString(1, ozellik1_deger);
                pstmt.setInt(2, islem_id);
                pstmt.executeUpdate();
                System.out.println("güncellendi.");
            }
            //Arayüzde girilen kutucuk kadar kactane değişkenine atanır ve atanan kadar for döngüsünde
            //metot çalıştırılarak dinamik hale gelmiş olur.

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
