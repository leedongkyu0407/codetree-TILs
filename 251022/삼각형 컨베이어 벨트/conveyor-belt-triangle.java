import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        while(t-- > 0) {
            int temp = l[n-1];
            for(int i=n-1;i>=1;i--) {
                l[i] = l[i-1];
            }
            l[0] = d[n-1];

            int temp2 = r[n-1];
            for(int i=n-1;i>=1;i--) {
                r[i] = r[i-1];
            }
            r[0] = temp;

            for(int i=n-1;i>=1;i--) {
                d[i] = d[i-1];
            }
            d[0] = temp2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(l[i]).append(" ");
        }
        sb.append("\n");

        for(int i=0;i<n;i++) {
            sb.append(r[i]).append(" ");
        }
        sb.append("\n");

        for(int i=0;i<n;i++) {
            sb.append(d[i]).append(" ");
        }

        System.out.println(sb.toString());
    }


}