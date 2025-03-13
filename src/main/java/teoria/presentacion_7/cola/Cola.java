package teoria.presentacion_7.cola;

public class Cola {

    private Nodo cabeza;
    private Nodo ultimo;
    private int size;

    public Cola() {
        this.cabeza = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void enqueue(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (isEmpty()) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
        size++;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }
        int valor = cabeza.dato;
        cabeza = cabeza.siguiente;
        size--;
        if (isEmpty()) {
            ultimo = null;
        }
        return valor;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return cabeza.dato;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}