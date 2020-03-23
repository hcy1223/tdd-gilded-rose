package cn.xpbootcamp.gilded_rose.goods;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidQualityException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cn.xpbootcamp.gilded_rose.goods.Goods.*;
import static org.junit.jupiter.api.Assertions.*;


public class GoodsTest {

    @Test
    void should_create_goods() {
        Goods newGoods = createGoods()
                .name("goods")
                .sellIn(30)
                .quality(20)
                .manufacturing(LocalDate.now())
                .build();
        assertNotNull(newGoods);
        assertEquals(newGoods.getName(), "goods");
        assertEquals(newGoods.getSellIn(), 30);
        assertEquals(newGoods.getQuality(), 20);
        assertEquals(newGoods.getManufacturing(), LocalDate.now());
    }

    @Test
    void should_not_create_goods_when_quality_is_lower_than_zero() {
        assertThrows(InvalidQualityException.class, () -> {
            createGoods()
                    .name("goods")
                    .sellIn(30)
                    .quality(-10)
                    .manufacturing(LocalDate.now())
                    .build();
        });
    }

    @Test
    void should_not_create_goods_when_quality_is_higher_than_fifty() {
        assertThrows(InvalidQualityException.class, () -> {
            createGoods()
                    .name("goods")
                    .sellIn(30)
                    .quality(51)
                    .manufacturing(LocalDate.now())
                    .build();
        });
    }

    @Test
    void should_create_aged_brie() {
        Goods agedBrie = createAgedBrie()
                .name("aged brie")
                .sellIn(30)
                .quality(45)
                .manufacturing(LocalDate.now())
                .build();

        assertNotNull(agedBrie);
        assertEquals(agedBrie.getName(), "aged brie");
        assertEquals(agedBrie.getSellIn(), 30);
        assertEquals(agedBrie.getQuality(), 45);
        assertEquals(agedBrie.getManufacturing(), LocalDate.now());
    }

    @Test
    void should_create_sulfuras() {
        Goods sulfuras = createSulfuras()
                .name("sulfuras")
                .quality(10)
                .manufacturing(LocalDate.now())
                .build();

        assertNotNull(sulfuras);
        assertEquals(sulfuras.getName(), "sulfuras");
        assertEquals(sulfuras.getQuality(), 10);
        assertEquals(sulfuras.getManufacturing(), LocalDate.now());
    }

    @Test
    void should_create_backstage_pass() {
        Goods backstagePass = createBackstagePass()
                .name("backstage pass")
                .sellIn(15)
                .quality(3)
                .manufacturing(LocalDate.now())
                .build();

        assertNotNull(backstagePass);
        assertEquals(backstagePass.getName(), "backstage pass");
        assertEquals(backstagePass.getSellIn(), 15);
        assertEquals(backstagePass.getQuality(), 3);
        assertEquals(backstagePass.getManufacturing(), LocalDate.now());
    }
}
