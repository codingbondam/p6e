package main.java.github.codingbondam.p6e.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

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

        /**
         * rotates right at the given node
         * @return
         */
        public Node rotateRight() {
            Node newRoot = left;
            left = newRoot.right;
            newRoot.right = this;
            return newRoot;
        }
    }

    /**
     * similar to visit but doesn't use recursion
     * @param consumer
     */
    public void traverse(Consumer<T> consumer) {

        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node<T> node = stack.pop();
            consumer.accept(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void visit(Consumer<T> consumer) {
        visitInternal(root, consumer);
    }

    private void visitInternal(Node<T> root, Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        consumer.accept(root.data);
        visitInternal(root.left, consumer);
        visitInternal(root.right, consumer);
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

    public static void testVisit() {

        Node<Integer> i100 = new Node<Integer>(100);
        Node<Integer> i50 = new Node<Integer>(50);
        Node<Integer> i150 = new Node<Integer>(150);
        Node<Integer> i25 = new Node<Integer>(25);
        Node<Integer> i75 = new Node<Integer>(75);
        Node<Integer> i125 = new Node<Integer>(125);
        Node<Integer> i175 = new Node<Integer>(175);
        Node<Integer> i110 = new Node<Integer>(110);

        i100.left = i50;
        i100.right = i150;
        i50.left = i25;
        i50.right = i75;
        i150.left = i125;
        i150.right = i175;
        i125.left = i110;

        BinaryTree<Integer> tree = new BinaryTree<>(i100);

        StringBuffer buffer = new StringBuffer();
        tree.visit(t -> buffer.append("<" + t + ">"));
        assertEquals("<100><50><25><75><150><125><110><175>", buffer.toString());

        StringBuffer buffer2 = new StringBuffer();
        tree.traverse(t -> buffer2.append("<" + t + ">"));
        assertEquals("<100><50><25><75><150><125><110><175>", buffer2.toString());


    }

    public static void main(String[] args) {
        testHeight();
        testVisit();
    }

}
