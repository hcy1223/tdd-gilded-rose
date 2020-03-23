package cn.xpbootcamp.gilded_rose;

import java.time.LocalDate;

public abstract class TestBase {

    protected LocalDate date(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
