package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import utils.DatosBD;

/**
 *
 * @author luis
 */
public class Veterinario extends Empleado implements Serializable {

    private int idvet;
    private String especialidad;
    private ArrayList<Animal> animales = new ArrayList<Animal>();

    public Veterinario(Empleado empleado, int idvet, String esp) {
        super(empleado);
        this.idvet = idvet;
        this.especialidad = esp;
        this.animales = new ArrayList<Animal>();
    }

    public Veterinario(Empleado e) {
        super(e);
        if (Veterinario.class.isInstance(e)) {
            this.idvet = ((Veterinario) e).getIdvet();
            this.especialidad = ((Veterinario) e).getEspecialidad();
            this.animales = ((Veterinario) e).getAnimales();
        } else {
            this.idvet = Veterinario.nextIdVeterinario();
            this.animales = new ArrayList<Animal>();
        }
    }

    public Veterinario(Empleado empleado, int idvet, String esp, ArrayList<Animal> animales) {
        super(empleado);
        this.idvet = idvet;
        this.especialidad = esp;
        this.animales = animales;
    }

    public int getIdvet() {
        return idvet;
    }

    public void setIdvet(int idvet) {
        this.idvet = idvet;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<Animal> animales) {
        this.animales = animales;
    }

    public Veterinario() {
        super();
        this.animales = new ArrayList<Animal>();
    }

    public Veterinario(Veterinario v) {
        super(v);
        this.idvet = v.idvet;
        this.especialidad = v.especialidad;
        this.animales = v.animales;
    }

    public Veterinario(int id, String nombre, String email, String telefono, int idvet, String especialidad) {
        super(id, nombre, email, telefono);
        this.idvet = idvet;
        this.especialidad = especialidad;
        this.animales = new ArrayList<Animal>();
    }

    public Veterinario(int id, String nombre, String email, String telefono, int idvet, String especialidad, ArrayList<Animal> animales) {
        super(id, nombre, email, telefono);
        this.idvet = idvet;
        this.especialidad = especialidad;
        this.animales = animales;
    }

    @Override
    public String toString() {
        String ret;
        ret = super.id + ". (idVet=" + idvet + ") " + super.nombre + " (" + super.email + ")(" + super.telefono + "): " + especialidad;
        if (this.animales.size() > 0) {
            ret += " Cuida de: \n";
            for (Animal a : animales) {
                ret += "(" + a.getId() + ") " + a.getNombre() + ",";
            }
            ret += "\n";
        }
        return ret;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>Veterinario</code> y un
     * array de identificadores de veterimario, y devuelve una sublista con los
     * Veterinario cuyos idvet coinciden con los identificadores del array en la
     * lista
     *
     * @param lista de Veterinarios en las que buscar
     * @param ids array de ids de Veterinarios
     * @return ArrayList<code>Veterinario</code>
     */
    public static ArrayList<Veterinario> arrayde(ArrayList<Veterinario> lista, int[] ids) {
        ArrayList<Veterinario> ret = new ArrayList<Veterinario>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getIdvet() == ids[i]) {
                    ret.add((Veterinario) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * *
     * Función que convierte un array de objetos Veterinario en un ArrayList de
     * objetos Veterinario con los mismos elementos que el array.
     *
     * @param array de Veterinarios
     * @return ArrayList de Veterinarios
     */
    public static final ArrayList<Veterinario> convertir(Veterinario[] array) {
        ArrayList<Veterinario> ret = new ArrayList<Veterinario>();
        for (Veterinario v : array) {
            ret.add((Veterinario) v);
        }
        return ret;
    }

    /**
     * *
     * Función que devuelve el siguiente idVeterinario al último del array
     * VETERINARIOS de la clase DatosBD
     *
     * @return siguiente idvet
     */
    public static int nextIdVeterinario() {
        int ret = 0;
        for (Veterinario v : DatosBD.VETERINARIOS) {
            if (v.getIdvet() > ret) {
                ret = v.getIdvet();
            }
        }
        return ret + 1;
    }

    public static Veterinario nuevoVeterinario() {
        Empleado e = Empleado.nuevoEmpleado();
        Veterinario ret = new Veterinario();
        ret.setId(e.getId());
        ret.setNombre(e.getNombre());
        ret.setTelefono(e.getTelefono());
        System.out.println("Introduzca la especialidad del veterinario:");
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        String esp = in.nextLine();
        ret.setEspecialidad(esp);
        return ret;
    }

    /**
     * Función que establece la relación cuidar entre Veterinario y Animal,
     * desde el lado del Veterinario, añadiendo a su lista de animales el que se
     * pasa como parámetro (si no lo contenía ya) .Además, también establece la
     * relación cuidar entre Veterinario y Animal, desde el lado del Animal,
     * añadiendo this a su lista de veterinarios (si no lo contenía ya)
     *
     * @param a Animal para la relación entre Veterinario y Animal
     */
    public void cuidarDe(Animal a) {
        if (!this.getAnimales().contains(a)) {
            this.getAnimales().add(a);
        }
        if (!a.getVeterinarios().contains(this)) {
            a.getVeterinarios().add(this);
        }
    }

    /**
     * Función que marca el orden de importación/exportación de los campos
     * básicos de un Veterinario: id|nombre|email|telefono|idvet|especialidad
     *
     * @return id|nombre|email|telefono|idvet|especialidad
     */
    public String data() {
        String ret;
        ret = super.id + "|" + super.nombre + "|" + super.email + "|" + super.telefono + "|" + this.idvet + "|" + this.especialidad;
        return ret;
    }

}
