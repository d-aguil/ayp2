package teoria.presentacion_8.ejemploArchivo;

/*
 * Esta clase es un ejemplo de búsqueda binaria en un arreglo
 * que se carga a partir de un archivo;
 */
public class BusquedaBinaria {
    private static String[] arreglo;

    //busca el dni en el arreglo
    public static void buscar(String dni) {
        //registro el momento actual del sistema
        long inicio = System.currentTimeMillis();

        //busco el dni en el arreglo
        int izquierda = 0;
        int derecha = arreglo.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arreglo[medio].equals(dni)) {
                System.out.println("DNI: " + arreglo[medio]);
                return;
            } else if (arreglo[medio].compareTo(dni) < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        //imprimo el tiempo de búsqueda
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de búsqueda: " + tiempo + " ms");
    }

    //carga el arreglo a partir del archivo
    public static void cargarArreglo(String archivo) {
        //registro el momento actual del sistema
        long inicio = System.currentTimeMillis();

        //creo la estructura para cargar el arreglo
        //creo el arreglo
        arreglo = new String[10000000];

        //cargo el arreglo a partir del archivo
        try (java.io.BufferedReader entrada = new java.io.BufferedReader(new java.io.FileReader(archivo))) {
            String linea;
            //leo la primera linea
            entrada.readLine();
            //leo el resto de las lineas
            int i = 0;
            while ((linea = entrada.readLine()) != null) {
                //separo los campos
                String[] campos = linea.split(";");
                //cargo el dni en el arreglo
                arreglo[i] = campos[0];
                i++;
            }
        } catch (java.io.IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        //imprimo el tiempo de carga
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de carga: " + tiempo + " ms");
    }

    public static void main(String[] args) {

        //cargo el arreglo a partir del archivo
        cargarArreglo("archivo.csv");

        // registro el tiempo que me lleva ordenar
        long inicio = System.currentTimeMillis();
        //ordeno el arreglo
        java.util.Arrays.sort(arreglo);
        //imprimo el tiempo de ordenamiento
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de ordenamiento: " + tiempo + " ms");


        //busco el dni en el arreglo
        buscar("12345678");
    }
}
