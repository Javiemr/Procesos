package com.example;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java app <ruta_fichero> <texto_a_buscar> <ruta_nuevo_fichero>");
            System.exit(1);
        }

        String ficheroEntrada = args[0];
        String textoABuscar = args[1];
        String ficheroSalida = args[2];

        try {
            // Construir el comando grep
            ProcessBuilder processBuilder = new ProcessBuilder("grep", textoABuscar, ficheroEntrada);
          
            File outputfile = new File(ficheroSalida);
            processBuilder.redirectOutput(outputfile);
       
          Process process = processBuilder.start();
            process.waitFor();

            int exitCode = process.exitValue();
            if (exitCode == 0) {
                System.out.println("Busqueda encontrada. Resultados guardados en " + ficheroSalida);
            } else {
                System.out.println("La búsqueda no encontró ninguna coincidencia.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
