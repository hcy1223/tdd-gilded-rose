package cn.xpbootcamp.gilded_rose.rules;

import cn.xpbootcamp.gilded_rose.goods.Goods;

import java.time.LocalDate;

public interface Rules {
    int quality(Goods goods, LocalDate date);
}
