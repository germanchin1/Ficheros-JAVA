package model;

import java.io.File;

public class Funciones {

    /**
     * Crea una carpeta con el nombre indicado si no existe.
     * @param folderName nombre de la carpeta a crear.
     */
    public static void createFolder(String folderName) {
        File carpeta = new File(folderName);
        if (!carpeta.exists()) {
            if (carpeta.mkdir()) {
                System.out.println("Carpeta creada: " + folderName);
            } else {
                System.out.println("No se pudo crear la carpeta.");
            }
        } else {
            System.out.println("La carpeta ya existe.");
        }
    }
}
