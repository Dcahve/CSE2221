import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newon4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newon4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param ask
     *            user to input e
     * @return estimate of square root
     */
    private static double sqrt(double x, double e) {
        SimpleWriter out = new SimpleWriter1L();
        double r = Integer.MAX_VALUE; //or other big number
        while ((r * r - x) / x > e * e) {
            if (r == 0) {
                r = x;
            } else {
                r = (x / r + r) / 2;
            }

        }
        out.println(r);
        out.close();
        return r;
    }

    public static void repeat() {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println(
                "type a positive double. If it's negative, the program will break.");
        double x = in.nextDouble();
        if (x > 0) {
            out.println("input the value of e");
            double e = in.nextDouble();
            sqrt(x, e);
        } else if (x == 0) {
            out.println("0");
            System.exit(0);
        } else {
            out.println("System exits");
            System.exit(0);
        }

        in.close();
        out.close();

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        repeat();
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
