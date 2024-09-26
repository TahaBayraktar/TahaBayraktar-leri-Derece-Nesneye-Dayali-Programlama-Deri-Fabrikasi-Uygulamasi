/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nesneproje;

import Sql.SqlVeriİSlemleriMali;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author w10
 */
public abstract class Calisan implements Mali{
    protected  long Tc;
    protected  String isim;
    protected  String soyad;
    protected String sifre;
    protected  String TelefonNo;
    protected  String mevki;
    protected  int maas;
    protected  int OrtalamaCalısmaSaati;
    protected int islem_id;
    protected String departman;
    protected int  gun;
    protected int gelir;
    protected int gider;
    protected int kar_zarar;
    protected String ulke;

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }
    

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    
    

    public long getTc() {
        return Tc;
    }

    public void setTc(long Tc) {
        this.Tc = Tc;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefonNo() {
        return TelefonNo;
    }

    public void setTelefonNo(String TelefonNo) {
        this.TelefonNo = TelefonNo;
    }

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getOrtalamaCalısmaSaati() {
        return OrtalamaCalısmaSaati;
    }

    public void setOrtalamaCalısmaSaati(int OrtalamaCalısmaSaati) {
        this.OrtalamaCalısmaSaati = OrtalamaCalısmaSaati;
    }
    
    public abstract String MaasGuncelle(long tc,int maas);
    public abstract  String BilgiGuncelle(long tc,int ozellik_deger,String ozellik1_deger,String hangiOzellik,int kactane);
    public abstract int Verimlilik(long a);
    public abstract String GununElemanı();
    public abstract String CalisaniBul(long tc);
    public abstract List TumCalısanGoster();
    public abstract String İstenCıkarım(long tc);
    public abstract String İsealma(long tc,String ulke,String isim,String sifre,String soyad,String TelefonNo, int maas, int OrtalamaCalısmaSaati,String mevki);
    public String MaliVeriSil(int islem_id) {
        SqlVeriİSlemleriMali v=new SqlVeriİSlemleriMali();
        List<Calisan> list=v.Verileri_Listeleme();
        for(Calisan c:list){
            if(c.islem_id==islem_id){
                v.Silme(islem_id);
                return "Mali("+"İşlem İD:"+c.islem_id+" ,işlem günü:"+c.gun
                       +" ,işlem departmanı"+c.departman+" ,gelir:"+c.gelir+" ,gider:"+c.gider+
                       " ,kar-zarar:"+c.kar_zarar+")";
            }
        }
        return "";
    }

  
    public String MaliVeriDüzenle(String hangiOzellik, String ozellik1_deger, int islem_id, int ozellik_deger, int kactane) {
         SqlVeriİSlemleriMali v=new SqlVeriİSlemleriMali();
         List<Calisan> list=v.Verileri_Listeleme();
        for(Calisan c:list){
            if(c.islem_id==islem_id){
                v.Guncelleme(hangiOzellik, ozellik1_deger, islem_id, ozellik_deger, kactane);
                return "Mali("+"İşlem İD:"+c.islem_id+" ,işlem günü:"+c.gun
                       +" ,işlem departmanı"+c.departman+" ,gelir:"+c.gelir+" ,gider:"+c.gider+
                       " ,kar-zarar:"+c.kar_zarar+")";
            }
        }
        return "";
    }

    
    public void MaliVeriDurum(int islem_id) {
        SqlVeriİSlemleriMali v=new SqlVeriİSlemleriMali();
        List<Calisan>list=v.Verileri_Listeleme();
        if(islem_id==0){
           for(Calisan c:list){
               System.out.println("Mali("+"İşlem İD:"+c.islem_id+" ,işlem günü:"+c.gun
                       +" ,işlem departmanı"+c.departman+" ,gelir:"+c.gelir+" ,gider:"+c.gider+
                       " ,kar-zarar:"+c.kar_zarar+")");
            } 
        }
        else{
            for(Calisan c:list){
                if(c.islem_id==islem_id){
                    System.out.println("Mali("+"İşlem İD:"+c.islem_id+" ,işlem günü:"+c.gun
                       +" ,işlem departmanı"+c.departman+" ,gelir:"+c.gelir+" ,gider:"+c.gider+
                       " ,kar-zarar:"+c.kar_zarar+")");
                }
            }
        }
        
    }

    @Override
    public String toString() {
        return "Calisan{" + "Tc=" + Tc + ", isim=" + isim + ", soyad=" + soyad + ", TelefonNo=" + TelefonNo + ", mevki=" + mevki + ", maas=" + maas + ", OrtalamaCal\u0131smaSaati=" + OrtalamaCalısmaSaati + '}';
    }
}
