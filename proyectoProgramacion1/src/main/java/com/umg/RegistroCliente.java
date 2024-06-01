/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Neytan Cirilo
 */
public class RegistroCliente {
    //imports
    Scanner scanner = new Scanner(System.in);
    String rutaArchivo = System.getProperty("user.dir") + "/archivo/archivo.txt";

    //declarar variables
    String dpi;
    String nombre;
    String direccion;
    String apellido;
    String telefono;
    String correo;
    String ocupacion;
    double ingreso;
    
    public void iniciar(){
    
        
      System.out.println("***Registro Cliente**");
      System.out.println("Ingrese DPI: ");
      dpi = scanner.next();
      System.out.println("Ingrese Nombre: "); 
      nombre = scanner.next();
      System.out.println("Ingrese Apellido: ");
      apellido = scanner.next();
      System.out.println("Ingrese Direccion: ");
      direccion = scanner.next();   
      System.out.println("Ingrese Telefono: ");
      telefono = scanner.next();
      System.out.println("correo: ");
      correo = scanner.next();
      System.out.println("Ingrese Ocupacion: ");
      ocupacion = scanner.next();
      System.out.println("Ingrese Ingresos mensuales: ");
      ingreso = scanner.nextDouble();   
      //guardarArchivo(dpi,nombre,apellido,direccion,telefono,correo,ocupacion,ingreso);
      crearArchivo proyecto = new crearArchivo();
      proyecto.guardarArchivo(dpi, nombre, apellido, direccion, telefono, correo, ocupacion, ingreso);
    }
    
  
   
    
}
