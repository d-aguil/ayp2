package teoria.presentacion_1.memoria;

public class Persona {

    String nombre;	// Parte del objeto Persona, se almacena en el heap
    int edad;	// Parte del objeto Persona, se almacena en el heap

    public Persona(String nombre, int edad) {
        this.nombre = nombre;// nombre (referencia) se almacenan en el stack
        this.edad = edad;	//   edad (referencia) se almacenan en el stack
    }

    // args (referencia) se almacena en el stack
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {// i se almacena en el stack

            // persona (referencia) en el stack, objeto Persona en el heap
            Persona persona = new Persona("Persona " + i, 20 + i);
            // mensaje (referencia) en el stack, objeto String en el heap
            String mensaje = "Persona creada: " + persona.nombre + ", " + persona.edad;

        }
    }
}
