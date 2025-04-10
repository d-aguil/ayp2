package teoria.presentacion_8.direccionamiento_abierto;

public class TablaHash {

    private Persona[] tabla;
    private final int capacidad;
    private int elementos;

    public TablaHash(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.tabla = new Persona[capacidadInicial];
        this.elementos = 0;
    }

    public boolean insertar(Persona persona) {
        if (elementos == capacidad) {
            System.out.println("La tabla hash está llena, no se puede insertar.");
            return false;
        }

        int indice = hash(persona.getDni());

        for (int i = 0; i < capacidad; i++) {
            if (tabla[indice] == null) {
                tabla[indice] = persona;
                System.out.println("Insertando " + persona + " en índice " + indice);
                elementos++;
                return true;
            } else if (tabla[indice].equals(persona)) {
                //la persona existe
                return true;
            }
            indice = (indice + 1) % capacidad;
        }
        return false;
    }

    private int hash(Integer clave) {
        return clave % capacidad;
    }

    public Persona buscar(Integer dni) {

        int indice = dni % capacidad;

        for (int i = 0; i < capacidad; i++) {
            if (tabla[indice] != null) {
                if (tabla[indice].getDni().equals(dni)) {
                    return tabla[indice];
                }
            }else{
                // Si encontramos una posición vacía, significa que el elemento no está en la tabla
                break;
            }
            indice = (indice + 1) % capacidad;
        }

        //
        return null;
    }

    public void listar() {
        System.out.println("Tabla Hash (capacidad: " + capacidad + ", elementos: " + elementos + ")");
        for (int i = 0; i < capacidad; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }

    public static void main(String[] args) {
        TablaHash tablaHash = new TablaHash(10);
        tablaHash.insertar(new Persona("Juan", 24345678));
        tablaHash.insertar(new Persona("Pedro", 27654321));
        tablaHash.insertar(new Persona("María", 21223344));
        tablaHash.insertar(new Persona("Ana", 44556677));
        tablaHash.insertar(new Persona("Luis", 32345678));

        tablaHash.listar();

        System.out.println("Buscar persona con DNI 32345678: " + tablaHash.buscar(32345678));
        System.out.println("Buscar persona con DNI 12345679: " + tablaHash.buscar(12345679));
        System.out.println("Buscar persona con DNI 99999999: " + tablaHash.buscar(99999999));
    }
}