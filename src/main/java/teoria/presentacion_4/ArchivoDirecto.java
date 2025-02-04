package teoria.presentacion_4;

/**
 * Campos :
 *  id: Entero (4 bytes).
 *  nombre: Cadena de texto con longitud máxima de 50 caracteres (50 bytes).
 *  edad: Entero (4 bytes).
 * Tamaño total :
 *  id + nombre + edad = 4 + 50 + 4 = 58 bytes .
 * Redondeo :
 *  Podríamos redondear a 60 bytes para dejar un pequeño margen.
 *  Entonces, en lugar de usar 100 bytes, podríamos modificar el código para usar 60 bytes por registro:
 */

import java.io.*;

public class ArchivoDirecto {
    static class Empleado implements Serializable {
        int id;
        String nombre;
        int edad;

        public Empleado(int id, String nombre, int edad) {
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad;
        }
    }

    public static void main(String[] args) {
        String ruta = "empleados.dat";

        // Escritura en el archivo (organización directa)
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "rw")) {
            // Guardar registros en posiciones específicas
            Empleado empleado1 = new Empleado(1, "Juan", 30);
            Empleado empleado2 = new Empleado(2, "María", 25);
            Empleado empleado3 = new Empleado(3, "Pedro", 40);

            // Convertir objetos a bytes y escribir en el archivo
            escribirEmpleado(raf, 0, empleado1);
            escribirEmpleado(raf, 1, empleado2);
            escribirEmpleado(raf, 2, empleado3);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Lectura directa de un registro
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            System.out.println("Ingrese la posición del registro a leer (0, 1, 2): ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int posicion = Integer.parseInt(br.readLine());

            Empleado empleado = leerEmpleado(raf, posicion);
            if (empleado != null) {
                System.out.println("Registro leído: " + empleado);
            } else {
                System.out.println("Posición inválida.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void escribirEmpleado(RandomAccessFile raf, int posicion, Empleado empleado) throws IOException {
        raf.seek(posicion * 100); // Cada registro ocupa 100 bytes (longitud fija)
        byte[] buffer = new byte[100];
        String data = empleado.id + "," + empleado.nombre + "," + empleado.edad;
        System.arraycopy(data.getBytes(), 0, buffer, 0, data.length());
        raf.write(buffer);
    }

    private static Empleado leerEmpleado(RandomAccessFile raf, int posicion) throws IOException {
        raf.seek(posicion * 100); // Ir a la posición específica
        byte[] buffer = new byte[100];
        raf.read(buffer);
        String data = new String(buffer).trim();
        if (data.isEmpty()) return null;

        String[] campos = data.split(",");
        int id = Integer.parseInt(campos[0]);
        String nombre = campos[1];
        int edad = Integer.parseInt(campos[2]);
        return new Empleado(id, nombre, edad);
    }
}