package skewheap;

import org.junit.jupiter.api.Test;
import skewheap.exceptions.EmptyHeapException;
import skewheap.SkewHeap;

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
    @Test
    void testMerge() {
        SkewHeap skewHeap = new SkewHeap();
        // Create two binary search trees to merge
        SkewHeap.Node root1 = new  SkewHeap.Node(5D);
        root1.left = new  SkewHeap.Node(3D);
        root1.right = new  SkewHeap.Node(7D);
        root1.left.left = new SkewHeap.Node(1D);

        SkewHeap.Node root2 = new SkewHeap.Node(4D);
        root2.left = new SkewHeap.Node(2D);
        root2.right = new SkewHeap.Node(6D);

        // Expected output after merging the two trees
        SkewHeap.Node expected = new SkewHeap.Node(5D);
        expected.left = new SkewHeap.Node(4D);
        expected.right = new SkewHeap.Node(7D);
        expected.left.left = new SkewHeap.Node(3D);
        expected.left.right = new SkewHeap.Node(6D);
        expected.left.left.left = new SkewHeap.Node(1D);
        expected.left.left.right = new SkewHeap.Node(2D);

        // Test the merge method
        SkewHeap.Node actual = skewHeap.merge(root1, root2);
        assertEquals(expected, actual);

        // Test merge with null root1
        SkewHeap.Node actual2 = skewHeap.merge(null, root2);
        assertEquals(root2, actual2);

        // Test merge with null root2
        SkewHeap.Node actual3 = skewHeap.merge(root1, null);
        assertEquals(root1, actual3);

        // Test merge with both roots null
        SkewHeap.Node actual4 = skewHeap.merge(null, null);
        assertNull(actual4);
    }

}
