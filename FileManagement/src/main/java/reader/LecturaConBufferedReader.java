/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author germanromort
 */
public class LecturaConBufferedReader {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            File fichero = new File("src\\ficheros\\ejemplo1.txt");
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El sistema no puede encontrar el archivo especificado");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error inesperado");
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Se ha producido un error inesperado");
            } catch (Exception ex) {
                System.out.println("Se ha producido un error inesperado");
            }
        }
    }
}
