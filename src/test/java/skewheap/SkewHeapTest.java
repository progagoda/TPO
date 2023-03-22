package skewheap;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import report.Report;
import skewheap.exceptions.EmptyHeapException;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
public class SkewHeapTest {

    public Report report;

    @BeforeEach
    public void init(){
       this.report = new Report();
    }
    @Test
    public void addTest(){
       SkewHeap emptyHeap = new SkewHeap();
       emptyHeap.add(1D, this.report);
       assertEquals(emptyHeap.root.value, 1D);
       assertEquals(report.report, "A_");
    }

    @Test
    public void removeMinEmptyTest(){
        SkewHeap emptyHeap = new SkewHeap();
        assertThrows(NoSuchElementException.class, ()-> emptyHeap.removeMin(this.report));
        assertEquals(report.report, "RM_E_");
    }

    @Test
    public void removeMinNotEmptyTest(){
        SkewHeap heap = new SkewHeap();
        Report addRep = new Report();
        heap.add(1D, addRep);
        heap.add(2D, addRep);
        heap.add(13D, addRep);
        heap.add(10D, addRep);
        heap.add(100D, addRep);
        Double minim = heap.removeMin(this.report);
        assertEquals(minim, 1D);
        assertEquals(report.report, "RM_NE_");
    }

    @Test
    public void removeMinOneElemTest(){
        SkewHeap heap = new SkewHeap();
        Report addRep = new Report();
        heap.add(13D, addRep);
        Double minim = heap.removeMin(this.report);
        assertEquals(minim, 13D);
        assertEquals(report.report, "RM_NE_");
    }

    @Test
    public void voidMergeNullTest(){
        SkewHeap heap1 = new SkewHeap();
        heap1.merge(null, this.report);
        assertEquals(this.report.report, "VM_ON_");
    }

    @Test
    public void voidMergeTest(){
        SkewHeap heap1 = new SkewHeap();
        SkewHeap heap2 = new SkewHeap();
        List<Double> vals1 = Arrays.asList(10d, 2d, 30d, 100d, 1d, 3.33d);
        List<Double> vals2 = Arrays.asList(3d, 32d, 4d);
        Report addRep = new Report();
        vals1.stream().forEach(elem -> heap1.add(elem, addRep));
        vals2.stream().forEach(elem -> heap2.add(elem, addRep));
        heap1.merge(heap2, this.report);
        assertEquals(this.report.report, "VM_ONE_");
    }

    @Test
    public void nodeMergeFirstNullTest(){
        SkewHeap heap1 = new SkewHeap();
        heap1.add(1D, new Report());
        SkewHeap.Node res = heap1.merge(null, heap1.root, this.report);
        assertEquals(this.report.report, "NM_FRN_");
    }

    @Test
    public void nodeMergeSecondNullTest(){
        SkewHeap heap1 = new SkewHeap();
        heap1.add(1D, new Report());
        SkewHeap.Node res = heap1.merge(heap1.root, null, this.report);
        assertEquals(this.report.report, "NM_SRN_");
    }


    @Test
    public void nodeMergeEqTest(){
        SkewHeap heap1 = new SkewHeap();
        SkewHeap heap2 = new SkewHeap();
        Report addRep = new Report();
        heap1.add(1D, addRep);
        heap2.add(1D, addRep);
        SkewHeap.Node res = heap1.merge(heap1.root, heap2.root, this.report);
        SkewHeap resHeap = new SkewHeap();
        resHeap.root = res;
        assertEquals(this.report.report, "NM_FR<=SR_NM_SRN_");
        assertEquals(resHeap.removeMin(new Report()), 1D);
    }

    @Test
    public void nodeMergeFirstBiggerTest(){
        SkewHeap heap1 = new SkewHeap();
        SkewHeap heap2 = new SkewHeap();
        Report addRep = new Report();
        heap1.add(10D, addRep);
        heap2.add(1D, addRep);
        SkewHeap.Node res = heap1.merge(heap1.root, heap2.root, this.report);
        SkewHeap resHeap = new SkewHeap();
        resHeap.root = res;
        assertEquals(this.report.report, "NM_FR>SR_NM_FR<=SR_NM_SRN_");
        assertEquals(resHeap.removeMin(new Report()), 1D);
    }

    @Test
    public void nodeMergeSecondBiggerTest(){
        SkewHeap heap1 = new SkewHeap();
        SkewHeap heap2 = new SkewHeap();
        Report addRep = new Report();
        heap1.add(34D, addRep);
        heap2.add(34234D, addRep);
        SkewHeap.Node res = heap1.merge(heap1.root, heap2.root, this.report);
        SkewHeap resHeap = new SkewHeap();
        resHeap.root = res;
        assertEquals(this.report.report, "NM_FR<=SR_NM_SRN_");
        assertEquals(resHeap.removeMin(new Report()), 34D);
    }
}
