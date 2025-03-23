package teoria.presentacion_7.lista_doble_generico;

public class NodoDoble<T> {
    public T valor;
    public NodoDoble<T> anterior;
    public NodoDoble<T> siguiente;

    public NodoDoble(T valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }
}