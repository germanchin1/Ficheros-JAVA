package model;

import java.io.*;
import java.util.Scanner;

public class Funciones {

    public static boolean createFolder(String folderName) {
        File carpeta = new File(folderName);
        if (!carpeta.exists()) {
            return carpeta.mkdir();
        }
        return false;
    }

    public static boolean createFile(String path, String fileName, String content) {
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
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String[] showListFiles(String path) {
        File carpeta = new File(path);
        if (carpeta.exists()) {
            String[] archivos = carpeta.list();
            return (archivos != null) ? archivos : new String[0];
        }
        return new String[0];
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
                return contenido.toString();
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    public static boolean overWriteFile(String path, String fileName, String newContent) {
        File archivo = new File(path, fileName);

        if (archivo.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write(newContent);
                bw.newLine();
                bw.flush();
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean deleteFile(String path, String fileName) {
        File archivo = new File(path, fileName);
        return archivo.exists() && archivo.delete();
    }

    public static int countChars(String path, String fileName) {
        File archivo = new File(path, fileName);
        int totalChars = 0;

        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                int c;
                while ((c = br.read()) != -1) {
                    totalChars++;
                }
            } catch (IOException e) {
                return -1;
            }
        } else {
            return -1;
        }

        return totalChars;
    }

    public static int countWords(String path, String fileName) {
        File archivo = new File(path, fileName);
        int totalPalabras = 0;

        if (archivo.exists()) {
            try (Scanner sc = new Scanner(archivo)) {
                while (sc.hasNext()) {
                    sc.next();
                    totalPalabras++;
                }
            } catch (IOException e) {
                return -1;
            }
        } else {
            return -1;
        }

        return totalPalabras;
    }
}
