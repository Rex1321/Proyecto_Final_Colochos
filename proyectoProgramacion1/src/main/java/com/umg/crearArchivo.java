/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Neytan Cirilo
 */
public class crearArchivo {
        //import
        String rutaArchivo = System.getProperty("user.dir") + "/archivo/archivo.txt";
    
      public void guardarArchivo (String dpi,String nombre, String apellido,String direccion,String telefono,String correo,String ocupacion,double ingreso){
         //creamos variables locales
        String dpiArchivo = dpi;
        String nombreArchivo = nombre;
        String apellidoArchivo = apellido;
        String direccionArchivo = direccion;
        String telefonoArchivo = telefono;
        String correoArchivo = correo;
        String ocupacionArchivo = ocupacion;
        double Ingreso = ingreso;
        
        FileWriter escritor = null;
        BufferedWriter bw = null;
        
        try {
            escritor = new FileWriter(rutaArchivo, true);
            bw = new BufferedWriter(escritor);
            
            String tarea = dpi + "," + nombre + "," + apellido + "," + direccion + "," + telefono + "," + correo + "," + ocupacion + "," + ingreso;
            
            bw.write(tarea);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error al guardar la tarea: " + e.getMessage());
        } finally {
            // CERRAR EL ARCHIVO
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo. " + e.getMessage());
            }
        }

    
    
    
    
    
    
    }
    
}
