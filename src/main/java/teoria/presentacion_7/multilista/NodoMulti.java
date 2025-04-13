package teoria.presentacion_7.multilista;

class NodoMulti {
    Alumno alumno;
    Curso curso;
    NodoMulti alumnoSig;
    NodoMulti cursoSig;

    public NodoMulti(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
    }
}