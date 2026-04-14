import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n+1][n+1];
        int[][] board = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = board[1][1];
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                dp[i][j] = Math.max(dp[i][j-1]+board[i][j], dp[i-1][j]+board[i][j]);
            }
        }

        System.out.println(dp[n][n]);
    }
}