package teoria.presentacion_7.lista_doble;

public class NodoEntero {
    int valor;
    NodoEntero anterior;
    NodoEntero siguiente;

    public NodoEntero(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }
}