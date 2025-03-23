package teoria.presentacion_7.lista_doble_generico;

public class ListaDoble<T> {

    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamaño;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void agregarAlFinal(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
        if (estaVacía()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        tamaño++;
    }

    public void agregarAlInicio(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
        if (estaVacía()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cabeza.anterior = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
        tamaño++;
    }

    public boolean estaVacía() {
        return cabeza == null;
    }

    // Otros métodos: eliminar, buscar, etc.
}
