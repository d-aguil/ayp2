package teoria.presentacion_8;

public class Horner {

    public static int hashing(String clave, int N) {
        long hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash = (hash * 32 + clave.charAt(i)) % N;
        }
        return (int) hash;
    }

    public static void main(String[] args) {
        String clave1 = "Hola";
        String clave2 = "Mundo";
        int N = 100;

        int hash1 = hashing(clave1, N);
        int hash2 = hashing(clave2, N);

        System.out.println("Hash de '" + clave1 + "': " + hash1);
        System.out.println("Hash de '" + clave2 + "': " + hash2);
    }
}
