package teoria.presentacion_6;

public class PruebaLista {

    public static void main(String[] args) {
        Lista lista = new Lista(5);

        //
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        //
        lista.insertar(15, 1);

        //
        for (int i = 0; i < lista.tamaño(); i++) {
            System.out.println(lista.obtener(i));
        }

        //
        lista.eliminar(2);

        //
        System.out.println("¿La lista está vacía?: " + lista.esVacia());
    }
}