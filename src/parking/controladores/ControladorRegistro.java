/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import parking.modelos.Conductores;
import parking.modelos.ConsultaConductores;
import parking.modelos.ConsultaVehiculos;
import parking.modelos.Parqueadero;
import parking.modelos.Vehiculos;
import parking.vistas.VistaRegistro;

/**
 *
 * @author User
 */
public class ControladorRegistro implements ActionListener {
    
    Conductores conductores=new Conductores();
    Vehiculos  vehiculos=new Vehiculos();
    Parqueadero parqueadero=new Parqueadero();
    VistaRegistro vistaRegistro=new VistaRegistro();

    public ControladorRegistro() {
    }
    
    public ControladorRegistro(Conductores conductores,Vehiculos vehiculos,Parqueadero parqueadero,VistaRegistro vistaRegistro) {
        
        this.conductores=conductores;
        this.vehiculos=vehiculos;
        this.parqueadero=parqueadero;
        this.vistaRegistro=vistaRegistro;
        
        vistaRegistro.botonregistrar.addActionListener(this);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultaVehiculos consultaVehiculos=new ConsultaVehiculos();
        ConsultaConductores consultaConductores=new ConsultaConductores();
        
        vehiculos.setPlaca(vistaRegistro.cajaplaca.getText());
        
        conductores.setCedula(vistaRegistro.cajacedula.getText());
        conductores.setNombres(vistaRegistro.cajanombres.getText());
        conductores.setApellidos(vistaRegistro.cajaapellidos.getText());
        conductores.setTelMovil(vistaRegistro.cajacelular.getText());
        conductores.setTelFijo(vistaRegistro.cajafijo.getText());
        
        java.util.Date entrada=new java.util.Date();
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String horaIngreso=formato.format(entrada);
        vehiculos.setHoraIngreso(horaIngreso);
        
        conductores.setPlaca(vistaRegistro.cajaplaca.getText());
        
        if(consultaVehiculos.registrarVehiculo(vehiculos) && consultaConductores.registrarConductor(conductores)){
            
            JOptionPane.showMessageDialog(null, "Exito en el registro");
        
        }else{
            
            JOptionPane.showMessageDialog(null, "Error guardando el registro");
        }
    }
    
}
