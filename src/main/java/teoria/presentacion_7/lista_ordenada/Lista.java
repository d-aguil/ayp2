package teoria.presentacion_7.lista_ordenada;

public class Lista {

    private Nodo primero;

    public Lista() {
        this.primero = null;
    }

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if ((primero == null) || (primero.dato > dato)) {
            nuevo.siguiente = primero;
            primero = nuevo;
        } else {
            agregarEnPosicionCorrecta(nuevo);
        }
    }

    private void agregarEnPosicionCorrecta(Nodo nuevo) {
        Nodo actual = primero;
        while (actual.siguiente != null && actual.siguiente.dato < nuevo.dato) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }


    public void listar() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    //
    public void eliminar(int dato) {
        if (primero != null) {
            if (primero.dato == dato) {
                primero = primero.siguiente;
            } else {
                Nodo actual = primero;
                while (actual.siguiente != null && actual.siguiente.dato != dato) {
                    actual = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente = actual.siguiente.siguiente;
                }
            }
        }
    }
}
