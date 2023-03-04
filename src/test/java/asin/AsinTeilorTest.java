package asin;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class AsinTeilorTest {
    private static final double EPSILON = 0.001;
    private static final double DELTA = 0.0001;
    private static final double MathSqrt = Math.sqrt(2);
    private static AsinTeilor asinTeilor;

    @BeforeAll
    public static void createAsin() {
        asinTeilor = new AsinTeilor();
    }

    @ParameterizedTest
    @CsvSource({"0.0,0.0, 0.0001", "0.5,0.5236, 0.0001", "0.7071,0.7854, 0.001", "1.0,1.5708, 0.1", "-1.0,-1.5708, 0.1", "-0.001,-0.001, 0.0001", "0.001,0.001, 0.001"})
    public void testCalculate(double input, double expectedOutput, double delta) {
        Assertions.assertEquals(expectedOutput, asinTeilor.calculate(input), delta);
    }
    @ParameterizedTest
    @ValueSource(doubles = {2.0, 10000.0,-10000.0 } )
    public void testCalculateIf(double input) {
        assertNull(asinTeilor.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.5, 1.0, -1.0})
    public void testValidateValid(double input) {
        Assertions.assertTrue(asinTeilor.validate(input));
    }
    @ParameterizedTest
    @ValueSource(doubles = {2.0, 1.0 + EPSILON, -1.0 - EPSILON})
    public void testValidateInvalid(double input) {
        Assertions.assertFalse(asinTeilor.validate(input));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 1.0",
            "1.0, 1.0",
            "2.0, 2.0",
            "4.0, 24.0"
    })
    public void testFact(double n, double expected) {
        Assertions.assertEquals(expected, asinTeilor.fact(n), 0.0001);
    }
    @Test
    public void testCalculateValidInput() {
        Double result = asinTeilor.calculate(0.5);
        Assertions.assertEquals(0.523598, result, EPSILON);
    }

    @Test
    public void testCalculateNullInput() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            asinTeilor.calculate(null);
        });
    }

    @Test
    public void testCalculateInvalidInput() {
        Double result = asinTeilor.calculate(2.0);
        Assertions.assertNull(result);
    }
    @Test
    public void testGetMultForMonomial() {
        Double result = asinTeilor.get_mult_for_monomial(1.0, 0.5);
        Assertions.assertEquals(0.5/3, result, EPSILON);
    }

    @Test
    public void testValidateValidInput() {
        boolean result = asinTeilor.validate(0.5);
        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateNullInput() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            asinTeilor.validate(null);
        });
    }

    @Test
    public void testValidateInvalidInput() {
        boolean result = asinTeilor.validate(2.0);
        Assertions.assertFalse(result);
    }


    @Test
    public void testCalculateNegativeInput() {
        Double result = asinTeilor.calculate(-0.5);
        Assertions.assertEquals(-0.5236, result, DELTA);
    }

    @Test
    public void testCalculateZeroInput() {
        Double result = asinTeilor.calculate(0.0);
        Assertions.assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testFactValidInput() {
        Double result = asinTeilor.fact(5.0);
        Assertions.assertEquals(120.0, result, DELTA);
    }

    @Test
    public void testFactInvalidInput() {
        Double result = asinTeilor.fact(-2.0);
        Assertions.assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testGetMultForMonomialValidInput() {
        Double result = asinTeilor.get_mult_for_monomial(2.0, 0.5);
        Assertions.assertEquals(0.075, result, DELTA);
    }

    @Test
    public void testGetMultForMonomialInvalidInput() {
        Double result = asinTeilor.get_mult_for_monomial(-2.0, -1.0);
        Assertions.assertNull(result);
    }
    @Test
    public void testCalculateReturnsNullForNullInput() {

        assertThrows(NullPointerException.class, () -> asinTeilor.calculate(null));
    }
    

    @Test
    public void testValidateReturnsFalseForInputGreaterThanOne() {
        boolean result = asinTeilor.validate(2.0);
        assertFalse(result);
    }

    @Test
    public void testValidateReturnsFalseForInputLessThanNegativeOne() {
        boolean result = asinTeilor.validate(-2.0);
        assertFalse(result);
    }

    @Test
    public void testValidateReturnsTrueForInputEqualToOne() {
        boolean result = asinTeilor.validate(1.0);
        assertTrue(result);
    }

    @Test
    public void testValidateReturnsTrueForInputEqualToNegativeOne() {
        boolean result = asinTeilor.validate(-1.0);
        assertTrue(result);
    }

    @Test
    public void testCalculateReturnsZeroForInputEqualToZero() {
        Double result = asinTeilor.calculate(0.0);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testCalculateReturnsApproximateValueForInputBetweenZeroAndOne() {
        Double result = asinTeilor.calculate(0.5);
        assertEquals(0.5236, result, 0.0001);
    }

}


