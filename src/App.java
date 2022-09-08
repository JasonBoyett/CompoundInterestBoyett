/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 7, 2022
 * Windows 10
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {// I made a GUI method that brings together many smaller
                                                             // methods and call that gui method in my main function
        GUI();
    }// end of main

    public static double compoundInterest(double principle, double percentInterest, double timeInYears,
            double numberPerYear) {// This method holds most of the actual math but doesn't have a set number of
                                   // times the interest compounds

        double rateInDecimal = percentInterest / 100;
        double innerParenthesis = rateInDecimal / numberPerYear;
        double outerParenthesis = 1 + innerParenthesis;
        double toThePowerOf = (numberPerYear * timeInYears);
        double thisTimesPrincipal = Math.pow(outerParenthesis, toThePowerOf);

        return principle * thisTimesPrincipal;
    }// end of method

    public static double computeBalance(double principle, double percentInterest, double timeInYears,
            boolean isMonthly) {// this method calls the compoundInterest method with either 12 cycles per
                                // period for monthly interest or just 1 for annual
        if (isMonthly) {
            return compoundInterest(principle, percentInterest, timeInYears, 12);
        }
        return compoundInterest(principle, percentInterest, timeInYears, 1);
    }// end of method

    // now we start the sub methods for GUI
    /*
     * all GUI sub methods except for getIsMonthly contain a try catch block that
     * displays an error message if an invalid input is entered the function then
     * calls itself until a valid entry is given
     */

    public static double getUserPrincipal() {// prompts the user to get their starting principle
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(null, "What is your Starting Principal?"));
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please make sure to enter a number", "Compound Interest Calculator",
                    JOptionPane.ERROR_MESSAGE);
        }
        return getUserPrincipal();
    }// end of method

    public static double getUserYears() {// prompts the user to get the number of years the principle will compound for
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(null, "How many years will will the term be?"));
        } 
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "please make sure to enter a number", "Compound Interest Calculator",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please try again", "Compound Interest Calculator",
                    JOptionPane.ERROR_MESSAGE);
        }
        return getUserYears();
    }// end of method

    public static double getUserPercent() {// prompts the user to get their interest rate
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(null, "What is your interest rate percentage?"));
        } 
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "please make sure to enter a number", "Compound Interest Calculator",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please try again", "Compound Interest Calculator",
                    JOptionPane.ERROR_MESSAGE);
        }
        return getUserPercent();
    }// end of method

    public static boolean getIsMonthly() {// returns true if the user selects to compound monthly and false for annually
        return JOptionPane.showConfirmDialog(null, "will this compound monthly?", "Compound Interest Calculator",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }// end of method

    public static void GUI() {/*
                               * takes all prvious methods enitializes variables with their return values and
                               * feeds those variables into the computeBalance method before rounding its
                               * return off to two decimal places and showing the user their final value
                               */
        double principle = getUserPrincipal();
        double percentInterest = getUserPercent();
        double timeInYears = getUserYears();
        boolean isMonthly = getIsMonthly();
        DecimalFormat round = new DecimalFormat("###,###,###,###.##");

        JOptionPane.showMessageDialog(null,
                "your total is $" + round.format(computeBalance(principle, percentInterest, timeInYears, isMonthly)),
                "total", JOptionPane.INFORMATION_MESSAGE);
    }// end of method
}
