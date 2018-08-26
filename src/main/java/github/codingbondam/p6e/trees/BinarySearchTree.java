package main.java.github.codingbondam.p6e.trees;

import static main.java.github.codingbondam.p6e.Utils.assertEquals;

public class BinarySearchTree {

    private Node root;

    BinarySearchTree(Node root) {
        this.root = root;
    }

    public int lca(int n1, int n2) {
        return lca(root, n1, n2);
    }

    private int lca(Node n, int n1, int n2) {

        if (n1 > n.data && n2 > n.data) {
            return lca(n.right, n1, n2);
        } else if (n1 < n.data && n2 < n.data) {
            return lca(n.left, n1, n2);
        } else {
            return n.data;
        }
    }

    public static class Node {

        int data;

        Node left;

        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void testLca() {
        Node n20 = new Node(20);
        Node n8 = new Node(8);
        Node n22 = new Node(22);
        Node n4 = new Node(4);
        Node n2 = new Node(2);
        Node n6 = new Node(6);
        Node n10 = new Node(10);
        Node n12 = new Node(12);
        Node n14 = new Node(14);

        n20.left = n8;
        n20.right = n22;

        n8.left = n4;
        n8.right = n12;

        n4.left = n2;
        n4.right = n6;

        n12.left = n10;
        n12.right = n14;

        BinarySearchTree bst = new BinarySearchTree(n20);
        assertEquals(8, String.valueOf(bst.lca(4, 14)));
        assertEquals(8, String.valueOf(bst.lca(4, 8)));
        assertEquals(8, String.valueOf(bst.lca(6, 10)));
    }

    public static void main(String[] args) {
        testLca();
    }

}
