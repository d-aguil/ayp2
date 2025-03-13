package teoria.presentacion_7.genericos;

public class Main {

    public static void main(String[] args) {

        Caja<Integer> cajaEnteros = new Caja<>();
        cajaEnteros.guardar(10);
        int valorEntero = cajaEnteros.obtener();

        Caja<String> cajaCadenas = new Caja<>();
        cajaCadenas.guardar("Hola");
        String valorCadena = cajaCadenas.obtener();
    }
}
