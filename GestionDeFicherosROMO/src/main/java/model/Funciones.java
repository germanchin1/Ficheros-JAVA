package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Funciones {

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

    public static void createFile(String path, String fileName, String content) {
        try {
            File carpeta = new File(path);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            File archivo = new File(carpeta, fileName);
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.newLine();
            bw.close();

            System.out.println("Archivo creado/modificado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear o escribir en el archivo.");
        }
    }

    public static String[] showListFiles(String path) {
        File carpeta = new File(path);
        if (carpeta.exists()) {
            String[] archivos = carpeta.list();
            if (archivos != null && archivos.length > 0) {
                return archivos;
            } else {
                System.out.println("La carpeta está vacía.");
                return new String[0];
            }
        } else {
            System.out.println("La ruta no existe.");
            return new String[0];
        }
    }
    
    
    
    
    public static String showFile(String path, String fileName) {
    StringBuilder contenido = new StringBuilder();
    File archivo = new File(path, fileName);

    if (archivo.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                contenido.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            return "Error al leer el archivo.";
        }
    } else {
        System.out.println("El archivo no existe.");
        return "El archivo no existe.";
    }

    return contenido.toString();
}
    
    
    
    
        // Método para sobrescribir un archivo
public static boolean overWriteFile(String path, String fileName, String newContent) {
    File archivo = new File(path, fileName);

    if (archivo.exists()) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            // Escribir el nuevo contenido en el archivo, sobrescribiendo el contenido anterior
            bw.write(newContent);
            bw.newLine();
            bw.flush();  // Asegurarse de que todo el contenido se escriba
            System.out.println("Archivo modificado correctamente.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            return false;
        }
    } else {
        System.out.println("El archivo no existe.");
        return false;
    }
}
}
