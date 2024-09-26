/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import AbstractFactory.Depo;
import AbstractFactory.Uretim;
import Sql.SqlVeriİSlemleriMali;
import Sql.SqlVeriIslemleriSatis;
import Sql.SqlVeriIslemleriSatis;
import Sql.SqlVeriIslemleriUlasım;
import Sql.SqlVeriIslemleriUretim;
import Sql.SqlVeriIslemleriUretim;
import Sql.SqlVeriİSlemleriMali;
import TemplateMethod.UlasımYap;
import java.util.List;
import nesneproje.Mali;

/**
 *
 * @author w10
 */
public class Satis extends Uretim implements Mali {

    private int satis_id;
    private String satilan_ulke;
    private String sattigimiz_ulke;
    private String firma_adi;
    private String firma_vergi_no;
    private String firma_iletisim;
    private String satilan_urun;
    private String satilan_urun_renk;
    private String ulasım_yolu;
    private int ulasım_yolu_uzaklık;

    private int satilan_desi;
    private String odeme_turu;
    private int satis_fiyati;

    private int gun;

    public String getSattigimiz_ulke() {
        return sattigimiz_ulke;
    }

    public void setSattigimiz_ulke(String sattigimiz_ulke) {
        this.sattigimiz_ulke = sattigimiz_ulke;
    }

    public int getUlasım_yolu_uzaklık() {
        return ulasım_yolu_uzaklık;
    }

    public void setUlasım_yolu_uzaklık(int ulasım_yolu_uzaklık) {
        this.ulasım_yolu_uzaklık = ulasım_yolu_uzaklık;
    }

    public String getSatilan_ulke() {
        return satilan_ulke;
    }

    public void setSatilan_ulke(String satilan_ulke) {
        this.satilan_ulke = satilan_ulke;
    }

    public String getUlasım_yolu() {
        return ulasım_yolu;
    }

    public void setUlasım_yolu(String ulasım_yolu) {
        this.ulasım_yolu = ulasım_yolu;
    }

    public int getGun() {
        return gun;
    }

    public String getSatilan_urun_renk() {
        return satilan_urun_renk;
    }

