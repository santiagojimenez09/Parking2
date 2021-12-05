/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 505
 */
public class ModeloDB {
    
    private final String servidor="jdbc:mysql://localhost/dbparking";
    private final String usuario="root";
    private final String password="";

    public ModeloDB() {
    }
    
    
     public Connection conectarDB(){
        
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidor,usuario,password);
            
            return conexion;
        
        }catch(Exception error){
            
            System.out.println("UPSS.."+error);
            return null;
        
        }
    }
    
    
}
