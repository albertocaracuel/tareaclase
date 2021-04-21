/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tareaclase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class Ej10 {

    private static ArrayList<String> ListaVehiculos = new ArrayList<>();

    public static void main(String[] args) {

//        crearDirectorio("./Copias");
//
//        cambiarDeDirectorio("./Deportivo.csv", "./Copias/Deportivo.csv");
//
//        cambiarDeDirectorio("./Turismo.csv", "./Copias/Turismo.csv");
//
//        leerFichero("./Copias/Turismo.csv");
//        leerFichero("./Copias/Deportivo.csv");
//
//        ImprimirLista();

        borrarFicheros("./Turismo.csv");
        
         borrarFicheros("./Deportivo.csv");

    }

    public static void crearDirectorio(String directorio) {
        Path directory = Paths.get(directorio);
        try {
            Files.createDirectory(directory);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());
        }

    }

    public static void cambiarDeDirectorio(String origenn, String Final) {
        Path origen = Paths.get(origenn);
        Path destino = Paths.get(Final);
        try {
            Files.copy(origen, destino);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
            System.out.println(e.toString());
        }

    }

    public static void borrarFicheros(String fichero) {
        Path element = Paths.get(fichero);
        try {
            Files.delete(element);
            System.out.println("El " + fichero + "ha sido eliminado");
        } catch (IOException e) {
            System.out.println("Problema borrando el archivo.");
            System.out.println(e.toString());
        }

    }

    public static void leerFichero(String idFichero) {
        FileInputStream fich = null;

        try {
            fich = new FileInputStream(idFichero);

            // A partir del fichero anterior se crea el flujo para leer objetos
            // Estructura try-with-resources
            try (ObjectInputStream flujo = new ObjectInputStream(fich)) {

                String a;
                // El método available() devuelve un número de bytes que quedan por leer
                while (fich.available() > 0) {
                    // Se hace un casting explícito del objeto devuelto
                    // por readObject()
                    a = (String) flujo.readObject();
                    // Añade el objeto a la lista
                    ListaVehiculos.add(a);
                }

            } catch (ClassNotFoundException | IOException e) { // Multicatch
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("EL fichero a leer no existe.");
        }

    }

    public static void ImprimirLista() {
        System.out.println("Imprimiendo lista");
        for (String o : ListaVehiculos) {
            System.out.println(o);
        }
    }
}