    public void setSatilan_urun_renk(String satilan_urun_renk) {
        this.satilan_urun_renk = satilan_urun_renk;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public Satis(int satis_id, int uretim_id, String satilan_ulke, String sattigimiz_ulke, String firma_adi, String firma_vergi_no,
            String firma_iletisim, String satilan_urun, String satilan_urun_renk,
            String odeme_turu, String ulasım_yolu, int ulasım_yolu_uzaklık,
            int satis_fiyati, int satilan_desi) {
        this.satis_id = satis_id;
        this.uretim_id = uretim_id;
        this.satilan_ulke = satilan_ulke;
        this.sattigimiz_ulke = sattigimiz_ulke;
        this.firma_adi = firma_adi;
        this.firma_vergi_no = firma_vergi_no;
        this.firma_iletisim = firma_iletisim;
        this.satilan_urun = satilan_urun;
        this.satilan_urun_renk = satilan_urun_renk;
        this.ulasım_yolu = ulasım_yolu;
        this.ulasım_yolu_uzaklık = ulasım_yolu_uzaklık;
        this.satilan_desi = satilan_desi;
        this.odeme_turu = odeme_turu;
        this.satis_fiyati = satis_fiyati;

    }

    public Satis() {

    }

    public Satis(int gun) {
        this.gun = gun;
    }

    public int getSatis_id() {
        return satis_id;
    }

    public void setSatis_id(int satis_id) {
        this.satis_id = satis_id;
    }

    public String getFirma_adi() {
        return firma_adi;
    }

    public void setFirma_adi(String firma_adi) {
        this.firma_adi = firma_adi;
    }

    public String getFirma_vergi_no() {
        return firma_vergi_no;
    }

    public void setFirma_vergi_no(String firma_vergi_no) {
        this.firma_vergi_no = firma_vergi_no;
    }

    public String getFirma_iletisim() {
        return firma_iletisim;
    }

    public void setFirma_iletisim(String firma_iletisim) {
        this.firma_iletisim = firma_iletisim;
    }

    public String getSatilan_urun() {
        return satilan_urun;
    }

    public void setSatilan_urun(String satilan_urun) {
        this.satilan_urun = satilan_urun;
    }

    public int getSatılan_desi() {
        return satilan_desi;
    }

    public void setSatılan_desi(int satilan_desi) {
        this.satilan_desi = satilan_desi;
    }

    public String getOdeme_turu() {
        return odeme_turu;
    }

    public void setOdeme_turu(String odeme_turu) {
        this.odeme_turu = odeme_turu;
    }

    public int getSatis_fiyati() {
        return satis_fiyati;
    }

    public void setSatis_fiyati(int satis_fiyati) {
        this.satis_fiyati = satis_fiyati;
    }

    public String SatisBilgi(int satis_id) { // hiçbirşey yazılmassa tüm verileri döner
        SqlVeriIslemleriSatis v = new SqlVeriIslemleriSatis();
        List<Satis> list = v.Verileri_Listeleme();
        if (satis_id != 0) {
            for (Satis c : list) {
                if (c.satis_id == satis_id) {
                    return ("Depo{" + "satış İD=" + c.satis_id + ", firma adı=" + c.firma_adi + ", "
                            + "firma vergi no=" + c.firma_vergi_no + ", firma iletişim=" + c.firma_iletisim + ", satılan ürün="
                            + c.satilan_urun + ",  satılan ürün rengi:" + c.satilan_urun_renk + ",ödeme türü:" + c.odeme_turu + ", satılan desi=" + c.satilan_desi
                            + ", satış fiyatı=" + c.satis_fiyati + '}');
                }
            }

        } else {
            for (Satis b : list) {
                return ("Depo{" + "satış İD=" + b.satis_id + ", firma adı=" + b.firma_adi + ", "
                        + "firma vergi no=" + b.firma_vergi_no + ", firma iletişim=" + b.firma_iletisim + ", satılan ürün="
                        + b.satilan_urun + ",  satılan ürün rengi:" + b.satilan_urun_renk + ",ödeme türü" + b.odeme_turu + ", satılan desi=" + b.satilan_desi
                        + ", satış fiyatı=" + b.satis_fiyati + '}');
            }
        }
        return "";
    }

    public String SatisEkleme(int uretim_id, String sattigimiz_ulke, String firma_adi, String firma_vergi_no,
            String firma_iletisim,
            String odeme_turu, String ulasım_yolu, int ulasım_yolu_uzaklık,
            int satis_fiyati, int satilan_desi) {

        Uretim ur = new Uretim();
        SqlVeriIslemleriSatis v = new SqlVeriIslemleriSatis();
        List<Satis> sa = v.Verileri_Listeleme();
        SqlVeriIslemleriUretim u = new SqlVeriIslemleriUretim();
        List<Uretim> varmı = u.Verileri_Listeleme();
        for (Uretim c : varmı) {
            if (uretim_id == c.uretim_id) {
                for (Satis var : sa) {
                    if (var.uretim_id == uretim_id && var.firma_vergi_no.equals(firma_vergi_no.toLowerCase()) && var.satilan_ulke.equals(c.ulke) && c.satılan_miktar >= satilan_desi
                            && var.satis_fiyati==satis_fiyati &&var.ulasım_yolu.equals(ulasım_yolu)&& var.sattigimiz_ulke.equals(sattigimiz_ulke.toLowerCase())
                            ) {

                        SatisDüzenleme("satilan_desi", "", var.satis_id, satilan_desi + var.satilan_desi, 1);

                        return "Satış eklendi";
                    }

                }

                if (c.satılan_miktar >= satilan_desi) {
                    v.VeriEkleme(new Satis(0, uretim_id, c.ulke, sattigimiz_ulke.toLowerCase(), firma_adi.toLowerCase(), firma_vergi_no.toLowerCase(),
                            firma_iletisim.toLowerCase(), c.getUrun_ad(), c.getUrun_renk(),
                            odeme_turu.toLowerCase(), ulasım_yolu, ulasım_yolu_uzaklık,
                            satis_fiyati, satilan_desi), 0);
                    ur.SatısUretimGuncelle("uretilen_miktar", "", uretim_id, c.satılan_miktar - satilan_desi, gun);
                    return "Satış eklendi";
                }
                return "Yeterli miktarda üretim olmadığından eklenmemiştir.";
            }
        }
        return "Satış eklenemedi";

    }

    public String SatisDüzenleme(String hangiOzellik, String ozellik1_deger, int satis_id, int ozellik_deger, int kactane) {
        SqlVeriIslemleriSatis v = new SqlVeriIslemleriSatis();
        SqlVeriIslemleriUretim ur = new SqlVeriIslemleriUretim();
        Uretim u = new Uretim();
        List<Satis> s = v.Verileri_Listeleme();
        List<Uretim> stok = ur.Verileri_Listeleme();
        if (hangiOzellik.equals("satilan_desi")) {
            for (Satis c : s) {
                if (c.satis_id == satis_id) {
                    for (Uretim ca : stok) {
                        int sayi = ozellik_deger - c.satilan_desi;
                        if (sayi < 0) {
                            sayi = -sayi;
                        }
                        if (ozellik_deger > c.satilan_desi) {
                            if (c.uretim_id == ca.uretim_id && sayi <= ca.satılan_miktar) {
                                v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
                                u.SatısUretimGuncelle("uretilen_miktar", "", c.uretim_id, ca.satılan_miktar - (sayi), 1);
                                return "Başarılı";
                            }

                        } else {
                            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
                            System.out.println(sayi);
                            System.out.println(ca.satılan_miktar);

                            u.SatısUretimGuncelle("uretilen_miktar", "", c.uretim_id, ca.satılan_miktar + (sayi), 1);
                            return "Başarılı";
                        }

                    }
                }
            }
        }
        if (hangiOzellik.equals("satilan_urun")) {
            return "Bu özellik değiştirilemez.";
        }
        if (hangiOzellik.equals("uretim_id")) {
            for (Uretim o : stok) {
                if (ozellik_deger == o.uretim_id) {
                    for (Satis k : s) {
                        if (k.satis_id == satis_id && o.satılan_miktar >= k.satilan_desi && k.uretim_id != ozellik_deger) {
                            u.SatısUretimGuncelle("uretilen_miktar", "", o.uretim_id, o.satılan_miktar - k.satilan_desi, kactane);
                            for (Uretim ı : stok) {
                                if (k.uretim_id == ı.uretim_id) {
                                    u.SatısUretimGuncelle("uretilen_miktar", "", k.uretim_id, ı.satılan_miktar + k.satilan_desi, kactane);
                                }
                            }
                            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
                            v.Guncelleme("satilan_ulke", o.ulke, satis_id, 0, 0);
                            v.Guncelleme("satilan_urun", o.urun_ad, satis_id, 0, 0);
                            v.Guncelleme("satilan_urun_renk", o.urun_renk, satis_id, 0, 0);

                            return "Başarılı";
                        }
                    }
                }
            }
            return "İşlem Yapılamadı.";
        }
        if (hangiOzellik.equals("satis_id")) {
            return "Bu özellik değiştirilemez.";
        }
        if (hangiOzellik.equals("satilan_urun_renk")) {
            return "Bu özellik değiştirilemez.";
        }
        if (hangiOzellik.equals("satilan_ulke")) {
            return "Bu özellik değiştirilemez.";
        }
        if (hangiOzellik.equals("firma_adi")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("firma_vergi_no")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("firma_iletisim")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("odeme_turu")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("ulasım_yolu")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("satis_fiyati")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("sattigimiz_ulke")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        if (hangiOzellik.equals("ulasım_yolu_uzaklık")) {
            v.Guncelleme(hangiOzellik, ozellik1_deger, satis_id, ozellik_deger, kactane);
            return "İşlem Başarılı";
        }
        return "Başarılı";
    }

    public String SatisSil(int satis_id) {
        SqlVeriIslemleriSatis v = new SqlVeriIslemleriSatis();
        SqlVeriIslemleriUretim ur = new SqlVeriIslemleriUretim();
        SqlVeriIslemleriUlasım ul = new SqlVeriIslemleriUlasım();
        Uretim u = new Uretim();
        List<UlasımYap> veri = ul.Verileri_Listeleme();
        List<Satis> s = v.Verileri_Listeleme();
        List<Uretim> stok = ur.Verileri_Listeleme();
        for (Satis c : s) {
            if (c.satis_id == satis_id) {
                for (UlasımYap ula : veri) {
                    if (ula.getSatis_id() == satis_id && ula.getTeslim_edildimi().toLowerCase().equals("yok")) {
                        ul.Silme(ula.getUlasim_id());
                    }
                }
                for (Uretim ca : stok) {
                    if (c.uretim_id == ca.getUretim_id()) {
                        u.SatısUretimGuncelle("uretilen_miktar", "", c.uretim_id, ca.satılan_miktar + c.satilan_desi, 1);
                        v.Silme(satis_id);
                        return "Başarılı";
                    }
                }

            }
        }

        return "Silme işlemi gerçekleşmedi";
    }

    @Override
    public int gelir(int satis_id) {
        int gelir = 0;
        SqlVeriIslemleriSatis v = new SqlVeriIslemleriSatis();
        List<Satis> list = v.Verileri_Listeleme();
        if (satis_id == 0) {
            for (Satis c : list) {
                gelir += c.satis_fiyati;
            }
        } else {
            for (Satis b : list) {
                gelir += b.satis_fiyati;
            }
        }
        return gelir;
    }

    @Override
    public int gider(int satis_id) {
        return 0;
    }

    @Override
    public void MaliVeriEkleme(int gun) {
        SqlVeriİSlemleriMali v = new SqlVeriİSlemleriMali();
        v.VeriEkleme(new Satis(gun), 0);
    }
}
