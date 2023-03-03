package skewheap;

import java.util.NoSuchElementException;

public class SkewHeap {
    private Node root;
    private static class Node {
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
    public void add(Double value) {
        Node current = new Node(value);
        root = merge(root,current);
    }
    public Double removeMin() {
        if(empty()){
            throw new NoSuchElementException();
        }
        else{
            Double min = root.value;
            root = merge(root.left, root.right);
            return min;
        }
    }
    public boolean empty() {
        return root == null;
    }
    public void merge(SkewHeap other) {
        if(other != null){
            this.root = merge(this.root, other.root);
            other.root = null;
        }
    }

    private Node merge(Node root1, Node root2) {
        Node firstRoot = root1;
        Node secondRoot = root2;
        if(firstRoot == null){
            return secondRoot;
        }else if(secondRoot == null){
            return firstRoot;
        }
        if(firstRoot.value <= secondRoot.value){
            Node temp = firstRoot.right;
            firstRoot.right = firstRoot.left;
            firstRoot.left = merge(secondRoot,temp);
            return firstRoot;
        }
        else{
            return merge(secondRoot,firstRoot);
        }

    }
}
