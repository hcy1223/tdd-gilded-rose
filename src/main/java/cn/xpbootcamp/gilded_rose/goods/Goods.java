package cn.xpbootcamp.gilded_rose.goods;

import java.time.LocalDate;

public class Goods {
    private String name;
    private Integer sellIn;
    private Integer quality;
    private LocalDate manufacturing;

    public Goods(String name, Integer sellIn, Integer quality, LocalDate manufacturing) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.manufacturing = manufacturing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public void setSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public LocalDate getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(LocalDate manufacturing) {
        this.manufacturing = manufacturing;
    }
}
