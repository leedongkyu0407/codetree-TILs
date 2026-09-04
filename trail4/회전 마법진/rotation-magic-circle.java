import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] present, target;
    private static int[][] dp;
    private static final int INF = Integer.MAX_VALUE/2;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        present = new int[n+1];
        target = new int[n+1];

        String p = bf.readLine();
        String t = bf.readLine();

        for(int i=0;i<n;i++) {
            present[i+1] = p.charAt(i)-'0';
            target[i+1] = t.charAt(i)-'0';
        }

        dp = new int[n+1][10];

        for(int[] c : dp) {
            Arrays.fill(c, INF);
        }

        dp[0][0] = 0;
        solve();
    }

    private static void solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<10;j++) {
                // 시계방향 회전
                int y = ((present[i]+j-target[i])%10+10)%10;

                for(int prevR=0;prevR<10;prevR++) {
                    if(dp[i-1][prevR] >= INF) continue;

                    // 반시계방향 회전 총합
                    int d = ((j-prevR)%10+10)%10;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][prevR]+y+d);
                }
            }
        }

        int ans = INF;
        for(int i=0;i<10;i++) {
            ans = Math.min(ans, dp[n][i]);
        }

        System.out.println(ans);
    }
}