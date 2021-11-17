package principal;

import entidades.*;
import utils.DatosBD;
import utils.Utilidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Examen1 {

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
        
        //Función 1:
        /*(Máx 1pto.) Función para ver por la salida estándar los datos básicos de cualquier Animal que se pase como parámetro, es decir, que se muestre: 
            En la 1ª línea   su identificador, nombre del animal, especie a la que pertenece y edad.
            En la 2º línea  el identificador del informe propio del animal y su descripción.
            En la 3ª línea  el idVet y el nombre de cada veterinario que cuida de ese animal o se indique que no es cuidado por ningún veterinario.  
         */
        System.out.println("- Función 1 -");
        funcion1(animales.get(3));
        System.out.println("\n");

        //Función 2:
        /* (Máx 1pto.) Función que se le pasa una lista de elementos Recinto como 
        parámetro y muestra por la salida estándar, sólo para los recintos que contienen 
        alguna Jaula, el identificador del recinto, el nombre del empleado encargado, 
        el sector en que se encuentra y la lista de jaulas que contiene (sólo el 
        identificador de cada jaula separados por comas).
         */
        System.out.println("- Función 2 -");
        ArrayList<Recinto> listaRecintos = new ArrayList<Recinto>();
        listaRecintos.add(recintos.get(0));
        listaRecintos.add(recintos.get(1));
        listaRecintos.add(recintos.get(2));
        funcion2(listaRecintos);
        System.out.println("\n");
        
        //Función 3:
        /*(Máx 1pto.) Función que, dada una edad expresada como entero ( >= 0 años), 
        devuelve el nº de animales en el sistema cuya edad es menor o igual a dicho 
        dato. En caso de que la edad tenga un valor inválido, devolverá 0. 
         */
        System.out.println("- Función 3 -");
        int edad = 4;
        int numAnimales;
        numAnimales = funcion3(edad, animales);
        System.out.println("Hay " + numAnimales + " animales de edad <= " + edad + ".");
        System.out.println("\n");
        
        //Función 4:
        /*(Máx 1,5ptos.) Función para buscar un Animal por su nombre, de forma que 
        se muestre por la salida estándar si hay o no coincidencias al filtrar una 
        cadena de caracteres introducida por el usuario comparada con el nombre de 
        todos los animales del sistema. En caso de haber alguna o varias coincidencia/s, 
        se mostrarán los datos básicos de cada animal (id, nombre y especie).
         */
        System.out.println("- Función 4 -");
        String aEncontrar = "mb";
        funcion4(aEncontrar, animales);
        System.out.println("\n");

        //Función 5:
        /*(Máx 1,5ptos.) Función que devuelve la lista de Recintos del sistema 
        ordenados alfabéticamente por el sector al que pertenecen y, en caso de 
        empate (es decir, en el mismo sector), de menor a mayor área.
         */
        System.out.println("- Función 5 -");
        listaRecintos = funcion5(recintos);
        for (Recinto r : listaRecintos) {
            System.out.println(r);
        }
        System.out.println("\n");
        
        //Función 6:
        /*(Máx 2ptos.) Función que, dado un sector expresado como char con los únicos 
            valores válidos ‘A’, ‘E’ y ‘I’, muestra por la salida estándar los siguientes datos:
            * Para cada recinto de ese sector, mostrar el idRecinto, el área y el 
                nombre del empleado encargado, así como los identificadores de las 
                jaulas que contiene (si tiene alguna) y, para cada Animal de ese 
                recinto, mostrar también el idAnimal, el nombre y la especie. 
            * En caso de que algún recinto del sector tenga jaulas vacías, indicarlo 
                por la salida estándar.
            * En caso de que el valor ingresado para el sector sea inválido, indicarlo 
                por la salida estándar.
         */
        System.out.println("- Función 6 -");
        char sector;
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el valor del sector ('A','E','I'):");
        sector = in.nextLine().charAt(0);
        funcion6(sector);
        System.out.println("\n");

        //Función 7:
        /*(Máx 2ptos.) Función que se le pasa una lista de elementos Jaula como 
            parámetro y devuelve una matriz de 2 columnas y tantas filas como el 
            nº de elementos de la lista, donde para cada fila se tiene el identificador 
            de la jaula correspondiente (en la 1ª columna), y el identificador del 
            empleado que limpia esa jaula (en la 2ª columna respectivamente).
         */
        System.out.println("- Función 7 -");
        ArrayList<Jaula> listaJaulas = new ArrayList<Jaula>();
        listaJaulas.add(jaulas.get(0));
        listaJaulas.add(jaulas.get(1));
        listaJaulas.add(jaulas.get(2));
        listaJaulas.add(jaulas.get(3));
        listaJaulas.add(jaulas.get(4));
        listaJaulas.add(jaulas.get(5));
        listaJaulas.add(jaulas.get(6));
        int[][] matriz = new int[listaJaulas.size()][2];
        matriz = funcion7(listaJaulas);
        for(int i=0; i< matriz.length; i++){
            System.out.println("La jaula J"+matriz[i][0] +" es limpiada por el idEmpleado="+matriz[i][1] + "("+Empleado.buscarEmpleadoPorId(matriz[i][1], empleados).getNombre()+")");
        }
        System.out.println("\n");

        System.out.println("FIN");
    }

    /*(Máx 1pto.) Función para ver por la salida estándar los datos básicos de cualquier Animal que se pase como parámetro, es decir, que se muestre: 
            En la 1ª línea   su identificador, nombre del animal, especie a la que pertenece y edad.
            En la 2º línea  el identificador del informe propio del animal y su descripción.
            En la 3ª línea  el idVet y el nombre de cada veterinario que cuida de ese animal o se indique que no es cuidado por ningún veterinario.  
     */
    private static void funcion1(Animal a) {
        System.out.println("IdAnimal: " + a.getId() + "\tNombre: " + a.getNombre() + "\tEspcie: " + a.getEspecie() + "\tEdad: " + a.getEdad());
        System.out.println("IdInfome: " + a.getInforme().getId() + "\t" + a.getInforme().getDescripcion());
        if (a.getVeterinarios().size() > 0) {
            System.out.print("Este animal es cuidado por los verterinarios:\t");
            for (Veterinario v : a.getVeterinarios()) {
                System.out.print(v.getIdvet() + "(" + v.getNombre() + "), ");
            }
        } else {
            System.out.println("El animal no es cuidado por ningún verterinario/a.");
        }
    }

    /* (Máx 1pto.) Función que se le pasa una lista de elementos Recinto como 
        parámetro y muestra por la salida estándar, sólo para los recintos que contienen 
        alguna Jaula, el identificador del recinto, el nombre del empleado encargado, 
        el sector en que se encuentra y la lista de jaulas que contiene (sólo el 
        identificador de cada jaula separados por comas).
     */
    private static void funcion2(ArrayList<Recinto> listaRecintos) {
        for (Recinto r : listaRecintos) {
            if (r.getJaulas().size() > 0) {
                System.out.println("idRecinto: " + r.getId() + " encargado/a: " + r.getEncargado().getNombre() + " en sector: " + r.getSector());
                System.out.println("Lista de jaulas: ");
                for (Jaula j : r.getJaulas()) {
                    System.out.print("" + j.getId() + ", ");
                }
            }
        }
    }

    /*(Máx 1pto.) Función que, dada una edad expresada como entero ( >= 0 años), 
        devuelve el nº de animales en el sistema cuya edad es menor o igual a dicho 
        dato. En caso de que la edad tenga un valor inválido, devolverá 0. 
     */
    private static int funcion3(int edad, ArrayList<Animal> lista) {
        int ret = 0;
        if (edad < 0) {
            System.out.println("Valor erróneo para la edad.");
            return 0;
        }
        for (Animal a : lista) {
            if (a.getEdad() <= edad) {
                ret++;
            }
        }
        return ret;
    }

    /*(Máx 1,5ptos.) Función para buscar un Animal por su nombre, de forma que 
        se muestre por la salida estándar si hay o no coincidencias al filtrar una 
        cadena de caracteres introducida por el usuario comparada con el nombre de 
        todos los animales del sistema. En caso de haber alguna o varias coincidencia/s, 
        se mostrarán los datos básicos de cada animal (id, nombre y especie).
     */
    private static void funcion4(String aEncontrar, ArrayList<Animal> animales) {
        ArrayList<Animal> ret = new ArrayList<Animal>();
        for (Animal a : animales) {
            if (Utilidades.removeDiacriticalMarks(a.getNombre().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(aEncontrar.toLowerCase()))) {
                ret.add(a);
            }
            if (a.getNombre().toLowerCase().contains(aEncontrar.toLowerCase())) {
                if (!ret.contains(a)) {
                    ret.add(a);
                }
            }
        }
        if (ret.size() > 0) {
            System.out.println("Hay coincidencias de animales:");
            for (Animal a : ret) {
                System.out.println("IdAnimal: " + a.getId() + " " + a.getNombre() + "(" + a.getEspecie() + ")");
            }
        } else {
            System.out.println("No hay coincidencias de animales con el nombre " + aEncontrar + ".");
        }
    }

    /*(Máx 1,5ptos.) Función que devuelve la lista de Recintos del sistema 
        ordenados alfabéticamente por el sector al que pertenecen y, en caso de 
        empate (es decir, en el mismo sector), de menor a mayor área.
     */
    private static ArrayList<Recinto> funcion5(ArrayList<Recinto> listaRecintos) {
        ArrayList<Recinto> ret = new ArrayList<Recinto>();
        int pos = 0;
        for (int i = 0; i < listaRecintos.size(); i++) {
            Recinto r = listaRecintos.get(i);
            if (ret.isEmpty()) {
                ret.add(r);
            } else {
                if (r.getSector() < ret.get(0).getSector()) {
                    ret.add(0, r);
                } else {
                    if (r.getSector() > ret.get(ret.size() - 1).getSector()) {
                        ret.add(r);
                    } else {
                        pos = 0;
                        while (pos < ret.size() && r.getSector() >= ret.get(pos).getSector()) {
                            if(r.getSector() == ret.get(pos).getSector() && r.getArea() <= ret.get(pos).getArea())
                                break;
                            else
                                pos++;
                        }
                        ret.add(pos, r);
                    }
                }
            }
        }

        return ret;
    }

    /*(Máx 2ptos.) Función que, dado un sector expresado como char con los únicos 
            valores válidos ‘A’, ‘E’ y ‘I’, muestra por la salida estándar los siguientes datos:
            * Para cada recinto de ese sector, mostrar el idRecinto, el área y el 
                nombre del empleado encargado, así como los identificadores de las 
                jaulas que contiene (si tiene alguna) y, para cada jaula con animal/es de ese 
                recinto, mostrar también el idAnimal, el nombre y la especie. 
            * En caso de que algún recinto del sector tenga jaulas vacías, indicarlo 
                por la salida estándar.
            * En caso de que el valor ingresado para el sector sea inválido, indicarlo 
                por la salida estándar.
     */
    private static void funcion6(char sector) {
        if (sector != 'A' && sector != 'E' && sector != 'I') {
            System.out.println("Valor de sector no válido.");
            return;
        } else {
            System.out.println("En el sector " + sector + " se tiene:");
            for (Recinto r : DatosBD.RECINTOS) {
                if (r.getSector() == sector) {
                    System.out.println("idRecinto: " + r.getId() + " area=" + r.getArea() + "m2. Encargado/a: " + r.getEncargado().getNombre());
                    if (r.getJaulas().isEmpty()) {
                        System.out.println("El recinto no tiene jaulas.");
                        for (ALibertad alib : DatosBD.ANIMALESLIBRES) {
                            if (alib.getRecinto().getId() == r.getId()) {
                                System.out.println("Vive: " + alib.getNombre() + "(id=" + alib.getId() + ")(" + alib.getEspecie() + ")");
                            }
                        }
                    } else {
                        System.out.println("El recinto contiene las jaulas siguientes:");
                        for (Jaula j : r.getJaulas()) {
                            for (AJaula aj : DatosBD.ANIMALESJAULA) {
                                if (aj.getJaula().getId() == j.getId()) {
                                    System.out.println("En la jaula J" + j.getId() + " vive/n:");
                                    System.out.println(aj.getNombre() + "(id=" + aj.getId() + ")(" + aj.getEspecie() + ")");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /*(Máx 2ptos.) Función que se le pasa una lista de elementos Jaula como 
            parámetro y devuelve una matriz de 2 columnas y tantas filas como el 
            nº de elementos de la lista, donde para cada fila se tiene el identificador 
            de la jaula correspondiente (en la 1ª columna), y el identificador del 
            empleado que limpia esa jaula (en la 2ª columna respectivamente).
     */
    private static int[][] funcion7(ArrayList<Jaula> listaJaulas) {
        int[][] ret = new int[listaJaulas.size()][2];
        for (int i = 0; i < listaJaulas.size(); i++) {
            ret[i][0] = listaJaulas.get(i).getId();
            ret[i][1] = listaJaulas.get(i).getLimpiador().getId();
        }
        return ret;
    }
}
