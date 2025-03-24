package teoria.presentacion_7.lista_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listas {

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList();

        lista.add(20);
        lista.add(10);
        lista.add(30);

        //
        for(int i=0; i< lista.size();i++){
            System.out.println(lista.get(i));
        }

    }

    public static void main2(String[] args) {

        List<Integer> lista = new LinkedList();

        lista.add(20);
        lista.add(10);
        lista.add(30);

        //
        for(int i=0; i< lista.size();i++){
            System.out.println(lista.get(i));
        }

    }
}
