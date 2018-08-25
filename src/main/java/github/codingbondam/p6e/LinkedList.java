package main.java.github.codingbondam.p6e;


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
        assert "0123456789".equals(list.toString());

        // remove tail
        list.remove(0);
        assert "012345678".equals(list.toString());

        // remove head
        list.remove(8);
        assert "12345678".equals(list.toString());

        // somewhere from the middle
        list.remove(5);
        assert "1245678".equals(list.toString());

        for(int i = 6; i > 0; i--) {
            list.remove(i);
        }
        assert "8".equals(list.toString());

        // when mth is the only element
        list.remove(0);
        assert "".equals(list.toString());
    }

    public static void main(String[] args) {

        testRemove();
    }

}
