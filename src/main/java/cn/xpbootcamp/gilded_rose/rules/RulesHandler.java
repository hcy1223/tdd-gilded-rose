package cn.xpbootcamp.gilded_rose.rules;

import cn.xpbootcamp.gilded_rose.goods.Goods;
import cn.xpbootcamp.gilded_rose.goods.GoodsTypes;
import com.google.common.collect.ImmutableMap;

import java.time.LocalDate;

import static cn.xpbootcamp.gilded_rose.goods.GoodsTypes.*;

public class RulesHandler {

    public static int quality(Goods goods, LocalDate date) {
        ImmutableMap<GoodsTypes, Rules> rules = ImmutableMap.<GoodsTypes,Rules>builder()
                .put(COMMON, new CommonRules())
                .put(AGED_BRIE, new AgedBrieRules())
                .put(SULFURAS, new SulfurasRules())
                .put(BACKSTAGE_PASS, new BackstagePass())
                .build();
        return rules.get(goods.getType()).quality(goods, date);
    }
}
