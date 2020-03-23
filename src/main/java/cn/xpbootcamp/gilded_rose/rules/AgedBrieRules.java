package cn.xpbootcamp.gilded_rose.rules;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidDateException;
import cn.xpbootcamp.gilded_rose.goods.Goods;

import java.time.LocalDate;

import static java.lang.Math.min;

public class AgedBrieRules implements Rules {
    @Override
    public int quality(Goods goods, LocalDate date) {
        int duration = (int) (date.toEpochDay() - goods.getManufacturing().toEpochDay());
        if (duration < 0) {
            throw new InvalidDateException("invalid date");
        }
        return min(goods.getQuality() + duration, 50);
    }
}
