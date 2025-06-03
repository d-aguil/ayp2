package teoria.estructuras_adicionales;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Implementación de Max-Heap usando array
 * Conceptualmente es un árbol binario completo, pero implementado con array por eficiencia
 */
public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;
    
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }
    
    // Constructor que crea heap desde un array existente (heapify)
    public MaxHeap(int[] array) {
        this.capacity = array.length;
        this.size = array.length;
        this.heap = Arrays.copyOf(array, capacity);
        
        // Construir heap desde abajo hacia arriba
        // Empezar desde el último nodo padre
        for (int i = getParentIndex(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }
    
    // ===============================
    // NAVEGACIÓN EN EL ÁRBOL (usando índices del array)
    // ===============================
    
    /**
     * Obtiene el índice del padre
     * Para nodo en índice i, el padre está en (i-1)/2
     */
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }
    
    /**
     * Obtiene el índice del hijo izquierdo
     * Para nodo en índice i, hijo izquierdo está en 2*i + 1
     */
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    
    /**
     * Obtiene el índice del hijo derecho
     * Para nodo en índice i, hijo derecho está en 2*i + 2
     */
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    
    // Métodos de verificación de existencia
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    
    // Métodos para obtener valores
    private int parent(int index) {
        return heap[getParentIndex(index)];
    }
    
    private int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }
    
    private int rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }
    
    // ===============================
    // OPERACIONES PRINCIPALES
    // ===============================
    
    /**
     * Obtiene el elemento máximo (raíz) sin eliminarlo
     */
    public int peek() {
        if (size == 0) throw new NoSuchElementException("Heap está vacío");
        return heap[0];
    }
    
    /**
     * Extrae el elemento máximo (raíz)
     */
    public int extractMax() {
        if (size == 0) throw new NoSuchElementException("Heap está vacío");
        
        int max = heap[0];
        
        // Mover el último elemento a la raíz
        heap[0] = heap[size - 1];
        size--;
        
        // Restaurar la propiedad del heap
        heapifyDown(0);
        
        return max;
    }
    
    /**
     * Inserta un nuevo elemento
     */
    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap está lleno");
        }
        
        // Agregar el nuevo elemento al final
        heap[size] = value;
        size++;
        
        // Restaurar la propiedad del heap hacia arriba
        heapifyUp(size - 1);
    }
    
    // ===============================
    // OPERACIONES DE HEAPIFY
    // ===============================
    
    /**
     * Mueve un elemento hacia arriba hasta que se cumpla la propiedad del heap
     * Se usa después de insertar
     */
    private void heapifyUp(int index) {
        // Mientras tenga padre y sea mayor que su padre
        while (hasParent(index) && parent(index) < heap[index]) {
            // Intercambiar con el padre
            swap(getParentIndex(index), index);
            // Moverse hacia arriba
            index = getParentIndex(index);
        }
    }
    
    /**
     * Mueve un elemento hacia abajo hasta que se cumpla la propiedad del heap
     * Se usa después de extraer el máximo
     */
    private void heapifyDown(int index) {
        // Mientras tenga al menos un hijo
        while (hasLeftChild(index)) {
            // Encontrar el índice del hijo mayor
            int largerChildIndex = getLeftChildIndex(index);
            
            // Si tiene hijo derecho y es mayor que el izquierdo
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }
            
            // Si el nodo actual es mayor que su hijo mayor, está en posición correcta
            if (heap[index] > heap[largerChildIndex]) {
                break;
            }
            
            // Intercambiar con el hijo mayor
            swap(index, largerChildIndex);
            // Moverse hacia abajo
            index = largerChildIndex;
        }
    }
    
    /**
     * Intercambia dos elementos en el heap
     */
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
    // ===============================
    // MÉTODOS UTILITARIOS
    // ===============================
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    /**
     * Visualización del heap como array y como árbol
     */
    public void printHeap() {
        System.out.println("Heap como array: " + Arrays.toString(Arrays.copyOf(heap, size)));
        System.out.println("Heap como árbol:");
        printTree(0, 0);
    }
    
    /**
     * Imprime el heap como un árbol (rotado 90 grados)
     */
    private void printTree(int index, int level) {
        if (index >= size) return;
        
        // Imprimir hijo derecho primero (parte superior del árbol)
        if (hasRightChild(index)) {
            printTree(getRightChildIndex(index), level + 1);
        }
        
        // Imprimir el nodo actual con indentación
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(heap[index]);
        
        // Imprimir hijo izquierdo (parte inferior del árbol)
        if (hasLeftChild(index)) {
            printTree(getLeftChildIndex(index), level + 1);
        }
    }
    
    /**
     * Verifica si el array mantiene la propiedad del max-heap
     */
    public boolean isValidHeap() {
        for (int i = 0; i < size; i++) {
            // Verificar que cada nodo sea mayor o igual que sus hijos
            if (hasLeftChild(i) && heap[i] < leftChild(i)) {
                return false;
            }
            if (hasRightChild(i) && heap[i] < rightChild(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Implementación de HeapSort usando esta estructura
     */
    public static int[] heapSort(int[] array) {
        // Crear heap desde el array
        MaxHeap heap = new MaxHeap(array.clone());
        
        int[] sorted = new int[array.length];
        
        // Extraer elementos uno por uno (en orden descendente)
        for (int i = array.length - 1; i >= 0; i--) {
            sorted[i] = heap.extractMax();
        }
        
        // Para orden ascendente, invertir
        for (int i = 0; i < sorted.length / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = temp;
        }
        
        return sorted;
    }
    
    // ===============================
    // DEMOSTRACIÓN Y PRUEBAS
    // ===============================
    
    public static void main(String[] args) {
        System.out.println("=== Demostración de Max-Heap ===\n");
        
        // Crear heap vacío
        MaxHeap heap = new MaxHeap(10);
        
        // Insertar elementos
        System.out.println("Insertando elementos: 10, 15, 20, 17, 8, 25, 5");
        int[] values = {10, 15, 20, 17, 8, 25, 5};
        
        for (int value : values) {
            heap.insert(value);
            System.out.println("Después de insertar " + value + ":");
            heap.printHeap();
            System.out.println("¿Es heap válido? " + heap.isValidHeap());
            System.out.println();
        }
        
        // Extraer elementos
        System.out.println("=== Extrayendo elementos ===");
        while (!heap.isEmpty()) {
            int max = heap.extractMax();
            System.out.println("Extraído: " + max);
            if (!heap.isEmpty()) {
                heap.printHeap();
                System.out.println("¿Es heap válido? " + heap.isValidHeap());
            }
            System.out.println();
        }
        
        // Demostración de construcción desde array existente
        System.out.println("=== Construcción desde array existente ===");
        int[] array = {4, 10, 3, 5, 1, 15, 2, 17, 8};
        System.out.println("Array original: " + Arrays.toString(array));
        
        MaxHeap heapFromArray = new MaxHeap(array);
        System.out.println("Heap construido:");
        heapFromArray.printHeap();
        System.out.println("¿Es heap válido? " + heapFromArray.isValidHeap());
        
        // Demostración de HeapSort
        System.out.println("\n=== HeapSort ===");
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + Arrays.toString(unsorted));
        int[] sorted = heapSort(unsorted);
        System.out.println("Array ordenado: " + Arrays.toString(sorted));
    }
}