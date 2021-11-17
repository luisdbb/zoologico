package entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class ALibertad extends Animal {

    private static final long serialVersionUID = -4408703402282080223L;

    private java.sql.Date fechaliberacion = Date.valueOf(LocalDate.now());
    private Recinto recinto;

    public Date getFechaliberacion() {
        return fechaliberacion;
    }

    public void setFechaliberacion(Date fechaliberacion) {
        this.fechaliberacion = fechaliberacion;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public ALibertad() {
        super();
        this.fechaliberacion = Date.valueOf(LocalDate.now());
    }

    public ALibertad(ALibertad a) {
        super(a);
        this.fechaliberacion = a.fechaliberacion;
        this.recinto = a.recinto;
    }

    public ALibertad(Animal a, Date fechaliberacion, Recinto recinto) {
        super(a);
        this.fechaliberacion = fechaliberacion;
        this.recinto = recinto;
    }

    public ALibertad(int id, String especie, String nombre, Informe informe, ArrayList<Veterinario> veterinarios, Recinto recinto) {
        super(id, especie, nombre, informe, veterinarios);
        this.recinto = recinto;
    }

    public ALibertad(int id, String especie, String nombre, int edad, Informe informe, ArrayList<Veterinario> veterinarios, Recinto recinto) {
        super(id, especie, nombre, edad, informe, veterinarios);
        this.recinto = recinto;
        this.fechaliberacion = Date.valueOf(LocalDate.now());
    }

    public ALibertad(int id, String especie, String nombre, int edad, Informe informe, ArrayList<Veterinario> veterinarios, Date fecha, Recinto recinto) {
        super(id, especie, nombre, edad, informe, veterinarios);
        this.recinto = recinto;
        this.fechaliberacion = fecha;
    }

    public ALibertad(Recinto recinto, int id, String especie, String nombre, Informe informe) {
        super(id, especie, nombre, informe);
        this.recinto = recinto;
        this.fechaliberacion = Date.valueOf(LocalDate.now());
    }

    public ALibertad(int id, String especie, String nombre, int edad, Informe informe, Recinto recinto) {
        super(id, especie, nombre, edad, informe);
        this.recinto = recinto;
        this.fechaliberacion = Date.valueOf(LocalDate.now());
    }

    public ALibertad(int id, String especie, String nombre, int edad, Informe informe, Date fecha, Recinto recinto) {
        super(id, especie, nombre, edad, informe);
        this.recinto = recinto;
        this.fechaliberacion = fecha;
    }

    public ALibertad(Animal a, Recinto recinto) {
        super(a);
        this.fechaliberacion = Date.valueOf(LocalDate.now());
        this.recinto = recinto;
    }

    /**
     * *
     * Función que convierte un array de objetos ALibertad en un ArrayList de
     * objetos ALibertad con los mismos elementos que el array.
     *
     * @param array de ALibertad
     * @return ArrayList de ALibertad
     */
    public static final ArrayList<ALibertad> convertir(ALibertad[] array) {
        ArrayList<ALibertad> ret = new ArrayList<ALibertad>();
        for (ALibertad al : array) {
            ret.add((ALibertad) al);
        }
        return ret;
    }
}
