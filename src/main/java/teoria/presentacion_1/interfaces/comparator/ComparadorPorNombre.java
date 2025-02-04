package teoria.presentacion_1.interfaces.comparator;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Persona> {

        @Override
        public int compare(Persona p1, Persona p2) {

            //usamos el método compareTo de la clase String
            return p1.getNombre().compareTo(p2.getNombre());
        }
}