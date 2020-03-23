package cn.xpbootcamp.gilded_rose.goods;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidDateException;
import cn.xpbootcamp.gilded_rose.TestBase;
import org.junit.jupiter.api.Test;

import static cn.xpbootcamp.gilded_rose.goods.Goods.createGoods;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceTest extends TestBase {
    @Test
    void should_get_price_before_expiry_date_within_normal_rate() {
        Goods apple = createGoods()
                .name("apple")
                .sellIn(30)
                .quality(20)
                .manufacturing(date(2020, 3, 3))
                .build();

        assertEquals(apple.getQuality(date(2020, 3, 10)), 13);
    }

    @Test
    void should_not_get_price_before_manufacturing_date() {
        Goods apple = createGoods()
                .name("apple")
                .sellIn(30)
                .quality(20)
                .manufacturing(date(2020, 3, 3))
                .build();

        assertThrows(InvalidDateException.class, () -> {
            apple.getQuality(date(2020, 2, 3));
        });
    }

    @Test
    void should_get_price_after_expiry_date_within_double_rate() {
        Goods apple = createGoods()
                .name("apple")
                .sellIn(30)
                .quality(50)
                .manufacturing(date(2020, 3, 3))
                .build();

//        50-30*1-(38-30)*2
        assertEquals(apple.getQuality(date(2020, 4, 10)), 4);
    }

    @Test
    void should_get_zero_when_after_a_long_time() {
        Goods apple = createGoods()
                .name("apple")
                .sellIn(30)
                .quality(50)
                .manufacturing(date(2020, 3, 3))
                .build();

        assertEquals(apple.getQuality(date(2020, 5, 10)), 0);
    }

    @Test
    void should_get_the_price_of_aged_brie() {
        Goods agedBrie = Goods.createAgedBrie()
                .name("aged brie")
                .sellIn(10)
                .quality(11)
                .manufacturing(date(2020, 3, 1))
                .build();

        assertEquals(agedBrie.getQuality(date(2020, 3, 21)), 31);
        assertEquals(agedBrie.getQuality(date(2020, 4, 21)), 50);
    }
}
