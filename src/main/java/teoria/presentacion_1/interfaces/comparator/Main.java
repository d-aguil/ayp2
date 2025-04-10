package teoria.presentacion_1.interfaces.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main2(String[] args) {
        Persona[] personas = new Persona[3];
        personas[0] = new Persona("Ana", "perez", 30);
        personas[1] = new Persona("juan", "Perez", 25);
        personas[2] = new Persona("Pedro", "perez", 40);

        // Crear una instancia del comparador
        ComparadorPorNombre comparaXNombre = new ComparadorPorNombre();
        ComparadorPorApellido comparXApellido = new ComparadorPorApellido();
        Arrays.sort(personas, comparXApellido.thenComparing(comparaXNombre));

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public static void main(String[] args) {
        Persona[] personas = {
                new Persona("Juan", "Perez",30),
                new Persona("Ana", "Gomez", 40),
                new Persona("Juan", "Gomez", 25),
                new Persona("Carlos", "Perez", 66)
        };

        // Comparator para apellido
        Comparator<Persona> apellidoComparator = Comparator.comparing(Persona::getApellido);

        // Comparator para nombre
        Comparator<Persona> nombreComparator = Comparator.comparing(Persona::getNombre);

        // Ordenar el arreglo usando un Comparator anidado
        Arrays.sort(personas, apellidoComparator.thenComparing(nombreComparator));

        // Imprimir el arreglo ordenado
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
