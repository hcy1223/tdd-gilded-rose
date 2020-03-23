package cn.xpbootcamp.gilded_rose.goods;

import cn.xpbootcamp.gilded_rose.Exceptions.InvalidDateException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cn.xpbootcamp.gilded_rose.goods.Goods.createGoods;
import static cn.xpbootcamp.gilded_rose.goods.PriceRules.price;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceTest {
    @Test
    void should_get_price_before_expiry_date_within_normal_rate() {
        Goods apple = createGoods()
                .name("apple")
                .sellIn(30)
                .quality(20)
                .manufacturing(LocalDate.of(2020, 3, 3))
                .build();
        PriceRules applePrice = price(apple, LocalDate.of(2020, 3, 10));

        assertEquals(applePrice.getQuality(), 13);
    }

    @Test
    void should_not_get_price_before_manufacturing_date() {
        Goods apple = createGoods()
                .name("apple")
                .sellIn(30)
                .quality(20)
                .manufacturing(LocalDate.of(2020, 3, 3))
                .build();

        assertThrows(InvalidDateException.class, () -> {
            price(apple, LocalDate.of(2019, 10, 1));
        });
    }

    @Test
    void should_get_price_after_expiry_date_within_double_rate() {
        Goods apple = createGoods()
                .name("apple")
                .sellIn(30)
                .quality(50)
                .manufacturing(LocalDate.of(2020, 3, 3))
                .build();

        PriceRules applePrice = price(apple, LocalDate.of(2020, 4, 10));
//        50-30*1-(38-30)*2
        assertEquals(applePrice.getQuality(), 4);
    }
}
