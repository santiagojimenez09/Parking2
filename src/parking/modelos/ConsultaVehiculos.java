/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 505
 */
public class ConsultaVehiculos extends ModeloDB {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarVehiculo (Vehiculos vehiculos){
        Connection conexion=conectarDB();
        String query="INSERT INTO vehiculos (placa,hora_ingreso,hora_salida,valor,id_parking)" 
                + "VALUES (?,?,?,?,?)";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1,vehiculos.getPlaca());
            consultaSQL.setString(2,vehiculos.getHoraIngreso());
            consultaSQL.setString(3,vehiculos.getHoraSalida());
            consultaSQL.setInt(4,vehiculos.getValor());
            consultaSQL.setString(5,vehiculos.getIdParking());
            
            int resultado=consultaSQL.executeUpdate();
            
            if(resultado>0){
                return true;
            }else{
                return false;
            }
        
        }catch(SQLException error){
            System.out.println("Upsss.." + error);
            return false;
        }
    
    }
    
    public Vehiculos buscarVehiculo(String placa){
        
        Connection conexion=conectarDB();
        String query="SELECT * from vehiculos where placa=?";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1, placa);
            
            resultadoSQL=consultaSQL.executeQuery();
            
            Vehiculos vehiculos=new Vehiculos();
            if(resultadoSQL.next()){
                
                vehiculos.setPlaca(resultadoSQL.getString("placa"));
                vehiculos.setHoraIngreso(resultadoSQL.getString("hora_ingreso"));
                vehiculos.setHoraSalida(resultadoSQL.getString("hora_salida"));
                vehiculos.setValor(resultadoSQL.getInt("valor"));
                vehiculos.setIdParking(resultadoSQL.getString("id_parking"));
                
                return vehiculos;
                
            }else{
                return null;
            }
        }catch(SQLException error){
            System.out.println("Upsss..." + error);
            return null;
        }
    
    }
    
    public boolean Actualizar (Vehiculos vehiculos){
         Connection conexion=conectarDB();
        String query="UPDATE vehiculos SET hora_salida=?,valor=? WHERE placa=?";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
             consultaSQL.setString(1, vehiculos.getHoraSalida());
             consultaSQL.setInt(2, vehiculos.getValor());
             consultaSQL.setString(3,vehiculos.getPlaca());
             
             
             int resultado=consultaSQL.executeUpdate();
             
              if(resultado>0){
              return true;  
            }else{
               return false; 
            }
        }catch(Exception error){
           System.out.println("upss"+error);
           return false;
            
        }
}
    
}
