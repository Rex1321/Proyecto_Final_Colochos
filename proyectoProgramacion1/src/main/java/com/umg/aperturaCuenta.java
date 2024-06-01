/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Neytan Cirilo
 */
public class aperturaCuenta {
    
    Scanner scanner = new Scanner(System.in);
    String mostrarParte1;
    String mostrarParte2;
    String numeroCuenta;
    String fechaApertura;
    String dpiUsuario;
    String tipoCuentaDefinitiva;
    double montoInicial;

    
    public void iniciar() {
        // Obtén la ruta del archivo utilizando el directorio de trabajo actual y la carpeta "archivo".
        String rutaArchivo = System.getProperty("user.dir") + "/archivo/archivo.txt";
        String cuenta = System.getProperty("user.dir") + "/archivo/cuentas.txt";

        System.out.println("Apertura de cuenta");
        System.out.println("Ingrese el DPI del usuario: ");
        dpiUsuario = scanner.nextLine();
        System.out.print("Ingrese monto inicial: ");
        montoInicial = scanner.nextDouble();
        
        boolean limite = false;
        do{
        System.out.print("Ingrese el tipo de cuenta (1 para Monetario, 2 para Ahorro): ");
        int tipoCuenta = scanner.nextInt();
        //para que haya un dato 
        if(tipoCuenta == 1){
            tipoCuentaDefinitiva = "monetario";
            limite = true;
            }
        else{
        if(tipoCuenta == 2){
            tipoCuentaDefinitiva = "Ahorro";
            limite = true;       
        }
        else{
            System.out.println("Dato incorrecto");
            limite = false;
            }
        }
        
        }while(!limite);
        
        llamardatos(rutaArchivo,dpiUsuario);
        
        guardarArchivo(cuenta, numeroCuenta, fechaApertura, tipoCuentaDefinitiva, montoInicial);
        
        
        
        }
        public void llamardatos(String rutaArchivo, String dpiUsuario){

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;
            StringBuilder datosActualizados = new StringBuilder();
            boolean usuarioEncontrado = false;

            while ((linea = br.readLine()) != null) {
                String[] partesLine = linea.split(",");

                if (partesLine[0].equals(dpiUsuario)) {
                    
                    
                    //para saber si hay datos
                    mostrarParte1 = partesLine[1];
                    mostrarParte2 = partesLine[2];
                    numeroCuenta = generarNumeroCuenta();
                    fechaApertura = obtenerFechaApertura();
                    System.out.println("Codigo de Cuenta: " + numeroCuenta);
                    System.out.println("Fecha de Apertura: " + fechaApertura);                   
                    System.out.println("Nombre :" + mostrarParte1);
                    System.out.println("Apellido :" + mostrarParte2);
                    

                    
                    
                    usuarioEncontrado = true;
                }

            }

            br.close();

            if (!usuarioEncontrado) {
                System.out.println("El DPI del usuario no se encuentra en la base de datos.");
                return;
            }

        } catch (Exception e) {
            System.out.println("Error al abrir el archivo el usuario : " + e.getMessage());
        }

        }
    
      private static String generarNumeroCuenta() {
        return "CTA-" + new Random().nextInt(999999);
    }

    private static String obtenerFechaApertura() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    
    //esto es para guardar el archivo
    
    public void guardarArchivo (String cuenta,String numeroCuenta, String fechaApertura, String tipoCuentaDefinitiva, double montoInicial){
         //creamos variables locales
        String numeroCuentaArchivo = numeroCuenta;
        String fechaAperturaArchivo = fechaApertura;
        String tipoCuentaDefinitivaArchivo = tipoCuentaDefinitiva;
        double montoInicialArchivo = montoInicial ;
        
        FileWriter escritor = null;
        BufferedWriter bw = null;
        
        try {
            escritor = new FileWriter(cuenta, true);
            bw = new BufferedWriter(escritor);
            
            String cuentas =  numeroCuentaArchivo + "," + fechaAperturaArchivo + "," + tipoCuentaDefinitivaArchivo + "," + montoInicialArchivo;
            
            bw.write(cuentas);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error al guardar Cuenta: " + e.getMessage());
        } finally {
            // CERRAR EL ARCHIVO
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar Cuenta. " + e.getMessage());
            }
        }
    }

}
