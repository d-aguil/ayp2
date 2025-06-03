package teoria.presentacion_10;

import java.util.Arrays;

public class TimSort {
    private static final int MIN_MERGE = 32;
    
    /**
     * Ordena el array usando el algoritmo TimSort
     */
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        
        // Si el array es pequeño, usa insertion sort directamente
        if (n < MIN_MERGE) {
            insertionSort(arr, 0, n);
            return;
        }
        
        // Calcula el tamaño mínimo de run
        int minRun = getMinRunLength(n);
        
        // Crear stack para manejar los runs pendientes
        RunStack runStack = new RunStack();
        
        int start = 0;
        while (start < n) {
            // Encuentra o crea un run
            int runLen = countRunAndMakeAscending(arr, start, n);
            
            // Si el run es muy corto, extiéndelo con insertion sort
            if (runLen < minRun) {
                int force = Math.min(minRun, n - start);
                insertionSort(arr, start, start + force);
                runLen = force;
            }
            
            // Agrega el run al stack
            runStack.pushRun(start, runLen);
            
            // Realiza merges según las reglas de TimSort
            mergeCollapse(arr, runStack);
            
            start += runLen;
        }
        
        // Merge todos los runs restantes
        mergeForceCollapse(arr, runStack);
    }
    
    /**
     * Encuentra un run natural y lo hace ascendente si es descendente
     */
    private static int countRunAndMakeAscending(int[] arr, int start, int end) {
        if (start + 1 == end) return 1;
        
        int runHi = start + 1;
        
        // Identifica si es ascendente o descendente
        if (arr[start] <= arr[runHi]) {
            // Run ascendente
            while (runHi < end && arr[runHi - 1] <= arr[runHi]) {
                runHi++;
            }
        } else {
            // Run descendente - lo invertimos
            while (runHi < end && arr[runHi - 1] > arr[runHi]) {
                runHi++;
            }
            reverseRange(arr, start, runHi - 1);
        }
        
        return runHi - start;
    }
    
    /**
     * Invierte un rango del array
     */
    private static void reverseRange(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Insertion Sort para arrays pequeños o extensión de runs
     */
    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Calcula el tamaño mínimo de run según el tamaño del array
     */
    private static int getMinRunLength(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
    
    /**
     * Realiza merges según las reglas de invariante de TimSort
     */
    private static void mergeCollapse(int[] arr, RunStack stack) {
        while (stack.size() > 1) {
            int n = stack.size() - 2;
            
            if ((n > 0 && stack.runLen(n-1) <= stack.runLen(n) + stack.runLen(n+1)) ||
                (n > 1 && stack.runLen(n-2) <= stack.runLen(n-1) + stack.runLen(n))) {
                if (stack.runLen(n-1) < stack.runLen(n+1)) {
                    n--;
                }
                mergeAt(arr, stack, n);
            } else if (stack.runLen(n) <= stack.runLen(n+1)) {
                mergeAt(arr, stack, n);
            } else {
                break;
            }
        }
    }
    
    /**
     * Fuerza el merge de todos los runs restantes
     */
    private static void mergeForceCollapse(int[] arr, RunStack stack) {
        while (stack.size() > 1) {
            int n = stack.size() - 2;
            if (n > 0 && stack.runLen(n-1) < stack.runLen(n+1)) {
                n--;
            }
            mergeAt(arr, stack, n);
        }
    }
    
    /**
     * Hace merge de dos runs consecutivos en la posición n
     */
    private static void mergeAt(int[] arr, RunStack stack, int i) {
        int base1 = stack.runBase(i);
        int len1 = stack.runLen(i);
        int base2 = stack.runBase(i + 1);
        int len2 = stack.runLen(i + 1);
        
        // Merge los dos runs
        merge(arr, base1, len1, base2, len2);
        
        // Actualiza el stack
        stack.setRunLen(i, len1 + len2);
        if (i == stack.size() - 3) {
            stack.setRun(i + 1, stack.runBase(i + 2), stack.runLen(i + 2));
        }
        stack.stackSize--;
    }
    
    /**
     * Merge dos runs adyacentes
     */
    private static void merge(int[] arr, int base1, int len1, int base2, int len2) {
        // Crea arrays temporales
        int[] temp1 = Arrays.copyOfRange(arr, base1, base1 + len1);
        int[] temp2 = Arrays.copyOfRange(arr, base2, base2 + len2);
        
        int i = 0, j = 0, k = base1;
        
        // Merge principal
        while (i < len1 && j < len2) {
            if (temp1[i] <= temp2[j]) {
                arr[k++] = temp1[i++];
            } else {
                arr[k++] = temp2[j++];
            }
        }
        
        // Copia elementos restantes
        while (i < len1) {
            arr[k++] = temp1[i++];
        }
        while (j < len2) {
            arr[k++] = temp2[j++];
        }
    }
    
    /**
     * Stack para manejar los runs pendientes
     */
    static class RunStack {
        private int[] runBase = new int[40];
        private int[] runLen = new int[40];
        private int stackSize = 0;
        
        void pushRun(int base, int len) {
            runBase[stackSize] = base;
            runLen[stackSize] = len;
            stackSize++;
        }
        
        int size() { return stackSize; }
        int runBase(int i) { return runBase[i]; }
        int runLen(int i) { return runLen[i]; }
        
        void setRun(int i, int base, int len) {
            runBase[i] = base;
            runLen[i] = len;
        }
        
        void setRunLen(int i, int len) {
            runLen[i] = len;
        }
    }
    
    // Método main para probar la implementación
    public static void main(String[] args) {
        // Casos de prueba
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = {5, 2, 4, 6, 1, 3};
        int[] arr3 = {1, 2, 3, 4, 5}; // Ya ordenado
        int[] arr4 = {5, 4, 3, 2, 1}; // Orden inverso
        
        System.out.println("Array original 1: " + Arrays.toString(arr1));
        sort(arr1);
        System.out.println("Array ordenado 1: " + Arrays.toString(arr1));
        
        System.out.println("\nArray original 2: " + Arrays.toString(arr2));
        sort(arr2);
        System.out.println("Array ordenado 2: " + Arrays.toString(arr2));
        
        System.out.println("\nArray original 3: " + Arrays.toString(arr3));
        sort(arr3);
        System.out.println("Array ordenado 3: " + Arrays.toString(arr3));
        
        System.out.println("\nArray original 4: " + Arrays.toString(arr4));
        sort(arr4);
        System.out.println("Array ordenado 4: " + Arrays.toString(arr4));
    }
}