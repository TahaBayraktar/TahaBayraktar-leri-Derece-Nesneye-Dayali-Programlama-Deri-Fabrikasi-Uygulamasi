/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nesneproje;

import Sql.SqlVeriİSlemleriMali;
import Sql.SqlVeriIslemleriCalisan;
import java.util.ArrayList;
import java.util.List;
public class Personel extends Calisan implements Mali{
    
    public Personel() {
    }
    public Personel(int gun){
        this.gun=gun;
    }
     public Personel(int islem_id,int gun,String departman,int gelir,int gider,int kar_zarar){
        this.islem_id=islem_id;
        this.gun=gun;
        this.departman=departman;
        this.gelir=gelir;
        this.gider=gider;
        this.kar_zarar=kar_zarar;   
    }
    
 public Personel(long Tc, String sifre,String ulke, String isim,String soyad, String TelefonNo, int maas, int OrtalamaCalısmaSaati) {
        
        this.Tc = Tc;
        this.ulke=ulke;
        this.isim = isim;
        this.sifre=sifre;
        this.soyad = soyad;
        this.TelefonNo = TelefonNo;
        this.mevki = "Personel";
        this.maas = maas;
        this.OrtalamaCalısmaSaati = OrtalamaCalısmaSaati;
    }
    
    
    @Override
    public int Verimlilik(long tc) {// Sistemde olmayan veri girildiğinde 0 oluyor.
        int verimlilik = 0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        for (Calisan c : list ) {
            if (c.Tc == tc && c.mevki.equals("Personel")) {
                verimlilik = (c.OrtalamaCalısmaSaati * 100) / 24;
                
            }
        }
        return verimlilik;
          
    }

    @Override
    public String GununElemanı() {
        int gününElemanı = 0;
        String a;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        for (Calisan c : list) {
            if (gününElemanı < c.OrtalamaCalısmaSaati && c.mevki.equals("Personel")) {
                gününElemanı = c.OrtalamaCalısmaSaati;
            }
        }
        for (Calisan b : list) {
            if (gününElemanı == b.OrtalamaCalısmaSaati && b.mevki.equals("Personel")) {
                return (CalisaniBul(b.Tc));
            }
        }
        return "Tanımlanmadı.";
    }

    @Override
    public String CalisaniBul(long tc) {// Bu metot sadece personel veya yönetici kendi bilgilerini erişecek şekilde değişecek.
                                        //Bu metodda kullanıcıdan tc alma giriş yaparken girdiği tcyi kullan.
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        for (Calisan c : list ) {
            if (c.Tc == tc && c.mevki.equals("Personel")) {
                return "Calisan{"  +"tc=" + c.Tc + ", isim=" + c.isim +  ", şifre=" + c.sifre +", soyad=" + c.soyad + ", TelefonNo=" + c.TelefonNo + ", mevki=" + c.mevki + ", maas=" + c.maas + ", OrtalamaCal\u0131smaSaati=" + c.OrtalamaCalısmaSaati + '}';
            }
        }
        return "Eleman bulunamamıştır";
    }
    @Override
    public int gider(int tc) {//Personele ait gider sadece yöneticilerin görmesi için 0 basılınca tüm personel 
                              // tc girilince belirli bir personel
        int gider=0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        if(tc==0){
          
        for(Calisan c:list){
            if(c.mevki.equals("Personel")){
                gider+=c.maas;
            }
        }
        System.out.print("Toplam gider:");
        return gider;  
        }
        else{
            for(Calisan c:list){
                if(c.mevki.equals("Personel")&& c.Tc==tc){
                    System.out.print(c.isim+" "+c.soyad+":");
                    gider=c.maas;
                }
            }
        }
        return gider;   
    }
    @Override
    public int gelir(int tc) { //Saatte 1000 tl kazandırdığını varsayıyorum.
                               // tc yi sıfır girerse toplamı elde ediyor
        int gelir=0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        if(tc==0){
        for(Calisan c:list){
            if(c.mevki.equals("Personel")){
                gelir+=c.OrtalamaCalısmaSaati*1000;
            }
        }
        System.out.print("Toplam gelir:");
        return gelir;  
        }
        else{
            for(Calisan c:list){
                if(c.mevki.equals("Personel")&& c.Tc==tc){
                    System.out.print(c.isim+" "+c.soyad+":");
                    gelir=c.OrtalamaCalısmaSaati*1000;
                }
            }
        }
        return gelir;  
    }

    @Override
    public int kar_zarar(int tc) { // 0 girilirse herkesinkini hesaplıyor
        return gelir(tc)-gider(tc);
    }

    @Override
    public String MaasGuncelle(long tc, int maas) {
       SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
       String Personelmi=Personelmi(tc);
       if(Personelmi.equals("evet")){
           v.GuncellemeCalisan("mas","",tc,maas,1);
           return "İşlem Başarılı";
       }
       else{
           return "Girdiğiniz tc bir personelle uyuşmamaktadır.";
       }
    }

    @Override
    public String BilgiGuncelle(long tc, int ozellik_deger, String ozellik1_deger, String hangiOzellik, int kactane) {
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        String Personelmi=Personelmi(tc);
       if(Personelmi.equals("evet")){
           v.GuncellemeCalisan(hangiOzellik,ozellik1_deger,tc,ozellik_deger,kactane);
           return "İşlem Başarılı";
       }
       else{
            return "Girdiğiniz tc bir personelle uyuşmamaktadır.";
       }  
    }

    
    private String Personelmi(long tc){
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        for(Calisan c:list){
            if(c.mevki.equals("Personel") && c.Tc==tc){
                return "evet";
            }
        }
        return "hayır";
    }
    
    @Override
    public String İsealma(long tc, String ulke,String isim, String sifre,String soyad, String TelefonNo, int maas, int OrtalamaCalısmaSaati, String mevki) {
       //Burda mevki parametresini kullanıcıdan isteme boş stringi otamatik sen ata
        int kontrol = 0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> varmı = v.Verileri_Listeleme();
        for (Calisan c : varmı) {
            if (c.Tc == tc) {
                kontrol++;
            }
        }
        if (kontrol == 0) {
            v.VeriEkleme(new Personel(tc, ulke, isim, sifre, soyad, TelefonNo, maas, OrtalamaCalısmaSaati), 0);
            return "İşlem Başarılı";
        }
        return "Girdiğiniz tc başka personele aittir.";

    }

    @Override
    public void MaliVeriEkleme(int gun) {
      SqlVeriİSlemleriMali v=new SqlVeriİSlemleriMali();
      v.VeriEkleme(new Personel(gun),0); 
    }
    @Override
    public List TumCalısanGoster() {
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        List<Calisan> personelList=new ArrayList();
            for (Calisan c : list) {
                if(c.mevki.equals("Personel")){
                    personelList.add(c);
                    
                    //System.out.println("Calisan{"  +"tc=" + c.Tc + ", isim=" + c.isim +  ", şifre=" + c.sifre +", soyad=" + c.soyad + ", TelefonNo=" + c.TelefonNo + ", mevki=" + c.mevki + ", maas=" + c.maas + ", OrtalamaCal\u0131smaSaati=" + c.OrtalamaCalısmaSaati + '}'); 
                }    
        }
            return personelList;
    }

    @Override
    public String İstenCıkarım(long tc) {
        String cıkarılan="Girdiğiniz tc bir personele ait değil";
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        for(Calisan c:list){
            if(c.mevki.equals("Personel") && c.Tc==tc){
            cıkarılan=CalisaniBul(tc);
            v.SilmeCalisan(tc);
            }
        }
        return cıkarılan; 
    }
 }

