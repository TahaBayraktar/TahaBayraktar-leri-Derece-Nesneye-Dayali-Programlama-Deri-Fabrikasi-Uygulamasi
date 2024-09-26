/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nesneproje;

import Sql.SqlVeriİSlemleriMali;
import Sql.SqlVeriIslemleriCalisan;
import java.awt.BorderLayout;
import java.util.List;
public class Yonetici extends Calisan implements Mali {

    public Yonetici() {
    }
    public Yonetici(long Tc, String sifre,String ulke, String isim,String soyad, String TelefonNo, int maas, int OrtalamaCalısmaSaati) {
        
        this.Tc = Tc;
        this.ulke=ulke;
        this.isim = isim;
        this.sifre=sifre;
        this.soyad = soyad;
        this.TelefonNo = TelefonNo;
        this.mevki = "Yönetici";
        this.maas = maas;
        this.OrtalamaCalısmaSaati = OrtalamaCalısmaSaati;
    }
    public Yonetici(int gun){
        this.gun=gun;
    }
    public Yonetici(int islem_id,int gun,String departman,int gelir,int gider,int kar_zarar){
        this.islem_id=islem_id;
        this.gun=gun;
        this.departman=departman;
        this.gelir=gelir;
        this.gider=gider;
        this.kar_zarar=kar_zarar;   
    }

    @Override
    public int Verimlilik(long tc) {  //Çalışma saatini 1 güne bölerek hesaplanıyor.
        int verimlilik = 0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        for (Calisan c : list ) {
            if (c.Tc == tc) {
                verimlilik = (c.OrtalamaCalısmaSaati * 100) / 24;
            }
        }
        return verimlilik;
    }

    @Override
    public String GununElemanı() {
        int gününElemanı = 0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        for (Calisan c : list) {
            if (gününElemanı < c.OrtalamaCalısmaSaati) {
                gününElemanı = c.OrtalamaCalısmaSaati;
            }
        }
        for (Calisan b : list) {
            if (gününElemanı == b.OrtalamaCalısmaSaati) {
                return CalisaniBul(b.Tc);
            }
        }
        return "Tanımlanmadı.";

    }

    @Override
    public String CalisaniBul(long tc) {
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        if(tc==0){
            for (Calisan c : list) {
            if (c.Tc == tc) {
                return  "<html>" + c.isim + " " + c.soyad + "<br>Günlük Ortalaması: " + c.OrtalamaCalısmaSaati + "</html>";
            }
        }
        }
        for (Calisan c : list) {
            if (c.Tc == tc) {
                return   "★ "+c.isim + "" + c.soyad  ;
            }
        }
        return "Eleman bulunamamıştır";
    }

    

    

    @Override
    public int gelir(int tc) {
        int gelir=0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        if(tc==0){
          
        for(Calisan c:list){
            if(c.mevki.equals("Yönetici")){
                gelir+=c.OrtalamaCalısmaSaati*1000;
            }
        }
        System.out.print("Toplam gelir:");
        return gelir;  
        }
        else{
            for(Calisan c:list){
                if(c.mevki.equals("Yönetici")&& c.Tc==tc){
                    System.out.print(c.isim+" "+c.soyad+":");
                    gelir=c.OrtalamaCalısmaSaati*1000;
                }
            }
        }
        return gelir;  
    }

    @Override
    public int gider(int tc) {
        int gider=0;
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
        if(tc==0){
          
        for(Calisan c:list){
            if(c.mevki.equals("Yönetici")){
                
                gider+=c.maas;
            }
        }
        System.out.print("Toplam gider:");
        return gider;  
        }
        else{
            for(Calisan c:list){
                if(c.mevki.equals("Yönetici")&& c.Tc==tc){
                    System.out.print(c.isim+" "+c.soyad+":");
                    gider=c.maas;
                }
            }
        }
        return gider;
    }

    @Override
    public int kar_zarar(int tc) {
        return gelir(tc)-gider(tc);
    }
     @Override
    public String BilgiGuncelle(long tc, int ozellik_deger, String ozellik1_deger, String hangiOzellik, int kactane) {
       SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan(); 
        v.GuncellemeCalisan(hangiOzellik,ozellik1_deger,tc,ozellik_deger,kactane);
        return "İşlem Başarılı";
    }
    @Override
    public String MaasGuncelle(long tc,int maas){
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
            v.GuncellemeCalisan("mas","",tc,maas,1);
            return "İşlem Başarılı";
    }
    @Override
    public String İstenCıkarım(long tc){
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        String cıkarılan=CalisaniBul(tc);
        v.SilmeCalisan(tc);
        return cıkarılan;
    }

    @Override
    public String İsealma(long tc,String ulke,String isim,String sifre,String soyad,String TelefonNo, int maas, int OrtalamaCalısmaSaati,String mevki) {
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        int kontrol=0;
        List<Calisan> varmi=v.Verileri_Listeleme();
        for(Calisan c:varmi){
            if(c.Tc==tc){
                kontrol++;
            }
        }
        if(mevki.equals("Yönetici" )&& kontrol==0 ){
            if( tc>9999999999L && tc<100000000000L){
                v.VeriEkleme(new Yonetici(tc,sifre,ulke,isim,soyad,TelefonNo,maas,OrtalamaCalısmaSaati),0);
                return "İşlem Başarılı.";
            }
            return "Girilen TC 11 Haneli Olmak Zorundadır.";
            
            
            
        }
        if(mevki.equals("Personel")&& kontrol==0 ){
            if( tc>9999999999L && tc<100000000000L){
              v.VeriEkleme(new Personel(tc,sifre,ulke,isim,soyad,TelefonNo,maas,OrtalamaCalısmaSaati),0);
                return "İşlem Başarılı.";  
            }
            return "Girilen TC 11 Haneli Olmak Zorundadır.";
            
        }
        return "Girdiğiniz TC Başka Bir Balışana Ait.";
       
        
    }   
       
        
    

    @Override
    public void MaliVeriEkleme(int gun) {
        SqlVeriİSlemleriMali v=new SqlVeriİSlemleriMali();
        v.VeriEkleme(new Yonetici(gun),0);
    } 

    @Override
    public List TumCalısanGoster() {
        SqlVeriIslemleriCalisan v = new SqlVeriIslemleriCalisan();
        List<Calisan> list = v.Verileri_Listeleme();
            for (Calisan c : list) {
               return list;
// System.out.println("Calisan{"  +", tc=" + c.Tc + ", isim=" + c.isim +  ", şifre=" + c.sifre +", soyad=" + c.soyad + ", TelefonNo=" + c.TelefonNo + ", mevki=" + c.mevki + ", maas=" + c.maas + ", OrtalamaCal\u0131smaSaati=" + c.OrtalamaCalısmaSaati + '}'); 
        }
            return list;
    }
}
