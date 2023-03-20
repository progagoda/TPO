package skewheap;

import java.util.NoSuchElementException;

public class SkewHeap {
    public Node root;

    public static class Node {
        Double value;
        Node left;
        Node right;

        Node(Double value) {
            System.out.print("C_");
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public SkewHeap() {
    }

    public void add(Double value) {
        System.out.print("A_");             //1
        Node current = new Node(value);     //1
        root = merge(root,current);         //1
    }

    public Double removeMin() {
        System.out.print("RM_");                //1
        if(empty()){                            //2
            System.out.print("E_");             //3
            throw new NoSuchElementException(); //3
        } else {                                //4
            System.out.print("NE_");            //4
            Double min = root.value;            //4
            root = merge(root.left, root.right);//4
            return min;                         //4
        }                                       //5
    }

    public boolean empty() {
        return root == null; //1
    }

    public void merge(SkewHeap other) {
        System.out.print("MH_");                        //1
        if(other != null) {                             //2
            System.out.print("NE_");                  //3
            this.root = merge(this.root, other.root);   //3
            other.root = null;                          //3
        } else {                                        //4
            System.out.print("E_");                   //4
        }                                               //5
    }

    public Node merge(Node root1, Node root2) {
        System.out.print("MN_");                        //1
        Node firstRoot = root1;                         //1
        Node secondRoot = root2;                        //1
        if(firstRoot == null){                          //2
            System.out.print("FN_");                  //3
            return secondRoot;                          //3
        }else if(secondRoot == null){                   //4
            System.out.print("SN_");                  //5
            return firstRoot;                           //5
        }                                               //6
        if(firstRoot.value <= secondRoot.value){        //7
            System.out.print("F<=S_");                //8
            Node temp = firstRoot.right;                //8
            firstRoot.right = firstRoot.left;           //8
            firstRoot.left = merge(secondRoot,temp);    //8
            return firstRoot;                           //8
        } else {                                        //9
            System.out.print("F>S_");                 //9
            return merge(secondRoot,firstRoot);         //9
        }                                               //10

    }
}
