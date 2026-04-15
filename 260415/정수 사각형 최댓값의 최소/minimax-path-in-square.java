import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] dp, grid;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        grid = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = grid[0][0];
        for(int i=1;i<n;i++) {
            dp[i][0] = Math.max(dp[i-1][0], grid[i][0]);
            dp[0][i] = Math.max(dp[0][i-1], grid[0][i]);
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<n;j++) {
                int minMax = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.max(minMax, grid[i][j]); 
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}