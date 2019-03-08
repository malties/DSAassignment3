import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Tree<Item extends Comparable<Item>> {
    // If the tree is empty, root is a null reference.
    private Node<Item> root = null;
    // A node of a tree contains a label, and optionally
// references to the roots of its left and right subtrees,
// which might be null if the subtrees are empty.
    public static class Node<Item> {
        public Node<Item> left = null;
        public Node<Item> right = null;
        public Item el = null;
        // Will print out the binary node structure
        public void print() {
            print("", true);
        }
        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "âââ " : "âââ ") + el.toString());
            if (right != null) {
                right.print(prefix + (isTail ? "    " : "â "), false);
            }
            if (left != null) {
                left.print(prefix + (isTail ? "    ":"â "), true);
            }
        }
    }
    // For unit testing purposes
    public void setRoot(Node<Item> newRoot) {
        root = newRoot;
    }
    public Node<Item> getRoot() {
        return root;
    }
    // This method constructs the following
// example tree with 5 in the root:
//
//   __5__
//  /     \
// /       \
// 1       8
//  \     /  \
//  2    1    3
//      / \
//     5   7
    public static Tree<Integer> exampleTree() {
        Node<Integer> t = new Node<Integer>();
        t.el = 5;
        Node<Integer> t1 = new Node<Integer>();
        t.left = t1;
        t1.el = 1;
        Node<Integer> t2 = new Node<Integer>();
        t.right = t2;
        t2.el = 8;
        Node<Integer> t12 = new Node<Integer>();
        t1.right = t12;
        t12.el = 2;
        Node<Integer> t21 = new Node<Integer>();
        t2.left = t21;
        t21.el = 1;
        Node<Integer> t22 = new Node<Integer>();
        t2.right = t22;
        t22.el = 3;
        Node<Integer> t211 = new Node<Integer>();
        t21.left = t211;
        t211.el = 5;
        Node<Integer> t212 = new Node<Integer>();
        t21.right = t212;
        t212.el = 7;
        Tree<Integer> res = new Tree<Integer>();
        res.root = t;
        return res;
    }
    // This method constructs the following
// example binary tree with 4 in the root:
//
//      __4__
//     /     \
//    /       \
//   1         8
//    \       / \
//     2     6   9
//          / \
//          5 7
    public static Tree<Integer> exampleTreeBin() {
        Node<Integer> t = new Node<Integer>();
        t.el = 4;
        Node<Integer> t1 = new Node<Integer>();
        t.left = t1;
        t1.el = 1;
        Node<Integer> t2 = new Node<Integer>();
        t.right = t2;
        t2.el = 8;
        Node<Integer> t12 = new Node<Integer>();
        t1.right = t12;
        t12.el = 2;
        Node<Integer> t21 = new Node<Integer>();
        t2.left = t21;
        t21.el = 6;
        Node<Integer> t22 = new Node<Integer>();
        t2.right = t22;
        t22.el = 9;
        Node<Integer> t211 = new Node<Integer>();
        t21.left = t211;
        t211.el = 5;
        Node<Integer> t212 = new Node<Integer>();
        t21.right = t212;
        t212.el = 7;
        Tree<Integer> res = new Tree<Integer>();
        res.root = t;
        return res;
    }
    public int size() {
        return size(root);
    }
    private int size(Node<Item> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }
    /**
     *  Assignment 3 Question 7. Returns the nth element in Breadth First
     Search
     *  (BFS) order
     *
     *  @param n the position
     *  @return the element found at the position
     */
    public Item nthBFS(int n) {
        if (root ==null){
            throw new IllegalArgumentException("Index out of bounds, you jerk!");
        }
        if (n==0){
            return root.el;
        }
        Queue<Node<Item>> myQueue = new LinkedList <>();
        Node<Item> currentNode = root;

        for (int i = 0; i<n;i++){
            if(currentNode.left!=null){
                myQueue.add(currentNode.left);
            }
            if (currentNode.right!=null){
                myQueue.add(currentNode.right);
            }
            currentNode = myQueue.remove();
        }

        return currentNode.el;

    }



    /**
     *  Hands on session 7, exercise 2. Prints the labels of the tree's
     nodes in
     *  breadth first order (BFS)
     *
     */
    public void printBFT() {
        throw new UnsupportedOperationException();
    }
    /**
     *  Hands on session 7, exercise 1. Returns the n:th element in Depth
     First
     *  Search
     *
     *  @param n the node to find
     *  @return the element in the n:th place
     *
     */
    public Item nthDFS(int n) {
        Stack <Node<Item>> myStack = new Stack <>();
        if (root==null){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        myStack.push(root);
        int indexCount = 0;
        Node<Item> currentNode = root;

        while(!myStack.empty()){
            currentNode = myStack.pop();
            if (indexCount==n){
                return currentNode.el;
            }
            if(currentNode.right !=null){
                myStack.push(currentNode.right);
            }

            if(currentNode.left !=null){
                myStack.push(currentNode.left);
            }
            indexCount++;
        }
        throw new IllegalArgumentException("Index out of bounds");
    }
    /**
     *  Assignment 3 Question 8. Prints the nodes of the tree in depth-
     first
     *  order
     */
    public void printDFS() {
        System.out.println(toStringDFS());
        throw new UnsupportedOperationException();
    }
    /**
     *  Creates a string according to DFS.
     *  Made public for unit testing
     *
     *  @return a string representation of the tree in DFS order
     */
    public String toStringDFS() {

        Stack<Node<Item>> myStack = new Stack <>();
        if (root==null){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        myStack.add(root);
        Node<Item> currentNode = root;
        String result = "";

        while(!myStack.empty()){
            currentNode = myStack.pop();
            if (currentNode.right !=null){
                myStack.push(currentNode.right);
            }if(currentNode.left !=null){
                myStack.push(currentNode.left);
            }
            result += currentNode.el.toString()+ "\n";
        }
        return result;
    }
    /**
     *  Assignment 3, Question 9. Insert i into a binary search tree
     *
     *  @param i the Item to insert
     */
    public void insertBST(Item i) {

        root = insertRec(root, i);
    }

    Node insertRec(Node node, Item i) {

        if (node== null) {
            Node n = new Node<Item>();
            n.el = i;
            return n;
        }

        if (Integer.parseInt(i.toString())<=Integer.parseInt(node.el.toString())){
            node.left = insertRec(node.left, i);
        }
        else if (Integer.parseInt(i.toString())>Integer.parseInt(node.el.toString())) {
            node.right = insertRec(node.right, i);
        }

        return node;

    }
    /**
     *  Hands on session 7, exercise 3. Removes one item from a binary
     search
     *  tree and then rearranges the nodes so that the tree after the item
     is
     *  removed is still a binary search tree.
     *
     *  @param i - the item to remove
     */
    public void removeBST(Item i) {
// This method mainly calls deleteRec()
        root = deleteRec(root, i);
    }
    /**
     *  A recursive function to delete a new element in BST, assuming
     existing
     *  tree is BST.
     *
     *  @param root the current root node
     *  @param i the Item to delete
     *  @return the new root node
     */
    private Node<Item> deleteRec(Node<Item> root, Item i) {
        throw new UnsupportedOperationException();
    }
    /**
     *  A method for visualization and debugging
     */
    public void printTree() {
        if (root != null) {
            root.print();
        }
    }
    public static void main(String[] args) {
        Tree<Integer> t = exampleTree();
// System.out.println("Size: " + t.size());
        t.printTree();
    }
}