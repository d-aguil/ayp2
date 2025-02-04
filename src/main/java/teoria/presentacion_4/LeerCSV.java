package teoria.presentacion_4;

import java.io.*;

public class LeerCSV {
    public static void main2(String[] args) {
        // Obtener el ClassLoader
        ClassLoader classLoader = LeerCSV.class.getClassLoader();

        // * String ruta = "src/main/resources/datos.csv";
        String ruta = "datos.csv";

        //try (BufferedReader reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(ruta)))) {
        try (BufferedReader reader = new BufferedReader(new FileReader(classLoader.getResource(ruta).getFile()))) {
        //* try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            System.out.println("Contenido del archivo CSV:");
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(","); // Separar los valores por comas
                for (String campo : campos) {
                    System.out.print(campo + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void main(String[] args) {

        String ruta = "src/main/resources/datos.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            System.out.println("Contenido del archivo CSV:");

            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");

                for (String campo : campos) {
                    System.out.print(campo + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}