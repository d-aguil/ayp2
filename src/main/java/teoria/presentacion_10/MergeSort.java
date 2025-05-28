package teoria.presentacion_10;

public class MergeSort {

    public static void mergeSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int mitad = (inicio + fin) / 2;

            mergeSort(arr, inicio, mitad);
            mergeSort(arr, mitad + 1, fin);
            mezclar(arr, inicio, mitad, fin);
        }
    }

    private static void mezclar(int[] arr, int inicio, int mitad, int fin) {
        int n1 = mitad - inicio + 1;
        int n2 = fin - mitad;

        // Crear arreglos temporales
        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        // Copiar datos a los arreglos temporales
        for (int i = 0; i < n1; ++i)
            izquierda[i] = arr[inicio + i];
        for (int j = 0; j < n2; ++j)
            derecha[j] = arr[mitad + 1 + j];

        // Mezclar los arreglos temporales
        int i = 0, j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j]) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes (si hay)
        while (i < n1) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = derecha[j];
            j++;
            k++;
        }
    }

    // Método principal de prueba
    public static void main(String[] args) {
        int[] arreglo = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arreglo, 0, arreglo.length - 1);

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
