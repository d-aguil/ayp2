package teoria.presentacion_8.ejemploArchivo;

/*
 * El prop[osito de la clase es mostrar el tiempo de búsqueda de un elemento
 * directamente sobre un archivo
 */
public class BusquedaDirecta {

    public static void buscar(String archivo, String dni) {
        //registro el momento actual del sistema
        long inicio = System.currentTimeMillis();

        //busco el dni en el archivo
        try (java.io.BufferedReader entrada = new java.io.BufferedReader(new java.io.FileReader(archivo))) {
            String linea;
            //leo la primera linea
            entrada.readLine();
            //leo el resto de las lineas
            while ((linea = entrada.readLine()) != null) {
                //separo los campos
                String[] campos = linea.split(";");
                //si el dni es igual al que busco
                if (campos[0].equals(dni)) {
                    System.out.println("DNI: " + campos[0] + " Nombre: " + campos[1]);
                    return;
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        //imprimo el tiempo de búsqueda
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de búsqueda: " + tiempo + " ms");
    }

    public static void main(String[] args) {
        //llamo al metodo para buscar el dni
        buscar("archivo.csv", "12345678");
    }
}
