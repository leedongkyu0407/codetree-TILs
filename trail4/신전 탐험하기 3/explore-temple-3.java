import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] dp;
    private static int[][] rooms;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=m;j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n+1][m+1];
        
        for(int r=1;r<=m;r++) {
            dp[1][r] = rooms[1][r];
        }
        solve();
    }

    private static void solve() {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                for(int k=1;k<=m;k++) {
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+rooms[i][j]);
                }
            }
        }

        int ans = 0;
        for(int i=1;i<=m;i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);
    }
}