package teoria.presentacion_7.lista_v1;

public class ListaInt {

    private Nodo cabeza;

    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    public void listar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    public void eliminar(int valor){
        if (cabeza == null) {
            return;
        }
        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente != null && temp.siguiente.dato != valor) {
            temp = temp.siguiente;
        }
        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }
}