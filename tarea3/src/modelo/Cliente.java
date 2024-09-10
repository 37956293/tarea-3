/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
/**
 *
 * @author Usuario
 */
public class Cliente extends persona{
    private String NIT;
    private int id;
    conexion cn;
    
public Cliente (){}
    public Cliente(int id,String nit,String nombres,String apellidos,String direccion, String telefono, String fecha_nacimiento){
        super (nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id = id;
        this.NIT = NIT;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void crear (){
        try{
            PreparedStatement parametro;
            cn = new conexion ();
            cn.abrir_conexion();
            String query = "INSERT INTO empleados(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES (?,?,?,?,?,?)";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNIT());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getFecha_nacimiento());
            int executar = parametro.executeUpdate();
            System.out.println("ingreso exitoso" + Integer.toString(executar));
            
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println("error al crear " + ex.getMessage());
        }
    }
    
    @Override
    public DefaultTableModel leer() {
    DefaultTableModel tabla = new DefaultTableModel();
    try {
        cn = new conexion();
        cn.abrir_conexion();
        String query = "SELECT id, nit, nombres, apellidos, direccion, telefono, fecha_nacimiento FROM empleados";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        
       
        String[] encabezado = {"ID", "NIT", "Nombres", "Apellidos", "Dirección", "Teléfono", "Fecha de Nacimiento"};
        tabla.setColumnIdentifiers(encabezado);
        
       
        String[] datos = new String[7]; 
        while (consulta.next()) {
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("nit");
            datos[2] = consulta.getString("nombres");
            datos[3] = consulta.getString("apellidos");
            datos[4] = consulta.getString("direccion");
            datos[5] = consulta.getString("telefono");
            datos[6] = consulta.getString("fecha_nacimiento");
            tabla.addRow(datos); 
        }
        cn.cerrar_conexion(); 
    } catch (SQLException ex) {
        System.out.println("Error al leer los datos: " + ex.getMessage());
        cn.cerrar_conexion(); 
    }
    
    return tabla; 
}
        
        
        
        
        
        
        
        
        
        
        
        
    }
    

