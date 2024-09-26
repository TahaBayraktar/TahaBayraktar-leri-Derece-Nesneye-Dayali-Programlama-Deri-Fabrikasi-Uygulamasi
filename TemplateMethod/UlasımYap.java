/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

import AbstractFactory.Satis;
import Sql.SqlVeriIslemleriSatis;
import Sql.SqlVeriIslemleriUlasım;
import java.util.List;

/**
 *
 * @author taha
 */
public abstract class UlasımYap  {

    public UlasımYap() {
    }

    public final String run(int satis_id, int satılan_desi){
        int paket=KargoPaketle(satis_id,satılan_desi);
        KargoyuGotur(satis_id,paket);
        KargoyuYukle(paket);
        KargoUlasımYap(satis_id);
        KargoTeslimat(satis_id,satılan_desi);
        KargoTeslimEdildimi();
        return "Teslimat İçin Başarıyla Eklenmiştir.";
    }
    
    
    

    public int KargoPaketle(int satis_id,int satılan_desi) {    //Ortak
        int saglama = 0;
        int miktar = 0;
        int PaketKargo = 0;
        SqlVeriIslemleriSatis s = new SqlVeriIslemleriSatis();
        List<Satis> veri = s.Verileri_Listeleme();
        for (Satis c : veri) {

            if (satis_id == c.getSatis_id()) {
                miktar = satılan_desi;

            }
        }
        PaketKargo = miktar / 10;

        saglama = miktar % 10;
        if (saglama != 0) {
            PaketKargo += 1;
        }
        return PaketKargo;
    }

    public abstract int KargoyuGotur(int satis_id, int paket);       //Farklı

    public abstract int KargoyuYukle(int kargo_sayısı);        //Farklı

    public abstract int KargoUlasımYap(int satis_id);      //Farklı

    public abstract String KargoTeslimat(int satis_id,int satılan_desi);          //Farklı

    public boolean KargoTeslimEdildimi() {
        SqlVeriIslemleriUlasım u = new SqlVeriIslemleriUlasım();
        List<UlasımYap> veri = u.Verileri_Listeleme();
        for (UlasımYap c : veri) {
            if (c.ulasim_id == ulasim_id && c.teslim_edildimi.equals("evet")) {
                return true;
            }
        }
        return false;
    }

    protected int ulasim_id;
    protected int satis_id;
    protected String sattigimiz_ulke;
    protected String satilan_urun;
    protected String satilan_renk;
    protected String firma_iletisim;
    protected String ulasım_yolu;
    protected String teslim_edildimi;
    protected int ulasım_yolu_uzaklık;
    protected int satilan_desi;
    protected int ulasım_maliyet;
    protected int tahmini_teslimat_gunu;
    protected int TurkiyelimanUzaklık = 30;
    protected int TurkiyeHavaAlanıUzaklık = 80;
    protected int TurkiyeKaraKargoUzaklık = 10;
    protected int AmerikalimanUzaklık = 30;
    protected int AmerikaHavaAlanıUzaklık = 80;
    protected int AmerikaKaraKargoUzaklık = 20;

    public int getUlasım_yolu_uzaklık() {
        return ulasım_yolu_uzaklık;
    }

    public void setUlasım_yolu_uzaklık(int ulasım_yolu_uzaklık) {
        this.ulasım_yolu_uzaklık = ulasım_yolu_uzaklık;
    }

    public int getUlasim_id() {
        return ulasim_id;
    }

    public void setUlasim_id(int ulasim_id) {
        this.ulasim_id = ulasim_id;
    }

    public int getSatis_id() {
        return satis_id;
    }

    public void setSatis_id(int satis_id) {
        this.satis_id = satis_id;
    }

    public String getSattigimiz_ulke() {
        return sattigimiz_ulke;
    }

    public void setSattigimiz_ulke(String sattigimiz_ulke) {
        this.sattigimiz_ulke = sattigimiz_ulke;
    }

    public String getSatilan_urun() {
        return satilan_urun;
    }

    public void setSatilan_urun(String satilan_urun) {
        this.satilan_urun = satilan_urun;
    }

    public String getSatilan_renk() {
        return satilan_renk;
    }

    public void setSatilan_renk(String satilan_renk) {
        this.satilan_renk = satilan_renk;
    }

    public String getFirma_iletisim() {
        return firma_iletisim;
    }

    public void setFirma_iletisim(String firma_iletisim) {
        this.firma_iletisim = firma_iletisim;
    }

    public String getUlasım_yolu() {
        return ulasım_yolu;
    }

    public void setUlasım_yolu(String ulasım_yolu) {
        this.ulasım_yolu = ulasım_yolu;
    }

    public String getTeslim_edildimi() {
        return teslim_edildimi;
    }

    public void setTeslim_edildimi(String teslim_edildimi) {
        this.teslim_edildimi = teslim_edildimi;
    }

    public int getSatilan_desi() {
        return satilan_desi;
    }

    public void setSatilan_desi(int satilan_desi) {
        this.satilan_desi = satilan_desi;
    }

    public int getUlasım_maliyet() {
        return ulasım_maliyet;
    }

    public void setUlasım_maliyet(int ulasım_maliyet) {
        this.ulasım_maliyet = ulasım_maliyet;
    }

