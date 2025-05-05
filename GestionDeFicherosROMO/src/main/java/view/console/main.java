/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.main to edit this template
 */
package view.console;

import java.util.Scanner;

/**
 *
 * @author germanromort
 */
public class main {
        static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String opcion;
        do {
            System.out.println("TESTER FUNCIONES UserDataValidations");
            System.out.println("1 - testCheckId");
            System.out.println("2 - testCheckFormatDate");
            System.out.println("3 - testCalculateAge");
            System.out.println("4 - testCheckPostalCode");
            System.out.println("5 - testIsNumeric");
            System.out.println("6 - testIsAlphabetic");
            System.out.println("7 - testCheckEmail");
            System.out.println("8 - testCheckName");
            System.out.println("0 - SALIR");

            System.out.println("opcion: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "z":
                    System.out.println("Abandonando el programa");
                    break;

                default:
                    System.out.println("Opcion Incorrecta");
            }
        } while (!opcion.equals("z"));
    }
    }

