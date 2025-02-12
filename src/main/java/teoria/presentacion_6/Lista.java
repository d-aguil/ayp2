package teoria.presentacion_6;

public class Lista {
    private int[] datos; // Arreglo para almacenar los elementos de la lista
    private int tamaño; // Cantidad de elementos en la lista
    private final int capacidad; // Capacidad máxima del arreglo (ahora es final)

    public Lista(int capacidadInicial) {
        capacidad = capacidadInicial;
        datos = new int[capacidad];
        tamaño = 0; // La lista está vacía
    }

    public void insertar(int elemento) {
        if (tamaño == capacidad) {
            throw new CapacityExceededException("La lista está llena");
        }
        datos[tamaño++] = elemento; // Inserta al final y aumenta el tamaño
    }

    public int eliminar() {
        if (tamaño == 0) {
            throw new EmptyListException("La lista está vacía");
        }
        return datos[--tamaño]; // Elimina del final y reduce el tamaño
    }

    public int obtener(int posicion) {
        if (tamaño == 0) {
            throw new EmptyListException("La lista está vacía");
        }
        if (posicion < 0 || posicion >= tamaño) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        return datos[posicion];
    }

    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    // Clases para representar excepciones
    public static class EmptyListException extends RuntimeException {
        public EmptyListException(String mensaje) {
            super(mensaje);
        }
    }

    public static class IndexOutOfBoundsException extends RuntimeException {
        public IndexOutOfBoundsException(String mensaje) {
            super(mensaje);
        }
    }

    public static class CapacityExceededException extends RuntimeException {
        public CapacityExceededException(String mensaje) {
            super(mensaje);
        }
    }
}