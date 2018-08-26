package main.java.github.codingbondam.p6e.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static main.java.github.codingbondam.p6e.Utils.assertEquals;

public class BinaryTree <T> {

    Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public static class Node <T> {

        T data;

        Node<T> left;

        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * same as height but uses an alternate non recursive implementation
     * @return number of levels in the tree
     */
    public int levels() {
        int levels = 0;
        List<Node<T>> current = new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()) {
            levels++;
            List<Node<T>> next = new LinkedList<>();
            Iterator<Node<T>> iterator = current.iterator();

            while (iterator.hasNext()) {
                Node<T> node = iterator.next();
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            current = next;
        }

        return levels;
    }

    public int height() {
        return heightInternal(root);
    }

    private int heightInternal(Node<T> root) {

        if (root == null) {
            return 0;
        }

        int left = heightInternal(root.left);
        int right = heightInternal(root.right);
        int max = left > right ? left : right;
        return max + 1;
    }

    public static void testHeight() {

        Node<String> a = new Node<String>("a");
        Node<String> b = new Node<String>("b");
        Node<String> c = new Node<String>("c");
        Node<String> d = new Node<String>("d");
        Node<String> e = new Node<String>("e");
        Node<String> f = new Node<String>("f");
        Node<String> g = new Node<String>("g");
        Node<String> h = new Node<String>("h");
        Node<String> i = new Node<String>("i");

        a.left = b;
        b.left = d;
        d.right = g;
        g.left = h;
        h.right = i;

        a.right = c;
        c.right = e;
        e.right = f;

        BinaryTree<String> tree = new BinaryTree<>(a);
        assertEquals(6, tree.height());
        assertEquals(6, tree.levels());

    }

    public static void main(String[] args) {
        testHeight();
    }

}
