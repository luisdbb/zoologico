package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import utils.DatosBD;

/**
 *
 * @author luis
 */
public class Animal implements Serializable{

    private static final long serialVersionUID = 8401706102181087123L;

    
    protected int id;
    protected String especie;
    protected String nombre;
    protected int edad = 0;
    protected Informe informe;
    protected ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(ArrayList<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public Animal() {
        this.edad = 0;
        this.veterinarios = new ArrayList<Veterinario>();
    }

    public Animal(Animal a) {
        this.id = a.id;
        this.especie = a.especie;
        this.nombre = a.nombre;
        this.edad = a.edad;
        this.informe = a.informe;
        this.veterinarios = a.veterinarios;
    }

    public Animal(int id, String especie, String nombre, Informe informe, ArrayList<Veterinario> veterinarios) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = 0;
        this.informe = informe;
        this.veterinarios = veterinarios;
    }

    public Animal(int id, String especie, String nombre, int edad, Informe informe, ArrayList<Veterinario> veterinarios) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.informe = informe;
        this.veterinarios = veterinarios;
    }

    public Animal(int id, String especie, String nombre, Informe informe) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = 0;
        this.informe = informe;
        this.veterinarios = new ArrayList<Veterinario>();
    }

    public Animal(int id, String especie, String nombre, int edad, Informe informe) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.informe = informe;
        this.veterinarios = new ArrayList<Veterinario>();
    }

    /**
     * *
     * Función que devuelve el siguiente idAnimal al último del array ANIMALES
     * de la clase DatosBD
     *
     * @return siguiente idAnimal
     */
    public static int nextIdAnimal() {
        int ret = 0;
        for (Animal a : DatosBD.ANIMALES) {
            if (a.getId() > ret) {
                ret = a.getId();
            }
        }
        return ret + 1;
    }

    /**
     * Función que establece la relación cuidar entre Veterinario y Animal,
     * desde el lado del Animal, añadiendo a su lista de veterinarios el que se
     * pasa como parámetro (si no lo contenía ya) .Además, también establece la
     * relación cuidar entre Veterinario y Animal, desde el lado del
     * Veterinario, añadiendo this a su lista de animales (si no lo contenía ya)
     *
     * @param v Veterinario para la relación entre Veterinario y Animal
     */
    public void cuidarDe(Veterinario v) {
        if (!this.getVeterinarios().contains(v)) {
            this.getVeterinarios().add(v);
        }
        if (!v.getAnimales().contains(this)) {
            v.getAnimales().add(this);
        }
    }
}
