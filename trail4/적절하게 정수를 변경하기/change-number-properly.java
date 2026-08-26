import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] nums;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][m+1][5];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m+1;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i=1;i<=4;i++) {
            if (i == nums[0]) dp[0][0][i] = 1;
            else dp[0][0][i] = 0;
        }

        solve();
    }

    private static void solve() {
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<=m;j++) {
                for(int now=1;now<5;now++) {
                    if(dp[i][j][now]==-1) continue;

                    for(int next=1;next<5;next++) {
                        if(now==next) {
                            if(nums[i+1]==next) {
                                dp[i+1][j][next] = Math.max(dp[i+1][j][next], dp[i][j][now]+1);
                            } else {
                                dp[i+1][j][next] = Math.max(dp[i+1][j][next], dp[i][j][now]);
                            }
                        } else {
                            if(j==m) continue;
                            if(nums[i+1]==next) {
                                dp[i+1][j+1][next] = Math.max(dp[i+1][j+1][next], dp[i][j][now]+1);
                            } else {
                                dp[i+1][j+1][next] = Math.max(dp[i+1][j+1][next], dp[i][j][now]);
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0;i<m+1;i++) {
            for(int j=1;j<=4;j++) {
                ans = Math.max(dp[n-1][i][j], ans);
            }
        }
        System.out.println(ans);
    }
}