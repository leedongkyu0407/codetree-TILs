import java.util.Scanner;
import java.io.*;

public class Main {
    static int[][] belt;
    static int n, t, left, right;
    static int[] top, bottom;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        top = new int[n];
        bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        
        while(t-->0) {
            move();
        }
        printAns();
    }

    private static void move() {
        int rightTop = top[n-1];
        int leftDown = bottom[n-1];
        for(int i=n-1;i>=1;i--) {
            top[i] = top[i-1];
        }
        top[0] = leftDown;

        for(int i=n-1;i>=1;i--) {
            bottom[i] = bottom[i-1];
        }
        bottom[0] = rightTop;
    }

    private static void printAns() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(top[i]).append(" ");
        }
        sb.append("\n");

        for(int i=0;i<n;i++) {
            sb.append(bottom[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}