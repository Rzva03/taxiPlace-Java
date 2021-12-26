/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiotaxi;

/**
 *
 * @author abigail
 */
public class viaje {
    String zona;
    String usuario;
    int pasajeros;

    public viaje() {
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return zona + "," + usuario + "," + pasajeros;
    }
    
}
