/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking.modelos;

/**
 *
 * @author User
 */
public class Parqueadero {
    
    private String idParking;
    private byte celdasLibres;
    private byte celdasOcupadas;
    private byte celdasTotales;

    public Parqueadero() {
    }

    public Parqueadero(String idParking, byte celdasLibres, byte celdasOcupadas, byte celdasTotales) {
        this.idParking = idParking;
        this.celdasLibres = celdasLibres;
        this.celdasOcupadas = celdasOcupadas;
        this.celdasTotales = celdasTotales;
    }

    public String getIdParking() {
        return idParking;
    }

    public void setIdParking(String idParking) {
        this.idParking = idParking;
    }

    public byte getCeldasLibres() {
        return celdasLibres;
    }

    public void setCeldasLibres(byte celdasLibres) {
        this.celdasLibres = celdasLibres;
    }

    public byte getCeldasOcupadas() {
        return celdasOcupadas;
    }

    public void setCeldasOcupadas(byte celdasOcupadas) {
        this.celdasOcupadas = celdasOcupadas;
    }

    public byte getCeldasTotales() {
        return celdasTotales;
    }

    public void setCeldasTotales(byte celdasTotales) {
        this.celdasTotales = celdasTotales;
    }
    
    
    
    
}
