package teoria.presentacion_6;

public class Cola {

    private int[] datos;
    private int frente;
    private int fin;
    private int tamaño;

    public Cola(int capacidad) {
        datos = new int[capacidad];
        frente = 0;
        fin = 0;
        tamaño = 0;
    }

    public void encolar(int elemento) {
        datos[fin] = elemento;
        fin = (fin + 1) % datos.length;
        tamaño++;
    }

    public int desencolar() {
        int elemento = datos[frente];
        frente = (frente + 1) % datos.length;
        tamaño--;
        return elemento;
    }

    public int frente() {
        return datos[frente];
    }

    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}