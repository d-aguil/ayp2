package teoria.presentacion_4;

import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerConSuperCSV {
    public static void main(String[] args) {
        String ruta = "src/main/resources/datos-compli.csv";

        try (CsvBeanReader lector = new CsvBeanReader(new FileReader(ruta), CsvPreference.STANDARD_PREFERENCE)) {

            // Leer la cabecera del CSV
            String[] header = lector.getHeader(true);

            // Definir los procesadores de cada columna
            CellProcessor[] processors = new CellProcessor[]{new ParseInt(), null, null};

            Datos datos;
            while ((datos = lector.read(Datos.class, header, processors)) != null) {
                System.out.println(datos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
