import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[] nums;
    private static int[][] dp;
    private static final int MINMIN = -10001;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        nums[0] = MINMIN;

        dp = new int[n+1][k+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i], MINMIN);
            if (nums[i]>=0) {
                dp[i][0] = nums[i];
            } else {
                dp[i][1] = nums[i];
            }
        }
        solve();
    }

    private static void solve() {
        for(int i=1;i<=n;i++) {
            for(int j=k;j>=0;j--) {
                 
                if(j>0 && nums[i] < 0 && dp[i-1][j-1]!=MINMIN) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+nums[i]);
                } else if (nums[i] >= 0 && dp[i-1][j]!=MINMIN) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+nums[i]);   
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=k;j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}