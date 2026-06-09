import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] nums;
    private static long[][] dp;
    private static final int OFFSET = 20;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[n+1][41];
        dp[0][OFFSET] = 1;

        solve();
        System.out.println(dp[n][m+OFFSET]);
    }

    private static void solve() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<=40;j++) {
                if(dp[i][j]==0) continue;

                if (j+nums[i+1]<=40) {
                    dp[i+1][j+nums[i+1]] += dp[i][j];
                }

                if (j-nums[i+1]>=0) {
                    dp[i+1][j-nums[i+1]] += dp[i][j];
                }
            }
        }
    }
}