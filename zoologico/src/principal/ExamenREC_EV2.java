package principal;

import entidades.*;
import utils.DatosBD;
import utils.Utilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author luis
 */
public class ExamenREC_EV2 {

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

        /**
         * ** EJEMPLOS de USO de las FUNCIONES del EXAMEN ****
         */
        //Ejercicio 1
        System.out.println("Ejercicio 1");
        printALibertad(animalesLibres.get(0));
        System.out.println("----------- ----------- -----------");

        //Ejercicio 2
        System.out.println("Ejercicio 2");
        printCuidadores(cuidadores);
        System.out.println("----------- ----------- -----------");

        //Ejercicio 3
        System.out.println("Ejercicio 3");
        String[] cuidadoresLimpia = printVolume(cuidadores, 150.0);
        for (String s : cuidadoresLimpia) {
            System.out.println("" + s);
        }
        System.out.println("----------- ----------- -----------");

        //Ejercicio 4
        System.out.println("Ejercicio 4");
        Nomina nueva = new Nomina(1, empleados.get(0).getId(), 1, 2021, 1612.86);
        System.out.println("idnomina:" + nueva.getId() + ", idEmpleado:" + nueva.getIdEmpleado() + ", mes: " + nueva.getMes() + ", año: " + nueva.getAño() + " cantidad: " + nueva.getCantidad() + "euros.");
        System.out.println("----------- ----------- -----------");

        //Ejercicio 5
        System.out.println("Ejercicio 5");
        exportarAnimalesDeEdad(animales, 4);
        System.out.println("----------- ----------- -----------");

        //Ejercicio 6
        System.out.println("Ejercicio 6");
        writeAnimalesToBinaryFile(animales);
        System.out.println("----------- ----------- -----------");

        //writeRecintoToBinaryFile();
        //Ejercicio 7.
        System.out.println("Ejercicio 7");
        String path = "nuevosrecintos.dat";
        Recinto r = importarRecintoDesdeFicheroDeBytes(path);
        System.out.println("----------- ----------- -----------");

