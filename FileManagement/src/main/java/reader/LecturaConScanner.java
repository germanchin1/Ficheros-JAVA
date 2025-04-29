/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author germanromort
 */
public class LecturaConScanner {

    public static void main(String[] args) {
        String fileName = "src\\ficheros\\ejemplo.txt";
        try {
            System.out.println(leerFichero(fileName));
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        }
    }

    private static String leerFichero(String fileName) throws FileNotFoundException {
        File fichero = new File(fileName);
        Scanner scan = new Scanner(fichero);
        String palabra = "";
        while (scan.hasNext()) {
            palabra += scan.next() + " ";
        }
        scan.close();
        return palabra;
    }
}
