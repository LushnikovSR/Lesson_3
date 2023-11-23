import Task_2.Calculate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculateTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 16, 32, 64, 12800000})
    public void intNumberIsEvenReturnTrue(int n){
        assertTrue(Calculate.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 27, 55, 111, 25100001})
    public void intNumberIsOddReturnFalse(int n){
        assertFalse(Calculate.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 41, 58, 64, 72, 84, 99})
    public void intNumberIsInRangeReturnTrue(int n){
        assertTrue(Calculate.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 12, 25, 100, 109})
    public void intNumberIsOutRangeReturnFalse(int n){
        assertFalse(Calculate.numberInInterval(n));
    }
}
