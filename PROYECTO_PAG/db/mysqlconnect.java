/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.Statement;
import javax.swing.JOptionPane;


public class mysqlconnect {
    Connection conn = null;
    private static String url="jdbc:mysql://localhost:3306/logged";
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,"root","Losnuevosbi12");
            // Statement stmt=conn.createStatement();  
            // ResultSet rs=stmt.executeQuery("show databases;");
            JOptionPane.showMessageDialog(null,"Connected");  
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
        
    }
    
 
}
