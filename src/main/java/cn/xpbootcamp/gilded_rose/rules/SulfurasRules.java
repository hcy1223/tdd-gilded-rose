package cn.xpbootcamp.gilded_rose.rules;

import cn.xpbootcamp.gilded_rose.goods.Goods;

import java.time.LocalDate;

public class SulfurasRules implements Rules{

    @Override
    public int quality(Goods goods, LocalDate date) {
        return goods.getQuality();
    }
}
