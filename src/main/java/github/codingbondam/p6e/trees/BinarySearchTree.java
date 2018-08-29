package main.java.github.codingbondam.p6e.trees;

import java.util.Arrays;

import static main.java.github.codingbondam.p6e.Utils.assertEquals;

public class BinarySearchTree {

    private Node root;

    BinarySearchTree(Node root) {
        this.root = root;
    }

    public BinarySearchTree(int[] input) {
        Node[] nodes = new Node[input.length];
        for (int i = 0; i < input.length; i++) {
            nodes[i] = new Node(input[i]);
        }

        for (int i = 0; (2 * i + 1) < input.length; i++) {
            Node node = nodes[i];
            node.left = nodes[2 * i + 1];
            if (2 * i + 2 < input.length) {
                node.right = nodes[2 * i + 2];
            }
        }
        root = nodes[0];
    }

    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) {
            return 0;
        }
        int lSize = size(n.left);
        int rSize = size(n.right);
        return lSize + rSize + 1;
    }

    public int[] array() {
        int[] output = new int[size()];
        array(root, output, -1);
        return output;
    }

    private int array(Node node, int[] output, int last) {
        if (node == null) {
            return last;
        }
        last++;
        output[last] = node.data;
        if (node.left != null) {
            last = array(node.left, output, last);
        }
        if (node.right != null) {
            last = array(node.right, output, last);
        }
        return last;
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

    public static void testArray() {
        Node n23 = new Node(23);
        Node n48 = new Node(48);
        Node n144 = new Node(144);
        Node n12 = new Node(12);
        Node n15 = new Node(15);
        Node n17 = new Node(17);
        Node n13 = new Node(13);
        Node n96 = new Node(96);
        Node n22 = new Node(22);

        n23.left = n48;
        n23.right = n144;

        n48.left = n12;
        n48.right = n15;

        n144.left = n17;
        n144.right = n13;

        n12.right = n96;

        n13.left = n22;

        BinarySearchTree bst = new BinarySearchTree(n23);
        int[] out = bst.array();
        Arrays.sort(out);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < out.length; i++) {
            builder.append("<");
            builder.append(out[i]);
            builder.append(">");
        }
        assertEquals("<12><13><15><17><22><23><48><96><144>", builder.toString());
        BinarySearchTree bst1 = new BinarySearchTree(out);
        int[] out2 = bst1.array();
        builder = new StringBuilder();
        for (int i = 0; i < out2.length; i++) {
            builder.append("<");
            builder.append(out2[i]);
            builder.append(">");
        }
        assertEquals("<12><13><17><96><144><22><15><23><48>", builder.toString());
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
        testArray();
    }

}
