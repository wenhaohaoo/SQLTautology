import java.util.Arrays;
import java.util.List;

public class ExpressionHelper {
    public static List<String> validComparatorList = Arrays.asList("=", ">", "<", ">=", "<=", "!=", "<>");

    public static boolean isValidNumber(String numberExpression) {
        return numberExpression.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isValidVariable(String variableExpression) {
        return true;
    }

    public static boolean isValidString(String stringExpression) {
        if(stringExpression.matches("^\'.*\'$")) {
            //            String subStringExpression = stringExpression.substring(1,stringExpression.length()-1);
            //            System.out.println(subStringExpression);
            return !stringExpression.matches(".*(\'\\p{Space}\').*");
        }
        return false;
    }

    public static boolean isValidNull(String nullExpression) {
        return nullExpression.equalsIgnoreCase("NULL");
    }

    public static boolean isValidComparator(String comparatorExpression) {
        return validComparatorList.contains(comparatorExpression);
    }

    public static String[] ParseSingle(String expression) {
        return new String[1];
    }

    public static boolean standardize(String basicExpression) {
        return true;
    }

    public static boolean isValidBasicExpression(String basicExpression) {
        return true;
    }

    public static String simplify(String basicExpession) {
        return "";
    }

    public static String evaluate(String expression) {
        return "";
    }

    public static ExpressionDescription Parse(String fullExpression) {
        return null;
    }

    public static boolean isTautology(String fullExpression) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidNumber("[-1.23]"));
        System.out.println(isValidString("'this' ' is incorrect'"));
        System.out.println(isValidString("'this'' '' is incorrect'"));//??
        System.out.println(isValidNull("something.NULL"));
        System.out.println(isValidNull("NuLL"));
    }

}
