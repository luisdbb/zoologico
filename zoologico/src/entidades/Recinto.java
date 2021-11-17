package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import utils.DatosBD;

/**
 *
 * @author luis
 */
public class Recinto implements Serializable{
    
     private static final long serialVersionUID = -6403716603981087123L;

    private int id;
    private char sector;
    private double area;
    private boolean electrificado = false;
    private Cuidador encargado;
    private ArrayList<Jaula> jaulas = new ArrayList<Jaula>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSector() {
        return sector;
    }

    public void setSector(char sector) {
        this.sector = sector;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isElectrificado() {
        return electrificado;
    }

    public void setElectrificado(boolean electrificado) {
        this.electrificado = electrificado;
    }

    public Cuidador getEncargado() {
        return encargado;
    }

    public void setEncargado(Cuidador encargado) {
        this.encargado = encargado;
    }

    public ArrayList<Jaula> getJaulas() {
        return jaulas;
    }

    public void setJaulas(ArrayList<Jaula> jaulas) {
        this.jaulas = jaulas;
    }

    public Recinto() {
        electrificado = false;
    }

    public Recinto(Recinto r) {
        this.id = r.id;
        this.sector = r.sector;
        this.area = r.area;
        this.electrificado = r.electrificado;
        this.encargado = r.encargado;
        this.jaulas = r.jaulas;
    }

    public Recinto(int id, char sector, double area, Cuidador encargado, ArrayList<Jaula> jaulas) {
        this.id = id;
        this.sector = sector;
        this.area = area;
        this.electrificado = false;
        this.encargado = encargado;
        this.jaulas = jaulas;
    }

    public Recinto(int id, char sector, double area, boolean electrificado, Cuidador encargado, ArrayList<Jaula> jaulas) {
        this.id = id;
        this.sector = sector;
        this.area = area;
        this.electrificado = electrificado;
        this.encargado = encargado;
        this.jaulas = jaulas;
    }

    public Recinto(int id, char sector, double area, Cuidador encargado) {
        this.id = id;
        this.sector = sector;
        this.area = area;
        this.electrificado = false;
        this.encargado = encargado;
        this.jaulas = new ArrayList<Jaula>();
    }

    public Recinto(int id, char sector, double area, boolean electrificado, Cuidador encargado) {
        this.id = id;
        this.sector = sector;
        this.area = area;
        this.electrificado = electrificado;
        this.encargado = encargado;
        this.jaulas = new ArrayList<Jaula>();
    }

    @Override
    public String toString() {
        String ret;
        ret = "Recinto " + id + " en sector " + sector + ", area=" + area + "m2 (electrificado=" + electrificado + ")\n";
        ret += "Encargado: " + this.encargado.getNombre() + " (" + this.encargado.getTelefono() + ")\n";
        if (this.jaulas.size() > 0) {
            ret += " contiene las jaulas: ";
            for (Jaula j : jaulas) {
                ret += j.getId() + ",";
            }
        }
        return ret;
    }

    /**
     * *
     * Función que devuelve el siguiente idRecinto al último del array RECINTOS
     * de la clase DatosBD
     *
     * @return siguiente idrecinto
     */
    public static int nextIdRecinto() {
        int ret = 0;
        for (Recinto r : DatosBD.RECINTOS) {
            if (r.getId() > ret) {
                ret = r.getId();
            }
        }
        return ret + 1;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>Recinto</code> y un array
     * de identificadores, y devuelve una sublista con los Recintos cuyos ids
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Recintos en las que buscar
     * @param ids array de ids de Recintos
     * @return ArrayList<code>Recintos</code>
     */
    public static ArrayList<Recinto> arrayde(ArrayList<Recinto> lista, int[] ids) {
        ArrayList<Recinto> ret = new ArrayList<Recinto>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Recinto) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * *
     * Función que convierte un array de objetos Recinto en un ArrayList de
     * objetos Recinto con los mismos elementos que el array.
     *
     * @param array de Recintos
     * @return ArrayList de Recintos
     */
    public static final ArrayList<Recinto> convertir(Recinto[] array) {
        ArrayList<Recinto> ret = new ArrayList<Recinto>();
        for (Recinto r : array) {
            ret.add((Recinto) r);
        }
        return ret;
    }
    
    /**
     * Función que establece la relación encargado entre Cuidador y Recinto,
     * desde el lado del Recinto, añadiendo como encargado el Cuidador que se
     * pasa como parámetro. Además, también establece la
     * relación encargado entre Cuidador y Recinto, desde el lado del Cuidador,
     * añadiendo this a su lista de recintos (si no lo contenía ya).
     *
     * @param c Cuidador para la relación entre Cuidador y Recinto
     */
    public void encargadoDe(Cuidador c) {
        this.setEncargado(c);
        if (!c.getRecintos().contains(this)) {
            c.getRecintos().add(this);
        }
    }
}
