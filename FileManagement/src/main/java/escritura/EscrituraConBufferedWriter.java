/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author germanromort
 */
public class EscrituraConBufferedWriter {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String opcion;
        do {
            System.out.println("MENU:");
            System.out.println("1.- Escribir fichero");
            System.out.println("2.- Salir");

            System.out.print("Opcion: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                    System.out.println("Nombre del fichero: ");
                    String nombreArchivo = sc.next();
                    escribirFichero(nombreArchivo);
                    break;
                case "2":
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (!opcion.equals("2"));
    }

    private static void escribirFichero(String fileName) throws IOException {
        File fichero = new File(fileName);

        FileWriter fw = new FileWriter(fichero, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Primera línea\n");
        bw.write("Segunda línea");
        bw.newLine();
        bw.write("Tercera línea");
        bw.newLine();

        bw.flush();
}

}

