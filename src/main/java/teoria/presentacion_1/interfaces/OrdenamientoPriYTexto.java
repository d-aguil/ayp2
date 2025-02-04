package teoria.presentacion_1.interfaces;

import java.util.Arrays;
import java.util.Collections;

public class OrdenamientoPriYTexto {

    public static void main(String[] args) {

        // Ordenar un array de enteros
        int[] numeros = {5, 2, 8, 1, 9};
        Arrays.sort(numeros);  // numeros = {1, 2, 5, 8, 9}

        // Ordenar un array de cadenas
        String[] nombres = {"Juan", "Ana", "Pedro", "Luis"};
        Arrays.sort(nombres);  // nombres = {"Ana", "Juan", "Luis", "Pedro"}
    }

    public static void main2(String[] args) {

        // Ordenar un array de enteros
        int[] numeros = {5, 2, 8, 1, 9};
        Arrays.sort(numeros);  // numeros = {1, 2, 5, 8, 9}
        for (int i = 0; i < numeros.length / 2; i++) {
            int temp = numeros[i];
            numeros[i] = numeros[numeros.length - i - 1];
            numeros[numeros.length - i - 1] = temp;
        }// numeros = {9, 8, 5, 2, 1}

        // Ordenar un array de cadenas
        String[] nombres = {"Juan", "Ana", "Pedro", "Luis"};
        Arrays.sort(nombres, Collections.reverseOrder());  // nombres = {"Pedro", "Luis", "Juan", "Ana"}
    }
}
