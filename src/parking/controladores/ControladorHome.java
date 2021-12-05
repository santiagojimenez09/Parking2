/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parking.modelos.Conductores;
import parking.modelos.ConsultaVehiculos;
import parking.modelos.Parqueadero;
import parking.modelos.Vehiculos;
import parking.vistas.VistaHome;
import parking.vistas.VistaRegistro;
import parking.vistas.VistaSalida;

/**
 *
 * @author User
 */
public class ControladorHome implements ActionListener {
    
    Conductores conductores=new Conductores();
    Vehiculos  vehiculos=new Vehiculos();
    Parqueadero parqueadero=new Parqueadero();
    VistaHome vistaHome=new VistaHome();

    public ControladorHome() {
    }
    
    public ControladorHome(Conductores conductores,Vehiculos vehiculos,Parqueadero parqueadero,VistaHome vistaHome) {
        
        this.conductores=conductores;
        this.vehiculos=vehiculos;
        this.parqueadero=parqueadero;
        this.vistaHome=vistaHome;
        
        vistaHome.botonconsultar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultaVehiculos consulta=new ConsultaVehiculos();
        String placa=vistaHome.cajaplaca.getText();
        
        if(consulta.buscarVehiculo(placa) !=null){
            VistaSalida vistasalida = new VistaSalida();
            vistaHome.setVisible(false);
            vistasalida.setVisible(true);
            
            ControladorSalida controladorsalida = new ControladorSalida(vistasalida,conductores,parqueadero,vehiculos);
        
        }else{
            
            VistaRegistro vistaRegistro=new VistaRegistro();
            vistaRegistro.setVisible(true);
            vistaHome.setVisible(false);
            
            ControladorRegistro controladorRegistro=new ControladorRegistro(conductores,vehiculos,parqueadero,vistaRegistro);
            
        }
    }
    
}
