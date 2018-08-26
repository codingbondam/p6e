package main.java.github.codingbondam.p6e.lists;

import static main.java.github.codingbondam.p6e.Utils.assertEquals;
import java.util.Iterator;

public class LinkedList <T> {

    private Node<T> head, tail;

    public LinkedList() {

    }

    public void add(T data) {
        Node<T> element = new Node<>(data);
        if (this.tail == null && this.head == null) {
            this.tail = element;
            this.head = element;
        } else {
            this.tail.next = element;
            this.tail = this.tail.next;
        }
    }

    /**
     * where m is the distance in number of nodes from the tail
     * @param m
     */
    public void remove(int m) {
        Node<T> black = head;
        while (m > 0) {
            m--;
            black = black.next;
        }
        Node<T> red = head;
        Node<T> redPrev = null;
        while (black.next != null) {
            black = black.next;
            redPrev = red;
            red = red.next;
        }

        // if red is the only element
        if (head == red && tail == red) {
            head = null;
            tail = null;
        } else if(head == red) {
            head = head.next;
        } else if(tail == red) {
            tail = redPrev;
            redPrev.next = null;
        } else {
            redPrev.next = red.next;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                Node<T> rtVal = current;
                current = current.next;
                return rtVal.data;
            }
        };
    }

    @Override
    public String toString() {
        Iterator<T> iterator = this.iterator();

        StringBuffer buffer = new StringBuffer();
        buffer.append("\"");
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
        }
        buffer.append("\"");
        return buffer.toString();
    }

    // helper class
    public static class Node <T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

    public static void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i ++) {
            list.add(i);
        }
        assertEquals("0123456789", list);

        // remove tail
        list.remove(0);
        assertEquals("012345678", list);

        // remove head
        list.remove(8);
        assertEquals("12345678", list);

        // somewhere from the middle
        list.remove(5);
        assertEquals("1245678", list);

        for(int i = 6; i > 0; i--) {
            list.remove(i);
        }
        assertEquals("8", list);

        // when mth is the only element
        list.remove(0);
        assertEquals("", list);
    }

    public static void main(String[] args) {

        testRemove();
    }

}
