package teoria.presentacion_8.ejemploArchivo;

/*
 * Esta clase es un ejemplo de búsqueda utilizado una tabla hash
 * direccionamiento abierto
 * que se carga a partir de un archivo;
 */
public class BusquedaTablaHashDA {
    private static String[] tablaHash;

    //busca el dni en la tabla hash
    public static void buscar(String dni) {
        //registro el momento actual del sistema
        long inicio = System.currentTimeMillis();

        //busco el dni en la tabla hash
        int posicion = Integer.parseInt(dni) % tablaHash.length;
        if (tablaHash[posicion] != null && tablaHash[posicion].equals(dni)) {
            System.out.println("DNI: " + tablaHash[posicion]);
            return;
        }else if(tablaHash[posicion] != null){
            posicion++;

        }else{
            System.out.println("DNI no encontrado");
            return;
        }

        //imprimo el tiempo de búsqueda
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de búsqueda: " + tiempo + " ms");
    }

    //carga la tabla hash a partir del archivo
    public static void cargarTablaHash(String archivo) {
        //registro el momento actual del sistema
        long inicio = System.currentTimeMillis();

        //creo la estructura para cargar la tabla hash
        //creo la tabla hash
        tablaHash = new String[10000000];

        //cargo la tabla hash a partir del archivo
        try (java.io.BufferedReader entrada = new java.io.BufferedReader(new java.io.FileReader(archivo))) {
            String linea;
            //leo la primera linea
            entrada.readLine();
            //leo el resto de las lineas
            while ((linea = entrada.readLine()) != null) {
                //separo los campos
                String[] campos = linea.split(";");
                //cargo el dni en la tabla hash
                int posicion = funcionHash(campos[0]);
                if(tablaHash[posicion] == null){
                    tablaHash[posicion] = campos[0];
                    //System.out.println();
                }else{
                    //System.out.print('C');
                    posicion++;
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        //imprimo el tiempo de carga
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("Tiempo de carga: " + tiempo + " ms");
    }

    private static int funcionHash(String campo) {
        //calculo la posicion en la tabla hash
        int dni = Integer.parseInt(campo);
        return dni % tablaHash.length;
    }

    public static void main(String[] args) {
        //cargo la tabla hash a partir del archivo
        cargarTablaHash("archivo.csv");

        //busco el dni en la tabla hash
        buscar("12345678");
    }
}
