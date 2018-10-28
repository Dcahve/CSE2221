import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        NaturalNumber evaluation = new NaturalNumber2();
        NaturalNumber evaluation1 = new NaturalNumber2();
        NaturalNumber evaluation2 = new NaturalNumber2();
        if (exp.numberOfChildren() != 0) {
            String str = exp.label();
            evaluation1.copyFrom(evaluate(exp.child(0)));
            evaluation2.copyFrom(evaluate(exp.child(1)));
            if (str.equals("times")) {
                evaluation1.multiply(evaluation2);
                evaluation.copyFrom(evaluation1);
            }
            if (str.equals("minus")) {
                if (evaluation1.compareTo(evaluation2) < 0) {
                    Reporter.fatalErrorToConsole("error: this < n");
                }
                evaluation1.subtract(evaluation2);
                evaluation.copyFrom(evaluation1);
            }
            if (str.equals("plus")) {
                evaluation1.add(evaluation2);
                evaluation.copyFrom(evaluation1);
            }
            if (str.equals("divide")) {
                evaluation1.divide(evaluation2);
                if (evaluation2.compareTo(evaluation.newInstance()) == 0) {
                    Reporter.fatalErrorToConsole("error: divided by zero");
                }
                evaluation.copyFrom(evaluation1);
            }

        } else {
            evaluation
                    .setFromInt(Integer.parseInt(exp.attributeValue("value")));
        }
        return evaluation;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}