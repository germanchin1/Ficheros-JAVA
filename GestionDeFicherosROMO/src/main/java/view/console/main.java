package view.console;

import java.util.Scanner;
import model.Funciones;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion;
        do {
            System.out.println("MENU:");
            System.out.println("1.- Crear carpeta");
            System.out.println("2.- Crear archivo con contenido");
            System.out.println("3.- Listar archivos de una carpeta");
            System.out.println("4.- Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la carpeta: ");
                    String folderName = sc.nextLine();
                    Funciones.createFolder(folderName);
                    break;
                case "2":
                    System.out.print("Ruta de la carpeta: ");
                    String ruta = sc.nextLine();
                    System.out.print("Nombre del archivo (con extensión): ");
                    String archivo = sc.nextLine();
                    System.out.print("Contenido del archivo: ");
                    String texto = sc.nextLine();
                    Funciones.createFile(ruta, archivo, texto);
                    break;
                case "3":
                    System.out.print("Ruta de la carpeta: ");
                    String rutaLista = sc.nextLine();
                    String[] archivos = Funciones.showListFiles(rutaLista);
                    for (String nombre : archivos) {
                        System.out.println("- " + nombre);
                    }
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (!opcion.equals("4"));
    }
}
