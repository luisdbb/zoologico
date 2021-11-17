package entidades;

import java.io.Serializable;

import utils.DatosBD;

/**
 *
 * @author luis
 */
public class Informe implements Serializable{

    
    private static final long serialVersionUID = -2401705102185087525L;

    
    private int id;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Informe() {
    }

    public Informe(Informe i) {
        this.id = i.id;
        this.descripcion = i.descripcion;
    }

    public Informe(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    /**
     * *
     * Función que devuelve el siguiente idInforme al último del array INFORMES
     * de la clase DatosBD
     *
     * @return siguiente idInforme
     */
    public static int nextIdInforme() {
        int ret = 0;
        for (Informe i : DatosBD.INFORMES) {
            if (i.getId() > ret) {
                ret = i.getId();
            }
        }
        return ret + 1;
    }

}
