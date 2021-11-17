package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Cuidador extends Empleado {

    private static final long serialVersionUID = -4408701402989087223L;

    private String experiencia;
    private ArrayList<Recinto> recintos = new ArrayList<Recinto>();

    public Cuidador(Empleado empleado, String exp) {
        super(empleado);
        this.experiencia = exp;
        this.recintos = new ArrayList<Recinto>();
    }

    public Cuidador(Empleado e) {
        super(e);
        if (Cuidador.class.isInstance(e)) {
            this.recintos = ((Cuidador) e).getRecintos();
            this.experiencia = ((Cuidador) e).getExperiencia();
        } else {
            this.recintos = new ArrayList<Recinto>();
        }
    }

    public Cuidador(Empleado empleado, String exp, ArrayList<Recinto> recintos) {
        super(empleado);
        this.experiencia = exp;
        this.recintos = recintos;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public ArrayList<Recinto> getRecintos() {
        return recintos;
    }

    public void setRecintos(ArrayList<Recinto> recintos) {
        this.recintos = recintos;
    }

    public Cuidador() {
        super();
        this.recintos = new ArrayList<Recinto>();
    }

    public Cuidador(Cuidador c) {
        super(c);
        this.experiencia = c.experiencia;
        this.recintos = c.recintos;
    }

    public Cuidador(int id, String nombre, String email, String telefono, String experiencia) {
        super(id, nombre, email, telefono);
        this.experiencia = experiencia;
    }

    public Cuidador(int id, String nombre, String email, String telefono, String experiencia, ArrayList<Recinto> recintos) {
        super(id, nombre, email, telefono);
        this.experiencia = experiencia;
        this.recintos = recintos;
    }

    @Override
    public String toString() {
        String ret;
        ret = super.id + ". Cuidador: " + super.nombre + " (" + super.email + ")(" + super.telefono + "): " + experiencia;
        if (this.recintos.size() > 0) {
            ret += " Encargado de los recintos: \n";
            for (Recinto r : recintos) {
                ret += "R" + r.getId() + " en sector " + r.getSector() + ",\n";
            }
            ret += "\n";
        }
        return ret;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>Cuidador</code> y un
     * array de identificadores, y devuelve una sublista con los Cuidadores
     * cuyos ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cuidadores en las que buscar
     * @param ids array de ids de Cuidadores
     * @return ArrayList<code>Cuidador</code>
     */
    public static ArrayList<Cuidador> arrayde(ArrayList<Cuidador> lista, int[] ids) {
        ArrayList<Cuidador> ret = new ArrayList<Cuidador>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cuidador) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * *
     * Función que convierte un array de objetos Cuidador en un ArrayList de
     * objetos Cuidador con los mismos elementos que el array.
     *
     * @param array de Cuidadores
     * @return ArrayList de Cuidadores
     */
    public static final ArrayList<Cuidador> convertir(Cuidador[] array) {
        ArrayList<Cuidador> ret = new ArrayList<Cuidador>();
        for (Cuidador c : array) {
            ret.add((Cuidador) c);
        }
        return ret;
    }

    public static Cuidador nuevoCuidador() {
        Empleado e = Empleado.nuevoEmpleado();
        Cuidador ret = new Cuidador();
        ret.setId(e.getId());
        ret.setNombre(e.getNombre());
        ret.setTelefono(e.getTelefono());
        ret.setEmail(e.getEmail());
        System.out.println("Introduzca la experiencia del cuidador:");
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        String exp = in.nextLine();
        ret.setExperiencia(exp);
        return ret;
    }

    /**
     * Función que establece la relación encargado entre Cuidador y Recinto,
     * desde el lado del Cuidador, añadiendo a su lista de recintos el que se
     * pasa como parámetro (si no lo contenía ya) .Además, también establece la
     * relación encargado entre Cuidador y Recinto, desde el lado del Recinto,
     * añadiendo this como su encargado.
     *
     * @param r Recinto para la relación entre Cuidador y Recinto
     */
    public void encargadoDe(Recinto r) {
        if (!this.getRecintos().contains(r)) {
            this.getRecintos().add(r);
        }
        r.setEncargado(this);
    }

    /**
     * Función que marca el orden de importación/exportación de los campos
     * básicos de un Cuidador id|nombre|email|telefono|experiencia
     *
     * @return id|nombre|email|telefono|experiencia
     */
    public String data() {
        String ret;
        ret = super.id + "|" + super.nombre + "|" + super.email + "|" + super.telefono + "|" + experiencia;
        return ret;
    }

}
