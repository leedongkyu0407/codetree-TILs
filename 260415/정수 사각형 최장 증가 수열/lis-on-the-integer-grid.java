import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] grid, dp;
    private static int[][] deltas = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        grid = new int[n][n];
        dp = new int[n][n];
        
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int ans = 0;
        for(int x=0;x<n;x++) {
            for(int y=0;y<n;y++) {
                ans = Math.max(ans, solve(x, y));
            }
        }
        System.out.println(ans);
    }

    private static int solve(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 1;

        for(int[] delta: deltas) {
            int nx = x+delta[0];
            int ny = y+delta[1];

            if (!inRange(nx, ny)) continue;
            if (grid[x][y] < grid[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], solve(nx, ny)+1);
            }
        }
        
        return dp[x][y];
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}