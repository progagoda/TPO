package skewheap;

import org.junit.jupiter.api.Test;
import skewheap.exceptions.EmptyHeapException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class SkewHeapTest {

    @Test
    public void testConstruct() throws EmptyHeapException {
       SkewHeap skewHeap = new SkewHeap();
       assertEquals(skewHeap.construct(null, null), null);
       assertEquals(skewHeap.construct(skewHeap, null), skewHeap);
       List<Double> elems = Arrays.asList(1d,2d,3d);
       skewHeap = skewHeap.construct(skewHeap, elems);

    }

}
