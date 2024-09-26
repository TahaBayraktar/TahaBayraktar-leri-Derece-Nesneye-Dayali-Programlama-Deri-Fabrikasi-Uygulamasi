/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AbstractFactory;


import AbstractFactory.Uretim;
import AbstractFactory.Depo;
import AbstractFactory.TurkiyeSuniFactory;
import AbstractFactory.TurkiyeSuetFactory;
import AbstractFactory.AmerikaSuniFactory;
import AbstractFactory.AmerikaSuetFactory;
import AbstractFactory.UretimPage;
import Sql.SqlVeriIslemleriDepo;
import Sql.SqlVeriIslemleriUlasım;
import Sql.SqlVeriIslemleriUretim;
import TemplateMethod.DenizYoluUlasım;
import TemplateMethod.HavaYoluUlasım;
import TemplateMethod.KaraYoluUlasım;
import TemplateMethod.UlasımYap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import nesneproje.Calisan;
import nesneproje.LoginPage;
import nesneproje.Personel;
import nesneproje.Yonetici;

/**
 *
 * @author w10
 */
public class NesneProje {
    public static void main(String[] args) {
      
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalisanPage calisan = new CalisanPage("Yönetici");
                UretimPage uretimPage = new UretimPage();
                LoginPage login = new LoginPage();
                SatisPage satis = new SatisPage();
                JTable uretimTablo = uretimPage.jTable2;
                JTable depoTablo = uretimPage.jTable3;
                SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
                SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
                List<Uretim> veri = v.Verileri_Listeleme();
                List<Depo> depoVeri = d.Verileri_Listeleme();
                DefaultTableModel dfTable = (DefaultTableModel) uretimTablo.getModel();
                DefaultTableModel dfTableD = (DefaultTableModel) depoTablo.getModel();
                
                for (Uretim c : veri) {
                    Object[] obj = {c.uretim_id,c.urun_id,Character.toUpperCase(c.ulke.charAt(0)) + c.ulke.substring(1),Character.toUpperCase(c.urun_ad.charAt(0)) + c.urun_ad.substring(1),Character.toUpperCase(c.urun_renk.charAt(0)) + c.urun_renk.substring(1),c.satılan_miktar,c.maliyet};
                    dfTable.addRow(obj);   
                }
                for (Depo c : depoVeri) {
                    Object[] obj = {c.urun_id,Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1),Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1),c.birim_maliyet,c.satis_fiyat,c.birim_kar,c.stok_miktari};
                    dfTableD.addRow(obj);   
                }
                      
                    login.setVisible(true);  
                    
            }
        });
        
     
        
        
       
        

/*
       
        //v.createCategory(new Yonetici(42109312,"mehmet","Bayraktar","5537828242",23322,12));
        //v.createCategory(new Personel(100322598,"Naber","Bayraktar","5537828242",23322,5));
        //List<Calisan> list=v.Verileri_Listeleme();
        //for(Calisan c:list){
         //   System.out.println(c);
        //}
        Yonetici y=new Yonetici();
        Personel p =new Personel();
        //System.out.println(y.CalisaniBul(42109312));
       // y.GununElemanı();
        //System.out.println(p.Verimlilik(100322592));
       // p.GununElemanı();
       // System.out.println(y.gider(0));
       // System.out.println(y.gelir(0));
        
        //y.İstenCıkarım(100322595);
       // p.MaasGuncelle(1412412515,823);
       // p.BilgiGuncelle(100322592, 0, "erhan", "isim", 1);
       // System.out.println(p.kar_zarar(100322594));
       // p.CalisaniBul(100322592);
        Depo d=new Depo();
        //System.out.println(d.kar_zarar(3));
        //System.out.println(d.DefoluMal());
        Satis s=new Satis();
        //System.out.println(s.kar_zarar(0));
        //p.MaliVeriEkleme(1);
        //y.MaliVeriEkleme(1);
        //y.MaliVeriSil(1);
        //System.out.println(p.MaliVeriDüzenle("gun","",3,8,1));
        //s.MaliVeriEkleme(5);
       // d.MaliVeriEkleme(4);
       //y.İsealma(32132, "ceyda", "1234", "sönmez", "asdasdas", 321321, 3213213,"Yönetici");
       //p.İsealma(1, "taha", "12345", "bayraktar", "asdasdas", 321321, 3213213,"");
       //y.BilgiGuncelle(1, 5, "", "sifre", 0);
       //y.İstenCıkarım(1);
       //(y.İstenCıkarım(32132);
       TurkiyeSuniFactory ts=new TurkiyeSuniFactory();
      AmerikaSuniFactory as=new AmerikaSuniFactory();
      TurkiyeSuetFactory tsu=new TurkiyeSuetFactory();
      AmerikaSuetFactory asu=new AmerikaSuetFactory();
       //d.StokEkleme("suni", "halil", 3, 54, 2, 102);
       //d.StokEkleme("suni", "Haso", 3,54, 2, 100);
       //ISuetDeri turkiyeSuet=tsu.Suetderiyap("mavi", 31, 1,1);
       //ISuetDeri amerikaSuet=asu.Suetderiyap("ceyda", 40, 5,1);

      // ISuniDeri turkiyeSuni=ts.Sunideriyap("ceyda", 41, 4,2);
      
       
       
       
      
      //ISuniDeri amerikaSuni=as.Sunideriyap("ceyda", 41, 10,3);
      // d.StokEkleme("suet", "mor", 3, 54, 2,2);
       Uretim u=new Uretim();
       u.UretimSil(6);
       //y.İsealma(423, "turkiye", "taha", "1234", "dadas", "dasda", 32, 52131, "Personel");
       
       
       //s.SatisEkleme("taha", "ceyda", "naber", "öyle", "hiihi", "hahaha", 90, 42, 514);
       
      // s.SatisBilgi(4);
     // u.UretimGuncelle("uretilen_miktar", "", 5, 52, 0);
//p.İsealma(3213, "dsa", "dsaasa","adsdsa", "dassa", "dsasd", 123, 32132,"" );
   // Uretim u=new Uretim();
   // u.UretimGuncelle("uretilen_miktar", "", 8, 20, 0);
//p.İsealma(1234, "turkiye", "taha", "1234", "bayraktar", "0342132", 32, 32132, "Personel");
//y.İsealma(5678, "amerika", "halil", "4321", "ağca", "512332", 37, 7423, "Yönetici");
//u.UretimGuncelle("urun_id", "", 7, 51, 0);
//s.SatisEkleme(15, "daadsa", "sdadsa", "adadsa", "sadsadsa", "dsadas", "Deniz", 100, 3213, 10);
DenizYoluUlasım kl=new DenizYoluUlasım();
//System.out.println(kl.KargoPaketle(1));
//System.out.println(kl.KargoyuGotur(1,kl.KargoPaketle(1)));
//System.out.println(kl.KargoyuYukle(kl.KargoPaketle(1)));
HavaYoluUlasım h=new HavaYoluUlasım();
KaraYoluUlasım k=new KaraYoluUlasım();
//s.SatisEkleme(14, "dasdsa", "sdaas", "dsadas", "sadsa", "dsadsa", "Hava", 14, 323, 3);
h.run(5,102);
//h.UlasımGuncelle("ulasım_yolu", "deniz", 4, 0, 0);

kl.UlasımGuncelle("ulasım_maliyet","", 8, 2650, 0);
*/










      
      
      
      
      
      
      
      
      
      
      
       
       
       
          
       
       
       
       
      
       
       
      
       
       
    }
}
