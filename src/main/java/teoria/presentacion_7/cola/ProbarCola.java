package teoria.presentacion_7.cola;

public class ProbarCola {

    public static void main(String[] args) {
        Cola cola = new Cola();

        // Agregar elementos a la cola
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        // Mostrar el elemento en la cabeza de la cola
        System.out.println("Elemento en la cabeza de la cola: " + cola.peek());

        // Eliminar un elemento de la cola
        int elemento = cola.dequeue();
        System.out.println("Elemento eliminado de la cola: " + elemento);

        // Sacamos y mostramos todos los elementos restantes
        while (!cola.isEmpty()) {
            System.out.println("Elemento eliminado de la cola: " + cola.dequeue());
        }

        System.out.println("¿La cola está vacía?: " + cola.isEmpty());
    }
}