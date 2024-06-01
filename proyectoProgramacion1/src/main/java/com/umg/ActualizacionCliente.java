/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg;


import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ActualizacionCliente {
    
    public void iniciar() {
        // Obtén la ruta del archivo utilizando el directorio de trabajo actual y la carpeta "archivo".
        String rutaArchivo = System.getProperty("user.dir") + "/archivo/archivo.txt";

        // Llama al método readCompoundList para leer el archivo de texto y obtener la lista resultante.
        List<List<String>> contenidoArchivo = leerArchivo.readCompoundList(rutaArchivo);

        // Imprime la lista compuesta.
        System.out.println(contenidoArchivo);

        // Llama al método de actualización de registros
        Updata(rutaArchivo);
    }
    
    public void Updata(String rutaArchivo) {
        Scanner nuevo = new Scanner(System.in);

        System.out.println("Ingrese el DPI del usuario a actualizar: ");
        String dpiUsuario = nuevo.nextLine();

        System.out.println("Ingrese la nueva dirección: ");
        String nuevaDireccion = nuevo.nextLine();

        System.out.println("Ingrese el nuevo teléfono: ");
        String nuevoTelefono = nuevo.nextLine();

        System.out.println("Ingrese el nuevo correo: ");
        String nuevoCorreo = nuevo.nextLine();

        System.out.println("Ingrese la nueva ocupación: ");
        String nuevaOcupacion = nuevo.nextLine();

        System.out.println("Ingrese el nuevo ingreso mensual: ");
        double nuevoIngreso = nuevo.nextDouble();

        actualizarRegistro(rutaArchivo, dpiUsuario, nuevaDireccion, nuevoTelefono, nuevoCorreo, nuevaOcupacion, nuevoIngreso);
    }

    public void actualizarRegistro(String rutaArchivo, String dpiUsuario, String nuevaDireccion, String nuevoTelefono,
            String nuevoCorreo, String nuevaOcupacion, double nuevoIngreso) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;
            StringBuilder datosActualizados = new StringBuilder();
            boolean usuarioEncontrado = false;

            while ((linea = br.readLine()) != null) {
                String[] partesLine = linea.split(",");

                if (partesLine[0].equals(dpiUsuario)) {
                    partesLine[3] = nuevaDireccion;
                    partesLine[4] = nuevoTelefono;
                    partesLine[5] = nuevoCorreo;
                    partesLine[6] = nuevaOcupacion;
                    partesLine[7] = Double.toString(nuevoIngreso);
                    usuarioEncontrado = true;
                }

                datosActualizados.append(String.join(",", partesLine)).append("\n");
            }

            br.close();

            if (!usuarioEncontrado) {
                System.out.println("El DPI del usuario no se encuentra en la base de datos.");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
                bw.write(datosActualizados.toString());
            }

            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario : " + e.getMessage());
        }
    }
}
