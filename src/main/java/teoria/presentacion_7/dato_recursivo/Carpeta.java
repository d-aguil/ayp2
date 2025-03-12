package teoria.presentacion_7.dato_recursivo;

public class Carpeta {
    private String nombre;

    private Archivo[] archivos;
    private int cantidadArchivos;

    private Carpeta[] carpetas;
    private int cantidadCarpetas;

    public Carpeta(String nombre) {
        this.nombre = nombre;

        this.archivos = new Archivo[8];
        this.cantidadArchivos = 0;

        this.carpetas = new Carpeta[8];
        this.cantidadCarpetas = 0;
    }

    public void add(Archivo archivo) {
        this.archivos[cantidadArchivos++] = archivo;
    }

    public void add(Carpeta carpeta) {
        this.carpetas[cantidadCarpetas++] = carpeta;
    }

    public String ls(boolean recursivo) {
        StringBuilder contenido = new StringBuilder("Listando el directorio "+ nombre + "/\n");
        for (int i=0;i<cantidadArchivos;i++) {
            contenido.append("  - ").append(archivos[i].nombre).append("\n");
        }
        for (int i=0;i<cantidadCarpetas;i++) {
            if(recursivo){
                contenido.append(carpetas[i].ls(true));
            }else {
                contenido.append("  - ").append(carpetas[i].nombre).append("/\n");
            }

        }
        return contenido.toString();
    }

    public String ls() {
        return ls(false);
    }
}
