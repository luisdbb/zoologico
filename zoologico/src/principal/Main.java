package principal;

import entidades.*;
import utils.DatosBD;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Main {

    public static void main(String[] args) {
        //cargar los datos desde los arrays de la clase DatosBD (pseudo-Base de datos)
        ArrayList<Jaula> jaulas = Jaula.convertir(DatosBD.JAULAS);
        ArrayList<Recinto> recintos = Recinto.convertir(DatosBD.RECINTOS);
        ArrayList<Animal> animales = new ArrayList<Animal>();
        ArrayList<AJaula> animalesJaula = AJaula.convertir(DatosBD.ANIMALESJAULA);
        ArrayList<ALibertad> animalesLibres = ALibertad.convertir(DatosBD.ANIMALESLIBRES);
        animales.addAll(animalesJaula.subList(0, 6));
        animales.addAll(animalesLibres.subList(0, 6));
        animales.addAll(animalesJaula.subList(6, 10));
        animales.addAll(animalesLibres.subList(6, 10));
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<Veterinario> veterinarios = Veterinario.convertir(DatosBD.VETERINARIOS);
        ArrayList<Cuidador> cuidadores = Cuidador.convertir(DatosBD.CUIDADORES);
        empleados.addAll(cuidadores);
        empleados.addAll(veterinarios);
        /*
          cargamos los datos de las relaciones entre las entidades que no fue
          posible cargar directamente desde DatosBD (ya que no es una BD real).
         */
        //Relación "cuidar" entre Veterinario-Animal (desde el lado del Veterinario)
        animales.get(0).cuidarDe(veterinarios.get(1));
        animales.get(0).cuidarDe(veterinarios.get(3));
        animales.get(1).cuidarDe(veterinarios.get(1));
        animales.get(1).cuidarDe(veterinarios.get(3));
        animales.get(2).cuidarDe(veterinarios.get(1));
        animales.get(2).cuidarDe(veterinarios.get(2));
        animales.get(3).cuidarDe(veterinarios.get(1));
        animales.get(3).cuidarDe(veterinarios.get(2));
        animales.get(4).cuidarDe(veterinarios.get(1));
        animales.get(4).cuidarDe(veterinarios.get(2));
        animales.get(5).cuidarDe(veterinarios.get(1));
        animales.get(5).cuidarDe(veterinarios.get(3));
        animales.get(7).cuidarDe(veterinarios.get(0));
        animales.get(7).cuidarDe(veterinarios.get(2));
        animales.get(8).cuidarDe(veterinarios.get(0));
        animales.get(8).cuidarDe(veterinarios.get(2));
        animales.get(11).cuidarDe(veterinarios.get(1));
        animales.get(11).cuidarDe(veterinarios.get(2));
        animales.get(12).cuidarDe(veterinarios.get(1));
        animales.get(11).cuidarDe(veterinarios.get(3));
        animales.get(13).cuidarDe(veterinarios.get(3));
        animales.get(14).cuidarDe(veterinarios.get(3));
        animales.get(15).cuidarDe(veterinarios.get(3));
        animales.get(16).cuidarDe(veterinarios.get(1));
        animales.get(16).cuidarDe(veterinarios.get(2));
        animales.get(17).cuidarDe(veterinarios.get(2));
        animales.get(18).cuidarDe(veterinarios.get(4));
        animales.get(19).cuidarDe(veterinarios.get(4));

        //Relación "encargado" entre Cuidador-Recinto (desde el lado del Cuidador)
        cuidadores.get(5).encargadoDe(recintos.get(0)); //Antonio Rollo Pérez encargado de R1
        cuidadores.get(0).encargadoDe(recintos.get(1)); //Jordi Fraga Pull encargado de R2
        recintos.get(2).encargadoDe(cuidadores.get(3)); //Pedro Luis Márquez Prieto encargado de R3
        recintos.get(3).encargadoDe(cuidadores.get(2)); //Raquel Gal Ordas encargada de R4

        /*
          A partir de este punto ya se tienen cargados todos los datos.
          Debería trabajarse sólo con los ArrayList empleados, recintos y animales.
         */
        int opcion = -1, opcion2 = -1;
        Scanner in;
        do {
            mostrarMenuPrincipal();
            in = new Scanner(System.in, "ISO-8859-1");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción incorrecta");
                continue;
            }
            switch (opcion) {
                case 0:
                    System.out.println("\nHa pulsado SALIR.");
                    break;
                case 1:
                    System.out.println("\nHa pulsado Gestión de EMPLEADOS.");
                    do {
                        mostrarMenuEmpleados();
                        in = new Scanner(System.in, "ISO-8859-1");
                        opcion2 = in.nextInt();
                        if (opcion2 < 0 || opcion2 > 4) {
                            System.out.println("Opción incorrecta");
                            continue;
                        }
                        gestionEmpleados(opcion2, empleados);
                    } while (opcion2 != 0);

                    break;
                case 2:
                    System.out.println("\nHa pulsado Gestión de ANIMALES.");
                    do {
                        mostrarMenuAnimales();
                        in = new Scanner(System.in, "ISO-8859-1");
                        opcion2 = in.nextInt();
                        if (opcion2 < 0 || opcion2 > 5) {
                            System.out.println("Opción incorrecta");
                            continue;
                        }
                        gestionAnimales(opcion2, animales, veterinarios);
                    } while (opcion2 != 0);

                    break;
                case 3:
                    System.out.println("\nHa pulsado Gestión de RECINTOS y JAULAS.");
                    do {
                        mostrarMenuRecintos();
                        in = new Scanner(System.in, "ISO-8859-1");
                        opcion2 = in.nextInt();
                        if (opcion2 < 0 || opcion2 > 5) {
                            System.out.println("Opción incorrecta");
                            continue;
                        }
                        gestionRecintos(opcion2, recintos, cuidadores);
                    } while (opcion2 != 0);

                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);
        System.out.println("FIN");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("-.-  MENÚ PRINCIPAL  -.- ");
        System.out.println("Pulse 1 para Gestión de EMPLEADOS.");
        System.out.println("Pulse 2 para Gestión de ANIMALES.");
        System.out.println("Pulse 3 para Gestión de RECINTOS y JAULAS.");
        System.out.println("Pulse 4 para");
        System.out.println("Pulse 0 para SALIR.");
    }

    private static void mostrarMenuEmpleados() {
        System.out.println("Pulse 1 para Ver datos de EMPLEADOS.");
        System.out.println("Pulse 2 para BUSCAR EMPLEADOS.");
        System.out.println("Pulse 3 para NUEVO EMPLEADO.");
        System.out.println("Pulse 4 para EDITAR EMPLEADO.");
        System.out.println("Pulse 0 para VOLVER.");
    }

    private static void mostrarMenuAnimales() {
        System.out.println("Pulse 1 para Ver datos de ANIMALES.");
        System.out.println("Pulse 2 para BUSCAR ANIMALES.");
        System.out.println("Pulse 3 para NUEVO ANIMAL.");
        System.out.println("Pulse 4 para EDITAR ANIMAL.");
        System.out.println("Pulse 5 para GESTIÓN de CUIDADOS (Veterinario).");
        System.out.println("Pulse 0 para VOLVER.");
    }

    private static void mostrarMenuRecintos() {
        System.out.println("Pulse 1 para Ver datos de RECINTOS.");
        System.out.println("Pulse 2 para BUSCAR RECINTOS.");
        System.out.println("Pulse 3 para NUEVO RECINTO.");
        System.out.println("Pulse 4 para EDITAR RECINTO.");
        System.out.println("Pulse 5 para GESTIÓN de LIMPIEZAS (Cuidador)");
        System.out.println("Pulse 0 para VOLVER.");
    }

    private static void gestionEmpleados(int opcion, ArrayList<Empleado> empleados) {
        Scanner in;
        int idEmpleado;
        Empleado e;
        switch (opcion) {
            case 0:
                break;
            case 1:
                System.out.println("Ha pulsado Ver datos de EMPLEADOS.");
                Empleado.verEmpleadosBasico(empleados);
                System.out.println("Introduzca el id del empleado (0 para VOLVER):");
                in = new Scanner(System.in, "ISO-8859-1");
                idEmpleado = in.nextInt();
                if (idEmpleado != 0) {
                    e = Empleado.buscarEmpleadoPorId(idEmpleado, empleados);
                    if (e != null) {
                        e.verDatosEmpleadoCompleto();
                    } else {
                        System.out.println("Empleado de id=" + idEmpleado + " no encontrado.");
                    }
                }
                break;
            case 2:
                System.out.println("Ha pulsado BUSCAR EMPLEADOS.");
                Empleado.buscarEmpleados(empleados);
                break;
            case 3:
                System.out.println("Ha pulsado NUEVO EMPLEADO.");
                int opcion2 = -1;
                in = new Scanner(System.in, "ISO-8859-1");
                do {
                    System.out.println("Pulse 1 para NUEVO CUIDADOR.");
                    System.out.println("Pulse 2 para NUEVO VETERINARIO.");
                    System.out.println("Pulse 0 para VOLVER.");
                    opcion2 = in.nextInt();
                    if (opcion2 < 0 || opcion2 > 2) {
                        System.out.println("Opción incorrecta.");
                        continue;
                    }
                    switch (opcion2) {
                        case 0:
                            break;
                        case 1:
                            Cuidador nuevoCuidador = Cuidador.nuevoCuidador();
                            empleados.add(nuevoCuidador);
                            System.out.println("Empleado CUIDADOR insertado correctamente con id=" + nuevoCuidador.getId());
                            break;
                        case 2:
                            Veterinario nuevoVet = Veterinario.nuevoVeterinario();
                            empleados.add(nuevoVet);
                            System.out.println("Empleado VETERINARIO insertado correctamente con id=" + nuevoVet.getId());
                            break;
                        default:
                            break;
                    }
                } while (opcion2 != 0);
                break;
            case 4:
                System.out.println("Ha pulsado EDITAR EMPLEADO.");
                Empleado.verEmpleadosBasico(empleados);
                System.out.println("Introduzca el id del empleado (0 para VOLVER):");
                in = new Scanner(System.in, "ISO-8859-1");
                idEmpleado = in.nextInt();
                if (idEmpleado != 0) {
                    e = Empleado.buscarEmpleadoPorId(idEmpleado, empleados);
                    if (e != null) {
                        e.editarEmpleado();
                    } else {
                        System.out.println("Error al seleccionar el empleado.");
                    }
                }
                break;
            default:
                break;
        }
    }

    private static void gestionAnimales(int opcion, ArrayList<Animal> animales, ArrayList<Veterinario> veterinarios) {
        Scanner in;
        int idAnimal;
        Animal a;
        switch (opcion) {
            case 0:
                break;
            case 1:
                System.out.println("Ha pulsado Ver datos de ANIMALES.");
                System.out.println("Opción no implementada! :(");
                break;
            case 2:
                System.out.println("Ha pulsado BUSCAR ANIMALES.");
                System.out.println("Opción no implementada! :(");
                break;
            case 3:
                System.out.println("Ha pulsado NUEVO ANIMAL.");
                System.out.println("Opción no implementada! :(");
                break;
            case 4:
                System.out.println("Ha pulsado EDITAR ANIMAL.");
                System.out.println("Opción no implementada! :(");
                break;
            case 5:
                System.out.println("Ha pulsado GESTIÓN de CUIDADOS (Veterinario).");
                System.out.println("Opción no implementada! :(");
                break;
            default:
                break;
        }
    }

    private static void gestionRecintos(int opcion, ArrayList<Recinto> recintos, ArrayList<Cuidador> cuidadores) {
        Scanner in;
        int idRecinto;
        Recinto r;
        switch (opcion) {
            case 0:
                break;
            case 1:
                System.out.println("Ha pulsado Ver datos de RECINTOS.");
                System.out.println("Opción no implementada! :(");
                break;
            case 2:
                System.out.println("Ha pulsado BUSCAR RECINTOS.");
                System.out.println("Opción no implementada! :(");
                break;
            case 3:
                System.out.println("Ha pulsado NUEVO RECINTO.");
                System.out.println("Opción no implementada! :(");
                break;
            case 4:
                System.out.println("Ha pulsado EDITAR RECINTO.");
                System.out.println("Opción no implementada! :(");
                break;
            case 5:
                System.out.println("Ha pulsado GESTIÓN de LIMPIEZAS (Cuidador).");
                System.out.println("Opción no implementada! :(");
                break;
            default:
                break;
        }
    }
}
