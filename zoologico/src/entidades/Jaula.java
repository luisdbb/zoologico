package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import utils.DatosBD;

/**
 *
 * @author luis
 */
public class Jaula implements Serializable{
     private static final long serialVersionUID = -3403706602780087923L;

    private int id;
    private double volumen;
    private Cuidador limpiador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public Cuidador getLimpiador() {
        return limpiador;
    }

    public void setLimpiador(Cuidador limpiador) {
        this.limpiador = limpiador;
    }

    public Jaula() {
    }

    public Jaula(Jaula j) {
        this.id = j.id;
        this.volumen = j.volumen;
        this.limpiador = j.limpiador;
    }

    public Jaula(int id, double volumen, Cuidador limpiador) {
        this.id = id;
        this.volumen = volumen;
        this.limpiador = limpiador;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>Jaula</code> y un array
     * de identificadores, y devuelve una sublista con las Jaula cuyos ids
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Jaulas en las que buscar
     * @param ids array de ids de Jaulas
     * @return ArrayList<code>Jaula</code>
     */
    public static ArrayList<Jaula> arrayde(ArrayList<Jaula> lista, int[] ids) {
        ArrayList<Jaula> ret = new ArrayList<Jaula>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Jaula) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * *
     * Función que convierte un array de objetos Jaula en un ArrayList de
     * objetos Jaula con los mismos elementos que el array.
     *
     * @param array de Jaulas
     * @return ArrayList de Jaulas
     */
    public static final ArrayList<Jaula> convertir(Jaula[] array) {
        ArrayList<Jaula> ret = new ArrayList<Jaula>();
        for (Jaula j : array) {
            ret.add((Jaula) j);
        }
        return ret;
    }

    /**
     * *
     * Función que devuelve el siguiente idJaula al último del array JAULAS de
     * la clase DatosBD
     *
     * @return siguiente idjaula
     */
    public static int nextIdJaula() {
        int ret = 0;
        for (Jaula j : DatosBD.JAULAS) {
            if (j.getId() > ret) {
                ret = j.getId();
            }
        }
        return ret + 1;
    }

    /**
     * Función que verifica si el cuidador que se pasa como parámetro es
     * limpiador /a de alguna Jaula
     *
     * @param cuidador
     * @return true si el cuidador cuida de alguna Jaula y false en otro caso.
     */
    public static boolean esLimpiador(Cuidador cuidador) {
        for (Jaula j : DatosBD.JAULAS) {
            if (j.getLimpiador() == cuidador) {
                return true;
            }
        }
        return false;
    }
    
    /***
     * Función que devuelve la lista de Jaulas de las que es limpiador/a el/la
     * cuidador/a que se pasa como parámetro
     * @param cuidador
     * @return la lista de Jaulas que limpia el/la cuidador/a
     */
    public static ArrayList<Jaula> esLimpiadorDe(Cuidador cuidador) {
        ArrayList<Jaula> ret = new ArrayList<Jaula>();
        for (Jaula j : DatosBD.JAULAS) {
            if (j.getLimpiador() == cuidador) {
                ret.add(j);
            }
        }
        return ret;
    }
}
