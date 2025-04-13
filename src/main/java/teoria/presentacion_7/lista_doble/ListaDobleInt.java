package teoria.presentacion_7.lista_doble;

public class ListaDobleInt {

    // Primer nodo
    private NodoEntero cabeza;

    // Último nodo
    private NodoEntero cola;

    private int tamaño;

    public ListaDobleInt() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void agregarAlFinal(int valor) {
        NodoEntero nuevoNodo = new NodoEntero(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        tamaño++;
    }

    public void agregarAlInicio(int valor) {
        NodoEntero nuevoNodo = new NodoEntero(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cabeza.anterior = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
        tamaño++;
    }

    public boolean estaVacia() {

        return cabeza == null;
    }

    // Otros métodos: eliminar, buscar ...

}

