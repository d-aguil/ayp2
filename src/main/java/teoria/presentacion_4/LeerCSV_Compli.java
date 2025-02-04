package teoria.presentacion_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerCSV_Compli {

    public static void main(String[] args) {

        String ruta = "src/main/resources/datos-compli.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            System.out.println("Contenido del archivo CSV:");

            while ((linea = reader.readLine()) != null) {
                // Usar una expresión regular para manejar campos entre comillas
                String[] campos = linea.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                for (String campo : campos) {
                    System.out.print(campo.trim().replace("\"", "") + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}