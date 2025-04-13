package teoria.presentacion_9;

public class NodoArbol {
    int info;
    NodoArbol izq;
    NodoArbol der;

    public NodoArbol(int info) {
        this.info = info;
        this.izq = null;
        this.der = null;
    }
}
