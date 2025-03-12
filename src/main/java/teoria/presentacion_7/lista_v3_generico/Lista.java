package teoria.presentacion_7.lista_v3_generico;

import java.util.Objects;

public class Lista<T> {

    private static class Nodo<T> {
        T dato;
        Nodo siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> cabeza;
    private int size;

    public Lista() {
        this.cabeza = null;
        this.size = 0;
    }

    public void add(T valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        size++;
    }

    public void add(int indice, int valor) {
        if (indice < 0 || indice > size) {
            throw new IndexOutOfBoundsException();
        }
        Nodo nuevoNodo = new Nodo(valor);
        if (indice == 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.siguiente;
            }
            nuevoNodo.siguiente = temp.siguiente;
            temp.siguiente = nuevoNodo;
        }
        size++;
    }

    public void remove(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (indice == 0) {
            cabeza = cabeza.siguiente;
        } else {
            Nodo temp = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.siguiente;
            }
            temp.siguiente = temp.siguiente.siguiente;
        }
        size--;
    }

    public T get(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException();
        }
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        return (T)temp.dato;
    }

    public void set(int indice, int valor) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException();
        }
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        temp.dato = valor;
    }

    public int indexOf(T valor) {
        Nodo temp = cabeza;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(temp.dato,valor)) {
                return i;
            }
            temp = temp.siguiente;
        }
        return -1;
    }

    public void listar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}