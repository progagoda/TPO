package asin;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsinTeilorTest {
    private static final double EPSILON = 0.001;
    private static final double DELTA = 0.0001;
    private static AsinTeilor asinTeilor;

    @BeforeAll
    public static void createAsin() {
        asinTeilor = new AsinTeilor();
    }

    @Test
    public void testCalculate() {
        Assertions.assertEquals(0.0, asinTeilor.calculate(0.0d), 0.0001);
        Assertions.assertEquals(Math.PI / 6.0, asinTeilor.calculate(0.5), 0.0001);
        Assertions.assertEquals(Math.PI / 4.0, asinTeilor.calculate(Math.sqrt(2) / 2.0), 0.0001);
        Assertions.assertEquals(Math.PI / 2.0, asinTeilor.calculate(1.0), 0.0001);
        Assertions.assertEquals(-Math.PI / 2.0, asinTeilor.calculate(-1.0), 0.0001);
        assertNull(asinTeilor.calculate(2.0));
        assertNull(asinTeilor.calculate(null));
    }

    @Test
    public void testValidate() {
        Assertions.assertTrue(asinTeilor.validate(0.0));
        Assertions.assertTrue(asinTeilor.validate(0.5));
        Assertions.assertTrue(asinTeilor.validate(Math.sqrt(2) / 2.0));
        Assertions.assertTrue(asinTeilor.validate(-0.5));
        Assertions.assertTrue(asinTeilor.validate(-Math.sqrt(2) / 2.0));
        Assertions.assertFalse(asinTeilor.validate(1.0));
        Assertions.assertFalse(asinTeilor.validate(-1.0));
        Assertions.assertFalse(asinTeilor.validate(2.0));
        try {
            asinTeilor.validate(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("Dot null argument", e.getMessage());
        }
    }

    @Test
    public void testDoublefact() {
        Assertions.assertEquals(1.0, asinTeilor.doublefact(0.0), 0.0001);
        Assertions.assertEquals(1.0, asinTeilor.doublefact(1.0), 0.0001);
        Assertions.assertEquals(3.0, asinTeilor.doublefact(2.0), 0.0001);
        Assertions.assertEquals(15.0, asinTeilor.doublefact(4.0), 0.0001);
    }

    @Test
    public void testFact() {
        Assertions.assertEquals(1.0, asinTeilor.fact(0.0), 0.0001);
        Assertions.assertEquals(1.0, asinTeilor.fact(1.0), 0.0001);
        Assertions.assertEquals(2.0, asinTeilor.fact(2.0), 0.0001);
        Assertions.assertEquals(24.0, asinTeilor.fact(4.0), 0.0001);
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
        Assertions.assertEquals(0.375, result, EPSILON);
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
    public void testDoublefactValidInput() {
        Double result = asinTeilor.doublefact(5.0);
        Assertions.assertEquals(15.0, result, DELTA);
    }

    @Test
    public void testDoublefactInvalidInput() {
        Double result = asinTeilor.doublefact(-2.0);
        Assertions.assertEquals(1.0, result, DELTA);
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
        Assertions.assertEquals(0.13333, result, DELTA);
    }

    @Test
    public void testGetMultForMonomialInvalidInput() {
        Double result = asinTeilor.get_mult_for_monomial(-2.0, -1.0);
        Assertions.assertEquals(1.0, result, DELTA);
    }
    @Test
    public void testCalculateReturnsNullForNullInput() {

        Double result = asinTeilor.calculate(null);
        assertNull(result);
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

    @Test
    public void testCalculateReturnsApproximateValueForInputBetweenNegativeOneAndZero() {
        Double result = asinTeilor.calculate(-0.5);
        assertEquals(-0.5236, result, 0.0001);
    }

}


