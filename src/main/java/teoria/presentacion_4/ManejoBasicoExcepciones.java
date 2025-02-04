package teoria.presentacion_4;

public class ManejoBasicoExcepciones {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int resultado = a / b; // Esto lanzará una ArithmeticException
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        } finally {
            System.out.println("Este bloque siempre se ejecuta.");
        }
    }
}