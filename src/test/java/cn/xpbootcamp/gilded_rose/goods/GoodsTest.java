package cn.xpbootcamp.gilded_rose.goods;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidQualityException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void should_not_create_goods_when_quality_is_lower_than_zero() {
        Goods newGoods = new Goods();
        newGoods.setName("goods");
        newGoods.setSellIn(30);
        newGoods.setManufacturing(LocalDate.now());
        assertThrows(InvalidQualityException.class, ()-> {
            newGoods.setQuality(-10);
        });
    }
}
