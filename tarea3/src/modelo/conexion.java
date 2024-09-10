/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */
public class conexion {
    
private final String puerto = "3306"; 
private final String tarea3 = "tarea3";
private final String urlConexion = String.format("jdbc:mysql://localhost:3306/tarea3");
private final String usuario = "root";
private final String contra = "Doom2023$";
private final String jdbc = "com.mysql.cj.jdbc.Driver";

public Connection conexionBD;
public void abrir_conexion(){
    try{
       Class.forName(jdbc);
       conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
       System.out.println("Conexion Correcta....");
       }catch (ClassNotFoundException | SQLException ex){  
        System.out.println("Algo salio totalmente mal w" + ex.getMessage());   
       }
} 
public void cerrar_conexion(){
    try{
        conexionBD.close();   
    }catch (SQLException ex){
        System.out.println("algo salio totalmente mal w" + ex.getMessage());
    }
}
}

