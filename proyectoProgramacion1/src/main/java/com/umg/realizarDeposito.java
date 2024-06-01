/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Neytan Cirilo
 */
public class realizarDeposito {
    double montoAnterior;
    
    
    public void iniciar() {
        // Obtén la ruta del archivo utilizando el directorio de trabajo actual y la carpeta "archivo".
        String rutaArchivo = System.getProperty("user.dir") + "/archivo/cuentas.txt";

        // Llama al método readCompoundList para leer el archivo de texto y obtener la lista resultante para saber cuenta plata hay en las cuentas.
        List<List<String>> contenidoArchivo = leerArchivo.readCompoundList(rutaArchivo);

        // Imprime la lista compuesta.
        System.out.println(contenidoArchivo);

        // Llama al método de actualización de registros
        Updata(rutaArchivo);
    }
    
    public void Updata(String rutaArchivo) {
        Scanner nuevo = new Scanner(System.in);

        System.out.println("Ingrese numero de cuenta: ");
        String cuenta = nuevo.nextLine();
        
        System.out.println("Ingrese el monto a depositar: ");
        double nuevoIngreso = nuevo.nextDouble();

        actualizarRegistro(rutaArchivo, cuenta , nuevoIngreso);
    }

    public void actualizarRegistro(String rutaArchivo, String cuenta , double nuevoIngreso) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;
            StringBuilder datosActualizados = new StringBuilder();
            boolean usuarioEncontrado = false;

            while ((linea = br.readLine()) != null) {
                String[] partesLine = linea.split(",");

                if (partesLine[0].equals(cuenta)) {
                    montoAnterior = Double.parseDouble(partesLine[3]);
                    double montoNuevo = montoAnterior+nuevoIngreso;
                    partesLine[3] = Double.toString(montoNuevo);
                    usuarioEncontrado = true;
                }

                datosActualizados.append(String.join(",", partesLine)).append("\n");
            }

            br.close();

            if (!usuarioEncontrado) {
                System.out.println("El numero de cuenta no se encuentra en la base de datos.");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
                bw.write(datosActualizados.toString());
            }

            System.out.println("Transaccion completa.");
        } catch (Exception e) {
            System.out.println("Error al hacer la transaccion : " + e.getMessage());
        }
    }
    
}
