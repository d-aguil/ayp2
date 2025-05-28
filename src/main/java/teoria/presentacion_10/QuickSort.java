package teoria.presentacion_10;

public class QuickSort {
    
    /**
     * Método principal para ordenar un array usando QuickSort
     * @param arr Array a ordenar
     * @param low Índice inicial
     * @param high Índice final
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el índice de partición
            int pivotIndex = partition(arr, low, high);
            
            // Ordena recursivamente los elementos antes y después de la partición
            quickSort(arr, low, pivotIndex - 1);  // Lado izquierdo
            quickSort(arr, pivotIndex + 1, high); // Lado derecho
        }
    }
    
    /**
     * Función que toma el último elemento como pivot,
     * coloca el pivot en su posición correcta y
     * coloca todos los elementos menores a la izquierda
     * y todos los mayores a la derecha del pivot
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Elegimos el último elemento como pivot
        int i = low - 1; // Índice del elemento más pequeño
        
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Coloca el pivot en su posición correcta
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Función auxiliar para intercambiar dos elementos en el array
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
     * Método para imprimir el array
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * Ejemplo de uso
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 5};
        
        System.out.println("Array original:");
        printArray(arr);
        
        quickSort(arr);
        
        System.out.println("Array ordenado:");
        printArray(arr);
    }
}