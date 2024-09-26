/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import AbstractFactory.AmerikaSuet;
import AbstractFactory.AbstractSuetFactory;
import Sql.SqlVeriIslemleriUretim;
import Sql.SqlVeriIslemleriDepo;
import java.util.List;

/**
 *
 * @author taha
 */
public class AmerikaSuetFactory extends Uretim implements AbstractSuetFactory {
    private int gun;
    private int SuetBirimMaliyet;
    public AmerikaSuetFactory(){
        this.SuetBirimMaliyet=4;
    }
    @Override
    public ISuetDeri Suetderiyap(String renk, int id, int istenen_miktar,int gun) {
        SqlVeriIslemleriDepo v=new SqlVeriIslemleriDepo();
        SqlVeriIslemleriUretim u=new SqlVeriIslemleriUretim();
        Uretim ur=new Uretim();
        List<Depo> veriDepo=v.Verileri_Listeleme();
        List<Uretim> veriUretim=u.Verileri_Listeleme();
        for(Depo c:veriDepo){
            if(c.urun_id==id && c.urun_adi.equals("suet") && c.renk.equals(renk) && c.stok_miktari>= istenen_miktar){
                for(Uretim a:veriUretim){
                    if(a.urun_id==id && a.ulke.equals("amerika")){
                        
                       ur.UretimGuncelle("uretilen_miktar","",a.uretim_id,a.satılan_miktar+istenen_miktar,0);
                       ur.UretimGuncelle("maliyet", "", a.uretim_id, a.maliyet+(istenen_miktar*SuetBirimMaliyet), gun);
                        return new AmerikaSuet(renk,id,istenen_miktar); 
                        
                    }
                   
                }
                StokGüncelleme("stok_miktari", "", id, c.stok_miktari-istenen_miktar, 0); 
                        System.out.println(c.urun_adi+" ürününden "+istenen_miktar+" kadar gün sonuna kadar "
                        + "üretim yapılmıştır.");
                        u.VeriEkleme(new AmerikaSuet(renk,id,istenen_miktar), SuetBirimMaliyet*istenen_miktar);
                        return new AmerikaSuet(renk,id,istenen_miktar); 
            }
        }
        System.out.println("Ham madde yetersizliğinden üretim yapılamaz.");
        return null;
    }
}

