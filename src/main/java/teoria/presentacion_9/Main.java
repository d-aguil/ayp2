package teoria.presentacion_9;

public class Main {
    public static void main(String[] args) {
        // Crear un árbol de ejemplo
        NodoArbol raiz = new NodoArbol(10);
        raiz.izq = new NodoArbol(5);
        raiz.der = new NodoArbol(15);
        raiz.izq.izq = new NodoArbol(3);
        raiz.izq.der = new NodoArbol(7);
        raiz.der.izq = new NodoArbol(12);
        raiz.der.der = new NodoArbol(18);

        RecorridosArbol recorridos = new RecorridosArbol();

        System.out.println("Recorrido Preorden: " + recorridos.preorden(raiz));
        System.out.println("Recorrido Inorden: " + recorridos.inorden(raiz));
        System.out.println("Recorrido Postorden: " + recorridos.postorden(raiz));
        System.out.println("Recorrido Por Niveles: " + recorridos.porNiveles(raiz));
    }
}
