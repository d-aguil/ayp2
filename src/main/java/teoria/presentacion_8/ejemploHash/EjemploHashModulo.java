package teoria.presentacion_8.ejemploHash;


public class EjemploHashModulo {

    /**
     *
     * @param clave
     * @param tamañoTabla
     * @return
     */
    public static int hash(String clave, int tamañoTabla) {
        int valorHash = 0;
        for (int i = 0; i < clave.length(); i++) {
            valorHash = valorHash + clave.charAt(i);
        }
        return valorHash % tamañoTabla;
    }

    /**
     *
     * @param clave
     * @param tamaño
     * @return
     */
    public static int hash(int clave, int tamaño) {
        return clave % tamaño;
    }

    public static void main(String[] args) {

        Persona[] personas = {
                new Persona("Juan" , 29123410),
                new Persona("Pedro", 35987624),
                new Persona("Maria", 19090233),
                new Persona("Ana"  , 36345781),
                new Persona("Luis" , 40123362)
        };

        Persona[] tabla = new Persona[5];

        for(int i=0; i< 5; i++){

            int indice = hash(personas[i].getDni(), 5);

            //insertamos en la posición obtenida del hash
            tabla[indice] = personas[i];
        }

    }
}