/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConsultaParqueadero extends ModeloDB {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarParqueadero (Parqueadero parqueadero){
        
        Connection conexion=conectarDB();
        String query="INSERT INTO parqueadero (celdas_libres,celdas_ocupadas,celdas_totales)" 
                + "VALUES (?,?;?)";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setInt(1,parqueadero.getCeldasLibres());
            consultaSQL.setInt(2,parqueadero.getCeldasOcupadas());
            consultaSQL.setInt(3,parqueadero.getCeldasTotales());
            
            int resultado=consultaSQL.executeUpdate();
            
            if(resultado>0){
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException error){
            System.out.println("Upsss..." + error);
            return false;
        }
        
    }
    
    public Parqueadero buscarParqueadero (int id_parking){
        
        Connection conexion=conectarDB();
        String query="SELECT * from parqueadero where id_parking=?";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setInt(1, id_parking);
            
            resultadoSQL=consultaSQL.executeQuery();
            
            Parqueadero parqueadero=new Parqueadero();
            if(resultadoSQL.next()){
                
                parqueadero.setCeldasLibres(resultadoSQL.getByte("celdas_libres"));
                parqueadero.setCeldasOcupadas(resultadoSQL.getByte("celdas_ocupadas"));
                parqueadero.setCeldasTotales(resultadoSQL.getByte("celdas_totales"));
                
                return parqueadero;
                
            }else{
                return null;
            }
            
        }catch(SQLException error){
            System.out.println("Upsss..." + error);
            return null;
        }
    }
    
}
