package skewheap;

import report.Report;

import java.util.NoSuchElementException;

public class SkewHeap {
    public Node root;
    public static class Node {
        Double value;
        Node left;
        Node right;

        Node(Double value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public SkewHeap() {

    }
    public void add(Double value, Report report) {
        report.add("A_");
        Node current = new Node(value);
        root = merge(root,current, new Report());
    }
    public Double removeMin(Report report) {
        report.add("RM_");
        if(empty()){
            report.add("E_");
            throw new NoSuchElementException();
        }
        else{
            report.add("NE_");
            Double min = root.value;
            root = merge(root.left, root.right, new Report());
            return min;
        }
    }
    public boolean empty() {
        return root == null;
    }
    public void merge(SkewHeap other, Report report) {
        report.add("VM_");
        if(other != null) {
            report.add("ONE_");
            this.root = merge(this.root, other.root, new Report());
            other.root = null;
        } else {
            report.add("ON_");
        }
    }

    public Node merge(Node root1, Node root2, Report report) {
        report.add("NM_");              //1
        Node firstRoot = root1;         //1
        Node secondRoot = root2;        //1
        if(firstRoot == null){          //2
            report.add("FRN_");         //3
            return secondRoot;          //3
        }else if(secondRoot == null){   //4
            report.add("SRN_");         //5
            return firstRoot;           //5
        }
        if(firstRoot.value <= secondRoot.value){    //6
            report.add("FR<=SR_");                  //7
            Node temp = firstRoot.right;            //7
            firstRoot.right = firstRoot.left;       //7
            firstRoot.left = merge(secondRoot,temp, report);   //7
            return firstRoot;                       //7
        }
        else{                                       //8
            report.add("FR>SR_");                   //8
            return merge(secondRoot,firstRoot, report); //8
        }                                           //9

    }
}
