public class App {
    public static void main(String[] args) throws Exception {
        System.out.printf("$%.2f", compoundInterest(10000, 4.5, 13, 1));
        System.out.println("\n" + compoundInterest(10000, 4.5, 13, 1));
    }

    public static double compoundInterest(double principle, double percentInterest, double timeInYears,
            double numberPerYear) {

        double rateInDecimal = percentInterest / 100;
        double innerParenthesis = rateInDecimal / numberPerYear;
        double outerParenthesis = 1 + innerParenthesis;
        double toThePowerOf = (numberPerYear * timeInYears);
        double thisTimesPrincipal = Math.pow(outerParenthesis, toThePowerOf);

        return principle * thisTimesPrincipal;
    }
}
