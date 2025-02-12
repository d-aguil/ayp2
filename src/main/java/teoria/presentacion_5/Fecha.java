package teoria.presentacion_5;

public class Fecha implements Comparable<Fecha> {
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    // Métodos setter y getter para día, mes y año

    @Override
    public int compareTo(Fecha otraFecha) {
        if (this.año < otraFecha.año) {
            return -1;
        } else if (this.año > otraFecha.año) {
            return 1;
        } else {
            if (this.mes < otraFecha.mes) {
                return -1;
            } else if (this.mes > otraFecha.mes) {
                return 1;
            } else {
                return this.dia - otraFecha.dia;
            }
        }
    }

    @Override
    public String toString() {

        return dia + " de " + obtenerNombreMes(mes) + " de " + año;
    }

    private String obtenerNombreMes(int mes) {
        return "implementar el algoritmo....";
    }
}