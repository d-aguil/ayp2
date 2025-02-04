package teoria.presentacion_1.interfaces.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        Persona[] personas = new Persona[3];
        personas[0] = new Persona("Juan", 30);
        personas[1] = new Persona("Ana", 25);
        personas[2] = new Persona("Pedro", 40);

        // Crear una instancia del comparador
        ComparadorPorNombre comparador = new ComparadorPorNombre();

        Arrays.sort(personas, comparador);

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}