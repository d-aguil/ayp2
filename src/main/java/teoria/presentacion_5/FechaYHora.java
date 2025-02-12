package teoria.presentacion_5;

public class FechaYHora {
    private Fecha fecha;
    private Hora hora;

    public FechaYHora(int dia, int mes, int año, int hora, int minutos, int segundos) {
        this.fecha = new Fecha(dia, mes, año);
        this.hora = new Hora(hora, minutos, segundos);
    }

    public FechaYHora(int dia, int mes, int año) {
        this(dia, mes, año, 0, 0, 0);
    }

    // Métodos getter y setter para fecha y hora

    public int comparar(FechaYHora otraFechaYHora) {
        int comparacionFechas = this.fecha.compareTo(otraFechaYHora.fecha);
        if (comparacionFechas != 0) {
            return comparacionFechas;
        } else {
            return this.hora.compareTo(otraFechaYHora.hora);
        }
    }

    @Override
    public String toString() {

        return fecha.toString() + " " + hora.toString();
    }

    public String toAMPMString() {

        return fecha.toString() + " " + hora.toAMPMString();
    }
}