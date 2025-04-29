package teoria.presentacion_9;

public class Main {
    public static void main(String[] args) {
        // Crear un árbol de ejemplo
        Nodo raiz = new Nodo(10);
        raiz.izq = new Nodo(5);
        raiz.der = new Nodo(15);
        raiz.izq.izq = new Nodo(3);
        raiz.izq.der = new Nodo(7);
        raiz.der.izq = new Nodo(12);
        raiz.der.der = new Nodo(18);

        RecorridosArbol recorridos = new RecorridosArbol();

        System.out.println("Recorrido Preorden: " + recorridos.preorden(raiz));
        System.out.println("Recorrido Inorden: " + recorridos.inorden(raiz));
        System.out.println("Recorrido Postorden: " + recorridos.postorden(raiz));
        System.out.println("Recorrido Por Niveles: " + recorridos.porNiveles(raiz));
    }
}
