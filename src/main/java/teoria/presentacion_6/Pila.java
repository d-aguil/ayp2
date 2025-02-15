package teoria.presentacion_6;

public class Pila {

    private int[] datos;
    private int tamaño;

    public Pila(int capacidad) {
        datos = new int[capacidad];
        tamaño = 0;
    }

    public void apilar(int elemento) {
        datos[tamaño] = elemento;
        tamaño++;
    }

    public int desapilar() {
        tamaño--;
        return datos[tamaño];
    }

    public int cima() {
        return datos[tamaño - 1];
    }

    public int tamaño() {
        return tamaño;
    }

    public boolean esVacia() {
        return tamaño == 0;
    }
}