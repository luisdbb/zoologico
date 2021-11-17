/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author luis
 */
public enum Inmunidad  {
    NINGUNA("ninguna", 0.0),
    PARCIAL("parcial", 50.0),
    COMPLETA("completa", 100.0);

    private String nombre;
    private double porcentaje;


    Inmunidad(String nombre, double porcentaje) {
        boolean disponible = true;
        for (Inmunidad val : Inmunidad.values()) {
            if (val.getNombre().equals(nombre) || val.getPorcentaje() == porcentaje) {
                disponible = false;
                break;
            }
        }
        if (disponible) {
            this.nombre = nombre;
            this.porcentaje = porcentaje;
        }
//        else throw new Exception("Error al crear nuevo valor de Inmunidad.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

}
