/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg;

/**
 *
 * @author brand
 */
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelCreator {

    public static void main(String[] args) {
        // Crear un nuevo libro de Excel
        Workbook workbook = new XSSFWorkbook();
        // Crear una nueva hoja en el libro
        Sheet sheet = workbook.createSheet("Hoja1");

        // Abrir el archivo de texto
        try (BufferedReader br = new BufferedReader(new FileReader("archivo/cuentas.txt"))) {
            String line;
            int rowNum = 0; // Iniciar el contador de filas en 0

            while ((line = br.readLine()) != null) {
                // Separar la línea en partes usando la coma como delimitador
                String[] data = line.split(",");

                // Crear una fila en la hoja de Excel
                Row row = sheet.createRow(rowNum++);

                // Crear y llenar las celdas con los datos
                for (int i = 0; i < data.length; i++) {
                    row.createCell(i).setCellValue(data[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Guardar el libro de Excel en un archivo
        try (FileOutputStream fileOut = new FileOutputStream("datos.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El archivo Excel ha sido creado exitosamente.");
    }
}