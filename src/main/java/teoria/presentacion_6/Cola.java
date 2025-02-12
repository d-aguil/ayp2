package teoria.presentacion_6;

public class Cola {
    private int[] datos;
    private int frente;
    private int finalCola;
    private final int capacidad;

    public Cola(int capacidadInicial) {
        capacidad = capacidadInicial;
        datos = new int[capacidad];
        frente = 0;
        finalCola = -1; // La cola está vacía
    }

    public void encolar(int elemento) {
        if (finalCola == capacidad - 1) {
            throw new CapacityExceededException("La cola está llena");
        }
        datos[++finalCola] = elemento;
    }

    public int desencolar() {
        if (frente > finalCola) {
            throw new EmptyQueueException("La cola está vacía");
        }
        return datos[frente++];
    }

    public boolean estaVacia() {
        return frente > finalCola;
    }

    // Clases para representar excepciones
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String mensaje) {

            super(mensaje);
        }
    }

    public static class CapacityExceededException extends RuntimeException {
        public CapacityExceededException(String mensaje) {

            super(mensaje);
        }
    }
}