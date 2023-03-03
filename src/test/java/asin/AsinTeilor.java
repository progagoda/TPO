package asin;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsinTeilor {
    static AsinTeilor asinTeilor;
    @BeforeAll
    public static void createAll(){
        asinTeilor= new AsinTeilor();
    }
    @Test
    public  void correctResult() throws NullPointerException{
        assertEquals(asinTeilor.validate(null), "Dot null argument");
        assertEquals(asinTeilor.validate(0D), true);
        assertEquals(asinTeilor.validate(1D), true);
        assertEquals(asinTeilor.validate(10D), false);
        assertEquals(asinTeilor.doublefact(0D), 1D);
        assertEquals(asinTeilor.doublefact(1D), 1D);
        assertEquals(asinTeilor.doublefact(10D), Math.asin(10D));


    }
}
