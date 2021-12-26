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
public class zona {
    int id_zona;
    String zona;
    double costo;

    public zona() {
    }

    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return id_zona + "," + zona + "," + costo;
    }

        
}
