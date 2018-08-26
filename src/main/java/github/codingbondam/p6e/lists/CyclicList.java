package main.java.github.codingbondam.p6e.lists;

import static main.java.github.codingbondam.p6e.Utils.assertEquals;

public class CyclicList {

    public static class Node {
        Node next;

    }

    public static boolean isCyclic(Node head) {

        Node p1, p2;
        p1 = p2 = head;

        do {
            p1 = p1.next;
            p2 = p2.next == null ? null : p2.next.next;
        } while (p1 != null && p2 != null && p1 != p2);

        if (p1 == null || p2 == null) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        // even case
        assertEquals(Boolean.TRUE, isCyclic(n1));

        n5.next = null;
        assertEquals(Boolean.FALSE, isCyclic(n1));

        // odd case
        Node n6 = new Node();
        n5.next = n6;
        n6.next = n2;
        assertEquals(Boolean.TRUE, isCyclic(n1));

    }
}
