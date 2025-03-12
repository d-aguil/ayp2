package teoria.presentacion_7.lista_v3_generico;

public class Main {

    public static void main(String[] args) {

        Lista<Integer> enteros = new Lista();
        enteros.add(1);
        enteros.add(2);
        enteros.add(3);
        enteros.listar();

        Lista<String> textos = new Lista();
        textos.add("hola");
        textos.add("-");
        textos.add("mundo");
        textos.listar();
    }
}
