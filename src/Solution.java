import java.util.Scanner;

public class Solution {
    private static final int UNKNOWN = 0;
    private static final int DONT_EXIST = -1;
    private static final int CALCULATING = -2;

    static int[][] f_table = null;
    static boolean[][] edges = null;
    static int s, n, m;

    static int f(int v, int mod) {
        v--;
        if(f_table[v][mod] > 0) {
            return f_table[v][mod]-1;
        }
        switch (f_table[v][mod]) {
            case UNKNOWN:
                break;
            case DONT_EXIST:
            case CALCULATING:
                return -1;
        }
        f_table[v][mod] = CALCULATING;
        int min_way = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(edges[i][v]) {
                int way = f(i + 1, (mod + 1) % 3);
                if(way != -1 && way < min_way) {
                    min_way = way;
                }
            }
        }
        if(min_way == Integer.MAX_VALUE) {
            f_table[v][mod] = DONT_EXIST;
            return -1;
        } else {
            f_table[v][mod] = min_way + 2;
            return min_way + 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        edges = new boolean[n][n];
        int u, v;

        for(int i = 0; i < m; i++) {
            u = in.nextInt();
            v = in.nextInt();
            edges[u-1][v-1] = true;
        }

        s = in.nextInt();
        int t = in.nextInt();

        f_table = new int[n][3];
        f_table[s-1][0] = 1;

        System.out.println(f(t, 0));
    }
}
