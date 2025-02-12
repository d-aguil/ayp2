package teoria.presentacion_6;

public class Pila {
    private int[] datos;
    private int cima;
    private final int capacidad;

    public Pila(int capacidadInicial) {
        capacidad = capacidadInicial;
        datos = new int[capacidad];
        cima = -1; // La pila está vacía
    }

    public void apilar(int elemento) {
        if (cima == capacidad - 1) {
            throw new CapacityExceededException("La pila está llena");
        }
        datos[++cima] = elemento;
    }

    public int desapilar() {
        if (cima == -1) {
            throw new EmptyStackException("La pila está vacía");
        }
        return datos[cima--];
    }

    public boolean estaVacia() {
        return cima == -1;
    }

    // Clases para representar excepciones
    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException(String mensaje) {

            super(mensaje);
        }
    }

    public static class CapacityExceededException extends RuntimeException {
        public CapacityExceededException(String mensaje) {

            super(mensaje);
        }
    }
}