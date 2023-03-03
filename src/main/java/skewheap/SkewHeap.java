package skewheap;

import skewheap.exceptions.EmptyHeapException;

import java.util.ArrayList;
import java.util.List;

public class SkewHeap{

    public Double key;
    public SkewHeap ltree;
    public SkewHeap rtree;

    public SkewHeap merge(SkewHeap h1, SkewHeap h2) throws EmptyHeapException{
        if (h1 == null){
            return h2;
        }
        if (h2 == null){
            return h1;
        }
        if (h1 == null && h2 == null){
            throw new EmptyHeapException();
        }

        if (h1.key > h2.key){
            SkewHeap temp = h1;
            h1 = h2;
            h2 = temp;
        }

        SkewHeap temp = h1.ltree;
        h1.ltree = h1.rtree;
        h1.rtree = temp;

        h1.ltree = merge(h2, h1.ltree);
        return h1;
    }

    public SkewHeap construct(SkewHeap root, List<Double> heap) throws EmptyHeapException {
        if (heap == null){
            return root;
        }
        SkewHeap temp;
        for (int i = 0; i < heap.size(); i++){
            temp = new SkewHeap();
            temp.key = heap.get(i);
            root = merge(root, temp);
        }
        return root;
    }

    public Integer size(){
        return size(this, 0);
    }

    private Integer size(SkewHeap root, Integer cnt){
        if (root == null){
            return 0;
        }
        cnt += size(root.ltree, cnt);
        cnt += size(root.rtree, cnt);
        cnt++;
        return cnt;
    }

    public String view(SkewHeap root, String ans){
        if (root == null){
            return "";
        }
        ans += view(root.ltree, ans);
        ans += root.key + "  ";
        ans += view(root.rtree, ans);
        return ans;
    }
}
