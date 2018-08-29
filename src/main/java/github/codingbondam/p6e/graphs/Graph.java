package main.java.github.codingbondam.p6e.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static main.java.github.codingbondam.p6e.Utils.assertEquals;

public class Graph {

    public static int distance(Node start, Node end) {
        List<Node> cLevel = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        cLevel.add(start);
        int distance = 0;
        while (!cLevel.isEmpty() && !cLevel.contains(end)) {
            List<Node> nLevel = new LinkedList<>();
            for (Node node : cLevel) {
                for (Node child: node.neighbors) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        nLevel.add(child);
                    }
                }
            }
            cLevel = nLevel;
            distance++;
        }
        if (!cLevel.contains(end)) {
            throw new IllegalArgumentException("End node is not reachable from the start node!");
        }
        return distance;
    }

    public static class Node {

        String data;

        Set<Node> neighbors;

        public Node(String data) {
            this.data = data;
        }


    }

    public static Set set(Node ...nodes) {
        Set<Node> set = new HashSet<>();
        for (Node n : nodes) {
            set.add(n);
        }
        return set;
    }

    public static void main(String[] args) {

        Node vamsi = new Node("vamsi");
        Node srini = new Node("srini");
        Node vikram = new Node("vikram");
        Node ramesh = new Node("ramesh");
        Node sweta = new Node("sweta");

        vamsi.neighbors = set(srini, vikram, sweta);
        srini.neighbors = set(vikram, vamsi, ramesh);
        vikram.neighbors = set(vamsi, ramesh);
        ramesh.neighbors = set(srini, vikram);
        sweta.neighbors = set(vamsi);

        assertEquals(2, distance(vamsi, ramesh));
        assertEquals(3, distance(sweta, ramesh));
        assertEquals(0, distance(vamsi, vamsi));
        assertEquals(1, distance(vamsi, vikram));
    }

}
