import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] soccers, baseballs;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        soccers = new int[n+1];
        baseballs = new int[n+1];
        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            soccers[i] = Integer.parseInt(st.nextToken());
            baseballs[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][12][10];
        for(int[][] cell : dp) {
            for(int[] c : cell) {
                Arrays.fill(c, -1);
            }
        }

        dp[0][0][0] = 0;
        solve();
    }

    private static void solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<12;j++) {
                for(int k=0;k<10;k++) {
                    // 선수 발탁 x
                    dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i][j][k]);

                    // 축구 선수로 발탁
                    if(j>=1) {
                        dp[i][j][k] = Math.max(dp[i-1][j-1][k]+soccers[i], dp[i][j][k]);
                    }

                    // 야구 선수로 발탁
                    if(k>=1) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k-1]+baseballs[i], dp[i][j][k]);
                    }
                }
            }
        }

        int ans = dp[n][11][9];
        System.out.println(ans);
    }
}