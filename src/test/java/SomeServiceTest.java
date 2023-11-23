import org.Task_1.SomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SomeServiceTest {

    private SomeService example;

    @BeforeEach
    void setup(){
        example = new SomeService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 33})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertThat(example.fizzBuzz(n)).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 55, 500})
    void multipleFiveNotThreeReturnsBuzz(int n) {
        assertThat(example.fizzBuzz(n)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 600, 1500})
    void multipleFifteenReturnsFizzBuzz(int n) {
        assertThat(example.fizzBuzz(n)).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 13, 26, 52, 911})
    void noMultipleDivisorReturnsInputNumber(int n) {
        assertThat(example.fizzBuzz(n)).isEqualTo(String.valueOf(n));
    }

    @Test
    void sixBeginningOfArray(){
        assertTrue(example.firstLast6(new int[] {6, 12, 15, 52, 43, 22, 88}));
    }

    @Test
    void sixEndOfArray(){
        assertTrue(example.firstLast6(new int[] {88, 12, 15, 52, 43, 22, 6}));
    }

    @Test
    void sixNotBeginningAndEndOfArray(){
        assertFalse(example.firstLast6(new int[] {4, 12, 15, 6, 43, 22, 88}));
    }

    @Test
    void correctPurchaseAndDiscountAmount(){
        assertThat(example.calculatingDiscount(3200, 10)).isEqualTo(2880);
    }

    @Test
    void negativePurchaseAmountThrownException(){
        assertThatThrownBy(() -> example.calculatingDiscount(-2000, 10)).
                isInstanceOf(ArithmeticException.class);
    }

    @Test
    void discountAmountOutOfRangeThrownException(){
        assertThatThrownBy(() -> example.calculatingDiscount(2000, 125)).
                isInstanceOf(ArithmeticException.class);
    }

    @Test
    void inputNumbersWithoutThirteen(){
        assertThat(example.luckySum(2, 4, 7)).isEqualTo(13);
    }

    @Test
    void firstNumbersThirteen(){
        assertThat(example.luckySum(13, 4, 7)).isEqualTo(11);
    }

    @Test
    void secondNumbersThirteen(){
        assertThat(example.luckySum(2, 13, 7)).isEqualTo(9);
    }

    @Test
    void thirdNumbersThirteen(){
        assertThat(example.luckySum(2, 4, 13)).isEqualTo(6);
    }

}
