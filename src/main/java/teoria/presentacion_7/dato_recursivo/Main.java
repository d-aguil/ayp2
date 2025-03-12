package teoria.presentacion_7.dato_recursivo;

public class Main {
    public static void main(String[] args) {
        Carpeta raiz = new Carpeta("raiz");
        raiz.add(new Archivo("documento.txt", "Este es un documento de texto."));
        Carpeta carpetaFotos = new Carpeta("fotos");
        carpetaFotos.add(new Archivo("perro.jpg", "..."));
        carpetaFotos.add(new Archivo("gato.jpg", "..."));
        raiz.add(carpetaFotos);

        //System.out.println(raiz.ls());
        System.out.println(raiz.ls(true));
    }
}