package teoria.presentacion_10;

class QuickSortRandom {
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Selecciona un pivot aleatorio para evitar el peor caso
            int randomIndex = low + (int)(Math.random() * (high - low + 1));
            swap(arr, randomIndex, high);
            
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 5};

        System.out.println("Array original:");
        printArray(arr);

        quickSort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}