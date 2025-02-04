package teoria.presentacion_4;

public class DivisionSinExcepcion {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int resultado = a / b; // Esto lanzará una ArithmeticException
        System.out.println("Resultado: " + resultado);
    }
}