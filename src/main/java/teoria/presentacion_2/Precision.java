package teoria.presentacion_2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Precision {

    public static void main(String[] args) {

        float a = 0.11f;
        float b = 0.22f;
        float c = a + b;

        System.out.println(c);

        double a1 = 0.11;
        double b1 = 0.22;
        double c1 = a1 +b1;

        System.out.println(c1);

        double d = 0.1;
        double e = 0.3;
        double f = e - d;

        System.out.println(f);

        BigDecimal d1 = new BigDecimal("0.1");
        BigDecimal e1 = new BigDecimal("0.3");
        BigDecimal f1 = e1.subtract(d1);

        System.out.println(f1);

        BigDecimal bd1 = new BigDecimal("1");
        BigDecimal bd2 = new BigDecimal("3");
        //BigDecimal bd3 = bd1.divide(bd2); <-- ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        System.out.println( bd1.divide(bd2, MathContext.DECIMAL32) );
        System.out.println( bd1.divide(bd2, RoundingMode.UP) );
        System.out.println( bd1.divide(bd2, 2,RoundingMode.UP) );

    }
}
