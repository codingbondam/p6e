package main.java.github.codingbondam.p6e.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Api {

    public static void main(String[] args) {

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer> () {

            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }

        });
        q.add(32);
        q.add(10);
        q.add(20);
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
