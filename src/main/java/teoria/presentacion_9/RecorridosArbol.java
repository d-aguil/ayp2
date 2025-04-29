package teoria.presentacion_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecorridosArbol {

    public List<Integer> preorden(Nodo raiz) {
        List<Integer> resultado = new ArrayList<>();
        preordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void preordenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            resultado.add(nodo.info);
            preordenRecursivo(nodo.izq, resultado);
            preordenRecursivo(nodo.der, resultado);
        }
    }

    public List<Integer> inorden(Nodo raiz) {
        List<Integer> resultado = new ArrayList<>();
        inordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void inordenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            inordenRecursivo(nodo.izq, resultado);
            resultado.add(nodo.info);
            inordenRecursivo(nodo.der, resultado);
        }
    }

    public List<Integer> postorden(Nodo raiz) {
        List<Integer> resultado = new ArrayList<>();
        postordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void postordenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            postordenRecursivo(nodo.izq, resultado);
            postordenRecursivo(nodo.der, resultado);
            resultado.add(nodo.info);
        }
    }

    public List<Integer> porNiveles(Nodo raiz) {
        List<Integer> resultado = new ArrayList<>();
        if (raiz == null) {
            return resultado;
        }

        Queue<Nodo> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();
            resultado.add(nodoActual.info);

            if (nodoActual.izq != null) {
                cola.offer(nodoActual.izq);
            }
            if (nodoActual.der != null) {
                cola.offer(nodoActual.der);
            }
        }
        return resultado;
    }


}