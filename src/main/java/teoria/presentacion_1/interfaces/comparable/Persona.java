package teoria.presentacion_1.interfaces.comparable;

import java.util.Arrays;

public class Persona implements Comparable<Persona> {

    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        // Comparar por edad
        return this.edad - otraPersona.edad;
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 30);
        Persona persona2 = new Persona("Ana", 25);

        int resultado = persona1.compareTo(persona2);

        if (resultado < 0) {
            System.out.println("persona1 es menor que persona2");
        } else if (resultado > 0) {
            System.out.println("persona1 es mayor que persona2");
        } else {
            System.out.println("persona1 es igual a persona2");
        }
    }

    public static void main2(String[] args) {
        Persona[] personas = new Persona[3];
        personas[0] = new Persona("Juan", 30);
        personas[1] = new Persona("Ana", 25);
        personas[2] = new Persona("Pedro", 40);

        Arrays.sort(personas);

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}