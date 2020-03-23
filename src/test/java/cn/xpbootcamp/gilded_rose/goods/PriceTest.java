package cn.xpbootcamp.gilded_rose.goods;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cn.xpbootcamp.gilded_rose.goods.Goods.createGoods;
import static cn.xpbootcamp.gilded_rose.goods.PriceRules.price;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(applePrice.getQuality(),13);
    }
}
