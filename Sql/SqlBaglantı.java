/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author w10
 */
public abstract class  SqlBaglantı {
    public Connection connect(){
        Connection c=null;
        try{
           Class.forName("org.postgresql.Driver");
            c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/nesneproje","postgres", "evettt1234"); //SQL bağlantı
            Statement st=c.createStatement();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }
}
