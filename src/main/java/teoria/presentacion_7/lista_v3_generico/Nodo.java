package teoria.presentacion_7.lista_v3_generico;

public class Nodo<T> {
    public T dato;
    public Nodo siguiente;

    Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
