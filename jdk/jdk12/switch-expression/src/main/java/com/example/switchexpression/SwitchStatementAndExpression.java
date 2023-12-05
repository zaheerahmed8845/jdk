package com.example.switchexpression;

public class SwitchStatementAndExpression {

    String version = "Q4";// This does not have any impact on the below variable defined.

    public static void main(String[] args) {
        SwitchStatementAndExpression switchStatementAndExpression = new SwitchStatementAndExpression();
        switchStatementAndExpression.oldSwitchStatement("APR");

        String returnValue = switchStatementAndExpression.newSwitchExpressionYield("APR");
        System.out.println("New Switch Statement : " + returnValue);
    }

    private void oldSwitchStatement(String month) {

        int i = 0;
        String quarter = "";

        //String version = "Q1"; //"If this is uncommented then at line 23 will through the Error: Variable version is already defined in the scope", thus teh scope of the variable is at method level

        switch (month) {
            case "JAN":
            case "FEB":
            case "MAR":
                String version = "Q1";
                i = i + 1;
                quarter = "Q1";
                break;
            case "APR":
            case "MAY":
            case "JUN":
                //String version = "Q2"; //"Error : Variable version is already defined in the scope"
                version = "Q2";
                String version1 = "Q2";
                i = i + 2;
                quarter = "Q2";
                break;
            case "JUL":
            case "AUG":
            case "SEP":
                i = i + 3;
                quarter = "Q3";
                break;
            case "OCT":
            case "NOV":
            case "DEC":
                i = i + 4;
                quarter = "Q4";
                break;
            default:
                System.out.println("Unknown case");
                break;
        }

        version = "Q5"; //Since this is defined in the switch statement it can be accessed outside it.

        System.out.println("QUARTER: " + i + " " + quarter);
    }

    private String newSwitchExpressionYield(String month) {

        return switch (month) {
            case "JAN", "FEB", "MAR" -> "Q1";
            case "APR", "MAY", "JUN" -> {
                String version = "Q2"; //On line 69, having the same variable does not throw a compile time error.
                System.out.println("Using yield.");
                yield "Q2";
            }
            case "JUL", "AUG", "SEP" -> {
                String version = "Q3";
                System.out.println("Using yield.");
                yield "Q3";
            }
            case "OCT", "NOV", "DEC" -> "Q4";
            default -> "Unknown case";
        };
    }
}
