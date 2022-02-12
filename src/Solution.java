import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] num1 = in.next().toCharArray();
        char[] num2 = in.next().toCharArray();

        int len1 = num1.length;
        int len2 = num2.length;

        char d1, d2;

        for(int i = 0; i < len1; i++) {
            if(i >= len2) {
                System.out.println("No");
                return;
            }

            d1 = num1[len1 - 1 - i];
            d2 = num2[len2 - 1 - i];

            if(d1 - '0' + d2 - '0' >= 10) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
        return;
    }
}
