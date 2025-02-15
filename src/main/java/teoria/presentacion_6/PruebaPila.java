package teoria.presentacion_6;

public class PruebaPila {

    public static void main(String[] args) {
        Pila pila = new Pila(5);

        // Apilar elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        //
        System.out.println("Tamaño de la pila: " + pila.tamaño());
        System.out.println("Elemento en la cima de la pila: " + pila.cima());

        //
        int elemento = pila.desapilar();
        System.out.println("Elemento desapilado: " + elemento);

        //
        System.out.println("¿La pila está vacía?: " + pila.esVacia());
    }
}