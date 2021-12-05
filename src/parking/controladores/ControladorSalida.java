/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import parking.modelos.Conductores;
import parking.modelos.ConsultaConductores;
import parking.modelos.ConsultaParqueadero;
import parking.modelos.ConsultaVehiculos;
import parking.modelos.Parqueadero;
import parking.modelos.Vehiculos;
import parking.vistas.VistaSalida;

/**
 *
 * @author aspire
 */
public class ControladorSalida implements ActionListener{
    VistaSalida vistasalida = new VistaSalida();
    Conductores conductores = new Conductores();
    Parqueadero parqueadero = new Parqueadero();
    Vehiculos vehiculos = new Vehiculos();

    public ControladorSalida(VistaSalida vistasalida,Conductores conductores,
            Parqueadero parqueadero,Vehiculos vehiculos) {
        this.vistasalida = vistasalida;
        this.vehiculos = vehiculos;
        this.parqueadero = parqueadero;
        this.conductores = conductores;
        
        vistasalida.botonRetirar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       ConsultaConductores consultaconductores = new ConsultaConductores();
       ConsultaParqueadero consultaparqueadero = new ConsultaParqueadero();
       ConsultaVehiculos consultavehiculos = new ConsultaVehiculos();
       
       vehiculos=consultavehiculos.buscarVehiculo(vistasalida.CajaPlacaRetirar.getText());
       String fechaEntrada = vehiculos.getHoraIngreso();
       
       try{
           Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada); 
           Date salida = new Date();
           SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String fechaSalida=formato.format(salida);
           
           long tiempoDiferencia=salida.getTime()-entrada.getTime();
           TimeUnit unidadTiempo=TimeUnit.MINUTES;
           long tiempoParqueadero=
                   unidadTiempo.convert(tiempoDiferencia,TimeUnit.MILLISECONDS);
           
           int cobro = 150;
           int  valorTotal;
           int valor = Math.toIntExact(tiempoParqueadero);
           valorTotal = valor * cobro;
           
           
           vehiculos.setHoraSalida(fechaSalida);
           vehiculos.setValor((int) valor);
           
           if(consultavehiculos.Actualizar(vehiculos)){
                JOptionPane.showMessageDialog(null, "Exito en la salida, te demoraste: "+tiempoParqueadero);
                JOptionPane.showMessageDialog(null, "El valor a pagar es: "+valorTotal);
           }else{
               JOptionPane.showMessageDialog(null, "Error en la salida");
           }
           
           
       }catch(ParseException error){
            System.out.println("uppss."+error);
        }
           
   }
    
 }
