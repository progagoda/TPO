package skewheap;

import org.junit.jupiter.api.Test;
import skewheap.exceptions.EmptyHeapException;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
public class SkewHeapTest {

    @Test
    public void testExtractMinFromEmptyHeap() throws EmptyHeapException {
       SkewHeap skewHeap = new SkewHeap();
       assertThrows(NoSuchElementException.class, () -> skewHeap.removeMin());
    }

    @Test
    public void testExtractLastMin() throws EmptyHeapException {
        SkewHeap skewHeap = new SkewHeap();
        skewHeap.add(1D);
        assertEquals(skewHeap.removeMin(), 1D);
        assertThrows(NoSuchElementException.class, ()-> skewHeap.removeMin());
    }

    @Test
    public void testEmpty(){
        SkewHeap skewHeap = new SkewHeap();
        assertTrue(skewHeap.empty());
    }

    @Test
    public void testComplex(){
        SkewHeap skewHeap = new SkewHeap();
        skewHeap.add(400d);
        skewHeap.add(0.999999999999d);
        skewHeap.add(3d);
        skewHeap.add(40d);
        skewHeap.add(3.4d);
        skewHeap.add(1.99999d);
        skewHeap.add(24.1123d);
        assertEquals(skewHeap.removeMin(),0.999999999999d);
        assertEquals(skewHeap.removeMin(),1.99999d);
        assertEquals(skewHeap.removeMin(),3d);
        assertEquals(skewHeap.removeMin(),3.4d);
        assertEquals(skewHeap.removeMin(),24.1123d);
        assertEquals(skewHeap.removeMin(),40d);
        assertEquals(skewHeap.removeMin(),400d);
    }


}
