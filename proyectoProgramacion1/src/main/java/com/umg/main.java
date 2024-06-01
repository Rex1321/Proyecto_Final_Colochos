/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.umg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class main {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new main().iniciar();
    }

    public void iniciar() {
        boolean salida = false;
        while (!salida) {
            System.out.println("Bienvenido al banco los 3 colochos");
            System.out.println("[1] Registro cliente");
            System.out.println("[2] Actualizacion Cliente");
            System.out.println("[3] Apertura de cuenta");
            System.out.println("[4] Realizar Deposito");
            System.out.println("[5] Retirar Dinero");
            System.out.println("[6] Generar Excel");
            System.out.println("[7] Salir");
            System.out.print("Ingrese opcion: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    RegistroCliente proyecto = new RegistroCliente();
                    proyecto.iniciar();
                    break;
                case 2:
                    ActualizacionCliente actualizar = new ActualizacionCliente();
                    actualizar.iniciar();      
                    break;
                case 3:
                    aperturaCuenta abrir = new aperturaCuenta();
                    abrir.iniciar();
                    break;
                case 4:
                    realizarDeposito bono = new realizarDeposito();
                    bono.iniciar(); 
                    break;
                case 5:
                    realizarRetiro retiro = new realizarRetiro();
                    retiro.iniciar();
                    break;
                case 6:
// Llamada a la clase ExcelCreator
                                    ExcelCreator.main(new String[]{});
                    break;
                case 7:
                    salida = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }  
}