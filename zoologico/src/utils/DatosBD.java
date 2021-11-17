package utils;

import entidades.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author luis
 */
public class DatosBD {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final Informe INFORMES[] = {
        //int id, String descripcion
        new Informe(1, "\t\"Informe de Peggy\""),
        new Informe(2, "\t\"Informe de Oráculo\""),
        new Informe(3, "\t\"Informe de Ariel\""),
        new Informe(4, "\t\"Informe de Pin\""),
        new Informe(5, "\t\"Informe de Cervantes\""),
        new Informe(6, "\t\"Informe de María\""),
        new Informe(7, "\t\"Informe de Dama alargada\""),
        new Informe(8, "\t\"Informe de Rafita\""),
        new Informe(9, "\t\"Informe de Mónica\""),
        new Informe(10, "\t\"Informe de Dambo\""),
        new Informe(11, "\t\"Informe de Rin\""),
        new Informe(12, "\t\"Informe de Simbo\""),
        new Informe(13, "\t\"Informe de Sapiss\""),
        new Informe(14, "\t\"Informe de Dulce\""),
        new Informe(15, "\t\"Informe de Palito\""),
        new Informe(16, "\t\"Informe de Z\""),
        new Informe(17, "\t\"Informe de Lili\""),
        new Informe(18, "\t\"Informe de Bisontis\""),
        new Informe(19, "\t\"Informe de Loly\""),
        new Informe(20, "\t\"Informe de Arco Iris\"")
    };

    public static final Empleado EMPLEADOS[] = {
        //int id, String nombre, String email, String telefono
        new Empleado(1, "Jordi Fraga Pull", "jfragapull@gmail.com", "601542287"),
        new Empleado(2, "Laura Díez Silva", "laudiezsilva1988@gmail.com", "623828221"),
        new Empleado(3, "Raquel Gal Ordas", "raqgallordas@hotmail.es", "602376525"),
        new Empleado(7, "Patrick White Xi", "pwhitexi@gmail.com", "698702311"),
        new Empleado(8, "Julio Ramiro Hierro de Cos", "juliorhierrodecos@gmail.com", "698080504"),
        new Empleado(9, "Patricia Carro Segura", "patocarrosegura@hotmail.com", "600342801")
    };

    public static final Cuidador CUIDADORES[] = {
        //Empleado e, String experiencia, [ArrayList<Recinto> recintos]
        new Cuidador(EMPLEADOS[0], "Zoológico Torrelavega. Areas silvestres."),
        new Cuidador(EMPLEADOS[1], "Dirección de empresas ortícolas. Venta de piensos de animales."),
        new Cuidador(EMPLEADOS[2], "Acuario de Santander. Animales acuáticos."),
        //int id, String nombre, String email, String telefono, String experiencia, [ArrayList<Recinto> recintos]
        new Cuidador(4, "Pedro Luis Márquez Prieto", "pepeluis@gmail.com", "679220175", "Larga experiencia con anfibios, insectos y reptiles.\nMáster en Biología de invertebrados."),
        new Cuidador(5, "Marta Tosco Valdés", "martatosval@hotmail.com", "633268310", "Ganadería doméstica y profesional."),
        new Cuidador(6, "Antonio Rollo Pérez", "arolloperez@hotmail.com", "699204771", "Experto en aves. Cría de aves.")
    //Faltaría la relación "encargadoDe" desde este lado, es decir, indicar de qué recintos es encargado cada Cuidador
    };

    public static final Veterinario VETERINARIOS[] = {
        //Empleado empleado, int idvet, String esp, [ArrayList<Animal> animales]
        new Veterinario(EMPLEADOS[3], 1, "Forense."),
        new Veterinario(EMPLEADOS[4], 2, "Doctorado en Biología molecular."),
        new Veterinario(EMPLEADOS[5], 3, "Patologías y enfermedades psicóticas."),
        //int id, String nombre, String email, String telefono, int idveterinario, String especialidad, [ArrayList<Animal> animales]
        new Veterinario(10, "Antonia Ruiz Fiel", "aruizfiel@hotmail.com", "695211791", 4, "Enfermedades transmisoras. Virus."),
        new Veterinario(11, "Rafael Soria De La Riva", "rafasoriadelariva@hotmail.es", "614927730", 5, "Especialidad en aves y aves nocturnas.")
    //Faltaría la relación "cuidar" desde este lado, es decir, indicar qué animales cuida cada Veterinario
    };

    public static final Jaula JAULAS[] = {
        //int id, double volumen, Cuidador limpiador
        new Jaula(1, 46.34, CUIDADORES[3]),
        new Jaula(2, 70.49, CUIDADORES[4]),
        new Jaula(3, 29.28, CUIDADORES[1]),
        new Jaula(4, 56.32, CUIDADORES[3]),
        new Jaula(5, 31.14, CUIDADORES[1]),
        new Jaula(6, 16.70, CUIDADORES[2]),
        new Jaula(7, 53.01, CUIDADORES[3]),
        new Jaula(8, 42.51, CUIDADORES[1]),
        new Jaula(9, 49.23, CUIDADORES[3]),
        new Jaula(10, 94.88, CUIDADORES[2]),
        new Jaula(11, 47.51, CUIDADORES[1])
    };