    public int getTahmini_teslimat_gunu() {
        return tahmini_teslimat_gunu;
    }

    public void setTahmini_teslimat_gunu(int tahmini_teslimat_gunu) {
        this.tahmini_teslimat_gunu = tahmini_teslimat_gunu;
    }

    public abstract int KargoMaliyet(int satis_id,int satılan_desi);

    public String UlasımSil(int ulasim_id) {
        SqlVeriIslemleriUlasım u = new SqlVeriIslemleriUlasım();
        List<UlasımYap> veriUlasım = u.Verileri_Listeleme();
        for(UlasımYap c:veriUlasım){
            if(c.ulasim_id==ulasim_id && c.teslim_edildimi.toLowerCase().equals("evet")){
                u.Silme(ulasim_id);
                return "Başarılı";
            }
        }
        return "Seçtiğiniz Satır Teslim Edilmediği İçin Silinemez.";
    }

    public String UlasımGuncelle(String hangiOzellik, String ozellik1_deger, int ulasım_id, int ozellik_deger, int kactane) {
        SqlVeriIslemleriUlasım u = new SqlVeriIslemleriUlasım();
        SqlVeriIslemleriSatis s = new SqlVeriIslemleriSatis();
        List<Satis> veri = s.Verileri_Listeleme();
        List<UlasımYap> veriUlasım = u.Verileri_Listeleme();
        Satis o=new Satis();
        if (hangiOzellik.equals("satis_id")) {
             return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("ulasım_id")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("sattigimiz_ulke")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("satilan_urun")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("satilan_renk")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("firma_iletisim")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("ulasım_yolu")) {
            
            for(UlasımYap c:veriUlasım){
                
                if(c.ulasim_id==ulasım_id && ozellik1_deger.toLowerCase().equals("hava")&& c.teslim_edildimi.toLowerCase().equals("hayır") && !c.ulasım_yolu.equals(ozellik1_deger)){
               
                HavaYoluUlasım h=new HavaYoluUlasım();
                u.Guncelleme(hangiOzellik, ozellik1_deger, ulasım_id, ozellik_deger, kactane);
                
                for(Satis ca:veri){
                    if(c.satis_id==ca.getSatis_id()){
                        o.SatisDüzenleme("ulasım_yolu", "hava", c.satis_id, 0, 0);
                    }
                }
                u.Guncelleme("ulasım_maliyet", "", ulasım_id, h.KargoMaliyet(c.satis_id,c.satilan_desi), kactane);
                u.Guncelleme("tahmini_teslimat_gunu", "", ulasım_id, h.KargoUlasımYap(c.satis_id), kactane);
                return "İşlem Başarılı";
                
                }
                if(c.ulasim_id==ulasım_id && ozellik1_deger.toLowerCase().equals("deniz")&& c.teslim_edildimi.toLowerCase().equals("hayır") && !c.ulasım_yolu.equals(ozellik1_deger)){
                
                DenizYoluUlasım h=new DenizYoluUlasım();
                u.Guncelleme(hangiOzellik, ozellik1_deger, ulasım_id, ozellik_deger, kactane);
                
                for(Satis ca:veri){
                    if(c.satis_id==ca.getSatis_id()){
                        o.SatisDüzenleme("ulasım_yolu", "deniz", c.satis_id, 0, 0);
                    }
                }
                u.Guncelleme("ulasım_maliyet", "", ulasım_id, h.KargoMaliyet(c.satis_id,c.satilan_desi), kactane);
                u.Guncelleme("tahmini_teslimat_gunu", "", ulasım_id, h.KargoUlasımYap(c.satis_id), kactane);
                return "İşlem Başarılı";
                
                }
                
                if(c.ulasim_id==ulasım_id && ozellik1_deger.toLowerCase().equals("kara")&& c.teslim_edildimi.toLowerCase().equals("hayır") && !c.ulasım_yolu.equals(ozellik1_deger)){
                
                KaraYoluUlasım h=new KaraYoluUlasım();
                u.Guncelleme(hangiOzellik, ozellik1_deger, ulasım_id, ozellik_deger, kactane);
                
                for(Satis ca:veri){
                    if(c.satis_id==ca.getSatis_id()){
                        o.SatisDüzenleme("ulasım_yolu", "kara", c.satis_id, 0, 0);
                    }
                }
                u.Guncelleme("ulasım_maliyet", "", ulasım_id, h.KargoMaliyet(c.satis_id,c.satilan_desi), kactane);
                u.Guncelleme("tahmini_teslimat_gunu", "", ulasım_id, h.KargoUlasımYap(c.satis_id), kactane);
                return "İşlem Başarılı";
                }
                
                
                
            }
           
        }
        if (hangiOzellik.equals("teslim_edildimi")) {
            u.Guncelleme(hangiOzellik, ozellik1_deger, ulasım_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("ulasım_id")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("ulasım_yolu_uzaklık")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("satilan_desi")) {
            return "Bu Verilerde Değişiklik Yapılamaz.";
        }
        if (hangiOzellik.equals("ulasım_maliyet")) {
            u.Guncelleme(hangiOzellik, ozellik1_deger, ulasım_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("tahmini_teslimat_gunu")) {
            u.Guncelleme(hangiOzellik, ozellik1_deger, ulasım_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }

        return "İşlem Başarısız.";

    }

}
