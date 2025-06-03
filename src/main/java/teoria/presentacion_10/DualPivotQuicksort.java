package teoria.presentacion_10;

import java.util.Arrays;
import java.util.Random;

public class DualPivotQuicksort {
    
    /**
     * Ordena el array usando Dual Pivot Quicksort
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        dualPivotQuicksort(arr, 0, arr.length - 1);
    }
    
    /**
     * Implementación principal del algoritmo Dual Pivot Quicksort
     */
    private static void dualPivotQuicksort(int[] arr, int left, int right) {
        // Caso base
        if (left >= right) return;
        
        // Para arrays pequeños, usa insertion sort (más eficiente)
        if (right - left < 27) {
            insertionSort(arr, left, right);
            return;
        }
        
        // Asegurar que arr[left] <= arr[right]
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        
        // Los dos pivotes
        int pivot1 = arr[left];
        int pivot2 = arr[right];
        
        // Si los pivotes son iguales, usa el algoritmo de 3-way partitioning
        if (pivot1 == pivot2) {
            threeWayPartition(arr, left, right, pivot1);
            return;
        }
        
        // Particionamiento con dos pivotes
        // Después del particionamiento:
        // arr[left+1..less-1] < pivot1
        // arr[less..great-1] están entre pivot1 y pivot2
        // arr[great+1..right-1] > pivot2
        
        int less = left + 1;
        int great = right - 1;
        
        // Particionamiento principal
        for (int k = less; k <= great; k++) {
            if (arr[k] < pivot1) {
                swap(arr, k, less);
                less++;
            } else if (arr[k] > pivot2) {
                // Buscar un elemento <= pivot2 desde great
                while (k < great && arr[great] > pivot2) {
                    great--;
                }
                swap(arr, k, great);
                great--;
                
                // Verificar si el elemento intercambiado es menor que pivot1
                if (arr[k] < pivot1) {
                    swap(arr, k, less);
                    less++;
                }
            }
        }
        
        // Colocar los pivotes en sus posiciones finales
        swap(arr, left, less - 1);
        swap(arr, right, great + 1);
        
        // Recursión en las tres particiones
        dualPivotQuicksort(arr, left, less - 2);
        dualPivotQuicksort(arr, less, great);
        dualPivotQuicksort(arr, great + 2, right);
    }
    
    /**
     * Particionamiento de 3 vías para elementos iguales
     */
    private static void threeWayPartition(int[] arr, int left, int right, int pivot) {
        int lt = left;
        int gt = right;
        int i = left;
        
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        
        // Recursión solo en las partes que no son iguales al pivot
        if (left < lt - 1) {
            dualPivotQuicksort(arr, left, lt - 1);
        }
        if (gt + 1 < right) {
            dualPivotQuicksort(arr, gt + 1, right);
        }
    }
    
    /**
     * Insertion sort para arrays pequeños
     */
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Intercambia dos elementos del array
     */
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}