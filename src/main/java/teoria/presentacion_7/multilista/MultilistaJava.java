package teoria.presentacion_7.multilista;

import java.util.ArrayList;
import java.util.List;

public class MultilistaJava {

    static List<Curso> cursos = new ArrayList<>();
    static List<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        Curso curso1 = new Curso("Programación I");
        Curso curso2 = new Curso("Matemáticas");

        Alumno alumno1 = new Alumno("Ana");
        Alumno alumno2 = new Alumno("Carlos");

        cursos.add(curso1);
        cursos.add(curso2);
        alumnos.add(alumno1);
        alumnos.add(alumno2);

        NodoMulti nodo1 = new NodoMulti(alumno1, curso1);
        NodoMulti nodo2 = new NodoMulti(alumno2, curso1);
        NodoMulti nodo3 = new NodoMulti(alumno1, curso2);

        PuntCur puntCur1 = new PuntCur(curso1);
        puntCur1.nodo = nodo1;
        PuntCur puntCur2 = new PuntCur(curso2);
        puntCur2.nodo = nodo3;

        PuntAlu puntAlu1 = new PuntAlu(alumno1);
        puntAlu1.nodo = nodo1;
        PuntAlu puntAlu2 = new PuntAlu(alumno2);
        puntAlu2.nodo = nodo2;

        nodo1.alumnoSig = nodo2;
        nodo1.cursoSig = nodo3;

        System.out.println("Alumno: " + puntAlu1.info + ", Curso: " + puntCur1.info);

        // Ejemplo de cómo recorrer los alumnos de un curso
        PuntCur cursoActual = puntCur1;
        System.out.println("Alumnos en " + cursoActual.info.nombre + ":");

        NodoMulti nodoActual = cursoActual.nodo;
        while (nodoActual != null) {
            if(nodoActual.curso == cursoActual.info)
                System.out.println(nodoActual.alumno.nombre);
            nodoActual = nodoActual.alumnoSig;
        }

        // Ejemplo de cómo recorrer los cursos de un alumno
        PuntAlu alumnoActual = puntAlu1;
        System.out.println("Cursos de " + alumnoActual.info.nombre + ":");

        nodoActual = alumnoActual.nodo;
        while (nodoActual != null) {
            if(nodoActual.alumno == alumnoActual.info)
                System.out.println(nodoActual.curso.nombre);
            nodoActual = nodoActual.cursoSig;
        }

        // Obtener todos los cursos
        System.out.println("Todos los cursos: " + cursos);

        // Obtener todos los alumnos
        System.out.println("Todos los alumnos: " + alumnos);

    }
}