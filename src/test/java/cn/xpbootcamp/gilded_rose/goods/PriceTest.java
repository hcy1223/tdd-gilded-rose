package cn.xpbootcamp.gilded_rose.goods;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidDateException;
import cn.xpbootcamp.gilded_rose.TestBase;
import org.junit.jupiter.api.Test;

import static cn.xpbootcamp.gilded_rose.goods.Goods.*;
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
        Goods agedBrie = createAgedBrie()
                .name("aged brie")
                .sellIn(10)
                .quality(11)
                .manufacturing(date(2020, 3, 1))
                .build();

        assertEquals(agedBrie.getQuality(date(2020, 3, 21)), 31);
        assertEquals(agedBrie.getQuality(date(2020, 4, 21)), 50);
    }

    @Test
    void should_get_instant_the_price_of_sulfuras() {
        Goods sulfuras = createSulfuras()
                .name("sulfuras")
                .quality(11)
                .manufacturing(date(2020, 3, 1))
                .build();
        assertEquals(sulfuras.getQuality(date(2020, 4, 1)), 11);
    }

    @Test
    void should_get_price_of_backstage_pass() {
        Goods backstagePass = createBackstagePass()
                .name("backstage pass")
                .sellIn(15)
                .quality(3)
                .manufacturing(date(2020, 3, 1))
                .build();
//        3+3
        assertEquals(backstagePass.getQuality(date(2020,3,4)), 6);
//        3+5+3*2
        assertEquals(backstagePass.getQuality(date(2020,3,9)), 14);
//        3+5+5*2+2*3
        assertEquals(backstagePass.getQuality(date(2020,3,13)), 24);

        assertEquals(backstagePass.getQuality(date(2020,4,1)), 0);
    }

    @Test
    void should_get_price_of_backstage_pass_when_sellIn_lower_than_ten() {
        Goods backstagePass = createBackstagePass()
                .name("backstage pass")
                .sellIn(9)
                .quality(3)
                .manufacturing(date(2020, 3, 1))
                .build();
//        3+3*2
        assertEquals(backstagePass.getQuality(date(2020,3,4)), 9);
//        3+4*2+3*3
        assertEquals(backstagePass.getQuality(date(2020,3,8)), 20);

        assertEquals(backstagePass.getQuality(date(2020,4,1)), 0);

    }
}
