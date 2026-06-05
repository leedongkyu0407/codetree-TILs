import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] nums, dp;
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        nums = new int[2*n+1][3];
        for(int i=1;i<=2*n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=2;j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[2*n+1][n+1];
        for(int i=0;i<=2*n;i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        solve();
    }

    private static void solve() {
        for(int i=1;i<=2*n;i++) {
            for(int j=0;j<=n;j++) {
                // 1. 빨간색 더 뽑을 수 있을 때
                if (j>0 && dp[i-1][j-1]>=0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+nums[i][1]);
                }
                
                // 2. 파란색 뽑을 때
                if (dp[i-1][j]>=0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+nums[i][2]);
                } 
            }
        }

        System.out.println(dp[2*n][n]);
    }
}