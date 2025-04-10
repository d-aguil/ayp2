package teoria.presentacion_8.direccionamiento_cerrado;

import java.util.ArrayList;
import java.util.List;

public class TablaHash {

    private List<Persona>[] tabla;
    private int capacidad;
    private int elementos;

    public TablaHash(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.tabla = new ArrayList[capacidadInicial];
        this.elementos = 0;
        //
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new ArrayList();
        }
    }

    private int hash(Integer clave) {
        return clave % capacidad;
    }

    public boolean insertar(Persona persona) {

        int indice = hash(persona.getDni());

        List<Persona> listaEnIndice = tabla[indice];

        if (!listaEnIndice.contains(persona)) {
            listaEnIndice.add(persona);
            elementos++;
            return true;
        }
        return true;
    }

    public Persona buscar(Integer dni) {

        int indice = hash(dni);

        List<Persona> listaEnIndice = tabla[indice];

        for (Persona persona : listaEnIndice) {
            if (persona.getDni().equals(dni)) {
                return persona;
            }
        }
        return null;
    }

    public void mostrarTabla() {
        System.out.println("Tabla Hash (capacidad: " + capacidad + ", elementos: " + elementos + ")");
        for (int i = 0; i < capacidad; i++) {
            if (!tabla[i].isEmpty()) {
                System.out.println("Índice " + i + ": " + tabla[i]);
            }
        }
    }

    public static void main(String[] args) {
        TablaHash tablaHash = new TablaHash(10);
        tablaHash.insertar(new Persona("Juan", 12345678));
        tablaHash.insertar(new Persona("Pedro", 87654321));
        tablaHash.insertar(new Persona("María", 11223344));
        tablaHash.insertar(new Persona("Ana", 44556677));
        tablaHash.insertar(new Persona("Luis", 22345678));

        tablaHash.mostrarTabla();

        System.out.println("\nBuscar persona con DNI 22345678: " + tablaHash.buscar(22345678));
        System.out.println("Buscar persona con DNI 12345678: " + tablaHash.buscar(12345678));
        System.out.println("Buscar persona con DNI 99999999: " + tablaHash.buscar(99999999));
    }
}