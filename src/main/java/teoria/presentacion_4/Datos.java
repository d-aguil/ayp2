package teoria.presentacion_4;

public class Datos {

    private Integer id;
    private String nombre;
    private String descripción;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    @Override
    public String toString() {
        return "Datos{id=" + id + ", nombre='" + nombre + "', descripción=" + descripción + "}";
    }
}
