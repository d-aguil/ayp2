package teoria.presentacion_7.multilista;

class PuntCur {
    Curso info;
    PuntCur sig;
    NodoMulti nodo;

    public PuntCur(Curso info) {
        this.info = info;
    }
}