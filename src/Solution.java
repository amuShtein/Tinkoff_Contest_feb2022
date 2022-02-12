import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        long sum = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        long x = in.nextLong();

        long full = x / sum;

        x -= full*sum;
        long nsum = 0;
        int k = 0;
        while(nsum <= x) {
            nsum += arr[k];
            k++;
        }

        System.out.println(full*n+k);
    }
}
