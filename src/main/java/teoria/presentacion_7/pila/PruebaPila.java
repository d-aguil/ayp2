package teoria.presentacion_7.pila;

public class PruebaPila {

    public static void main(String[] args) {
        Pila pila = new Pila();

        // Agregar elementos a la pila
        pila.push(10);
        pila.push(20);
        pila.push(30);

        // Mostrar el elemento en la cima de la pila
        System.out.println("Elemento en la cima de la pila: " + pila.peek());

        // Eliminar un elemento de la pila
        int elemento = pila.pop();
        System.out.println("Elemento eliminado de la pila: " + elemento);

        // Sacamos y mostramos todos los elementos restantes
        while(pila.isEmpty() == false) {
            System.out.println("Elemento eliminado de la pila: " + pila.pop());
        }

        System.out.println("¿La pila está vacía?: " + pila.isEmpty());
    }
}