package teoria.presentacion_7.pila;

public class Pila {

    private Nodo cabeza;

    public Pila() {
        this.cabeza = null;
    }

    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public Integer pop() {
        int valor = cabeza.dato;
        cabeza = cabeza.siguiente;
        return valor;
    }

    public Integer peek() {
        return cabeza.dato;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }
}