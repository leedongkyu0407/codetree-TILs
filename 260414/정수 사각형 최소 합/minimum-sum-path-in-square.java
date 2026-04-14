import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n+2][n+2];
        int[][] board = new int[n+2][n+2];
        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=n;i>0;i--) {
            dp[1][i] = board[1][i]+dp[1][i+1];
        }

        for(int i=1;i<=n;i++) {
            dp[i][n] = board[i][n]+dp[i-1][n];
        }

        for(int i=2;i<=n;i++) {
            for(int j=n-1;j>0;j--) {
                dp[i][j] = Math.min(dp[i-1][j]+board[i][j], dp[i][j+1]+board[i][j]);
            }
        }
        System.out.println(dp[n][1]);
    }
}