package teoria.presentacion_7.genericos;

public class Caja<T> {
    private T contenido;

    public void guardar(T valor) {

        this.contenido = valor;
    }

    public T obtener() {

        return this.contenido;
    }
}
