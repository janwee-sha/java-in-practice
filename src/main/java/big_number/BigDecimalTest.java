package big_number;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class BigDecimalTest {
    @Test
    public void givenBigDecimalsThenShouldMatchValues() {
        BigDecimal fromString = new BigDecimal("0.1");
        assertThat(fromString.toString()).isEqualTo("0.1");

        BigDecimal fromCharArray = new BigDecimal(new char[]
                {'3', '.', '1', '6', '1', '5'});
        assertThat(fromCharArray.toString()).isEqualTo("3.1615");

        BigDecimal fromInt = new BigDecimal(27);
        assertThat(fromInt.toString()).isEqualTo("27");

        BigDecimal fromLong = new BigDecimal(12345678901L);
        assertThat(fromLong.toString()).isEqualTo("12345678901");

        BigDecimal fromLong2 = BigDecimal.valueOf(12345678901L);
        assertThat(fromLong2).isEqualTo(fromLong);

        BigDecimal fromLong3 = BigDecimal.valueOf(12345678901L, 2);
        assertThat(fromLong3.toString()).isEqualTo("123456789.01");

        BigDecimal fromDouble = BigDecimal.valueOf(123456789.01d);
        assertThat(fromDouble).isEqualTo(fromLong3);
    }

    @Test
    public void givenBigDecimalsThenShouldNotMatchValues() {
        BigDecimal fromDouble = new BigDecimal(0.1);
        assertThat(fromDouble.toString()).isNotEqualTo("0.1");
        System.out.println(fromDouble);
    }

    @Test
    public void whenRoundingDecimalsThenMatchValues() {
        BigDecimal notRounded1 = new BigDecimal("0.48"), notRounded2 = new BigDecimal("0.44"),
                notRounded3 = new BigDecimal("0.45");
        MathContext halfEvenContext = new MathContext(1, RoundingMode.HALF_EVEN);
        BigDecimal halfEven1 = notRounded1.round(halfEvenContext), halfEven2 = notRounded2.round(halfEvenContext),
                halfEven3 = notRounded3.round(halfEvenContext);
        assertThat(halfEven1.toString()).isEqualTo("0.5");
        assertThat(halfEven2.toString()).isEqualTo("0.4");
        assertThat(halfEven3.toString()).isEqualTo("0.4");


        MathContext halfUpContext = new MathContext(1, RoundingMode.HALF_UP);
        BigDecimal halfUp1 = notRounded1.round(halfUpContext), halfUp2 = notRounded2.round(halfUpContext),
                halfUp3 = notRounded3.round(halfUpContext);
        assertThat(halfUp1.toString()).isEqualTo("0.5");
        assertThat(halfUp2.toString()).isEqualTo("0.4");
        assertThat(halfUp3.toString()).isEqualTo("0.5");
    }
}
