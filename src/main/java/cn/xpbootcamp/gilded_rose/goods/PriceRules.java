package cn.xpbootcamp.gilded_rose.goods;

import java.time.LocalDate;

public class PriceRules {
    private Goods goods;
    private int quality;
    private LocalDate date;

    private PriceRules(Goods goods, Integer quality, LocalDate date) {
        this.goods = goods;
        this.quality = quality;
        this.date = date;
    }

    public static PriceRules price(Goods goods, LocalDate date) {
        int duration = date.compareTo(goods.getManufacturing());
        return new PriceRules(goods, negativeToZero(goods.getQuality() - duration), date);
    }

    private static Integer negativeToZero(Integer number) {
        return number < 0 ? 0 : number;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getQuality() {
        return quality;
    }

    public LocalDate getDate() {
        return date;
    }
}
