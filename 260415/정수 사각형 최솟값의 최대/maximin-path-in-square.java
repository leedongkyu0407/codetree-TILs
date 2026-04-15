import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        int[][] grid = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[1][1] = grid[1][1];
        for(int i=2;i<=n;i++) {
            dp[1][i] = Math.min(dp[1][i-1], grid[1][i]);
            dp[i][1] = Math.min(dp[i-1][1], grid[i][1]);
        }
        
        for(int i=2;i<=n;i++) {
            for(int j=2;j<=n;j++) {
                int maxMin = Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.min(maxMin, grid[i][j]); 
            }
        }
        System.out.println(dp[n][n]);
    }
}