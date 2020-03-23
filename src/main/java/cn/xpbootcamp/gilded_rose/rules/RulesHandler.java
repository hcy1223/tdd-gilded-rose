package cn.xpbootcamp.gilded_rose.rules;

import cn.xpbootcamp.gilded_rose.goods.Goods;
import cn.xpbootcamp.gilded_rose.goods.GoodsTypes;
import com.google.common.collect.ImmutableMap;

import java.time.LocalDate;
import java.util.Map;

import static cn.xpbootcamp.gilded_rose.goods.GoodsTypes.AGED_BRIE;
import static cn.xpbootcamp.gilded_rose.goods.GoodsTypes.COMMON;

public class RulesHandler {

    public static int quality(Goods goods, LocalDate date) {
        Map<GoodsTypes, Rules> rules = ImmutableMap.of(COMMON, new CommonRules(), AGED_BRIE, new AgedBrieRules());
        return rules.get(goods.getType()).quality(goods, date);
    }
}
