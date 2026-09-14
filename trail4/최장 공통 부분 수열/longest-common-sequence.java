import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static String A, B;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        A = bf.readLine();
        B = bf.readLine();

        int n = A.length();
        int m = B.length();

        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);   
    }
}