        //Ejercicio 8
        System.out.println("Ejercicio 8");
//        Inmunidad inmu_nueva = new Inmunidad("1ª dosis", 25.0);
        System.out.println("----------- ----------- -----------");
    }

    /*
    1) (Máx 1pto.) Función que se le pasa como argumento un animal en libertad y muestra por la salida estándar
su identificador, nombre, especie, edad, id del recinto en el que vive, su fecha de liberación y el nº de días
hasta hoy que ha pasado en libertad en el zoo.
     */
    public static void printALibertad(ALibertad a) {
        System.out.println("identificador: " + a.getId() + ", nombre: " + a.getNombre() + ", edad: " + a.getEdad());
        System.out.println("idRecinto: " + a.getRecinto().getId() + ", fecha de liberación: " + a.getFechaliberacion().toString());
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
        java.util.Date hoy = new java.util.Date();
        long dias = (hoy.getTime() - a.getFechaliberacion().getTime()) / MILLSECS_PER_DAY;
        System.out.println("nº de días en libertad: " + dias);
    }

    /*
2) (Máx 1pto.) Función que muestra por la salida estándar, para cada cuidador del sistema en una línea
distinta, el identificador de empleado, el nombre, los identificadores de las jaulas que limpia y el volumen
total (acumulado) de esas jaulas. 
     */
    public static void printCuidadores(ArrayList<Cuidador> cuidadores) {
        double acum;
        for (Cuidador c : cuidadores) {
            acum = 0.0;
            System.out.print("idEmpleado: " + c.getId() + ", nombre: " + c.getNombre() + "\t");
            ArrayList<Integer> jaulas = new ArrayList();
            for (Jaula j : DatosBD.JAULAS) {
                if (j.getLimpiador().equals(c)) {
                    jaulas.add(j.getId());
                    acum += j.getVolumen();
                }
            }
            if (!jaulas.isEmpty()) {
                System.out.println("Limpia la jaulas: " + jaulas);
            } else {
                System.out.println("No limpia ninguna jaula.");
            }
            System.out.println("Volumen total = " + acum + "m3.");
        }
    }

    /*
    3) (Máx 1pto.) Función que se le pasa como argumento un valor decimal que expresa un volumen (>= 0.0)
y devuelve un array con los nombres de los cuidadores que en total (acumulado) limpian un volumen de
jaulas igual o mayor que el valor pasado como parámetro.
     */
    public static String[] printVolume(ArrayList<Cuidador> cuidadores, double vol) {
        Object[] ret;
        ArrayList<String> aux = new ArrayList<String>();
        double acum;
        for (Cuidador c : cuidadores) {
            acum = 0.0;
            for (Jaula j : DatosBD.JAULAS) {
                if (j.getLimpiador().equals(c)) {
                    acum += j.getVolumen();
                }
            }
            if (acum >= vol) {
                aux.add(c.getNombre());
            }
        }
        ret = aux.toArray();

        return Arrays.asList(ret).toArray(new String[ret.length]);

        //  (String[])ret;
    }

    /*
    5) (Máx 1,5ptos.) Implementar una función que, dada una edad (entero >=0), exporte a un fichero de texto
de nombre animales.txt la información sobre los animales del zoo cuya edad es mayor o igual a ese
valor. Se escribirá en la primera línea del fichero la cadena
Los animales del zoo de edad mayor o igual a <edad> años son:
y luego, en cada línea, los siguientes datos de cada animal que cumpla la condición:
<idAnimal> : <nombre> ( <especie> ) de <edad> años.
     */
    private static void exportarAnimalesDeEdad(ArrayList<Animal> animales, int edad) {
        String path = "animales.txt";
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, false);
                buffer = new PrintWriter(escritor);
                buffer.print("Los animales del zoo de edad mayor o igual a " + edad + " años son:");
                for (Animal a : animales) {
                    if (a.getEdad() >= edad) //<idAnimal> : <nombre> ( <especie> ) de <edad> años.
                    {
                        buffer.print(a.getId() + " : " + a.getNombre() + " (" + a.getEspecie() + ") de " + a.getEdad() + " años.\n");
                    }
                }
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
    }

    /*
    6) (Máx 1,5ptos.) Implementar una función que recorra toda la lista de animales del sistema, muestre por la
salida estándar los datos básicos de cada animal (id, nombre y especie) y pregunte al usuario si desea
exportar los datos de ese animal. La selección de animales que haga el usuario se exportará a un fichero
binario de nombre animales.dat.
     */
    public static void writeAnimalesToBinaryFile(ArrayList<Animal> animales) {
        String path = "animales.dat";
        try {
            FileOutputStream fichero = new FileOutputStream(path, false); //el 2º argumento a true para que concatene al final del fichero, en lugar de sobreescribir
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            for (Animal a : animales) {
                System.out.println(a.getId() + ": " + a.getNombre() + "(" + a.getEspecie() + ")");
                System.out.println("¿Desea exportar al animal anterior?");
                if (Utilidades.leerBoolean()) {
                    escritor.writeObject((Animal) a);
                    escritor.flush();
                }
            }
            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
    }

    /*
    7) (Máx 1pto.) En el proyecto se incluye un fichero binario de nombre nuevosrecintos.dat que contiene
los datos para un nuevo Recinto en el zoo. Concretamente, se tienen los datos en el siguiente orden:
Recinto (int id, char sector, double area, boolean electrificado, Cuidador encargado)
Se pide implementar una función que importe los datos del nuevo recinto y los muestre por la salida
estándar del sistema para luego devolver un objeto completo creado con esos valores.
     */
    public static Recinto importarRecintoDesdeFicheroDeBytes(String path) {
        Recinto ret = new Recinto();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                ret = (Recinto) lectorObjeto.readObject();
                System.out.println("" + ret);
            } finally {
                if (lectorObjeto != null) {
                    lectorObjeto.close();
                }
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido una ClassNotFoundException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
        return ret;
    }

//    public static void writeRecintoToBinaryFile() {
//        String path = "nuevosrecintos.dat";
//        try {
//            FileOutputStream fichero = new FileOutputStream(path, false);
//            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
//            Recinto r = new Recinto(5, 'A', 780.87, false, DatosBD.CUIDADORES[3]);
//            escritor.writeObject((Recinto) r);
//            escritor.flush();
//
//            escritor.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("Se ha producido una IOException" + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Se ha producido una Exception" + e.getMessage());
//        }
//    }
}
