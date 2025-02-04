package teoria.presentacion_4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ArchivoIndexado {
    public static void main(String[] args) {
        String rutaPrincipal = "empleados_var.dat";
        String rutaIndice = "indice.dat";

        // Escritura en el archivo principal y creación del índice
        Map<Integer, Long> indice = new HashMap<>();
        try (RandomAccessFile raf = new RandomAccessFile(rutaPrincipal, "rw")) {
            // Guardar registros y registrar sus posiciones
            guardarRegistro(raf, indice, 1, "Juan", 30);
            guardarRegistro(raf, indice, 2, "María Pérez González", 25);
            guardarRegistro(raf, indice, 3, "Pedro", 40);

            // Guardar el índice en un archivo separado
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaIndice))) {
                oos.writeObject(indice);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Lectura de un registro usando el índice
        try (RandomAccessFile raf = new RandomAccessFile(rutaPrincipal, "r")) {
            // Cargar el índice desde el archivo
            Map<Integer, Long> indiceCargado;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaIndice))) {
                indiceCargado = (Map<Integer, Long>) ois.readObject();
            }

            System.out.println("Ingrese el ID del empleado a buscar: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int idBuscado = Integer.parseInt(br.readLine());

            if (indiceCargado.containsKey(idBuscado)) {
                long posicion = indiceCargado.get(idBuscado);
                raf.seek(posicion);
                String linea = raf.readLine();
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                System.out.println("Empleado encontrado: ID=" + id + ", Nombre=" + nombre + ", Edad=" + edad);
            } else {
                System.out.println("Empleado no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void guardarRegistro(RandomAccessFile raf, Map<Integer, Long> indice, int id, String nombre, int edad) throws IOException {
        long posicion = raf.getFilePointer(); // Obtener la posición actual
        indice.put(id, posicion); // Registrar la posición en el índice
        raf.writeBytes(id + "," + nombre + "," + edad + "\n"); // Escribir el registro
    }
}