    public static final Recinto RECINTOS[] = {
        //int id, char sector, double area, [boolean electrificado,] Cuidador encargado, [ArrayList<Jaula> jaulas]
        new Recinto(1, 'A', 308.35, true, CUIDADORES[5]),
        new Recinto(2, 'A', 2001.87, true, CUIDADORES[0]),
        new Recinto(3, 'I', 540.66, CUIDADORES[3], Jaula.arrayde(Jaula.convertir(JAULAS), new int[]{1, 3, 4, 5, 7, 8, 9, 11})),
        new Recinto(4, 'E', 775.23, CUIDADORES[2], Jaula.arrayde(Jaula.convertir(JAULAS), new int[]{2, 6, 10}))
    };

    public static final Animal ANIMALES[] = {
        //int id, String especie, String nombre, [int edad,] Informe informe, ArrayList<Veterinario> veterinarios
        new Animal(1, "Sus scrofa domestica", "Peggy", 8, INFORMES[0], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 4})),
        new Animal(2, "Oryctolagus cuniculus", "Oráculo", INFORMES[1], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 4})),
        new Animal(3, "Medusozoa", "Ariel", INFORMES[2], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 3})),
        new Animal(4, "Pygoscelis antarcticus", "Pin", 3, INFORMES[3], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 3})),
        new Animal(5, "Testudines", "Cervantes", 18, INFORMES[4], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 3})),
        new Animal(6, "Lepidoptera", "María", INFORMES[5], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 4})),
        new Animal(7, "Giraffa camelopardalis", "Dama alargada", 8, INFORMES[6]),
        new Animal(8, "Primate Cebidae", "Rafita", INFORMES[7], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{1, 3})),
        new Animal(9, "Primate Cebidae", "Mónica", 1, INFORMES[8], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{1, 3})),
        new Animal(10, "Elephantidae", "Dambo", 12, INFORMES[9]),
        new Animal(11, "Rhinocerotidae", "Rin", 3, INFORMES[10]),
        new Animal(12, "Panthera leo", "Simba", 3, INFORMES[11], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 3}))
    };

    public static final AJaula ANIMALESJAULA[] = {
        //Animal a, [int generacion,] Jaula jaula
        new AJaula(ANIMALES[0], 2, JAULAS[1]),
        new AJaula(ANIMALES[1], 3, JAULAS[1]),
        new AJaula(ANIMALES[2], JAULAS[5]),
        new AJaula(ANIMALES[3], 2, JAULAS[9]),
        new AJaula(ANIMALES[4], 3, JAULAS[9]),
        new AJaula(ANIMALES[5], JAULAS[2]),
        //int id, String especie, String nombre, int edad, Informe informe, [ArrayList<Veterinario> veterinarios,] [int generacion,] Jaula jaula 
        new AJaula(13, "Bufo viridis", "Sapiss", 1, INFORMES[12], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 4}), 1, JAULAS[4]),
        new AJaula(14, "Corallus batesii", "Dulce", 2, INFORMES[13], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{4}), JAULAS[10]),
        new AJaula(15, "Phasmatodea", "Palito", 3, INFORMES[14], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{4}), 2, JAULAS[7]),
        new AJaula(16, "Myrmecia pilosula", "Z", 4, INFORMES[15], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{4}), 2, JAULAS[0])
    };

    public static final ALibertad ANIMALESLIBRES[] = {
        //Animal a, Date fechaliberacion, Recinto recinto
        new ALibertad(ANIMALES[6], Date.valueOf(LocalDate.parse("31/12/2017", dateFormatter)), RECINTOS[1]),
        new ALibertad(ANIMALES[7], Date.valueOf(LocalDate.parse("10/09/2018", dateFormatter)), RECINTOS[1]),
        new ALibertad(ANIMALES[8], Date.valueOf(LocalDate.parse("06/04/2019", dateFormatter)), RECINTOS[1]),
        new ALibertad(ANIMALES[9], Date.valueOf(LocalDate.parse("08/04/2019", dateFormatter)), RECINTOS[1]),
        new ALibertad(ANIMALES[10], Date.valueOf(LocalDate.parse("16/07/2019", dateFormatter)), RECINTOS[1]),
        new ALibertad(ANIMALES[11], Date.valueOf(LocalDate.parse("21/08/2019", dateFormatter)), RECINTOS[1]),
        //int id, String especie, String nombre, int edad, Informe informe, ArrayList<Veterinario> veterinarios, Date fecha, Recinto recinto
        new ALibertad(17, "Panthera leo", "Lili", 4, INFORMES[16], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{2, 3}), Date.valueOf(LocalDate.parse("01/10/2019", dateFormatter)), RECINTOS[1]),
        new ALibertad(18, "Bison bonasus", "Bisontis", 3, INFORMES[17], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{3}), Date.valueOf(LocalDate.parse("20/12/2019", dateFormatter)), RECINTOS[1]),
        new ALibertad(19, "Agapornis", "Loly", 6, INFORMES[18], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{5}), Date.valueOf(LocalDate.parse("15/02/2020", dateFormatter)), RECINTOS[0]),
        new ALibertad(20, "Paradisaeidae", "Arco Iris", 1, INFORMES[19], Veterinario.arrayde(Veterinario.convertir(VETERINARIOS), new int[]{5}), Date.valueOf(LocalDate.parse("17/08/2020", dateFormatter)), RECINTOS[0])
    };

}
