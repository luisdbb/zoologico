package entidades;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class AJaula extends Animal {

    private static final long serialVersionUID = -940873482382010223L;

    
    private int generacion = 1;
    private Jaula jaula;

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public AJaula() {
        super();
        this.generacion = 1;
    }

    public AJaula(AJaula a) {
        super(a);
        this.generacion = a.generacion;
        this.jaula = a.jaula;
    }

    public AJaula(Animal a, Jaula jaula) {
        super(a);
        this.generacion = 1;
        this.jaula = jaula;
    }

    public AJaula(Animal a, int generacion, Jaula jaula) {
        super(a);
        this.generacion = generacion;
        this.jaula = jaula;
    }

    public AJaula(int id, String especie, String nombre, int edad, Informe informe, ArrayList<Veterinario> veterinarios, Jaula jaula) {
        super(id, especie, nombre, edad, informe, veterinarios);
        this.generacion = 1;
        this.jaula = jaula;
        this.veterinarios = veterinarios;
    }

    public AJaula(int id, String especie, String nombre, int edad, Informe informe, ArrayList<Veterinario> veterinarios, int generacion, Jaula jaula) {
        super(id, especie, nombre, edad, informe, veterinarios);
        this.generacion = generacion;
        this.jaula = jaula;
        this.veterinarios = veterinarios;
    }

    public AJaula(int id, String especie, String nombre, int edad, Informe informe, Jaula jaula) {
        super(id, especie, nombre, edad, informe);
        this.generacion = 1;
        this.jaula = jaula;
        this.veterinarios = new ArrayList<Veterinario>();
    }

    public AJaula(int id, String especie, String nombre, int edad, Informe informe, int generacion, Jaula jaula) {
        super(id, especie, nombre, edad, informe);
        this.generacion = generacion;
        this.jaula = jaula;
        this.veterinarios = new ArrayList<Veterinario>();
    }

    /**
     * *
     * Función que convierte un array de objetos AJaula en un ArrayList de
     * objetos AJaula con los mismos elementos que el array.
     *
     * @param array de AJaula
     * @return ArrayList de AJaula
     */
    public static final ArrayList<AJaula> convertir(AJaula[] array) {
        ArrayList<AJaula> ret = new ArrayList<AJaula>();
        for (AJaula aj : array) {
            ret.add((AJaula) aj);
        }
        return ret;
    }

}
