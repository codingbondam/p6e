import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Closest {

    public static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.valueOf(x) + ", " +  String.valueOf(y);
        }
    }

    public static class DistanceComparator implements Comparator<Point> {

        private double distance(int x, int y) {
            return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }

        @Override
        public int compare(Point p1, Point p2) {
            if (distance(p1.x, p1.y) > distance(p2.x, p2.y)) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public static List<Point> closest(List<Point> points, int n) {

        Comparator comparator = new DistanceComparator();
        PriorityQueue<Point> queue = new PriorityQueue<>(comparator);

        List<Point> closest = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            queue.add(points.get(i));
            closest.add(points.get(i));
        }

        for(int i = n; i < points.size(); i++) {
            Point farthest = queue.peek();
            Point current = points.get(i);
            if (comparator.compare(farthest, current) > 0) {
                queue.remove();
                queue.add(current);
                closest.remove(farthest);
                closest.add(current);
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        List<Point> input = new ArrayList<>();
        input.add(new Point(3, 0));
        input.add(new Point(1, 0));
        input.add(new Point(2, 0));
        input.add(new Point(4, 1));

        for (Point p : closest(input, 2)) {
            System.out.println(p);
        }



    }
}
