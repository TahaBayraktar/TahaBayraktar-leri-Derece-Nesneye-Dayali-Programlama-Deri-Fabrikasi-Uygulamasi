/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import java.util.List;

/**
 *
 * @author taha
 */
public class AmerikaSuni extends Depo implements ISuniDeri {
    private String renk;
    private int istenen_miktar;
    private int id;
    private int SuniBirimMaliyet=2;
    private String ad;
    private String ulke;
    private int urun_id;
    private int maliyet;

    public AmerikaSuni(String renk, int id, int istenen_miktar) {
        this.renk = renk;
        this.istenen_miktar = istenen_miktar;
        this.id = id;
    }

    public AmerikaSuni(String renk, int istenen_miktar, int id, String ad, String ulke, int urun_id, int maliyet) {
        this.renk = renk;
        this.istenen_miktar = istenen_miktar;
        this.id = id;
        this.ad = "suni";
        this.ulke = "amerika";
        this.urun_id = urun_id;
        this.maliyet = maliyet;
    }
    

   
    
   @Override
    public String getRenk() {
       return renk;
    }

    @Override
    public int getid() {
        return id;
    }

    @Override
    public int getistenen_miktar() {
        return istenen_miktar;
    }
   

    
}
