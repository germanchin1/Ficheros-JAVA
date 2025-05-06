package view.console;

import model.Funciones;
import java.util.Scanner;

public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion;
        do {
            mostrarMenu();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    menuCrearCarpeta();
                    break;
                case "2":
                    menuCrearArchivo();
                    break;
                case "3":
                    menuMostrarArchivos();
                    break;
                case "4":
                    menuMostrarContenido();
                    break;
                case "5":
                    menuSobrescribirArchivo();
                    break;
                case "6":
                    menuBorrarArchivo();
                    break;
                case "7":
                    menuContarCaracteres();
                    break;
                case "8":
                    menuContarPalabras();
                    break;
                case "9":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("9"));
    }

    private static void mostrarMenu() {
        System.out.println("\n----- MENÚ -----");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear archivo con texto");
        System.out.println("3. Listar archivos de una carpeta");
        System.out.println("4. Mostrar contenido de un archivo");
        System.out.println("5. Sobrescribir archivo");
        System.out.println("6. Borrar archivo");
        System.out.println("7. Contar caracteres");
        System.out.println("8. Contar palabras");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void menuCrearCarpeta() {
        System.out.print("Nombre de la carpeta: ");
        String carpeta = sc.nextLine();
        boolean creada = Funciones.createFolder(carpeta);
        if (creada) {
            System.out.println("Carpeta creada.");
        } else {
            System.out.println("No se pudo crear o ya existía.");
        }
    }

    private static void menuCrearArchivo() {
        System.out.print("Ruta: ");
        String path = sc.nextLine();
        System.out.print("Nombre del archivo: ");
        String archivo = sc.nextLine();
        System.out.print("Contenido: ");
        String texto = sc.nextLine();

        boolean exito = Funciones.createFile(path, archivo, texto);
        if (exito) {
            System.out.println("Archivo creado/modificado.");
        } else {
            System.out.println("Error al crear archivo.");
        }
    }

    private static void menuMostrarArchivos() {
        System.out.print("Ruta de la carpeta: ");
        String path = sc.nextLine();
        String[] archivos = Funciones.showListFiles(path);
        if (archivos.length > 0) {
            System.out.println("Archivos:");
            for (String nombre : archivos) {
                System.out.println("- " + nombre);
            }
        } else {
            System.out.println("No se encontraron archivos.");
        }
    }

    private static void menuMostrarContenido() {
        System.out.print("Ruta: ");
        String path = sc.nextLine();
        System.out.print("Nombre del archivo: ");
        String archivo = sc.nextLine();
        String contenido = Funciones.showFile(path, archivo);
        if (contenido != null) {
            System.out.println("Contenido del archivo:");
            System.out.println(contenido);
        } else {
            System.out.println("No se pudo leer el archivo.");
        }
    }

    private static void menuSobrescribirArchivo() {
        System.out.print("Ruta: ");
        String path = sc.nextLine();
        System.out.print("Nombre del archivo: ");
        String archivo = sc.nextLine();
        System.out.print("Nuevo contenido: ");
        String nuevo = sc.nextLine();
        boolean exito = Funciones.overWriteFile(path, archivo, nuevo);
        if (exito) {
            System.out.println("Archivo sobrescrito.");
        } else {
            System.out.println("No se pudo sobrescribir.");
        }
    }

    private static void menuBorrarArchivo() {
        System.out.print("Ruta: ");
        String path = sc.nextLine();
        System.out.print("Nombre del archivo: ");
        String archivo = sc.nextLine();
        boolean eliminado = Funciones.deleteFile(path, archivo);
        if (eliminado) {
            System.out.println("Archivo eliminado.");
        } else {
            System.out.println("No se pudo eliminar o no existe.");
        }
    }

    private static void menuContarCaracteres() {
        System.out.print("Ruta: ");
        String path = sc.nextLine();
        System.out.print("Nombre del archivo: ");
        String archivo = sc.nextLine();
        int chars = Funciones.countChars(path, archivo);
        if (chars >= 0) {
            System.out.println("Total de caracteres: " + chars);
        } else {
            System.out.println("Error al contar.");
        }
    }

    private static void menuContarPalabras() {
        System.out.print("Ruta: ");
        String path = sc.nextLine();
        System.out.print("Nombre del archivo: ");
        String archivo = sc.nextLine();
        int palabras = Funciones.countWords(path, archivo);
        if (palabras >= 0) {
            System.out.println("Total de palabras: " + palabras);
        } else {
            System.out.println("Error al contar.");
        }
    }
}
