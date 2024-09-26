/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import Sql.SqlVeriİSlemleriMali;
import Sql.SqlVeriIslemleriDepo;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import nesneproje.Mali;

public class Depo implements Mali {

    protected String urun_adi;
    protected String renk;
    protected int urun_id;
    protected int birim_maliyet;
    protected int satis_fiyat;
    protected int birim_kar;
    protected int stok_miktari;
    protected int gun;

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public Depo(int urun_id, String urun_adı, String renk, int birim_maliyet, int satis_fiyat, int birim_kar, int stok_miktarı) {
        this.urun_adi = urun_adı;
        this.renk = renk;
        this.urun_id = urun_id;
        this.birim_maliyet = birim_maliyet;
        this.satis_fiyat = satis_fiyat;
        this.birim_kar = birim_kar;
        this.stok_miktari = stok_miktarı;
    }
    public Depo(int gun){
        this.gun=gun;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public Depo() {

    }

    public String getUrun_adı() {
        return urun_adi;
    }

    public void setUrun_adı(String urun_adı) {
        this.urun_adi = urun_adı;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getBirim_maliyet() {
        return birim_maliyet;
    }

    public void setBirim_maliyet(int birim_maliyet) {
        this.birim_maliyet = birim_maliyet;
    }

    public int getSatis_fiyat() {
        return satis_fiyat;
    }

    public void setSatis_fiyat(int satis_fiyat) {
        this.satis_fiyat = satis_fiyat;
    }

    public int getBirim_kar() {
        return birim_kar;
    }

    public void setBirim_kar(int birim_kar) {
        this.birim_kar = birim_kar;
    }

    public int getStok_miktarı() {
        return stok_miktari;
    }

    public void setStok_miktarı(int stok_miktarı) {
        this.stok_miktari = stok_miktarı;
    }

    public String StokEkleme(String urunad, String renk, int birimmali, int satısfiyat, int stokmiktar) {
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        List<Depo> list=v.Verileri_Listeleme();
        for(Depo c:list){
           if(c.urun_adi.equals(urunad) && c.renk.equals(renk) && c.birim_maliyet==birimmali && c.satis_fiyat==stokmiktar){
               v.Guncelleme("stok_miktari", "", c.urun_id, c.stok_miktari+stokmiktar,1);
               return "Depoya malzemeniz eklendi.";
           } 
        }
        v.VeriEkleme(new Depo(0, urunad, renk, birimmali, satısfiyat, satısfiyat-birimmali, stokmiktar),0);
        return "Depoya malzemeniz eklendi.";
    }

    public String StokDurum(int id) { //eğer 0 girerse bütün stokları göster eğer belli bir id girerse sadece onu göster.
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        List<Depo> list = v.Verileri_Listeleme();
        if (id == 0) {
            for (Depo c : list) {
                return ("Ürün ID=" + c.urun_id + "\n, Ürün Adı=" + c.urun_adi
                        + "\nRengi=" + c.renk + "\nBirim Maliyet=" + c.birim_maliyet + "\nSatış Fiyatı="
                        + c.satis_fiyat + "\n Birim Kar=" + c.birim_kar + "\nStok Miktarı" + c.stok_miktari);
            }
        } else {
            for (Depo b : list) {
                if (b.urun_id == id) {
                    return ("Ürün ID=" + b.urun_id + "\nÜrün Adı=" + b.urun_adi
                        + "\nRengi=" + b.renk + "\nBirim Maliyet=" + b.birim_maliyet + "\nSatış Fiyatı="
                        + b.satis_fiyat + "\nBirim Kar=" + b.birim_kar + "\nStok Miktarı=" + b.stok_miktari); 
                }
            }
        }
        return "Aranan ID bulunamadı.";
        
    }

    public void StokSil(int id) {
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        v.Silme(id);
        
    }

    public String StokGüncelleme(String hangiOzellik, String ozellik1_deger, int id, int ozellik_deger, int kactane) {
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        List<Depo> a=v.Verileri_Listeleme();
        if(hangiOzellik.equals("satis_fiyat")){
            for(Depo c:a){
                if(c.urun_id==id){
                    v.Guncelleme("birim_kar", "", id, ozellik_deger-c.birim_maliyet, 0);
                    v.Guncelleme(hangiOzellik, ozellik1_deger, id, ozellik_deger, kactane);
                    return "İşlem Başarılı";
                }
            }
            
            
        }
        if(hangiOzellik.equals("birim_maliyet")){
           for(Depo c:a){
                if(c.urun_id==id){
                    v.Guncelleme("birim_kar", "", id, c.satis_fiyat-ozellik_deger, 0);
                    v.Guncelleme(hangiOzellik, ozellik1_deger, id, ozellik_deger, kactane);
                    return "İşlem Başarılı";
                }
            } 
        }
        if(hangiOzellik.equals("urun_id") || hangiOzellik.equals("urun_adi") || hangiOzellik.equals("renk") || hangiOzellik.equals("birim_kar")){
            return "Bu verilerde değişiklik yapılamaz.";
        }
        
        if(hangiOzellik.equals("stok_miktari")){
        v.Guncelleme(hangiOzellik, ozellik1_deger, id, ozellik_deger, kactane);
        return "İşlem Başarılı";
        }
        return "İşlem Başarısız";
        
        
        //Bu metodla defolu çıkan ürünleride burdan girip hallederiz ona göre gider metodunu çalıştırıp
        //onların geliri olmadan sadece giderini hesaplarız arayüzde
    }

    public List DepoKontrol() { //Bu metodu çalıştırıp listedeki eleman sayısı kadar for döngüsüne sokup
                                         // o for döngüsündede BitenUrunSipariş metodunu çalıştırcaz.
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        List<Depo> list = v.Verileri_Listeleme();
        List<Depo> BitenUrunler=new ArrayList<>();
        for (Depo c : list) {
            if (c.stok_miktari == 0) {
                System.out.println(c.urun_id + " ürünün stoğu bitmiştir.");
                BitenUrunler.add(c);
            }
        }
        return BitenUrunler;
    }
    public void Siparis(int id, int stok) {
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        List<Depo> list = v.Verileri_Listeleme();
        for (Depo c : list) {
            if (c.urun_id == id) {
                StokGüncelleme("stok_miktari", "", id, stok, 1);
            }
        }
    }

    @Override
    public int gelir(int tc) {
        return 0;
    }

    @Override
    public int gider(int tc) { //0 ise tüm gider bir id verilirse onun gideri
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        List<Depo> list = v.Verileri_Listeleme();
        int gider = 1;
        if (tc == 0) {
            for (Depo c : list) {
                gider = gider*(c.birim_maliyet * c.stok_miktari);
            }
            return gider;
        } else {
            for (Depo c : list) {
                if (c.urun_id == tc) {
                    return c.birim_maliyet * c.stok_miktari;
                }
            }
        }
        return gider;
    }
    @Override
    public int kar_zarar(int tc) {
        return gelir(tc) - gider(tc);
    }
    /*
    public int DefoluMal(){  //Defolu malları stoktan düşerek bize giderlerini dönen fonksiyon
        int gider=0;
        int geciciToplam=0;
        Random r=new Random();
        SqlVeriIslemleriDepo v = new SqlVeriIslemleriDepo();
        List<Depo> list = v.Verileri_Listeleme();
        for(Depo c:list){System.out.println("");
          int toplam=c.stok_miktari;
          geciciToplam=(c.stok_miktari*2)/1000;
          if(geciciToplam!=0){
          System.out.println(c.stok_miktari+"yüzde 1:"+geciciToplam);
          int defolu=r.nextInt(geciciToplam);
          System.out.println("defolu:"+defolu);
          gider=defolu*c.birim_maliyet;
          StokGüncelleme("stok_miktari", "", c.urun_id,toplam-defolu ,1);  
          }
           
        }
        return gider;
    }
*/

    @Override
    public String toString() {
        return "Depo{" + "urun_adi=" + urun_adi + ", renk=" + renk + ", urun_id=" + urun_id + ", birim_maliyet=" + birim_maliyet + ", satis_fiyat=" + satis_fiyat + ", birim_kar=" + birim_kar + ", stok_miktari=" + stok_miktari + "}"+"\n";
    }

    @Override
    public void MaliVeriEkleme(int gun) {
        SqlVeriİSlemleriMali v=new SqlVeriİSlemleriMali();
        v.VeriEkleme(new Depo(gun),0);
    }

    
}
