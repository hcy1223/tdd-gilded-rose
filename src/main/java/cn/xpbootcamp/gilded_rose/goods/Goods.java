package cn.xpbootcamp.gilded_rose.goods;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidQualityException;

import java.time.LocalDate;

import static cn.xpbootcamp.gilded_rose.goods.PriceRules.price;

public class Goods {
    private String name;
    private int sellIn;
    private int quality;
    private LocalDate manufacturing;

    private Goods(String name, int sellIn, int quality, LocalDate manufacturing) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.manufacturing = manufacturing;
    }

    public static Builder createGoods() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int sellIn;
        private int quality;
        private LocalDate manufacturing;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sellIn(int sellIn) {
            this.sellIn = sellIn;
            return this;
        }

        public Builder quality(int quality) {
            if (quality < 0) {
                throw new InvalidQualityException("the quality of goods is lower than 0");
            }
            if (quality > 50) {
                throw new InvalidQualityException("the quality of goods is higher than 50");
            }
            this.quality = quality;
            return this;
        }

        public Builder manufacturing(LocalDate manufacturing) {
            this.manufacturing = manufacturing;
            return this;
        }

        public Goods build() {
            return new Goods(this.name, this.sellIn, this.quality, this.manufacturing);
        }
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public int getQuality(LocalDate date) {
        return price(this, date).getQuality();
    }

    public LocalDate getManufacturing() {
        return manufacturing;
    }
}
