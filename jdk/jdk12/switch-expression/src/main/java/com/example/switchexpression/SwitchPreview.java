package com.example.switchexpression;

public class SwitchPreview {

    public static void main(String[] args) {

        OrderStatus status = OrderStatus.DELIVERED;
        var displayStatus = processOrder(status);
        System.out.println(displayStatus);

        String strStatus = "ORDERED";
        String strResponse = processOrderInputString(strStatus);
        System.out.println(strResponse);

    }

    private static String processOrder(OrderStatus status) {

        return switch (status) {
            case ORDERED -> "Food ordered,Restaurant will confirm";
            case COOKING -> "Restaurant confirmed order,food is being cooked";
            case DELIVERED -> "Food has been delivered";
            case CANCELLED -> "Food order has been cancelled";
        };

        //return result;
    }

    private static String processOrderSwitchStatement(OrderStatus status) {
        String result = "";

        switch (status) {
            case ORDERED:
                result = "Food ordered,Restaurant will confirm";
                break;
            case COOKING:
                result = "Restaurant confirmed order,food is being cooked";
                break;
            case DELIVERED:
                result = "Food has been delivered";
                break;
            case CANCELLED:
                result = "Food order has been cancelled";
                break;
        }
        ;
        return result;

    }


    private static String processOrderInputString(String status) {

        var result = switch (status) {
            case "ORDERED" -> "Food ordered,Restaurant will confirm";
            case "COOKING" -> "Restaurant confirmed order,food is being cooked";
            case "DELIVERED" -> "Food has been delivered";
            case "CANCELLED" -> "Food order has been cancelled";
            default -> "Value Not Found";
        };

        return result;
    }
}

enum OrderStatus {

    ORDERED, COOKING, DELIVERED, CANCELLED
}
