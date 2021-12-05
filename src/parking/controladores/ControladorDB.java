/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parking.modelos.ModeloDB;


/**
 *
 * @author 505
 */
public class ControladorDB implements ActionListener {
    
    ModeloDB modelo = new ModeloDB();
    
    
    
    public ControladorDB(ModeloDB modelo){
    
        this.modelo=modelo;
        
        
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        modelo.conectarDB();
        
    }
    
}
