package teoria.presentacion_7.lista_iterable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListaInt implements Iterable{

    private Nodo cabeza;
    private int size;

    public ListaInt() {
        this.cabeza = null;
        this.size = 0;
    }

    public void add(int valor) {
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
    public int size() {
        return size;
    }

    public int get(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException();
        }
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        return temp.dato;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void listar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    @Override
    public Iterator iterator() {
        return new Iterador();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

    public class Iterador implements Iterator<Integer> {
        private Nodo actual = cabeza;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Integer next() {
            Integer valor = actual.dato;
            actual = actual.siguiente;
            return valor;
        }
    }
}