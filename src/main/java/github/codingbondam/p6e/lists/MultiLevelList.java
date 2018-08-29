package main.java.github.codingbondam.p6e.lists;

import static main.java.github.codingbondam.p6e.Utils.assertEquals;

public class MultiLevelList <T> {

    Node<T> head;

    Node<T> tail;

    public void flatten() {

        Node<T> curr = head;
        Node<T> end = tail;

        while (curr != null) {
            if (curr.child != null) {
                end.next = curr.child;
                curr.child.prev = end;
                end = curr.child;
                while (end.next != null) {
                    end = end.next;
                }
            }
            curr = curr.next;
        }
    }

    public void unflatten() {
        unflattenInternal(head);
        // alternate method involves traversing the flattened list back using two pointers
        // this method visits nodes twice in some instances
    }

    public void unflattenInternal(Node<T> curr) {
        while (curr != null) {
            System.out.println("curr is " + curr.data);
            if (curr.child != null) {
                if (curr.child.prev != null) {
                    curr.child.prev.next = null;
                    curr.child.prev = null;
                }
                unflattenInternal(curr.child);
            }
            curr = curr.next;
        }
    }

    public static class Node <T> {

        T data;

        Node<T> next;
        Node<T> prev;
        Node<T> child;

        public Node(T data) {
            this.data = data;
        }

    }

    public static void testFlatten1() {

        MultiLevelList<String> list = new MultiLevelList<>();

        Node<String> a = new Node("a");
        Node<String> b = new Node("b");
        Node<String> c = new Node("c");
        Node<String> d = new Node("d");
        Node<String> e = new Node("e");
        Node<String> f = new Node("f");
        Node<String> g = new Node("g");
        Node<String> h = new Node("h");
        Node<String> i = new Node("i");
        Node<String> j = new Node("j");
        Node<String> k = new Node("k");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        g.next = h;

        a.child = f;
        c.child = g;
        g.child = j;
        h.child = k;
        e.child = i;

        list.head = a;
        list.tail = e;

        list.flatten();

        Node<String> curr = list.head;

        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.data);
            curr = curr.next;
        }
        String output = builder.toString();

        assertEquals("abcdefghijk", output);
    }

    public static void testFlatten2() {

        MultiLevelList<Integer> list = new MultiLevelList<>();

        Node<Integer> n5 = new Node(5);
        Node<Integer> n33 = new Node(33);
        Node<Integer> n17 = new Node(17);
        Node<Integer> n2 = new Node(2);
        Node<Integer> n1 = new Node(1);
        n5.next = n33; n33.next = n17; n17.next = n2; n2.next = n1;
        n33.prev = n5; n17.prev = n33; n2.prev = n17; n1.prev = n2;

        Node<Integer> n6 = new Node(6);
        Node<Integer> n25 = new Node(25);
        Node<Integer> n6_2 = new Node(6);
        n6.next = n25; n25.next = n6_2;
        n25.prev = n6; n6_2.prev = n25;

        Node<Integer> n2_2 = new Node(2);
        Node<Integer> n7 = new Node(7);
        n2_2.next = n7;
        n7.prev = n2_2;

        Node<Integer> n8 = new Node(8);

        Node<Integer> n9 = new Node(9);

        Node<Integer> n12 = new Node(12);
        Node<Integer> n5_2 = new Node(5);
        n12.next = n5_2;
        n5_2.prev = n12;

        Node<Integer> n7_2 = new Node(7);

        Node<Integer> n21 = new Node(21);
        Node<Integer> n3 = new Node(3);
        n21.next = n3;
        n3.prev = n21;

        list.head = n5;
        list.tail = n1;

        n5.child = n6;
        n2.child = n2_2;
        n25.child = n8;
        n6_2.child = n9;
        n2_2.child = n12;
        n9.child = n7_2;
        n12.child = n21;

        list.flatten();

        Node<Integer> curr = list.head;

        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.data);
            curr = curr.next;
        }

        String output = builder.toString();

        assertEquals("5331721625627891257213", output);
        list.unflatten();
    }

    public static void main(String[] args) {
        testFlatten1();
        testFlatten2();
    }

}
