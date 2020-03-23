package cn.xpbootcamp.gilded_rose.goods;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidDateException;

import java.time.LocalDate;

public class PriceRules {
    private Goods goods;
    private int quality;
    private LocalDate date;

    public PriceRules(Goods goods, Integer quality, LocalDate date) {
        this.goods = goods;
        this.quality = quality;
        this.date = date;
    }

    public static PriceRules price(Goods goods, LocalDate date) {
        int duration = (int) (date.toEpochDay() - goods.getManufacturing().toEpochDay());
        if (duration < 0) {
            throw new InvalidDateException("invalid date");
        }
        if (duration <= goods.getSellIn()) {
            return new PriceRules(goods, negativeToZero(goods.getQuality() - duration), date);
        }
        return new PriceRules(goods, negativeToZero(goods.getQuality() + goods.getSellIn() - duration * 2), date);
    }

    public int getQuality() {
        return quality;
    }

    public LocalDate getDate() {
        return date;
    }

    private static int negativeToZero(int number) {
        return Math.max(number, 0);
    }
}
