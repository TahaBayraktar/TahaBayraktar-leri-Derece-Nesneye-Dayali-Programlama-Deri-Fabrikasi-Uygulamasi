/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sql;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author w10
 */
public interface SqlVeriIslem {
    public Connection getDb();
    public void setDb(Connection db);
    public void Guncelleme(String hangiOzellik,String ozellik1_deger,int tc,int ozellik_deger,int kactane);
    public void Silme(int tc);
    public List Verileri_Listeleme();
    public void VeriEkleme(Object c,int id);
    public void SilmeCalisan(Long tc);
    public void GuncellemeCalisan(String hangiOzellik,String ozellik1_deger,long tc,int ozellik_deger,int kactane);
    
}
