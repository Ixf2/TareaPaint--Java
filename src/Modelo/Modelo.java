package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public final class Modelo {
    private Connection conexion;
    
    private final String usuario = "admin";
    private final String password = "";
    
    public Modelo(){
        crearBaseDatos();
        conectarBaseDatos();
        crearTablas();   
    }
    
    private Connection conectar (String url) throws SQLException{
        return DriverManager.getConnection(url, usuario, password);
    }
    
    public void crearBaseDatos(){
        try{
            conexion = conectar("jdbc:mariadb://localhost:3306/");
            Statement st = conexion.createStatement();
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS Paint");
            System.out.println("Base de datos Paint creada o que ya existe");
        } catch (SQLException e){
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }
    
    public void conectarBaseDatos(){
        try{
            conexion = conectar("jdbc:mariadb://localhost:3306/Paint");
            System.out.println("Conectado a la base de datos Paint");
        
        } catch (SQLException e){
            System.out.println("Error al conectar con la base de datos Paint: " + e.getMessage());
        }
    }
        
    public void crearTablas(){
            try{
                Statement st = conexion.createStatement();
                String sqlDibujos = "CREATE TABLE IF NOT EXISTS dibujos("
                        + "id INT AUTO_INCREMENT PRIMARY KEY,"
                        + "nombre VARCHAR(100)"
                        + ")";
                
                st.executeUpdate(sqlDibujos);
                
                System.out.println("Tablas creadas correctamente");
            } catch (SQLException e){
                System.out.println("Eror a crear tabla: " + e.getMessage());
            }  
            
        }
}
        
        
        
   
    
    
