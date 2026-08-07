import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] dp;
    private static int[][] rooms;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        rooms = new int[n][3];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
            rooms[i][2] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][3];
        for(int i=0;i<3;i++) {
            dp[0][i] = rooms[0][i];
        }
        solve();
    }

    private static void solve() {
        for(int i=1;i<n;i++) {
            for(int j=0;j<3;j++) {
                for(int k=0;k<3;k++) {
                    if(j==k) continue;
                    dp[i][k] = Math.max(dp[i][k], dp[i-1][j]+rooms[i][k]);
                }
            }
        }

        int ans = 0;
        for(int i=0;i<3;i++) {
            ans = Math.max(dp[n-1][i], ans);
        }
        System.out.println(ans);
    }
}