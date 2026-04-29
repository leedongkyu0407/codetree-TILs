import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] nums;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        nums = new int[n];
        dp = new int[n][3];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], 1);
        }
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());
    }

    private static int solve() {
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if (nums[i] == nums[j]) continue;
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[j][0]+1, dp[i][0]);
                } else if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[j][1]+1, dp[i][1]);

                    dp[i][2] = Math.max(dp[j][0]+1, dp[i][2]);                                        
                    dp[i][2] = Math.max(dp[j][2]+1, dp[i][2]);                    
                }
            }
        }

        int answer = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<3;j++) {
                answer = Math.max(dp[i][j], answer);
            }
        }

        return answer;
    }

}