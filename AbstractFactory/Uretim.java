/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import AbstractFactory.Depo;
import Sql.SqlVeriIslemleriDepo;
import Sql.SqlVeriIslemleriUretim;
import java.util.List;
import nesneproje.Mali;

/**
 *
 * @author taha
 */
public class Uretim extends Depo implements Mali {

    protected int uretim_id;
    protected int urun_id;
    protected String urun_ad;
    protected String urun_renk;
    protected String ulke;
    protected int satılan_miktar;
    protected int maliyet;

    public Uretim(int uretim_id, int urun_id, String urun_ad, String urun_renk,
            String ulke, int satılan_miktar, int maliyet) {
        this.uretim_id = uretim_id;
        this.urun_id = urun_id;
        this.urun_ad = urun_ad;
        this.urun_renk = urun_renk;
        this.ulke = ulke;
        this.satılan_miktar = satılan_miktar;
        this.maliyet = maliyet;
    }

    public Uretim() {

    }

    public int getUretim_id() {
        return uretim_id;
    }

    public void setUretim_id(int uretim_id) {
        this.uretim_id = uretim_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public String getUrun_ad() {
        return urun_ad;
    }

    public void setUrun_ad(String urun_ad) {
        this.urun_ad = urun_ad;
    }

    public String getUrun_renk() {
        return urun_renk;
    }

    public void setUrun_renk(String urun_renk) {
        this.urun_renk = urun_renk;
    }

    public int getSatılan_miktar() {
        return satılan_miktar;
    }

    public void setSatılan_miktar(int satılan_miktar) {
        this.satılan_miktar = satılan_miktar;
    }

    public int getMaliyet() {
        return maliyet;
    }

    public void setMaliyet(int maliyet) {
        this.maliyet = maliyet;
    }
    // public void UretimGuncel(String hangiOzellik, String ozellik1_deger, int uretim_id, int ozellik_deger, int kactane){
    //    SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
    //     v.Guncelleme(hangiOzellik, ozellik1_deger, uretim_id, ozellik_deger, kactane);
    // }

    public String UretimGuncelle(String hangiOzellik, String ozellik1_deger, int uretim_id, int ozellik_deger, int kactane) {
        SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
        SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
        List<Depo> veri = d.Verileri_Listeleme();
        List<Uretim> a = UretimleriGöster();
        if (hangiOzellik.equals("uretilen_miktar")) {
            for (Uretim b : a) {
                if (uretim_id == b.uretim_id) {
                    for (Depo c : veri) {
                        if (c.urun_id == b.urun_id) {
                            int sayı = (b.satılan_miktar - ozellik_deger);
                            if (sayı < 0) {
                                sayı = -sayı;
                            }
                            if (ozellik_deger >= b.satılan_miktar) {
                                if (sayı <= c.stok_miktari && b.satılan_miktar != ozellik_deger) {
                                    StokGüncelleme("stok_miktari", "", c.urun_id, c.stok_miktari - sayı, kactane);
                                    v.Guncelleme(hangiOzellik, ozellik1_deger, uretim_id, ozellik_deger, kactane);

                                    return "İşlem Başarılı.";
                                } else {
                                    return "Üretim ham madde yetersizliğinden yapılamaz.";
                                }
                            }
                            else{
                                StokGüncelleme("stok_miktari", "", c.urun_id, c.stok_miktari + sayı, kactane);
                                v.Guncelleme(hangiOzellik, ozellik1_deger, uretim_id, ozellik_deger, kactane);
                                return "İşlem Başarılı";
                            }

                        }
                    }
                }
            }
        } else if (hangiOzellik.equals("urun_adı")) {
            return "Güncelleme yapılamaz.";
        } else if (hangiOzellik.equals("urun_renk")) {
            return "Güncelleme yapılamaz.";
        } else if (hangiOzellik.equals("urun_id")) {
            for (Depo c : veri) {
                if (c.urun_id == ozellik_deger) {
                    for (Uretim b : a) {
                        if (b.uretim_id == uretim_id && b.uretim_id == uretim_id && c.stok_miktari >= b.satılan_miktar && b.urun_id != ozellik_deger) {
                            StokGüncelleme("stok_miktari", "", c.urun_id, c.stok_miktari - b.satılan_miktar, 0);
                            for(Depo u:veri){
                                if(u.urun_id==b.urun_id){
                                    StokGüncelleme("stok_miktari","",u.urun_id,u.stok_miktari+b.satılan_miktar,0);
                                }
                            }
                            
                            
                            v.Guncelleme(hangiOzellik, ozellik1_deger, uretim_id, ozellik_deger, kactane);
                            v.Guncelleme("urun_adı", c.urun_adi, uretim_id, 0, 0);
                            v.Guncelleme("urun_renk", c.renk, uretim_id, 0, 0);
                            return "İşlem Başarılı.";
                        }
                    }
                }
                

            }
        } else if (hangiOzellik.equals("uretim_id")) {
            return "Güncelleme yapılamaz.";
        } else {
            v.Guncelleme(hangiOzellik, ozellik1_deger, uretim_id, ozellik_deger, kactane);
            return "İşlem Başarılı.";
        }
        return "İşlem Başarısız.";
    }

    public List UretimleriGöster() {
        SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
        List<Uretim> veri = v.Verileri_Listeleme();
        for (Uretim c : veri) {
            // System.out.println("Uretim{" + ", uretimId=" + c.uretim_id + ", urunId=" + c.urun_id + ", urunAd=" + c.urun_ad + ", ülke=" + c.ulke + ", urun rengi=" + c.urun_renk + ", satılan miktar=" + c.satılan_miktar + ", maliyet=" + c.maliyet + '}');

        }
        return veri;
    }

    public String SatısUretimGuncelle(String hangiOzellik, String ozellik1_deger, int uretim_id, int ozellik_deger, int kactane) {
        SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
        v.Guncelleme(hangiOzellik, ozellik1_deger, uretim_id, ozellik_deger, kactane);
        return "İşlem Başarılı.";
    }

    public void UretimSil(int uretim_id) {
        SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
        SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
        List<Uretim> veri = v.Verileri_Listeleme();
        List<Depo> veri2 = d.Verileri_Listeleme();
        for (Uretim c : veri) {
            if (c.uretim_id == uretim_id) {

                for (Depo b : veri2) {

                    if (c.urun_id == b.urun_id) {

                        StokGüncelleme("stok_miktari", "", b.urun_id, b.stok_miktari + c.satılan_miktar, 0);

                    }
                }
            }
        }
        v.Silme(uretim_id);

    }

    @Override
    public int gelir(int tc) {
        return 0;

    }

    @Override
    public int gider(int tc) {
        int gider = 0;
        SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
        List<Uretim> list = v.Verileri_Listeleme();
        for (Uretim c : list) {
            if (tc == 0) {
                gider += c.satılan_miktar * c.maliyet;

            } else if (tc != 0) {
                if (c.uretim_id == tc) {
                    gider += c.satılan_miktar * c.maliyet;
                }
            }

        }
        return gider;
    }

    @Override
    public int kar_zarar(int tc) {
        return gelir(tc) - gider(tc);
    }

    @Override
    public void MaliVeriEkleme(int gun) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object[] toArray() {
        return new Object[]{uretim_id, urun_id, urun_ad, urun_renk, ulke, satılan_miktar, maliyet};
    }

}
