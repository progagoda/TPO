package asin;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsinTeilor {
    private static final double EPSILON = 0.001;
    private static final double DELTA = 0.0001;
    private AsinTeilor asinTeilor;

    @Before
    public void setUp() {
        asinTeilor = new AsinTeilor();
    }
    @Test
    public void testCalculate() {
        AsinTeilor asinTeilor = new AsinTeilor();
        assertEquals(0.0, asinTeilor.calculate(0.0), 0.0001);
        assertEquals(Math.PI / 6.0, asinTeilor.calculate(0.5), 0.0001);
        assertEquals(Math.PI / 4.0, asinTeilor.calculate(Math.sqrt(2) / 2.0), 0.0001);
        assertEquals(Math.PI / 2.0, asinTeilor.calculate(1.0), 0.0001);
        assertEquals(-Math.PI / 2.0, asinTeilor.calculate(-1.0), 0.0001);
        assertNull(asinTeilor.calculate(2.0));
        assertNull(asinTeilor.calculate(null));
    }

    @Test
    public void testValidate() {
        AsinTeilor asinTeilor = new AsinTeilor();
        assertTrue(asinTeilor.validate(0.0));
        assertTrue(asinTeilor.validate(0.5));
        assertTrue(asinTeilor.validate(Math.sqrt(2) / 2.0));
        assertTrue(asinTeilor.validate(-0.5));
        assertTrue(asinTeilor.validate(-Math.sqrt(2) / 2.0));
        assertFalse(asinTeilor.validate(1.0));
        assertFalse(asinTeilor.validate(-1.0));
        assertFalse(asinTeilor.validate(2.0));
        try {
            asinTeilor.validate(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("Dot null argument", e.getMessage());
        }
    }

    @Test
    public void testDoublefact() {
        AsinTeilor asinTeilor = new AsinTeilor();
        assertEquals(1.0, asinTeilor.doublefact(0.0), 0.0001);
        assertEquals(1.0, asinTeilor.doublefact(1.0), 0.0001);
        assertEquals(3.0, asinTeilor.doublefact(2.0), 0.0001);
        assertEquals(15.0, asinTeilor.doublefact(4.0), 0.0001);
    }

    @Test
    public void testFact() {
        AsinTeilor asinTeilor = new AsinTeilor();
        assertEquals(1.0, asinTeilor.fact(0.0), 0.0001);
        assertEquals(1.0, asinTeilor.fact(1.0), 0.0001);
        assertEquals(2.0, asinTeilor.fact(2.0), 0.0001);
        assertEquals(24.0, asinTeilor.fact(4.0), 0.0001);
    }
    @Test
    public void testCalculateValidInput() {
        AsinTeilor asinTeilor = new AsinTeilor();
        Double result = asinTeilor.calculate(0.5);
        Assertions.assertEquals(0.523598, result, EPSILON);
    }

    @Test
    public void testCalculateNullInput() {
        AsinTeilor asinTeilor = new AsinTeilor();
        Assertions.assertThrows(NullPointerException.class, () -> {
            asinTeilor.calculate(null);
        });
    }

    @Test
    public void testCalculateInvalidInput() {
        AsinTeilor asinTeilor = new AsinTeilor();
        Double result = asinTeilor.calculate(2.0);
        Assertions.assertNull(result);
    }
    @Test
    public void testGetMultForMonomial() {
        AsinTeilor asinTeilor = new AsinTeilor();
        Double result = asinTeilor.get_mult_for_monomial(1.0, 0.5);
        Assertions.assertEquals(0.375, result, EPSILON);
    }

    @Test
    public void testValidateValidInput() {
        AsinTeilor asinTeilor = new AsinTeilor();
        boolean result = asinTeilor.validate(0.5);
        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateNullInput() {
        AsinTeilor asinTeilor = new AsinTeilor();
        Assertions.assertThrows(NullPointerException.class, () -> {
            asinTeilor.validate(null);
        });
    }

    @Test
    public void testValidateInvalidInput() {
        AsinTeilor asinTeilor = new AsinTeilor();
        boolean result = asinTeilor.validate(2.0);
        Assertions.assertFalse(result);
    }


    @Test
    public void testCalculateNegativeInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.calculate(-0.5);
        Assertions.assertEquals(-0.5236, result, DELTA);
    }

    @Test
    public void testCalculateZeroInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.calculate(0.0);
        Assertions.assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testDoublefactValidInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.doublefact(5.0);
        Assertions.assertEquals(15.0, result, DELTA);
    }

    @Test
    public void testDoublefactInvalidInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.doublefact(-2.0);
        Assertions.assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testFactValidInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.fact(5.0);
        Assertions.assertEquals(120.0, result, DELTA);
    }

    @Test
    public void testFactInvalidInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.fact(-2.0);
        Assertions.assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testGetMultForMonomialValidInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.get_mult_for_monomial(2.0, 0.5);
        Assertions.assertEquals(0.13333, result, DELTA);
    }

    @Test
    public void testGetMultForMonomialInvalidInput() {
        AsinTeilor asin = new AsinTeilor();
        Double result = asin.get_mult_for_monomial(-2.0, -1.0);
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


