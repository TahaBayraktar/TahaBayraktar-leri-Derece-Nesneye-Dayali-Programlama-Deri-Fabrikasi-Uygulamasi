/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import AbstractFactory.ISuniDeri;
import java.util.List;

/**
 *
 * @author taha
 */
public class TurkiyeSuni extends Depo implements ISuniDeri {
    private String renk;
    private int istenen_miktar;
    private int id;
   
   

    public TurkiyeSuni(String renk, int id, int istenen_miktar) {
        this.renk = renk;
        this.istenen_miktar = istenen_miktar;
        this.id = id;
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
