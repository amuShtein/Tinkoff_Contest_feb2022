import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeSet<Point> set = new TreeSet<>();

        TreeSet<Integer> horizontal = new TreeSet<>();
        TreeSet<Integer> vertical = new TreeSet<>();

        int n = in.nextInt();
        int x, y;
        Point p;

        for(int i = 0; i < n; i++) {
            x = in.nextInt();
            y = in.nextInt();

            p = new Point(x, y);

            if(!set.contains(p)) {
                if(set.contains(new Point(x, Point.ANY))) {
                    vertical.add(x);
                }
                if(set.contains(new Point(Point.ANY, y))) {
                    horizontal.add(y);
                }

                set.add(p);
            }
        }

        int h = horizontal.size();
        int w = vertical.size();

        System.out.println( (w*(w-1)/2) * (h*(h-1)/2) );
    }
}

class Point implements Comparable<Point> {
    public static final int ANY = Integer.MAX_VALUE;
    int x, y;
    @Override
    public int compareTo(Point o) {
        if(x == ANY || o.x == ANY || x == o.x) {
            if(y == ANY || o.y == ANY || y == o.y) {
                return 0;
            } else {
                return y-o.y;
            }
        } else {
            return x - o.x;
        }
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
