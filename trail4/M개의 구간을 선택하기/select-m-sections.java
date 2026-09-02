import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] nums;
    private static int[][][] dp;
    private static final int MIN = Integer.MIN_VALUE/2;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][m+1][2];

        for(int[][] row : dp) {
            for(int[] cell : row) {
                Arrays.fill(cell, MIN);
            }
        }

        dp[0][0][0] = 0;
        solve();
    }

    private static void solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                // i번째 선택 X
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]);

                // i번째 선택, 이전 구간과 이어짐
                dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j][1]+nums[i]);

                // 이전 구간과 별개
                if(j>=1) {
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j-1][0]+nums[i]);
                }
            }
        }

        int ans = Math.max(dp[n][m][0], dp[n][m][1]);

        System.out.println(ans);
    }
}