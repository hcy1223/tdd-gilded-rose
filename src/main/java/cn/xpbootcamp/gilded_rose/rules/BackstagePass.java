package cn.xpbootcamp.gilded_rose.rules;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidDateException;
import cn.xpbootcamp.gilded_rose.goods.Goods;

import java.time.LocalDate;

public class BackstagePass implements Rules {
    @Override
    public int quality(Goods goods, LocalDate date) {
        int duration = (int) (date.toEpochDay() - goods.getManufacturing().toEpochDay());
        if (duration < 0) {
            throw new InvalidDateException("invalid date");
        }

        if (duration > goods.getSellIn()) {
            return 0;
        }
        if (goods.getSellIn() > 10) {
            int daysBetweenDateAndExpiryDate = goods.getSellIn() - duration;
            if (daysBetweenDateAndExpiryDate > 10) {
                return goods.getQuality() + duration;
            } else if (daysBetweenDateAndExpiryDate > 5) {
                return goods.getQuality() + duration * 2 - goods.getSellIn() + 10;
            } else {
                return goods.getQuality() + duration * 3 - goods.getSellIn() * 2 + 15;
            }

        } else if (goods.getSellIn() > 5) {
            return goods.getSellIn() - duration > 5 ? duration : duration * 3 - goods.getSellIn() + 5;
        } else {
            return duration * 3;
        }
    }
}
