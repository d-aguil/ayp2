package teoria.presentacion_10;

public class QuickSortHoare {
    
    /**
     * Método principal para ordenar un array usando QuickSort con partición de Hoare
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el índice de partición usando el metodo de Hoare
            int pivotIndex = partitionHoare(arr, low, high);
            
            // Ordena recursivamente las dos mitades
            quickSort(arr, low, pivotIndex - 1);     // Lado izquierdo (excluye el pivot)
            quickSort(arr, pivotIndex + 1, high);    // Lado derecho (excluye el pivot)
        }
    }
    
    /**
     * Partición de Hoare: usa dos índices que se mueven desde los extremos
     * El pivot se fija al principio
     */
    private static int partitionHoare(int[] arr, int low, int high) {
        int pivot = arr[low]; // Fija el pivot al principio
        int i = low + 1;      // Índice izquierdo: comienza desde el segundo elemento
        int j = high;         // Índice derecho: comienza desde el último elemento

        while (true) {
            // Avanza i mientras los elementos sean menores o iguales al pivot
            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            // Retrocede j mientras los elementos sean mayores al pivot
            while (j >= low && arr[j] > pivot) {
                j--;
            }

            // Si los índices se cruzaron, termina el proceso
            if (i >= j) {
                break;
            }

            // Intercambia los elementos encontrados
            swap(arr, i, j);
        }

        // Intercambia el pivot con el elemento en la posición j
        swap(arr, low, j);
        return j; // Retorna la nueva posición del pivot
    }
    
    /**
     * Función auxiliar para intercambiar dos elementos
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Método de conveniencia para ordenar todo el array
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    /**
     * Método para imprimir el array con detalles del proceso
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 1, 9, 2, 7};
        
        System.out.println("=== QUICKSORT CON PARTICIÓN DE HOARE ===");
        System.out.println("Array original: " + java.util.Arrays.toString(arr));
        System.out.println();
        
        // Ordenamiento
        System.out.println("--- Ordenamiento ---");
        quickSort(arr);
        System.out.println("Array ordenado: " + java.util.Arrays.toString(arr));
    }
}