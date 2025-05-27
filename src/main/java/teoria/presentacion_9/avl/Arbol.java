package teoria.presentacion_9.avl;

public class Arbol {

    public class Nodo {
        protected Integer dato;
        protected Nodo izq;
        protected Nodo der;
        protected int altura;

        public Nodo(int info) {
            this.dato = info;
            this.izq = null;
            this.der = null;
            // un nuevo nodo es una hoja → altura = 0
            this.altura = 0;
        }
    }

    private Nodo raiz;

    public Arbol() {

        this.raiz = null;
    }

    public void insertar(Integer dato) {
        raiz = insertar(raiz, dato);
    }

    private Nodo insertar(Nodo nodo, Integer dato) {
        // 1. Si el nodo es nulo, creamos un nuevo nodo con el dato
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izq = insertar(nodo.izq, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.der = insertar(nodo.der, dato);
        } else {
            // Elemento duplicado - no se inserta
            return nodo;
        }

        // 2. Actualizar altura del nodo actual
        actualizarAltura(nodo);

        // 3. Equilibrar el árbol y retornar la nueva raíz
        return equilibrar(nodo);
    }


    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo nodo) {
        return nodo == null ? -1 : nodo.altura;
    }

    private void actualizarAltura(Nodo nodo) {
        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
    }

    private int factorEquilibrio(Nodo nodo) {
        return nodo == null ? 0 : altura(nodo.izq) - altura(nodo.der);
    }

    //ROTACIONES
    private Nodo rotacionDerecha(Nodo p) {
        Nodo q = p.izq;
        p.izq = q.der;
        q.der = p;

        actualizarAltura(p);
        actualizarAltura(q);

        return q;
    }

    private Nodo rotacionIzquierda(Nodo p) {
        Nodo q = p.der;
        p.der = q.izq;
        q.izq = p;

        actualizarAltura(p);
        actualizarAltura(q);

        return q;
    }

    private Nodo rotacionIzquierdaDerecha(Nodo nodo) {
        nodo.izq = rotacionIzquierda(nodo.izq);
        return rotacionDerecha(nodo);
    }

    private Nodo rotacionDerechaIzquierda(Nodo nodo) {
        nodo.der = rotacionDerecha(nodo.der);
        return rotacionIzquierda(nodo);
    }

    private Nodo equilibrar(Nodo nodo) {
        int balance = factorEquilibrio(nodo);

        // Rotación derecha
        if (balance > 1) {
            if (factorEquilibrio(nodo.izq) >= 0) {
                return rotacionDerecha(nodo);
            } else {
                return rotacionIzquierdaDerecha(nodo);
            }
        }

        // Rotación izquierda
        if (balance < -1) {
            if (factorEquilibrio(nodo.der) <= 0) {
                return rotacionIzquierda(nodo);
            } else {
                return rotacionDerechaIzquierda(nodo);
            }
        }

        return nodo;
    }

    public void eliminar(Integer dato) {
        raiz = eliminar(raiz, dato);
    }

    private Nodo eliminar(Nodo nodo, Integer dato) {
        //
        if (nodo == null) {
            return null;
        }

        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izq = eliminar(nodo.izq, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.der = eliminar(nodo.der, dato);
        } else {
            // Nodo encontrado - aplicar casos de eliminación
            if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            } else {
                // Nodo con dos hijos - encontrar menor del subárbol derecho
                Nodo menor = encontrarMenor(nodo.der);
                nodo.dato = menor.dato;
                nodo.der = eliminar(nodo.der, menor.dato);
            }
        }

        //
        actualizarAltura(nodo);

        //
        return equilibrar(nodo);
    }

    private Nodo encontrarMenor(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }
}