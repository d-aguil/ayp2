package teoria.presentacion_10;

public class QuickSortWorstCase {
    
    private static int partitionCount = 0;
    
    /**
     * QuickSort con partición de Hoare - primer elemento como pivot
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionHoare(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * Partición de Hoare con debugging para mostrar el peor caso
     */
    private static int partitionHoare(int[] arr, int low, int high) {
        partitionCount++;
        int pivot = arr[low]; // Primer elemento como pivot
        int i = low + 1;
        int j = high;
        
        System.out.println("Partición #" + partitionCount + " - Rango [" + low + "..." + high + "]");
        System.out.println("  Pivot: " + pivot + " (posición " + low + ")");
        System.out.println("  Array: " + arrayToString(arr, low, high));
        
        while (true) {
            // i avanza buscando elementos > pivot
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            
            // j retrocede buscando elementos <= pivot
            while (j >= low && arr[j] > pivot) {
                j--;
            }
            
            if (i >= j) {
                break;
            }
            
            // Intercambiar elementos
            System.out.println("  Intercambio: arr[" + i + "]=" + arr[i] + 
                             " ↔ arr[" + j + "]=" + arr[j]);
            swap(arr, i, j);
        }
        
        // Intercambiar pivot con arr[j]
        if (j != low) {
            System.out.println("  Intercambio final: pivot arr[" + low + "]=" + arr[low] + 
                             " ↔ arr[" + j + "]=" + arr[j]);
            swap(arr, low, j);
        } else {
            System.out.println("  Pivot ya está en su lugar");
        }
        
        System.out.println("  Resultado: " + arrayToString(arr, low, high));
        System.out.println("  Pivot final en posición: " + j);
        System.out.println("  Particiones resultantes: [" + low + "..." + (j-1) + "] y [" + (j+1) + "..." + high + "]");
        System.out.println();
        
        return j;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static String arrayToString(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
            if (i < end) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== QUICKSORT - PEOR CASO ===");
        System.out.println("Array ya ordenado con primer elemento como pivot\n");
        
        // PEOR CASO: Array ordenado ascendente
        int[] worstCase = {1, 2, 3, 4, 5};
        partitionCount = 0;
        
        System.out.println("Array original: " + java.util.Arrays.toString(worstCase));
        System.out.println("Tamaño: " + worstCase.length);
        System.out.println();
        
        quickSort(worstCase, 0, worstCase.length - 1);
        
        System.out.println("Array final: " + java.util.Arrays.toString(worstCase));
        System.out.println("Total de particiones: " + partitionCount);
        System.out.println("Complejidad: O(n²) - " + partitionCount + " particiones para " + worstCase.length + " elementos");
        
        System.out.println("\n" + "=".repeat(50));
        
        // Comparación con caso promedio
        int[] avgCase = {3, 1, 4, 2, 5};
        partitionCount = 0;
        
        System.out.println("\nComparación - Caso promedio:");
        System.out.println("Array original: " + java.util.Arrays.toString(avgCase));
        
        quickSort(avgCase, 0, avgCase.length - 1);
        
        System.out.println("Array final: " + java.util.Arrays.toString(avgCase));
        System.out.println("Total de particiones: " + partitionCount);
        System.out.println("Complejidad: O(n log n) - " + partitionCount + " particiones para " + avgCase.length + " elementos");
    }
}