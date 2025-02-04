package teoria.presentacion_1.object;

public class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persona persona = (Persona) obj;
        return edad == persona.edad && nombre.equals(persona.nombre);
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 30);
        Persona persona2 = new Persona("Juan", 30);
        Persona persona3 = new Persona("Pedro", 25);

        System.out.println("persona1 es igual a persona2: " + persona1.equals(persona2)); // true
        System.out.println("persona1 es igual a persona3: " + persona1.equals(persona3)); // false
    }
}