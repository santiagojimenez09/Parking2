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
public class ConsultaConductores extends ModeloDB {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarConductor (Conductores conductores){
    
        Connection conexion=conectarDB();
        String query="INSERT INTO conductores (cedula,nombres,apellidos,tel_movil,tel_fijo,placa)" 
                + "VALUES (?,?,?,?,?,?)";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1,conductores.getCedula());
            consultaSQL.setString(2,conductores.getNombres());
            consultaSQL.setString(3,conductores.getApellidos());
            consultaSQL.setString(4,conductores.getTelMovil());
            consultaSQL.setString(5,conductores.getTelFijo());
            consultaSQL.setString(6,conductores.getPlaca());
            
            int resultado=consultaSQL.executeUpdate();
            
            if(resultado>0){
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException error){
            System.out.println("Uppss..." + error);
            return false;
        }
        
        
        
        }
    
    public Conductores buscarConductores(String cedula){
            
            Connection conexion=conectarDB();
            String query="SELECT * from conductores where cedula=?";
            
            try{
                
                consultaSQL=conexion.prepareStatement(query);
                
                consultaSQL.setString(1, cedula);
                
                resultadoSQL=consultaSQL.executeQuery();
                
                Conductores conductores=new Conductores();
                if(resultadoSQL.next()){
                    
                    conductores.setCedula(resultadoSQL.getString("cedula"));
                    conductores.setNombres(resultadoSQL.getString("nombres"));
                    conductores.setApellidos(resultadoSQL.getString("apellidos"));
                    conductores.setTelMovil(resultadoSQL.getString("tel_movil"));
                    conductores.setTelFijo(resultadoSQL.getString("tel_fijo"));
                    conductores.setPlaca(resultadoSQL.getString("placa"));
                    
                    return conductores;
                }else{
                    return null;
                }
                
            }catch(SQLException error){
                System.out.println("Upsss..." + error);
                return null;
            }
    }
 }
    

