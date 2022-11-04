package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import utils.DatosBD;
import utils.Utilidades;

/**
 *
 * @author luis
 */
public class Empleado implements Serializable {

    private static final long serialVersionUID = -6403706602980087123L;

    protected int id;
    protected String nombre;
    protected String email;
    protected String telefono;
    
    protected String apellidos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado() {
    }

    public Empleado(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.email = e.email;
        this.telefono = e.telefono;
    }

    public static Empleado nuevoEmpleado() {
        Empleado ret = new Empleado();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        //System.out.println("Introduzca el id del empleado:");
        int id = Empleado.nextIdEmpleado();
        ret.setId(id);
        System.out.println("Introduzca el nombre del empleado:");
        in = new Scanner(System.in, "ISO-8859-1");
        String nom = in.nextLine();
        ret.setNombre(nom);
        System.out.println("Introduzca el email del empleado:");
        in = new Scanner(System.in, "ISO-8859-1");
        String email = in.nextLine();
        ret.setEmail(email);
        System.out.println("Introduzca el telefono del empleado:");
        in = new Scanner(System.in, "ISO-8859-1");
        String tel = in.nextLine();
        ret.setTelefono(tel);
        return ret;
    }

    /**
     * *
     * Función que devuelve el siguiente idEmpleado al último del array
     * EMPLEADOS de la clase DatosBD
     *
     * @return siguiente idEmpleado
     */
    public static int nextIdEmpleado() {
        int ret = 0;
        for (Empleado e : DatosBD.EMPLEADOS) {
            if (e.getId() > ret) {
                ret = e.getId();
            }
        }
        for (Cuidador c : DatosBD.CUIDADORES) {
            if (c.getId() > ret) {
                ret = c.getId();
            }
        }
        for (Veterinario v : DatosBD.VETERINARIOS) {
            if (v.getId() > ret) {
                ret = v.getId();
            }
        }
        return ret + 1;
    }

    public static void verEmpleadosBasico(ArrayList<Empleado> empleados) {
        System.out.println("El sistema tiene los siguientes empleados");
        for (Empleado e : empleados) {
            System.out.println(e.getId() + ". " + e.getNombre() + " (" + e.getClass().getSimpleName() + ")");
        }
    }

