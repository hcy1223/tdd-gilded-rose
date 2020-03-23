package cn.xpbootcamp.gilded_rose.goods;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class GoodsTest {
    @Test
    void should_create_goods() {
        Goods newGoods = new Goods("goods", 30, 20, LocalDate.now());
        assertNotNull(newGoods);
        assertEquals(newGoods.getName(), "goods");
        assertEquals(newGoods.getSellIn(), new Integer(30));
        assertEquals(newGoods.getQuality(), new Integer(20));
        assertEquals(newGoods.getManufacturing(), LocalDate.now());

    }
}
