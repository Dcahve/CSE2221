import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        double x = 0.0;
        while (x <= 0) {
            out.println("input positive");
            String str = in.nextLine();
            if (FormatChecker.canParseDouble(str)) {
                x = Double.parseDouble(str);
            }
        }
        System.out.print(x);
        return x;

    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        double x = 0.0;
        while (x <= 1) {
            out.println("input not 1 but positive");
            String str = in.nextLine();
            if (FormatChecker.canParseDouble(str)) {
                x = Double.parseDouble(str);
            }
        }
        System.out.print(x);
        return x;
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        double[] mylist = { -5, -4, -3, -2, -1, -1.0 / 2.0, -1.0 / 3.0,
                -1.0 / 4.0, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1, 2, 3, 4, 5 };
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);
        double u = getPositiveDouble(in, out);
        double e = 0.0, estimate = 0.0, aa = 0.0, bb = 0.0, cc = 0.0, dd = 0.0;
        for (int a = 0; a < mylist.length; a++) {

            for (int b = 0; b < mylist.length; b++) {

                for (int c = 0; c < mylist.length; c++) {

                    for (int d = 0; d < mylist.length; d++) {

                        estimate = (Math.pow(w, mylist[a]))
                                * (Math.pow(x, mylist[b]))
                                * (Math.pow(y, mylist[c]))
                                * (Math.pow(z, mylist[d]));
                        e = (estimate - u) / u;
                        if (Math.abs(e) < 0.001) {
                            aa = mylist[a];
                            bb = mylist[b];
                            cc = mylist[c];
                            dd = mylist[d];
                        }
                    }
                }
            }
        }
        out.println(aa);
        out.println(bb);
        out.println(cc);
        out.println(dd);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
