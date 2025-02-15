package teoria.presentacion_6;

public class PruebaCola {

    public static void main(String[] args) {
        Cola cola = new Cola(5);

        //
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);

        //
        System.out.println("Tamaño de la cola: " + cola.tamaño());
        System.out.println("Elemento al frente de la cola: " + cola.frente());

        //
        int elemento = cola.desencolar();
        System.out.println("Elemento desencolado: " + elemento);

        //
        System.out.println("¿La cola está vacía?: " + cola.esVacia());
    }
}