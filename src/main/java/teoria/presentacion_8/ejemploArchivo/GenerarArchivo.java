package teoria.presentacion_8.ejemploArchivo;

//La clase se utiliza para generar un archivo de texto (csv)
// Cada linea tiene un número de dni y un nombre asociado
public class GenerarArchivo {

    //genero el archivo
    public static void generarArchivo(String archivo){
        //creo el archivo
        try (java.io.PrintWriter salida = new java.io.PrintWriter(archivo)) {
            //escribo el encabezado
            salida.println("dni;nombre");

            //itero varias veces para generar cada linea
            for (int i = 0; i < 10000000; i++) {
                //genero un dni aleatorio
                int dni = (int) (Math.random() * 100000000);
                //genero un nombre aleatorio
                String nombre = "nombre-" + i;

                //escribo la linea en el archivo
                salida.println(dni + ";" + nombre);
            }
        } catch (java.io.IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //llamo al metodo para generar el archivo
        generarArchivo("archivo.csv");
    }

}
