package com.example.patternmatchingswitch;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SwitchCasePatternMatching {

    public static void main(String[] args) {
        Object value = getValue();
        String result = getResult(value);
        System.out.println(result);
        System.out.println("Normal Switch Statement Result");
        String result1 = getResultSwitchStatement(value);
    }

    public static String getResult(Object value) {
        //char,byte,short,int,Character,Byte,Short,Integer,String,Enum type.

        return switch (value) {
            case String s -> "A String of length :  " + s.length();
            case List list -> "A list of size : " + list.size();
            case Map map -> "A map(key,value) of size : " + map.size();
            case Set set -> "A set, unique elements : " + set.size();
            default -> "Unknown data structure...";
        };
    }

    /*
     * In the Switch Statement, the default case is not mandatory but since we are using the pattern matching in switch statement, this is mandatory. As the input value is not enum.
     * */
    public static String getResultSwitchStatement(Object value) {
        var result = "";
        switch (value) {
            case String s:
                result = "A String of length :  " + s.length();
                break;
            case List list:
                result = "A list of size : " + list.size();
                break;
            case Map map:
                result = "A map(key,value) of size : " + map.size();
                break;
            case Set set:
                result = "A set, unique elements : " + set.size();
                break;
            default:
                result = "Unknown data structure...";
                break;
        }
        return result;
    }

    //Example of Guarded pattern
    /*
     *   case List list -> "A list of size : "+ list.size();
     *   case List list && (list.size() > 10000) -> "A large list of size : "+ list.size();
     *   This will give an error message - "Label is dominated by preceding one"
     * */
    public static String getResultWithGuard(Object value) {
        return switch (value) {
            case String s -> "A String of length :  " + s.length();
            case List list && (list.size() > 10000) -> "A large list of size : " + list.size();
            case List list -> "A list of size : " + list.size();
            case Map map -> "A map(key,value) of size : " + map.size();
            case Set set -> "A set, unique elements : " + set.size();
            default -> "Unknown data structure...";
        };
    }

    //null case label.
    //Note: null can be in any order, need not be the first element only.
    public static String getLeagueDescription(FootballLeague league) {
        return switch (league) {
            case null -> "Invalid league";
            case EPL -> "English Premier League";
            case LA_LIGA -> "Spanish football League";
            case BUNDESLIGA -> "Football league in Germany";
            case LIGUE_1 -> "French football tournament";
        };
    }

    private static Object getValue() {
        return Map.of("1", "One", "2", "Two");
        //return List.of(1,2,3,4,5);
        //return "Hello Pattern matching for switch";
    }
}

