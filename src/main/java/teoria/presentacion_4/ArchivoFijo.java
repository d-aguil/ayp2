package teoria.presentacion_4;

import java.io.*;

public class ArchivoFijo {
    public static void main(String[] args) {
        String ruta = "empleados_fijo.dat";

        // Escritura en el archivo
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "rw")) {
            guardarRegistro(raf, 1, "Juan", 30);
            guardarRegistro(raf, 2, "María Pérez González", 25);
            guardarRegistro(raf, 3, "Pedro", 40);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Lectura de un registro
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            System.out.println("Ingrese la posición del registro a leer (0, 1, 2): ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int posicion = Integer.parseInt(br.readLine());

            Empleado empleado = leerRegistro(raf, posicion);
            if (empleado != null) {
                System.out.println("Empleado encontrado: ID=" + empleado.id + ", Nombre=" + empleado.nombre + ", Edad=" + empleado.edad);
            } else {
                System.out.println("Posición inválida.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void guardarRegistro(RandomAccessFile raf, int id, String nombre, int edad) throws IOException {
        final int LONGITUD_NOMBRE = 50; // Máxima longitud del nombre
        byte[] bufferNombre = new byte[LONGITUD_NOMBRE];
        byte[] nombreBytes = nombre.getBytes();
        System.arraycopy(nombreBytes, 0, bufferNombre, 0, Math.min(nombreBytes.length, LONGITUD_NOMBRE));

        raf.writeInt(id); // 4 bytes
        raf.write(bufferNombre); // 50 bytes
        raf.writeInt(edad); // 4 bytes
    }

    private static Empleado leerRegistro(RandomAccessFile raf, int posicion) throws IOException {
        final int LONGITUD_REGISTRO = 4 + 50 + 4; // 4 (id) + 50 (nombre) + 4 (edad)
        raf.seek(posicion * LONGITUD_REGISTRO);

        int id = raf.readInt();
        byte[] bufferNombre = new byte[50];
        raf.read(bufferNombre);
        String nombre = new String(bufferNombre).trim();
        int edad = raf.readInt();

        return new Empleado(id, nombre, edad);
    }

    static class Empleado {
        int id;
        String nombre;
        int edad;

        public Empleado(int id, String nombre, int edad) {
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;
        }
    }
}