import java.io.*;
import java.util.*;

public class Main {
    
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] board, dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dp = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = 1;
        for(int i=1;i<n;i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<n;j++) {
                for(int k=0;k<i;k++) {
                    for (int l=0;l<j;l++) {
                        if (board[i][j] <= board[k][l]) continue;
                        dp[i][j] = Math.max(dp[k][l]+1, dp[i][j]);
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ans = Math.max(dp[i][j], ans);
            }
        }

        System.out.println(ans);
    }
}