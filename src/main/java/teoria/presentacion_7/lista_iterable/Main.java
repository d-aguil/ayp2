package teoria.presentacion_7.lista_iterable;


import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ListaInt lista = new ListaInt();
        lista.add(30);
        lista.add(10);
        lista.add(40);
        lista.add(20);

        lista.listar();

        System.out.println("-------------");
        for(int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

        System.out.println("-------------");
        Iterator it = lista.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-------------");
        lista.forEach(
                (p) -> System.out.println(p)
        );
    }
}
