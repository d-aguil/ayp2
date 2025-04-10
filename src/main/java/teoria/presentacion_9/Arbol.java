package teoria.presentacion_9;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int elemento) {
        NodoArbol nuevoNodo = new NodoArbol(elemento);

        if (raiz == null) {
            raiz = nuevoNodo;
            return; // Si el árbol está vacío, el nuevo nodo es la raíz y terminamos.
        }

        NodoArbol aux = raiz;
        NodoArbol ant = null;

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
}