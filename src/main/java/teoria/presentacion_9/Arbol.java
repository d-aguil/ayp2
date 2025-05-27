package teoria.presentacion_9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arbol {
    private Nodo raiz;

    public Arbol() {

        this.raiz = null;
    }

    public void insertar(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);

        if (raiz == null) {
            raiz = nuevoNodo;
            return;
        }

        Nodo aux = raiz;
        Nodo ant = null;

        while (aux != null) {
            ant = aux;
            if (elemento < aux.info) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
        }

        if (elemento < ant.info) {
            ant.izq = nuevoNodo;
        } else {
            ant.der = nuevoNodo;
        }
    }

    //insertar recursivo
    public void insertarRecursivo(int elemento) {

        raiz = insertarRecursivo(raiz, elemento);
    }

    private Nodo insertarRecursivo(Nodo nodo, int elemento) {
        if (nodo == null) {
            return new Nodo(elemento);
        }

        if (elemento < nodo.info) {
            nodo.izq = insertarRecursivo(nodo.izq, elemento);
        } else {
            nodo.der = insertarRecursivo(nodo.der, elemento);
        }

        return nodo;
    }

    //listar en orden
    public void listarEnOrden() {
        listarEnOrden(raiz);
    }
    private void listarEnOrden(Nodo nodo) {
        if (nodo != null) {
            listarEnOrden(nodo.izq);
            System.out.print(nodo.info + " ");
            listarEnOrden(nodo.der);
        }
    }

    //listar en orden iterativo
    public void listarEnOrdenIterativo() {
        if (raiz == null) {
            return;
        }

        Stack<Nodo> pila = new Stack<>();
        Nodo actual = raiz;

        while (actual != null || !pila.isEmpty()) {
            while (actual != null) {
                pila.push(actual);
                actual = actual.izq;
            }

            actual = pila.pop();
            System.out.print(actual.info + " ");
            actual = actual.der;
        }
    }

    //listar por niveles
    public void listarPorNiveles() {
        if (raiz == null) {
            return;
        }

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.info + " ");

            if (actual.izq != null) {
                cola.add(actual.izq);
            }
            if (actual.der != null) {
                cola.add(actual.der);
            }
        }
    }

    //buscar
    public boolean buscar(int elemento) {

        return buscar(raiz, elemento);
    }

    private boolean buscar(Nodo nodo, int elemento) {
        if (nodo == null) {
            return false;
        }

        if (nodo.info == elemento) {
            return true;
        } else if (elemento < nodo.info) {
            return buscar(nodo.izq, elemento);
        } else {
            return buscar(nodo.der, elemento);
        }
    }

    //buscar iterativo
    public Nodo buscarIterativo(int elemento) {
        Nodo actual = raiz;

        while (actual != null) {
            if (actual.info == elemento) {
                return actual;
            } else if (elemento < actual.info) {
                actual = actual.izq;
            } else {
                actual = actual.der;
            }
        }

        return null;
    }
}