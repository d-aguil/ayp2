package teoria.presentacion_6;

import java.util.Iterator;

public class Lista implements Iterable<Integer> {

    private int[] datos;
    private int tamaño;

    public Lista(int capacidad) {
        datos = new int[capacidad];
        tamaño = 0;
    }

    public void insertar(int elemento, int posicion) {
        for (int i = tamaño; i > posicion; i--) {
            datos[i] = datos[i - 1];
        }
        datos[posicion] = elemento;
        tamaño++;
    }

    public void agregar(int elemento) {
        datos[tamaño] = elemento;
        tamaño++;
    }

    public void eliminar(int posicion) {
        for (int i = posicion; i < tamaño - 1; i++) {
            datos[i] = datos[i + 1];
        }
        tamaño--;
    }

    public int obtener(int posicion) {
        return datos[posicion];
    }

    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IteradorLista();
    }

    private class IteradorLista implements Iterator<Integer> {
        private int posicion = 0;

        @Override
        public boolean hasNext() {
            return posicion < tamaño;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            int elemento = datos[posicion];
            posicion++;
            return elemento;
        }
    }
}