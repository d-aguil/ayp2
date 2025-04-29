package teoria.presentacion_8.ejemploArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Esta clase es un ejemplo de búsqueda utilizando una tabla hash
 * direccionamiento cerrado
 * que se carga a partir de un archivo;
 */
public class BusquedaTablaHashDC {
    private static List<String>[] tablaHash;

    // Busca el DNI en la tabla hash
    public static void buscar(String dni) {
        // Registro el momento actual del sistema
        long inicio = System.currentTimeMillis();

        // Calculo la posición en la tabla hash
        int posicion = funcionHash(dni);

        // Busco el DNI en la lista correspondiente
        List<String> lista = tablaHash[posicion];
        if (lista != null && lista.contains(dni)) {
            System.out.println("DNI encontrado: " + dni);
        } else {
            System.out.println("DNI no encontrado");
        }

        // Imprimo el tiempo de búsqueda
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de búsqueda: " + tiempo + " ms");
    }

    // Carga la tabla hash a partir del archivo
    public static void cargarTablaHash(String archivo) {
        // Registro el momento actual del sistema
        long inicio = System.currentTimeMillis();

        // Creo la estructura para cargar la tabla hash
        tablaHash = new ArrayList[750000];

        // Cargo la tabla hash a partir del archivo
        try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leo la primera línea
            entrada.readLine();
            // Leo el resto de las líneas
            while ((linea = entrada.readLine()) != null) {
                // Separo los campos
                String[] campos = linea.split(";");
                String dni = campos[0];
                // Calculo la posición en la tabla hash
                int posicion = funcionHash(dni);

                // Inserto el DNI en la lista correspondiente
                if (tablaHash[posicion] == null) {
                    tablaHash[posicion] = new ArrayList<>();
                    //System.out.println();
                }else{
                    //System.out.println("C"+tablaHash[posicion].size());
                }
                tablaHash[posicion].add(dni);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Imprimo el tiempo de carga
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de carga: " + tiempo + " ms");
    }

    private static int funcionHash(String campo) {
        // Calculo la posición en la tabla hash
        int dni = Integer.parseInt(campo);
        return dni % tablaHash.length;
    }

    public static void main(String[] args) {
        // Cargo la tabla hash a partir del archivo
        cargarTablaHash("archivo.csv");

        // Busco el DNI en la tabla hash
        buscar("12345678");
    }
}