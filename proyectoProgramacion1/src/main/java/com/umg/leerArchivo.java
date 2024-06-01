/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class leerArchivo {
    
    public static List<List<String>> readCompoundList(String filename) {
        List<List<String>> compoundList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                List<String> rowList = new ArrayList<>();
                for (String value : row) {
                    rowList.add(value);
                }
                if (!rowList.isEmpty()) {
                    compoundList.add(rowList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return compoundList;
    }
}