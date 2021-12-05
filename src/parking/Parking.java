/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import parking.controladores.ControladorDB;
import parking.controladores.ControladorHome;
import parking.modelos.Conductores;
import parking.modelos.ModeloDB;
import parking.modelos.Parqueadero;
import parking.modelos.Vehiculos;
import parking.vistas.VistaHome;

/**
 *
 * @author 505
 */
public class Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conductores conductores=new Conductores();
        Vehiculos  vehiculos=new Vehiculos();
        Parqueadero parqueadero=new Parqueadero();
        VistaHome vistaHome=new VistaHome();
        vistaHome.setVisible(true);
        
        ControladorHome controladorHome=new ControladorHome(conductores,vehiculos,parqueadero,vistaHome);
        
    }
    
}
