package com.example.privatemethods;

import java.time.LocalDate;

public class PrivateMethodImplementation implements PrivateMethodInterface {
    @Override
    public boolean isHoliday(LocalDate date) {
        return false;
    }

    @Override
    public boolean isBusinessDay(LocalDate date) {
        return PrivateMethodInterface.super.isBusinessDay(date);
    }

}
