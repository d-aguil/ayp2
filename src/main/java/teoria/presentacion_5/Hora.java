package teoria.presentacion_5;

public class Hora implements Comparable<Hora> {
    private int hora;
    private int minutos;
    private int segundos;

    public Hora(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    // Métodos getter y setter para hora, minutos y segundos

    @Override
    public int compareTo(Hora otraHora) {
        if (this.hora < otraHora.hora) {
            return -1;
        } else if (this.hora > otraHora.hora) {
            return 1;
        } else {
            if (this.minutos < otraHora.minutos) {
                return -1;
            } else if (this.minutos > otraHora.minutos) {
                return 1;
            } else {
                return this.segundos - otraHora.segundos;
            }
        }
    }

    @Override
    public String toString() {

        return String.format("%02d:%02d:%02d", hora, minutos, segundos);
    }

    public String toAMPMString() {
        int horaAMPM = hora % 12;
        if (horaAMPM == 0) {
            horaAMPM = 12;
        }
        String ampm = hora < 12 || hora == 24 ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", horaAMPM, minutos, segundos, ampm);
    }

}