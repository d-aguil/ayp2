package teoria.presentacion_9;

public class Nodo {
    protected int info;
    protected Nodo izq;
    protected Nodo der;

    public Nodo(int info) {
        this.info = info;
        this.izq = null;
        this.der = null;
    }
}