    public static void buscarEmpleados(ArrayList<Empleado> empleados) {
        Empleado buscado;
        ArrayList<Empleado> encontrados;
        Scanner in;
        int opcion = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Empleado>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar empleado por ID.");
            System.out.println("Pulse 2 para buscar empleado por NOMBRE.");
            System.out.println("Pulse 3 para buscar empleado por TELEFONO.");
            System.out.println("Pulse 4 para buscar empleado por EMAIL.");
            System.out.println("Pulse 0 para VOLVER.");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            in = new Scanner(System.in, "ISO-8859-1");
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("Introduzca el ID del empleado a encontrar:");
                    int idEmp = in.nextInt();
                    buscado = Empleado.buscarEmpleadoPorId(idEmp, empleados);
                    if (buscado != null) {
                        System.out.print("Empleado encontrado: ");
                        System.out.println(buscado.getId() + ". " + buscado.getNombre() + " (" + buscado.getEmail() + ")(" + buscado.getTelefono() + ")-->" + buscado.getClass().getSimpleName());
                    } else {
                        System.out.println("Empleado con id=" + idEmp + " NO ENCONTRADO.");
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el NOMBRE del empleado a encontrar:");
                    String nomEmp = in.nextLine();
                    encontrados = Empleado.buscarEmpleadoPorNombre(nomEmp, empleados);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Empleado e : encontrados) {
                            System.out.println(e.getId() + ". " + e.getNombre() + " (" + e.getEmail() + ")(" + e.getTelefono() + ")-->" + e.getClass().getSimpleName());
                        }
                    } else {
                        System.out.println("Empleado con nombre=" + nomEmp + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Introduzca el TELEFONO del empleado a encontrar:");
                    String telEmp = in.nextLine();
                    encontrados = Empleado.buscarEmpleadoPorTelefono(telEmp, empleados);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Empleado e : encontrados) {
                            System.out.println(e.getId() + ". " + e.getNombre() + " (" + e.getEmail() + ")(" + e.getTelefono() + ")-->" + e.getClass().getSimpleName());
                        }
                    } else {
                        System.out.println("Empleado con teléfono=" + telEmp + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Introduzca el EMAIL del empleado a encontrar:");
                    String emailEmp = in.nextLine();
                    encontrados = Empleado.buscarEmpleadoPorEmail(emailEmp, empleados);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Empleado e : encontrados) {
                            System.out.println(e.getId() + ". " + e.getNombre() + " (" + e.getEmail() + ")(" + e.getTelefono() + ")-->" + e.getClass().getSimpleName());
                        }
                    } else {
                        System.out.println("Empleado con email=" + emailEmp + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                default:
                    break;
            }
        } while (opcion != 0);

    }

    public static Empleado buscarEmpleadoPorId(int idEmpleado, ArrayList<Empleado> empleados) {
        Empleado ret = null;
        for (Empleado e : empleados) {
            if (e.getId() == idEmpleado) {
                ret = e;
                break;
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorNombre(String nomEmpleado, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getNombre().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nomEmpleado.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getNombre().toLowerCase().contains(nomEmpleado.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorTelefono(String telEmpleado, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getTelefono().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(telEmpleado.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getTelefono().toLowerCase().contains(telEmpleado.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorEmail(String emailEmpleado, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getEmail().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(emailEmpleado.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getEmail().toLowerCase().contains(emailEmpleado.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public void editarEmpleado() {
        Empleado nuevo = new Empleado(this);
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        String resp;
        System.out.println("Los datos actuales del empleado son:\n" + this.toString());
        System.out.println("Introduzca el valor del nuevo ID (Intro para pasar):");
        resp = in.nextLine();
        if (!resp.isEmpty()) {
            nuevo.setId(Integer.valueOf(resp));
        }
        System.out.println("Introduzca el valor del nuevo NOMBRE (Intro para pasar):");
        in = new Scanner(System.in, "ISO-8859-1");
        resp = in.nextLine();
        if (!resp.isEmpty()) {
            nuevo.setNombre(resp);
        }
        System.out.println("Introduzca el valor del nuevo TELEFONO (Intro para pasar):");
        in = new Scanner(System.in, "ISO-8859-1");
        resp = in.nextLine();
        if (!resp.isEmpty()) {
            nuevo.setTelefono(resp);
        }
        System.out.println("Introduzca el valor del nuevo EMAIL (Intro para pasar):");
        in = new Scanner(System.in, "ISO-8859-1");
        resp = in.nextLine();
        if (!resp.isEmpty()) {
            nuevo.setEmail(resp);
        }

        if (Cuidador.class.isInstance(this)) {
            nuevo = new Cuidador(nuevo);
            ((Cuidador) nuevo).setExperiencia(((Cuidador) this).getExperiencia());
            ((Cuidador) nuevo).setRecintos(((Cuidador) this).getRecintos());
            System.out.println("Introduzca el valor de la nueva EXPERIENCIA (Intro para pasar):");
            in = new Scanner(System.in, "ISO-8859-1");
            resp = in.nextLine();
            if (!resp.isEmpty()) {
                ((Cuidador) nuevo).setExperiencia(resp);
            }
            //Los recintos de los que es encargado/a
            System.out.println("¿Desea modificar los recintos de los que es encargado/a (s/n)?");
            if (Utilidades.leerBoolean()) {
                ArrayList<Recinto> nuevosRecintos = new ArrayList<Recinto>();
                for (int i = 0; i < DatosBD.RECINTOS.length; i++) {
                    Recinto r = DatosBD.RECINTOS[i];
                    System.out.println("¿Es encargado/a del recinto R" + r.getId() + "? (s/n)");
                    if (Utilidades.leerBoolean()) {
                        nuevosRecintos.add(r);
                    } else {
                        if (((Cuidador) nuevo).getRecintos().contains(r)) {
                            ((Cuidador) nuevo).getRecintos().remove(r);
                        }
                    }
                }
                for (Recinto r : ((Cuidador) nuevo).getRecintos()) {
                    ((Cuidador) nuevo).encargadoDe(r);
                }
                ((Cuidador) nuevo).setRecintos(nuevosRecintos);
            }
            //TODO faltan las jaulas (limpiador)
            System.out.println("¿Desea modificar las jaulas que limpia (s/n)?");
            if (Utilidades.leerBoolean()) {
                System.out.println("Para modificar las limpiezas de jaulas vaya a la GESTIÓN de LIMPIEZA en el menú GESTIÓN de RECINTOS y JAULAS.");
            }
        } else if (Veterinario.class.isInstance(this)) {
            nuevo = new Veterinario(nuevo);
            ((Veterinario) nuevo).setIdvet(((Veterinario) this).getIdvet());
            ((Veterinario) nuevo).setEspecialidad(((Veterinario) this).getEspecialidad());
            ((Veterinario) nuevo).setAnimales(((Veterinario) this).getAnimales());
            System.out.println("Introduzca el valor de la nueva ESPECIALIDAD (Intro para pasar):");
            in = new Scanner(System.in, "ISO-8859-1");
            resp = in.nextLine();
            if (!resp.isEmpty()) {
                ((Veterinario) nuevo).setEspecialidad(resp);
            }
            //TODO Faltan los animales
            System.out.println("¿Desea modificar los animales que cuida (s/n)?");
            if (Utilidades.leerBoolean()) {
                System.out.println("Para modificar los cuidados de animales vaya a la GESTIÓN de CUIDADOS en el menú GESTIÓN de ANIMALES.");
            }

        }

        System.out.println("Los datos actualizados del empleado son:" + nuevo.toString());
        System.out.println("¿Es correcto (s/n)?");
        if (Utilidades.leerBoolean()) {
            this.setId(nuevo.getId());
            this.setNombre(nuevo.getNombre());
            this.setEmail(nuevo.getEmail());
            this.setTelefono(nuevo.getTelefono());
            if (Cuidador.class.isInstance(this)) {
                ((Cuidador) this).setExperiencia(((Cuidador) nuevo).getExperiencia());
                ((Cuidador) this).setRecintos(((Cuidador) nuevo).getRecintos());
            } else if (Veterinario.class.isInstance(this)) {
                ((Veterinario) this).setIdvet(((Veterinario) nuevo).getIdvet());
                ((Veterinario) this).setEspecialidad(((Veterinario) nuevo).getEspecialidad());
                ((Veterinario) this).setAnimales(((Veterinario) nuevo).getAnimales());
            }
            System.out.println("Empleado actualizado correctamente.");
        } else {
            System.out.println("NO se ha actualizado el empleado.");
        }
    }

    public void verDatosEmpleadoCompleto() {
        System.out.println("---------------");
        System.out.println("INFORME completo de EMPLEADO de ID: " + this.getId());
        System.out.println("NOMBRE: " + this.getNombre());
        System.out.println("TELEFONO: " + this.getTelefono() + "\t\tEMAIL: " + this.getEmail());
        if (Cuidador.class.isInstance(this)) {
            System.out.println("Es un empleado CUIDADOR.");
            System.out.println("EXPERIENCIA:\t" + ((Cuidador) this).getExperiencia());
            if (((Cuidador) this).getRecintos().size() > 0) {
                System.out.print("Encargado de los RECINTOS: ");
                for (Recinto r : ((Cuidador) this).getRecintos()) {
                    System.out.print("R" + r.getId() + " en sector " + r.getSector() + ", ");
                }
                System.out.println("");
            } else {
                System.out.println("NO es encargado/a de ningún recinto.");
            }

            if (Jaula.esLimpiador((Cuidador) this)) {
                System.out.print("Encargado de la limpieza de las JAULAS: ");
                for (Jaula j : Jaula.esLimpiadorDe((Cuidador) this)) {
                    System.out.print("J" + j.getId() + ", ");
                }
                System.out.println("");
            } else {
                System.out.println("NO es limpiador/a de ninguna JAULA.");
            }
        } else if (Veterinario.class.isInstance(this)) {
            System.out.println("Es un empleado VETERINARIO de IDVET=" + ((Veterinario) this).getIdvet());
            System.out.println("ESPECILIDAD:\t" + ((Veterinario) this).getEspecialidad());
            if (((Veterinario) this).getAnimales().size() > 0) {
                System.out.print("Cuida de los siguientes ANIMALES:");
                for (Animal a : ((Veterinario) this).getAnimales()) {
                    System.out.print("\n" + a.getId() + ". " + a.getNombre() + " (" + a.getEspecie() + ")");
                }
                System.out.println("");
            } else {
                System.out.println("NO cuida de ningún ANIMAL.");
            }
        }
        System.out.println("---------------");
    }
}
