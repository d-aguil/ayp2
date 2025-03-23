package teoria.presentacion_7.lista_v1;

public class Main {

    public static void main(String[] args) {

        Nodo nodo1 = new Nodo(10);
        Nodo nodo2 = new Nodo(20);
        nodo1.siguiente = nodo2;


        ListaInt lista = new ListaInt();
        lista.agregar(14);
        lista.agregar(7);
        lista.agregar(21);
        lista.listar();
    }
}
