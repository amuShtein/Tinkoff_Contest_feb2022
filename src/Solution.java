import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n+1][3];

        int a, b;
        for(int i = 0; i < m; i++) {
            a = in.nextInt();
            b = in.nextInt();

            arr[a][0]++;
            if(arr[a][0] > 2) {
                System.out.println("No");
                return;
            }

            arr[a][arr[a][0]] = b;

            arr[b][0]++;
            if(arr[b][0] > 2) {
                System.out.println("No");
                return;
            }

            arr[b][arr[b][0]] = a;

            if(arr[a][0] == 2 && arr[b][0] == 2) {
                int prev = a;
                int cur = arr[a][1];

                while(arr[cur][0] == 2) {
                    if(arr[cur][1] == prev) {
                        prev = cur;
                        cur = arr[cur][2];
                    } else {
                        prev = cur;
                        cur = arr[cur][1];
                    }

                    if(cur == b) {
                        System.out.println("No");
                        return;
                    }
                }
            }
        }

        System.out.println("Yes");
    }
}
